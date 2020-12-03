package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Persistencia {
	private FileWriter filew ;
	private BufferedWriter bufferw;

	public Persistencia() {
	}
	
	public void iniciaEscrita(File file) throws IOException {
    	filew = new FileWriter(file);
    	bufferw = new BufferedWriter(filew);
	}
	
	public void escreveQuebraLinha () throws IOException {
		bufferw.newLine();
	}
	
	public void escreveString (String string) throws IOException {
		bufferw.write(string);
	}
	
	public void fechaEscrita() throws IOException {  
	    bufferw.close();
	    filew.close();
	}
}
