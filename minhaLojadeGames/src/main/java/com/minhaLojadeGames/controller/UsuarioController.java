package com.minhaLojadeGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minhaLojadeGames.model.UsuarioModel;
import com.minhaLojadeGames.repository.UsuarioRepository;

@RestController
@RequestMapping("/Usuarios")
@CrossOrigin("*")
public class UsuarioController {

	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping("/usuarios")
	public List<UsuarioModel> pegarTodos() {
		return repository.findAll();
	}


	@PostMapping("/usuario")
	public UsuarioModel criar(@RequestBody UsuarioModel model) {
		repository.save(model);
		return model;
	}

	@GetMapping("/usuario/nome/{nome}")
	public List<UsuarioModel> buscarPorNome(@PathVariable String nome) {
		return repository.findByNome(nome);
	}

	@PutMapping("/usuario/{id}")
	public UsuarioModel atualizar(@PathVariable Long id, @RequestBody UsuarioModel model) {
		model.setId(id);
		repository.save(model);
		return model;
	}

	@DeleteMapping("/usuario/{id}")
	public String remover(@PathVariable Long id) {
		repository.deleteById(id);
		return "sucesso";
	}

}
