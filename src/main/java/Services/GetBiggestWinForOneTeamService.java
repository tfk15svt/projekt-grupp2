/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Domain.Game;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ntn13aae
 */
public class GetBiggestWinForOneTeamService extends Service{
    
    private Long teamId;
    private Integer startDate;
    private Integer endDate;
    
    public GetBiggestWinForOneTeamService (Long teamId, Integer startDate, Integer endDate) {
    
        this.teamId = teamId;
        if (this.teamId == null) {
            throw new ServiceException("League id is null");
        }
        this.startDate = startDate;
        if (this.startDate == null) {
            throw new ServiceException("StartDate id is null");
        }
        this.endDate = endDate;
        if (this.endDate == null) {
            throw new ServiceException("EndDate id is null");
        }
    }
    
    @Override
    public Game execute() {
        Game tempGame = getBrokerFactory().getGameBroker().create();
        if(getBrokerFactory().getLeagueBroker().getGamesWithinDateInterVal((long) teamId,(int) startDate,(int) endDate).size() < 1) {
            System.out.println("No games within that interval! Returning an empty game. ");
            return tempGame;
        }
        else{
            List<Game> listOfGames = getBrokerFactory().getLeagueBroker().getGamesWithinDateInterVal((long) teamId,(int) startDate,(int) endDate);
            List<Game> listOfAwayGames = new ArrayList(); 
            List<Game> listOfHomeGames = new ArrayList();
            int tempInt = 0;

            for(int x = 0; x < listOfGames.size(); x++) {

                if(Objects.equals(listOfGames.get(x).getAwayTeam().getId(), teamId)) {

                    listOfAwayGames.add(listOfGames.get(x));
                }
                if(Objects.equals(listOfGames.get(x).getHomeTeam().getId(), teamId)) {

                    listOfHomeGames.add(listOfGames.get(x));
                }
            }

            for(int x = 0; x < listOfAwayGames.size(); x++) {


                if((listOfAwayGames.get(x).getResult().getAwayScore() - listOfAwayGames.get(x).getResult().getHomeScore()) > tempInt) {


                    tempInt = (listOfAwayGames.get(x).getResult().getAwayScore() - listOfAwayGames.get(x).getResult().getHomeScore());
                    tempGame = listOfAwayGames.get(x);
                }
            }

            for(int x = 0; x < listOfHomeGames.size(); x++) {

                if((listOfHomeGames.get(x).getResult().getHomeScore() - listOfHomeGames.get(x).getResult().getAwayScore()) > tempInt) {
                    tempInt = listOfHomeGames.get(x).getResult().getHomeScore() - listOfHomeGames.get(x).getResult().getAwayScore();
                    tempGame = listOfHomeGames.get(x);
                }
            }
            System.out.println("Biggest win at game id: " + tempGame.getId() + " with a margin of " + tempInt + " points.");
            return tempGame;
        }
    }
}
