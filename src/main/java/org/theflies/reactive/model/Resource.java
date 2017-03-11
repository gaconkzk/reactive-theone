package org.theflies.reactive.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 */
@Data
@AllArgsConstructor
public class Resource {
  Long id;
  String name;
  List<Metadata> metadatas;
}
