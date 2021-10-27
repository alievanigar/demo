package com.azercell.personposition.api;
import com.azercell.personposition.dao.inter.PersonDaoInter;
import com.azercell.personposition.dto.PersonDTO;
import com.azercell.personposition.modul.Person;
import com.azercell.personposition.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PersonApi {

        private final PersonDaoInter personDaoInter;

        @GetMapping("person/{id}")
        public ResponseEntity<PersonDTO> getUserById(@PathVariable("id") Long id) {
            final PersonDTO personDTO = personDaoInter.getById(id);
            return ResponseEntity.ok(personDTO);
        }

        @GetMapping("person")
        public ResponseEntity<List<PersonDTO>> getUsers() {
            final List<PersonDTO> persons = personDaoInter.getAll();
            return ResponseEntity.ok(persons);
        }

        @PostMapping("person")
        public ResponseEntity<?> createUser(@RequestBody PersonDTO personDTO) {

            personDaoInter.create(personDTO);
            return ResponseEntity.ok(new GenericResponse("User created"));
        }

        @PutMapping("person/{id}")
        public ResponseEntity<PersonDTO> updateUser(@PathVariable("id") Long id, @RequestBody PersonDTO personDTO) {
            final PersonDTO p = personDaoInter.update(id, personDTO);
            return ResponseEntity.ok(p);
        }

    @DeleteMapping("person/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id, @RequestBody PersonDTO person) {
         personDaoInter.delete(id);
        return ResponseEntity.ok(new GenericResponse("User deleted"));
    }
    }
