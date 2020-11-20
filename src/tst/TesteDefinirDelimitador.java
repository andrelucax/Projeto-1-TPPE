package tst;

import org.junit.Before;
import org.junit.Test;

import app.Parser;

public class TesteDefinirDelimitador {
	
	private Parser parser;

	@Before
	public void setup() {
		parser = new Parser();
	}
	
	
	@Test
	public void testDefinirDelimitadorDeCampo() throws DelimitadorInvalidoException {
		parser.setDelimiter(';');
		assertEquals(';', parser.getDelimiter());
	}
}
