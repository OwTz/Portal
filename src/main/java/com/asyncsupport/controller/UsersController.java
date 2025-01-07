package com.asyncsupport.controller;


import ch.qos.logback.core.net.server.Client;
import com.asyncsupport.models.User;
import com.asyncsupport.service.ClientScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private ClientScan client;

    @GetMapping
    public List<User> getAllusuarios(){
        return client.scanAllUsers();
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id){
        return client.scanById(id);
    }

    @GetMapping("/name/{name}")
    public List<User> findByName(@PathVariable String name){
        return client.findByName(name);
    }
}
