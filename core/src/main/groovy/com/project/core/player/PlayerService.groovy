package com.project.core.player

/**
 * Service to manage players
 */
interface PlayerService {

    Player findPlayerById(Long id)

    Long createPlayer(Player player)

    def createMultiplePlayers(List<Player> players)

    def updatePlayer(Player player)

    def deletePlayer(Long id)

    List<Player> getPlayersForTeam(Long teamId)
}
