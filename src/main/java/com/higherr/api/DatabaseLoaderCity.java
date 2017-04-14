package com.higherr.api;

import com.higherr.api.models.*;
import com.higherr.api.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoaderCity implements CommandLineRunner {

    private final CityRepository repository;

    @Autowired
    public DatabaseLoaderCity(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
    }
}