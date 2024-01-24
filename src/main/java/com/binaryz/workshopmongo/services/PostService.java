package com.binaryz.workshopmongo.services;
import com.binaryz.workshopmongo.domain.Post;
import com.binaryz.workshopmongo.domain.User;
import com.binaryz.workshopmongo.dto.UserDTO;
import com.binaryz.workshopmongo.repository.PostRepository;
import com.binaryz.workshopmongo.repository.UserRepository;
import com.binaryz.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository; // Instantiate a UserRepository to use the MongoRepository methods

    public Post findById(String id) { // method to return an user by id
        Optional<Post> post = postRepository.findById(id); // get a user by id using UserRepository
        return post.orElseThrow(() -> new ObjectNotFoundException("Object was not found"));
    }
    

}
