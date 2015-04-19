package com.project.web.tournament


import com.project.core.tournament.Tournament
import com.project.core.tournament.TournamentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import static org.springframework.http.HttpStatus.OK

@RestController
class TournamentController {
    @Autowired
    TournamentService tournamentService

    @RequestMapping(method = RequestMethod.GET, value = "/{version}/tournaments/{tournamentId}")
    def getTournamentDetails(@PathVariable String version, @PathVariable Long id){
        Tournament tournament = tournamentService.getFixturesForTournament(tournamentId)
        return tournament.jsonMap()
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{version}/tournaments")
    def createTournament(@PathVariable String version, @RequestBody(required = true) CreateTournamentRequest request) {
        Tournament tournament = new Tournament(name: request.name, location: request.location,  numPitches: request.numPitches, )
        Long tournamentId = tournamentService.createTournament(tournament)
        [
                id: tournamentId
        ]
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{version}/tournaments/{tournamentId}")
    def updateTournament(@PathVariable String version, @PathVariable Long tournamentId, @RequestBody(required = true) UpdateTournamentRequest request) {
        Tournament tournament = tournamentService.findTournamentById(tournamentId)
        if (tournament == null){
            //Do nothing for now - should throw some form of exception
        }

        tournament.name = request.name
        tournament.location = request.location
        tournament.numPitches = request.numPitches

        tournametService.updateTournament(tournament)

        return new ResponseEntity(OK)

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{version}/tournaments/{tournamentId}")
    def deleteTournament(@PathVariable String version, @PathVariable Long tournamentId) {
        Tournament tournament = tournamentService.findTournamentId(tournamentId)
        if (team == null){
            //Do nothing for now - should throw some form of exception
        }

        tournamentService.deleteTournament(tournamentId)

        return new ResponseEntity(OK)

    }


}





