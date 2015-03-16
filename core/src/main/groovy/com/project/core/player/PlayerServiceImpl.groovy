package com.project.core.player

import com.project.core.team.Team
import org.springframework.stereotype.Service

@Service
class PlayerServiceImpl implements PlayerService {

    @Override
    Player getPlayerById(Long playerId) {
        //insert hibernate/jpa repo interface here to query an actual db for a player - mock it for now


        //mock player
        Team team = new Team(teamName: "The Shams")
        Player player = new Player(id: 420, name: "Howard", playerNumber: 69, team: team )

        return player
    }
}
