package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;

public class TelaCadastroDependente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeTitular;
	private JTextField textField;
	private JTextField txtCPFTitular;
	private JTextField txtNomedependente;
	private JTextField txtCPFDependente;

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

	/**
	 * Create the frame.
	 */
	public TelaCadastroDependente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		txtNomeTitular.setColumns(10);
		
		JLabel lblCpfTitular = new JLabel("CPF Titular");
		lblCpfTitular.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		
		JLabel lblCpfTitular_1 = new JLabel("CPF Titular");
		lblCpfTitular_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtCPFTitular = new JTextField();
		txtCPFTitular.setColumns(10);
		
		JLabel lblNomeDependente = new JLabel("Nome Dependente");
		lblNomeDependente.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtNomedependente = new JTextField();
		txtNomedependente.setColumns(10);
		
		JLabel lblCpfDependente = new JLabel("CPF Dependente");
		lblCpfDependente.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtCPFDependente = new JTextField();
		txtCPFDependente.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento Dependente");
		lblDataDeNascimento.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JDateChooser dateChooser = new JDateChooser();
		
		JButton btnCadastrar = new JButton("Cadastrar");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtNomedependente, Alignment.LEADING)
							.addComponent(lblNomeTitular, Alignment.LEADING)
							.addComponent(lblCpfTitular, Alignment.LEADING)
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
							.addComponent(txtNomeTitular, Alignment.LEADING))
						.addComponent(lblNomeDependente))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblCpfTitular_1)
						.addComponent(lblCpfDependente)
						.addComponent(txtCPFDependente, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
						.addComponent(txtCPFTitular))
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
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeTitular)
						.addComponent(lblCpfTitular_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNomeTitular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCPFTitular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeDependente)
						.addComponent(lblCpfDependente)
						.addComponent(lblDataDeNascimento))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtNomedependente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtCPFDependente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnCadastrar)
					.addContainerGap(7, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}
