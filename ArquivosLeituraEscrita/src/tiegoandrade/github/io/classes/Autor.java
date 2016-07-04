package tiegoandrade.github.io.classes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;

import tiegoandrade.github.io.interfaces.Recordable;

public class Autor implements Recordable {
	// Atributo que representa o nome do Autor.
	private String nome;
	
	// Atributo que representa a data de nascimento do autor.
	private Date dataNascimento;
	
	// M�todos getters e setters.
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	// M�todo que l� os dados de um Autor.
	@Override
	public void read(DataInputStream in) throws IOException {
		
		// L� o nome do autor.
		nome = in.readUTF();
		
		// Se a String <null> for retornada, o autor n�o possui nome.
		if (nome.equals(NULL_DATA)) {
			nome = null;
		}
		
		// L� a data de nascimento e retorna um Long.
		long time = in.readLong();
		
		// Caso a data de nascimento seja -1, ela n�o foi informada.
		if (time == -1) {
			dataNascimento = null;
		
		// Se n�o cria um objeto Date com a data lida.
		} else {
			dataNascimento = new Date(time);
		}
	}
	
	// M�todo que grava dados de um Autor.
	@Override
	public void write(DataOutputStream out) throws IOException {
		
		// Se o autor tiver um nome, ele � gravado.
		if (nome != null) {
			out.writeUTF(nome);
		
		// Se n�o ser� gravado como "<null>", informando que n�o h� um nome.
		} else {
			out.writeUTF(NULL_DATA);
		}
		
		// Se o autor tiver uma data de nascimento, ela � gravada.
		if (dataNascimento != null) {
			out.writeLong(dataNascimento.getTime());
		
		// Se n�o grava -1, informando que n�o h� uma data de nascimento.
		} else {
			out.writeLong(-1);
		}
	}
	
	// M�todo que apresenta as informa��es de Autor.
	@Override
	public String toString() {
		return "Autor [Nome = " + nome + ", Data de nascimento = " + dataNascimento + "]";
	}
}
