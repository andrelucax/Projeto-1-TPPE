package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.Parser;

public class TesteDefinirFormatoSaida {

	
	private Parser parser;

	@Before
	public void setup() {
		parser = new Parser();
	}
	
	@Test
	public void testeDefinirFormatoSaidaColuna() {
		parser.setFormatoSaida(Parser.COLUNA);
		assertEquals(Parser.COLUNA, parser.getFormatoSaida());
	}
	
	@Test
	public void testeDefinirFormatoSaidaLinha() {
		parser.setFormatoSaida(Parser.LINHA);
		assertEquals(Parser.LINHA, parser.getFormatoSaida());
	}
	
	@Test
	public void testeDefinirFormatoSaidaGenerico() {
		parser.setFormatoSaida(2);
		assertEquals(2, parser.getFormatoSaida());
	}
}
