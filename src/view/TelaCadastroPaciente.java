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
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import controller.Fachada;
import controller.Paciente;
import controller.Pessoa;
import model.RepositorioPessoasArray;

public class TelaCadastroPaciente extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtLogin;
	private JPasswordField passwordField;
	private JTextField txtConvenio;
	private Pessoa pessoa;
	
	private static TelaCadastroPaciente instance;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPaciente frame = new TelaCadastroPaciente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static TelaCadastroPaciente getInstance () {
		if (TelaCadastroPaciente.instance == null)
			TelaCadastroPaciente.instance = new TelaCadastroPaciente();
		
		return TelaCadastroPaciente.instance;
	}

	/**
	 * Create the frame.
	 */
	private TelaCadastroPaciente() {
		setIconifiable(true);
		setResizable(true);
		setMaximizable(true);
		setTitle("Cadastro Paciente");
		setBounds(100, 100, 785, 320);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		passwordField = new JPasswordField();
		
		JLabel lblConvenio = new JLabel("Conv\u00EAnio");
		lblConvenio.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtConvenio = new JTextField();
		txtConvenio.setColumns(10);
		
		JLabel lblDataNasc = new JLabel("Data de Nascimento");
		lblDataNasc.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JDateChooser dateChooser = new JDateChooser();
		
		JFormattedTextField txtCPF = new JFormattedTextField();
		txtCPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String caracteres = "0987654321";
				
				if (!caracteres.contains(arg0.getKeyChar() + ""))
					arg0.consume();
			}
		});
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					pessoa = new Paciente();
					pessoa.setNome(txtNome.getText());
					pessoa.setDataNasc(dateChooser.getDate());
					pessoa.setCPF(txtCPF.getText());
					((Paciente) pessoa).setLogin(txtLogin.getText());
					((Paciente) pessoa).setPasswd(passwordField.getPassword().toString());
					((Paciente) pessoa).setConvenio(txtConvenio.getText());
				
					Fachada.getInstance().cadastrar(pessoa);
					
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.");
					
					txtNome.setText("");
					dateChooser.cleanup();
					txtCPF.setText("");
					txtLogin.setText("");
					passwordField.setText("");
					txtConvenio.setText("");
				}
				
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
				}
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLogin)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
											.addComponent(txtNome)
											.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
													.addComponent(txtLogin)
													.addComponent(txtCPF, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
												.addGap(18)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
													.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
													.addComponent(txtConvenio)
													.addComponent(lblSenha)
													.addComponent(lblConvenio))))
										.addComponent(lblNome)
										.addComponent(lblCpf))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDataNasc)
										.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(319)
							.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(lblDataNasc))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCpf)
								.addComponent(lblConvenio))
							.addGap(5)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtConvenio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLogin)
								.addComponent(lblSenha))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCadastrar)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
	
}
