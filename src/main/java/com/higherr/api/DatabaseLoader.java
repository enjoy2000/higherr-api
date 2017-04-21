package com.higherr.api;

import com.higherr.api.models.Company;
import com.higherr.api.models.Profile;
import com.higherr.api.models.User;
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
//        Profile profile = new Profile(
//                new Company("Facebook2"),
//                false,
//                "Engineer",
//                5
//        );
//        this.repository.save(new User("Frodo", "Baggins", "ring bearer", profile));
    }
}