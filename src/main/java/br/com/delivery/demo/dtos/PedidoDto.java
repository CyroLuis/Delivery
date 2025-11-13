package br.com.delivery.demo.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record PedidoDto(@NotNull Long clienteId,
                        @NotEmpty List<ItemPedidoDto> itens) {
}
