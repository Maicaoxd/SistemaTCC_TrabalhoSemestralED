package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.Aluno;

public class InserirAlunos implements ActionListener {
//	Uma tela que permita ao orientador inserir, em um arquivo csv, os alunos.

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
			registrar();
		}
	}

	private void registrar() {
		Aluno aluno = new Aluno();
		aluno.setNome(tfAlunoNome.getText());
		aluno.setRA(tfAlunoRa.getText());

		System.out.println(aluno.getNome());
		tfAlunoNome.setText("");
		tfAlunoRa.setText("");
	}

}