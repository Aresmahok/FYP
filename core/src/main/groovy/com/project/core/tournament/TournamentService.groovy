package com.project.core.tournament

/**
 * Service for managing tournaments (Creating them, updating etc)
 */
interface TournamentService {
    Tournament findTournamentByName(String name)
    Long createTournament(Tournament tournament)
    def getFixturesForTournament(Long tournamentId)
    def updateTournament(Tournament tournament)
    def deleteTournament(Long id)
}
