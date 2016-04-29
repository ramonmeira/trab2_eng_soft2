package view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import control.TelaPrincipalControl;
import view.models.SingletonJInternalFrame;

import java.beans.PropertyVetoException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class CadastroEstoque extends SingletonJInternalFrame {
	private JFormattedTextField txtId;
	private JTextField txtLocal;
	private JFormattedTextField txtIdProduto;
	private JTextField txtDescricaoProduto;
	private JFormattedTextField txtQtd;
	private JFormattedTextField txtPreco;
	
	TelaPrincipalControl controle;

	public CadastroEstoque() {
		super();
		setTitle("Estoque");
		try {
			setMaximum(true);
			getContentPane().setLayout(null);
			
			DateFormatter displayFormat = new DateFormatter(new SimpleDateFormat("dd/MM/yyyy"));
			DateFormatter editFormat = new DateFormatter(new SimpleDateFormat("ddMMyyyy"));
			DefaultFormatterFactory dateFormat = new DefaultFormatterFactory(displayFormat, displayFormat, editFormat);
			
			NumberFormatter displayPreco = new NumberFormatter(NumberFormat.getCurrencyInstance());
			NumberFormatter editPreco = new NumberFormatter(new java.text.DecimalFormat("#,##0.##"));
			DefaultFormatterFactory moedaFactory = new DefaultFormatterFactory(displayPreco, displayPreco, editPreco);
			
			JLabel lblId = new JLabel("ID");
			lblId.setBounds(20, 20, 46, 14);
			getContentPane().add(lblId);
			
			try {
				txtId = new JFormattedTextField(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(this, "ID inválido", "O número do ID informado possui formato inválido!", JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
			txtId.setText("ID");
			txtId.setBounds(20, 35, 86, 20);
			getContentPane().add(txtId);
			txtId.setColumns(6);
			
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
			
			try {
				txtIdProduto = new JFormattedTextField(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(this, "ID inválido", "O número do ID informado possui formato inválido!", JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
			txtIdProduto.setBounds(20, 80, 86, 20);
			getContentPane().add(txtIdProduto);
			txtIdProduto.setColumns(6);
			
			txtDescricaoProduto = new JTextField();
			txtDescricaoProduto.setBounds(116, 80, 361, 20);
			getContentPane().add(txtDescricaoProduto);
			txtDescricaoProduto.setColumns(10);
			
			JLabel lblDescricaoProtudo = new JLabel("Descri\u00E7\u00E3o Protudo");
			lblDescricaoProtudo.setBounds(116, 66, 108, 14);
			getContentPane().add(lblDescricaoProtudo);
			
			try {
				txtQtd = new JFormattedTextField(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(this, "Quantidade inválida", "A quantidade informada possui um formato inválido!", JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			}
			txtQtd.setBounds(418, 35, 59, 20);
			getContentPane().add(txtQtd);
			txtQtd.setColumns(6);
			
			JLabel lblQtd = new JLabel("Qtd");
			lblQtd.setBounds(418, 20, 46, 14);
			getContentPane().add(lblQtd);
			
			JFormattedTextField frmtdtxtfldDtFabricacao = new JFormattedTextField(dateFormat);
			frmtdtxtfldDtFabricacao.setColumns(8);
			frmtdtxtfldDtFabricacao.setBounds(20, 125, 86, 20);
			getContentPane().add(frmtdtxtfldDtFabricacao);
			
			JLabel lblDtFabricacao = new JLabel("Dt. Fabrica\u00E7\u00E3o");
			lblDtFabricacao.setBounds(20, 110, 73, 14);
			getContentPane().add(lblDtFabricacao);
			
			JFormattedTextField frmtdtxtfldDtValidade = new JFormattedTextField(dateFormat);
			frmtdtxtfldDtValidade.setColumns(8);
			frmtdtxtfldDtValidade.setBounds(116, 125, 86, 20);
			getContentPane().add(frmtdtxtfldDtValidade);
			
			JLabel lblDtValidade = new JLabel("Dt. Validade");
			lblDtValidade.setBounds(116, 111, 66, 14);
			getContentPane().add(lblDtValidade);
			
			txtPreco = new JFormattedTextField(moedaFactory);
//			try {
//				txtPreco = new JFormattedTextField(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("R$ ##.####0,00")));
//			} catch (ParseException e) {
//				JOptionPane.showMessageDialog(this, "Preço inválido", "O preço informado possui um formato inválido!", JOptionPane.WARNING_MESSAGE);
//				e.printStackTrace();
//			}
			txtPreco.setBounds(212, 125, 86, 20);
			getContentPane().add(txtPreco);
			txtPreco.setColumns(8);
			
			JLabel lblPrecoUnit = new JLabel("Pre\u00E7o Unit.");
			lblPrecoUnit.setBounds(212, 110, 66, 14);
			getContentPane().add(lblPrecoUnit);
			
		}
		catch(PropertyVetoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Erro de maximização", "Não é possível maximizar esta tela!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public static CadastroEstoque getInstance() {
		if(instance == null) {
			instance = new CadastroEstoque();
		}
		
		return (CadastroEstoque) instance;
	}
	
	public void setControl(TelaPrincipalControl controle) {
		this.controle = controle;
	}
}
