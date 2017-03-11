package org.theflies.reactive.controller;

import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.theflies.reactive.model.Resource;
import org.theflies.reactive.repository.ResourceRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 */
@RestController
public class ResourceController {
  private final ResourceRepository repository;

  public ResourceController(ResourceRepository resourceRepository) {
    this.repository = resourceRepository;
  }

  @PostMapping("/resources")
  Mono<Void> create(@RequestBody Publisher<Resource> resourceStream) {
    return this.repository.save(resourceStream).then();
  }

  @GetMapping("/resources")
  Flux<Resource> list() {
    return this.repository.findAll();
  }

  @GetMapping("/resources/{id}")
  Mono<Resource> findById(@PathVariable Long id) {
    return this.repository.findOne(id);
  }
}
