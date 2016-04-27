package view;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import view.models.SingletonJInternalFrame;

public class CadastroProduto extends SingletonJInternalFrame {

	public CadastroProduto() {
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
