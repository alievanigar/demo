package com.example.backendmain.api;

import com.example.backendmain.dto.UserCreateDTO;
import com.example.backendmain.dto.UserUpdateDTO;
import com.example.backendmain.dto.UserViewDTO;
import com.example.backendmain.service.UserService;
import com.example.backendmain.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserApi {

    private final UserService userService;

    @GetMapping("v1/user/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long id) {
        final UserViewDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("v1/user")
    public ResponseEntity<List<UserViewDTO>> getUsers(){
        final List<UserViewDTO> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("v1/user")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO){

        userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new GenericResponse("User created"));
    }

    @PutMapping("v1/user/{id}")
    public ResponseEntity<UserViewDTO> updateUser(@PathVariable("id") Long id,@RequestBody UserUpdateDTO userUpdateDTO) {
        final UserViewDTO user = userService.updateUser(id,userUpdateDTO);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping ("v1/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id) {
       userService.deleteUser(id);
        return ResponseEntity.ok(new GenericResponse("User Deleted"));
    }

    @GetMapping ("v1/user/slice")
    public ResponseEntity< List<UserViewDTO>> slice(Pageable pageable){
        final List<UserViewDTO> users = userService.slice(pageable);
        return ResponseEntity.ok(users);
    }

}



