package com.example.apiexample.dtos.clients;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationDto {

  private Long id;
  private String type;
  private String value;

}
