package com.minhaLojadeGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minhaLojadeGames.model.CategoriaModel;

// Aqui eu coloco a minha categoria e o FindyByNome
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{

		public List<CategoriaModel> findByNome (String nome);

	
}
