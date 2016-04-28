package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import view.models.SingletonJFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class TelaLogin extends JFrame {
	private JTextField loginField;
	private JPasswordField senhaField;
	private static TelaLogin INSTANCE = null;
	
	public static TelaLogin getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new TelaLogin();
		}
		
		return INSTANCE;
	}

	private TelaLogin() {
		setResizable(false);		
		setBounds(100, 100, 397, 207);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(35, 30, 46, 14);
		getContentPane().add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(35, 70, 46, 14);
		getContentPane().add(lblSenha);
		
		loginField = new JTextField();
		loginField.setBounds(76, 27, 263, 20);
		getContentPane().add(loginField);
		loginField.setColumns(10);
		
		senhaField = new JPasswordField();
		senhaField.setBounds(76, 67, 263, 20);
		getContentPane().add(senhaField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(205, 115, 89, 23);
		getContentPane().add(btnLogin);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(91, 115, 89, 23);
		getContentPane().add(btnCancelar);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{loginField, senhaField, btnCancelar, btnLogin}));

	}
}
