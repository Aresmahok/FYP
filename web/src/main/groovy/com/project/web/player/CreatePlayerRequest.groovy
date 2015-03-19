package com.project.web.player

import org.hibernate.validator.constraints.NotBlank

public class CreatePlayerRequest {

    @NotBlank
    String firstName

    @NotBlank
    String lastName

    Long playerNumber
}
