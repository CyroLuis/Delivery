package br.com.delivery.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDto(@NotBlank String nome,
                         @NotNull Double preco) {
}
