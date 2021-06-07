package com.diotec.MyStoreControll.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diotec.MyStoreControll.entities.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Integer>{

}
