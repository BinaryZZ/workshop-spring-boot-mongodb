package com.binaryz.workshopmongo.resources;

import com.binaryz.workshopmongo.domain.User;
import com.binaryz.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired // Instantiate the service
    private UserService userService;

    //@RequestMapping(method= RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<User>> findAll(){ // Capsule the list of user as an http entity
        List<User> list = userService.findAll(); // Instantiate a list and get all users using the instantiated service method.
        return ResponseEntity.ok().body(list); // return http and list as body.
    }


}
