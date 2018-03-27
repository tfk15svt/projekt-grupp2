package spikes;

import com.mycompany.sportstatsveiret.Sport;
import java.util.List;
import org.javalite.activejdbc.Base;

/**
 *
 * @author thomas
 */
public class FirstShot {

    public static void main(String[] args) {
        open();
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

        System.out.println("hej");
        close();
    }

    public static void open() {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/mydb", "veiret_sql", "paronplommon378");
    }
    
    public static void close() {
        Base.close();
    }
}
