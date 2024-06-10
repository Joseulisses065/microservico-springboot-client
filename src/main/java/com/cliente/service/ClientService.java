package com.cliente.service;

import com.cliente.domain.entity.Client;
import com.cliente.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    @Transactional
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Transactional(readOnly = true)
    public Client getByCpf(String cpf){
        return clientRepository.findByCpf(cpf).orElseThrow(
                ()->new EntityNotFoundException("Entity not found")
        );
    }

}
