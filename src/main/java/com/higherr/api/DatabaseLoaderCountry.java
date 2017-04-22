package com.higherr.api;

import com.higherr.api.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoaderCountry implements CommandLineRunner {

    private final CountryRepository repository;

    @Autowired
    public DatabaseLoaderCountry(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
    }
}