/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Domain.Game;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author slett
 */
public class GetTeamsMatchHistoryService extends Service{
    private final Long team1Id;
    private final Long team2Id;
    
    public GetTeamsMatchHistoryService(Long team1Id, Long team2Id)
    {
        if (team1Id == null || team2Id == null)
            throw new ServiceException("Team Id is null");
        else
        {
            this.team1Id = team1Id;
            this.team2Id = team2Id;
        }
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Game> execute(){
        if(getBrokerFactory().getTeamBroker().findTeamById(team1Id) == null || getBrokerFactory().getTeamBroker().findTeamById(team2Id) == null){
            throw new ServiceException("id not found.");
        }
        List<Game> listOfGames = getBrokerFactory().getTeamBroker().getAllGamesForTwoTeams(team1Id, team2Id);
        
        /**  
         *    Skriver ut en lista (system.out) för alla matcher 
         */
        String outString;
        System.out.println(listOfGames.get(0).getId());
        for (int x = 0; x < listOfGames.size(); x++)
        {
            outString = "Game " + x + " - " + ", Round: " + listOfGames.get(x).getRound().getId();
            
            // Lägger till säsong namn eller id
            try {
                 outString += ", Season: " + listOfGames.get(x).getRound().getSeason().getName();
            } catch(Exception ex) {
                outString += ", Season ID: " + listOfGames.get(x).getRound().getSeason().getId();
                Logger.getLogger(AddResultToGameService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Lägger till league, league id eller inget
            try {
                outString += ", League: " + listOfGames.get(x).getRound().getSeason().getLeague().getName();
            } catch(Exception ex) {
                try {
                    outString += ", League ID: " + listOfGames.get(x).getRound().getSeason().getLeague().getId();
                } catch(Exception e) {
                    Logger.getLogger(AddResultToGameService.class.getName()).log(Level.SEVERE, null, e);
                }
                Logger.getLogger(AddResultToGameService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Lägger till hemma och borta lag (om data finns)
            try{
                outString += ", Home team: " + listOfGames.get(x).getResult().getHomeScore() + " " + listOfGames.get(x).getHomeTeam().getName() + ", Away team: " +  listOfGames.get(x).getAwayTeam().getName() + " " + listOfGames.get(x).getResult().getHomeScore();
            } catch(Exception ex) {
                Logger.getLogger(AddResultToGameService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Lägger till arena (om data finns)
            try{
                outString += ", Arena: " + listOfGames.get(x).getArena().getArenaName();
            } catch(Exception ex) {
                Logger.getLogger(AddResultToGameService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Lägger till datum (om data finns)
            try{
                outString += ", Date: " + listOfGames.get(x).getDate().toString();
            } catch(Exception ex) {
                Logger.getLogger(AddResultToGameService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Lägger till åskådare (om data finns)
            try{
                outString += ", Spectators: " + (listOfGames.get(x).getSpectators().toString());
            } catch(Exception ex) {
                Logger.getLogger(AddResultToGameService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println(outString);
            outString += "/n";
        }
            
            
        return listOfGames;
    }
    
}
