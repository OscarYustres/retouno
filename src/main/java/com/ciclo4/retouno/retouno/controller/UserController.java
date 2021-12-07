/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo4.retouno.retouno.controller;

import com.ciclo4.retouno.retouno.model.User;
import com.ciclo4.retouno.retouno.service.UserService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author OscarD
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user){
        return userService.registrar(user);
    }
    
    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password")String password){
     return userService.autenticarUsuario(email, password);
    }
    
    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email){
        return userService.existeEmail(email);
    }
}
