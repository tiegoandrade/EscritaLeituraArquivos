package tiegoandrade.github.io.classes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import tiegoandrade.github.io.interfaces.Recordable;

public class Livro implements Recordable {
	
	// Atributo que representa o título do livro.
	private String titulo;
	
	// Atributo que representa o número de páginas do livro.
	private int numPaginas;
	
	// Atributo que apresenta informações do Autor do livro.
	private Autor autor;
	
	// Métodos Setters e Getters.
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public String getLivro() {
		return titulo;
	}
	
	public int getNumPaginas() {
		return numPaginas;
	}
	
	public Autor getAutor() {
		return autor;
	}
	
	// Realiza a leitura dos dados do livro.
	@Override
	public void read(DataInputStream in) throws IOException {
		
		// Lê o título do livro.
		titulo = in.readUTF();
		
		// Se o título for lido como "<null>", o livro não terá título.
		if (titulo.equals(NULL_DATA)) {
			titulo = null;
		}
		
		// Lê o número de paginas.
		numPaginas = in.readInt();
		
		// Se o autor for nulo, cria-se um objeto para que seus dados sejam populados.
		if (autor == null) {
			autor = new Autor();
		}
		
		// Chama o método "read" do autor que irá popular os dados.
		autor.read(in);
	}
	
	// Realiza a escrita dos dados do livro.
	@Override
	public void write(DataOutputStream out) throws IOException {
		
		// Se o título for "null", é escrito "<null>".
		if (titulo == null) {
		out.writeUTF(NULL_DATA);
		
		// Se não será escrito o título do livro.
		} else {
			out.writeUTF(titulo);
		}
		
		// Grava o número de páginas
		out.writeInt(numPaginas);
		
		// Se houver um autor para o livro, faz uma gravação dos seus dados.
		if (autor != null) {
			autor.write(out);	
		}
	}
	
	// Irá apresentar os dados do livro.
	@Override
	public String toString() {
		return "Livro [Título = " + titulo + ", Número de páginas = " + 
				numPaginas + ", Autor = " + autor + "]";
	}
}
