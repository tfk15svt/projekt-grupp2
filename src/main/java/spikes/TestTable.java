/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spikes;

import Services.ServiceRunner;
import Services.ShowTableWithDynamicFiltersService;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Veiret
 */
public class TestTable {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        list.add(64L);
        System.out.println("" + new ServiceRunner(new ShowTableWithDynamicFiltersService(list)).execute());
    }
}
