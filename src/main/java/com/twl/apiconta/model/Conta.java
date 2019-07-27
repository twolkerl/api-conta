package com.twl.apiconta.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * POJO referente a <b>Conta</b>.
 *
 * @author <a href="mailto:tiago.wolker.leite@gmail.com">Tiago Wolker Leite</a>
 * @since 7/26/2019 10:20 PM
 */
@Data
@Builder
@Document(collection = "contas")
public class Conta {

    @Id
    private String id;
    private String numero;
    private String agencia;
    private String cpf;
    private boolean status;
    private LocalDate dataCriacao;
    private LocalDate dataAtualizacao;
}
