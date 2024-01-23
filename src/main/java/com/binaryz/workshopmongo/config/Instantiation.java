package com.binaryz.workshopmongo.config;

import com.binaryz.workshopmongo.domain.Post;
import com.binaryz.workshopmongo.domain.User;
import com.binaryz.workshopmongo.repository.PostRepository;
import com.binaryz.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration // define this class as a configuration class
public class Instantiation implements CommandLineRunner { // Implementing a interface

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;



    @Override
    public void run(String... args) throws Exception { // Instantiating a database

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // changing date format
        sdf.setTimeZone(TimeZone.getTimeZone("GMT")); // setting GMT Z 0 timezone

        userRepository.deleteAll(); // Delete all users from database
        postRepository.deleteAll(); // Delete all post from database

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar pra São Paulo, Abraços!", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));

    }
}
