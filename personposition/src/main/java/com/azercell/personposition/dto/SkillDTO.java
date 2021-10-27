package com.azercell.personposition.dto;

import com.azercell.personposition.modul.Person;
import com.azercell.personposition.modul.Skill;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class SkillDTO {
    private Long id;
    private String name;
    private PersonDTO user;


    public SkillDTO(String name, PersonDTO user){
        this.name=name;
        this.user=user;
    }
    public SkillDTO(Long id){
        this.id=id;
    }

    public static SkillDTO of(Skill skill) {
        return new SkillDTO(skill);
    }

    //for test skill.ftl
    public SkillDTO(Skill skill){
        this.id = skill.getId();
        this.user = new PersonDTO(skill.getUser(),true);
        this.name = skill.getName();

    }
}
