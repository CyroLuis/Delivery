package br.com.delivery.demo.controller;

import br.com.delivery.demo.dtos.PedidoDto;
import br.com.delivery.demo.dtos.StatusPedidoDto;
import br.com.delivery.demo.model.Pedido;
import br.com.delivery.demo.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    PedidoService pedidoService;

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
    public ResponseEntity<?> buscarPedido (@PathVariable(value = "id") Long id){
      try {
          Pedido pedido = pedidoService.buscarPorId(id);

          return ResponseEntity.status(HttpStatus.OK).body(pedido);
      } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
      }
    }
    @PatchMapping("/{id}/status")
    public ResponseEntity<?> atualizarStatus (@PathVariable(value = "id") Long id, @Valid @RequestBody StatusPedidoDto statusDto) {

        try {
            Pedido pedidoAtualizado = pedidoService.atualizarStatus(id, statusDto);

            return ResponseEntity.status(HttpStatus.OK).body(pedidoAtualizado);
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }















}

