package com.higherr.api;

import com.higherr.api.models.Company;
import com.higherr.api.models.Job;
import com.higherr.api.models.Profile;
import com.higherr.api.models.User;
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
                new Company("Facebook"),
                false,
                "Engineer",
                5
        );
        User author = new User("admin", "admin", "Hat",
                "Dao", "enjoy3013@gmail.com", true, profile);

        this.repository.save(new Job("FB Job1", "Facebook", "Singapore", "Singapore", "Software Engineering",
                "Full Time", "New job description", "New job responsibilities", "New job requirements",
                1, "http://higherr.com/", author));
    }
}