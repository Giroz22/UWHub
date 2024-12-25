package com.waveghost.uwhub.api.dtos.request;

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
public class StaffRQ {
    private String tournamentId;
    private String ownerId;
    private String userId;
}
