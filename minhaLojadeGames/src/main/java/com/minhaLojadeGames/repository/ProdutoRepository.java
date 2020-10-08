package com.minhaLojadeGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minhaLojadeGames.model.ProdutoModel;


// Importar a model e a List (Nao esquecer)
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{

	public List<ProdutoModel> findByNome (String nome); 

}
