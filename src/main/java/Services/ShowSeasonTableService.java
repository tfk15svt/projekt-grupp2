/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Domain.Game;
import Domain.Team;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Veiret
 */
public class ShowSeasonTableService extends Service {

    private List<TableRow> notSortedRows;
    private List<TableRow> sortedRows;
    private final Long seasonId;
    private int[] sizeOfCol = new int[7];
    List<Game> allSeasonGames;
    List<Team> allSeasonTeams;

    public ShowSeasonTableService(Long seasonId) {
        this.seasonId = seasonId;
        if (seasonId == null) {
            throw new ServiceException("Season id is null");
        }
    }

    @Override
    public String execute() {
        allSeasonGames = (List<Game>) new ServiceRunner(new GetAllGamesFromSeasonService(seasonId)).execute();
        allSeasonTeams = getBrokerFactory().getSeasonBroker().getAllTeamsFromSeasonId(seasonId);
        notSortedRows = new ArrayList<TableRow>();
        sortedRows = new ArrayList<TableRow>();

        for (Team team : allSeasonTeams) {
            notSortedRows.add(new TableRow(team));
        }

        setRowSizes();
        sortList();
        return createTable();
    }

    public void setRowSizes() {
        for (int i = 0; i < sizeOfCol.length; i++) {
            sizeOfCol[i] = 0;
        }
        for (TableRow tableRow : notSortedRows) {
            for (int i = 0; i < tableRow.row.length; i++) {
                if (tableRow.row[i].length() > sizeOfCol[i]) {
                    sizeOfCol[i] = tableRow.row[i].length();
                }
            }
        }
        for (TableRow tableRow : notSortedRows) {
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
        }
    }

    public void sortList() {
        while (!notSortedRows.isEmpty()) {
            int mostPoints = 0;
            for (TableRow row : notSortedRows) {
                if (mostPoints < row.getPoints()) {
                    mostPoints = row.getPoints();
                }
            }
            for (TableRow row : notSortedRows) {
                if (mostPoints == row.getPoints()) {
                    sortedRows.add(row);
                    notSortedRows.remove(row);
                }
            }
        }

    }

    public String createTable() {
        String table = "";
        for (TableRow tablerow : sortedRows) {
            table += tablerow.row[0] + tablerow.row[1] + tablerow.row[2]
                    + tablerow.row[3] + tablerow.row[4] + tablerow.row[5]
                    + tablerow.row[6] + "\n";
        }
        return table;
    }

    private class TableRow {

        Long teamId;
        String teamname;
        String[] row;
        int fullTimeWins;
        int losses;
        int overTimeLosses;
        int tied;
        int scoredGoals;
        int opponentScore;
        int overTimeWins;

        TableRow(Team team) {
            this.teamId = team.getDao().getLongId();
            this.teamname = team.getName();

            fullTimeWins = 0;
            losses = 0;
            overTimeLosses = 0;
            tied = 0;
            scoredGoals = 0;
            opponentScore = 0;
            overTimeWins = 0;

            for (Game game : allSeasonGames) {
                if ((game.getHomeTeam().getDao().getId() == teamId) && (game.getResult() != null)) {
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
                if ((game.getAwayTeam().getDao().getId() == teamId) && (game.getResult() != null)) {
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
            }

        }

        public int getPoints() {
            return 3 * fullTimeWins + 2 * overTimeWins + tied + overTimeLosses;
        }

        public void setRowColumns() {
            row = new String[7];
            row[0] = teamname;
            row[1] = " GP: " + (fullTimeWins + losses + tied);
            row[2] = " W: " + (fullTimeWins);
            row[3] = " T: " + (tied + overTimeWins + overTimeLosses);
            row[4] = " L: " + losses;
            row[5] = " " + scoredGoals + " - " + opponentScore + " ";
            row[6] = getPoints() + "p";
        }
    }
}
