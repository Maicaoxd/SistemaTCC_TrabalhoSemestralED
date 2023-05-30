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
import model.Subarea;

public class ConsultarSubarea implements ActionListener {

	private JTextField tfSubSubarea;
	private JTextArea taSubListaGrupos;
	private Lista[] tabelaHash;

	public ConsultarSubarea(JTextField tfSubSubarea, JTextArea taSubListaGrupos) {
		this.tfSubSubarea = tfSubSubarea;
		this.taSubListaGrupos = taSubListaGrupos;
		tabelaHash = new Lista[1024];
		inicializarTabelaHash();
	}

	private void inicializarTabelaHash() {
		int tamanho = tabelaHash.length;
		for (int i = 0; i < tamanho; i++) {
			tabelaHash[i] = new Lista();
		}
	}

	public void adicionarGrupo(Grupo grupo) {
		int posicao = grupo.hashCode();
		tabelaHash[posicao].addfirst(grupo);
		taSubListaGrupos.append("ID: " + grupo.getCodigo() + " - Tema: " + grupo.getTema() + "\n\r");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Buscar Grupos")) {
			taSubListaGrupos.setText("");
			try {
				if (!tfSubSubarea.getText().isEmpty()) {
					buscar();
				} else {
					JOptionPane.showMessageDialog(null, "Insira a Subarea do grupo", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	private void buscar() throws IOException {
		Grupo grupo = new Grupo();
		Subarea subarea = new Subarea();
		subarea.setNome(tfSubSubarea.getText());
		grupo.setSubarea(subarea);
		grupo = buscarGrupo(grupo);
		if (grupo.getTema() == null) {
			JOptionPane.showMessageDialog(null, "Não há Grupos Com Esta Subarea", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private Grupo buscarGrupo(Grupo grupo) throws IOException {
		Area area = new Area();
		String path = System.getProperty("user.home") + File.separator + "SistemaTCC";
		File arq = new File(path, "grupos.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (vetLinha[3].equals(grupo.getSubarea().getNome())) {
					grupo.setCodigo(Integer.parseInt(vetLinha[0]));
					grupo.setTema(vetLinha[1]);
					area.setNome(vetLinha[2]);
					grupo.setArea(area);
					adicionarGrupo(grupo);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}
		return grupo;
	}

}
