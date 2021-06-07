package com.diotec.MyStoreControll.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diotec.MyStoreControll.entities.Produto;
import com.diotec.MyStoreControll.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> find() {
		List<?> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Produto obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}

}

/*
 * Produto p1 = new Produto(1, "Maquina de barbear", 80.00, 150.00, 4); Produto
 * p2 = new Produto(2, "Fone de ouvido", 50.00, 110.00, 8); Produto p3 = new
 * Produto(3, "Box TV 4K", 110.00, 210.00, 8);
 * 
 * return Arrays.asList(p1, p2, p3);
 */
