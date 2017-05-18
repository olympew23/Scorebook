package com.theironyard.novauc.services;

import com.theironyard.novauc.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jerieshasmith on 5/18/17.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    User findFirstByName(String userName);
}