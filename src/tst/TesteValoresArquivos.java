package tst;

import static org.junit.Assert.assertEquals;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import app.Parser;
import expts.ArquivoNaoEncontradoException;

public class TesteValoresArquivos {
	private Parser parser;

	@Before
	public void setup() {
		parser = new Parser();
	}
	
	@Test
	public void teste1NumeroEvolucoes() throws ArquivoNaoEncontradoException {
		parser.lerArquivo("assets/analysisTime.out");
		Vector<Vector<Integer>> array = parser.getBuffer();
		assertEquals(20, array.size());
	}
	
	@Test
	public void teste2NumeroEvolucoes() throws ArquivoNaoEncontradoException {
		parser.lerArquivo("assets/totalTime.out");
		Vector<Vector<Integer>> array = parser.getBuffer();
		assertEquals(20, array.size());
	}
	
	@Test
	public void teste3NumeroEvolucoes() throws ArquivoNaoEncontradoException {
		parser.lerArquivo("assets/arquivoVazio.out");
		Vector<Vector<Integer>> array = parser.getBuffer();
		assertEquals(0, array.size());
	}
}

