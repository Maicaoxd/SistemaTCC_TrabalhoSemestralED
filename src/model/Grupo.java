package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import br.edu.fateczl.lista.listaObj.Lista;
import br.edu.fateczl.pilhas.Pilha;

public class Grupo {

	Area area = new Area();

	Subarea subarea = new Subarea();

	private int codigo;
	private String tema;
	private Lista integrantes;

	public Grupo() {

	}

	public void setCodigo() {
		try {
			this.codigo = id();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int id() throws Exception {

		String path = System.getProperty("user.home") + File.separator + "SistemaTCC" + File.separator + "grupos.csv";
		File arquivo = new File(path);

		if (!arquivo.exists()) {
//			se o arquivo não existe dentro do diretório
			return 1;
		} else {
			Pilha leitura = new Pilha();

			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			while (linha != null) {
				leitura.push(linha);
				linha = buffer.readLine();
			}
			String ultimalinha = (String) leitura.pop();

			String[] grupo = ultimalinha.split(";");

			return Integer.parseInt(grupo[0]) + 1;

		}

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

	@Override
	public String toString() {
		return getCodigo() + ";" + getTema() + ";" + area.getNome() + ";" + subarea.getNome() + ";" + getIntegrantes();
	}

}
