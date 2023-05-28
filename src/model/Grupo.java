package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Objects;

import br.edu.fateczl.listas.Lista;

public class Grupo {
	private int codigo;
	private String tema;
	private Area area;
	private Subarea subarea;
	private Lista integrantes;

	public Grupo() {
	}

	public void ordenaCodigo() {
		try {
			this.codigo = id();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getCodigo() {
		return codigo;
	}

	private int id() throws Exception {

		String path = System.getProperty("user.home") + File.separator + "SistemaTCC" + File.separator + "grupos.csv";
		File arquivo = new File(path);

		if (!arquivo.exists()) {
			return 1;
		} else {
			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String ultimalinha = "", linha = buffer.readLine();

			while (linha != null) {
				ultimalinha = linha;
				linha = buffer.readLine();
			}

			fluxo.close();
			leitor.close();
			buffer.close();

			String[] id = ultimalinha.split(";");

			return Integer.parseInt(id[0]) + 1;

		}
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

	public void setIntegrantes(Lista integrantes) {
		this.integrantes = integrantes;
	}

	@Override
	public String toString() {
		return getCodigo() + ";" + getTema() + ";" + area.getNome() + ";" + subarea.getNome() + ";"
				+ getIntegrantes().toString();
	}

	@Override
	public int hashCode() {
		String chave = getSubarea().toString().toLowerCase().substring(0, 3);
		int posicao = 0;
		int tamanho = chave.length();
		for (int i = 0; i < tamanho; i++) {
			int decimal = chave.charAt(i) - 97;
			posicao = posicao * 100 + decimal;
		}
		posicao = posicao % 1024;
		return posicao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		return Objects.equals(area, other.area) && codigo == other.codigo
				&& Objects.equals(integrantes, other.integrantes) && Objects.equals(subarea, other.subarea)
				&& Objects.equals(tema, other.tema);
	}

}
