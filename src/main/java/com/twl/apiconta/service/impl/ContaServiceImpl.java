package com.twl.apiconta.service.impl;

import com.twl.apiconta.model.Conta;
import com.twl.apiconta.repository.ContaRepository;
import com.twl.apiconta.service.ContaService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.validation.Valid;

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
    public List<Conta> findAll(Integer size, Integer page) {

        return Objects.nonNull(size) && Objects.nonNull(page)
                ? contaRepository.findAll(PageRequest.of(page, size)).getContent()
                : contaRepository.findAll();
    }

    @Override
    public Conta findById(String id) {
        return contaRepository.findById(id).orElse(null);
    }

    @Override
    public Conta save(@Valid Conta conta) {

        conta.setDataCriacao(LocalDate.now());
        conta.setStatus(true);

        return contaRepository.save(conta);
    }

    @Override
    public Conta update(String id, @Valid Conta conta) {

        Conta existingConta = contaRepository.findById(id).orElse(null);

        if (Objects.nonNull(existingConta)) {
            existingConta.setNumero(conta.getNumero());
            existingConta.setAgencia(conta.getAgencia());
            existingConta.setCpf(conta.getCpf());
            existingConta.setStatus(conta.isStatus());
            existingConta.setDataAtualizacao(LocalDate.now());

            return contaRepository.save(existingConta);
        } else {
            /*
             * Outra abordagem seria realizar o upsert, salvando uma nova conta caso não existisse uma para o ID
             * informado, porém com finalidade de distinguir as funções de save e update, optei por esta abordagem.
             */
            throw new NoSuchElementException("Não existe conta para o ID informado!");
        }
    }
}
