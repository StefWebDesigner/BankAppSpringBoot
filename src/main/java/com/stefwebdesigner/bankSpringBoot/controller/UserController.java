package com.stefwebdesigner.bankSpringBoot.controller;

import com.stefwebdesigner.bankSpringBoot.entities.UserEntities;
import com.stefwebdesigner.bankSpringBoot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController (UserService userService) {this.userService = userService; }

    //REQUEST THE USER ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserById(@PathVariable Integer id) {

        UserEntities userEntities = userService.getUserById(id);

        if (userEntities == null) {
            return ResponseEntity.ok("No user found with the given ID " + id);
        }

        return ResponseEntity.ok(userEntities);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<UserEntities> newUser(@RequestBody UserEntities user) {

       return ResponseEntity.ok(userService.save(user));
    }




}
