package br.unicamp.ic.inf335;

import br.unicamp.ic.inf335.beans.*;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AnuncianteBeanTest {

	//	ProdutoBean produto = new ProdutoBean("PN123", "Motor","Motor Esteira de Entrada", (double) 300, "Novo");
	//	ArrayList<URL> fotosUrl = new ArrayList<URL>();
	//	double desconto = (double) 0.1;	

	ArrayList<AnuncioBean> anuncios = new ArrayList<AnuncioBean>();
 
	private AnuncianteBean anunciante = new AnuncianteBean("Rafael Garcia", "312.831.778-03", anuncios);

	@Test
	void testSetNome() {
		anunciante.setNome("Felipe Duarte");
		assertEquals("Felipe Duarte", anunciante.getNome());	
	}

	@Test
	void testGetNome() {
		assertEquals( "Rafael Garcia", anunciante.getNome());
	}

	@Test
	void testSetCPF() {
		anunciante.setCPF("123.456.789-00");
		assertEquals("123.456.789-00", anunciante.getCPF());
	}

	@Test
	void testGetCPF() {
		String cpf = anunciante.getCPF();
		assertEquals("312.831.778-03", cpf);		
	}

	@Test
	void testSetAnuncios() throws MalformedURLException {

		ProdutoBean produtoA = new ProdutoBean("PN123", "Motor","Motor Esteira de Entrada", (double) 300, "Novo");
		ProdutoBean produtoB = new ProdutoBean("PN456", "Suporte","Suporte Esteira de Entrada", (double) 500, "Usado");		

		ArrayList<URL> fotosUrlA = new ArrayList<URL>();
		ArrayList<URL> fotosUrlB = new ArrayList<URL>();

		URL url = new URL("http://www.unicamp.com/foto_1");
		fotosUrlA.add(url);
		url = new URL("http://www.unicamp.com/foto_2");
		fotosUrlA.add(url);
		url = new URL("http://www.unicamp.com/foto_3");
		fotosUrlB.add(url);
		url = new URL("http://www.unicamp.com/foto_4");
		fotosUrlB.add(url);

		double descontoA = (double) 0.1;
		double descontoB = (double) 0.2;	

		AnuncioBean anuncioA = new AnuncioBean(produtoA, fotosUrlA, descontoA);
		AnuncioBean anuncioB = new AnuncioBean(produtoB, fotosUrlB, descontoB);

		anuncios.add(anuncioA);
		anuncios.add(anuncioB);

		anunciante.setAnuncios(anuncios);

		assertAll("anunciante",
				() -> assertEquals("Rafael Garcia", anunciante.getNome()),
				() -> assertEquals("312.831.778-03", anunciante.getCPF()),
				() -> assertEquals("PN123", anunciante.getAnuncios().get(0).getProduto().getCodigo()),
				() -> assertEquals("Motor", anunciante.getAnuncios().get(0).getProduto().getNome()),
				() -> assertEquals("Motor Esteira de Entrada", anunciante.getAnuncios().get(0).getProduto().getDescricao()),
				() -> assertEquals((double) 300, anunciante.getAnuncios().get(0).getProduto().getValor()),
				() -> assertEquals("Novo", anunciante.getAnuncios().get(0).getProduto().getEstado()),
				() -> assertEquals("PN456", anunciante.getAnuncios().get(1).getProduto().getCodigo()),
				() -> assertEquals("Suporte", anunciante.getAnuncios().get(1).getProduto().getNome()),
				() -> assertEquals("Suporte Esteira de Entrada", anunciante.getAnuncios().get(1).getProduto().getDescricao()),
				() -> assertEquals((double) 500, anunciante.getAnuncios().get(1).getProduto().getValor()),
				() -> assertEquals("Usado", anunciante.getAnuncios().get(1).getProduto().getEstado())
				);

	}

	@Test
	void testGetAnuncios() throws MalformedURLException {

		ProdutoBean produtoA = new ProdutoBean("PN123", "Motor","Motor Esteira de Entrada", (double) 300, "Novo");

		ArrayList<URL> fotosUrlA = new ArrayList<URL>();

		URL url = new URL("http://www.unicamp.com/foto_1");
		fotosUrlA.add(url);
		url = new URL("http://www.unicamp.com/foto_2");
		fotosUrlA.add(url);

		double descontoA = (double) 0.1;

		AnuncioBean anuncioA = new AnuncioBean(produtoA, fotosUrlA, descontoA);

		anuncios.add(anuncioA);

		anunciante.setAnuncios(anuncios);

		ArrayList<AnuncioBean> anunciosResultado = anunciante.getAnuncios();

		assertAll("anunciante",
				() -> assertEquals("PN123", anunciosResultado.get(0).getProduto().getCodigo()),
				() -> assertEquals("Motor", anunciosResultado.get(0).getProduto().getNome()),
				() -> assertEquals("Motor Esteira de Entrada", anunciosResultado.get(0).getProduto().getDescricao()),
				() -> assertEquals((double) 300, anunciosResultado.get(0).getProduto().getValor()),
				() -> assertEquals("Novo", anunciosResultado.get(0).getProduto().getEstado()),
				() -> assertEquals(fotosUrlA.get(0), anunciosResultado.get(0).getFotosUrl().get(0)),
				() -> assertEquals((double) 0.1, anunciosResultado.get(0).getDesconto())
				);

	}


	@Test
	void testAddAnuncio() throws MalformedURLException {
		ProdutoBean produtoA = new ProdutoBean("PN123", "Motor","Motor Esteira de Entrada", (double) 300, "Novo");

		ArrayList<URL> fotosUrlA = new ArrayList<URL>();

		URL url = new URL("http://www.unicamp.com/foto_1");
		fotosUrlA.add(url);
		url = new URL("http://www.unicamp.com/foto_2");
		fotosUrlA.add(url);

		double descontoA = (double) 0.1;

		AnuncioBean anuncioA = new AnuncioBean(produtoA, fotosUrlA, descontoA);

		anuncios.add(anuncioA);

		anunciante.setAnuncios(anuncios);

		assertEquals(1, anunciante.getAnuncios().size());
	
	}

	@Test
	void testRemoveAnuncio() throws MalformedURLException {
		ProdutoBean produtoA = new ProdutoBean("PN123", "Motor","Motor Esteira de Entrada", (double) 300, "Novo");
		ProdutoBean produtoB = new ProdutoBean("PN456", "Suporte","Suporte Esteira de Entrada", (double) 500, "Usado");		

		ArrayList<URL> fotosUrlA = new ArrayList<URL>();
		ArrayList<URL> fotosUrlB = new ArrayList<URL>();

		URL url = new URL("http://www.unicamp.com/foto_1");
		fotosUrlA.add(url);
		url = new URL("http://www.unicamp.com/foto_2");
		fotosUrlA.add(url);
		url = new URL("http://www.unicamp.com/foto_3");
		fotosUrlB.add(url);
		url = new URL("http://www.unicamp.com/foto_4");
		fotosUrlB.add(url);

		double descontoA = (double) 0.1;
		double descontoB = (double) 0.2;	

		AnuncioBean anuncioA = new AnuncioBean(produtoA, fotosUrlA, descontoA);
		AnuncioBean anuncioB = new AnuncioBean(produtoB, fotosUrlB, descontoB);

		anuncios.add(anuncioA);
		anuncios.add(anuncioB);

		anunciante.setAnuncios(anuncios);

		int countAnuncions = anunciante.getAnuncios().size();
		
		anunciante.removeAnuncio(0);
		
		countAnuncions = anunciante.getAnuncios().size();
		
		assertEquals(1,countAnuncions);
		
	}

	@Test
	void testValorMedioAnuncios() throws MalformedURLException {
		ProdutoBean produtoA = new ProdutoBean("PN123", "Motor","Motor Esteira de Entrada", (double) 300, "Novo");
		ProdutoBean produtoB = new ProdutoBean("PN456", "Suporte","Suporte Esteira de Entrada", (double) 500, "Usado");		

		ArrayList<URL> fotosUrlA = new ArrayList<URL>();
		ArrayList<URL> fotosUrlB = new ArrayList<URL>();

		URL url = new URL("http://www.unicamp.com/foto_1");
		fotosUrlA.add(url);
		url = new URL("http://www.unicamp.com/foto_2");
		fotosUrlA.add(url);
		url = new URL("http://www.unicamp.com/foto_3");
		fotosUrlB.add(url);
		url = new URL("http://www.unicamp.com/foto_4");
		fotosUrlB.add(url);

		double descontoA = (double) 0.1;
		double descontoB = (double) 0.2;	

		AnuncioBean anuncioA = new AnuncioBean(produtoA, fotosUrlA, descontoA);
		AnuncioBean anuncioB = new AnuncioBean(produtoB, fotosUrlB, descontoB);

		anuncios.add(anuncioA);
		anuncios.add(anuncioB);

		anunciante.setAnuncios(anuncios);

		double valorMedio = anunciante.valorMedioAnuncios();
		
		assertEquals(335, valorMedio);
	
	}

}
