package com.higherr.api.repositories;

import com.higherr.api.models.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long> {
}