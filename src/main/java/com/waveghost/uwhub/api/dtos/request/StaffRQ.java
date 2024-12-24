package com.waveghost.uwhub.api.dtos.request;

import com.waveghost.uwhub.utils.enums.RoleTourney;

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
    private RoleTourney role;
    private String userId;
}
