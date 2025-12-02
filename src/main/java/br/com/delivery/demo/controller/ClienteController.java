package br.com.delivery.demo.controller;

import br.com.delivery.demo.dtos.ClienteDto;
import br.com.delivery.demo.model.Cliente;
import br.com.delivery.demo.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;

    //esta action cria um novo cliente
    @PostMapping("/save")
    public ResponseEntity<Cliente> saveClient(@RequestBody @Valid ClienteDto clienteDto) {
        var cliente = new Cliente();
        BeanUtils.copyProperties(clienteDto, cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
    }
    //esta action mostra todos os clientes cadastrados
    @GetMapping("all")
    public ResponseEntity<List<Cliente>> clienteAll(){
        List<Cliente> listaCliente = clienteRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listaCliente);
    }

    //esta action deleta um cliente
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id") Long id) {
        Optional<Cliente> clienteO = clienteRepository.findById(id);
        if (clienteO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não Encontrado");
        }
        clienteRepository.delete(clienteO.get());

        return ResponseEntity.status(HttpStatus.OK).body("Cliente Deletado");
    }
}