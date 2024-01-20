package com.binaryz.workshopmongo.services;
import com.binaryz.workshopmongo.domain.User;
import com.binaryz.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // Instantiate a UserRepository to use the MongoRepository methods

    public List<User> findAll(){ // method to return all users on a list
        return userRepository.findAll(); // find all MongoRepository method
    }
}
