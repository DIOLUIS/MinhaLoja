package com.diotec.MyStoreControll.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diotec.MyStoreControll.entities.Cliente;
import com.diotec.MyStoreControll.entities.Pedido;
import com.diotec.MyStoreControll.repositories.PedidoRepository;
import com.diotec.MyStoreControll.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) {

		Optional<Pedido> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	public List<Pedido> findAll() {
		return repo.findAll();
	}
}
