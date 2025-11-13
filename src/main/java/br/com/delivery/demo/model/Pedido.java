package br.com.delivery.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "TAB_PEDIDOS")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPedido;

    @Column(nullable = false)
    LocalDateTime dataPedido;

    @Column(nullable = false)
    String status;

    @Column(nullable = false)
    Double valorTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL,orphanRemoval = true)
    List<ItemPedido> itens;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}
