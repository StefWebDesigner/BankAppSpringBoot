package com.stefwebdesigner.bankSpringBoot.beans.controller;

import com.stefwebdesigner.bankSpringBoot.beans.entities.UserEntities;
import com.stefwebdesigner.bankSpringBoot.beans.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userEntities")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController (UserService userService) {this.userService = userService; }

    //REQUEST THE USER ID
    @RequestMapping(value = "/userid", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserById(@PathVariable Integer userId) {

        UserEntities userEntities = userService.getUserById(userId);
        if (userEntities == null) {
            return ResponseEntity.ok("No user found with the given ID " + userId);
        }

        return ResponseEntity.ok(userEntities);
    }




}
