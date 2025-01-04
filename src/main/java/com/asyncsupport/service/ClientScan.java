package com.asyncsupport.service;


import com.asyncsupport.models.User;
import com.asyncsupport.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ClientScan {

    @Autowired
    private UsuarioRepository query;

    public User scanById(Integer id) {
        User usuario = new User();

        for (User user : query.findAll()) {
            if (user.getId().equals(id)) {
                usuario = user;
                return user;
            }
        }
        return usuario;
    }

    public List<User> scanAllUsers(){
        List<User> users = query.findAll();
        return users;
    }

}
