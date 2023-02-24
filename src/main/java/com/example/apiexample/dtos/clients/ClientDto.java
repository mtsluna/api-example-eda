package com.example.apiexample.dtos.clients;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private Long id;

    private String dni;

    private String name;

    private String surname;

    private String address;

    private String code;

    private AccountDto account;

    private List<IdentificationDto> identifications;

    private List<DepartmentDto> departments;
}
