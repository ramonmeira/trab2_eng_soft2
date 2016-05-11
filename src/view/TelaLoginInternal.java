package view;

import view.models.SingletonJInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.TelaPrincipalControl;

public class TelaLoginInternal extends SingletonJInternalFrame {
	private static TelaLoginInternal instance;
	
	private JTextField txtLogin;
	private JPasswordField pwdSenha;
	
	private TelaPrincipalControl controle = null;

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
		setBounds(100, 100, 440, 220);
	}
	
	public static TelaLoginInternal getInstance(){
		if(instance == null) {
			instance = new TelaLoginInternal();
		}
		
		return instance;
	}
	
	public void setControl(TelaPrincipalControl controle) {
		this.controle = controle;
	}
}
