/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssistantClasses;

import Broker.BrokerFactory;
import Broker.TeamBroker;
import DAO.GameDao;
import Domain.Game;
import Domain.Team;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Veiret
 */
public class GetTeamsFromListOfGamesTest {
    private static Game game1;
    private static Game game2;
    private static GameDao gameDao1;
    private static GameDao gameDao2;
    private static BrokerFactory brokerFactory;
    private static TeamBroker teamBroker;
    private static Team team1;
    private static Team team2;
    private static long teamId1;
    private static long teamId2;
    private static List <Game> gameList;
    private static List <Team> teamList;
    
    @BeforeClass
    public static void setUpClass() {
        game1 = mock(Game.class);
        game2 = mock(Game.class);
        gameDao1 = mock(GameDao.class);
        gameDao2 = mock(GameDao.class);
        brokerFactory = mock(BrokerFactory.class);
        teamBroker = mock(TeamBroker.class);
        team1 = mock(Team.class);
        team2 = mock(Team.class);
        teamId1 = 1L;
        teamId2 = 2L;
        
        gameList = new ArrayList<Game>();
        gameList.add(game1);
        gameList.add(game2);
        
        teamList = new ArrayList<Team>();
        teamList.add(team1);
        teamList.add(team2);
        
        
        
        when(brokerFactory.getTeamBroker()).thenReturn(teamBroker);
        when(teamBroker.findTeamById(teamId1)).thenReturn(team1);
        when(teamBroker.findTeamById(teamId2)).thenReturn(team2);
        when(game1.getDao()).thenReturn(gameDao1);
        when(game2.getDao()).thenReturn(gameDao2);
        when(gameDao1.get("away_team_id")).thenReturn(teamId1);
        when(gameDao1.get("home_team_id")).thenReturn(teamId2);
        when(gameDao2.get("away_team_id")).thenReturn(teamId2);
        when(gameDao2.get("home_team_id")).thenReturn(teamId1);
      
    }

    /**
     * Test of getTeams method, of class GetTeamsFromListOfGames.
     */
    @Test
    public void testGetTeams() {
        System.out.println("Testa execute");
        GetTeamsFromListOfGames instance = new GetTeamsFromListOfGames(gameList);
        instance.init(brokerFactory);
        assertEquals(2, instance.execute().size());
    }

}
