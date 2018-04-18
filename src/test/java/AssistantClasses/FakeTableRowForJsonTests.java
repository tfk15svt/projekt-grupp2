/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssistantClasses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author Veiret
 */
@JsonPropertyOrder({ "teamName", "gamesPlayed", "fullTimeWins", "tied", "losses", "scoredGoals", "opponentScore", "points" })
public class FakeTableRowForJsonTests {
    private String teamnamePub;
    private int gamesPlayedPub;
    private int fullTimeWinsPub;
    private int tiedPub;
    private int lossesPub;
    private int scoredGoalsPub;
    private int opponentScorePub;
    private int pointsPub;

    public void setTeamname(String teamName) {
        this.teamnamePub = teamName;
    }
    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayedPub = gamesPlayed;
    }
    public void setFullTimeWins(int fullTimeWins) {
        this.fullTimeWinsPub = fullTimeWins;
    }
    public void setTied(int tied) {
        this.tiedPub = tied;
    }
    public void setLosses(int losses) {
        this.lossesPub = losses;
    }
    public void setOpponentScore(int opponentScore) {
        this.opponentScorePub = opponentScore;
    }
    public void setScoredGoals(int scoredGoals) {
        this.scoredGoalsPub = scoredGoals;
    }
    public void setPoints(int points) {
        this.pointsPub = points;
    }
    
    public String getTeamName() {
        return teamnamePub;
    }

    public int getGamesPlayed() {
        return gamesPlayedPub;
    }

    public int getFullTimeWins() {
        return fullTimeWinsPub;
    }

    public int getTied() {
        return tiedPub;
    }

    public int getLosses() {
        return lossesPub;
    }

    public int getScoredGoals() {
        return scoredGoalsPub;
    }

    public int getOpponentScore() {
        return opponentScorePub;
    }

    public int getPoints() {
        return pointsPub;
    }
    
    
}
