package com.azercell.personposition.controller;

import com.azercell.personposition.dao.inter.PersonDaoInter;
import com.azercell.personposition.dao.inter.SkillDaoInter;
import com.azercell.personposition.dto.PersonDTO;
import com.azercell.personposition.dto.SkillDTO;
import com.azercell.personposition.modul.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class SkillController {
    @Autowired
    SkillDaoInter skillDaoInter;
    @Autowired
    PersonDaoInter personDaoInter;

    @GetMapping("/skill")
    public String main(Model model) {
        model.addAttribute("skillDTO", skillDaoInter.getAll());
       return "skill";
    }

    @PostMapping("/skill")
    public String add(
            @RequestParam String name,
            @RequestParam Long user, Map<String, Object> model
    ) throws IOException {

        SkillDTO skillDTO = new SkillDTO(name, personDaoInter.getById(user));
        skillDaoInter.create(skillDTO);

        Iterable<SkillDTO> skillDTOS = skillDaoInter.getAll();

        model.put("skillDTO", skillDTOS);

        return "skill";
    }
}
