package com.higherr.api.repositories;

import com.higherr.api.models.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blog, Long> {
}