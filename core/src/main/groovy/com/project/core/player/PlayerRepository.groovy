package com.project.core.player

import org.springframework.data.jpa.repository.JpaRepository

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findById(Long id)

    List<Player> findByTeamId(Long teamId)
}
