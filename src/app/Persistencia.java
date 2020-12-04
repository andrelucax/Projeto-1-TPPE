package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Persistencia {
	private FileWriter filew ;
	private BufferedWriter bufferw;
	private Scanner input;

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
	
	public void iniciaLeitura(Scanner input) {
		this.input = input;
	}
	
	public boolean temProximaLinha() {
		return input.hasNextLine();
	}
	
	public String lerArquivo() {
		return input.nextLine();
	}
	
	public void fechaLeitura() {
		input.close();
	}
}
