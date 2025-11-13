package br.com.delivery.demo.repository;

import br.com.delivery.demo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositoy extends JpaRepository<Produto,Long> {

}
