package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.Parser;
import expts.DelimitadorInvalidoException;

public class TesteDefinirFormatoSaida {

	
	private Parser parser;

	@Before
	public void setup() {
		parser = new Parser();
	}
	
	@Test
	public void testeDefinirFormatoSaida() {
		parser.setFormatoSaida(parser.COLUNA);
		assertEquals(parser.COLUNA, parser.getFormatoSaida());
	}

}
