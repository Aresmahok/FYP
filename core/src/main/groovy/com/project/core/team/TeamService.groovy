package com.project.core.team
/**
 * Service for managing teams (Creating them, adding players etc)
 */
interface TeamService {

    Team findTeamById(Long id)

    Long createTeam(Team team)

    def updateTeam(Team team)

    def deleteTeam(Long id)
}
