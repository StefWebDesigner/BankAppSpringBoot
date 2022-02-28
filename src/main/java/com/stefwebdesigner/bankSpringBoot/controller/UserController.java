package com.stefwebdesigner.bankSpringBoot.controller;

import com.stefwebdesigner.bankSpringBoot.entities.UserModel;
import com.stefwebdesigner.bankSpringBoot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserById(@PathVariable Integer id) {

        UserModel userModel = userService.getUserById(id);

        if (userModel == null) {
            return ResponseEntity.ok("No user found with the given ID " + id);
        }

        return ResponseEntity.ok(userModel);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<UserModel> save(@RequestBody UserModel userModel, @RequestParam String type) {
        return ResponseEntity.ok(userService.save(userModel, type));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.ok("Succesfully deleted your account");
    }
}