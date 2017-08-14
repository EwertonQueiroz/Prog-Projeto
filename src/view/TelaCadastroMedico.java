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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import controller.ExceptionPessoaCadastrada;
import controller.Fachada;
import controller.Medico;
import controller.Pessoa;

public class TelaCadastroMedico extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtCRM;
	private JTextField txtLogin;
	private JPasswordField passwordField;
	private Pessoa pessoa;
	
	private static TelaCadastroMedico instance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroMedico frame = new TelaCadastroMedico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static TelaCadastroMedico getInstance () {
		if (TelaCadastroMedico.instance == null)
			TelaCadastroMedico.instance = new TelaCadastroMedico();
		
		return TelaCadastroMedico.instance;
	}

	/**
	 * Create the frame.
	 */
	private TelaCadastroMedico() {
		setIconifiable(true);
		setResizable(true);
		setMaximizable(true);
		setTitle("Cadastro M\u00E9dico");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 776, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		JDateChooser dateChooserDataNasc = new JDateChooser();
		
		JLabel lblDataNascimento = new JLabel("Data de Nascimento");
		lblDataNascimento.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String caracteres = "0987654321";
				
				if (!caracteres.contains(arg0.getKeyChar() + ""))
					arg0.consume();
			}
		});
		
		JLabel lblCrm = new JLabel("CRM");
		
		txtCRM = new JTextField();
		txtCRM.setColumns(10);
		txtCRM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String caracteres = "0987654321";
				
				if (!caracteres.contains(arg0.getKeyChar() + ""))
					arg0.consume();
			}
		});
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		passwordField = new JPasswordField();
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					pessoa = new Medico();
					pessoa.setNome(txtNome.getText());
					pessoa.setDataNasc(dateChooserDataNasc.getDate());
					pessoa.setCPF(txtCPF.getText());
					((Medico) pessoa).setCRM(Integer.parseInt(txtCRM.getText()));
					((Medico) pessoa).setLogin(txtLogin.getText());
					((Medico) pessoa).setPasswd(passwordField.getPassword().toString());
				
					Fachada.getInstance().cadastrar(pessoa);
					
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.");
					
					txtNome.setText("");
					dateChooserDataNasc.cleanup();
					txtCPF.setText("");
					txtCRM.setText("");
					txtLogin.setText("");
					passwordField.setText("");
				}
				
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
											.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
													.addComponent(lblCpf)
													.addComponent(txtCPF, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
													.addComponent(txtLogin))
												.addGap(27)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
													.addComponent(lblCrm)
													.addComponent(lblSenha)
													.addComponent(passwordField)
													.addComponent(txtCRM, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)))
											.addComponent(txtNome))
										.addComponent(lblNome))
									.addGap(36)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDataNascimento)
										.addComponent(dateChooserDataNasc, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblLogin)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(324)
							.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(lblDataNascimento))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCpf)
								.addComponent(lblCrm))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCRM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLogin)
								.addComponent(lblSenha))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(dateChooserDataNasc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnCadastrar)
					.addContainerGap(172, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
	
}
