package com.project.core.team

import com.project.core.player.Player

import javax.persistence.Entity

/**
 * Created by ares on 09/03/15.
 */
class Team {
    List<Player> theTeam //which type of list would be most appropriate
    String teamName //e.g. Trinity College Dublin
    String shortHand //would translate to TCD
    int initialSeeding
    int currentSeeding

    Player captain //maybe extend the com.project.web.player class with a captain


    String coach  //if applicable
    int SpritScores
}
