package com.twl.apiconta.service.impl;

import com.twl.apiconta.model.Conta;
import com.twl.apiconta.repository.ContaRepository;
import com.twl.apiconta.service.ContaService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Implementação de {@link com.twl.apiconta.service.ContaService}.
 *
 * @author <a href="mailto:tiago.wolker.leite@gmail.com">Tiago Wolker Leite</a>
 * @since 7/26/2019 10:47 PM
 */
@Service
public class ContaServiceImpl implements ContaService {

    private final ContaRepository contaRepository;

    public ContaServiceImpl(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public List<Conta> findAllContas(Integer size, Integer page) {

        return Objects.nonNull(size) && Objects.nonNull(page)
                ? contaRepository.findAll(PageRequest.of(page, size)).getContent()
                : contaRepository.findAll();
    }
}
