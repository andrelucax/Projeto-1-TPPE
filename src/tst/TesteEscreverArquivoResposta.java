package tst;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import app.Parser;
import expts.ArquivoNaoEncontradoException;
import expts.DelimitadorInvalidoException;

public class TesteEscreverArquivoResposta {
	private Parser parser;

	@Before
	public void setup() {
		parser = new Parser();
	}
	
	@Test
	public void testeEscreverArquivoResposta() throws ArquivoNaoEncontradoException, DelimitadorInvalidoException, FileNotFoundException {
		parser.lerArquivo("assets/analysisTime.out");
		parser.setDelimitador(";");
		parser.setFormatoSaida(Parser.LINHA);
		parser.escreverArquivo();
		
		String path = parser.getArquivoSaida();
		Scanner input = new Scanner(new FileReader(path));
		Vector <Vector <Integer>> buffer = new Vector <Vector <Integer>>();
		while(input.hasNextLine()) {
			String data = input.nextLine();
			String columns[] = data.split(";");
			
			Vector<Integer> line = new Vector<Integer>();
			for(int i=1; i<columns.length; i++) {
				line.add(Integer.parseInt(columns[i]));
			}
			buffer.add(line);
			
		}
		
		assertEquals(buffer, parser.getBuffer());
	}
}
