package view.models;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class SingletonJInternalFrame extends JInternalFrame {
	
	protected static SingletonJInternalFrame instance = null;

	protected SingletonJInternalFrame() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent arg0) {
				instance = null;
			}
		});
		setIconifiable(true);
		setClosable(true);
		setResizable(true);
		try {
			setMaximum(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(instance, "Erro de maximização", "Não é possível maximizar esta tela!", JOptionPane.WARNING_MESSAGE);
		}
		setMaximizable(true);
		setBounds(100, 100, 450, 300);

	}
	
	public static SingletonJInternalFrame getInstance() {
		if(instance ==  null) {
			instance = new SingletonJInternalFrame();
		}
		
		return instance;
	}

}
