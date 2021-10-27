package com.azercell.personposition.repository;

import com.azercell.personposition.modul.WorkPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkPositionRep extends JpaRepository<WorkPosition, Long> {
}
