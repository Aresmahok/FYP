package com.project.core.tournament


import org.springframework.data.jpa.repository.JpaRepository


public interface TournamentRepository extends JpaRepository<Tournament,Long>{
    Tournament findByname(String name)
    Tournament findBytournamentId(Long id)

}