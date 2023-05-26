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

import br.edu.fateczl.listas.Lista;
import model.Area;
import model.Grupo;
import model.Orientacao;
import model.Subarea;

public class InserirOrientacoes implements ActionListener {
//	Uma tela que permita ao orientador inserir, orientações, em uma Estrutura de Dados.

	private JTextField tfOrientacaoGrupo;
	private JTextField tfOrientacaoData;
	private JTextField tfOrientacaoDescricao;
	Grupo grupo = new Grupo();

	public InserirOrientacoes(JTextField tfOrientacaoGrupo, JTextField tfOrientacaoData,
			JTextField tfOrientacaoDescricao) {
		this.tfOrientacaoGrupo = tfOrientacaoGrupo;
		this.tfOrientacaoData = tfOrientacaoData;
		this.tfOrientacaoDescricao = tfOrientacaoDescricao;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Buscar Grupo")) {
			try {
				grupo = buscar(grupo);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (cmd.equals("Lançar Orientação")) {
			if (grupo.getCodigo() != 0) {
				try {
					registrar(grupo);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				tfOrientacaoGrupo.setText("");
				tfOrientacaoData.setText("");
				tfOrientacaoDescricao.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "Insira o ID do Grupo", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	private void registrar(Grupo grupo) throws IOException {
		Orientacao orientacao = new Orientacao();
		orientacao.setGrupo(grupo);
		orientacao.setData(tfOrientacaoData.getText());
		orientacao.setDescricao(tfOrientacaoDescricao.getText());

		registraOrientacao(orientacao.toString());
		tfOrientacaoGrupo.setText("");
		tfOrientacaoData.setText("");
		tfOrientacaoDescricao.setText("");
	}

	private void registraOrientacao(String csvOrientacao) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaTCC";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "orientacoes.csv");
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvOrientacao + "\r\n");
		pw.flush();
		pw.close();
		fw.close();
		JOptionPane.showMessageDialog(null, "Orientação Cadastrada Com Sucesso");
	}

	private Grupo buscar(Grupo grupo) throws Exception {
		grupo.setCodigo(Integer.parseInt(tfOrientacaoGrupo.getText()));
		grupo = buscarGrupo(grupo);
		if (grupo.getTema() != null) {
			JOptionPane.showMessageDialog(null, "Grupo Encontrado Com Sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "ID incorreto", "ERRO", JOptionPane.ERROR_MESSAGE);
			grupo.setCodigo(0);
			tfOrientacaoGrupo.setText("");
		}
		return grupo;
	}

	private Grupo buscarGrupo(Grupo grupo) throws IOException {
		Area area = new Area();
		Subarea subarea = new Subarea();
		String path = System.getProperty("user.home") + File.separator + "SistemaTCC";
		File arq = new File(path, "grupos.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (vetLinha[0].equals(Integer.toString(grupo.getCodigo()))) {
					grupo.setTema(vetLinha[1]);
					area.setNome(vetLinha[2]);
					grupo.setArea(area);
					subarea.setNome(vetLinha[3]);
					grupo.setSubarea(subarea);
					grupo.setIntegrantes(listaIntegrantes(vetLinha, grupo));
					break;
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}
		return grupo;
	}

	private Lista listaIntegrantes(String[] vetLinha, Grupo grupo) {
		Lista lista = new Lista();
		int tamanho = vetLinha.length;
		for (int i = 4; i < tamanho; i++) {
			lista.addfirst(vetLinha[i]);
		}
		return lista;
	}
}
