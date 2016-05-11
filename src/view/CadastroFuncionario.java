package view;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;

import view.models.CadastroBasicoPF;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Component;

public class CadastroFuncionario extends CadastroBasicoPF {
	private static CadastroFuncionario instance = null;
	
	private JTextField txtLogin;
	private JPasswordField pwdSenha;
	private JPasswordField pwdConsifrmarsenha;

	public CadastroFuncionario() {
		super();
		setTitle("Cadastro de Funcion\u00E1rio");
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(20, 290, 46, 14);
		getContentPane().add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(20, 305, 225, 20);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(255, 290, 46, 14);
		getContentPane().add(lblSenha);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setBounds(255, 305, 170, 20);
		getContentPane().add(pwdSenha);
		
		JCheckBox chckbxGerente = new JCheckBox("Gerente");
		chckbxGerente.setBounds(611, 304, 65, 23);
		getContentPane().add(chckbxGerente);
		
		pwdConsifrmarsenha = new JPasswordField();
		pwdConsifrmarsenha.setBounds(435, 305, 170, 20);
		getContentPane().add(pwdConsifrmarsenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar senha");
		lblConfirmarSenha.setBounds(435, 290, 102, 14);
		getContentPane().add(lblConfirmarSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(130, 365, 89, 23);
		getContentPane().add(btnCadastrar);
	}
	
	public static CadastroFuncionario getInstance() {
		if(instance == null) {
			instance = new CadastroFuncionario();
		}
		
		return instance;
	}
}
