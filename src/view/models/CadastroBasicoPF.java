package view.models;

import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class CadastroBasicoPF extends JInternalFrame {

	private static final long serialVersionUID = 2528457607303713404L;

	public CadastroBasicoPF() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		try {
			setMaximum(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Erro de maximização", "Não é possível maximizar esta tela!", JOptionPane.WARNING_MESSAGE);
		}
		setResizable(true);
		setBounds(100, 100, 450, 300);

	}

}
