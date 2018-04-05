/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Domain.Arena;
import Domain.Game;

/**
 *
 * @author Simon
 */
public class AddMetaInfoToGameService extends Service{
    Long gameId;
    Long arenaId;
    int spectators;
    Game game;

    public AddMetaInfoToGameService(Long gameId, Long arenaId, int spectators){
        this.gameId = gameId;
        this.arenaId = arenaId;
        this.spectators = spectators;
        
        if(gameId == null){
            throw new ServiceException("GameId cannot be null.");
        }
        if(arenaId == null){
            throw new ServiceException("arenaId cannot be null.");
        }
        if(spectators<0 && spectators > 100000){
            throw new ServiceException("invalid spectators");
        }
        
        
    }

    @Override
    public Game execute() {
        Game newGame = getBrokerFactory().getGameBroker().findById(gameId);
        Arena arena = getBrokerFactory().getArenaBroker().findById(arenaId);
        newGame.setArena(arena);
        newGame.setSpectators(spectators);
        newGame.getDao().save();
        
        return newGame;
    }
    
    
}
