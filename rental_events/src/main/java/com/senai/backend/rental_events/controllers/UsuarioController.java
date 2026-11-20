package com.senai.backend.rental_events.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.senai.backend.rental_events.models.Usuario;
import com.senai.backend.rental_events.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/contar-usuarios")
    public Long contarUsuarios() {
        return usuarioService.contarUsuarios();
    }

    @GetMapping("/buscar-usuario/{id}")
    public Usuario buscarUsuario(@PathVariable Integer id) {
        return usuarioService.buscarUsuario(id);
    }

    @GetMapping("/listar-usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @DeleteMapping("/deletar-usuario/{id}")
    public String deletarUsuario(@PathVariable Integer id) {
        if (usuarioService.deletarUsuario(id)) {
            return "Usuario removido com sucesso.";
        }
        return "Falha ao remover usuario.";
    }

    @PostMapping("/salvar-usuario")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.cadastrarUsuario(usuario);
    }

    @PutMapping("/atualizar-usuario/{id}")
    public String atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        if (usuarioService.atualizarUsuario(id, usuario) != null) {
            return "Usuario atualizado com sucesso.";
        }
        return "Falha ao atualizar usuario.";
    }
}