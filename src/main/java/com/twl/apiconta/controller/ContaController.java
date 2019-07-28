package com.twl.apiconta.controller;

import com.twl.apiconta.model.Conta;
import com.twl.apiconta.service.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.validation.ConstraintViolationException;

/**
 * Controller com as operações de {@link com.twl.apiconta.model.Conta}.
 *
 * @author <a href="mailto:tiago.wolker.leite@gmail.com">Tiago Wolker Leite</a>
 * @since 7/26/2019 10:40 PM
 */
@Controller
@RequestMapping("/conta")
public class ContaController {

    private static final String APPLICATION_JSON = "application/json";

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
            @RequestParam(name = "page", required = false) Integer page) {

        List<Conta> contas = contaService.findAll(size, page);

        return CollectionUtils.isEmpty(contas)
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(contas, HttpStatus.OK);
    }

    /**
     * GET /conta/{id}
     * <br/>Retorna uma conta especifica pelo ID
     *
     * @return uma {@link com.twl.apiconta.model.Conta} correspondente ao id informado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Conta> getContaById(@PathVariable String id) {

        Conta conta = contaService.findById(id);

        return Objects.isNull(conta)
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(conta, HttpStatus.OK);
    }

    /**
     * POST /conta
     * <br/>Salva uma conta na base de dados
     *
     * @param conta JSON com as informações da nova {@link com.twl.apiconta.model.Conta}
     * @return nova {@link com.twl.apiconta.model.Conta} salva
     */
    @PostMapping(consumes = APPLICATION_JSON)
    public ResponseEntity<?> saveConta(@RequestBody Conta conta) {

        try {
            return new ResponseEntity<>(contaService.save(conta), HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * PUT /conta/{id}
     * <br/>Atualiza um conta
     *
     * @return registro de {@link com.twl.apiconta.model.Conta} atualizada
     */
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON)
    public ResponseEntity<?> updateConta(
            @PathVariable String id,
            @RequestBody Conta conta) {

        try {
            return new ResponseEntity<>(contaService.update(id, conta), HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * DELETE /conta/{id}
     * <br/>Faz o delete lógico da conta (status = false)
     *
     * @return {@link org.springframework.http.ResponseEntity} com o status da operação
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteConta(@PathVariable String id) {

        contaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
