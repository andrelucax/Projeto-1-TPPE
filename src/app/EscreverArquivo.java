package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import expts.EscritaNaoPermitidaException;

public class EscreverArquivo {
	final Parser parser;
	public EscreverArquivo(Parser parser) {
		this.parser = parser;
	}
	
	public void escreve() throws EscritaNaoPermitidaException {
	    try {
	    	File file = parser.abrirArquivoSaida(parser.getArquivoSaida());
		    
	    	FileWriter filew = new FileWriter(file);
	    	BufferedWriter bufferw = new BufferedWriter(filew);
		    
		    if(parser.getFormatoSaida() == Parser.LINHA) {
		    	for(int index = 0; index < parser.getBuffer().size(); index++) {
		    		if(index != 0) bufferw.newLine();
		    		bufferw.write(Integer.toString(index+1));
		    		for (int i=0; i < parser.getBuffer().elementAt(index).size(); i++) {
		    			bufferw.write(parser.getDelimitador());
		    			bufferw.write(Integer.toString(parser.getBuffer().elementAt(index).elementAt(i)));
		    		}
		    	}
		    } else if(parser.getFormatoSaida() == Parser.COLUNA) {
		    	int max_size=0;
		    	for(int i=0; i<parser.getBuffer().size(); i++) {
		    		if(i!=0) bufferw.write(parser.getDelimitador());
		    		bufferw.write(Integer.toString(i+1));
		    		if(parser.getBuffer().elementAt(i).size() > max_size) max_size = parser.getBuffer().elementAt(i).size();
		    	}
		    	bufferw.newLine();
		    	for(int j=0; j<max_size; j++) { // linha
		    		if(j!=0) bufferw.newLine();
		    		for(int i=0; i<parser.getBuffer().size(); i++) {
		    			if(i!=0) bufferw.write(parser.getDelimitador());
		    			if(parser.getBuffer().elementAt(i).size() > j) {
		    				bufferw.write(Integer.toString(parser.getBuffer().elementAt(i).elementAt(j)));
		    			}
		    		}
		    	}
		    	
		    }
		    
		    bufferw.close();
		    filew.close();
	    } catch (Exception e) {
	    	System.out.println(e);
	    	throw new EscritaNaoPermitidaException(parser.getCaminhoArquivoSaida());
	    }
	}
}
