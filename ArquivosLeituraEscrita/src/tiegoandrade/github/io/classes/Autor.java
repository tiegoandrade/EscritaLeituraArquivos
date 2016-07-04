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
	
	// Métodos getters e setters.
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
	
	// Método que lê os dados de um Autor.
	@Override
	public void read(DataInputStream in) throws IOException {
		
		// Lê o nome do autor.
		nome = in.readUTF();
		
		// Se a String <null> for retornada, o autor não possui nome.
		if (nome.equals(NULL_DATA)) {
			nome = null;
		}
		
		// Lê a data de nascimento e retorna um Long.
		long time = in.readLong();
		
		// Caso a data de nascimento seja -1, ela não foi informada.
		if (time == -1) {
			dataNascimento = null;
		
		// Se não cria um objeto Date com a data lida.
		} else {
			dataNascimento = new Date(time);
		}
	}
	
	// Método que grava dados de um Autor.
	@Override
	public void write(DataOutputStream out) throws IOException {
		
		// Se o autor tiver um nome, ele é gravado.
		if (nome != null) {
			out.writeUTF(nome);
		
		// Se não será gravado como "<null>", informando que não há um nome.
		} else {
			out.writeUTF(NULL_DATA);
		}
		
		// Se o autor tiver uma data de nascimento, ela é gravada.
		if (dataNascimento != null) {
			out.writeLong(dataNascimento.getTime());
		
		// Se não grava -1, informando que não há uma data de nascimento.
		} else {
			out.writeLong(-1);
		}
	}
	
	// Método que apresenta as informações de Autor.
	@Override
	public String toString() {
		return "Autor [Nome = " + nome + ", Data de nascimento = " + dataNascimento + "]";
	}
}
