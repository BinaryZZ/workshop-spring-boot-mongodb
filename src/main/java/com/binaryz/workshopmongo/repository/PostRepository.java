package com.binaryz.workshopmongo.repository;

import com.binaryz.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> { // MongoRepository<Class domain type, ID type>

    List<Post> findByTitleContainingIgnoreCase(String text);

}
