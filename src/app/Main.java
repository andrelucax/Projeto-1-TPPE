package app;

import java.util.Scanner;

import expts.ArquivoNaoEncontradoException;
import expts.DelimitadorInvalidoException;
import expts.EscritaNaoPermitidaException;

public class Main {
	
	public static void main(String[] args) {
		Parser parser = new Parser();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite o caminho do arquivo de entrada: ");
		String caminhoArquivoEntrada = scanner.nextLine();

		try {
			parser.lerArquivo(caminhoArquivoEntrada);
		} catch (ArquivoNaoEncontradoException e) {
			System.out.println(e);
			System.exit(-1);
		}
		
		System.out.print("Digite o delimitador do arquivo de saída: ");
		String delimitadorArquivoSaida = scanner.nextLine();
		
		try {
			parser.setDelimitador(delimitadorArquivoSaida);
		} catch (DelimitadorInvalidoException e) {
			System.out.println(e);
			System.exit(-1);
		}
		
		System.out.print("Digite o formato do arquivo de saída (0 - Linha, 1 - Coluna): ");
		int formatoArquivoSaida = scanner.nextInt();
		scanner.nextLine();

		if (formatoArquivoSaida == 0 || formatoArquivoSaida == 1) {
			parser.setFormatoSaida(formatoArquivoSaida);	
		} else {
			System.out.println("Formato de saída inválido.");
			System.exit(-1);
		}
		
		System.out.print("Digite o caminho do diretório para salvar o arquivo de saída: ");
		String caminhoArquivoSaida = scanner.nextLine();

		try {
			parser.setCaminhoArquivoSaida(caminhoArquivoSaida);
		} catch (EscritaNaoPermitidaException e) {
			System.out.println(e);
			System.exit(-1);
		}

		try {
			parser.escreverArquivo();
		} catch (EscritaNaoPermitidaException e) {
			System.out.println(e);
			System.exit(-1);
		}
		
		System.out.println("\n>> Resultado final salvo na pasta informada.");
		System.out.println(">> Programa encerrado!");

		scanner.close();
	}

}
