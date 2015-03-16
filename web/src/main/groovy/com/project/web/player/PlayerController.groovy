package com.project.web.player

import com.project.core.player.Player
import com.project.core.player.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/*
    Controller for managing players (Creating, updating etc)
 */
@Controller
class PlayerController {

    @Autowired
    PlayerService playerService

    /*
    maps to http://localhost:8080/v1/players/1
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{version}/players/{playerId}")
    @ResponseBody
    def getPlayerDetails(@PathVariable String version, @PathVariable Long playerId){

        Player player = playerService.getPlayerById(playerId)

        return player.jsonMap()
    }
}
