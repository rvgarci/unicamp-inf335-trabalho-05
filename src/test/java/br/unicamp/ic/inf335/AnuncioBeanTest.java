 package br.unicamp.ic.inf335;

 import br.unicamp.ic.inf335.beans.*;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import br.unicamp.ic.inf335.beans.ProdutoBean;

class AnuncioBeanTest {

	ProdutoBean produtoA = new ProdutoBean("PN123", "Motor","Motor Esteira de Entrada", (double) 300, "Novo");
	ArrayList<URL> fotosUrl = new ArrayList<URL>();
	double desconto = (double) 0.1;	

	// Main object
	AnuncioBean anuncio = new AnuncioBean(produtoA, fotosUrl, desconto);

	@Test
	void testGetProduto() {
		ProdutoBean produto = anuncio.getProduto();
		assertAll("produto",
				() -> assertEquals("PN123", produto.getCodigo()),
				() -> assertEquals("Motor", produto.getNome()),
				() -> assertEquals("Motor Esteira de Entrada", produto.getDescricao()),
				() -> assertEquals((double) 300, produto.getValor()),
				() -> assertEquals("Novo", produto.getEstado())
				);
	}

	@Test
	void testSetProduto() {
		ProdutoBean produtoB = new ProdutoBean("PN456", "Suporte","Suporte da Esteira de Entrada", (double) 500, "Usado");
		anuncio.setProduto(produtoB);
		ProdutoBean produtoResultado = anuncio.getProduto();		
		assertAll("produtoResultado",
				() -> assertEquals("PN456", produtoResultado.getCodigo()),
				() -> assertEquals("Suporte", produtoResultado.getNome()),
				() -> assertEquals("Suporte da Esteira de Entrada", produtoResultado.getDescricao()),
				() -> assertEquals((double) 500, produtoResultado.getValor()),
				() -> assertEquals("Usado", produtoResultado.getEstado())
				);
	}

	@Test
	void testGetFotosUrl() throws MalformedURLException {

		URL url = new URL("http://www.unicamp.com/foto_1");
		fotosUrl.add(url);

		url = new URL("http://www.unicamp.com/foto_2");
		fotosUrl.add(url);

		anuncio.setFotosUrl(fotosUrl);

		ArrayList<URL> fotosUrlResultado = anuncio.getFotosUrl();
		
		assertAll("fotosUrlResultado",
				() -> assertEquals(fotosUrl.get(0), fotosUrlResultado.get(0)),
				() -> assertEquals(fotosUrl.get(1), fotosUrlResultado.get(1))
				);
				
		System.out.println(fotosUrl + "\n" + fotosUrlResultado);
	}

	@Test
	void testSetFotosUrl() throws MalformedURLException {
		
		URL url = new URL("http://www.unicamp.com/foto_3");
		fotosUrl.add(url);

		url = new URL("http://www.unicamp.com/foto_4");
		fotosUrl.add(url);

		anuncio.setFotosUrl(fotosUrl);

		ArrayList<URL> fotosUrlResultado = anuncio.getFotosUrl();
		assertAll("fotosUrlResultado",
				() -> assertEquals(fotosUrl.get(0), fotosUrlResultado.get(0)),
				() -> assertEquals(fotosUrl.get(1), fotosUrlResultado.get(1))
				);
	}


	@Test
	void testGetDesconto() {
		desconto = anuncio.getDesconto();
		assertEquals((double) .1, desconto);
	}


	@Test
	void testSetDesconto() {
		anuncio.setDesconto((double) 0.2);
		desconto = anuncio.getDesconto();
		assertEquals(0.2, desconto);
	}

	@Test
	void testGetValor() {
		double valor = anuncio.getValor();
		assertEquals((double) 270, valor);
	}
}
