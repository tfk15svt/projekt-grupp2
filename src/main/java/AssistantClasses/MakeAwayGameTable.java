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
public class MakeAwayGameTable {

    private List<TableRow> notSortedRows;
    private List<TableRow> sortedRows;
    private int[] sizeOfCol = new int[7];
    List<Game> listOfGames;
    List<Team> listOfTeams;

    public MakeAwayGameTable(List<Game> games, List<Team> teams) {
        this.listOfGames = games;
        this.listOfTeams = teams;
        if (listOfGames == null) {
            throw new ServiceException("List of games is null");
        }
        if (listOfTeams == null) {
            throw new ServiceException("List of games is null");
        }
    }

    public String execute() {
        notSortedRows = new ArrayList<TableRow>();
        sortedRows = new ArrayList<TableRow>();

        listOfTeams.forEach((team) -> {
            notSortedRows.add(new TableRow(team));
        });

        setRowSizes();
        sortList();
        return JsonOutputformat.create(sortedRows);
    }

    public void setRowSizes() {
        for (int i = 0; i < sizeOfCol.length; i++) {
            sizeOfCol[i] = 0;
        }
        notSortedRows.forEach((tableRow) -> {
            for (int i = 0; i < tableRow.row.length; i++) {
                if (tableRow.row[i].length() > sizeOfCol[i]) {
                    sizeOfCol[i] = tableRow.row[i].length();
                }
            }
        });
        notSortedRows.forEach((tableRow) -> {
            for (int colInTableRow = 0; colInTableRow < tableRow.row.length; colInTableRow++) {
                if (tableRow.row[colInTableRow].length() < sizeOfCol[colInTableRow]) {

                    int numberOfSpaces = sizeOfCol[colInTableRow] - tableRow.row[colInTableRow].length();
                    String spaces = "";
                    for (int spaceNumber = 0; spaceNumber < numberOfSpaces; spaceNumber++) {
                        spaces = spaces + " ";
                    }

                    tableRow.row[colInTableRow] = spaces + tableRow.row[colInTableRow];
                }
            }
        });
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

    private String createTable() {
        String table = "";
        table = sortedRows.stream().map((tablerow) -> tablerow.row[0] + tablerow.row[1] + tablerow.row[2]
                + tablerow.row[3] + tablerow.row[4] + tablerow.row[5]
                + tablerow.row[6] + "\n").reduce(table, String::concat);
        return table;
    }
    @JsonPropertyOrder({ "teamName", "gamesPlayed", "fullTimeWins", "tied", "losses", "scoredGoals", "opponentScore", "points" })
    private class TableRow {
        long teamId;
        String teamName;
        String[] row;
        int fullTimeWins;
        int losses;
        int overTimeLosses;
        int tied;
        int scoredGoals;
        int opponentScore;
        int overTimeWins;
        //int getGamesPlayed;
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
                if (awayTeamId == teamId) {
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
            setRowColumns();
        }

        public String getTeamName() {
            return teamName;
        }

        public int getGamesPlayed() {
            //getGamesPlayed = fullTimeWins + losses + tied;
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

        public void setRowColumns() {
            row = new String[7];
            row[0] = teamName;
            row[1] = " GP: " + (fullTimeWins + losses + tied);
            row[2] = " W: " + (fullTimeWins);
            row[3] = " T: " + (tied);
            row[4] = " L: " + losses;
            row[5] = " " + scoredGoals + " - " + opponentScore + " ";
            row[6] = getPoints() + "p";
        }
    }
}
