package com.minhaLojadeGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minhaLojadeGames.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{

	public List<UsuarioModel> findByNome (String nome); 

}
