package com.project.core.player

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository

    @Override
    Player findPlayerById(Long playerId) {
        //We don't actually have to implement the 'findById()' method here. Hibernate automatically generates the needed SQL code
        //http://docs.spring.io/spring-data/jpa/docs/1.3.0.RELEASE/reference/html/jpa.repositories.html
        //Section 2.2.2 Query Creation
        Player player = playerRepository.findById(playerId)

        return player
    }

    @Override
    List<Player> getPlayersForTeam(Long teamId) {
        List<Player> players = playerRepository.findByTeamId(teamId)

        return players
    }

    @Override
    Long createPlayer(Player player) {
        Player savedPlayer = playerRepository.save(player)
        return savedPlayer.id
    }

    @Override
    def updatePlayer(Player player) {
        playerRepository.save(player)
    }

    @Override
    def deletePlayer(Long playerId) {
        playerRepository.delete(playerId)
    }


}
