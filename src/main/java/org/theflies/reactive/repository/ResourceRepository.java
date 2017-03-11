package org.theflies.reactive.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.theflies.reactive.model.Resource;

/**
 *
 */
public interface ResourceRepository extends ReactiveMongoRepository<Resource, Long> {

}
