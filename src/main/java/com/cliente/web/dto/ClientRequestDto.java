package com.cliente.web.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientRequestDto {
    @NotBlank
    private String cpf;
    @NotBlank
    private String  name;
    @NotBlank
    private String age;
}
