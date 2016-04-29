package view;

import java.beans.PropertyVetoException;

import javax.swing.JOptionPane;

import control.TelaPrincipalControl;
import view.models.CadastroBasicoPF;
import javax.swing.JButton;
import java.awt.Component;

public class CadastroCliente extends CadastroBasicoPF {

	private static final long serialVersionUID = -8071117372959399379L;
	
	private TelaPrincipalControl controle;
	
	private CadastroCliente() {
		super();
		setTitle("Cadastro de Cliente");
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(130, 365, 89, 23);
		getContentPane().add(btnCadastrar);
		
	}
	
	public static CadastroCliente getInstance() {
		if(instance == null) {
			instance = new CadastroCliente();
		}
		
		return (CadastroCliente) instance;
	}
	
	public void setControl(TelaPrincipalControl controle) {
		this.controle = controle;
	}

}
