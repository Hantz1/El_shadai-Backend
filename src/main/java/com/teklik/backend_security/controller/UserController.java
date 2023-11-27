package com.teklik.backend_security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.teklik.backend_security.exception.ResourceNotFoundException;
import com.teklik.backend_security.model.User;
import com.teklik.backend_security.repository.UserRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // build create employee REST API
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable  long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not exist with id:" + id));
        return ResponseEntity.ok(user);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<User> updateOrder(@PathVariable long id,@RequestBody User userParams) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not exist with id:" + id));

                user.setLastname(userParams.getLastname());
                user.setFirstname(userParams.getFirstname());
                user.setEmail(userParams.getEmail());
                user.setUsername(userParams.getUsername());
                user.setPassword(userParams.getPassword());
                user.setRole(userParams.getRole());
                user.setStatus(userParams.getStatus());
                user.setDateinscription(userParams.getDateinscription());

        userRepository.save(user);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id){

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not exist with id: " + id));

        userRepository.delete(user);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
