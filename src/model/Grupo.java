package model;

import br.edu.fateczl.lista.listaObj.Lista;

public class Grupo {
	private int codigo;
	private String tema;
	private Area area;
	private Subarea subarea;
	private Lista integrantes;

	public Grupo() {
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Subarea getSubarea() {
		return subarea;
	}

	public void setSubarea(Subarea subarea) {
		this.subarea = subarea;
	}

	public Lista getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(Aluno aluno) {
		integrantes.addFirst(aluno);
	}

	@Override
	public String toString() {
		return getCodigo() + ";" + getTema() + ";" + area.getNome() + ";" + subarea.getNome() + ";" + getIntegrantes();
	}

}
