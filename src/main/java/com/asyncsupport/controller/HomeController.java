package com.asyncsupport.controller;

import com.asyncsupport.models.User;
import com.asyncsupport.service.ClientScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RequestMapping("/home")
@Controller
public class HomeController {

    @Autowired
    ClientScan queryUser;

    @GetMapping()
    public String home() {
        return "home";
    }

    @GetMapping("/contact")
    public String contact(){
        return "em construção";
    }

    @GetMapping("/users")
    public String pegandoUsers(){
        ModelAndView mv = new ModelAndView();
        return "home";
    }

}
