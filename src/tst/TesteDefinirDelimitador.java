package tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.Parser;
import expts.DelimitadorInvalidoException;

public class TesteDefinirDelimitador {
	
	private Parser parser;

	@Before
	public void setup() {
		parser = new Parser();
	}
	
	@Test
	public void testeDefinirDelimitadorDeCampo() throws DelimitadorInvalidoException {
		parser.setDelimitador(";");
		assertEquals(';', parser.getDelimitador());
	}
	
	@Test
	public void teste2DefinirDelimitadorDeCampo() throws DelimitadorInvalidoException {
		parser.setDelimitador(",");
		assertEquals(',', parser.getDelimitador());
	}
}
