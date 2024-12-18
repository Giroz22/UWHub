package com.waveghost.uwhub.controller.dtos.response;

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
public class TeamRS {
    private Integer id;
    private String name;
    private int points;
    private int goals;
}
