package view;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import view.models.SingletonJInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JFormattedTextField;

public class CadastroProduto extends SingletonJInternalFrame {
	private JFormattedTextField txtId;
	private JTextField txtDescricao;
	private JTextField txtFabricante;
	private JTextField txtModelo;
	private JFormattedTextField txtCodEan;

	public CadastroProduto() {
		super();
		setTitle("Cadastro de Produto");
		try {
			setMaximum(true);
			getContentPane().setLayout(null);
			
			JLabel lblId = new JLabel("ID");
			lblId.setBounds(20, 20, 25, 14);
			getContentPane().add(lblId);
			
			txtId = new JFormattedTextField();
			txtId.setBounds(20, 35, 86, 20);
			getContentPane().add(txtId);
			txtId.setColumns(10);
			
			txtDescricao = new JTextField();
			txtDescricao.setBounds(116, 35, 363, 20);
			getContentPane().add(txtDescricao);
			txtDescricao.setColumns(10);
			
			JLabel lblDescricao = new JLabel("Descricao");
			lblDescricao.setBounds(116, 20, 46, 14);
			getContentPane().add(lblDescricao);
			
			JLabel lblFabricante = new JLabel("Fabricante");
			lblFabricante.setBounds(20, 65, 67, 14);
			getContentPane().add(lblFabricante);
			
			txtFabricante = new JTextField();
			txtFabricante.setBounds(20, 80, 300, 20);
			getContentPane().add(txtFabricante);
			txtFabricante.setColumns(10);
			
			txtModelo = new JTextField();
			txtModelo.setBounds(330, 80, 149, 20);
			getContentPane().add(txtModelo);
			txtModelo.setColumns(10);
			
			JLabel lblModelo = new JLabel("Modelo");
			lblModelo.setBounds(330, 65, 46, 14);
			getContentPane().add(lblModelo);
			
			JLabel lblCodEan = new JLabel("Cod. EAN");
			lblCodEan.setBounds(20, 110, 46, 14);
			getContentPane().add(lblCodEan);
			
			txtCodEan = new JFormattedTextField();
			txtCodEan.setBounds(20, 125, 142, 20);
			getContentPane().add(txtCodEan);
			txtCodEan.setColumns(10);
			
			JComboBox cmbFornecedor = new JComboBox();
			cmbFornecedor.setBounds(172, 125, 307, 20);
			getContentPane().add(cmbFornecedor);
			
			JLabel lblFornecedor = new JLabel("Fornecedor");
			lblFornecedor.setBounds(172, 111, 67, 14);
			getContentPane().add(lblFornecedor);
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(20, 182, 89, 23);
			getContentPane().add(btnCancelar);
			
			JButton btnCadastrar = new JButton("Cadastrar");
			btnCadastrar.setBounds(152, 182, 89, 23);
			getContentPane().add(btnCadastrar);
			setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtId, txtDescricao, txtFabricante, txtModelo, txtCodEan, cmbFornecedor, btnCancelar, btnCadastrar}));
		}
		catch(PropertyVetoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Erro de maximização", "Não é possível maximizar esta tela!", JOptionPane.WARNING_MESSAGE);
		}

	}
}
