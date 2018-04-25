/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

/**
 *
 * @author Veiret
 */
public class ShowTeamWinLossStatistics extends Service {
    private List<Long> teamId;
    ShowTeamWinLossStatistics(List<Long> teamIds) {
        this.teamId = teamId;
    }
    @Override
    public Object execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
