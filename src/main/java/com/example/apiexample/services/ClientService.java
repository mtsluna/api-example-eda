package com.example.apiexample.services;

import com.example.apiexample.components.CodeGeneratorComponent;
import com.example.apiexample.domain.Client;
import com.example.apiexample.entities.ClientEntity;
import com.example.apiexample.mappers.ClientMapper;
import com.example.apiexample.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final CodeGeneratorComponent codeGeneratorComponent;

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    public Client findById(Long id) throws Exception {

        Optional<ClientEntity> optionalClientEntity = this.clientRepository.findById(id);

        if(optionalClientEntity.isPresent()) {
            return this.clientMapper.convertFromEntitytoClient(optionalClientEntity.get());
        }

        throw new Exception("Resource not found");

    }

    public List<Client> findAll() {
        return this.clientRepository.findAll().stream().map(this.clientMapper::convertFromEntitytoClient).collect(Collectors.toList());
    }

    public Client create(Client client) {

        client.setCode(this.codeGeneratorComponent.generate(
                client.getDni(),
                client.getSurname()
        ));

        ClientEntity clientEntity = this.clientRepository.save(this.clientMapper.convertFromClientToEntity(client));

        return this.clientMapper.convertFromEntitytoClient(clientEntity);
    }

    public Client update(Long id, Client client) {
        client.setId(id);

        client.setCode(this.codeGeneratorComponent.generate(
                client.getDni(),
                client.getSurname()
        ));

        ClientEntity clientEntity = this.clientRepository.save(this.clientMapper.convertFromClientToEntity(client));

        return this.clientMapper.convertFromEntitytoClient(clientEntity);
    }

    public void deleteById(Long id) {
        this.clientRepository.deleteById(id);
    }

}
