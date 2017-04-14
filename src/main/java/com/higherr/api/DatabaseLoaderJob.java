package com.higherr.api;

import com.higherr.api.models.*;
import com.higherr.api.repositories.JobRepository;
import com.higherr.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class DatabaseLoaderJob implements CommandLineRunner {

    private final JobRepository repository;

    @Autowired
    public DatabaseLoaderJob(JobRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Profile profile = new Profile(
                new Company("Facebook1"),
                false,
                "Engineer",
                5
        );
        User author = new User("Frodo", "Baggins", "ring bearer", profile);

        this.repository.save(new Job("FB Job1", new Company("Facebook1"), new City("cityName", new Country("Singapore")),
                "Software Engineering",
                EmploymentType.FULL_TIME, "New job description", "New job responsibilities", "New job requirements",
                1, "http://higherr.com/", author));
    }
}