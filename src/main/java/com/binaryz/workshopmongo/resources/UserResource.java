package com.binaryz.workshopmongo.resources;

import com.binaryz.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    //@RequestMapping(method= RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<User>> findAll(){ // Capsule the list of user as an http entity
        User maria = new User("1", "Maria Silva", "maria@gmail.com");
        User alex = new User("1", "Alex Green", "alex@gmail.com");
        List<User> list = new ArrayList<>(Arrays.asList(maria, alex));
        //list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list); // return http and list as body.
    }

    
}
