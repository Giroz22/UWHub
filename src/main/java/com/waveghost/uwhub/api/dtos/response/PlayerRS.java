package com.waveghost.uwhub.api.dtos.response;

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
public class PlayerRS {
    private String id;
    private String name;
    private int number;
    private String position;
}
