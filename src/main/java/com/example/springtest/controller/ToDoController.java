package com.example.springtest.controller;


import com.example.springtest.entity.ToDoEntity;
import com.example.springtest.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @PostMapping
    public ResponseEntity  createToDo(@RequestBody ToDoEntity todo,
                                      @RequestParam Long userId){
        try {
        return ResponseEntity.ok(toDoService.createToDo(todo,userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }



    @PutMapping
    public ResponseEntity  completeToDo(@RequestParam Long id){

        try {
            return ResponseEntity.ok(toDoService.Complete(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }





}
