package expts;

public class DelimitadorInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DelimitadorInvalidoException(String msg){
        super("Delimitador Invalido: " + msg);
	}

}
