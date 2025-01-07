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
            }
        }
        return usuario;
    }

    public List<User> scanAllUsers(){
        List<User> users = query.findAll();
        return users;
    }

    public void saveUser(User user){
        query.save(user);
    }
    public List<User> findByName(String name){
        List<User> users = new ArrayList<>();
        for (User usuario : query.findAll()) {
            if (usuario.getNome().equals(name)) {
                users.add(usuario);
            }
        }
        return users;
    }

}
