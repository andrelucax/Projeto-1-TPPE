package app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Vector;

import expts.ArquivoNaoEncontradoException;
import expts.DelimitadorInvalidoException;
import expts.EscritaNaoPermitidaException;

public class Parser {
	public static final int COLUNA = 0;
	public static final int LINHA = 1;
	
	private Vector <Vector <Integer>> buffer;
	private char delimitador;
	private String caminhoArquivoSaida;
	private int formato;
	
	public Parser(){
		buffer = new Vector <Vector <Integer>>();
		delimitador = ';';
		caminhoArquivoSaida = "assets/";
		formato = COLUNA;
	}

	public void lerArquivo(String path) throws ArquivoNaoEncontradoException {
		Scanner input;
		try {
			input = new Scanner(new FileReader(path));
		} catch (FileNotFoundException e) {
			throw new ArquivoNaoEncontradoException(path);
		}

		while(input.hasNextLine()) {
			
			String data = input.nextLine();
			
			if (data.startsWith("-")) {
				Vector<Integer> row = new Vector<Integer>();
				buffer.add(row);
			}
			else {
				buffer.lastElement().add(Integer.parseInt(data));
			}
		}
		
		input.close();
		
	}


	public Vector <Vector <Integer>> getBuffer() {
		return buffer;
	}

	public void setDelimitador(String delimitador) throws DelimitadorInvalidoException {
		if (delimitador.length() == 1) {
			this.delimitador = delimitador.charAt(0);
		}
		else {
			throw new DelimitadorInvalidoException(delimitador);
		}
	}
	
	public char getDelimitador() {
		return delimitador;
	}

	public void setCaminhoArquivoSaida(String caminhoArquivoSaida) throws EscritaNaoPermitidaException {
		if (!caminhoArquivoSaida.endsWith("/")) {
			caminhoArquivoSaida += "/";
		}
		
		Path caminho = Paths.get(caminhoArquivoSaida);
		
		if(!Files.isWritable(caminho)) {
			throw new EscritaNaoPermitidaException(caminhoArquivoSaida);
		}
		
		this.caminhoArquivoSaida = caminhoArquivoSaida;
	}

	public String getCaminhoArquivoSaida() {
		return caminhoArquivoSaida;
	}

	public void setFormatoSaida(int formato) {
		this.formato = formato;
		
	}

	public int getFormatoSaida() {
		return formato;
	}
	
}
