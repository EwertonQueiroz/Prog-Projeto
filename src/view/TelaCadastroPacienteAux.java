package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.font.GraphicAttribute;
import java.awt.Dialog.ModalExclusionType;

public class TelaCadastroPacienteAux extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPacienteAux frame = new TelaCadastroPacienteAux();
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
	public TelaCadastroPacienteAux() {
		setTitle("Cadastro Paciente");
		setType(Type.UTILITY);
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 785, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(TelaCadastroPaciente.getInstance());
		TelaCadastroPaciente.getInstance().setVisible(true);
		TelaCadastroPaciente.getInstance().grabFocus();
	}

}
