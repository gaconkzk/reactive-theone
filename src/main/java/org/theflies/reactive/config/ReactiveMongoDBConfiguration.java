package org.theflies.reactive.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 *
 */
@Configuration
@EnableReactiveMongoRepositories(basePackages = "org.theflies.reactive.repository")
public class ReactiveMongoDBConfiguration {

}
