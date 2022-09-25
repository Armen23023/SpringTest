package com.example.springtest.service;


import com.example.springtest.entity.ToDoEntity;
import com.example.springtest.entity.UserEntity;
import com.example.springtest.model.ToDo;
import com.example.springtest.repository.ToDoRepo;
import com.example.springtest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepo toDoRepo;
    @Autowired
    private UserRepo userRepo;

    public ToDo createToDo(ToDoEntity toDo, Long userid){
        UserEntity user = userRepo.findById(userid).get();
        toDo.setUser(user);
        return ToDo.toModel(toDoRepo.save(toDo));
    }

    public ToDo Complete( Long id){
            ToDoEntity toDo = toDoRepo.findById(id).get();
            toDo.setCompleted(!toDo.getCompleted());
            return ToDo.toModel(toDoRepo.save(toDo));
    }

 }
