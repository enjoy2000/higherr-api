package com.higherr.api.repositories;

import com.higherr.api.models.Application;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApplicationRepository extends PagingAndSortingRepository<Application, Long> {
}