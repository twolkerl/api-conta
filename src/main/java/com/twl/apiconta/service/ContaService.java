package com.twl.apiconta.service;

import com.twl.apiconta.model.Conta;

import java.util.List;

/**
 * Serviços de {@link com.twl.apiconta.model.Conta}.
 *
 * @author <a href="mailto:tiago.wolker.leite@gmail.com">Tiago Wolker Leite</a>
 * @since 7/26/2019 10:47 PM
 */
public interface ContaService {

    /**
     * Busca todos os registros de {@link com.twl.apiconta.model.Conta}. Caso ambos os parâmetros sejam informados,
     * irá buscar a página solicitada.
     *
     * @param size Quantidade de registros máximos a serem buscados
     * @param page Número da paginação
     * @return Lista de {@link com.twl.apiconta.model.Conta}
     */
    List<Conta> findAllContas(Integer size, Integer page);
}
