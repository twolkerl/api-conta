package com.twl.apiconta.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @NotBlank(message = "O campo 'número da conta' é obrigatório")
    @Size(max = 6, message = "O número da conta deve conter no máximo 6 dígitos")
    private String numero;

    @NotBlank(message = "O campo 'número da agência' é obrigatório")
    @Size(max = 4, message = "O número da agência deve conter no máximo 4 dígitos")
    private String agencia;

    @NotBlank(message = "O campo 'CPF' é obrigatório")
    @Size(max = 11, message = "O CPF deve conter no máximo 11 dígitos")
    private String cpf;

    @NotNull(message = "O campo 'status' é obrigatório")
    private boolean status;

    @NotNull(message = "O campo 'data da criação' é obrigatório")
    private LocalDate dataCriacao;

    private LocalDate dataAtualizacao;
}
