package app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

import expts.ArquivoNaoEncontradoException;

public class Parser {
	Vector <Vector <Integer>> buffer;
	
	public Parser(){
		buffer = new Vector <Vector <Integer>>();
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
	
	
}
