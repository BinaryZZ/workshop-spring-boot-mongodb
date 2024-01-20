package com.binaryz.workshopmongo.config;

import com.binaryz.workshopmongo.domain.User;
import com.binaryz.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration // define this class as a configuration class
public class Instantiation implements CommandLineRunner { // Implementing a interface

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception { // Instantiating a database

        userRepository.deleteAll(); // Delete on users on database

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

    }
}
