package com.project.core.tournament

import com.project.core.game.Game

import javax.persistence.Entity

/**
 * Created by ares on 09/03/15.
 */
class Tournament {
    List<Game> fixtures
    String name

    boolean addTeam(){}
    boolean addPlayer(){}
    boolean addPitches(){}
    boolean setTournamentLength(){}
    boolean initializeSeedings(){}

    boolean initializeTournament(){}



}
