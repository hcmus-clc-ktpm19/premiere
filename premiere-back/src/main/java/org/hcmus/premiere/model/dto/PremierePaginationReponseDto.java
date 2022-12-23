package org.hcmus.premiere.model.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PremierePaginationReponseDto<T> {

  private List<T> payload;
  private MetaDataDto meta;
}
