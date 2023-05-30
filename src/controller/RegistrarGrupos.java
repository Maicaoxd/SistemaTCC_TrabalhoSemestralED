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

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.fateczl.listas.Lista;
import model.Aluno;
import model.Area;
import model.Grupo;
import model.Subarea;

public class RegistrarGrupos implements ActionListener {

	private JTextField tfGrupoTema;
	private JTextField tfGrupoArea;
	private JTextField tfGrupoSubarea;
	private JTextField tfGrupoRaAluno;
	private JTextArea taGrupoListaAluno;
	private static int cnt = 0;
	Grupo grupo = new Grupo();
	Lista alunos = new Lista();

	public RegistrarGrupos(JTextField tfGrupoTema, JTextField tfGrupoArea, JTextField tfGrupoSubarea,
			JTextField tfGrupoRaAluno, JTextArea taGrupoListaAluno) {
		this.tfGrupoTema = tfGrupoTema;
		this.tfGrupoArea = tfGrupoArea;
		this.tfGrupoSubarea = tfGrupoSubarea;
		this.tfGrupoRaAluno = tfGrupoRaAluno;
		this.taGrupoListaAluno = taGrupoListaAluno;
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		try {
			if (cmd.equals("Buscar Aluno")) {
				if (!tfGrupoRaAluno.getText().isEmpty()) {
					alunos = buscar(grupo, alunos);
					tfGrupoRaAluno.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Insira o RA do aluno", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			} else if (cmd.equals("Registrar Grupo")) {
				if (!tfGrupoArea.getText().isEmpty() && !tfGrupoSubarea.getText().isEmpty()
						&& !tfGrupoTema.getText().isEmpty() && !taGrupoListaAluno.getText().isEmpty()) {
					cnt = 0;
					grupo.setIntegrantes(alunos);
					registrar(grupo);
					tfGrupoTema.setText("");
					tfGrupoArea.setText("");
					tfGrupoSubarea.setText("");
					tfGrupoRaAluno.setText("");
					taGrupoListaAluno.setText("");
					while (!alunos.vazia()) {
						alunos.removefirst();
					}
					grupo.setIntegrantes(alunos);
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private void registrar(Grupo grupo) throws IOException {
		Area area = new Area();
		Subarea subarea = new Subarea();

		grupo.ordenaCodigo();
		grupo.setTema(tfGrupoTema.getText());

		area.setNome(tfGrupoArea.getText());
		grupo.setArea(area);

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
		JOptionPane.showMessageDialog(null, "Grupo Cadastrado Com Sucesso\n\rID do Grupo: " + grupo.getCodigo());
	}

	private Lista buscar(Grupo grupo, Lista alunos) throws IOException {
		Aluno aluno = new Aluno();
		aluno.setRA(tfGrupoRaAluno.getText());
		aluno = buscaAluno(aluno);

		if (aluno.getNome() != null) {
			if (cnt < 4) {
				cnt++;
				alunos.addfirst(aluno);
				taGrupoListaAluno.append("RA: " + aluno.getRA() + " - Nome: " + aluno.getNome() + "\n\r");
			} else {
				JOptionPane.showMessageDialog(null, "Capacidade máxima de alunos por grupo", "ERRO",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Aluno não encontrado", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		return alunos;
	}

	private Aluno buscaAluno(Aluno aluno) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaTCC";
		File arq = new File(path, "alunos.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
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
