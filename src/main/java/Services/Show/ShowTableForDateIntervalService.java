/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Show;

import AssistantClasses.GetTeamsFromListOfGames;
import AssistantClasses.MakeTableFromGameList;
import AssistantClasses.MakeTableFromGameList.TableRow;
import Domain.Game;
import Services.Service;
import java.util.List;

/**
 *
 * @author Veiret
 */
public class ShowTableForDateIntervalService extends Service{
    private final Long leagueId;
    private final int startDate;
    private final int endDate;
    public ShowTableForDateIntervalService (Long leagueId, int startDate, int endDate) {
        this.leagueId = leagueId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    @Override
    public List<TableRow> execute() {
        List<Game> listGames = getBrokerFactory().getLeagueBroker().getGamesWithinDateInterVal(leagueId, startDate, endDate);
        GetTeamsFromListOfGames getTeams = new GetTeamsFromListOfGames(listGames);
        getTeams.init(getBrokerFactory());
        boolean[] conditions = new boolean[2];
        conditions[0] = true;
        conditions[1] = true;
        return new MakeTableFromGameList(listGames, getTeams.execute(), conditions).execute(); 
    }
    
}
