package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Fachada;
import controller.Paciente;
import controller.Pessoa;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class TelaGerenciarPacientes extends JInternalFrame {
	private JTable table;
	TelaCadastroPacienteAux cadastroPacienteAux = new TelaCadastroPacienteAux();
	
	private static TelaGerenciarPacientes instance = null;
	
	public static TelaGerenciarPacientes getInstance () {
		if (TelaGerenciarPacientes.instance == null)
			TelaGerenciarPacientes.instance = new TelaGerenciarPacientes();
		
		return TelaGerenciarPacientes.instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerenciarPacientes frame = new TelaGerenciarPacientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private TelaGerenciarPacientes() {
		setTitle("Gerenciar Pacientes");
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setBounds(100, 100, 897, 520);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton btnCadastrarPaciente = new JButton("Cadastrar Paciente");
		btnCadastrarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroPacienteAux.dispose();
				cadastroPacienteAux = new TelaCadastroPacienteAux();
				cadastroPacienteAux.setVisible(true);
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar");
		
		JButton btnRemover = new JButton("Remover");
		
		JButton btnPesquisarCpf = new JButton("Pesquisar CPF");
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		table = new JTable();
		//JScrollPane scrollpane = new JScrollPane(table);
		
		table.setCellSelectionEnabled(true);
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		
		Object[] colunas = {"Nome", "Data de Nascimento", "CPF", "Convênio", "Login"};
		modelo.setColumnIdentifiers(colunas);
		table.setModel(modelo);
		
		Object[] linha = new Object[5];
		
		for (Pessoa pessoa : Fachada.getInstance().listarPessoas()) {
			if (pessoa instanceof Paciente) {
				linha[0] = pessoa.getNome();
				linha[1] = pessoa.getDataNasc();
				linha[2] = pessoa.getCPF();
				linha[3] = ((Paciente) pessoa).getConvenio();
				linha[4] = ((Paciente) pessoa).getLogin();
				
				modelo.addRow(linha);
			}
		}
		
		JButton btnAtualizartela = new JButton("");
		btnAtualizartela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel(null, new String[]{"Nome", "Data de Nascimento", "CPF", "Convênio", "Login"}));
				table.setModel(modelo);
				for (Pessoa pessoa : Fachada.getInstance().listarPessoas()) {
					if (pessoa instanceof Paciente) {
						linha[0] = pessoa.getNome();
						linha[1] = pessoa.getDataNasc();
						linha[2] = pessoa.getCPF();
						linha[3] = ((Paciente) pessoa).getConvenio();
						linha[4] = ((Paciente) pessoa).getLogin();
						
						modelo.addRow(linha);
					}
				}
			}
		});
		btnAtualizartela.setIcon(new ImageIcon("C:\\Users\\Ewerton\\Downloads\\btn-atualizar_30x30.png"));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(table, GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(73)
							.addComponent(btnCadastrarPaciente, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnAtualizar, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnRemover, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnPesquisarCpf, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
							.addGap(71)
							.addComponent(btnAtualizartela, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrarPaciente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnPesquisarCpf, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnRemover, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAtualizar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAtualizartela, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

	}
}
