package com.binaryz.workshopmongo.resources;

import com.binaryz.workshopmongo.domain.Post;
import com.binaryz.workshopmongo.domain.User;
import com.binaryz.workshopmongo.dto.UserDTO;
import com.binaryz.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        return ResponseEntity.ok().body(listDTOUsers); // return 200 http status and a list of DTO users as body.
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){ // Get user id sent on URL
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj)); // return 200 http status and an UserDTO as body.
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){ // Get user id sent on URL
        User obj = userService.fromDTO(objDto);
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build(); // return 201 http status using created.
    }

    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value="{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id){ // Get user id sent on URL
        User obj = userService.fromDTO(objDto);
        obj.setId(id);
        obj = userService.update(obj);
        return ResponseEntity.noContent().build(); // return 204 http status
    }

    @GetMapping(value="/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id){ // Get user id sent on URL
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj.getPosts()); // return 200 http status and the posts from searched id.
    }







}
