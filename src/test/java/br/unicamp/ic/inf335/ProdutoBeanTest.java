package br.unicamp.ic.inf335;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.unicamp.ic.inf335.beans.ProdutoBean;

class ProdutoBeanTest {

	ProdutoBean produto = new ProdutoBean("PN123", "Motor","Motor Esteira de Entrada", (double) 300, "Novo");
 
	@Test
	void testGetCodigo() {
		String	codigo = produto.getCodigo();
		assertEquals("PN123", codigo);
	}

	@Test
	void testSetCodigo() {
		produto.setCodigo("PN456");
		String codigo = produto.getCodigo();
		assertEquals("PN456", codigo);
	}

	@Test
	void testGetNome() {
		String nome = produto.getNome();
		assertEquals("Motor", nome);
	}
	
	@Test
	void testSetNome() {
		produto.setNome("Suporte");
		String nome = produto.getNome();
		assertEquals("Suporte", nome);
	}
 
	@Test
	void testGetDescricao() {
		String descricao = produto.getDescricao();
		assertEquals("Motor Esteira de Entrada", descricao);
	}

	@Test
	void testSetDescricao() {
		produto.setDescricao("Suporte da Esteira de Entrada");
		String descricao = produto.getDescricao();
		assertEquals("Suporte da Esteira de Entrada", descricao);
	}

	@Test
	void testGetValor() {
		double valor = produto.getValor();
		assertEquals((double) 300, valor);
	}

	@Test
	void testSetValor() {
		produto.setValor((double) 500);
		double valor = produto.getValor();
		assertEquals((double) 500, valor);
	}

	@Test
	void testGetEstado() {
		String estado = produto.getEstado();
		assertEquals("Novo", estado);
	}

	@Test
	void testSetEstado() {
		produto.setEstado("Usado");
		String estado = produto.getEstado();
		assertEquals("Usado", estado);
	}
}