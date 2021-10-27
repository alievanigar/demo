package com.azercell.personposition.dto;

import com.azercell.personposition.modul.Person;
import com.azercell.personposition.modul.Skill;
import com.azercell.personposition.modul.enums.PersonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private Long id;
    private String name;
    private String surname;
    private String gender;
    private Integer age;
    private List<SkillDTO> skills;
    private Set<PersonStatus> status;

    public PersonDTO(Person p) {
        this.id = p.getId();
        this.name = p.getName();
        this.surname = p.getSurname();
        this.gender = p.getGender();
        this.age = p.getAge();
        this.status = p.getStatus();
        List<SkillDTO> list = new ArrayList<>();
        List<Skill> personSkills = p.getSkills();
        for (int i = 0; i < personSkills.size(); i++) {
            Skill s = personSkills.get(i);
            list.add(new SkillDTO(s));
            skills = list;
        }

    }

    //for skill.ftl post method tests
    public PersonDTO(Person p, boolean cond){

        this.id = p.getId();
        this.name = p.getName();
        this.surname = p.getSurname();
        this.gender = p.getGender();
        this.age = p.getAge();
        this.status = p.getStatus();
    }

    public static PersonDTO of(Person person) {
        return new PersonDTO(person);
    }
}
