package br.com.delivery.demo.controller;

import br.com.delivery.demo.dtos.PedidoDto;
import br.com.delivery.demo.model.Pedido;
import br.com.delivery.demo.repository.PedidoRepository;
import br.com.delivery.demo.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    PedidoService pedidoService;
    @Autowired
    PedidoRepository pedidoRepository;

    @PostMapping("/save")
    public ResponseEntity<Pedido> savePedido(@RequestBody @Valid PedidoDto pedidoDto) {
        try {
            Pedido pedidoSalvo = pedidoService.criarPedido(pedidoDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
        } catch (RuntimeException e) {
            // (Idealmente, crie exceções customizadas)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/buscapedido/{id}")
    public ResponseEntity<Object> buscarPedido (@PathVariable(value = "id") Long id){
        Optional<Pedido> pedidocli = pedidoRepository.findById(id);
        if (pedidocli.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não foi encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pedidocli.get());
    }

    // Você pode adicionar outros métodos aqui (buscar pedido por id, listar pedidos de um cliente, etc.)
}

