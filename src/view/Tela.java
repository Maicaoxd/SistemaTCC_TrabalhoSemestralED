package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ConsultarGrupo;
import controller.ConsultarOrientacao;
import controller.ConsultarSubarea;
import controller.RegistrarAlunos;
import controller.RegistrarGrupos;
import controller.RegistrarOrientacoes;

public class Tela extends JFrame {

	private static final long serialVersionUID = -8533024649811972087L;
	private JPanel contentPane;
	private JTextField tfAlunoNome;
	private JTextField tfAlunoRa;
	private JTextField tfGrupoTema;
	private JTextField tfGrupoArea;
	private JTextField tfGrupoSubarea;
	private JTextField tfGrupoRaAluno;
	private JTextField tfIDGrupo;
	private JTextField tfOrientacaoGrupo;
	private JTextField tfOrientacaoData;
	private JTextField tfOrientacaoDescricao;
	private JTextField tfSubSubarea;
	private JTextField tfUltimaGrupo;

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Tela frame = new Tela();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	public Tela() {
		setTitle("Sistema de TCC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 634, 441);
		tabbedPane.setBackground(new Color(255, 255, 255));
		contentPane.add(tabbedPane);

		JPanel tabAluno = new JPanel();
		tabAluno.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Registrar Aluno", null, tabAluno, "Registrar Alunos");
		tabAluno.setLayout(null);

		JLabel lblAlunoNome = new JLabel("Nome");
		lblAlunoNome.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblAlunoNome.setBounds(148, 120, 60, 30);
		tabAluno.add(lblAlunoNome);

		tfAlunoNome = new JTextField();
		tfAlunoNome.setBackground(new Color(248, 248, 248));
		tfAlunoNome.setBounds(208, 120, 258, 30);
		tabAluno.add(tfAlunoNome);
		tfAlunoNome.setColumns(10);

		JLabel lblAlunoRa = new JLabel("RA");
		lblAlunoRa.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblAlunoRa.setBounds(148, 169, 60, 30);
		tabAluno.add(lblAlunoRa);

		tfAlunoRa = new JTextField();
		tfAlunoRa.setBackground(new Color(248, 248, 248));
		tfAlunoRa.setColumns(10);
		tfAlunoRa.setBounds(208, 174, 258, 30);
		tabAluno.add(tfAlunoRa);

		JButton btnAlunoCadastrar = new JButton("Registrar");
		btnAlunoCadastrar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnAlunoCadastrar.setForeground(new Color(0, 0, 0));
		btnAlunoCadastrar.setBackground(new Color(0, 255, 64));
		btnAlunoCadastrar.setBounds(259, 228, 124, 39);
		tabAluno.add(btnAlunoCadastrar);

		JButton btnAlunoSair = new JButton("Sair ->");
		btnAlunoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Deseja fechar a aplicação?", "Saída",
						JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		});
		btnAlunoSair.setForeground(new Color(0, 0, 0));
		btnAlunoSair.setBackground(new Color(255, 128, 64));
		btnAlunoSair.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnAlunoSair.setBounds(530, 11, 89, 23);
		tabAluno.add(btnAlunoSair);

		JPanel tabGrupo = new JPanel();
		tabGrupo.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Registrar Grupo", null, tabGrupo, "Registrar Grupos");
		tabGrupo.setLayout(null);

		JButton btnGrupoSair = new JButton("Sair ->");
		btnGrupoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Deseja fechar a aplicação?", "Saída",
						JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnGrupoSair.setBackground(new Color(255, 128, 64));
		btnGrupoSair.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnGrupoSair.setBounds(530, 11, 89, 23);
		tabGrupo.add(btnGrupoSair);

		JLabel lblGrupoTema = new JLabel("Tema");
		lblGrupoTema.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblGrupoTema.setBounds(58, 53, 60, 30);
		tabGrupo.add(lblGrupoTema);

		tfGrupoTema = new JTextField();
		tfGrupoTema.setBackground(new Color(248, 248, 248));
		tfGrupoTema.setColumns(10);
		tfGrupoTema.setBounds(118, 53, 397, 30);
		tabGrupo.add(tfGrupoTema);

		JLabel lblGrupoArea = new JLabel("Área");
		lblGrupoArea.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblGrupoArea.setBounds(58, 94, 60, 30);
		tabGrupo.add(lblGrupoArea);

		tfGrupoArea = new JTextField();
		tfGrupoArea.setBackground(new Color(248, 248, 248));
		tfGrupoArea.setColumns(10);
		tfGrupoArea.setBounds(118, 94, 160, 30);
		tabGrupo.add(tfGrupoArea);

		JLabel lblGrupoSubarea = new JLabel("Subárea");
		lblGrupoSubarea.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblGrupoSubarea.setBounds(295, 94, 60, 30);
		tabGrupo.add(lblGrupoSubarea);

		tfGrupoSubarea = new JTextField();
		tfGrupoSubarea.setBackground(new Color(248, 248, 248));
		tfGrupoSubarea.setColumns(10);
		tfGrupoSubarea.setBounds(355, 94, 160, 30);
		tabGrupo.add(tfGrupoSubarea);

		JLabel lblGrupoRaAluno = new JLabel("RA do Aluno");
		lblGrupoRaAluno.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblGrupoRaAluno.setBounds(10, 135, 108, 30);
		tabGrupo.add(lblGrupoRaAluno);

		tfGrupoRaAluno = new JTextField();
		tfGrupoRaAluno.setBackground(new Color(248, 248, 248));
		tfGrupoRaAluno.setColumns(10);
		tfGrupoRaAluno.setBounds(118, 135, 348, 30);
		tabGrupo.add(tfGrupoRaAluno);

		JTextArea taGrupoListaAluno = new JTextArea();
		taGrupoListaAluno.setBackground(new Color(248, 248, 248));
		taGrupoListaAluno.setBounds(118, 176, 397, 141);
		tabGrupo.add(taGrupoListaAluno);

		JLabel lblGrupoListaAluno = new JLabel("Lista de Alunos");
		lblGrupoListaAluno.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblGrupoListaAluno.setBounds(10, 176, 108, 30);
		tabGrupo.add(lblGrupoListaAluno);

		JButton btnGrupoBuscar = new JButton("Buscar Aluno");
		btnGrupoBuscar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnGrupoBuscar.setBackground(new Color(0, 255, 64));
		btnGrupoBuscar.setBounds(476, 135, 143, 30);
		tabGrupo.add(btnGrupoBuscar);

		JButton btnGrupoRegistrar = new JButton("Registrar Grupo");
		btnGrupoRegistrar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnGrupoRegistrar.setBackground(new Color(0, 255, 64));
		btnGrupoRegistrar.setBounds(233, 335, 148, 37);
		tabGrupo.add(btnGrupoRegistrar);

		JPanel tabID = new JPanel();
		tabID.setBackground(new Color(255, 255, 255));
		tabID.setLayout(null);
		tabbedPane.addTab("Consultar Grupo", null, tabID, "Localizar Grupo Por ID");

		JButton btnIDSair = new JButton("Sair ->");
		btnIDSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Deseja fechar a aplicação?", "Saída",
						JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnIDSair.setBackground(new Color(255, 128, 64));
		btnIDSair.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnIDSair.setBounds(530, 11, 89, 23);
		tabID.add(btnIDSair);

		JLabel lblIDTema = new JLabel("Tema");
		lblIDTema.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblIDTema.setBounds(26, 94, 60, 30);
		tabID.add(lblIDTema);

		JLabel lblIDArea = new JLabel("Área");
		lblIDArea.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblIDArea.setBounds(26, 135, 60, 30);
		tabID.add(lblIDArea);

		JLabel lblIDSubarea = new JLabel("Subárea");
		lblIDSubarea.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblIDSubarea.setBounds(295, 135, 60, 30);
		tabID.add(lblIDSubarea);

		JLabel lblIDGrupo = new JLabel("ID do Grupo");
		lblIDGrupo.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblIDGrupo.setBounds(26, 53, 108, 30);
		tabID.add(lblIDGrupo);

		tfIDGrupo = new JTextField();
		tfIDGrupo.setBackground(new Color(248, 248, 248));
		tfIDGrupo.setColumns(10);
		tfIDGrupo.setBounds(118, 53, 348, 30);
		tabID.add(tfIDGrupo);

		JTextArea taIDLista = new JTextArea();
		taIDLista.setBackground(new Color(248, 248, 248));
		taIDLista.setBounds(118, 176, 397, 141);
		tabID.add(taIDLista);

		JLabel lblIDLista = new JLabel("Integrantes");
		lblIDLista.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblIDLista.setBounds(26, 176, 108, 30);
		tabID.add(lblIDLista);

		JButton btnIDBuscar = new JButton("Buscar Grupo");
		btnIDBuscar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnIDBuscar.setBackground(new Color(0, 255, 64));
		btnIDBuscar.setBounds(476, 53, 123, 30);
		tabID.add(btnIDBuscar);

		JButton btnIDAdicionarOrientacao = new JButton("Adicionar Orientação");
		btnIDAdicionarOrientacao.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnIDAdicionarOrientacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIDAdicionarOrientacao.setBackground(new Color(255, 255, 0));
		btnIDAdicionarOrientacao.setBounds(333, 328, 182, 47);
		tabID.add(btnIDAdicionarOrientacao);

		JTextArea taIDTema = new JTextArea();
		taIDTema.setBackground(new Color(248, 248, 248));
		taIDTema.setBounds(118, 94, 397, 30);
		tabID.add(taIDTema);

		JTextArea taIDArea = new JTextArea();
		taIDArea.setBackground(new Color(248, 248, 248));
		taIDArea.setBounds(118, 135, 160, 30);
		tabID.add(taIDArea);

		JTextArea taIDSubarea = new JTextArea();
		taIDSubarea.setBackground(new Color(248, 248, 248));
		taIDSubarea.setBounds(355, 135, 160, 30);
		tabID.add(taIDSubarea);

		JButton btnIDUltimaOrientacao = new JButton("Última Orientação");

		btnIDUltimaOrientacao.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnIDUltimaOrientacao.setBackground(new Color(128, 255, 0));
		btnIDUltimaOrientacao.setBounds(118, 328, 169, 47);
		tabID.add(btnIDUltimaOrientacao);

		JPanel tabOrientacao = new JPanel();
		tabOrientacao.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Registrar Orientação", null, tabOrientacao, "Defina Uma Orientação Para Algum Grupo");
		tabOrientacao.setLayout(null);

		JLabel lblOrientacaoGrupo = new JLabel("ID do Grupo");
		lblOrientacaoGrupo.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblOrientacaoGrupo.setBounds(10, 68, 88, 30);
		tabOrientacao.add(lblOrientacaoGrupo);

		tfOrientacaoGrupo = new JTextField();
		tfOrientacaoGrupo.setBackground(new Color(248, 248, 248));
		tfOrientacaoGrupo.setColumns(10);
		tfOrientacaoGrupo.setBounds(108, 69, 186, 30);
		tabOrientacao.add(tfOrientacaoGrupo);

		JButton btnOrientacaoBuscar = new JButton("Buscar Grupo");
		btnOrientacaoBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrientacaoBuscar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnOrientacaoBuscar.setBackground(new Color(0, 255, 64));
		btnOrientacaoBuscar.setBounds(306, 68, 123, 30);
		tabOrientacao.add(btnOrientacaoBuscar);

		JLabel lblOrientacaoData = new JLabel("Data");
		lblOrientacaoData.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblOrientacaoData.setBounds(439, 68, 43, 30);
		tabOrientacao.add(lblOrientacaoData);

		tfOrientacaoData = new JTextField();
		tfOrientacaoData.setBackground(new Color(248, 248, 248));
		tfOrientacaoData.setColumns(10);
		tfOrientacaoData.setBounds(478, 68, 141, 30);
		tabOrientacao.add(tfOrientacaoData);

		JLabel lblOrientacaoDescricao = new JLabel("Descrição");
		lblOrientacaoDescricao.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblOrientacaoDescricao.setBounds(28, 138, 112, 30);
		tabOrientacao.add(lblOrientacaoDescricao);

		JButton btnOrientacaoLancar = new JButton("Lançar Orientação");
		btnOrientacaoLancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrientacaoLancar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnOrientacaoLancar.setBackground(new Color(0, 255, 64));
		btnOrientacaoLancar.setBounds(232, 328, 159, 38);
		tabOrientacao.add(btnOrientacaoLancar);

		tfOrientacaoDescricao = new JTextField();
		tfOrientacaoDescricao.setColumns(10);
		tfOrientacaoDescricao.setBackground(new Color(248, 248, 248));
		tfOrientacaoDescricao.setBounds(104, 144, 418, 173);
		tabOrientacao.add(tfOrientacaoDescricao);

		JButton btnOrientacaoSair = new JButton("Sair ->");
		btnOrientacaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Deseja fechar a aplicação?", "Saída",
						JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnOrientacaoSair.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnOrientacaoSair.setBackground(new Color(255, 128, 64));
		btnOrientacaoSair.setBounds(530, 11, 89, 23);
		tabOrientacao.add(btnOrientacaoSair);

		JPanel tabConsultaOrientacao = new JPanel();
		tabConsultaOrientacao.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Consultar Última Orientação", null, tabConsultaOrientacao,
				"Consulte a Última Orientação Definida");
		tabConsultaOrientacao.setLayout(null);

		JLabel lblUltimaGrupo = new JLabel("ID do Grupo");
		lblUltimaGrupo.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblUltimaGrupo.setBounds(28, 67, 88, 30);
		tabConsultaOrientacao.add(lblUltimaGrupo);

		JLabel lblUltimaData = new JLabel("Data");
		lblUltimaData.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblUltimaData.setBounds(417, 67, 43, 30);
		tabConsultaOrientacao.add(lblUltimaData);

		JLabel lblUltimaDescricao = new JLabel("Descrição");
		lblUltimaDescricao.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblUltimaDescricao.setBounds(28, 138, 112, 30);
		tabConsultaOrientacao.add(lblUltimaDescricao);

		JTextArea taUltimaData = new JTextArea();
		taUltimaData.setBackground(new Color(248, 248, 248));
		taUltimaData.setBounds(470, 67, 149, 30);
		tabConsultaOrientacao.add(taUltimaData);

		JTextArea taUltimaDescricao = new JTextArea();
		taUltimaDescricao.setBackground(new Color(248, 248, 248));
		taUltimaDescricao.setBounds(107, 142, 492, 164);
		tabConsultaOrientacao.add(taUltimaDescricao);

		JButton btnUltimaSair = new JButton("Sair ->");
		btnUltimaSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Deseja fechar a aplicação?", "Saída",
						JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnUltimaSair.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnUltimaSair.setBackground(new Color(255, 128, 64));
		btnUltimaSair.setBounds(530, 11, 89, 23);
		tabConsultaOrientacao.add(btnUltimaSair);

		JButton btnUltimaBuscar = new JButton("Buscar Grupo");
		btnUltimaBuscar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnUltimaBuscar.setBackground(new Color(0, 255, 64));
		btnUltimaBuscar.setBounds(271, 67, 123, 30);
		tabConsultaOrientacao.add(btnUltimaBuscar);

		tfUltimaGrupo = new JTextField();
		tfUltimaGrupo.setBounds(126, 68, 136, 30);
		tabConsultaOrientacao.add(tfUltimaGrupo);
		tfUltimaGrupo.setColumns(10);

		JPanel tabConsultaSubarea = new JPanel();
		tabConsultaSubarea.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Consultar por Subárea", null, tabConsultaSubarea,
				"Consulte Uma Lista de Grupos Por Subárea");
		tabConsultaSubarea.setLayout(null);

		JButton btnSubSair = new JButton("Sair ->");
		btnSubSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Deseja fechar a aplicação?", "Saída",
						JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnSubSair.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnSubSair.setBackground(new Color(255, 128, 64));
		btnSubSair.setBounds(530, 11, 89, 23);
		tabConsultaSubarea.add(btnSubSair);

		JLabel lblSubSubarea = new JLabel("Subárea");
		lblSubSubarea.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSubSubarea.setBounds(80, 60, 80, 40);
		tabConsultaSubarea.add(lblSubSubarea);

		JLabel lblSubListaGrupos = new JLabel("Lista de Grupos");
		lblSubListaGrupos.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblSubListaGrupos.setBounds(40, 125, 120, 40);
		tabConsultaSubarea.add(lblSubListaGrupos);

		tfSubSubarea = new JTextField();
		tfSubSubarea.setBounds(150, 66, 310, 30);
		tabConsultaSubarea.add(tfSubSubarea);
		tfSubSubarea.setColumns(10);

		JButton btnSubBuscar = new JButton("Buscar Grupos");
		btnSubBuscar.setBackground(new Color(0, 255, 64));
		btnSubBuscar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnSubBuscar.setBounds(470, 65, 149, 30);
		tabConsultaSubarea.add(btnSubBuscar);

		JTextArea taSubListaGrupos = new JTextArea();
		taSubListaGrupos.setBackground(new Color(248, 248, 248));
		taSubListaGrupos.setBounds(150, 134, 320, 217);
		tabConsultaSubarea.add(taSubListaGrupos);

		RegistrarAlunos cAlunos = new RegistrarAlunos(tfAlunoNome, tfAlunoRa);
		RegistrarGrupos cGrupos = new RegistrarGrupos(tfGrupoTema, tfGrupoArea, tfGrupoSubarea, tfGrupoRaAluno,
				taGrupoListaAluno);
		ConsultarGrupo cID = new ConsultarGrupo(tfIDGrupo, taIDTema, taIDArea, taIDSubarea, taIDLista);
		RegistrarOrientacoes cOrientacoes = new RegistrarOrientacoes(tfOrientacaoGrupo, tfOrientacaoData,
				tfOrientacaoDescricao);
		ConsultarOrientacao cUltima = new ConsultarOrientacao(tfUltimaGrupo, taUltimaData, taUltimaDescricao);
		ConsultarSubarea cSub = new ConsultarSubarea(tfSubSubarea, taSubListaGrupos);

		btnAlunoCadastrar.addActionListener(cAlunos);
		btnGrupoBuscar.addActionListener(cGrupos);
		btnGrupoRegistrar.addActionListener(cGrupos);
		btnIDBuscar.addActionListener(cID);
		btnOrientacaoBuscar.addActionListener(cOrientacoes);
		btnOrientacaoLancar.addActionListener(cOrientacoes);
		btnUltimaBuscar.addActionListener(cUltima);
		btnSubBuscar.addActionListener(cSub);

		btnIDUltimaOrientacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
				tfUltimaGrupo.setText(tfIDGrupo.getText());
			}
		});

		btnIDAdicionarOrientacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
				tfOrientacaoGrupo.setText(tfIDGrupo.getText());
			}
		});
	}
}
