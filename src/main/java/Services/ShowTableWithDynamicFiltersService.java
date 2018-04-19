/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import AssistantClasses.GetTeamsFromListOfGames;
import AssistantClasses.MakeTableFromGameList;
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
    }

    public ShowTableWithDynamicFiltersService(List<Long> seasonIds, int[] filter, boolean trueDateFalseRound, boolean[] homeAwayConditions) {
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
        this.homeAwayConditions = homeAwayConditions;
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = true;
        if (seasonIds == null) {
            throw new ServiceException("seasonIds cannot be null");
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

    public ShowTableWithDynamicFiltersService(Long leagueId, int[] filter, boolean chooseFilter) {
        this.leagueId = leagueId;
        this.seasonIds = null;
        this.trueDateFalseRound = chooseFilter;
        this.homeAwayConditions = new boolean[2];
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = true;
        this.startEndDate = null;
        this.startEndRound = null;
        if (leagueId == null) {
            throw new ServiceException("seasonIds cannot be null");
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
            throw new ServiceException("seasonIds cannot be null");
        }
    }

    public ShowTableWithDynamicFiltersService(Long leagueId, int[] filter, boolean chooseFilter, boolean[] homeAwayConditions) {
        this.leagueId = leagueId;
        this.seasonIds = null;
        this.trueDateFalseRound = chooseFilter;
        this.homeAwayConditions = homeAwayConditions;
        homeAwayConditions[0] = true;
        homeAwayConditions[1] = true;
        this.startEndDate = null;
        this.startEndRound = null;
        if (leagueId == null) {
            throw new ServiceException("seasonIds cannot be null");
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
    }

    public ShowTableWithDynamicFiltersService(Long leagueId, int[] startEndDate, int[] startEndRound, boolean[] homeAwayConditions) {
        this.leagueId = leagueId;
        this.seasonIds = null;
        this.trueDateFalseRound = null;
        this.homeAwayConditions = homeAwayConditions;
        this.startEndDate = startEndDate;
        this.startEndRound = startEndRound;
        if (leagueId == null) {
            throw new ServiceException("seasonIds cannot be null");
        }
    }

    @Override
    public String execute() {
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
