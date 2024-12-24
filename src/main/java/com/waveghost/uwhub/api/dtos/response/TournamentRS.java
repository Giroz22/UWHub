package com.waveghost.uwhub.api.dtos.response;

import java.util.List;

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
public class TournamentRS {
    private String id;
    private String name;
    private UserRS owner;
    private List<StaffRS> staff; 
}
