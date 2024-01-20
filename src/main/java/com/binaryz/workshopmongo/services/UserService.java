package com.binaryz.workshopmongo.services;
import com.binaryz.workshopmongo.domain.User;
import com.binaryz.workshopmongo.repository.UserRepository;
import com.binaryz.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // Instantiate a UserRepository to use the MongoRepository methods

    public List<User> findAll(){ // method to return all users on a list
        return userRepository.findAll(); // find all MongoRepository method
    }

    public User findById(String id) { // method to return an user by id
        Optional<User> user = userRepository.findById(id); // get a user by id using UserRepository
        return user.orElseThrow(() -> new ObjectNotFoundException("Object was not found"));
    }
}
