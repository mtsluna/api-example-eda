package com.example.apiexample.mappers;

import com.example.apiexample.domain.Client;
import com.example.apiexample.dtos.clients.ClientDto;
import com.example.apiexample.entities.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client convert(ClientDto clientDto);

    ClientDto convert(Client client);

    Client convertFromEntitytoClient(ClientEntity clientEntity);

    ClientEntity convertFromClientToEntity(Client client);

}
