package app;

import java.io.File;
import expts.EscritaNaoPermitidaException;

public class EscreverArquivo {
	final Parser parser;
	public EscreverArquivo(Parser parser) {
		this.parser = parser;
	}
	
	public void escreve() throws EscritaNaoPermitidaException {
	    try {
	    	File file = parser.abrirArquivoSaida(parser.getArquivoSaida());
		    
	    	parser.persistencia.iniciaEscrita(file);
		    
		    if(parser.getFormatoSaida() == Parser.LINHA) {
		    	for(int index = 0; index < parser.getBuffer().size(); index++) {
		    		if(index != 0) parser.persistencia.escreveQuebraLinha();
		    		parser.persistencia.escreveString(Integer.toString(index+1));
		    		for (int i=0; i < parser.getBuffer().elementAt(index).size(); i++) {
		    			parser.persistencia.escreveString(Character.toString(parser.getDelimitador()));
		    			parser.persistencia.escreveString(Integer.toString(parser.getBuffer().elementAt(index).elementAt(i)));
		    		}
		    	}
		    } else if(parser.getFormatoSaida() == Parser.COLUNA) {
		    	int max_size=0;
		    	for(int i=0; i<parser.getBuffer().size(); i++) {
		    		if(i!=0) parser.persistencia.escreveString(Character.toString(parser.getDelimitador()));
		    		parser.persistencia.escreveString(Integer.toString(i+1));
		    		if(parser.getBuffer().elementAt(i).size() > max_size) max_size = parser.getBuffer().elementAt(i).size();
		    	}
		    	parser.persistencia.escreveQuebraLinha();
		    	for(int j=0; j<max_size; j++) { // linha
		    		if(j!=0) parser.persistencia.escreveQuebraLinha();
		    		for(int i=0; i<parser.getBuffer().size(); i++) {
		    			if(i!=0) parser.persistencia.escreveString(Character.toString(parser.getDelimitador()));
		    			if(parser.getBuffer().elementAt(i).size() > j) {
		    				parser.persistencia.escreveString(Integer.toString(parser.getBuffer().elementAt(i).elementAt(j)));
		    			}
		    		}
		    	}
		    	
		    }
		  
		    parser.persistencia.fechaEscrita();
	    } catch (Exception e) {
	    	System.out.println(e);
	    	throw new EscritaNaoPermitidaException(parser.getCaminhoArquivoSaida());
	    }
	}
}
