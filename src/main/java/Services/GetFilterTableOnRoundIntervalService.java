/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import AssistantClasses.MakeTableFromGameList;
import AssistantClasses.MakeTableFromGameList.TableRow;
import Domain.Game;
import Domain.Season;
import Domain.Team;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Simon
 */
public class GetFilterTableOnRoundIntervalService extends Service {

    private final Long seasonId;
    private final int startRound;
    private final int endRound;
    List<Game> allSeasonGames;
    List<Team> allSeasonTeams;
    List<Game> intervalGames;
    List<Team> intervalTeams;

    public GetFilterTableOnRoundIntervalService(Long seasonId, int startRound, int endRound) {
        this.seasonId = seasonId;
        this.startRound = startRound;
        this.endRound = endRound;

        if (seasonId == null) {
            throw new ServiceException("seasonId cannot be null");
        }
        if (startRound < 0) {
            throw new ServiceException("startRound cannot be null");
        }
        if (endRound < 0) {
            throw new ServiceException("endRound cannot be null");
        }
    }

    @Override
    public List<TableRow> execute() {
        Game game;
        intervalGames = new ArrayList<>();
        intervalTeams = new ArrayList<>();
        if (getBrokerFactory().getSeasonBroker().findSeasonById(seasonId) == null) {
            throw new ServiceException("no season with given id");
        }

        GetAllGamesFromSeasonService getGameService = getBrokerFactory().getServiceBroker().getAllGamesFromSeasonService(seasonId);
        getGameService.init(getBrokerFactory());
        allSeasonGames = getGameService.execute();
        allSeasonTeams = getBrokerFactory().getSeasonBroker().getAllTeamsFromSeasonId(seasonId);
        for (int i = 0; i < allSeasonGames.size(); i++) {
            game = allSeasonGames.get(i);
            if (game.getRound().getRoundNumber() < 0 || game == null) {
                throw new ServiceException("GameRound is null");
            }
            if (game.getRound().getRoundNumber() <= endRound && game.getRound().getRoundNumber() >= startRound) {
                intervalGames.add(game);
            }
        }
        for (Team team : allSeasonTeams) {
            boolean contains = false;
            long teamId = (long) team.getDao().getLongId();

            for (Team addedTeam : intervalTeams) {
                long addedTeamId = (long) addedTeam.getDao().getLongId();
                contains = contains || (addedTeamId == teamId);
            }
            if (!contains) {
                intervalTeams.add(team);
            }
        }
        boolean[] conditions = new boolean[2];
        conditions[0] = true;
        conditions[1] = true;
        return new MakeTableFromGameList(intervalGames, intervalTeams, conditions).execute();
    }
}
