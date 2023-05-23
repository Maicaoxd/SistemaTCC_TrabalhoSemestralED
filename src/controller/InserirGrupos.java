package controller;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Aluno;

public class InserirGrupos {
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
		if (cmd.equals("Buscar Aluno")) {
			try {
				buscar();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void buscar() throws IOException {
		Aluno aluno = new Aluno();
		aluno.setRA(tfGrupoRaAluno.getText());
		aluno = buscaAluno(aluno);
		if (aluno.getRA() != null) {
			taGrupoListaAluno.setText("RA: " + aluno.getRA() + " - Nome: " + aluno.getNome());
		} else {
			taGrupoListaAluno.setText("Aluno não encontrado");
		}
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
