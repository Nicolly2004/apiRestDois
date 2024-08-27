package com.nicollyreis.com.apiRest2.controller;

import com.nicollyreis.com.apiRest2.dtos.UsuarioDTO;
import com.nicollyreis.com.apiRest2.form.CreateUsuarioForm;
import com.nicollyreis.com.apiRest2.model.Usuario;
import com.nicollyreis.com.apiRest2.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //cadastrar
    @PostMapping
    public ResponseEntity<UsuarioDTO> store(@RequestBody CreateUsuarioForm form){
        Usuario usuario = form.convert();
        this.usuarioRepository.save(usuario);
        return new ResponseEntity<>(new UsuarioDTO(usuario), HttpStatus.CREATED);
    }

    //listar
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listaUsuario(){
        List<Usuario> usuarios = this.usuarioRepository.findAll();
        List<UsuarioDTO> usuarioDTOList = usuarios.stream().map(UsuarioDTO::new).toList();
        return new ResponseEntity<>(usuarioDTOList,HttpStatus.OK);
    }

    //atualizar
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @RequestBody CreateUsuarioForm form){
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);

        if(usuario.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Usuario usuarioUpdated = form.update(usuario.get());
        this.usuarioRepository.save(usuarioUpdated);
        return new ResponseEntity<>(new UsuarioDTO(usuarioUpdated),HttpStatus.OK);
    }


    //listar um único usuário
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> show(@PathVariable Long id){
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);

        if(usuario.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new UsuarioDTO(usuario.get()),HttpStatus.OK);
    }

    //deletar um usuário
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);

        if(usuario.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.usuarioRepository.delete(usuario.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
