package view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import view.models.SingletonJInternalFrame;

import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class CadastroEstoque extends SingletonJInternalFrame {
	private JFormattedTextField txtId;
	private JTextField txtLocal;
	private JFormattedTextField txtIdProduto;
	private JTextField txtDescricaoProduto;
	private JTextField textField;

	public CadastroEstoque() {
		super();
		setTitle("Estoque");
		try {
			setMaximum(true);
			getContentPane().setLayout(null);
			
			JLabel lblId = new JLabel("ID");
			lblId.setBounds(20, 20, 46, 14);
			getContentPane().add(lblId);
			
			txtId = new JFormattedTextField();
			txtId.setText("ID");
			txtId.setBounds(20, 35, 86, 20);
			getContentPane().add(txtId);
			txtId.setColumns(10);
			
			txtLocal = new JTextField();
			txtLocal.setText("Local");
			txtLocal.setBounds(116, 35, 292, 20);
			getContentPane().add(txtLocal);
			txtLocal.setColumns(10);
			
			JLabel lblLocal = new JLabel("Local");
			lblLocal.setBounds(116, 20, 46, 14);
			getContentPane().add(lblLocal);
			
			JLabel lblIdProduto = new JLabel("ID Produto");
			lblIdProduto.setBounds(20, 65, 73, 14);
			getContentPane().add(lblIdProduto);
			
			txtIdProduto = new JFormattedTextField();
			txtIdProduto.setText("ID Produto");
			txtIdProduto.setBounds(20, 80, 86, 20);
			getContentPane().add(txtIdProduto);
			txtIdProduto.setColumns(10);
			
			txtDescricaoProduto = new JTextField();
			txtDescricaoProduto.setText("Descricao Produto");
			txtDescricaoProduto.setBounds(116, 80, 361, 20);
			getContentPane().add(txtDescricaoProduto);
			txtDescricaoProduto.setColumns(10);
			
			JLabel lblDescricaoProtudo = new JLabel("Descri\u00E7\u00E3o Protudo");
			lblDescricaoProtudo.setBounds(116, 66, 108, 14);
			getContentPane().add(lblDescricaoProtudo);
			
			textField = new JTextField();
			textField.setBounds(418, 35, 59, 20);
			getContentPane().add(textField);
			textField.setColumns(10);
			
			JLabel lblQtd = new JLabel("Qtd");
			lblQtd.setBounds(418, 20, 46, 14);
			getContentPane().add(lblQtd);
			
			JFormattedTextField frmtdtxtfldDtFabricacao = new JFormattedTextField();
			frmtdtxtfldDtFabricacao.setText("Dt Fabricacao");
			frmtdtxtfldDtFabricacao.setBounds(20, 125, 86, 20);
			getContentPane().add(frmtdtxtfldDtFabricacao);
			
			JLabel lblDtFabricacao = new JLabel("Dt. Fabrica\u00E7\u00E3o");
			lblDtFabricacao.setBounds(20, 110, 73, 14);
			getContentPane().add(lblDtFabricacao);
			
			JFormattedTextField frmtdtxtfldDtValidade = new JFormattedTextField();
			frmtdtxtfldDtValidade.setText("Dt Validade");
			frmtdtxtfldDtValidade.setBounds(116, 125, 86, 20);
			getContentPane().add(frmtdtxtfldDtValidade);
			
			JLabel lblDtValidade = new JLabel("Dt. Validade");
			lblDtValidade.setBounds(116, 111, 66, 14);
			getContentPane().add(lblDtValidade);
			
		}
		catch(PropertyVetoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Erro de maximização", "Não é possível maximizar esta tela!", JOptionPane.WARNING_MESSAGE);
		}
	}
}
