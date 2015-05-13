package com.project.web.team

import org.hibernate.validator.constraints.NotBlank

public class CreateTeamRequest {
    @NotBlank
    String name
    String shortHandName
}
