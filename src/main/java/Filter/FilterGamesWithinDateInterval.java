/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import DAO.GameDao;
import Domain.Game;
import Services.ServiceException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Veiret
 */
public class FilterGamesWithinDateInterval {

    private final List<Game> games;
    private final int startDate, endDate;

    public FilterGamesWithinDateInterval(List<Game> gameList, int startDate, int endDate) {
        this.games = gameList;
        if (games == null) {
            throw new ServiceException("Gamelist is null");
        }
        this.startDate = startDate;
        if (startDate < 0) {
            throw new ServiceException("Stardate is invalid");
        }
        this.endDate = endDate;
        if (endDate < 0) {
            throw new ServiceException("Enddate is invalid");
        }
    }

    public List<Game> execute() {
        return games.stream().filter(game
                -> endDate >= game.getDate()
                && game.getDate() >= startDate)
                .collect(Collectors.toList());
    }
}
