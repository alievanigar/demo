package com.example.backendmain.dto;

import com.example.backendmain.validator.UniqueUserName;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data

public class UserCreateDTO {

    @NotNull
    @Size(min=2,max=32)
    @UniqueUserName
    private String userName;

    @NotNull(message = "{backend.constraints.firstname.NotNull.message}")
    @Size(min=2,max=32,message ="{backend.constraints.firstname.Size.message}")
    private String firstName;

    @NotNull(message = "{backend.constraints.lastname.NotNull.message}")
    @Size(min=2,max=32,message ="{backend.constraints.lastname.Size.message}")
    private String lastName;
}