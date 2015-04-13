package com.project.core.player

import org.springframework.data.jpa.repository.JpaRepository

public interface PlayerRepository extends JpaRepository<Player, Long> { //call hibernate query language, subset of sql jpa is interface between java and database
    Player findById(Long id)

    List<Player> findByTeamId(Long teamId)
}
