package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import controller.Dependente;
import controller.Fachada;
import controller.Paciente;
import controller.Pessoa;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class TelaCadastroDependente extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtNomeTitular;
	private JTextField txtCPFTitularBusca;
	private JTextField txtCPFTitularEncontrado;
	private JTextField txtNomeDependente;
	private JTextField txtCPFDependente;
	private Pessoa titular;
	private Pessoa dependente;
	
	private static TelaCadastroDependente instance; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroDependente frame = new TelaCadastroDependente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static TelaCadastroDependente getInstance () {
		if (TelaCadastroDependente.instance == null)
			TelaCadastroDependente.instance = new TelaCadastroDependente();
		
		return TelaCadastroDependente.instance;
	}
	
	/**
	 * Create the frame.
	 */
	private TelaCadastroDependente() {
		setIconifiable(true);
		setResizable(true);
		setMaximizable(true);
		setTitle("Cadastro Dependente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNomeTitular = new JLabel("Nome Titular");
		lblNomeTitular.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtNomeTitular = new JTextField();
		txtNomeTitular.setEditable(false);
		txtNomeTitular.setColumns(10);
		
		JLabel lblCpfTitular = new JLabel("CPF Titular");
		lblCpfTitular.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtCPFTitularBusca = new JTextField();
		txtCPFTitularBusca.setColumns(10);
		txtCPFTitularBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String caracteres = "0987654321";
				
				if (!caracteres.contains(arg0.getKeyChar() + ""))
					arg0.consume();
			}
		});
		
		
		JLabel lblCpfTitular_1 = new JLabel("CPF Titular");
		lblCpfTitular_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtCPFTitularEncontrado = new JTextField();
		txtCPFTitularEncontrado.setEditable(false);
		txtCPFTitularEncontrado.setColumns(10);
		
		JLabel lblNomeDependente = new JLabel("Nome Dependente");
		lblNomeDependente.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtNomeDependente = new JTextField();
		txtNomeDependente.setEnabled(false);
		txtNomeDependente.setColumns(10);
		
		JLabel lblCpfDependente = new JLabel("CPF Dependente");
		lblCpfDependente.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtCPFDependente = new JTextField();
		txtCPFDependente.setEnabled(false);
		txtCPFDependente.setColumns(10);
		txtCPFDependente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String caracteres = "0987654321";
				
				if (!caracteres.contains(arg0.getKeyChar() + ""))
					arg0.consume();
			}
		});
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento Dependente");
		lblDataDeNascimento.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setEnabled(false);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setEnabled(false);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dependente = new Dependente();
					dependente.setNome(txtNomeDependente.getText());
					dependente.setCPF(txtCPFDependente.getText());
					dependente.setDataNasc(dateChooser.getDate());
					
					Fachada.getInstance().cadastrarDependente(((Paciente) titular), ((Dependente) dependente));
					
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.");
					
					txtNomeDependente.setText("");
					txtCPFDependente.setText("");
					dateChooser.cleanup();
				}
				
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro: " + e1.getMessage());
				}
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					titular = Fachada.getInstance().pesquisar(txtCPFTitularBusca.getText());
					
					txtNomeTitular.setText(titular.getNome());
					txtCPFTitularEncontrado.setText(titular.getCPF());
					
					txtNomeDependente.setEnabled(true);
					txtCPFDependente.setEnabled(true);
					dateChooser.setEnabled(true);
					btnCadastrar.setEnabled(true);
				}
				
				catch (Exception e) {
					txtNomeTitular.setText("");
					txtCPFTitularEncontrado.setText("");
					
					txtNomeDependente.setEnabled(false);
					txtCPFDependente.setEnabled(false);
					dateChooser.setEnabled(false);
					btnCadastrar.setEnabled(false);
					
					JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
				}
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtNomeDependente, Alignment.LEADING)
							.addComponent(lblNomeTitular, Alignment.LEADING)
							.addComponent(lblCpfTitular, Alignment.LEADING)
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addComponent(txtCPFTitularBusca, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
							.addComponent(txtNomeTitular, Alignment.LEADING))
						.addComponent(lblNomeDependente))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblCpfTitular_1)
						.addComponent(lblCpfDependente)
						.addComponent(txtCPFDependente, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
						.addComponent(txtCPFTitularEncontrado))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblDataDeNascimento, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(346, Short.MAX_VALUE)
					.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(337))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCpfTitular)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCPFTitularBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeTitular)
						.addComponent(lblCpfTitular_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNomeTitular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCPFTitularEncontrado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeDependente)
						.addComponent(lblCpfDependente)
						.addComponent(lblDataDeNascimento))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtNomeDependente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtCPFDependente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnCadastrar)
					.addContainerGap(7, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}
