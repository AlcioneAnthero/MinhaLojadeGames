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

import com.minhaLojadeGames.model.CategoriaModel;
import com.minhaLojadeGames.repository.CategoriaRepository;

@RestController
@RequestMapping("/Categorias")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping("/categorias")
	public List<CategoriaModel> pegarTodos() {
		return repository.findAll();
	}


	@PostMapping("/categoria")
	public CategoriaModel criar(@RequestBody CategoriaModel model) {
		repository.save(model);
		return model;
	}

	@GetMapping("/categoria/nome/{nome}")
	public List<CategoriaModel> buscarPorNome(@PathVariable String nome) {
		return repository.findByNome(nome);
	}

	@PutMapping("/categoria/{id}")
	public CategoriaModel atualizar(@PathVariable Long id, @RequestBody CategoriaModel model) {
		model.setId(id);
		repository.save(model);
		return model;
	}

	@DeleteMapping("/categoria/{id}")
	public String remover(@PathVariable Long id) {
		repository.deleteById(id);
		return "sucesso";
	}

}
