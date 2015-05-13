package com.project.core.tournament

import com.project.core.game.Game
import com.project.core.team.Team
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.transaction.Transactional


@Service
@Transactional
class TournamentServiceImpl implements TournamentService {
    @Autowired
    TournamentRepository tournamentRepository

    @Override
    Tournament findTournamentById(Long id) {
        Tournament tournament = tournamentRepository.findByid(id)

        return tournament
    }

    @Override
    Tournament findTournamentByName(String name) {
        Tournament tournament = tournamentRepository.findByname(name);
        return tournament
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
