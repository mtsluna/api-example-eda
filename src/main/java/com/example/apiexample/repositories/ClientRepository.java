package com.example.apiexample.repositories;

import com.example.apiexample.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    ClientEntity findAllByDniAndSurname(String dni, String surname);

    ClientEntity findAllByDniContainsAndSurnameEndingWith(String dni, String surname);

    @Query("select count(client) from ClientEntity client WHERE client.dni = :dni and client.surname = :surname")
    long countByDniAndSurname(String dni, String surname);


}
