package model;

public class Orientador {

	private String senha;
	private String nome;

	public Orientador(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}