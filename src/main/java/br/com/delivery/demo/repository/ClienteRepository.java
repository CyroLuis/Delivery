package br.com.delivery.demo.repository;

import br.com.delivery.demo.model.Cliente;
import br.com.delivery.demo.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente,Long> {

}
