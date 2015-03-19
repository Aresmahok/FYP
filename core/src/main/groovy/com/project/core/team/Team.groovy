package com.project.core.team

import com.project.core.player.Player
import org.hibernate.annotations.GenericGenerator

import javax.persistence.*


/**
 * Created by ares on 09/03/15.
 */
@Entity
class Team {
    @Id
    @GeneratedValue(generator = "pooled")
    @GenericGenerator(name = "pooled", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = [
            @org.hibernate.annotations.Parameter(name = "value_column_name", value = "sequence_next_hi_value"),
            @org.hibernate.annotations.Parameter(name = "prefer_entity_table_as_segment_value", value = "true"),
            @org.hibernate.annotations.Parameter(name = "optimizer", value = "pooled"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "100"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "100")])
    Long id

    //Annotate with @OneToMany because a one team will have multiple players
    //CascadeType.ALL tells hibernate that when a team is deleted, it should perform a cascading delete ie. when deleting a team, it should also delete all the teams players
    //FetchType.LAZY  tells hibernate to only load the players of a team when they are explicitly accessed ( eg when team.getPlayers() is called )
    @OneToMany (cascade = CascadeType.ALL, mappedBy = 'team', fetch = FetchType.LAZY)
    Set<Player> players

    String name
    String shortHandName

    Long initialSeeding
    Long currentSeeding
    Long spiritScore

    def jsonMap(){
        return [
                id      : id,
                name    : name,
                shortHandName : shortHandName,
                initialSeeding : initialSeeding,
                currentSeeding : currentSeeding,
                spiritScore    : spiritScore
        ]
    }
}
