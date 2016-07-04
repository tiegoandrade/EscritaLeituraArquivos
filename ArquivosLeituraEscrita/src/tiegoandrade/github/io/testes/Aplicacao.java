package tiegoandrade.github.io.testes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import tiegoandrade.github.io.classes.Autor;
import tiegoandrade.github.io.classes.Livro;

public class Aplicacao {
	// Constante que representa o arquivo que armazena os dados.
	private static final String FILE = "livros.bin";
	
	public static void main(String[] args) throws Exception {
		
		// Criação da interface com o usuário.
		System.out.println("Escolha uma opção: ");
		System.out.println("1 - Gravar os dados");
		System.out.println("2 - Ler os dados");
		System.out.println("=> ");
		
		// Lê a opção digitada
		Scanner keyboard = new Scanner(System.in);
		String opcao = keyboard.nextLine();
		
		/* 
		 * Com base nas informações passadas pelo usuário, 
		 * é feita uma gração ou leitura nos dados de livro e autor.
		 */
		if (opcao.equals("1")) {
			gravarDados();
		} else if (opcao.equals("2")) {
			lerDados();
		} else {
			System.out.println("Opção Desconhecida.");
		}
	}
	
	// Método que faz a leitura dos dados de um livro e autor.
	private static void lerDados() throws Exception {
		
		// Cria dois objetos Livro
		Livro l1 = new Livro();
		Livro l2 = new Livro();
		
		// Criação da Stream para leitura dos dados.
		try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE))) {
			
			// Lê os dados de l1 
			l1.read(dis);
			
			// Lê os dados de l2
			l2.read(dis);
		}
		
		// Imprime os dados dos livros
		System.out.println(l1);
		System.out.println(l2);
	}
	
	// Método que faz a gravação de dados de um livro ou autor.
	private static void gravarDados() throws Exception {
		
		// Cria uma data
		String d1 = "01/04/1972";
		String d2 = "25/02/1980";
		
		// Formata a data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		// Cria autores e livros a serem gravados no arquivo.
		Autor a1 = new Autor();
		a1.setNome("Leandro da Silva");
		a1.setDataNascimento(sdf.parse(d1));
		
		Autor a2 = new Autor();
		a2.setNome("Maria de Jesus");
		a2.setDataNascimento(sdf.parse(d2));
		
		Livro l1 = new Livro();
		l1.setTitulo("Orientação a Objetos");
		l1.setNumPaginas(350);
		l1.setAutor(a1);
		
		Livro l2 = new Livro();
		l1.setTitulo("Programação Java");
		l1.setNumPaginas(200);
		l1.setAutor(a2);
		
		// Criação da Stream para gravação dos dados.
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE))) {
			
			// Grava os dados de l1.
			l1.write(dos);
			
			// Grava os dados de l2
			l2.write(dos);
		}
	}
}
