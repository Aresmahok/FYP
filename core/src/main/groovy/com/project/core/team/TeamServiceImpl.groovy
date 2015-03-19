package com.project.core.team

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository

    @Override
    Team findTeamById(Long id) {
        Team team = teamRepository.findById(id)

        return team
    }

    @Override
    Long createTeam(Team team) {
        Team newTeam = teamRepository.save(team)

        return newTeam.id
    }

    @Override
    def updateTeam(Team team) {
        teamRepository.save(team)
    }

    @Override
    def deleteTeam(Long id) {
        teamRepository.delete(id)
    }
}
