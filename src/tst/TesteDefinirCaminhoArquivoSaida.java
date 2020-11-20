package tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.Parser;
import expts.EscritaNaoPermitidaException;

public class TesteDefinirCaminhoArquivoSaida {
	
	private Parser parser;

	@Before
	public void setup() {
		parser = new Parser();
	}
	
	@Test
	public void testeDefinirCaminhoArquivoSaida() throws EscritaNaoPermitidaException {
		parser.setCaminhoArquivoSaida("assets");
		assertEquals("assets/", parser.getCaminhoArquivoSaida());
	}
	
	@Test
	public void teste2DefinirCaminhoArquivoSaida() throws EscritaNaoPermitidaException {
		parser.setCaminhoArquivoSaida("assets/");
		assertEquals("assets/", parser.getCaminhoArquivoSaida());
	}
	
	@Test
	public void teste3DefinirCaminhoArquivoSaida() throws EscritaNaoPermitidaException {
		parser.setCaminhoArquivoSaida(".");
		assertEquals("./", parser.getCaminhoArquivoSaida());
	}
	
	@Test(expected=EscritaNaoPermitidaException.class)
	public void testeDefinirCaminhoArquivoSaidaExcecao() throws EscritaNaoPermitidaException {
		parser.setCaminhoArquivoSaida("/dev/");
	}

}
