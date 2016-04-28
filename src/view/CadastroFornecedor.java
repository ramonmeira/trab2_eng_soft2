package view;

import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import view.models.CadastroBasicoPJ;
import java.awt.Component;

public class CadastroFornecedor extends CadastroBasicoPJ {

	private static final long serialVersionUID = 1680750000093104596L;

	public CadastroFornecedor() {
		super();
		
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

}
