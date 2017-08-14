package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private TelaCadastroPaciente telaCadastroPaciente = null;
	private TelaCadastroDependente telaCadastroDependente = null;
	private TelaCadastroMedico telaCadastroMedico = null;
	private TelaGerenciarPacientes telaGerenciarPacientes = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setTitle("Cl\u00EDnica M\u00E9dica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmPaciente = new JMenuItem("Paciente");
		mnCadastro.add(mntmPaciente);
		
		JMenuItem mntmDependente = new JMenuItem("Dependente");
		mnCadastro.add(mntmDependente);
		
		JMenuItem mntmMdico = new JMenuItem("M\u00E9dico");
		mnCadastro.add(mntmMdico);
		
		JMenu mnAtendimento = new JMenu("Atendimento");
		menuBar.add(mnAtendimento);
		
		JMenu mnGerenciar = new JMenu("Gerenciar");
		menuBar.add(mnGerenciar);
		
		JMenuItem mntmPacientes = new JMenuItem("Pacientes");
		mnGerenciar.add(mntmPacientes);
		
		JMenuItem mntmAtendimentos = new JMenuItem("Atendimentos");
		mnGerenciar.add(mntmAtendimentos);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		mntmPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (telaCadastroPaciente == null) {
					telaCadastroPaciente = TelaCadastroPaciente.getInstance();
					desktopPane.add(telaCadastroPaciente);
					telaCadastroPaciente.setVisible(true);
				}
				
				else {
					try {
						telaCadastroPaciente.setSelected(true);
					}
					
					catch (PropertyVetoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
			}
		});
		
		mntmDependente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (telaCadastroDependente == null) {
					telaCadastroDependente = TelaCadastroDependente.getInstance();
					desktopPane.add(telaCadastroDependente);
					telaCadastroDependente.setVisible(true);
				}
				
				else {
					try {
						telaCadastroDependente.setSelected(true);
					}
					
					catch (PropertyVetoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
			}
		});
		
		mntmMdico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (telaCadastroMedico == null) {
					telaCadastroMedico = TelaCadastroMedico.getInstance();
					desktopPane.add(telaCadastroMedico);
					telaCadastroMedico.setVisible(true);
				}
				
				else {
					try {
						telaCadastroMedico.setSelected(true);
					}
					
					catch (PropertyVetoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
			}
		});
		
		mntmPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (telaGerenciarPacientes == null) {
					telaGerenciarPacientes = TelaGerenciarPacientes.getInstance();
					desktopPane.add(telaGerenciarPacientes);
					telaGerenciarPacientes.setVisible(true);
				}
				
				else {
					try {
						telaGerenciarPacientes.setSelected(true);
					}
					
					catch (PropertyVetoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
			}
		});
	}
}
