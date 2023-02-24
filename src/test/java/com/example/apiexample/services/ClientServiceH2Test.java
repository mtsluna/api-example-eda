package com.example.apiexample.services;

import static org.junit.jupiter.api.Assertions.*;

import com.example.apiexample.components.CodeGeneratorComponent;
import com.example.apiexample.domain.Client;
import com.example.apiexample.mappers.ClientMapper;
import com.example.apiexample.mappers.ClientMapperImpl;
import com.example.apiexample.repositories.ClientRepository;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import({ClientMapperImpl.class, CodeGeneratorComponent.class})
@ActiveProfiles("test")
class ClientServiceH2Test {

  @Autowired
  private ClientService clientService;

  @Test
  @Sql("/scripts/client-find-all.sql")
  void findAll() {

    List<Client> clients = this.clientService.findAll();
    Assertions.assertEquals(2, clients.size());

  }
}