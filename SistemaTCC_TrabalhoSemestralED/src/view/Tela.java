package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Tela extends JFrame {

	private static final long serialVersionUID = -8533024649811972087L;
	private JPanel contentPane;
	private JTextField tfAlunoNome;
	private JTextField tfAlunoRa;
	private JTextField tfGrupoTema;
	private JTextField tfGrupoArea;
	private JTextField tfGrupoSubarea;
	private JTextField tfGrupoNomeAluno;
	private JTextField tfIDGrupo;
	private JTextField textField;
	private JTextField txtData;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(0, 0, 634, 441);
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

		JLabel lblGrupoNomeAluno = new JLabel("Nome do Aluno");
		lblGrupoNomeAluno.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblGrupoNomeAluno.setBounds(10, 135, 108, 30);
		tabGrupo.add(lblGrupoNomeAluno);

		tfGrupoNomeAluno = new JTextField();
		tfGrupoNomeAluno.setBackground(new Color(248, 248, 248));
		tfGrupoNomeAluno.setColumns(10);
		tfGrupoNomeAluno.setBounds(118, 135, 348, 30);
		tabGrupo.add(tfGrupoNomeAluno);

		JTextArea taGrupoListaAluno = new JTextArea();
		taGrupoListaAluno.setBackground(new Color(248, 248, 248));
		taGrupoListaAluno.setBounds(118, 176, 397, 141);
		tabGrupo.add(taGrupoListaAluno);

		JLabel lblGrupoListaAluno = new JLabel("Lista de Alunos");
		lblGrupoListaAluno.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblGrupoListaAluno.setBounds(10, 176, 108, 30);
		tabGrupo.add(lblGrupoListaAluno);

		JButton btnGrupoAdicionaAluno = new JButton("Adicionar Aluno");
		btnGrupoAdicionaAluno.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnGrupoAdicionaAluno.setBackground(new Color(0, 255, 64));
		btnGrupoAdicionaAluno.setBounds(476, 135, 143, 30);
		tabGrupo.add(btnGrupoAdicionaAluno);

		JButton btnGrupoCadastrar = new JButton("Registrar Grupo");
		btnGrupoCadastrar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnGrupoCadastrar.setBackground(new Color(0, 255, 64));
		btnGrupoCadastrar.setBounds(233, 335, 148, 37);
		tabGrupo.add(btnGrupoCadastrar);

		JPanel tabID = new JPanel();
		tabID.setBackground(new Color(255, 255, 255));
		tabID.setLayout(null);
		tabbedPane.addTab("Localizar Grupo", null, tabID, "Localizar Grupo Por ID");

		JButton btnIDSair = new JButton("Sair ->");
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

		JButton btnID = new JButton("Registrar Grupo");
		btnID.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnID.setBackground(new Color(0, 255, 64));
		btnID.setBounds(230, 337, 142, 37);
		tabID.add(btnID);

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

		JPanel tabOrientacao = new JPanel();
		tabOrientacao.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Definir Orientação", null, tabOrientacao, "Defina Uma Orientação Para Algum Grupo");
		tabOrientacao.setLayout(null);

		JLabel lblGrupoID = new JLabel("ID do Grupo");
		lblGrupoID.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblGrupoID.setBounds(189, 67, 88, 30);
		tabOrientacao.add(lblGrupoID);

		textField = new JTextField();
		textField.setBackground(new Color(248, 248, 248));
		textField.setColumns(10);
		textField.setBounds(280, 68, 186, 30);
		tabOrientacao.add(textField);

		JButton btnIDBuscar_1 = new JButton("Buscar Grupo");
		btnIDBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIDBuscar_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnIDBuscar_1.setBackground(new Color(0, 255, 64));
		btnIDBuscar_1.setBounds(476, 67, 123, 30);
		tabOrientacao.add(btnIDBuscar_1);

		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblData.setBounds(28, 67, 43, 30);
		tabOrientacao.add(lblData);

		txtData = new JTextField();
		txtData.setBackground(new Color(248, 248, 248));
		txtData.setColumns(10);
		txtData.setBounds(67, 67, 112, 30);
		tabOrientacao.add(txtData);

		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblDescricao.setBounds(28, 138, 112, 30);
		tabOrientacao.add(lblDescricao);

		JTextPane txpDescricao = new JTextPane();
		txpDescricao.setBackground(new Color(248, 248, 248));
		txpDescricao.setBounds(107, 140, 492, 164);
		tabOrientacao.add(txpDescricao);

		JButton btnLancarOrientacao = new JButton("Lançar Orientação");
		btnLancarOrientacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLancarOrientacao.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnLancarOrientacao.setBackground(new Color(0, 255, 64));
		btnLancarOrientacao.setBounds(232, 328, 159, 38);
		tabOrientacao.add(btnLancarOrientacao);

		JButton btnIDSair_1 = new JButton("Sair ->");
		btnIDSair_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnIDSair_1.setBackground(new Color(255, 128, 64));
		btnIDSair_1.setBounds(530, 11, 89, 23);
		tabOrientacao.add(btnIDSair_1);

		JPanel tabConsultaOrientacao = new JPanel();
		tabConsultaOrientacao.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Última Orientação", null, tabConsultaOrientacao, "Consulte a Última Orientação Definida");
		tabConsultaOrientacao.setLayout(null);

		JPanel tabConsultaSubarea = new JPanel();
		tabConsultaSubarea.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Consultar Por Subárea", null, tabConsultaSubarea,
				"Consulte Uma Lista de Grupos Por Subárea");
		tabConsultaSubarea.setLayout(null);
	}
}
