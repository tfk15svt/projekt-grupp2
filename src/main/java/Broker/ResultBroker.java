/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import DAO.GameDao;
import DAO.ResultDao;
import Domain.Result;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Simon
 */
public class ResultBroker {
    
    public void saveResult(Result result){
        ResultDao resultDao = result.getDao();
        resultDao.save();
    }
    /**
     *
     * @return
     */
    public Result create() {
        return new Result();
    }

    public Result getBiggestDifferensBetweenTwoTeams(Long teamId1, Long teamId2) {
        Result result = null;
        int biggestDifference = -1;
        ResultDao resultDao;

        List<GameDao> listOfGameDaos1 = GameDao.where("home_team_id=? and away_team_id=?", teamId1, teamId2);
        List<GameDao> listOfGameDaos2 = GameDao.where("home_team_id=? and away_team_id=?", teamId2, teamId1);
        List<GameDao> listOfGames = Stream.concat(listOfGameDaos1.stream(), listOfGameDaos2.stream()).collect(Collectors.toList());

        for (GameDao dao : listOfGames) {
            if (dao.getAll(ResultDao.class).size() != 0) {
                if (biggestDifference < 0) {
                    resultDao = dao.getAll(ResultDao.class).get(0);
                    result = new Result(resultDao);
                    biggestDifference = Math.abs(result.getAwayScore() - result.getHomeScore());
                } else {
                    ResultDao resultDao1 = dao.getAll(ResultDao.class).get(0);
                    Result result1 = new Result(resultDao1);
                    int diff = Math.abs(result1.getAwayScore() - result1.getHomeScore());
                    if(diff > biggestDifference){
                        biggestDifference = diff;
                        resultDao = resultDao1;
                        result = result1;
                    }
                }
            }
        }
    
        return result;
    }
    public Result findByGameId(Long gameId){
         try {
             return new Result((ResultDao) ResultDao.find("game_id=?", gameId).get(0));
         } catch (Exception ex){
           
            ex.getMessage();
            return create();
         }
//        return new Result((ResultDao) ResultDao.find("game_id=?", gameId).get(0));
//        return new Result(ResultDao.findById(dao);
    }
}