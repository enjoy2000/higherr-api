package com.higherr.api.repositories;

import com.higherr.api.models.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}