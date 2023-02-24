package com.example.apiexample.entities;

import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String dni;

    @Column
    private String address;

    @Column
    private String code;

    @OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL, CascadeType.PERSIST, CascadeType.DETACH })
    private AccountEntity account;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = IdentificationEntity.class, cascade = { CascadeType.ALL, CascadeType.PERSIST, CascadeType.DETACH })
    private List<IdentificationEntity> identifications;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = DepartmentEntity.class, cascade = { CascadeType.ALL, CascadeType.PERSIST, CascadeType.DETACH })
    private List<DepartmentEntity> departments;

}
