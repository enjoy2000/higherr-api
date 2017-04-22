package com.higherr.api.repositories;

import com.higherr.api.models.Authority;
import com.higherr.api.models.AuthorityName;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorityRepository extends PagingAndSortingRepository<Authority, Long> {

    Authority findByName(AuthorityName name);
}