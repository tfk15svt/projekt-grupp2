/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import AssistantClasses.GetTeamsFromListOfGames;
import AssistantClasses.MakeTableFromGameList;
import AssistantClasses.MakeTableFromGameList.TableRow;
import Domain.Game;
import Domain.Season;
import Domain.Team;
import Filter.FilterGamesWithinDateInterval;
import Filter.FilterGamesWithinRoundInterval;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Simon
 */
public class ShowTableWithDynamicFiltersService extends Service {

    private List<Long> seasonIds;
    private final Long leagueId;
    private final boolean[] homeAwayConditions;
    private final int[] startEndDate;
    private final int[] startEndRound;
    private final Boolean trueDateFalseRound;

    public ShowTableWithDynamicFiltersService(List<Long> seasonIds) {
        this.seasonIds = seasonIds;
        this.leagueId = null;
        this.trueDateFalseRound = null;
        this.homeAwayConditions = new boolean[2];
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = true;
        this.startEndDate = null;
        this.startEndRound = null;
        if (seasonIds == null) {
            throw new ServiceException("seasonIds cannot be null");
        }
    }

    public ShowTableWithDynamicFiltersService(List<Long> seasonIds, int[] filter, boolean trueDateFalseRound) {
        this.seasonIds = seasonIds;
        this.leagueId = null;
        this.trueDateFalseRound = trueDateFalseRound;
        if (trueDateFalseRound) {
            this.startEndDate = filter;
            this.startEndRound = null;
        } else {
            this.startEndDate = null;
            this.startEndRound = filter;
        }
        this.homeAwayConditions = new boolean[2];
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = true;
        if (seasonIds == null) {
            throw new ServiceException("seasonIds cannot be null");
        }
        if (filter == null){
            throw new ServiceException("Filter can not be null");
        }
        if(filter[0] > filter[1]){
            throw new ServiceException("End of interval is before start of interval");
        }
        
    }

    public ShowTableWithDynamicFiltersService(List<Long> seasonIds, boolean[] homeAwayConditions) {
        this.seasonIds = seasonIds;
        this.leagueId = null;
        this.trueDateFalseRound = null;
        this.homeAwayConditions = homeAwayConditions;
        this.startEndDate = null;
        this.startEndRound = null;
        if (seasonIds == null) {
            throw new ServiceException("seasonIds cannot be null");
        }
        if (homeAwayConditions == null) {
            throw new ServiceException("Home and away conditions cannot be null");
        }
        if (!homeAwayConditions[0] && !homeAwayConditions[1]) {
            throw new ServiceException("Pointless table exception");
        }
    }

    public ShowTableWithDynamicFiltersService(List<Long> seasonIds, int[] filter, Boolean trueDateFalseRound, boolean[] homeAwayConditions) {
        this.seasonIds = seasonIds;
        this.leagueId = null;
        this.trueDateFalseRound = trueDateFalseRound;
        this.homeAwayConditions = homeAwayConditions;

        if (seasonIds == null) {
            throw new ServiceException("seasonIds cannot be null");
        }
        if(filter == null){
            throw new ServiceException("Filter cannot be null");
        }
        if (this.trueDateFalseRound == null){
            throw new ServiceException("TrueDateFalseRound cannot be null");
        }
        if(this.homeAwayConditions == null){
            throw new ServiceException("HomeAwayConditions cannot be null");
        }
        if(filter[0] > filter[1]){
            throw new ServiceException("End of interval is before start of interval");
        }
        if (!homeAwayConditions[0] && !homeAwayConditions[1]) {
            throw new ServiceException("Pointless table exception");
        }
        if (trueDateFalseRound) {
            this.startEndDate = filter;
            this.startEndRound = null;
        } else {
            this.startEndDate = null;
            this.startEndRound = filter;
        }
        
    }

    public ShowTableWithDynamicFiltersService(List<Long> seasonIds, int[] startEndDate, int[] startEndRound) {
        this.seasonIds = seasonIds;
        this.leagueId = null;
        this.trueDateFalseRound = null;
        this.homeAwayConditions = new boolean[2];
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = true;
        this.startEndDate = startEndDate;
        this.startEndRound = startEndRound;
        if (seasonIds == null) {
            throw new ServiceException("seasonIds cannot be null");
        }
        if(startEndDate == null){
            throw new ServiceException("StartEndDate cannot be null");
        }
        if(startEndRound == null){
            throw new ServiceException("StartEndRound cannot be null");
        }
        if (startEndRound[0] > startEndRound[1]){
            throw new ServiceException("Start can not be larger then end");
        }
        if(startEndDate[0] > startEndDate[1]){
            throw new ServiceException("Start can not be larger then end");
        }
        
        
    }

    public ShowTableWithDynamicFiltersService(List<Long> seasonIds, int[] startEndDate, int[] startEndRound, boolean[] homeAwayConditions) {
        this.seasonIds = seasonIds;
        this.leagueId = null;
        this.trueDateFalseRound = null;
        this.homeAwayConditions = homeAwayConditions;
        this.startEndDate = startEndDate;
        this.startEndRound = startEndRound;
        if (seasonIds == null) {
            throw new ServiceException("seasonIds cannot be null");
        }
        if (startEndDate == null){
            throw new ServiceException("StartEndDate cannot be null");
        }
        if(startEndRound == null){
            throw new ServiceException("StartEndRound cannot be null");
        }
        if(homeAwayConditions == null){
            throw new ServiceException("HomeAwayConditions cannot be null");
        }
         if (startEndRound[0] > startEndRound[1]){
            throw new ServiceException("Start can not be larger then end");
        }
        if(startEndDate[0] > startEndDate[1]){
            throw new ServiceException("Start can not be larger then end");
        }
        if (!homeAwayConditions[0] && !homeAwayConditions[1]) {
            throw new ServiceException("Pointless table exception");
        }
        
                
    }

    public ShowTableWithDynamicFiltersService(Long leagueId) {
        this.leagueId = leagueId;
        this.seasonIds = null;
        this.trueDateFalseRound = null;
        this.homeAwayConditions = new boolean[2];
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = true;
        this.startEndDate = null;
        this.startEndRound = null;
        if (leagueId == null) {
            throw new ServiceException("seasonIds cannot be null");
        }
    }

    public ShowTableWithDynamicFiltersService(Long leagueId, int[] filter, Boolean chooseFilter) {
        this.leagueId = leagueId;
        this.seasonIds = null;
        this.trueDateFalseRound = chooseFilter;
        this.homeAwayConditions = new boolean[2];
        
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = true;
        if (leagueId == null) {
            throw new ServiceException("seasonIds cannot be null");
        }
        if(filter == null){
            throw new ServiceException("Filter cannot be null");
        }
        if(this.trueDateFalseRound == null){
            throw new ServiceException("ChooseFilter cannot be null");
        }
        if (filter[0] > filter[1]){
            throw new ServiceException("Start cannot be larger then end");
        }
        
        if (trueDateFalseRound) {
            this.startEndDate = filter;
            this.startEndRound = null;
        } else {
            this.startEndDate = null;
            this.startEndRound = filter;
        }
        
    }

    public ShowTableWithDynamicFiltersService(Long leagueId, boolean[] homeAwayConditions) {
        this.leagueId = leagueId;
        this.seasonIds = null;
        this.trueDateFalseRound = null;
        this.homeAwayConditions = homeAwayConditions;
        this.startEndDate = null;
        this.startEndRound = null;
        if (leagueId == null) {
            throw new ServiceException("leagueId cannot be null");
        }
        if (homeAwayConditions == null) {
            throw new ServiceException("Home and away conditions cannot be null");
        }
        if (!homeAwayConditions[0] && !homeAwayConditions[1]) {
            throw new ServiceException("Pointless table exception");
        }
    }

    public ShowTableWithDynamicFiltersService(Long leagueId, int[] filter, Boolean chooseFilter, boolean[] homeAwayConditions) {
        this.leagueId = leagueId;
        this.seasonIds = null;
        this.trueDateFalseRound = chooseFilter;
        this.homeAwayConditions = homeAwayConditions;
        if (leagueId == null) {
            throw new ServiceException("seasonIds cannot be null");
        }
        if (filter == null) {
            throw new ServiceException("filter cannot be null");
        }
        if (trueDateFalseRound == null) {
            throw new ServiceException("chooseFilter cannot be null");
        }
        if(homeAwayConditions == null) {
            throw new ServiceException("homeAwayConditions cannot be null");
        }
        if (filter[0] > filter[1]){
            throw new ServiceException("Start cannot be larger then end");
        }
        if (!homeAwayConditions[0] && !homeAwayConditions[1]) {
            throw new ServiceException("Pointless table exception");
        }
        
        if (trueDateFalseRound) {
            this.startEndDate = filter;
            this.startEndRound = null;
        } else {
            this.startEndDate = null;
            this.startEndRound = filter;
        }
    }

    public ShowTableWithDynamicFiltersService(Long leagueId, int[] startEndDate, int[] startEndRound) {
        this.leagueId = leagueId;
        this.seasonIds = null;
        this.trueDateFalseRound = null;
        this.homeAwayConditions = new boolean[2];
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = true;
        this.startEndDate = startEndDate;
        this.startEndRound = startEndRound;
        if (leagueId == null) {
            throw new ServiceException("seasonIds cannot be null");
        }
        if(startEndDate == null) {
            throw new ServiceException("StartEndDate cannot be null");
        }
        if(startEndRound == null){
            throw new ServiceException("StartEndRound cannot be null");
        }
         if (startEndRound[0] > startEndRound[1]){
            throw new ServiceException("Start can not be larger then end");
        }
        if(startEndDate[0] > startEndDate[1]){
            throw new ServiceException("Start can not be larger then end");
        }
        
    }

    public ShowTableWithDynamicFiltersService(Long leagueId, int[] startEndDate, int[] startEndRound, boolean[] homeAwayConditions) {
        this.leagueId = leagueId;
        this.seasonIds = null;
        this.trueDateFalseRound = null;
        this.homeAwayConditions = homeAwayConditions;
        this.startEndDate = startEndDate;
        this.startEndRound = startEndRound;
        if (leagueId == null) {
            throw new ServiceException("leagueId cannot be null");
        }
        if (startEndDate == null){
            throw new ServiceException("StartEndDate cannot be null");
        }
        if(startEndRound == null){
            throw new ServiceException("StartEndRound cannot be null");
        }
        if(homeAwayConditions == null){
            throw new ServiceException("HomeAwayConditions cannot be null");
        }
         if (startEndRound[0] > startEndRound[1]){
            throw new ServiceException("Start can not be larger then end");
        }
        if(startEndDate[0] > startEndDate[1]){
            throw new ServiceException("Start can not be larger then end");
        }
        if (!homeAwayConditions[0] && !homeAwayConditions[1]) {
            throw new ServiceException("Pointless table exception");
        }
        
    }

    @Override
    public List<TableRow> execute() {
        if (seasonIds != null) {
            for (Long id : seasonIds) {
                if (!getBrokerFactory().getSeasonBroker().seasonExists(id)) {
                    throw new ServiceException("no season with given id");
                }
            }
        }
        if (leagueId != null && !getBrokerFactory().getLeagueBroker().leagueExists(leagueId)) {
            throw new ServiceException("League does not exist");
        }
        if (leagueId != null) {
            seasonIds = getBrokerFactory().getLeagueBroker().getAllSeasonsFromLeagueId(leagueId)
                    .stream().map(season -> season.getId())
                    .collect(Collectors.toList());
        }

        List<Game> listOfGames = seasonIds.stream().map(id
                -> {
            GetAllGamesFromSeasonService getGames
                    = getBrokerFactory().getServiceBroker()
                            .getAllGamesFromSeasonService(id);
            getGames.init(getBrokerFactory());
            return getGames.execute();
        }).flatMap(gameList -> gameList.stream())
                .collect(Collectors.toList());

        if (startEndDate != null) {
            listOfGames
                    = new FilterGamesWithinDateInterval(listOfGames, startEndDate[0], startEndDate[1])
                            .execute();
        }
        if (startEndRound != null) {
            listOfGames
                    = new FilterGamesWithinRoundInterval(listOfGames, startEndRound[0], startEndRound[1])
                            .execute();
        }

        GetTeamsFromListOfGames getTeams = new GetTeamsFromListOfGames(listOfGames);
        getTeams.init(getBrokerFactory());
        List<Team> listOfTeams = getTeams.execute();

        return new MakeTableFromGameList(listOfGames, listOfTeams, homeAwayConditions).execute();
    }

}
