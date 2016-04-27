package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.LoginControl;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaLogin {

	private JFrame frmSistemaDeGerenciamento;
	private JTextField loginField;
	private JPasswordField passwordField;
	
	private LoginControl loginControl;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaLogin window = new TelaLogin();
//					window.frmSistemaDeGerenciamento.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public TelaLogin() {
		initialize();
	}
	
	public void visualizar(boolean visualizar) {
		frmSistemaDeGerenciamento.setVisible(visualizar);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaDeGerenciamento = new JFrame();
		frmSistemaDeGerenciamento.setTitle("Sistema de Gerenciamento Comercial - Login");
		frmSistemaDeGerenciamento.setBounds(100, 100, 398, 219);
		frmSistemaDeGerenciamento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaDeGerenciamento.getContentPane().setLayout(null);
		
		loginControl = new LoginControl(this);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(35, 35, 46, 14);
		frmSistemaDeGerenciamento.getContentPane().add(lblLogin);
		
		loginField = new JTextField();
		loginField.setBounds(73, 32, 264, 20);
		frmSistemaDeGerenciamento.getContentPane().add(loginField);
		loginField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(35, 80, 46, 14);
		frmSistemaDeGerenciamento.getContentPane().add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(73, 77, 264, 20);
		frmSistemaDeGerenciamento.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(loginControl.usuarioValido()) {
					loginControl.iniciaTelaPrincipal();
				}
			}
		});
		btnLogin.setBounds(213, 123, 89, 23);
		frmSistemaDeGerenciamento.getContentPane().add(btnLogin);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(96, 123, 89, 23);
		frmSistemaDeGerenciamento.getContentPane().add(btnCancelar);
	}

}
