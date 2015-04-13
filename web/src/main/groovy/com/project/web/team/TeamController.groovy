package com.project.web.team

import com.project.core.team.Team
import com.project.core.team.TeamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import static org.springframework.http.HttpStatus.OK

@RestController //this manages http requests post put get and
class TeamController {

    @Autowired
    TeamService teamService

    /*
    Return the team details
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{version}/teams/{teamId}")
    def getTeamDetails(@PathVariable String version, @PathVariable Long teamId){
        Team team = teamService.findTeamById(teamId)

        return team.jsonMap()
    }

    /*
    Create a new team
     */
    @RequestMapping(method = RequestMethod.POST, value = "/{version}/teams")
    def createTeam(@PathVariable String version, @RequestBody(required = true) CreateTeamRequest request) {
        Team team = new Team(name: request.name, shortHandName: request.shortHandName)
        Long teamId = teamService.createTeam(team)

        [
                id: teamId
        ]
    }

    /*
    Update a teams details
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{version}/teams/{teamId}")
    def updateTeam(@PathVariable String version, @PathVariable Long teamId, @RequestBody(required = true) UpdateTeamRequest request) {
        Team team = teamService.findTeamById(teamId)
        if (team == null){
            //Do nothing for now - should throw some form of exception
        }

        team.name = request.name
        team.shortHandName = request.shortHandName
        team.currentSeeding = request.currentSeeding
        team.spiritScore = request.spiritScore

        teamService.updateTeam(team)

        return new ResponseEntity(OK)

    }

    /*
    Delete a team
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{version}/teams/{teamId}")
    def deleteTeam(@PathVariable String version, @PathVariable Long teamId) {
        Team team = teamService.findTeamById(teamId)
        if (team == null){
            //Do nothing for now - should throw some form of exception
        }

        teamService.deleteTeam(teamId)

        return new ResponseEntity(OK)

    }
}
