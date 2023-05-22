package model;

import br.edu.fateczl.lista.listaObj.Lista;

public class Grupo {
	
	private int codigo;
	private String tema;
	private Lista integrantes;
	
	public Grupo() {
//		ler o código do ultimo grupo cadastrado da tabela, aqui é determinado o código
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setTema(String tema) {
		this.tema = tema;
	}
	public String getTema() {
		return tema;
	}
	
	public void setIntegrantes(Aluno aluno) {
		integrantes.addFirst(aluno);
	}

	public Lista getIntegrantes() {
		return integrantes;
	}

	

}
