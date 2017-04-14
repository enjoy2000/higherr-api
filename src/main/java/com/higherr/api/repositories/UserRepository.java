package com.higherr.api.repositories;

import com.higherr.api.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}