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
	public void testeDefinirFormatoSaida() {
		parser.setFormatoSaida(Parser.COLUNA);
		assertEquals(Parser.COLUNA, parser.getFormatoSaida());
	}
}
