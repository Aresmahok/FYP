package com.project.core.game

import com.project.core.referee.Referee
import com.project.core.score.Score
import com.project.core.team.Team
import com.project.core.tournament.Tournament

import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne


/**
 * Created by ares on 09/03/15.
 */
class Game {
    Long id
    Team home, away
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'tournament_id')
    Tournament tournament
    def startTime, currentTime, halfTime, endTime
    Score currentScore
    LinkedList<Score> scoreHistory
    Referee referee




}
