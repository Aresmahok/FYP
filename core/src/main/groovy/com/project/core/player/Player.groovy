package com.project.core.player

import com.project.core.team.Team
import org.hibernate.annotations.GenericGenerator

import javax.persistence.*


/**
 * Created by ares on 09/03/15.
 */

//The Entity annotation lets JPA know to pick up this class and map it
@Entity //must have an id
class Player {
    //Anytime you annotate a class with @Entity, it *must* contain an id
    //These annotations take care of assigning ID's to new objects (Players in this case) so we don't have to worry about it
    @Id
    @GeneratedValue(generator = "pooled")
    @GenericGenerator(name = "pooled", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = [
            @org.hibernate.annotations.Parameter(name = "value_column_name", value = "sequence_next_hi_value"),
            @org.hibernate.annotations.Parameter(name = "prefer_entity_table_as_segment_value", value = "true"),
            @org.hibernate.annotations.Parameter(name = "optimizer", value = "pooled"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "100")])
    Long id
    //copy and paste these every time you use something to be created/used in database
    // The names below are valid because they share the names with the colums in the db
    String firstName
    String lastName
    Long playerNumber


    //There will be many players on a team, so we annotate with @ManyToOne
    //FetchType.EAGER tells Hibernate that whenever it loads a Player object from the DB, it should load the players team along with it (even if the team object is never accessed)
    //If we use FetchType.LAZY, then Hibernate will only load the team when it is explicitly accessed  (eg - when player.getTeam() is called)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = 'team_id')
    Team team


    //We like to provide a jsonMap method for all classes that will returned as JSON at some stage
    def jsonMap(){
        return [
                name    : firstName + " " +  lastName,
                playerNumber : playerNumber,
                team    : team.name
        ]
    }

    /*
    NB - because we're using Groovy, there is no need to include getters and setters - groovy provides these to us automatically
     */
}
