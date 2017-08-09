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
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import controller.Paciente;
import controller.Pessoa;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtLogin;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setTitle("Cl\u00EDnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 320);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmPaciente = new JMenuItem("Paciente");
		mnCadastro.add(mntmPaciente);
		
		JMenuItem mntmMdico = new JMenuItem("M\u00E9dico");
		mnCadastro.add(mntmMdico);
		
		JMenu mnAtendimento = new JMenu("Atendimento");
		menuBar.add(mnAtendimento);
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
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblDataNasc = new JLabel("Data de Nascimento");
		lblDataNasc.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JDateChooser dateChooser = new JDateChooser();
		
		JFormattedTextField txtCPF = new JFormattedTextField();
		txtCPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String caracteres="0987654321";
				
				if(!caracteres.contains(arg0.getKeyChar()+"")){
					arg0.consume();
				}
			}
		});
		
		JLabel lblErro = new JLabel("");
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lblErro.setText("");
					Pessoa p = new Paciente(txtNome.getText(), dateChooser.getDate(), txtCPF.getText(), txtLogin.getText(), passwordField.getPassword().toString(), textField.getText());
					System.out.println(p);
				}
				
				catch (Exception e) {
					lblErro.setText(e.getMessage());
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
													.addComponent(textField)
													.addComponent(lblSenha)
													.addComponent(lblConvenio))))
										.addComponent(lblNome)
										.addComponent(lblCpf))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblErro)
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
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLogin)
								.addComponent(lblSenha))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(43)
							.addComponent(lblErro)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCadastrar)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}
