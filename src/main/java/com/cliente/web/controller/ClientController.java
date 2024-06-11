package com.cliente.web.controller;

import com.cliente.domain.entity.Client;
import com.cliente.service.ClientService;
import com.cliente.web.dto.ClientRequestDto;
import com.cliente.web.dto.ClientResponseDto;
import com.cliente.web.dto.mapper.ClientMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    public String status() {
        return "ok";
    }

    @PostMapping
    private ResponseEntity<Void> create(@RequestBody @Valid ClientRequestDto client) {
        Client clientResponse = ClientMapper.toClient(client);
        clientService.create(clientResponse);
        URI locale = ServletUriComponentsBuilder.fromCurrentRequest().query("cpf={cpf}").buildAndExpand(clientResponse.getCpf()).toUri();
        return ResponseEntity.created(locale).build();
    }

    @GetMapping(params = "cpf")
    private ResponseEntity<ClientResponseDto> dataClient(@RequestParam("cpf") String cpf) {
        try {


            Client clientResponse = clientService.getByCpf(cpf);
            return ResponseEntity.ok(ClientMapper.toDto(clientResponse));

        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
