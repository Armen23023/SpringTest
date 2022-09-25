package com.example.springtest.repository;

import com.example.springtest.entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepo extends CrudRepository<ToDoEntity,Long> {
}
