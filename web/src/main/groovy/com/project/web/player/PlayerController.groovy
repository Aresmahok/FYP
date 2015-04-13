package com.project.web.player

import com.project.core.player.Player
import com.project.core.player.PlayerService
import com.project.core.team.Team
import com.project.core.team.TeamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import static org.springframework.http.HttpStatus.OK

/*
    Controller for managing players (Creating, updating etc)
 */

//Let Spring know that this is a RestController
@RestController
class PlayerController {


    /*
    We use the @Autowired annotation to allow spring to handle our dependency injection for us.
    Traditionally, if you wanted to use an instance of a PlayerService, you would do something like :

    PlayerService playerService = new PlayerService()
    playerService.doSomeAction()

    If we use the Autowired annotation, this becomes

    @Autowired
    PlayerService playerService

    Then whenever we want to use the playerService, we simply call it directly with playerService.doSomething()
     */
    @Autowired
    PlayerService playerService

    @Autowired
    TeamService teamService

    /*
    maps to http://localhost:8080/v1/players/1
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{version}/teams/{teamId}/players/{playerId}")
    def getPlayerDetails(@PathVariable String version, @PathVariable Long playerId){
        Player player = playerService.findPlayerById(playerId)

        return player.jsonMap()
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{version}/teams/{teamId}/players")
    def getPlayersForTeam(@PathVariable String version, @PathVariable Long teamId){
        List<Player> players = playerService.getPlayersForTeam(teamId)

        /*
         NB regarding the line: players.collect { it.jsonMap() }

         This is called a closure. This is a very simple example, they can be much more complicated. In essence, a closure is simply a piece of anonymous
         code that can take some arguments and give a return value.

         players.collect is essentially the same as:

         for (Player player : players){
         }

         - It just loops through the players collection

         It then calls it.jsonMap on each object it iterates over - which in the end results in it looping through the players
         collection and calling player.jsonMap() on each player
         */

        [
                players : players.collect { it.jsonMap() },
        ]
    }


    /*
    Create a player
     */
    @RequestMapping(method = RequestMethod.POST, value = "/{version}/teams/{teamId}/players")
    def createPlayer(@PathVariable String version, @PathVariable Long teamId, @RequestBody(required = true) CreatePlayerRequest request) {
        Team team = teamService.findTeamById(teamId)
        if (team == null){
            //Do nothing for now - should throw some form of exception
        }
        Player player = new Player(firstName: request.firstName, lastName: request.lastName, team: team, playerNumber: request.playerNumber)

        Long playerId = playerService.createPlayer(player)

        [
                id: playerId
        ]
    }

    /*
  Create multiple players
  Sample json

  {"players":[
    {
    "firstName": "bob",
    "lastName": "bob",
   "playerNumber": 1
    },
   {
   "firstName": "bob2",
    "lastName": "bob2",
   "playerNumber": 2
    },
   {
 	"firstName": "bob3",
    "lastName": "bob3",
   "playerNumber": 3
    },
  ]
 }



*/
    @RequestMapping(method = RequestMethod.POST, value = "/{version}/teams/{teamId}/multipleplayers")
    def createPlayerRequest(@PathVariable String version, @PathVariable Long teamId, @RequestBody(required = true) CreateMultiplePlayersRequest request) {
        Team team = teamService.findTeamById(teamId)
        if (team == null){
            //Do nothing for now - should throw some form of exception
        }

        List<Long> playerIds = new ArrayList()
        for (CreatePlayerRequest playerRequest : request.requestList) {
            Player player = new Player(firstName: playerRequest.firstName, lastName: playerRequest.lastName, team: team, playerNumber: playerRequest.playerNumber)

            Long playerId = playerService.createPlayer(player)
            playerIds.add(playerId)

        }

        [
                id: playerIds.collect{ it.toString() },
        ]
    }

    /*
    Update a player
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{version}/teams/{teamId}/players/{playerId}")
    def updatePlayer(@PathVariable String version, @PathVariable Long teamId, @PathVariable Long playerId, @RequestBody(required = true) UpdatePlayerRequest request) {
        Team team = teamService.findTeamById(teamId)
        if (team == null){
            //Do nothing for now - should throw some form of exception
        }

        Player player = playerService.findPlayerById(playerId)

        player.firstName = request.firstName
        player.lastName = request.lastName
        player.playerNumber = request.playerNumber
        playerService.updatePlayer(player)

        return new ResponseEntity(OK)

    }

    /*
    Delete a player
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{version}/teams/{teamId}/players/{playerId}")
    def deletePlayer(@PathVariable String version, @PathVariable Long teamId, @PathVariable Long playerId) {
        Team team = teamService.findTeamById(teamId)
        if (team == null){
            //Do nothing for now - should throw some form xof exception
        }

        Player player = playerService.findPlayerById(playerId)
        if (player == null) {
            //throw 'player not found' exception
        }

        playerService.deletePlayer(playerId)

        return new ResponseEntity(OK)

    }
}
