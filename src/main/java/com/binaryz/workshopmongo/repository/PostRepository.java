package com.binaryz.workshopmongo.repository;

import com.binaryz.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> { // MongoRepository<Class domain type, ID type>

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }") // { 'attribute to be searched': { $regex: regularExpression(0 to the first object = text), $options: 'i to ignore sensitive case' } }
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);

}
