package com.example.apiexample.services;

import static org.junit.jupiter.api.Assertions.*;

import com.example.apiexample.domain.Client;
import com.example.apiexample.entities.ClientEntity;
import com.example.apiexample.mappers.ClientMapper;
import com.example.apiexample.repositories.ClientRepository;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

  @Mock
  private ClientRepository clientRepository;

  @Mock
  private ClientMapper clientMapper;

  @InjectMocks
  private ClientService clientService;

  @Test
  @DisplayName("Should return a client by id")
  void findById() throws Exception {

    ClientEntity clientEntity = ClientEntity
        .builder()
        .id(45L)
        .dni("4647493")
        .name("Matias")
        .build();

    Client clientExpected = Client
        .builder()
        .id(45L)
        .name("Matias")
        .dni("4647493")
        .build();

    Mockito.when(this.clientRepository.findById(45L))
        .thenReturn(Optional.of(clientEntity));

    Mockito.when(this.clientMapper.convertFromEntitytoClient(clientEntity))
        .thenReturn(clientExpected);

    Client client = this.clientService.findById(45L);

    Mockito.verify(this.clientRepository, Mockito.times(1))
        .findById(45L);

    Mockito.verify(this.clientMapper, Mockito.times(1))
            .convertFromEntitytoClient(clientEntity);

    Assertions.assertEquals(
        clientExpected,
        client
    );

  }

  @Test
  void findByIdThrowException() throws Exception {

    Mockito.when(this.clientRepository.findById(89L))
        .thenReturn(Optional.empty());

    Throwable throwable = Assertions.assertThrows(Exception.class, () -> {
      this.clientService.findById(89L);
    });

    Assertions.assertEquals(throwable.getMessage(), "Resource not found");

    Mockito.verify(this.clientRepository, Mockito.times(1))
        .findById(89L);

  }
}