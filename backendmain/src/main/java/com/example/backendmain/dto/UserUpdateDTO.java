package com.example.backendmain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserUpdateDTO {

    @NotNull(message = "{backend.constraints.firstName.NotNull.message}")
    @Size(min=2,max=32,message ="not null olmaz") //{backend.constraints.firstName.Size.message}
    private String firstName;

    @NotNull(message = "{backend.constraints.lastName.NotNull.message}")
    @Size(min=2,max=32,message ="{backend.constraints.lastName.Size.message}")
    private String lastName;
}
