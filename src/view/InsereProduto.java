package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import control.TelaPrincipalControl;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InsereProduto extends JInternalFrame {
	private JTextField txtProduto;
	
	private TelaPrincipalControl controle;
	
	public InsereProduto(TelaPrincipalControl controll) {
		setBounds(115, 115, 377, 184);
		getContentPane().setLayout(null);
		
		txtProduto = new JTextField();
		txtProduto.setBounds(42, 60, 281, 20);
		getContentPane().add(txtProduto);
		txtProduto.setColumns(10);
		this.controle = controll;
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controle.insereProduto(txtProduto.getText());
			}
		});
		btnInserir.setBounds(155, 102, 89, 23);
		getContentPane().add(btnInserir);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(42, 35, 46, 14);
		lblProduto.setSize(lblProduto.getPreferredSize());
		getContentPane().add(lblProduto);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controle.fechaInsereProduto();
			}
		});
		btnCancelar.setBounds(42, 102, 89, 23);
		getContentPane().add(btnCancelar);
	}
}
