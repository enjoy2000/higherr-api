package com.higherr.api;

import com.higherr.api.models.Blog;
import com.higherr.api.models.Company;
import com.higherr.api.models.Profile;
import com.higherr.api.models.User;
import com.higherr.api.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class DatabaseLoaderBlog implements CommandLineRunner {

    private final BlogRepository repository;

    @Autowired
    public DatabaseLoaderBlog(BlogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
//        Profile profile = new Profile(
//                new Company("Facebook1"),
//                false,
//                "Engineer",
//                5
//        );
//        User author = new User("Frodo", "Baggins", "ring bearer", profile);
//        this.repository.save(new Blog(author, "new title", "new body", ""));
    }
}