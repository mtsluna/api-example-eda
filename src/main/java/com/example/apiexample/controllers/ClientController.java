package com.example.apiexample.controllers;

import com.example.apiexample.domain.Client;
import com.example.apiexample.dtos.clients.ClientDto;
import com.example.apiexample.mappers.ClientMapper;
import com.example.apiexample.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    private final ClientMapper clientMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getById(@PathVariable Long id) throws Exception {

        Client client = this.clientService.findById(id);

        ClientDto clientDto = this.clientMapper.convert(client);

        return ResponseEntity.status(HttpStatus.OK).body(clientDto);
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getAll() {
        List<Client> clients = this.clientService.findAll();

        List<ClientDto> clientDtos = clients.stream().map(this.clientMapper::convert).toList();

        return ResponseEntity.status(HttpStatus.OK).body(clientDtos);
    }

    @PostMapping
    public ResponseEntity<ClientDto> create(@RequestBody ClientDto clientDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                this.clientMapper.convert(
                        this.clientService.create(
                                this.clientMapper.convert(clientDto)
                        )
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> update(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.clientMapper.convert(
                        this.clientService.update(
                                id,
                                this.clientMapper.convert(clientDto)
                        )
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.clientService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
