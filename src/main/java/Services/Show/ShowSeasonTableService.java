/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Show;

import Services.Get.GetAllGamesFromSeasonService;
import AssistantClasses.MakeTableFromGameList;
import AssistantClasses.MakeTableFromGameList.TableRow;
import Domain.Game;
import Domain.Team;
import Services.Service;
import Services.ServiceException;
import java.util.List;

/**
 *
 * @author Veiret
 */
public class ShowSeasonTableService extends Service {
    private final Long seasonId;
    List<Game> allSeasonGames;
    List<Team> allSeasonTeams;
    public ShowSeasonTableService (Long seasonId) {
        this.seasonId = seasonId;
        if (seasonId == null) {
            throw new ServiceException("Season id is null");
        }
    }

    @Override
    public List<TableRow> execute() {
        GetAllGamesFromSeasonService getGamesService = getBrokerFactory().getServiceBroker().getAllGamesFromSeasonService(seasonId);
        getGamesService.init(getBrokerFactory());
        allSeasonGames = getGamesService.execute();
        allSeasonTeams = getBrokerFactory().getSeasonBroker().getAllTeamsFromSeasonId(seasonId);
        boolean[] conditions = new boolean[2];
        conditions[0] = true;
        conditions[1] = true;
        return new MakeTableFromGameList(allSeasonGames, allSeasonTeams, conditions).execute();
    }
    
}
