package com.binaryz.workshopmongo.repository;

import com.binaryz.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> { // MongoRepository<Class domain type, ID type>

}
