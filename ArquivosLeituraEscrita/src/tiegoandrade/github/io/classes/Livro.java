package tiegoandrade.github.io.classes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import tiegoandrade.github.io.interfaces.Recordable;

public class Livro implements Recordable {
	
	// Atributo que representa o t�tulo do livro.
	private String titulo;
	
	// Atributo que representa o n�mero de p�ginas do livro.
	private int numPaginas;
	
	// Atributo que apresenta informa��es do Autor do livro.
	private Autor autor;
	
	// M�todos Setters e Getters.
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
		
		// L� o t�tulo do livro.
		titulo = in.readUTF();
		
		// Se o t�tulo for lido como "<null>", o livro n�o ter� t�tulo.
		if (titulo.equals(NULL_DATA)) {
			titulo = null;
		}
		
		// L� o n�mero de paginas.
		numPaginas = in.readInt();
		
		// Se o autor for nulo, cria-se um objeto para que seus dados sejam populados.
		if (autor == null) {
			autor = new Autor();
		}
		
		// Chama o m�todo "read" do autor que ir� popular os dados.
		autor.read(in);
	}
	
	// Realiza a escrita dos dados do livro.
	@Override
	public void write(DataOutputStream out) throws IOException {
		
		// Se o t�tulo for "null", � escrito "<null>".
		if (titulo == null) {
		out.writeUTF(NULL_DATA);
		
		// Se n�o ser� escrito o t�tulo do livro.
		} else {
			out.writeUTF(titulo);
		}
		
		// Grava o n�mero de p�ginas
		out.writeInt(numPaginas);
		
		// Se houver um autor para o livro, faz uma grava��o dos seus dados.
		if (autor != null) {
			autor.write(out);	
		}
	}
	
	// Ir� apresentar os dados do livro.
	@Override
	public String toString() {
		return "Livro [T�tulo = " + titulo + ", N�mero de p�ginas = " + 
				numPaginas + ", Autor = " + autor + "]";
	}
}
