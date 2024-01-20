package com.binaryz.workshopmongo.resources;

import com.binaryz.workshopmongo.domain.User;
import com.binaryz.workshopmongo.dto.UserDTO;
import com.binaryz.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired // Instantiate the service
    private UserService userService;

    //@RequestMapping(method= RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){ // Capsule the list of user as an http entity
        List<User> listUsers = userService.findAll(); // Instantiate a list and get all users using the instantiated service method.
        List<UserDTO> listDTOUsers = listUsers.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); /*Get the listUsers to a stream
         then get each User object from the list and convert into an UserDTO object, so collect all this new objects and use all them to
         form a new UserDTO list*/
        return ResponseEntity.ok().body(listDTOUsers); // return http status and a list of DTO users as body.
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){ // Get user id sent on URL
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj)); // return http status and an UserDTO as body.
    }



}
