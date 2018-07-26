package com.oocl.springBootSqlTest.NToN.Controller;

import com.oocl.springBootSqlTest.NToN.Enity.User;
import com.oocl.springBootSqlTest.NToN.Repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @GetMapping
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @Transactional
    @PostMapping(path = "" , produces = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @Transactional
    @DeleteMapping(path = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public User deleteUserById (@PathVariable Long id){
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return user;
    }
}
