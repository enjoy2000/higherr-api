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
    }
}