package tst;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.Parser;
import expts.DelimitadorInvalidoException;

@RunWith(Parameterized.class)
public class TesteParametrizadoDefinirDelimitador {

	private String delimitador;
	private char delimitadorEsperado;
	
	public TesteParametrizadoDefinirDelimitador(String delimitador, char delimitadorEsperado) {
		this.delimitador = delimitador;
		this.delimitadorEsperado = delimitadorEsperado;
	}
	
	@Parameters
	public static Iterable<Object[]> getParameters() {
		Object[][] dados = new Object[][] {
			{"\n", '\n'},
			{"\r", '\r'},
			{"\t", '\t'},
			{";" , ';'},
			{"," , ','},
			{"." , '.'},
			{"*" , '*'},
			{"&" , '&'},
			{"_" , '_'},
			{"+" , '+'},
			{"-" , '-'}
		};
		return Arrays.asList(dados);
	}
	
	@Test
	public void testDefinirDelimitadorDeCampo() throws DelimitadorInvalidoException {
		Parser parser = new Parser();
		parser.setDelimitador(delimitador);
		assertEquals(delimitadorEsperado, parser.getDelimitador());
	}

}