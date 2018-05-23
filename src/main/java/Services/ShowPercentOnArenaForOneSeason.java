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
public class ShowPercentOnArenaForOneSeason extends Service {

    private Long seasonId;
    private Long arenaId;

    public ShowPercentOnArenaForOneSeason(Long seasonId, Long arenaId) {
        this.seasonId = seasonId;
        this.arenaId = arenaId;

        if (seasonId == null) {
            throw new ServiceException("seasonID cannot be null");
        }
        if (arenaId == null) {
            throw new ServiceException("arenaId cannot be null");
        }
    }

    @Override
    public String execute() {
        double arenaPercent = 0;
        int totalSpectators = 0;
        double arenaCapacity = 0;
        String arenaName = "";
        List<Game> allGamesForOneArena = getBrokerFactory().getArenaBroker().getAllGamesForOneArena(arenaId);
        List<Game> listOfSeasonGames = new ArrayList<>();

        for (int i = 0; i < allGamesForOneArena.size(); i++) {
            Game game = allGamesForOneArena.get(i);
            if (game.getRound().getDao().getLong("season_id").longValue() == seasonId) {
                listOfSeasonGames.add(game);
            }
        }

        for (int j = 0; j < listOfSeasonGames.size(); j++) {
            Game game = listOfSeasonGames.get(j);
            if (game.getSpectators() != null) {
                totalSpectators += game.getSpectators();
                arenaCapacity += game.getArena().getMaxCapacity();
            }
            arenaName = game.getArena().getArenaName();
        }

        arenaPercent = (totalSpectators / arenaCapacity) * 100;

        String finalString = "Arena: " + arenaName + ", " + arenaPercent + "% this season.";
        return finalString;
    }
}
