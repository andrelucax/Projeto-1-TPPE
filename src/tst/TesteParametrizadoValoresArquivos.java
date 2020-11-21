package tst;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Vector;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.Parser;
import expts.ArquivoNaoEncontradoException;

@RunWith(Parameterized.class)
public class TesteParametrizadoValoresArquivos {
	private String arquivo;
	private int numeroEvolucao;
	private int numeroAnalises;
	
	
	public TesteParametrizadoValoresArquivos(String arquivo,
											int numeroEvolucao,
											int numeroAnalises) {
		this.arquivo = arquivo;
		this.numeroEvolucao = numeroEvolucao;
		this.numeroAnalises = numeroAnalises;
	}
	
	@Parameters
	public static Iterable<Object[]> getParameters() {
		Object[][] dados = new Object[][] {
			{"assets/analysisTime.out", 1, 10},
			{"assets/analysisTime.out", 2, 10},
			{"assets/analysisTime.out", 3, 10},
			{"assets/analysisTime.out", 4, 10},
			{"assets/analysisTime.out", 5, 10},
			{"assets/analysisTime.out", 6, 10},
			{"assets/analysisTime.out", 7, 10},
			{"assets/analysisTime.out", 8, 10},
			{"assets/analysisTime.out", 9, 10},
			{"assets/analysisTime.out", 10, 10},
	        {"assets/analysisTime.out", 11, 10},
			{"assets/analysisTime.out", 12, 10},
			{"assets/analysisTime.out", 13, 10},
			{"assets/analysisTime.out", 14, 10},
			{"assets/analysisTime.out", 15, 10},
			{"assets/analysisTime.out", 16, 10},
			{"assets/analysisTime.out", 17, 10},
			{"assets/analysisTime.out", 18, 10},
			{"assets/analysisTime.out", 19, 10},
			{"assets/analysisTime.out", 20, 10},
	        {"assets/totalTime.out", 1, 10},
			{"assets/totalTime.out", 2, 10},
			{"assets/totalTime.out", 3, 10},
			{"assets/totalTime.out", 4, 10},
			{"assets/totalTime.out", 5, 10},
			{"assets/totalTime.out", 6, 10},
			{"assets/totalTime.out", 7, 10},
			{"assets/totalTime.out", 8, 10},
			{"assets/totalTime.out", 9, 10},
			{"assets/totalTime.out", 10, 10},
	        {"assets/totalTime.out", 11, 10},
			{"assets/totalTime.out", 12, 10},
			{"assets/totalTime.out", 13, 10},
			{"assets/totalTime.out", 14, 10},
			{"assets/totalTime.out", 15, 10},
			{"assets/totalTime.out", 16, 10},
			{"assets/totalTime.out", 17, 10},
			{"assets/totalTime.out", 18, 10},
			{"assets/totalTime.out", 19, 10},
			{"assets/totalTime.out", 20, 10},
		};
		return Arrays.asList(dados);
	}

	
	@Test
	public void testNumeroAnalises() throws ArquivoNaoEncontradoException {
		Parser parser = new Parser();
		parser.lerArquivo(arquivo);
		Vector<Vector<Integer>> array = parser.getBuffer();
		assertEquals(numeroAnalises, array.elementAt(numeroEvolucao-1).size());
	}
	
}
