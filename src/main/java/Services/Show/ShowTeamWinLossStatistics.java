/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Show;

import Services.Get.GetAllGamesFromSeasonService;
import AssistantClasses.JsonOutputformat;
import Domain.Game;
import Domain.Result;
import Domain.Team;
import Services.Service;
import Services.ServiceException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Veiret
 */
public class ShowTeamWinLossStatistics extends Service { /// to do ::: Perioder, boolean array size

    private final List<Long> teamIds;
    private final List<Long> seasonIds;
    private final Boolean firstGoal, lastGoal, fulltime, overtime, homeGames, awayGames;
    private final Integer wonPeriod;
    /* If == 0 -> dont filter on period */
    private List<Game> listOfGames;
    private List<Team> listOfTeams;

    ShowTeamWinLossStatistics(List<Long> seasonIds, Boolean[] firstLastGoal, Boolean[] fullOvertime, Integer wonPeriods, Boolean[] homeAway) {
        this.seasonIds = seasonIds;
        this.teamIds = null;
        this.firstGoal = firstLastGoal[0];
        this.lastGoal = firstLastGoal[1];
        this.fulltime = fullOvertime[0];
        this.overtime = fullOvertime[1];
        this.wonPeriod = wonPeriods;
        this.homeGames = homeAway[0];
        this.awayGames = homeAway[1];
        if (seasonIds == null) {
            throw new ServiceException("seasonIds cannot be null");
        }
        if (firstGoal == null || lastGoal == null || fulltime == null || overtime == null || wonPeriods == null || homeGames == null || awayGames == null) {
            throw new ServiceException("Conditions cannot be null");
        }
        if (!fulltime && !overtime) {
            throw new ServiceException("cannot filter both overtime and fulltime");
        }
        if (wonPeriods < 0) {
            throw new ServiceException("Wonperiods cannot be less then 0");
        }
        if (this.homeGames == null) {
            throw new ServiceException("homeGames cannot be null");
        }
        if (this.awayGames == null) {
            throw new ServiceException("awayGames cannot be null");
        }
    }

    ShowTeamWinLossStatistics(List<Long> seasonIds, Boolean[] firstLastGoal, Boolean[] fullOvertime, Integer wonPeriods, List<Long> teamIds , Boolean[] homeAway) {
        this.seasonIds = seasonIds;
        this.teamIds = teamIds;
        this.firstGoal = firstLastGoal[0];
        this.lastGoal = firstLastGoal[1];
        this.fulltime = fullOvertime[0];
        this.overtime = fullOvertime[1];
        this.wonPeriod = wonPeriods;
        this.homeGames = homeAway[0];
        this.awayGames = homeAway[1];
        if (seasonIds == null) {
            throw new ServiceException("seasonIds cannot be null");
        }
        if (teamIds == null) {
            throw new ServiceException("teamIds cannot be null");
        }
        if (firstGoal == null || lastGoal == null || fulltime == null || overtime == null || wonPeriods == null || homeGames == null || awayGames == null) {
            throw new ServiceException("Conditions cannot be null");
        }
        if (!fulltime && !overtime) {
            throw new ServiceException("cannot filter both overtime and fulltime");
        }
        if (wonPeriods < 0) {
            throw new ServiceException("Wonperiods cannot be less then 0");
        }
        if (this.homeGames == null) {
            throw new ServiceException("homeGames cannot be null");
        }
        if (this.awayGames == null) {
            throw new ServiceException("awayGames cannot be null");
        }

    }

    ShowTeamWinLossStatistics(Boolean[] firstLastGoal, Boolean[] fullOvertime, Integer wonPeriods, List<Long> teamIds , Boolean[] homeAway) {
        this.seasonIds = null;
        this.teamIds = teamIds;
        this.firstGoal = firstLastGoal[0];
        this.lastGoal = firstLastGoal[1];
        this.fulltime = fullOvertime[0];
        this.overtime = fullOvertime[1];
        this.wonPeriod = wonPeriods;
        this.homeGames = homeAway[0];
        this.awayGames = homeAway[1];
        if (teamIds == null) {
            throw new ServiceException("teamIds cannot be null");
        }
        if (firstGoal == null || lastGoal == null || fulltime == null || overtime == null || wonPeriods == null || homeGames == null || awayGames == null) {
            throw new ServiceException("Conditions cannot be null");
        }
        if (!fulltime && !overtime) {
            throw new ServiceException("cannot filter both overtime and fulltime");
        }
        if (wonPeriods < 0) {
            throw new ServiceException("Wonperiods cannot be less then 0");
        }
        if (this.homeGames == null) {
            throw new ServiceException("homeGames cannot be null");
        }
        if (this.awayGames == null) {
            throw new ServiceException("awayGames cannot be null");
        }
    }

    @Override
    public List<TableRow> execute() {
        if (seasonIds == null) {
            listOfGames = teamIds.stream()
                    .map(id -> getBrokerFactory().getTeamBroker().getAllGamesForOneTeam(id))
                    .flatMap(games -> games.stream()).map(game -> game.getId())
                    .distinct()
                    .map(id -> getBrokerFactory().getGameBroker().findById(id))
                    .collect(Collectors.toList());
            listOfTeams = teamIds.stream().map(id -> getBrokerFactory().getTeamBroker().findTeamById(id))
                    .collect(Collectors.toList());
        }
        if (teamIds == null) {
            listOfTeams = seasonIds.stream().map(id -> getBrokerFactory().getSeasonBroker().getAllTeamsFromSeasonId(id))
                    .flatMap(teams -> teams.stream())
                    .collect(Collectors.toList());
        }
        if (teamIds != null) {
            listOfTeams = teamIds.stream()
                    .map(id -> getBrokerFactory().getTeamBroker().findTeamById(id))
                    .collect(Collectors.toList());
        }
        if (seasonIds != null) {
            listOfGames = seasonIds.stream().map(seasonId
                    -> {
                GetAllGamesFromSeasonService service = getBrokerFactory().getServiceBroker().getAllGamesFromSeasonService(seasonId);
                service.init(getBrokerFactory());
                return service.execute();
            })
                    .flatMap(games -> games.stream())
                    .collect(Collectors.toList());
        }
         List<TableRow> rows = listOfTeams.stream().map(team -> new TableRow(team)).collect(Collectors.toList());
         rows.stream().forEach(tableRow -> tableRow.create());
         rows = rows.stream().sorted((row2, row1) -> ((Double) row1.winPercentage).compareTo((Double) row2.winPercentage))
                 .collect(Collectors.toList());
         //return rows.stream().map(row -> JsonOutputformat.create(row)).collect(Collectors.toList());
         return rows;
    }

    @JsonPropertyOrder({"teamName", "winPercentage", "lossPercentage", "gamesPlayed", "gamesWon", "gamesLossed"})
    private class TableRow {

        public String teamName;
        public long teamId;
        public double winPercentage;
        public double lossPercentage;
        public int gamesPlayed;
        public int gamesWon;
        public int gamesLossed;
        public String getTeamName() {
            return teamName;
        }

        public long getTeamId() {
            return teamId;
        }

        public double getWinPercentage() {
            return winPercentage;
        }

        public double getLossPercentage() {
            return lossPercentage;
        }

        public int getGamesPlayed() {
            return gamesPlayed;
        }

        public int getGamesWon() {
            return gamesWon;
        }

        public int getGamesLossed() {
            return gamesLossed;
        }
        

        public TableRow(Team team) {
            teamName = team.getName();
            teamId = team.getId();
            gamesPlayed = 0;
            gamesWon = 0;
            gamesLossed = 0;

        }

        private void create() {
            listOfGames.stream().forEach(game
                    -> {
                Result result = game.getResult(); // Avoid creating result a bunch of times
                int periodHS;
                int periodAS;
                boolean homeWonPeriod = false;
                boolean awayWonPeriod = false;
                if (wonPeriod != 0) {
                    String resString = game.getResult().getScore();
                    if (resString == null) {
                        throw new ServiceException("No period results");
                    }
                    if (resString.split("-").length < wonPeriod) {
                        throw new ServiceException("Period does not exist");
                    }
                    String periodRes = resString.split("-")[wonPeriod-1];
                    periodHS = Integer.parseInt(periodRes.split(":")[0]);
                    periodAS = Integer.parseInt(periodRes.split(":")[1]);
                    if (periodHS > periodAS) {
                        homeWonPeriod = true;
                    }
                    if (periodHS < periodAS) {
                        awayWonPeriod = true;
                    }
                }
                if (game.getHomeTeam().getId() == teamId && homeGames && !(firstGoal && !result.getHomeTeamFirstGoal()) && !(lastGoal && !result.getHomeTeamLastGoal()) 
                        && (fulltime && result.getFullTime() || overtime && (result.getOverTime() || result.getShotOut())) 
                        && !((wonPeriod != 0) && ! homeWonPeriod)
                        ) {
                    gamesPlayed++;
                    if (result.getHomeScore() > result.getAwayScore()) {
                        gamesWon++;
                    } else if (result.getHomeScore() < result.getAwayScore()) {
                        gamesLossed++;
                    }
                } else if (game.getAwayTeam().getId() == teamId && awayGames && !(firstGoal && !result.getAwayTeamFirstGoal()) && !(lastGoal && !result.getAwayTeamLastGoal())
                        && (fulltime && result.getFullTime() || overtime && (result.getOverTime() || result.getShotOut()))
                        && !((wonPeriod != 0) && ! awayWonPeriod)
                        ) {
                    gamesPlayed++;
                    if (result.getHomeScore() < result.getAwayScore()) {
                        gamesWon++;
                    } else if (result.getHomeScore() > result.getAwayScore()) {
                        gamesLossed++;
                    }
                }
            });
            if (gamesPlayed != 0) {
                winPercentage = (double) gamesWon *100 / (double) gamesPlayed;
                lossPercentage = (double) gamesLossed *100 / (double) gamesPlayed;
            } else {
                winPercentage = 0;
                lossPercentage = 0;
            }
            
        }

    }
}
