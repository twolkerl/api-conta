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
    List<Conta> findAll(Integer size, Integer page);

    /**
     * Busca uma conta por seu identificador.
     *
     * @param id {@link com.twl.apiconta.model.Conta#getId()}
     * @return {@link com.twl.apiconta.model.Conta} correspondente ao ID informado
     */
    Conta findById(String id);

    /**
     * Salva uma nova {@link com.twl.apiconta.model.Conta} na base de dados.
     *
     * @param conta nova {@link com.twl.apiconta.model.Conta} a ser salva
     * @return nova {@link com.twl.apiconta.model.Conta} salva
     */
    Conta save(Conta conta);

    /**
     * Atualiza a {@link com.twl.apiconta.model.Conta} do ID informado.
     *
     * @param id {@link com.twl.apiconta.model.Conta#getId()}
     * @param conta {@link com.twl.apiconta.model.Conta} a ser atualizada
     * @return {@link com.twl.apiconta.model.Conta} atualizada
     */
    Conta update(String id, Conta conta);
}
