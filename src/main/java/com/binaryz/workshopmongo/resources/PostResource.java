package com.binaryz.workshopmongo.resources;

import com.binaryz.workshopmongo.domain.Post;
import com.binaryz.workshopmongo.domain.User;
import com.binaryz.workshopmongo.dto.UserDTO;
import com.binaryz.workshopmongo.services.PostService;
import com.binaryz.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired // Instantiate the service
    private PostService postService;

    @GetMapping(value="/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){ // Get user id sent on URL
        Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj); // return 200 http status and an UserDTO as body.
    }

}
