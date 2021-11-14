package com.example.sweater.repos;

import com.example.sweater.domain.User;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
