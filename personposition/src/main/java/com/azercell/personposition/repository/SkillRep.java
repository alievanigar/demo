package com.azercell.personposition.repository;

import com.azercell.personposition.modul.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRep extends JpaRepository<Skill, Long> {
}
