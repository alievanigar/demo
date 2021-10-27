package com.azercell.personposition.api;

import com.azercell.personposition.dao.inter.SkillDaoInter;

import com.azercell.personposition.dto.SkillDTO;
import com.azercell.personposition.modul.Person;
import com.azercell.personposition.modul.Skill;
import com.azercell.personposition.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class SkillApi {


            private final SkillDaoInter skillDaoInter;

            @GetMapping("skill/{id}")
            public ResponseEntity<SkillDTO> getUserById(@PathVariable("id") Long id) {
                final SkillDTO skillDTO = skillDaoInter.getById(id);
                return ResponseEntity.ok(skillDTO);
            }

            @GetMapping("skill")
            public ResponseEntity<List<SkillDTO>> getUsers() {
                final List<SkillDTO> skills = skillDaoInter.getAll();
                return ResponseEntity.ok(skills);
            }

            @PostMapping("skill")
            public ResponseEntity<?> createUser(@RequestBody SkillDTO skillDTO) {

                skillDaoInter.create(skillDTO);
                return ResponseEntity.ok(new GenericResponse("User created"));
            }

            @PutMapping("skill/{id}")
            public ResponseEntity<SkillDTO> updateUser(@PathVariable("id") Long id, @RequestBody SkillDTO skillDTO) {
                final SkillDTO s = skillDaoInter.update(id, skillDTO);
                return ResponseEntity.ok(s);
            }

    @DeleteMapping("skill/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id, @RequestBody SkillDTO skillDTO) {
        skillDaoInter.delete(id);
        return ResponseEntity.ok(new GenericResponse("Skill deleted"));
    }

        }
