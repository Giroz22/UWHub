package com.waveghost.uwhub.api.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TournamentRQ {
    @NotBlank(message = "The name is required")
    @NotNull(message = "The name can't be null")
    private String name;

    @NotBlank(message = "The user_id is required")
    @NotNull(message = "The user_id can't be null")
    private String userId;
}
