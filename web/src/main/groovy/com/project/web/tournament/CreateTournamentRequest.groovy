package com.project.web.tournament

import com.project.core.game.Game
import com.project.core.pitch.Pitch
import com.project.core.team.Team
import org.hibernate.validator.constraints.NotBlank

import javax.persistence.CascadeType
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

/**
 * Created by smeehan on 13/04/15.
 */
class CreateTournamentRequest {
    @NotBlank
    String name

    @NotBlank
    Long numPitches

    String location
    Set<Team> teams
    Set<Pitch> pitches
    Set<Game> pool_1
    Set<Game> pool_2
    Set<Game> pool_3
    Set<Game> pool_4

    @OneToMany (cascade = CascadeType.ALL, mappedBy = 'fixtures', fetch = FetchType.EAGER)
    @JoinColumn(name = 'tournament_id')
    Set<Game> fixtures



    def jsonMap(){ //key : value
        return [
                id      : id,
                name    : name,
                location    : location,
                fixtures : fixtures,
                numPitches : numPitches,
                pool_1 : pool_1,
                pool_2 : pool_2,
                pool_3 : pool_3,
                pool_4 : pool_4,

        ]
    }
}

