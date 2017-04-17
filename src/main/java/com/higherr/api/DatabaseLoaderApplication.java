package com.higherr.api;

import com.higherr.api.models.*;
import com.higherr.api.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

//@Component
public class DatabaseLoaderApplication implements CommandLineRunner {

    private final ApplicationRepository repository;

    @Autowired
    public DatabaseLoaderApplication(ApplicationRepository repository) {
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
        Job newJob = new Job("FB Job1", "Facebook", "Singapore", "Singapore", "Software Engineering",
                "Full Time", "New job description", "New job responsibilities", "New job requirements",
                1, "http://higherr.com/", author);

        this.repository.save(new Application(newJob, author, author, null, null));
    }
}