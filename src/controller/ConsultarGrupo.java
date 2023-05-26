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

public class ConsultarGrupo implements ActionListener {
	private JTextField tfIDGrupo;
	private JTextArea taIDTema;
	private JTextArea taIDArea;
	private JTextArea taIDSubarea;
	private JTextArea taIDLista;

	public ConsultarGrupo(JTextField tfIDGrupo, JTextArea taIDTema, JTextArea taIDArea, JTextArea taIDSubarea,
			JTextArea taIDLista) {
		this.tfIDGrupo = tfIDGrupo;
		this.taIDTema = taIDTema;
		this.taIDArea = taIDArea;
		this.taIDSubarea = taIDSubarea;
		this.taIDLista = taIDLista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Buscar Grupo")) {
			try {
				taIDLista.setText("");
				taIDTema.setText("");
				taIDArea.setText("");
				taIDSubarea.setText("");
				buscar();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	private void buscar() throws Exception {
		Grupo grupo = new Grupo();
		grupo.setCodigo(Integer.parseInt(tfIDGrupo.getText()));
		grupo = buscarGrupo(grupo);
		if (grupo.getTema() != null) {
			taIDTema.setText(grupo.getTema());
			taIDArea.setText(grupo.getArea().getNome());
			taIDSubarea.setText(grupo.getSubarea().getNome());

			int tamanho = grupo.getIntegrantes().size();
			for (int i = 0; i < tamanho; i++) {
				if (i % 2 != 0) {
					taIDLista.append(" - Nome: " + grupo.getIntegrantes().get(i) + "\r\n");
				} else {
					taIDLista.append(" Ra: " + grupo.getIntegrantes().get(i));
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "ID incorreto", "ERRO", JOptionPane.ERROR_MESSAGE);
		}

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
