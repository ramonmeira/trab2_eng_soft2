package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField loginTextField;
	private JTextField senhaTextField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaLogin frame = new TelaLogin();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(46, 39, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(46, 86, 46, 14);
		contentPane.add(lblSenha);
		
		loginTextField = new JTextField();
		loginTextField.setBounds(84, 36, 266, 20);
		contentPane.add(loginTextField);
		loginTextField.setColumns(10);
		
		senhaTextField = new JTextField();
		senhaTextField.setBounds(84, 83, 266, 20);
		contentPane.add(senhaTextField);
		senhaTextField.setColumns(10);
		
		JButton okButton = new JButton("OK");
		okButton.setBounds(230, 140, 89, 23);
		contentPane.add(okButton);
		
		JButton cancelarButton = new JButton("Cancelar");
		cancelarButton.setBounds(110, 140, 89, 23);
		contentPane.add(cancelarButton);
	}
}
