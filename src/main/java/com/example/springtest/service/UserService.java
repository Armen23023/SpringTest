package com.example.springtest.service;

import com.example.springtest.entity.UserEntity;
import com.example.springtest.exeption.UserAlreadyExistException;
import com.example.springtest.exeption.UserNotFoundException;
import com.example.springtest.model.User;
import com.example.springtest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null ){
            throw  new UserAlreadyExistException("User already exists");
        }
        return userRepo.save(user);
    }


    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user==null){
            throw  new UserNotFoundException("User Not Found");
        }
        return User.toModel(user);
    }

    public  Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }

}
