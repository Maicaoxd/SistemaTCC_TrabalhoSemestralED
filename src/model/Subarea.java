package model;

import java.util.Objects;

public class Subarea {
	private String nome;

	public Subarea() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

}
