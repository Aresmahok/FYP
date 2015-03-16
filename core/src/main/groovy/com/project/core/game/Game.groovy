package com.project.core.game

import com.project.core.referee.Referee
import com.project.core.score.Score
import com.project.core.team.Team


/**
 * Created by ares on 09/03/15.
 */
class Game {
    Long id
    Team home, away
    def startTime, currentTime, halfTime, endTime
    Score currentScore
    LinkedList<Score> scoreHistory
    Referee referee




}
