package com.diotec.MyStoreControll.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.diotec.MyStoreControll.entities.Produto;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 4, max = 80, message = "O tamanho deve ser entre 4 e 80 caracteres" )
	private String nome;
	private Double precoCompra;
	private Double precoVenda;
	private int quantidade;
	
	public ProdutoDTO() {
	}
	
	public ProdutoDTO (Produto obj) {
		id = obj.getId();
		nome = obj.getNome();
		precoCompra = obj.getPrecoCompra();
		precoVenda = obj.getPrecoVenda();
		quantidade = obj.getQuantidade();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(Double precoCompra) {
		this.precoCompra = precoCompra;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
