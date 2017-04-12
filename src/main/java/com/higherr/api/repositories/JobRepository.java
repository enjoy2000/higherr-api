package com.higherr.api.repositories;

import com.higherr.api.models.Job;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface JobRepository extends PagingAndSortingRepository<Job, Long> {
}