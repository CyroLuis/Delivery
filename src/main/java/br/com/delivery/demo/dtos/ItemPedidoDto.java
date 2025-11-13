package br.com.delivery.demo.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

// DTO para informar CADA item do pedido
public record ItemPedidoDto(
        @NotNull Long produtoId,
        @NotNull @Positive int quantidade
) {



}