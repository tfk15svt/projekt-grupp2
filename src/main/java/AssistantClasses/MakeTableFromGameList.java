/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssistantClasses;

import Services.*;
import Domain.Game;
import Domain.Team;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Veiret
 */
public class MakeTableFromGameList {

    private List<TableRow> notSortedRows;
    private List<TableRow> sortedRows;
    List<Game> listOfGames;
    List<Team> listOfTeams;
    private boolean countHome;
    private boolean countAway;

    public MakeTableFromGameList(List<Game> games, List<Team> teams, boolean[] conditions) {
        this.listOfGames = games;
        this.listOfTeams = teams;
        if (listOfGames == null) {
            throw new ServiceException("List of games is null");
        }
        if (listOfTeams == null) {
            throw new ServiceException("List of games is null");
        }
        countHome = conditions[0];
        countAway = conditions[1];
    }

    public String execute() {
        notSortedRows = new ArrayList<TableRow>();
        sortedRows = new ArrayList<TableRow>();

        listOfTeams.forEach((team) -> {
            notSortedRows.add(new TableRow(team));
        });

        sortList();
        return JsonOutputformat.create(sortedRows);
    }



    public void sortList() {
        int notSortedRowsLength = notSortedRows.size();
        while (notSortedRowsLength > 0) {
            int mostPoints = 0;
            for (TableRow row : notSortedRows) {
                if (mostPoints < row.getPoints()) {
                    mostPoints = row.getPoints();
                }
            }
            Iterator<TableRow> iterator = notSortedRows.iterator();
            while (iterator.hasNext()) {
                TableRow row = iterator.next();
                if (mostPoints == row.getPoints()) {
                    sortedRows.add(row);
                    iterator.remove();
                    notSortedRowsLength = notSortedRowsLength - 1;
                }
            }

        }

    }

   
    @JsonPropertyOrder({ "teamName", "gamesPlayed", "fullTimeWins", "tied", "losses", "scoredGoals", "opponentScore", "points" })
    private class TableRow {
        long teamId;
        String teamName;
        int fullTimeWins;
        int losses;
        int overTimeLosses;
        int tied;
        int scoredGoals;
        int opponentScore;
        int overTimeWins;
        TableRow(Team team) {
            this.teamId = team.getDao().getLongId();
            this.teamName = team.getName();

            fullTimeWins = 0;
            losses = 0;
            overTimeLosses = 0;
            tied = 0;
            scoredGoals = 0;
            opponentScore = 0;
            overTimeWins = 0;

            listOfGames.forEach((game) -> {
                long homeTeamId = game.getHomeTeam().getDao().getLongId();
                long awayTeamId = game.getAwayTeam().getDao().getLongId();
                if ((homeTeamId == teamId) && countHome/*&& (game.getResult() != null)*/) {
                    int homeScore = game.getResult().getHomeScore();
                    int awayScore = game.getResult().getAwayScore();

                    scoredGoals += homeScore;
                    opponentScore += awayScore;

                    if ((homeScore > awayScore) && game.getResult().getFullTime()) {
                        fullTimeWins++;
                    }
                    if ((homeScore > awayScore) && (game.getResult().getOverTime() || game.getResult().getShotOut())) {
                        tied++;
                        overTimeWins++;
                    }
                    if ((homeScore < awayScore) && (game.getResult().getOverTime() || game.getResult().getShotOut())) {
                        tied++;
                        overTimeLosses++;
                    }
                    if ((homeScore < awayScore) && game.getResult().getFullTime()) {
                        losses++;
                    }
                }
                if (awayTeamId == teamId && countAway) {
                    int homeScore = game.getResult().getHomeScore();
                    int awayScore = game.getResult().getAwayScore();
                    scoredGoals += awayScore;
                    opponentScore += homeScore;
                    if ((homeScore < awayScore) && game.getResult().getFullTime()) {
                        fullTimeWins++;
                    }
                    if ((homeScore < awayScore) && (game.getResult().getOverTime() || game.getResult().getShotOut())) {
                        tied++;
                        overTimeWins++;
                    }
                    if ((homeScore > awayScore) && (game.getResult().getOverTime() || game.getResult().getShotOut())) {
                        tied++;
                        overTimeLosses++;
                    }
                    if ((homeScore > awayScore) && game.getResult().getFullTime()) {
                        losses++;
                    }
                }
            });
            
        }

        public String getTeamName() {
            return teamName;
        }

        public int getGamesPlayed() {
            return fullTimeWins + losses + tied;
        }

        public int getFullTimeWins() {
            return fullTimeWins;
        }

        public int getTied() {
            return tied;
        }

        public int getLosses() {
            return losses;
        }

        public int getScoredGoals() {
            return scoredGoals;
        }

        public int getOpponentScore() {
            return opponentScore;
        }

        public int getPoints() {
            return 3 * fullTimeWins + 2 * overTimeWins + (tied - overTimeWins);
        }

        
    }
}
