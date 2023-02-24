package com.example.apiexample.domain;

import java.util.List;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {

    private Long id;

    private String name;

    private String surname;

    private String dni;

    private String address;

    private String code;

    private Account account;

    private List<Department> departments;

    private List<Identification> identifications;
}
