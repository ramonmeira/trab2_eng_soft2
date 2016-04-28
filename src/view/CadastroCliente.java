package view;

import java.beans.PropertyVetoException;

import javax.swing.JOptionPane;

import view.models.CadastroBasicoPF;
import javax.swing.JButton;
import java.awt.Component;

public class CadastroCliente extends CadastroBasicoPF {

	private static final long serialVersionUID = -8071117372959399379L;
	
	private CadastroCliente() {
		super();
		setTitle("Cadastro de Cliente");
		
		try {
			setMaximum(true);
			
			JButton btnCadastrar = new JButton("Cadastrar");
			btnCadastrar.setBounds(130, 365, 89, 23);
			getContentPane().add(btnCadastrar);
		}
		catch(PropertyVetoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Erro de maximização", "Não é possível maximizar esta tela!", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	public static CadastroCliente getInstance() {
		if(instance == null) {
			instance = new CadastroCliente();
		}
		
		return (CadastroCliente) instance;
	}

}
