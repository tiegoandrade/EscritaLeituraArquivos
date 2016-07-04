package tiegoandrade.github.io.interfaces;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface Recordable {
	
	// Constante que representa um valor null em algum dado de livros ou autores.
	public String NULL_DATA = "<null>";
	
	// Método de leitura de dados implementado por classes.
	public void read(DataInputStream in) throws IOException;
	
	// Método de escrita de dados implementado por classes.
	public void write(DataOutputStream out) throws IOException;
}
