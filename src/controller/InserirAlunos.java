package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JTextField;

import model.Aluno;

public class InserirAlunos implements ActionListener {

	private JTextField tfAlunoNome;
	private JTextField tfAlunoRa;

	public InserirAlunos(JTextField tfAlunoNome, JTextField tfAlunoRa) {
		this.tfAlunoNome = tfAlunoNome;
		this.tfAlunoRa = tfAlunoRa;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Registrar")) {
			try {
				registrar();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void registrar() throws IOException {
		Aluno aluno = new Aluno();
		aluno.setNome(tfAlunoNome.getText());
		aluno.setRA(tfAlunoRa.getText());
		registraAluno(aluno.toString());
		tfAlunoNome.setText("");
		tfAlunoRa.setText("");
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
	}

}