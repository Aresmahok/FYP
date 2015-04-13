package com.project.core.tournament

import com.project.core.game.Game
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class TournamentServiceImpl implements TournamentService {
    @Autowired
    TournamentRepository tournamentRepository

    @Override
    Tournament findTournamentByName(String name) {
        Tournament tournament = tournamentRepository.findByName(name);
        return tournament
    }

    @Override
    List<Game> getFixturesForTournament(Long tournamentId){
        List<Game> fixtures = TournamentRepository.FindBytournamentId();
        return fixtures
    }
    @Override
    Long createTournament(Tournament tournament) {
        Tournament savedTournament = tournamentRepository.save(tournament)
        return savedTournament.id
    }

    @Override
    def updateTournament(Tournament tournament) {
        return null
    }

    @Override
    def deleteTournament(Long id) {
        return null
    }
}
