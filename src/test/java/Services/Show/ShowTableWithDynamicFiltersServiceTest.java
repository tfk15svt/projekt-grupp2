/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Show;

import Services.Show.ShowTableWithDynamicFiltersService;
import AssistantClasses.FakeTableRowForJsonTests;
import AssistantClasses.JsonOutputformat;
import Broker.BrokerFactory;
import Broker.LeagueBroker;
import Broker.SeasonBroker;
import Broker.ServiceBroker;
import Broker.TeamBroker;
import DAO.TeamDao;
import Domain.Game;
import Domain.Result;
import Domain.Round;
import Domain.Season;
import Domain.Team;
import Services.Get.GetAllGamesFromSeasonService;
import Services.ServiceException;
import Services.ServiceException;
import Services.ServiceRunner;
import Services.ServiceRunner;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Veiret
 */
public class ShowTableWithDynamicFiltersServiceTest {

    private static List<Long> seasonIds;
    private static Long leagueId;
    private static BrokerFactory brokerFactory;

    private static String teamName1;
    private static int fullTimeWins1;
    private static int losses1;
    private static int tied1;
    private static int overTimeWins1;
    private static int overTimeLosses1;
    private static int scoredGoals1;
    private static int opponentScore1;
    private static int points1;

    private static String teamName2;
    private static int fullTimeWins2;
    private static int tied2;
    private static int overTimeWins2;
    private static int overTimeLosses2;
    private static int losses2;
    private static int scoredGoals2;
    private static int opponentScore2;
    private static int points2;

    private static Team team1;
    private static Team team2;
    private static TeamDao teamDao1;
    private static TeamDao teamDao2;
    private static final long team1Id = 1L;
    private static final long team2Id = 2L;
    private static Game game1;
    private static Game game2;
    private static Game game3;
    private static Game game4;
    private static SeasonBroker seasonBroker;
    private static LeagueBroker leagueBroker;
    private static Result result1;
    private static Result result2;
    private static Season season1;
    private static Season season2;
    private static Round round1;
    private static Round round2;

    private static ServiceRunner serviceRunner;
    private static ServiceBroker serviceBroker;
    private static TeamBroker teamBroker;
    private static GetAllGamesFromSeasonService getAllGamesFromSeason1Service;
    private static GetAllGamesFromSeasonService getAllGamesFromSeason2Service;
    private static List<Game> allSeason1Games;
    private static List<Team> allSeason1Teams;
    private static List<Game> allSeason2Games;
    private static List<Team> allSeason2Teams;
    private static List<Season> seasonList;
    private static List<Long> seasonOneList;
    private static List<Long> seasonTwoList;
    private static boolean[] homeAwayConditions;
    private static int[] startEndDate;
    private static int[] startEndRound;
    private final static boolean chooseDate = true;
    private final static boolean chooseRound = false;
    private final static long season1Id = 1L;
    private final static long season2Id = 2L;

    private static FakeTableRowForJsonTests t1Row1;
    private static FakeTableRowForJsonTests t1Row2;
    private static List<FakeTableRowForJsonTests> tabel1TwoSeasonsHomeAndAway;

    private static FakeTableRowForJsonTests t2Row1;
    private static FakeTableRowForJsonTests t2Row2;
    private static List<FakeTableRowForJsonTests> tabel2OneSeasonHomeAndAway;

    private static FakeTableRowForJsonTests t3Row1;
    private static FakeTableRowForJsonTests t3Row2;
    private static List<FakeTableRowForJsonTests> tabel3TwoSeasonsHome;

    private static FakeTableRowForJsonTests t4Row1;
    private static FakeTableRowForJsonTests t4Row2;
    private static List<FakeTableRowForJsonTests> tabel4TwoSeasonsAway;

    private ShowTableWithDynamicFiltersService instance1_1_twoSeasons, instance1_2_oneSeason;
    private ShowTableWithDynamicFiltersService instance2;
    private ShowTableWithDynamicFiltersService instance3;
    private ShowTableWithDynamicFiltersService instance4;
    private ShowTableWithDynamicFiltersService instance5;
    private ShowTableWithDynamicFiltersService instance6;
    private ShowTableWithDynamicFiltersService instance7;
    private ShowTableWithDynamicFiltersService instance8;
    private ShowTableWithDynamicFiltersService instance9;
    private ShowTableWithDynamicFiltersService instance10;
    private ShowTableWithDynamicFiltersService instance11;
    private ShowTableWithDynamicFiltersService instance12;

    @BeforeClass
    public static void setUpClass() {
        teamName1 = "Lag1";
        teamName2 = "Lag2";
        seasonOneList = new ArrayList<>();
        seasonOneList.add(season1Id);
        seasonTwoList = new ArrayList<>();
        seasonTwoList.add(team2Id);
        leagueId = 1L;
        seasonIds = new ArrayList<>();
        seasonIds.add(season1Id);
        seasonIds.add(season2Id);
        brokerFactory = mock(BrokerFactory.class);
        getAllGamesFromSeason1Service = mock(GetAllGamesFromSeasonService.class);
        getAllGamesFromSeason2Service = mock(GetAllGamesFromSeasonService.class);
        team1 = mock(Team.class);
        team2 = mock(Team.class);
        teamDao1 = mock(TeamDao.class);
        teamDao2 = mock(TeamDao.class);
        game1 = mock(Game.class);
        game2 = mock(Game.class);
        game3 = mock(Game.class);
        game4 = mock(Game.class);
        seasonBroker = mock(SeasonBroker.class);
        leagueBroker = mock(LeagueBroker.class);
        teamBroker = mock(TeamBroker.class);
        result1 = mock(Result.class);
        result2 = mock(Result.class);
        serviceRunner = mock(ServiceRunner.class);
        serviceBroker = mock(ServiceBroker.class);
        homeAwayConditions = new boolean[2];
        startEndDate = new int[2];
        startEndRound = new int[2];
        season1 = mock(Season.class);
        season2 = mock(Season.class);
        round1 = mock(Round.class);
        round2 = mock(Round.class);

        allSeason1Games = new ArrayList<Game>();
        allSeason1Games.add(game1);
        allSeason1Games.add(game2);
        allSeason2Games = new ArrayList<Game>();
        allSeason2Games.add(game3);
        allSeason2Games.add(game4);
        allSeason1Teams = new ArrayList<Team>();
        allSeason1Teams.add(team1);
        allSeason1Teams.add(team2);
        allSeason2Teams = new ArrayList<Team>();
        allSeason2Teams.add(team1);
        allSeason2Teams.add(team2);

        seasonList = new ArrayList<Season>();
        seasonList.add(season1);
        seasonList.add(season2);

        when(brokerFactory.getServiceBroker()).thenReturn(serviceBroker);
        when(brokerFactory.getSeasonBroker()).thenReturn(seasonBroker);
        when(brokerFactory.getLeagueBroker()).thenReturn(leagueBroker);
        when(brokerFactory.getTeamBroker()).thenReturn(teamBroker);
        when(serviceBroker.getAllGamesFromSeasonService(season1Id)).thenReturn(getAllGamesFromSeason1Service);
        when(serviceBroker.getAllGamesFromSeasonService(season2Id)).thenReturn(getAllGamesFromSeason2Service);
        when(getAllGamesFromSeason1Service.execute()).thenReturn(allSeason1Games);
        when(getAllGamesFromSeason2Service.execute()).thenReturn(allSeason2Games);
        when(seasonBroker.getAllTeamsFromSeasonId(season1Id)).thenReturn(allSeason1Teams);
        when(seasonBroker.getAllTeamsFromSeasonId(season2Id)).thenReturn(allSeason2Teams);
        when(seasonBroker.seasonExists(season1Id)).thenReturn(true);
        when(seasonBroker.seasonExists(season2Id)).thenReturn(true);
        when(seasonBroker.seasonExists(3L)).thenReturn(false);
        when(leagueBroker.leagueExists(leagueId)).thenReturn(true);
        when(leagueBroker.leagueExists(2L)).thenReturn(false);
        when(leagueBroker.getAllSeasonsFromLeagueId(leagueId)).thenReturn(seasonList);
        when(team1.getDao()).thenReturn(teamDao1);
        when(team2.getDao()).thenReturn(teamDao2);
        when(team1.getName()).thenReturn(teamName1);
        when(team2.getName()).thenReturn(teamName2);
        when(teamDao1.getLongId()).thenReturn(team1Id);
        when(teamDao2.getLongId()).thenReturn(team2Id);
        when(team1.getId()).thenReturn(team1Id);
        when(team2.getId()).thenReturn(team2Id);
        when(game1.getResult()).thenReturn(result1);
        when(game2.getResult()).thenReturn(result2);
        when(game3.getResult()).thenReturn(result1);
        when(game4.getResult()).thenReturn(result2);
        when(game1.getDate()).thenReturn(1);
        when(game2.getDate()).thenReturn(2);
        when(game3.getDate()).thenReturn(3);
        when(game4.getDate()).thenReturn(4);
        when(result1.getAwayScore()).thenReturn(0);
        when(result1.getHomeScore()).thenReturn(5);
        when(result2.getAwayScore()).thenReturn(2);
        when(result2.getHomeScore()).thenReturn(1);
        when(result1.getFullTime()).thenReturn(true);
        when(result2.getFullTime()).thenReturn(false);
        when(result1.getOverTime()).thenReturn(false);
        when(result2.getOverTime()).thenReturn(true);
        when(result1.getShotOut()).thenReturn(false);
        when(result2.getShotOut()).thenReturn(false);
        when(game1.getHomeTeam()).thenReturn(team1);
        when(game1.getAwayTeam()).thenReturn(team2);
        when(game2.getHomeTeam()).thenReturn(team2);
        when(game2.getAwayTeam()).thenReturn(team1);
        when(game3.getHomeTeam()).thenReturn(team1);
        when(game3.getAwayTeam()).thenReturn(team2);
        when(game4.getHomeTeam()).thenReturn(team2);
        when(game4.getAwayTeam()).thenReturn(team1);
        when(game1.getRound()).thenReturn(round1);
        when(game2.getRound()).thenReturn(round2);
        when(game3.getRound()).thenReturn(round2);
        when(game4.getRound()).thenReturn(round1);
        when(round1.getRoundNumber()).thenReturn(1);
        when(round2.getRoundNumber()).thenReturn(2);
        when(season1.getId()).thenReturn(season1Id);
        when(season2.getId()).thenReturn(season2Id);
        when(teamBroker.findTeamById(team1Id)).thenReturn(team1);
        when(teamBroker.findTeamById(team2Id)).thenReturn(team2);
        //Tabel 1, Två säsonger borta och hemma

        fullTimeWins1 = 2;
        losses1 = 0;
        tied1 = 2;
        overTimeWins1 = 2;
        overTimeLosses1 = 0;
        scoredGoals1 = 14;
        opponentScore1 = 2;
        points1 = 10;
        fullTimeWins2 = 0;
        tied2 = 2;
        overTimeWins2 = 0;
        overTimeLosses2 = 2;
        losses2 = 2;
        scoredGoals2 = 2;
        opponentScore2 = 14;
        points2 = 2;
        t1Row1 = new FakeTableRowForJsonTests();
        t1Row2 = new FakeTableRowForJsonTests();

        t1Row1.setFullTimeWins(fullTimeWins1);
        t1Row1.setGamesPlayed(fullTimeWins1 + losses1 + tied1);
        t1Row1.setLosses(losses1);
        t1Row1.setOpponentScore(opponentScore1);
        t1Row1.setPoints(points1);
        t1Row1.setScoredGoals(scoredGoals1);
        t1Row1.setTeamname(teamName1);
        t1Row1.setTied(tied1);
        t1Row2.setFullTimeWins(fullTimeWins2);
        t1Row2.setGamesPlayed(fullTimeWins2 + losses2 + tied2);
        t1Row2.setLosses(losses2);
        t1Row2.setOpponentScore(opponentScore2);
        t1Row2.setPoints(points2);
        t1Row2.setScoredGoals(scoredGoals2);
        t1Row2.setTeamname(teamName2);
        t1Row2.setTied(tied2);

        tabel1TwoSeasonsHomeAndAway = new ArrayList<>();
        tabel1TwoSeasonsHomeAndAway.add(t1Row1);
        tabel1TwoSeasonsHomeAndAway.add(t1Row2);

        //Tabel 2 en säsong hemma och borta
        teamName1 = "Lag1";
        teamName2 = "Lag2";
        fullTimeWins1 = 1;
        losses1 = 0;
        tied1 = 1;
        overTimeWins1 = 1;
        overTimeLosses1 = 0;
        scoredGoals1 = 7;
        opponentScore1 = 1;
        points1 = 5;
        fullTimeWins2 = 0;
        tied2 = 1;
        overTimeWins2 = 0;
        overTimeLosses2 = 1;
        losses2 = 1;
        scoredGoals2 = 1;
        opponentScore2 = 7;
        points2 = 1;
        t2Row1 = new FakeTableRowForJsonTests();
        t2Row2 = new FakeTableRowForJsonTests();

        t2Row1.setFullTimeWins(fullTimeWins1);
        t2Row1.setGamesPlayed(fullTimeWins1 + losses1 + tied1);
        t2Row1.setLosses(losses1);
        t2Row1.setOpponentScore(opponentScore1);
        t2Row1.setPoints(points1);
        t2Row1.setScoredGoals(scoredGoals1);
        t2Row1.setTeamname(teamName1);
        t2Row1.setTied(tied1);
        t2Row2.setFullTimeWins(fullTimeWins2);
        t2Row2.setGamesPlayed(fullTimeWins2 + losses2 + tied2);
        t2Row2.setLosses(losses2);
        t2Row2.setOpponentScore(opponentScore2);
        t2Row2.setPoints(points2);
        t2Row2.setScoredGoals(scoredGoals2);
        t2Row2.setTeamname(teamName2);
        t2Row2.setTied(tied2);

        tabel2OneSeasonHomeAndAway = new ArrayList<>();
        tabel2OneSeasonHomeAndAway.add(t2Row1);
        tabel2OneSeasonHomeAndAway.add(t2Row2);

        //Tabel 3, Två säsonger hemmamatcher
        teamName1 = "Lag1";
        teamName2 = "Lag2";
        fullTimeWins1 = 2;
        losses1 = 0;
        tied1 = 0;
        overTimeWins1 = 0;
        overTimeLosses1 = 0;
        scoredGoals1 = 10;
        opponentScore1 = 0;
        points1 = 6;
        fullTimeWins2 = 0;
        tied2 = 2;
        overTimeWins2 = 0;
        overTimeLosses2 = 2;
        losses2 = 0;
        scoredGoals2 = 2;
        opponentScore2 = 4;
        points2 = 2;
        t3Row1 = new FakeTableRowForJsonTests();
        t3Row2 = new FakeTableRowForJsonTests();

        t3Row1.setFullTimeWins(fullTimeWins1);
        t3Row1.setGamesPlayed(fullTimeWins1 + losses1 + tied1);
        t3Row1.setLosses(losses1);
        t3Row1.setOpponentScore(opponentScore1);
        t3Row1.setPoints(points1);
        t3Row1.setScoredGoals(scoredGoals1);
        t3Row1.setTeamname(teamName1);
        t3Row1.setTied(tied1);
        t3Row2.setFullTimeWins(fullTimeWins2);
        t3Row2.setGamesPlayed(fullTimeWins2 + losses2 + tied2);
        t3Row2.setLosses(losses2);
        t3Row2.setOpponentScore(opponentScore2);
        t3Row2.setPoints(points2);
        t3Row2.setScoredGoals(scoredGoals2);
        t3Row2.setTeamname(teamName2);
        t3Row2.setTied(tied2);

        tabel3TwoSeasonsHome = new ArrayList<>();
        tabel3TwoSeasonsHome.add(t3Row1);
        tabel3TwoSeasonsHome.add(t3Row2);

        //Tabel 4, Två säsonger bortamatcher
        teamName1 = "Lag1";
        teamName2 = "Lag2";
        fullTimeWins1 = 0;
        losses1 = 0;
        tied1 = 2;
        overTimeWins1 = 2;
        overTimeLosses1 = 0;
        scoredGoals1 = 4;
        opponentScore1 = 2;
        points1 = 4;
        fullTimeWins2 = 0;
        tied2 = 0;
        overTimeWins2 = 0;
        overTimeLosses2 = 0;
        losses2 = 2;
        scoredGoals2 = 0;
        opponentScore2 = 10;
        points2 = 0;
        t4Row1 = new FakeTableRowForJsonTests();
        t4Row2 = new FakeTableRowForJsonTests();

        t4Row1.setFullTimeWins(fullTimeWins1);
        t4Row1.setGamesPlayed(fullTimeWins1 + losses1 + tied1);
        t4Row1.setLosses(losses1);
        t4Row1.setOpponentScore(opponentScore1);
        t4Row1.setPoints(points1);
        t4Row1.setScoredGoals(scoredGoals1);
        t4Row1.setTeamname(teamName1);
        t4Row1.setTied(tied1);
        t4Row2.setFullTimeWins(fullTimeWins2);
        t4Row2.setGamesPlayed(fullTimeWins2 + losses2 + tied2);
        t4Row2.setLosses(losses2);
        t4Row2.setOpponentScore(opponentScore2);
        t4Row2.setPoints(points2);
        t4Row2.setScoredGoals(scoredGoals2);
        t4Row2.setTeamname(teamName2);
        t4Row2.setTied(tied2);

        tabel4TwoSeasonsAway = new ArrayList<>();
        tabel4TwoSeasonsAway.add(t4Row1);
        tabel4TwoSeasonsAway.add(t4Row2);
    }

    @Test
    public void testConstructor1() {
        try {
            new ShowTableWithDynamicFiltersService((List<Long>) null);
            fail();
        } catch (ServiceException e) {

        }
        instance1_1_twoSeasons = new ShowTableWithDynamicFiltersService(seasonIds);
        instance1_2_oneSeason = new ShowTableWithDynamicFiltersService(1L);
    }

    @Test
    public void testConstructor2() {
        try {
            new ShowTableWithDynamicFiltersService((Long) null);
            fail();
        } catch (ServiceException e) {

        }
        instance2 = new ShowTableWithDynamicFiltersService(leagueId);
    }

    @Test
    public void testConstructor3() {
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = false;
        try {
            new ShowTableWithDynamicFiltersService((List<Long>) null, homeAwayConditions);
            fail();
        } catch (ServiceException e) {

        }
        homeAwayConditions[0] = false;
        homeAwayConditions[1] = false;
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, homeAwayConditions);
            fail();
        } catch (ServiceException e) {

        }
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, null);
            fail();
        } catch (ServiceException e) {

        }
        homeAwayConditions[0] = false;
        homeAwayConditions[1] = true;
        new ShowTableWithDynamicFiltersService(seasonIds, homeAwayConditions);
    }

    @Test
    public void testConstructor4() {
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = false;
        try {
            new ShowTableWithDynamicFiltersService((Long) null, homeAwayConditions);
            fail();
        } catch (ServiceException e) {

        }
        homeAwayConditions[0] = false;
        homeAwayConditions[1] = false;
        try {
            new ShowTableWithDynamicFiltersService(leagueId, homeAwayConditions);
            fail();
        } catch (ServiceException e) {

        }
        try {
            new ShowTableWithDynamicFiltersService(leagueId, null);
            fail();
        } catch (ServiceException e) {

        }
        homeAwayConditions[0] = false;
        homeAwayConditions[1] = true;
        new ShowTableWithDynamicFiltersService(leagueId, homeAwayConditions);
    }

    @Test
    public void testConstructor5() {
        startEndDate[0] = 20180920;
        startEndDate[1] = 20181020;
        startEndRound[0] = 1;
        startEndRound[1] = 10;
        try {
            new ShowTableWithDynamicFiltersService((List<Long>) null, startEndDate, true);
            fail();
        } catch (ServiceException e) {

        }
        try {
            new ShowTableWithDynamicFiltersService((List<Long>) null, startEndDate, false);
            fail();
        } catch (ServiceException e) {

        }

        startEndDate[1] = 20180920;
        startEndDate[0] = 20181020;
        startEndRound[1] = 1;
        startEndRound[0] = 10;

        try {
            new ShowTableWithDynamicFiltersService(seasonIds, null, true);
            fail();
        } catch (ServiceException e) {

        }
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, null, false);
            fail();
        } catch (ServiceException e) {

        }
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, true);
            fail();
        } catch (ServiceException e) {

        }
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, startEndRound, false);
            fail();
        } catch (ServiceException e) {

        }
        startEndDate[0] = 20180920;
        startEndDate[1] = 20181020;
        startEndRound[0] = 1;
        startEndRound[1] = 10;
        new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, true);
        new ShowTableWithDynamicFiltersService(seasonIds, startEndRound, false);
    }

    @Test
    public void testConstructor6() {
        startEndDate[0] = 20180920;
        startEndDate[1] = 20181020;
        startEndRound[0] = 1;
        startEndRound[1] = 10;
        try {
            new ShowTableWithDynamicFiltersService((List<Long>) null, startEndDate, startEndRound);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, null, startEndRound);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, null);
            fail();
        } catch (ServiceException e) {
        }

        startEndDate[1] = 20180920;
        startEndDate[0] = 20181020;
        startEndRound[0] = 1;
        startEndRound[1] = 10;
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, startEndRound);
            fail();
        } catch (ServiceException e) {
        }
        startEndDate[0] = 20180920;
        startEndDate[1] = 20181020;
        startEndRound[1] = 1;
        startEndRound[0] = 10;
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, startEndRound);
            fail();
        } catch (ServiceException e) {
        }
        startEndDate[0] = 20180920;
        startEndDate[1] = 20181020;
        startEndRound[0] = 1;
        startEndRound[1] = 10;
        new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, startEndRound);
    }

    @Test
    public void testConstructor7() {
        //new ShowTableWithDynamicFiltersService(enLongLeagueId, ett_Filter_Int_Array_Datum_Round, enBooleanValjFilter);

        startEndDate[0] = 20180920;
        startEndDate[1] = 20181020;
        startEndRound[0] = 1;
        startEndRound[1] = 10;

        try {
            new ShowTableWithDynamicFiltersService((Long) null, startEndDate, chooseDate);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new ShowTableWithDynamicFiltersService(leagueId, null, chooseDate);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new ShowTableWithDynamicFiltersService(leagueId, startEndDate, (Boolean) null);
            fail();
        } catch (ServiceException e) {
        }

        startEndDate[1] = 20180920;
        startEndDate[0] = 20181020;
        startEndRound[1] = 1;
        startEndRound[0] = 10;

        try {
            new ShowTableWithDynamicFiltersService(leagueId, startEndDate, chooseDate);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new ShowTableWithDynamicFiltersService(leagueId, startEndRound, chooseRound);
            fail();
        } catch (ServiceException e) {
        }

        startEndDate[0] = 20180920;
        startEndDate[1] = 20181020;
        startEndRound[0] = 1;
        startEndRound[1] = 10;
        new ShowTableWithDynamicFiltersService(leagueId, startEndDate, chooseDate);
        new ShowTableWithDynamicFiltersService(leagueId, startEndRound, chooseRound);
    }

    @Test
    public void testConstructor8() {
        startEndDate[0] = 20180920;
        startEndDate[1] = 20181020;
        startEndRound[0] = 1;
        startEndRound[1] = 10;
        //new ShowTableWithDynamicFiltersService(leagueIdEnLong, startEndDate, startEndRound)
        try {
            new ShowTableWithDynamicFiltersService((Long) null, startEndDate, startEndRound);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new ShowTableWithDynamicFiltersService(leagueId, null, startEndRound);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new ShowTableWithDynamicFiltersService(leagueId, startEndDate, (int[]) null);
            fail();
        } catch (ServiceException e) {
        }

        startEndDate[1] = 20180920;
        startEndDate[0] = 20181020;

        try {
            new ShowTableWithDynamicFiltersService(leagueId, startEndDate, startEndRound);
            fail();
        } catch (ServiceException e) {
        }

        startEndDate[1] = 20180920;
        startEndDate[0] = 20181020;
        try {
            new ShowTableWithDynamicFiltersService(leagueId, startEndDate, startEndRound);
            fail();
        } catch (ServiceException e) {
        }
        startEndDate[0] = 20180920;
        startEndDate[1] = 20181020;
        startEndRound[1] = 1;
        startEndRound[0] = 10;
        try {
            new ShowTableWithDynamicFiltersService(leagueId, startEndDate, startEndRound);
            fail();
        } catch (ServiceException e) {
        }

        startEndRound[0] = 1;
        startEndRound[1] = 10;
        new ShowTableWithDynamicFiltersService(leagueId, startEndDate, startEndRound);
    }

    @Test
    public void testConstructor9() {
        //new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, valjFilterBoolean, homeAwayConditions)
        startEndDate[0] = 20180920;
        startEndDate[1] = 20181020;
        startEndRound[0] = 1;
        startEndRound[1] = 10;
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = true;
        try {
            new ShowTableWithDynamicFiltersService((List<Long>) null, startEndDate, chooseDate, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, null, chooseDate, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, (Boolean) null, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, chooseDate, null);
            fail();
        } catch (ServiceException e) {
        }
        startEndDate[1] = 20180920;
        startEndDate[0] = 20181020;
        startEndRound[0] = 1;
        startEndRound[1] = 10;
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, chooseDate, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        startEndDate[0] = 20180920;
        startEndDate[1] = 20181020;
        startEndRound[1] = 1;
        startEndRound[0] = 10;
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, startEndRound, chooseRound, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        homeAwayConditions[0] = false;
        homeAwayConditions[1] = false;
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, startEndRound, chooseRound, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        homeAwayConditions[1] = true;
        startEndRound[0] = 1;
        startEndRound[1] = 10;
        new ShowTableWithDynamicFiltersService(seasonIds, startEndRound, chooseRound, homeAwayConditions);
    }

    @Test
    public void testConstructor10() {
        startEndDate[0] = 20180920;
        startEndDate[1] = 20181020;
        startEndRound[0] = 1;
        startEndRound[1] = 10;
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = true;

        //new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, startEndRound, homeAwayConditions)
        try {
            new ShowTableWithDynamicFiltersService((List<Long>) null, startEndDate, startEndRound, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, null, startEndRound, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, (int[]) null, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, startEndRound, null);
            fail();
        } catch (ServiceException e) {
        }
        startEndDate[1] = 20180920;
        startEndDate[0] = 20181020;
        startEndRound[0] = 1;
        startEndRound[1] = 10;
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, startEndRound, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        startEndDate[0] = 20180920;
        startEndDate[1] = 20181020;
        startEndRound[1] = 1;
        startEndRound[0] = 10;
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, startEndRound, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        homeAwayConditions[0] = false;
        homeAwayConditions[1] = false;
        try {
            new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, startEndRound, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        homeAwayConditions[1] = true;
        startEndRound[0] = 1;
        startEndRound[1] = 10;
        new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, startEndRound, homeAwayConditions);

    }

    @Test
    public void testConstructor11() {
        startEndDate[0] = 20180920;
        startEndDate[1] = 20181020;
        startEndRound[0] = 1;
        startEndRound[1] = 10;
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = true;

        //new ShowTableWithDynamicFiltersService(leagueId, startEndDate, chooseDate, homeAwayConditions)
        try {
            new ShowTableWithDynamicFiltersService((Long) null, startEndDate, chooseDate, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new ShowTableWithDynamicFiltersService(leagueId, null, chooseDate, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new ShowTableWithDynamicFiltersService(leagueId, startEndDate, (Boolean) null, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new ShowTableWithDynamicFiltersService(leagueId, startEndDate, chooseDate, null);
            fail();
        } catch (ServiceException e) {
        }
        startEndDate[1] = 20180920;
        startEndDate[0] = 20181020;
        startEndRound[1] = 1;
        startEndRound[0] = 10;
        try {
            new ShowTableWithDynamicFiltersService(leagueId, startEndDate, chooseDate, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        startEndDate[1] = 20180920;
        startEndDate[0] = 20181020;
        startEndRound[1] = 1;
        startEndRound[0] = 10;
        try {
            new ShowTableWithDynamicFiltersService(leagueId, startEndDate, chooseDate, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new ShowTableWithDynamicFiltersService(leagueId, startEndRound, chooseRound, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        homeAwayConditions[0] = false;
        homeAwayConditions[1] = false;
        startEndDate[0] = 20180920;
        startEndDate[1] = 20181020;
        startEndRound[0] = 1;
        startEndRound[1] = 10;
        try {
            new ShowTableWithDynamicFiltersService(leagueId, startEndRound, chooseRound, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = true;
        new ShowTableWithDynamicFiltersService(leagueId, startEndRound, chooseRound, homeAwayConditions);
    }

    @Test
    public void testConstructor12() {
        startEndDate[0] = 20180920;
        startEndDate[1] = 20181020;
        startEndRound[0] = 1;
        startEndRound[1] = 10;
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = true;
        // new ShowTableWithDynamicFiltersService(leagueId, startEndDate, startEndRound, homeAwayConditions);
        try {
            new ShowTableWithDynamicFiltersService((Long) null, startEndDate, startEndRound, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new ShowTableWithDynamicFiltersService(leagueId, null, startEndRound, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new ShowTableWithDynamicFiltersService(leagueId, startEndDate, (Boolean) null, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new ShowTableWithDynamicFiltersService(leagueId, startEndDate, startEndRound, null);
            fail();
        } catch (ServiceException e) {
        }
        startEndDate[1] = 20180920;
        startEndDate[0] = 20181020;
        startEndRound[0] = 1;
        startEndRound[1] = 10;
        try {
            new ShowTableWithDynamicFiltersService(leagueId, startEndDate, startEndRound, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        startEndDate[0] = 20180920;
        startEndDate[1] = 20181020;
        startEndRound[1] = 1;
        startEndRound[0] = 10;
        try {
            new ShowTableWithDynamicFiltersService(leagueId, startEndDate, startEndRound, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        startEndDate[0] = 20180920;
        startEndDate[1] = 20181020;
        startEndRound[0] = 1;
        startEndRound[1] = 10;
        homeAwayConditions[0] = false;
        homeAwayConditions[1] = false;
        try {
            new ShowTableWithDynamicFiltersService(leagueId, startEndDate, startEndRound, homeAwayConditions);
            fail();
        } catch (ServiceException e) {
        }
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = true;
        new ShowTableWithDynamicFiltersService(leagueId, startEndDate, startEndRound, homeAwayConditions);
    }

    @Test
    public void testInit() {
        ShowTableWithDynamicFiltersService instance = new ShowTableWithDynamicFiltersService(seasonIds);
        try {
            instance.init(null);
        } catch (ServiceException e) {
        }
        instance.init(brokerFactory);

    }

    @Test
    public void testExecute1() {
        System.out.println("execute");
        instance1_1_twoSeasons = new ShowTableWithDynamicFiltersService(seasonIds);
        instance1_2_oneSeason = new ShowTableWithDynamicFiltersService(seasonOneList);
        instance1_1_twoSeasons.init(brokerFactory);
        instance1_2_oneSeason.init(brokerFactory);
        String expResult1 = JsonOutputformat.create(tabel1TwoSeasonsHomeAndAway);
        String expResult2 = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        String reString1 = JsonOutputformat.create(instance1_1_twoSeasons.execute());
        String reString2 = JsonOutputformat.create(instance1_2_oneSeason.execute());
        assertTrue(expResult1.equals(reString1));
        assertTrue(expResult2.equals(reString2));
        instance1_2_oneSeason = new ShowTableWithDynamicFiltersService(seasonOneList);
        instance1_2_oneSeason.init(brokerFactory);
        reString2 = JsonOutputformat.create(instance1_2_oneSeason.execute());
        assertTrue(expResult2.equals(reString2));
    }

    @Test
    public void testExecute2() {
        System.out.println("execute2");
        instance2 = new ShowTableWithDynamicFiltersService(leagueId);

        instance2.init(brokerFactory);
        String expResult1 = JsonOutputformat.create(tabel1TwoSeasonsHomeAndAway);
        String reString1 = JsonOutputformat.create(instance2.execute());
        assertTrue(expResult1.equals(reString1));
    }

    @Test
    public void testExecute3() {
        System.out.println("execute3");
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = false;
        instance3 = new ShowTableWithDynamicFiltersService(seasonIds, homeAwayConditions);
        instance3.init(brokerFactory);
        String expResult1 = JsonOutputformat.create(tabel3TwoSeasonsHome);
        String reString1 = JsonOutputformat.create(instance3.execute());
        assertTrue(expResult1.equals(reString1));
        homeAwayConditions[1] = true;
        homeAwayConditions[0] = false;
        instance3 = new ShowTableWithDynamicFiltersService(seasonIds, homeAwayConditions);
        instance3.init(brokerFactory);
        String expResult2 = JsonOutputformat.create(tabel4TwoSeasonsAway);
        String reString2 = JsonOutputformat.create(instance3.execute());
        assertTrue(expResult2.equals(reString2));
        homeAwayConditions[1] = true;
        homeAwayConditions[0] = true;
        instance3 = new ShowTableWithDynamicFiltersService(seasonOneList, homeAwayConditions);
        instance3.init(brokerFactory);
        String expResult3 = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        String reString3 = JsonOutputformat.create(instance3.execute());
        assertTrue(expResult3.equals(reString3));
    }

    @Test
    public void testExecute4() {
        System.out.println("execute4");
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = false;
        instance4 = new ShowTableWithDynamicFiltersService(leagueId, homeAwayConditions);
        instance4.init(brokerFactory);
        String expResult1 = JsonOutputformat.create(tabel3TwoSeasonsHome);
        String reString1 = JsonOutputformat.create(instance4.execute());
        assertTrue(expResult1.equals(reString1));
        homeAwayConditions[1] = true;
        homeAwayConditions[0] = false;
        instance4 = new ShowTableWithDynamicFiltersService(leagueId, homeAwayConditions);
        instance4.init(brokerFactory);
        expResult1 = JsonOutputformat.create(tabel4TwoSeasonsAway);
        reString1 = JsonOutputformat.create(instance4.execute());
        assertTrue(expResult1.equals(reString1));
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = true;
        instance4 = new ShowTableWithDynamicFiltersService(leagueId, homeAwayConditions);
        instance4.init(brokerFactory);
        expResult1 = JsonOutputformat.create(tabel1TwoSeasonsHomeAndAway);
        reString1 = JsonOutputformat.create(instance4.execute());
        assertTrue(expResult1.equals(reString1));
    }

    @Test
    public void testExecute5() {
        System.out.println("execute5");
        startEndDate[0] = 1;
        startEndDate[1] = 2;
        startEndRound[0] = 1;
        startEndRound[1] = 1;
        instance5 = new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, chooseDate);
        instance5.init(brokerFactory);
        String expResult1 = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        String reString1 = JsonOutputformat.create(instance5.execute());
        assertTrue(expResult1.equals(reString1));
        instance5 = new ShowTableWithDynamicFiltersService(seasonIds, startEndRound, chooseRound);
        instance5.init(brokerFactory);
        reString1 = JsonOutputformat.create(instance5.execute());
        assertTrue(expResult1.equals(reString1));
    }

    @Test
    public void testExecute6() {
        System.out.println("execute6");
        startEndDate[0] = 1;
        startEndDate[1] = 2;
        startEndRound[0] = 1;
        startEndRound[1] = 2;
        instance6 = new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, startEndRound);
        instance6.init(brokerFactory);
        String expResult1 = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        String reString1 = JsonOutputformat.create(instance6.execute());
        assertTrue(expResult1.equals(reString1));
        startEndDate[0] = 1;
        startEndDate[1] = 4;
        startEndRound[0] = 1;
        startEndRound[1] = 1;
        instance6 = new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, startEndRound);
        instance6.init(brokerFactory);
        reString1 = JsonOutputformat.create(instance6.execute());
        assertTrue(expResult1.equals(reString1));

        startEndDate[0] = 1;
        startEndDate[1] = 2;
        startEndRound[0] = 1;
        startEndRound[1] = 1;
        instance6 = new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, startEndRound);
        instance6.init(brokerFactory);
        expResult1 = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString1 = JsonOutputformat.create(instance6.execute());
        assertFalse(expResult1.equals(reString1));
    }

    @Test
    public void testExecute7() {
        startEndDate[0] = 1;
        startEndDate[1] = 4;
        instance7 = new ShowTableWithDynamicFiltersService(leagueId, startEndDate, chooseDate);
        instance7.init(brokerFactory);
        String expResult = JsonOutputformat.create(tabel1TwoSeasonsHomeAndAway);
        String reString = JsonOutputformat.create(instance7.execute());
        assertTrue(expResult.equals(reString));
        
        startEndDate[0] = 1;
        startEndDate[1] = 2;
        instance7 = new ShowTableWithDynamicFiltersService(leagueId, startEndDate, chooseDate);
        instance7.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString = JsonOutputformat.create(instance7.execute());
        assertTrue(expResult.equals(reString));
        
        startEndRound[0] = 1;
        startEndRound[1] = 2;
        instance7 = new ShowTableWithDynamicFiltersService(leagueId, startEndRound, chooseRound);
        instance7.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel1TwoSeasonsHomeAndAway);
        reString = JsonOutputformat.create(instance7.execute());
        assertTrue(expResult.equals(reString));
        
        startEndRound[0] = 1;
        startEndRound[1] = 1;
        instance7 = new ShowTableWithDynamicFiltersService(leagueId, startEndRound, chooseRound);
        instance7.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString = JsonOutputformat.create(instance7.execute());
        assertTrue(expResult.equals(reString));
    }
    @Test
    public void testExecute8() {
        startEndDate[0] = 1;
        startEndDate[1] = 4;
        startEndRound[0] = 1;
        startEndRound[1] = 2;
        instance8 = new ShowTableWithDynamicFiltersService(leagueId, startEndDate, startEndRound);
        instance8.init(brokerFactory);
        String expResult = JsonOutputformat.create(tabel1TwoSeasonsHomeAndAway);
        String reString = JsonOutputformat.create(instance8.execute());
        assertTrue(expResult.equals(reString));
        
        startEndDate[0] = 1;
        startEndDate[1] = 2;
        startEndRound[0] = 1;
        startEndRound[1] = 2;
        instance8 = new ShowTableWithDynamicFiltersService(leagueId, startEndDate, startEndRound);
        instance8.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString = JsonOutputformat.create(instance8.execute());
        assertTrue(expResult.equals(reString));
        
        startEndDate[0] = 1;
        startEndDate[1] = 4;
        startEndRound[0] = 1;
        startEndRound[1] = 1;
        instance8 = new ShowTableWithDynamicFiltersService(leagueId, startEndDate, startEndRound);
        instance8.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString = JsonOutputformat.create(instance8.execute());
        assertTrue(expResult.equals(reString));
        
    }
    @Test
    public void testExecute9() {
        startEndDate[0] = 1;
        startEndDate[1] = 4;
        startEndRound[0] = 1;
        startEndRound[1] = 2;
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = true;
        instance9 = new ShowTableWithDynamicFiltersService(seasonIds, startEndRound, chooseRound, homeAwayConditions);
        instance9.init(brokerFactory);
        String expResult = JsonOutputformat.create(tabel1TwoSeasonsHomeAndAway);
        String reString = JsonOutputformat.create(instance9.execute());
        assertTrue(expResult.equals(reString));
        
        instance9 = new ShowTableWithDynamicFiltersService(seasonOneList, startEndRound, chooseRound, homeAwayConditions);
        instance9.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString = JsonOutputformat.create(instance9.execute());
        assertTrue(expResult.equals(reString));
        
        instance9 = new ShowTableWithDynamicFiltersService(seasonTwoList, startEndRound, chooseRound, homeAwayConditions);
        instance9.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString = JsonOutputformat.create(instance9.execute());
        assertTrue(expResult.equals(reString));
        
        startEndDate[0] = 1;
        startEndDate[1] = 2;
        instance9 = new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, chooseDate, homeAwayConditions);
        instance9.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString = JsonOutputformat.create(instance9.execute());
        assertTrue(expResult.equals(reString));
        
        startEndDate[0] = 3;
        startEndDate[1] = 4;
        instance9 = new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, chooseDate, homeAwayConditions);
        instance9.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString = JsonOutputformat.create(instance9.execute());
        assertTrue(expResult.equals(reString));
        
        startEndDate[0] = 1;
        startEndDate[1] = 4;
        startEndRound[0] = 1;
        startEndRound[1] = 1;
        instance9 = new ShowTableWithDynamicFiltersService(seasonIds, startEndRound, chooseRound, homeAwayConditions);
        instance9.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString = JsonOutputformat.create(instance9.execute());
        assertTrue(expResult.equals(reString));
        
        startEndRound[0] = 2;
        startEndRound[1] = 2;
        instance9 = new ShowTableWithDynamicFiltersService(seasonIds, startEndRound, chooseRound, homeAwayConditions);
        instance9.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString = JsonOutputformat.create(instance9.execute());
        assertTrue(expResult.equals(reString));
        
        startEndRound[0] = 1;
        startEndRound[1] = 2;
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = false;
        instance9 = new ShowTableWithDynamicFiltersService(seasonIds, startEndRound, chooseRound, homeAwayConditions);
        instance9.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel3TwoSeasonsHome);
        reString = JsonOutputformat.create(instance9.execute());
        assertTrue(expResult.equals(reString));
        
        homeAwayConditions[0] = false;
        homeAwayConditions[1] = true;
        instance9 = new ShowTableWithDynamicFiltersService(seasonIds, startEndRound, chooseRound, homeAwayConditions);
        instance9.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel4TwoSeasonsAway);
        reString = JsonOutputformat.create(instance9.execute());
        assertTrue(expResult.equals(reString));
    }
    @Test
    public void testExecute10() {
        startEndDate[0] = 1;
        startEndDate[1] = 4;
        startEndRound[0] = 1;
        startEndRound[1] = 2;
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = true;
        instance10 = new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, startEndRound, homeAwayConditions);
        instance10.init(brokerFactory);
        String expResult = JsonOutputformat.create(tabel1TwoSeasonsHomeAndAway);
        String reString = JsonOutputformat.create(instance10.execute());
        assertTrue(expResult.equals(reString));
        
        instance10 = new ShowTableWithDynamicFiltersService(seasonOneList, startEndDate, startEndRound, homeAwayConditions);
        instance10.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString = JsonOutputformat.create(instance10.execute());
        assertTrue(expResult.equals(reString));
        
        instance10 = new ShowTableWithDynamicFiltersService(seasonTwoList, startEndDate, startEndRound, homeAwayConditions);
        instance10.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString = JsonOutputformat.create(instance10.execute());
        assertTrue(expResult.equals(reString));
        
        startEndDate[0] = 1;
        startEndDate[1] = 2;
        instance10 = new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, startEndRound, homeAwayConditions);
        instance10.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString = JsonOutputformat.create(instance10.execute());
        assertTrue(expResult.equals(reString));
        
        startEndDate[0] = 3;
        startEndDate[1] = 4;
        instance10 = new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, startEndRound, homeAwayConditions);
        instance10.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString = JsonOutputformat.create(instance10.execute());
        assertTrue(expResult.equals(reString));
        
        startEndDate[0] = 1;
        startEndDate[1] = 4;
        startEndRound[0] = 1;
        startEndRound[1] = 1;
        instance10 = new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, startEndRound, homeAwayConditions);
        instance10.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString = JsonOutputformat.create(instance10.execute());
        assertTrue(expResult.equals(reString));
        
        startEndRound[0] = 2;
        startEndRound[1] = 2;
        instance10 = new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, startEndRound, homeAwayConditions);
        instance10.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString = JsonOutputformat.create(instance10.execute());
        assertTrue(expResult.equals(reString));
        
        startEndRound[0] = 1;
        startEndRound[1] = 2;
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = false;
        instance10 = new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, startEndRound, homeAwayConditions);
        instance10.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel3TwoSeasonsHome);
        reString = JsonOutputformat.create(instance10.execute());
        assertTrue(expResult.equals(reString));
        
        homeAwayConditions[0] = false;
        homeAwayConditions[1] = true;
        instance10 = new ShowTableWithDynamicFiltersService(seasonIds, startEndDate, startEndRound, homeAwayConditions);
        instance10.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel4TwoSeasonsAway);
        reString = JsonOutputformat.create(instance10.execute());
        assertTrue(expResult.equals(reString));
    }
    @Test
    public void testExecute11() {
        startEndDate[0] = 1;
        startEndDate[1] = 4;
        startEndRound[0] = 1;
        startEndRound[1] = 2;
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = true;
        instance11 = new ShowTableWithDynamicFiltersService(leagueId, startEndDate, chooseDate, homeAwayConditions);
        instance11.init(brokerFactory);
        String expResult = JsonOutputformat.create(tabel1TwoSeasonsHomeAndAway);
        String reString = JsonOutputformat.create(instance11.execute());
        assertTrue(expResult.equals(reString));
        
        startEndDate[0] = 1;
        startEndDate[1] = 2;
        instance11 = new ShowTableWithDynamicFiltersService(leagueId, startEndDate, chooseDate, homeAwayConditions);
        instance11.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString = JsonOutputformat.create(instance11.execute());
        assertTrue(expResult.equals(reString));
        
        startEndDate[0] = 1;
        startEndDate[1] = 4;
        startEndRound[0] = 1;
        startEndRound[1] = 1;
        instance11 = new ShowTableWithDynamicFiltersService(leagueId, startEndRound, chooseRound, homeAwayConditions);
        instance11.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString = JsonOutputformat.create(instance11.execute());
        assertTrue(expResult.equals(reString));
        
        startEndRound[0] = 1;
        startEndRound[1] = 2;
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = false;
        instance11 = new ShowTableWithDynamicFiltersService(leagueId, startEndRound, chooseRound, homeAwayConditions);
        instance11.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel3TwoSeasonsHome);
        reString = JsonOutputformat.create(instance11.execute());
        assertTrue(expResult.equals(reString));
        
        homeAwayConditions[0] = false;
        homeAwayConditions[1] = true;
        instance11 = new ShowTableWithDynamicFiltersService(leagueId, startEndRound, chooseRound, homeAwayConditions);
        instance11.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel4TwoSeasonsAway);
        reString = JsonOutputformat.create(instance11.execute());
        assertTrue(expResult.equals(reString));
    }
    @Test
    public void testExecute12() {
        startEndDate[0] = 1;
        startEndDate[1] = 4;
        startEndRound[0] = 1;
        startEndRound[1] = 2;
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = true;
        instance12 = new ShowTableWithDynamicFiltersService(leagueId, startEndDate, startEndRound, homeAwayConditions);
        instance12.init(brokerFactory);
        String expResult = JsonOutputformat.create(tabel1TwoSeasonsHomeAndAway);
        String reString = JsonOutputformat.create(instance12.execute());
        assertTrue(expResult.equals(reString));
        
        startEndDate[0] = 1;
        startEndDate[1] = 2;
        instance12 = new ShowTableWithDynamicFiltersService(leagueId, startEndDate, startEndRound, homeAwayConditions);
        instance12.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString = JsonOutputformat.create(instance12.execute());
        assertTrue(expResult.equals(reString));
        
        startEndDate[0] = 1;
        startEndDate[1] = 4;
        startEndRound[0] = 1;
        startEndRound[1] = 1;
        instance12 = new ShowTableWithDynamicFiltersService(leagueId, startEndDate, startEndRound, homeAwayConditions);
        instance12.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel2OneSeasonHomeAndAway);
        reString = JsonOutputformat.create(instance12.execute());
        assertTrue(expResult.equals(reString));
        
        startEndRound[0] = 1;
        startEndRound[1] = 2;
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = false;
        instance12 = new ShowTableWithDynamicFiltersService(leagueId, startEndDate, startEndRound, homeAwayConditions);
        instance12.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel3TwoSeasonsHome);
        reString = JsonOutputformat.create(instance12.execute());
        assertTrue(expResult.equals(reString));
        
        homeAwayConditions[0] = false;
        homeAwayConditions[1] = true;
        instance12 = new ShowTableWithDynamicFiltersService(leagueId, startEndDate, startEndRound, homeAwayConditions);
        instance12.init(brokerFactory);
        expResult = JsonOutputformat.create(tabel4TwoSeasonsAway);
        reString = JsonOutputformat.create(instance12.execute());
        assertTrue(expResult.equals(reString));
    }
}