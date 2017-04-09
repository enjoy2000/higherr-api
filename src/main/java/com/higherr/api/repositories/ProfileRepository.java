package com.higherr.api.repositories;

import com.higherr.api.models.Profile;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProfileRepository extends PagingAndSortingRepository<Profile, Long> {

}