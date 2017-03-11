package org.theflies.reactive;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.theflies.reactive.model.Metadata;
import org.theflies.reactive.model.Resource;
import org.theflies.reactive.repository.ResourceRepository;

/**
 *
 */
@SpringBootApplication
@Slf4j
public class TheOneApplication {

  @Autowired
  private ResourceRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(TheOneApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner() {
    return (args -> {
      log.info("initialize some data for testing");
      repository.deleteAll().block();
      repository.save(new Resource(0L, "htc",
          Arrays.asList(new Metadata("if","0341"), new Metadata("speed","2gb")))).block();
      repository.save(new Resource(1L, "vtv",
          Arrays.asList(new Metadata("sofa","445"), new Metadata("en","con")))).block();
      repository.save(new Resource(2L, "vac",
          Arrays.asList(new Metadata("if","0341"), new Metadata("t","2")))).block();
    });
  }
}
