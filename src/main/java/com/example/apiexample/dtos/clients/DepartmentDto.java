package com.example.apiexample.dtos.clients;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

  private Long id;

  private String name;

  private List<ClientDto> clients;

}
