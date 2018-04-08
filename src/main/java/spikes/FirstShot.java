package spikes;

import Domain.Game;
import Services.GetAllSportService;
import Services.ServiceRunner;
import Domain.Sport;
import Services.GetTeamsMatchHistoryService;
import java.util.List;
import org.javalite.activejdbc.Base;

/**
 *
 * @author thomas
 */
public class FirstShot {

    public static void main(String[] args) {
        //open();
        /*
        List<Sport> sports = Sport.findAll();
        System.out.println("Antal tillgängliga sporter: " + sports.size());
        Sport newSport = new Sport();
        newSport.setName("Quidditch");
        newSport.save();
        sports = Sport.findAll();
        System.out.println("Antal tillgängliga sporter: " + sports.size());
        System.out.println("Den första heter: " + sports.get(0).getName());
        System.out.println("Den sista heter: " + sports.get(sports.size() - 1).getName());
        newSport.delete();
        sports = Sport.findAll();
        System.out.println("Antal tillgängliga sporter: " + sports.size());
        */        

        //System.out.println("hej");
        //close();
//        System.out.println("HEJ");
//        
//            ServiceRunner runner = new ServiceRunner(new GetAllSportService());
//            System.out.println("sSPORTEEEEER: " + runner.execute());
//        
        
        
        List<Game> listOfGames = (List<Game>) (new ServiceRunner<>(new GetTeamsMatchHistoryService(1L, 2L)).execute());
    }

    public static void open() {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://node71227-grupp2.jls-sto1.elastx.net:11068/mydb", "grupp2", "Nilgo4QTZeNT702L");
    }
    
    public static void close() {
        Base.close();
    }
}
