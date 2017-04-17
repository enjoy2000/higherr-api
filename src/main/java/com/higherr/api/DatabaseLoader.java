package com.higherr.api;

import com.higherr.api.models.*;
import com.higherr.api.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class DatabaseLoader implements CommandLineRunner {

    private final UserRepository repository;

    @Autowired
    public DatabaseLoader(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Profile profile = new Profile(
                new Company("BuzzElement"),
                false,
                "Engineer",
                5
        );
        User user = new User("enjoy2000", "password","Hat",
                "Dao", "enjoy3013@gmail.com",
                true, profile);
        this.repository.save(user);
    }
}