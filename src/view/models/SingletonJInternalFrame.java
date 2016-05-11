package view.models;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class SingletonJInternalFrame extends JInternalFrame {

	protected SingletonJInternalFrame() {
		setIconifiable(true);
		setClosable(true);
		setResizable(true);
		setMaximizable(true);
		setBounds(100, 100, 450, 300);
	}
}
