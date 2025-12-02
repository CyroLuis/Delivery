package br.com.delivery.demo.dtos;

import jakarta.validation.constraints.NotBlank;

public record StatusPedidoDto(@NotBlank String novoStatus) {


}
