package com.oocl.springBootSqlTest.NToN.Controller;

import com.oocl.springBootSqlTest.NToN.Enity.User;
import com.oocl.springBootSqlTest.NToN.Repository.GroupRepository;
import com.oocl.springBootSqlTest.NToN.Repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private GroupRepository groupRepository;

    public UserController(UserRepository userRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    @Transactional
    @GetMapping
    public List<User> getAllUser(){
        return userRepository.findAll();
    }


    @PostMapping(path = "" , produces = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody User user){
        if(user.getGroupTS()!=null) {
            groupRepository.saveAll(user.getGroupTS());
        }
        return userRepository.save(user);
    }

    @PutMapping(path = "" , produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody User user){
        if(user.getGroupTS()!=null) {
            groupRepository.saveAll(user.getGroupTS());
        }
        return userRepository.save(user);
    }

    @Transactional
    @DeleteMapping(path = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public User deleteUserById (@PathVariable Long id){
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return user;
    }

    @GetMapping(path = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public User findById(@PathVariable Long id){
        User user = userRepository.findById(id).get();
        return user;
    }


}
