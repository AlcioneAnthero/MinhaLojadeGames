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

import com.minhaLojadeGames.model.ProdutoModel;
import com.minhaLojadeGames.repository.ProdutoRepository;

@RestController
@RequestMapping("/Produtos")
@CrossOrigin("*")
public class ProdutoController {

	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping("/produtos")
	public List<ProdutoModel> pegarTodos() {
		return repository.findAll();
	}


	@PostMapping("/produto")
	public ProdutoModel criar(@RequestBody ProdutoModel model) {
		repository.save(model);
		return model;
	}

	@GetMapping("/produto/nome/{nome}")
	public List<ProdutoModel> buscarPorNome(@PathVariable String nome) {
		return repository.findByNome(nome);
	}

	@PutMapping("/produto/{id}")
	public ProdutoModel atualizar(@PathVariable Long id, @RequestBody ProdutoModel model) {
		model.setId(id);
		repository.save(model);
		return model;
	}

	@DeleteMapping("/produto/{id}")
	public String remover(@PathVariable Long id) {
		repository.deleteById(id);
		return "sucesso";
	}

}
