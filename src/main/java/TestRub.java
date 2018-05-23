/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Veiret
 */
import Services.Show.ShowTableWithDynamicFiltersService;
import Services.*;
import java.util.ArrayList;
import java.util.List;
public class TestRub {
    private static void main (String[] args) {
     List<Long> list = new ArrayList<>();
    
    System.out.println("" + new ServiceRunner(new ShowTableWithDynamicFiltersService(list)).execute());   
    }
    
}
