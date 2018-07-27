package com.oocl.springBootSqlTest.NToN.Controller;

import com.oocl.springBootSqlTest.NToN.Enity.GroupT;
import com.oocl.springBootSqlTest.NToN.Repository.GroupRepository;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private GroupRepository repository;

    public GroupController(GroupRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @GetMapping
    public List<GroupT> getAll(){
        return repository.findAll();
    }

    @Transactional
    @PostMapping(path = "" , produces = MediaType.APPLICATION_JSON_VALUE)
    public GroupT addUserGroup(@RequestBody GroupT groupT){

//        groupT.getUsers().stream().forEach(user -> user.setGroupTS(groupT));
        return repository.save(groupT);
    }

}
