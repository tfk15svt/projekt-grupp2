package Services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Broker.BrokerFactory;
import DB.DbConn;
import Domain.Arena;
import Domain.Game;
import Domain.League;
import Domain.Result;
import Domain.Round;
import Domain.Season;
import Domain.Sport;
import Domain.Team;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Slett
 */
public class GetAllLossesForTeamServiceIT {
    public static DbConn conn;
    public static Sport sport;
    public static Game game;
    public static Game game2;
    public static Arena arena;
    public static Team team;
    public static Team team2;
    public static Round round;
    public static Season season;
    public static Result result;
    public static Result result2;
    public static League league;
    
    public static Long gameId;
    public static Long game2Id;
    public static Long arenaId;
    public static Long teamId;
    public static Long team2Id;
    
    public GetAllLossesForTeamServiceIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        conn = new DbConn();
        conn.open();
        sport = new Sport();
        season = new Season();
        game = new Game();
        game2 = new Game();
        arena = new Arena();
        team = new Team();
        team2 = new Team();
        round = new Round();
        result = new Result();
        result2 = new Result();
        league = new League();
        
        sport.setName("SportTest2222222");
        sport.getDao().save();
            
            
        league.setSport(sport);
        league.setName("LeagueTest2222222");
        league.getDao().save();

        season.setSummer(Boolean.TRUE);
        season.setYear(1);
        league.addSeason(season);
        season.getDao().save();
            
        team.setName("TeamTest99999");
        team.setSport(sport);
        team.getDao().save();
        teamId = team.getDao().getLongId();
        
        team2.setName("Teamtest 88888");
        team2.setSport(sport);
        team2.getDao().save();
        team2Id = team2.getDao().getLongId();

        arena.getDao().save();
        arenaId = arena.getDao().getLongId();
            
        round.setRoundNumber(22);
        round.setSeason(season);
        round.getDao().save();
            
        result.setAwayScore(5);
        result.setHomeScore(1);
        result2.setAwayScore(1);
        result2.setHomeScore(5);
        

               
        game.setArena(arena);
        game.setAwayTeam(team);
        game.setHomeTeam(team2);
        game.setRound(round);
        game.getDao().save();
        game.setResult(result); 
        gameId = game.getDao().getLongId();
        
          
        game2.setArena(arena);
        game2.setAwayTeam(team);
        game2.setHomeTeam(team2);
        game2.setRound(round);
        game2.getDao().save();
        game2.setResult(result2); 
        game2Id = game2.getDao().getLongId();
        
        result.getDao().save();
        result2.getDao().save();
    }
    
    @After
    public void tearDown() {
        
        result.getDao().delete();
        result2.getDao().delete();
        game.getDao().delete();
        game2.getDao().delete();
        round.getDao().delete();
        arena.getDao().delete();
        team.getDao().delete();
        team2.getDao().delete();
        season.getDao().delete();
        league.getDao().delete();
        sport.getDao().delete();
        
        conn.close();
    }

    @Test
    public void testSomeMethod() {
        List<Game> listOfGames;
        GetAllLossesForTeamService instance = new GetAllLossesForTeamService(teamId);
        instance.init(new BrokerFactory());
        listOfGames = instance.execute();
        System.out.println("LIST OF GAMES: " + listOfGames);
        
    }
    
}
