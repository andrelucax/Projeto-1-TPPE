package tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.Parser;

public class TesteDefinirCaminhoArquivoSaida {
	
	private Parser parser;

	@Before
	public void setup() {
		parser = new Parser();
	}
	
	@Test
	public void testeDefinirCaminhoArquivoSaida() throws EscritaNaoPermitidaException {
		parser.setCaminhoArquivoSaida("output/");
		assertEquals("output/", parser.getCaminhoArquivoSaida());
	}

}
