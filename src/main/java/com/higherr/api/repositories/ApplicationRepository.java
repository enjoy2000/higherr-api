package com.higherr.api.repositories;

import com.higherr.api.models.Application;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Application, Long> {
}