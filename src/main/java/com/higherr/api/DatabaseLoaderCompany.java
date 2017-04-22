package com.higherr.api;

import com.higherr.api.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoaderCompany implements CommandLineRunner {

    private final CompanyRepository repository;

    @Autowired
    public DatabaseLoaderCompany(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
    }
}