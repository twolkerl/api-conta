package com.twl.apiconta.controller;

import com.twl.apiconta.model.Conta;
import com.twl.apiconta.service.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Controller com as operações de {@link com.twl.apiconta.model.Conta}.
 *
 * @author <a href="mailto:tiago.wolker.leite@gmail.com">Tiago Wolker Leite</a>
 * @since 7/26/2019 10:40 PM
 */
@Controller
@RequestMapping("/conta")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    /**
     * GET /conta
     * <br/>Lista todas contas cadastradas -> Possivel paginar
     *
     * @param size Quantidade de registros máximos a serem buscados
     * @param page Número da paginação
     * @return Lista de {@link com.twl.apiconta.model.Conta}.
     */
    @GetMapping
    public ResponseEntity<List<Conta>> getAllContas(
            @RequestParam(name = "size", required = false) Integer size,
            @RequestParam(name = "page", required = false)Integer page) {

        List<Conta> contas = contaService.findAllContas(size, page);

        return CollectionUtils.isEmpty(contas)
                ? ResponseEntity.status(HttpStatus.NO_CONTENT).body(null)
                : ResponseEntity.status(HttpStatus.OK).body(contas);
    }
}
