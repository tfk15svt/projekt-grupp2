package spikes;

import Broker.BrokerFactory;
import Domain.Game;
import Domain.Result;
import Services.GetAllSportService;
import Services.ServiceRunner;
import Domain.Sport;
import Services.AddGameService;
import Services.AddResultToGameService;
import Services.AddSeasonToLeagueService;
import Services.GetAllLossesForTeamService;
import Services.GetAllWinsForTeamService;
import Services.GetGameResultInfoService;
import Services.GetTeamsMatchHistoryService;
import Services.Service;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.javalite.activejdbc.Base;

/**
 *
 * @author thomas
 */
public class FirstShot {

    public static void main(String[] args) {
        
//        new ServiceRunner<>(new AddResultToGameService(1, 1, 22L)).execute();
        
//        new ServiceRunner<>(new AddGameService(3L, 1L, 2L)).execute();
//        List<Game> listOfGames = (List<Game>) (new ServiceRunner<>(new GetTeamsMatchHistoryService(1L, 2L)).execute());
//          new ServiceRunner<>(new AddSeasonToLeagueService(1, 2L)).execute();
          List<Game> listOfLostGames;
//          System.out.println(listOfLostGames = (List<Game>) new ServiceRunner<>(new GetAllLossesForTeamService(0L)).execute());
//          System.out.println(listOfLostGames.get(0).getResult());
          System.out.println(new ServiceRunner(new GetGameResultInfoService(0L)).execute());

          
    }

    public static void open() {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://node71227-grupp2.jls-sto1.elastx.net:11068/mydb", "grupp2", "Nilgo4QTZeNT702L");
    }
    
    public static void close() {
        Base.close();
    }
}
