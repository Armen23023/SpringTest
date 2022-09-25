package com.example.springtest.controller;

import com.example.springtest.entity.UserEntity;
import com.example.springtest.exeption.UserAlreadyExistException;
import com.example.springtest.exeption.UserNotFoundException;
import com.example.springtest.repository.UserRepo;
import com.example.springtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("User successfully saved");
        }catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }



    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id){
        try {
            return ResponseEntity.ok(userService.getOne(id));
        }catch (UserNotFoundException e){
          return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
          return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.delete(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

}
