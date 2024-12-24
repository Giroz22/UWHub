package com.waveghost.uwhub.api.dtos.response;

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
public class StaffRS {
    private String id;
    private RoleTourney role;
    private UserRS user;
}
