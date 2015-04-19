package com.project.core.tournament

import com.project.core.game.Game
import com.project.core.pitch.Pitch
import com.project.core.team.Team
import org.hibernate.annotations.GenericGenerator

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

/**
 * Created by ares on 09/03/15.
 */
@Entity
class Tournament {
    @Id
    @GeneratedValue(generator = "pooled")
    @GenericGenerator(name = "pooled", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = [
            @org.hibernate.annotations.Parameter(name = "value_column_name", value = "sequence_next_hi_value"),
            @org.hibernate.annotations.Parameter(name = "prefer_entity_table_as_segment_value", value = "true"),
            @org.hibernate.annotations.Parameter(name = "optimizer", value = "pooled"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "100"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "100")])


    Long id
    Set<Team> teams
    String name
    Long numPitches
    Set<Pitch> pitches
    String location
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
                teams    : teams,
                numPitches : numPitches,
                fixtures : fixtures, //S
                pitches : pitches,
                name : name,
                location    : location
        ]
    }
}

/*
    boolean addTeam(){}
    boolean addPlayer(){}
    boolean addPitches(){}
    boolean setTournamentLength(){}
    boolean initializeSeedings(){}
    boolean initializeTournament(){}
*/



