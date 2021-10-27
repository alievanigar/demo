package com.azercell.personposition.controller;

import com.azercell.personposition.dao.inter.PersonDaoInter;
import com.azercell.personposition.dao.inter.SkillDaoInter;
import com.azercell.personposition.dto.PersonDTO;
import com.azercell.personposition.dto.SkillDTO;
import com.azercell.personposition.modul.enums.PersonStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class PersonController {
    @Autowired
    PersonDaoInter personDaoInter;

    @GetMapping("/person")
    public String main(Model model) {
        model.addAttribute("personDTO", personDaoInter.getAll());
        return "person";
    }

    /*
    @PostMapping("/person")
    public String add(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String gender,
            @RequestParam Integer age,
            @RequestParam Set<PersonStatus> status,
            @RequestParam List<SkillDTO> skills,
            Map<String, Object> model
    ) throws IOException {

        PersonDTO personDTO = new PersonDTO(name, surname,gender,age,skills,status);
        personDaoInter.create(personDTO);

        Iterable<PersonDTO> personDTOS = personDaoInter.getAll();

        model.put("personDTO", personDTOS);

        return "person";
    }
*/
}
