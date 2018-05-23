/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Domain.Game;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simon
 */
public class ShowArenaPercentAndTeamGoalsOnDateInterval extends Service {

    private final Long arenaId;
    private final Long seasonId;
    private final Integer startDate;
    private final Integer endDate;

    public ShowArenaPercentAndTeamGoalsOnDateInterval(Long arenaId, Long seasonId, Integer startDate, Integer endDate) {
        this.arenaId = arenaId;
        this.seasonId = seasonId;
        this.startDate = startDate;
        this.endDate = endDate;
        if (arenaId == null) {
            throw new ServiceException("arenaId cannot be null");
        }
        if (seasonId == null) {
            throw new ServiceException("seasonId cannot be null");
        }
        if (startDate == null) {
            throw new ServiceException("startDate cannot be null");
        }
        if (endDate == null) {
            throw new ServiceException("endDate cannot be null");
        }
    }

    @Override
    public List<String> execute() {
        List<String> listOfStrings = new ArrayList<>();
        double arenaPercent = 0;
        int totalSpectators = 0;
        int gameSpectators = 0;
        double arenaCapacityOnGame = 0;
        double arenaPercentOnGame = 0;
        double arenaCapacity = 0;
        String arenaName = "";
        int hScore = 0;
        int aScore = 0;
        int numberOfGames = 0;
        String homTeam = "";
        String awayTeam = "";
        List<Game> allGamesForOneArena = getBrokerFactory().getArenaBroker().getAllGamesForOneArena(arenaId);
        List<Game> allGamesForOneArenaInOneSeason = new ArrayList<>();

        for (int i = 0; i < allGamesForOneArena.size(); i++) {
            Game game = allGamesForOneArena.get(i);
            if (game.getRound().getDao().getLong("season_id").longValue() == seasonId) {
                allGamesForOneArenaInOneSeason.add(game);
            }
        }

        for (int i = 0; i < allGamesForOneArenaInOneSeason.size(); i++) {
            Game game = allGamesForOneArenaInOneSeason.get(i);
            if (game.getSpectators() != null) {
                if (game.getDate() >= startDate && game.getDate() <= endDate) {
                    totalSpectators += game.getSpectators();
                    gameSpectators = game.getSpectators();
                    arenaCapacityOnGame = game.getArena().getMaxCapacity();
                    arenaCapacity += game.getArena().getMaxCapacity();
                    hScore = game.getResult().getHomeScore();
                    aScore = game.getResult().getAwayScore();
                    numberOfGames++;
                    homTeam = game.getHomeTeam().getName();
                    awayTeam = game.getAwayTeam().getName();
                    arenaName = game.getArena().getArenaName();
                    arenaPercentOnGame = (gameSpectators / arenaCapacityOnGame) * 100;
                    String st = "\n" + "Game:" + numberOfGames + " Arena: " + arenaName + " ArenaPercent on this game: "
                            + arenaPercentOnGame + " HomeTeam: " + homTeam + " HomeScore: " + hScore + " AwayTeam: " + awayTeam
                            + " AwayScore: " + aScore;
                    listOfStrings.add(st);
                    st = "";
                }
            }

        }
        arenaPercent = (totalSpectators / arenaCapacity) * 100;

        return listOfStrings;
    }

}
