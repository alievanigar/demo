package com.azercell.personposition.modul.enums;

import org.springframework.security.core.GrantedAuthority;

public enum PositionStatus implements GrantedAuthority {

    VACANT,INACTIVE,CATCHED;

    @Override
    public String getAuthority() {
        return  name();
    }
}

