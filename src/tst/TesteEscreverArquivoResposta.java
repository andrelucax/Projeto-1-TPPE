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
import expts.EscritaNaoPermitidaException;

public class TesteEscreverArquivoResposta {
	private Parser parser;

	@Before
	public void setup() {
		parser = new Parser();
	}
	
	@Test
	public void testeEscreverArquivoResposta() throws ArquivoNaoEncontradoException, DelimitadorInvalidoException, FileNotFoundException, EscritaNaoPermitidaException {
		parser.lerArquivo("assets/analysisTime.out");
		parser.setDelimitador(";");
		parser.setFormatoSaida(Parser.LINHA);
		parser.setCaminhoArquivoSaida("assets/");
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
	
	@Test
	public void teste2EscreverArquivoResposta() throws ArquivoNaoEncontradoException, DelimitadorInvalidoException, FileNotFoundException, EscritaNaoPermitidaException {
		parser.lerArquivo("assets/analysisTime.out");
		parser.setDelimitador("\t");
		parser.setFormatoSaida(Parser.COLUNA);
		parser.setCaminhoArquivoSaida("assets/");
		parser.escreverArquivo();
		
		String path = parser.getArquivoSaida();
		Scanner input = new Scanner(new FileReader(path));
		Vector <Vector <Integer>> buffer = new Vector <Vector <Integer>>();
		int line_number=0;
		while(input.hasNextLine()) {
			String data = input.nextLine();
			String columns[] = data.split("\t");
			if(line_number == 0) {
				for(int i = 0; i < columns.length; i++) {
					buffer.add(new Vector<Integer>());
				}
			}else {
				for(int i=0; i<columns.length; i++) {
					buffer.elementAt(i).add(Integer.valueOf(columns[i]));
				}
			}
			
			line_number++;
		}
		
		assertEquals(buffer, parser.getBuffer());
	}
	
	@Test
	public void teste3EscreverArquivoResposta() throws ArquivoNaoEncontradoException, DelimitadorInvalidoException, FileNotFoundException, EscritaNaoPermitidaException {
		parser.lerArquivo("assets/totalTime.out");
		parser.setDelimitador(",");
		parser.setFormatoSaida(Parser.LINHA);
		parser.setCaminhoArquivoSaida("assets/");
		parser.escreverArquivo();
		
		String path = parser.getArquivoSaida();
		Scanner input = new Scanner(new FileReader(path));
		Vector <Vector <Integer>> buffer = new Vector <Vector <Integer>>();
		while(input.hasNextLine()) {
			String data = input.nextLine();
			String columns[] = data.split(",");
			
			Vector<Integer> line = new Vector<Integer>();
			for(int i=1; i<columns.length; i++) {
				line.add(Integer.parseInt(columns[i]));
			}
			buffer.add(line);
			
		}
		
		assertEquals(buffer, parser.getBuffer());
	}
	
	@Test
	public void teste4EscreverArquivoResposta() throws ArquivoNaoEncontradoException, DelimitadorInvalidoException, FileNotFoundException, EscritaNaoPermitidaException {
		parser.lerArquivo("assets/totalTime.out");
		parser.setDelimitador(" ");
		parser.setFormatoSaida(Parser.COLUNA);
		parser.setCaminhoArquivoSaida("assets/");
		parser.escreverArquivo();
		
		String path = parser.getArquivoSaida();
		Scanner input = new Scanner(new FileReader(path));
		Vector <Vector <Integer>> buffer = new Vector <Vector <Integer>>();
		int line_number=0;
		while(input.hasNextLine()) {
			String data = input.nextLine();
			String columns[] = data.split(" ");
			if(line_number == 0) {
				for(int i = 0; i < columns.length; i++) {
					buffer.add(new Vector<Integer>());
				}
			}else {
				for(int i=0; i<columns.length; i++) {
					buffer.elementAt(i).add(Integer.valueOf(columns[i]));
				}
			}
			
			line_number++;
		}
		
		assertEquals(buffer, parser.getBuffer());
	}
}
