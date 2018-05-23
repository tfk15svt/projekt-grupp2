/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import Services.Get.GetAllGamesFromSeasonService;
import Services.Service;
import Services.ServiceRunner;

/**
 *
 * @author Veiret
 */
public class ServiceBroker {
    
    public ServiceRunner getServiceRunner(Service service){
        return new ServiceRunner(service);
    }
    public GetAllGamesFromSeasonService getAllGamesFromSeasonService(Long seasonId) {
        return new GetAllGamesFromSeasonService(seasonId);
    }
}
