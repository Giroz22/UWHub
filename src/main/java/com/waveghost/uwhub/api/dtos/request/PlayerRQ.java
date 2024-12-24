package com.waveghost.uwhub.api.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
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
public class PlayerRQ {
    @NotBlank(message = "The name is required")
    private String name;

    @PositiveOrZero(message = "The number must be greater than zero")
    private int number;
    private String position;
}
