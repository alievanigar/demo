package com.azercell.personposition.api;

import com.azercell.personposition.dao.inter.SkillDaoInter;
import com.azercell.personposition.dao.inter.WorkPositionDaoInter;
import com.azercell.personposition.dto.WorkPositionDTO;
import com.azercell.personposition.modul.Person;
import com.azercell.personposition.modul.Skill;
import com.azercell.personposition.modul.WorkPosition;
import com.azercell.personposition.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class WorkPositionApi {
    private final WorkPositionDaoInter workPositionDaoInter;

    @GetMapping("workposition/{id}")
    public ResponseEntity<WorkPositionDTO> getUserById(@PathVariable("id") Long id) {
        final WorkPositionDTO workPositionDTO = workPositionDaoInter.getById(id);
        return ResponseEntity.ok(workPositionDTO);
    }

    @GetMapping("workposition")
    public ResponseEntity<List<WorkPositionDTO>> getUsers() {
        final List<WorkPositionDTO> workPositions = workPositionDaoInter.getAll();
        return ResponseEntity.ok(workPositions);
    }

    @PostMapping("workposition")
    public ResponseEntity<?> createUser(@RequestBody WorkPositionDTO workPositionDTO) {

        workPositionDaoInter.create(workPositionDTO);
        return ResponseEntity.ok(new GenericResponse("User created"));
    }

    @PutMapping("workposition/{id}")
    public ResponseEntity<WorkPositionDTO> updateUser(@PathVariable("id") Long id, @RequestBody WorkPositionDTO workPositionDTO) {
        final WorkPositionDTO wp = workPositionDaoInter.update(id, workPositionDTO);
        return ResponseEntity.ok(wp);
    }

    @DeleteMapping("workposition/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id, @RequestBody WorkPositionDTO workPositionDTO) {
       workPositionDaoInter.delete(id);
        return ResponseEntity.ok(new GenericResponse("WorkPosition deleted"));
    }

}
