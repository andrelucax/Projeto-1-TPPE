package app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

import expts.ArquivoNaoEncontradoException;
import expts.DelimitadorInvalidoException;

public class Parser {
	private Vector <Vector <Integer>> buffer;
	private char delimitador;
	
	public Parser(){
		buffer = new Vector <Vector <Integer>>();
		delimitador = ';';
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
	
	
	
}
