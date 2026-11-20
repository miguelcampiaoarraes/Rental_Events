package com.senai.backend.rental_events.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.senai.backend.rental_events.models.Movimentacao;
import com.senai.backend.rental_events.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @GetMapping("/contar-movimentacoes")
    public Long contarMovimentacoes() {
        return movimentacaoService.contarMovimentacoes();
    }

    @GetMapping("/buscar-movimentacao/{id}")
    public Movimentacao buscarMovimentacao(@PathVariable Integer id) {
        return movimentacaoService.buscarMovimentacao(id);
    }

    @GetMapping("/listar-movimentacoes")
    public List<Movimentacao> listarMovimentacoes() {
        return movimentacaoService.listarMovimentacoes();
    }

    @DeleteMapping("/deletar-movimentacao/{id}")
    public String deletarMovimentacao(@PathVariable Integer id) {
        if (movimentacaoService.deletarMovimentacao(id)) {
            return "Movimentacao removida com sucesso.";
        }
        return "Falha ao remover movimentacao.";
    }

    @PostMapping("/salvar-movimentacao")
    public Movimentacao cadastrarMovimentacao(@RequestBody Movimentacao movimentacao) {
        return movimentacaoService.cadastrarMovimentacao(movimentacao);
    }

    @PutMapping("/atualizar-movimentacao/{id}")
    public String atualizarMovimentacao(@PathVariable Integer id, @RequestBody Movimentacao movimentacao) {
        if (movimentacaoService.atualizarMovimentacao(id, movimentacao) != null) {
            return "Movimentacao atualizada com sucesso.";
        }
        return "Falha ao atualizar movimentacao.";
    }
}