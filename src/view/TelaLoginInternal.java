package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import view.models.SingletonJInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import control.TelaPrincipalControl;

import java.awt.Component;

public class TelaLoginInternal extends SingletonJInternalFrame {
	private JTextField txtLogin;
	private JPasswordField pwdSenha;
	
	TelaPrincipalControl controle = null;

	private TelaLoginInternal() {
		super();
		setClosable(false);
		setResizable(false);
		setMaximizable(false);
		setIconifiable(false);
		getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(53, 49, 31, 14);
		getContentPane().add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(89, 46, 275, 20);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(53, 87, 38, 14);
		getContentPane().add(lblSenha);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setBounds(89, 84, 275, 20);
		getContentPane().add(pwdSenha);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controle.usuarioAutenticado(txtLogin.getText(), String.valueOf(pwdSenha.getPassword()));
			}
		});
		btnLogin.setBounds(175, 130, 89, 23);
		getContentPane().add(btnLogin);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblSenha, lblLogin, txtLogin, pwdSenha, btnLogin}));
		setBounds(100, 100, 440, 220);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtLogin, lblLogin, pwdSenha, lblSenha, btnLogin, getContentPane()}));
	}
	
	public static TelaLoginInternal getInstance(){
		if(instance == null) {
			instance = new TelaLoginInternal();
		}
		
		return (TelaLoginInternal) instance;
	}
	
	public void setControl(TelaPrincipalControl controle) {
		this.controle = controle;
	}
}
