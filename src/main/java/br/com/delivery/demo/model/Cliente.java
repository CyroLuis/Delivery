package br.com.delivery.demo.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "Clientes")
public class Cliente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long idCliente;

    @Column(length = 50, nullable = false)
    String name;

    @Column(length = 100, nullable = false)
    String endereco;

    @Column(length = 10, nullable = false)
    Integer telefone;

}
