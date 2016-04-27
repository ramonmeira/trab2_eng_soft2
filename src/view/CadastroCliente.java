package view;

import java.beans.PropertyVetoException;

import javax.swing.JOptionPane;

import view.models.CadastroBasicoPF;

public class CadastroCliente extends CadastroBasicoPF {

	private static final long serialVersionUID = -8071117372959399379L;
	
	private CadastroCliente() {
		super();
		
		try {
			setMaximum(true);
		}
		catch(PropertyVetoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Erro de maximização", "Não é possível maximizar esta tela!", JOptionPane.WARNING_MESSAGE);
		}
		
	}

}
