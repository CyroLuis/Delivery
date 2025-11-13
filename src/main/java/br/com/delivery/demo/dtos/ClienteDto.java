package br.com.delivery.demo.dtos;

import jakarta.validation.constraints.NotBlank;

public record ClienteDto(@NotBlank String name,
                         @NotBlank String endereco,
                         @NotBlank String telefone) {
}
