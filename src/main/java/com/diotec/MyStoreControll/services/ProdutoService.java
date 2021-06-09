package com.diotec.MyStoreControll.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.diotec.MyStoreControll.dto.ProdutoDTO;
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

	public List<Produto> findAll() {
		return repo.findAll();
	}

	public Page<Produto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Produto insert(Produto obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Produto fromDTO(ProdutoDTO objDto) {
		return new Produto(objDto.getId(), objDto.getNome(), objDto.getPrecoCompra(), objDto.getPrecoVenda(),
				objDto.getQuantidade());
	}

	public Produto update(Produto obj) {
		find(obj.getId());
		return repo.save(obj);
	}
}
