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
public class UserRQ {
    @NotBlank(message = "The name is required")
    @NotNull(message = "The name can't be null")
    private String name;

    @NotBlank(message = "The email is required")
    @NotNull(message = "The email can't be null")
    private String email;

    @NotBlank(message = "The password is required")
    @NotNull(message = "The password can't be null")
    private String passsword;

}
