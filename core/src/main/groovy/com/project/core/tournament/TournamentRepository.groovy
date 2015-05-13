package com.project.core.tournament
/**
 * Created by smeehan on 03/04/15.
 */
import org.springframework.data.jpa.repository.JpaRepository


public interface TournamentRepository extends JpaRepository<Tournament,Long>{
    Tournament findByname(String name)
    Tournament findByid(Long id)

}