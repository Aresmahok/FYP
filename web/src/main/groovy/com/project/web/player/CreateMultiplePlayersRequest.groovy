package com.project.web.player

import org.hibernate.validator.constraints.NotBlank

class CreateMultiplePlayersRequest {
    @NotBlank
    List<CreatePlayerRequest> requestList

}
