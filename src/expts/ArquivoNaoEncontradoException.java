package expts;

public class ArquivoNaoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ArquivoNaoEncontradoException(String msg){
        super("Nao foi possivel abrir o arquivo: " + msg);
	}

}
