/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import Domain.Game;
import Services.ServiceException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Veiret
 */
public class FilterGamesWithinRoundInterval {
    private final List<Game> games;
    private final int startRound, endRound;
    public FilterGamesWithinRoundInterval(List<Game> games, int startRound, int endRound) {
        this.games = games;
        if (games == null) {
            throw new ServiceException("Gamelist is null");
        }
        this.startRound = startRound;
        if (startRound < 0) {
            throw new ServiceException("startRound is invalid");
        }
        this.endRound = endRound;
        if (endRound < 0) {
            throw new ServiceException("endRound is invalid");
        }
    }
    public List<Game> execute () {
        return games.stream().filter(game -> 
                game.getRound().getRoundNumber() <= endRound && 
                game.getRound().getRoundNumber() >= startRound)
                .collect(Collectors.toList());
    }
}
