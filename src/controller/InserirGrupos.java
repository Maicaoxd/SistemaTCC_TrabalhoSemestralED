package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Aluno;
import model.Area;
import model.Grupo;
import model.Subarea;

public class InserirGrupos implements ActionListener {
//	Uma tela que permita ao orientador inserir, em um arquivo csv, os grupos.

	private JTextField tfGrupoTema;
	private JTextField tfGrupoArea;
	private JTextField tfGrupoSubarea;
	private JTextField tfGrupoRaAluno;
	private JTextArea taGrupoListaAluno;

	public InserirGrupos(JTextField tfGrupoTema, JTextField tfGrupoArea, JTextField tfGrupoSubarea,
			JTextField tfGrupoRaAluno, JTextArea taGrupoListaAluno) {
		this.tfGrupoTema = tfGrupoTema;
		this.tfGrupoArea = tfGrupoArea;
		this.tfGrupoSubarea = tfGrupoSubarea;
		this.tfGrupoRaAluno = tfGrupoRaAluno;
		this.taGrupoListaAluno = taGrupoListaAluno;
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		Grupo grupo = new Grupo();
		try {
			if (cmd.equals("Buscar Aluno")) {
				buscar(grupo);
			} else if (cmd.equals("Registrar Grupo")) {
				registrar(grupo);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void registrar(Grupo grupo) throws IOException {
		
		grupo.setTema(tfGrupoTema.getText());
		
		Area area = new Area();
		area.setNome(tfGrupoArea.getText());
		grupo.setArea(area);
		
		Subarea subarea = new Subarea();
		subarea.setNome(tfGrupoSubarea.getText());
		grupo.setSubarea(subarea);
		
		registraGrupo(grupo.toString());
		
	}
	
	private void registraGrupo(String csvGrupo) throws IOException {
		
		String path = System.getProperty("user.home") + File.separator + "SistemaTCC";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		
		File arq = new File(path, "grupos.csv");
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvGrupo + "\r\n");
		pw.flush();
		pw.close();
		fw.close();
	}

	private void buscar(Grupo grupo) throws IOException {

		Aluno aluno = new Aluno();

		aluno.setRA(tfGrupoRaAluno.getText());
		aluno = buscaAluno(aluno);

		if (aluno.getNome() != null) {

			taGrupoListaAluno.append("RA: " + aluno.getRA() + " - Nome: " + aluno.getNome() + "\n\r");
			grupo.setIntegrantes(aluno);

		} else {
			taGrupoListaAluno.setText("Aluno não encontrado");
		}
		tfGrupoRaAluno.setText("");
	}

	private Aluno buscaAluno(Aluno aluno) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaTCC";
		File arq = new File(path, "alunos.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (vetLinha[1].equals(aluno.getRA())) {
					aluno.setNome(vetLinha[0]);
					break;
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}
		return aluno;
	}
}
