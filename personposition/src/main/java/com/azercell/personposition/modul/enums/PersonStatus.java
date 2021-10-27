package com.azercell.personposition.modul.enums;

import org.springframework.security.core.GrantedAuthority;

public enum PersonStatus  implements GrantedAuthority {

	JOB_SEEKER,	EMPLOYED,UNEMPLOYED;

    @Override
    public String getAuthority() {
        return  name();
    }

}
