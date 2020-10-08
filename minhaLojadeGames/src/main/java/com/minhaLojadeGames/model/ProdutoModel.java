package com.minhaLojadeGames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "produto")
public class ProdutoModel {

	// Meus atributos
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotNull
		@Size(min = 5, max = 100)
		private String nome; 
		
		@NotNull
		@Size(min = 5, max = 100)
		private String categoriaProduto;

		
		// Foreing Key do meu produto
		
		@ManyToOne
		@JsonIgnoreProperties("produtos")
		private CategoriaModel categoria;
		
		
		// Getter e Setter 
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCategoriaProduto() {
			return categoriaProduto;
		}

		public void setCategoriaProduto(String categoriaProduto) {
			this.categoriaProduto = categoriaProduto;
		}

		public CategoriaModel getCategoria() {
			return categoria;
		}

		public void setCategoria(CategoriaModel categoria) {
			this.categoria = categoria;
		}

		

		
		
		
}
