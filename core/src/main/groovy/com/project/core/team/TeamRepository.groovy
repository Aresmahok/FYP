package com.project.core.team

import org.springframework.data.jpa.repository.JpaRepository


public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findById(Long id)
}
