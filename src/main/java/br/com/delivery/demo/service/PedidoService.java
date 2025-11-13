package br.com.delivery.demo.service;

import br.com.delivery.demo.dtos.ItemPedidoDto;
import br.com.delivery.demo.dtos.PedidoDto;
import br.com.delivery.demo.model.Cliente;
import br.com.delivery.demo.model.ItemPedido;
import br.com.delivery.demo.model.Pedido;
import br.com.delivery.demo.model.Produto;
import br.com.delivery.demo.repository.ClienteRepository;
import br.com.delivery.demo.repository.PedidoRepository;
import br.com.delivery.demo.repository.ProdutoRepositoy;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    ProdutoRepositoy produtoRepositoy;

    @Transactional // Garante que tudo seja salvo ou nada (em caso de erro)
    public Pedido criarPedido(PedidoDto pedidoDto){
        //Buscar Cliente
       Cliente clientep = clienteRepository.findById(pedidoDto.clienteId())
                                            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        //crir pedido

        Pedido pedido = new Pedido();
        pedido.setCliente(clientep);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus("PENDENTE");

        List<ItemPedido> itensPedido = new ArrayList<>();
        Double valorTotal = 0.0;

        //iterar sobre os dtos do itens
        for (ItemPedidoDto itemDto: pedidoDto.itens()){
            //buscar produto
            Produto produto = produtoRepositoy.findById(itemDto.produtoId())
                                                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
            //3 criar o itemPedido

            ItemPedido itempedido = new ItemPedido();
            itempedido.setPedido(pedido); //Associa o item ao pedido
            itempedido.setProduto(produto);
            itempedido.setQuantidade(itemDto.quantidade());
            itempedido.setPrecoUnitario(produto.getPreco()); //Pega o preço atual do produto

            itensPedido.add(itempedido);

            valorTotal += (produto.getPreco() * itemDto.quantidade());

        };
        // 4. Associar os itens ao pedido e salvar
        pedido.setItens(itensPedido);
        pedido.setValorTotal(valorTotal); // Exemplo

        return pedidoRepository.save(pedido);
    }
}

















