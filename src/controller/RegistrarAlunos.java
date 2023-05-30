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
import javax.swing.JTextField;

import model.Aluno;

public class RegistrarAlunos implements ActionListener {

	private JTextField tfAlunoNome;
	private JTextField tfAlunoRa;

	public RegistrarAlunos(JTextField tfAlunoNome, JTextField tfAlunoRa) {
		this.tfAlunoNome = tfAlunoNome;
		this.tfAlunoRa = tfAlunoRa;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Registrar")) {
			try {
				if (!tfAlunoNome.getText().isEmpty() && !tfAlunoRa.getText().isEmpty()) {
					registrar();
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void registrar() throws IOException {
		Aluno aluno = new Aluno();
		aluno.setNome(tfAlunoNome.getText());
		aluno.setRA(tfAlunoRa.getText());
		boolean existe = verificarAluno(aluno);
		if (existe == false) {
			registraAluno(aluno.toString());
		} else {
			JOptionPane.showMessageDialog(null, "Aluno já registrado", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		tfAlunoNome.setText("");
		tfAlunoRa.setText("");
	}

	private boolean verificarAluno(Aluno aluno) throws IOException {
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
					buffer.close();
					leitor.close();
					fluxo.close();
					return true;
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}
		return false;
	}

	private void registraAluno(String csvAluno) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaTCC";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "alunos.csv");
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvAluno + "\r\n");
		pw.flush();
		pw.close();
		fw.close();
		JOptionPane.showMessageDialog(null, "Aluno Cadastrado Com Sucesso");
	}

}