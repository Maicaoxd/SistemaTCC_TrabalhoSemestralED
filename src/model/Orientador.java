package model;

public class Orientador {

	private String usuario;
	private String senha;
	private String nome;
	private Area area;
	private Subarea[] subareas;

	public Orientador(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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