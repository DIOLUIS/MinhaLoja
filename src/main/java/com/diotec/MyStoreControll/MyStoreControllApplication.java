package com.diotec.MyStoreControll;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diotec.MyStoreControll.entities.Cliente;
import com.diotec.MyStoreControll.entities.Endereco;
import com.diotec.MyStoreControll.entities.ItemPedido;
import com.diotec.MyStoreControll.entities.Pagamento;
import com.diotec.MyStoreControll.entities.Pedido;
import com.diotec.MyStoreControll.entities.Produto;
import com.diotec.MyStoreControll.enums.EstadoPagamento;
import com.diotec.MyStoreControll.repositories.ClienteRepository;
import com.diotec.MyStoreControll.repositories.EnderecoRepository;
import com.diotec.MyStoreControll.repositories.ItemPedidoRepository;
import com.diotec.MyStoreControll.repositories.PagamentoRepository;
import com.diotec.MyStoreControll.repositories.PedidoRepository;
import com.diotec.MyStoreControll.repositories.ProdutoRepository;

@SpringBootApplication
public class MyStoreControllApplication implements CommandLineRunner {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyStoreControllApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Produto p1 = new Produto(null, "MiBox", 180.00, 315.00, 10);
		Produto p2 = new Produto(null, "Fone JBL", 80.00, 160.00, 3);
		Produto p3 = new Produto(null, "Maquina de cortar cabelo", 50.00, 150.00, 10);
		Produto p4 = new Produto(null, "note", 180.00, 315.00, 10);
		Produto p5 = new Produto(null, "celilar JBL", 80.00, 160.00, 3);
		Produto p6 = new Produto(null, "faca de cortar cabelo", 50.00, 150.00, 10);
		Produto p7 = new Produto(null, "tv", 180.00, 315.00, 10);
		Produto p8 = new Produto(null, "video JBL", 80.00, 160.00, 3);
		Produto p9 = new Produto(null, "navalha de cortar cabelo", 50.00, 150.00, 10);
		Produto p10 = new Produto(null, "videogame", 180.00, 315.00, 10);
		Produto p11 = new Produto(null, "Fonite JBL", 80.00, 160.00, 3);
		Produto p12 = new Produto(null, "pente cabelo", 50.00, 150.00, 10);
		Produto p13 = new Produto(null, "video", 180.00, 315.00, 10);
		Produto p14 = new Produto(null, "autofalante JBL", 80.00, 160.00, 3);
		Produto p15 = new Produto(null, "Maquina", 50.00, 150.00, 10);

		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15));

		Cliente cli1 = new Cliente(null, "Diogo", "diogo@gmail.com");
		Cliente cli2 = new Cliente(null, "Hulk", "hulk@gmail.com");
		Cliente cli3 = new Cliente(null, "gabi", "gabi@gmail.com");

		cli1.getTelefones().addAll(Arrays.asList("12344567", "123654794"));
		cli2.getTelefones().addAll(Arrays.asList("4587369", "1258749632"));
		cli3.getTelefones().addAll(Arrays.asList("852647931", "879546213"));

		Endereco e1 = new Endereco(null, "Massatake", "11", "casa1", "Parque do lago", "04955-123", cli3);
		Endereco e2 = new Endereco(null, "Semantica", "117", "5", "Paraiso", "36974-123", cli2);
		Endereco e3 = new Endereco(null, "Desastre", "87", "4", "Paraisopolis", "15975-123", cli1);

		cli1.getEnderecos().add(e3);
		cli2.getEnderecos().add(e2);
		cli3.getEnderecos().add(e1);

		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2020"), cli3, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("01/01/2021"), cli2, e2);
		Pedido ped3 = new Pedido(null, sdf.parse("15/04/2020"), cli1, e3);

		Pagamento pagto1 = new Pagamento(null, EstadoPagamento.QUITADO, ped1);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new Pagamento(null, EstadoPagamento.PENDENTE, ped2);
		ped2.setPagamento(pagto2);

		Pagamento pagto3 = new Pagamento(null, EstadoPagamento.CANCELADO, ped3);
		ped3.setPagamento(pagto3);

		cli1.getPedidos().add(ped3);
		cli2.getPedidos().add(ped2);
		cli3.getPedidos().add(ped1);

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2, pagto3));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 3, 315.00);
		ItemPedido ip2 = new ItemPedido(ped2, p2, 0.00, 4, 160.00);
		ItemPedido ip3 = new ItemPedido(ped3, p3, 100.00, 6, 150.00);

		ped1.getItens().add(ip1);
		ped2.getItens().add(ip2);
		ped3.getItens().add(ip3);

		p1.getItens().add(ip1);
		p2.getItens().add(ip2);
		p3.getItens().add(ip3);

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}

}
