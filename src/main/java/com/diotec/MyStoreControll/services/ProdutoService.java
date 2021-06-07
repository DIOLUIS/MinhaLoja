package com.diotec.MyStoreControll.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diotec.MyStoreControll.entities.Produto;
import com.diotec.MyStoreControll.repositories.ProdutoRepository;
import com.diotec.MyStoreControll.services.exception.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;

	public Produto find(Integer id) {

		Optional<Produto> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Produto.class.getName()));
	}

	public List<?> findAll() {
		List<Produto> list = repo.findAll();
		return list;
	}
}
