package com.project.web.tournament


import com.project.core.team.Team
import org.hibernate.validator.constraints.NotBlank


/**
 * Created by smeehan on 13/04/15.
 */
class CreateTournamentRequest {
    @NotBlank
    String name

    @NotBlank
    Long numPitches

    @NotBlank
    String location

    Set<Team> teams


}

