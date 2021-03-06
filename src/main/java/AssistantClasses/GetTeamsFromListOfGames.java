/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssistantClasses;

import Broker.BrokerFactory;
import Domain.Game;
import Domain.Team;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import Broker.TeamBroker;
import Services.Service;

/**
 *
 * @author Veiret
 */
public class GetTeamsFromListOfGames extends Service {
    private final List<Game> gameList;
    public GetTeamsFromListOfGames (List<Game> gameList) {
        this.gameList = gameList;
    }
    public List<Team> execute() {
        return Stream.concat(
                gameList.stream().map(game -> ((Game) game).getHomeTeam()), 
                gameList.stream().map(game -> ((Game) game).getAwayTeam()))
                .map(team -> (long) team.getId())
                .distinct()
                .map(id -> getBrokerFactory().getTeamBroker().findTeamById(id))
                .collect(Collectors.toList());
    }


}
