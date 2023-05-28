package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.fateczl.listas.Lista;
import model.Area;
import model.Grupo;
import model.Orientacao;
import model.Subarea;

public class ConsultarOrientacao implements ActionListener {

	private JTextField tfUltimaGrupo;
	private JTextArea taUltimaData;
	private JTextArea taUltimaDescricao;

	public ConsultarOrientacao(JTextField tfUltimaGrupo, JTextArea taUltimaData, JTextArea taUltimaDescricao) {
		this.tfUltimaGrupo = tfUltimaGrupo;
		this.taUltimaData = taUltimaData;
		this.taUltimaDescricao = taUltimaDescricao;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Buscar Grupo")) {
			taUltimaData.setText("");
			taUltimaDescricao.setText("");
			try {
				if (!tfUltimaGrupo.getText().isEmpty()) {
					buscar();
				} else {
					JOptionPane.showMessageDialog(null, "Insira o ID do grupo", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Grupo Sem Orientacao", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void buscar() throws Exception {
		Grupo grupo = new Grupo();
		Orientacao orientacao = new Orientacao();
		grupo.setCodigo(Integer.parseInt(tfUltimaGrupo.getText()));
		grupo = buscarGrupo(grupo);
		if (grupo.getTema() != null) {
			JOptionPane.showMessageDialog(null, "Grupo Encontrado Com Sucesso");
			orientacao.setGrupo(grupo);
			orientacao = buscarOrientacao(orientacao);
			taUltimaData.setText(orientacao.getData());
			taUltimaDescricao.setText(orientacao.getDescricao());
		} else {
			JOptionPane.showMessageDialog(null, "ID incorreto", "ERRO", JOptionPane.ERROR_MESSAGE);
			grupo.setCodigo(0);
			tfUltimaGrupo.setText("");
		}
	}

	private Orientacao buscarOrientacao(Orientacao orientacao) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaTCC";
		File arq = new File(path, "orientacoes.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (vetLinha[0].equals(Integer.toString(orientacao.getGrupo().getCodigo()))) {
					orientacao.setData(vetLinha[1]);
					orientacao.setDescricao(vetLinha[2]);
					break;
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}
		return orientacao;
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
