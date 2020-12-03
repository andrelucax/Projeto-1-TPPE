package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
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
	private String nomeArquivoEntrada;
	private String arquivoSaida;
	private int formato;

	public Persistencia persistencia;
	
	public Parser(){
		buffer = new Vector <Vector <Integer>>();
		delimitador = ';';
		caminhoArquivoSaida = "assets/";
		formato = COLUNA;
		persistencia = new Persistencia();
	}

	public void lerArquivo(String path) throws ArquivoNaoEncontradoException {
		Scanner input = abrirArquivo(path);

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
		int lastIndex = path.lastIndexOf('/');
		if(lastIndex != -1) {
			this.setNomeArquivoEntrada(path.substring(lastIndex+1));
		} else {
			this.setNomeArquivoEntrada(path);
		}
	}

	private Scanner abrirArquivo(String path) throws ArquivoNaoEncontradoException {
		Scanner input;
		try {
			input = new Scanner(new FileReader(path));
		} catch (FileNotFoundException e) {
			throw new ArquivoNaoEncontradoException(path);
		}
		return input;
	}

	public Vector <Vector <Integer>> getBuffer() {
		return buffer;
	}

	public void setDelimitador(String delimitador) throws DelimitadorInvalidoException {
		Map<String, Character> avaliaDelimitador = new HashMap<String, Character>() {
			private static final long serialVersionUID = 1L;
		{
			put("\\t", '\t');
			put("\\b", '\b');
			put("\\n", '\n');
			put("\\f", '\f');
			put("\\r", '\r');
		}};
		
		if (delimitador.length() == 1) {
			this.delimitador = delimitador.charAt(0);
		} else if (avaliaDelimitador.containsKey(delimitador)) {
			this.delimitador = avaliaDelimitador.get(delimitador);
		} else {
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

	public void escreverArquivo() throws EscritaNaoPermitidaException {
		String caminhoCompletoSaida = getNomeArquivoEntrada();

	    int indexPonto = -1;
	    for(int i = caminhoCompletoSaida.length() - 1; i >= 0; i--) {
	        if(caminhoCompletoSaida.charAt(i) == '.') {
	            indexPonto = i;
	            break;
	        }
	    }

	    if(indexPonto == 0) {
	        caminhoCompletoSaida = "Tab" + caminhoCompletoSaida;
	    } else if(indexPonto != -1) {
	        caminhoCompletoSaida = caminhoCompletoSaida.substring(0,indexPonto) + "Tab" + caminhoCompletoSaida.substring(indexPonto);
	    } else {
	        caminhoCompletoSaida += "Tab";
	    }

	    caminhoCompletoSaida = getCaminhoArquivoSaida() + caminhoCompletoSaida;
	    setArquivoSaida(caminhoCompletoSaida);
	    
		new EscreverArquivo(this).escreve();
		return;
	}

	public File abrirArquivoSaida(String caminhoCompletoSaida) throws IOException {
		File file = new File(caminhoCompletoSaida);
		if(!file.exists()) {
			file.createNewFile();
		}
		return file;
	}

	public String getArquivoSaida() {
		return arquivoSaida;
	}

	public String getNomeArquivoEntrada() {
		return nomeArquivoEntrada;
	}

	public void setNomeArquivoEntrada(String nomeArquivoEntrada) {
		this.nomeArquivoEntrada = nomeArquivoEntrada;
	}

	public void setArquivoSaida(String caminhoCompletoSaida) {
		this.arquivoSaida = caminhoCompletoSaida;
	}
	
}
