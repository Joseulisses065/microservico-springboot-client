package com.cliente.web.dto.mapper;

import com.cliente.domain.entity.Client;
import com.cliente.web.dto.ClientRequestDto;
import com.cliente.web.dto.ClientResponseDto;
import org.modelmapper.ModelMapper;

public class ClientMapper {
    public static ClientResponseDto toDto(Client client){
       return new ModelMapper().map(client, ClientResponseDto.class);
    }

    public static Client toClient(ClientRequestDto clientRequestDto){
        return new ModelMapper().map(clientRequestDto,Client.class);
    }
}
