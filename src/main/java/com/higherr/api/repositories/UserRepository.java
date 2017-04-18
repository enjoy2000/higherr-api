package com.higherr.api.repositories;

import com.higherr.api.models.User;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByUsername(String username);

    @Before("execution(* com.higherr.api.repositories.UserRepository.save(..))")
    public void log(User user) {
        user.setAuthorities()
    }
}