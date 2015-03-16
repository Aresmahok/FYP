package com.project.core.player

import com.project.core.team.Team

/**
 * Created by ares on 09/03/15.
 */
class Player {
    Long id
    String name
    String playerNumber
    Team team

    def jsonMap(){
        return [
                name    : name,
                playerNumber : playerNumber,
                team    : team.getTeamName()
        ]
    }



}
