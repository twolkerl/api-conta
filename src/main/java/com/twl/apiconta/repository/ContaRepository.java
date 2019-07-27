package com.twl.apiconta.repository;

import com.twl.apiconta.model.Conta;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repositório para manipulação de {@link com.twl.apiconta.model.Conta}.
 *
 * @author <a href="mailto:tiago.wolker.leite@gmail.com">Tiago Wolker Leite</a>
 * @since 7/26/2019 10:42 PM
 */
public interface ContaRepository extends MongoRepository<Conta, String> {
}
