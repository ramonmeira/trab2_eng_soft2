package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import control.TelaPrincipalControl;
import data.model.Venda;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JFormattedTextField;

public class CadastroVenda extends JInternalFrame {
	private static CadastroVenda instance = null;
	private TelaPrincipalControl controle;
	private JFormattedTextField txtCpfCliente;
	private JTextField txtNomeCliente;
	private JFormattedTextField txtCpfVendedor;
	private JTextField txtNomeVendedor;
	private JTextArea txtrProdutos;
	
	private CadastroVenda() {
		setTitle("Cadastro de venda");
		setIconifiable(true);
		setClosable(true);
		setMaximizable(false);
		setResizable(false);
		setBounds(100, 100, 575, 438);
		getContentPane().setLayout(null);
		
		JLabel lblCpfCliente = new JLabel("CPF cliente");
		lblCpfCliente.setBounds(10, 11, 64, 14);
		lblCpfCliente.setSize(lblCpfCliente.getPreferredSize());
		getContentPane().add(lblCpfCliente);
		
		try {
			txtCpfCliente = new JFormattedTextField(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCpfCliente.setBounds(10, 36, 171, 20);
		getContentPane().add(txtCpfCliente);
		txtCpfCliente.setColumns(10);
		
		JLabel lblNomeCliente = new JLabel("Nome Cliente");
		lblNomeCliente.setBounds(191, 11, 64, 14);
		lblNomeCliente.setSize(lblNomeCliente.getPreferredSize());
		getContentPane().add(lblNomeCliente);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(191, 36, 309, 20);
		getContentPane().add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		JLabel lblCpfVendedor = new JLabel("Cpf Vendedor");
		lblCpfVendedor.setBounds(10, 67, 89, 14);
		lblCpfVendedor.setSize(lblCpfVendedor.getPreferredSize());
		getContentPane().add(lblCpfVendedor);
		
		try {
			txtCpfVendedor = new JFormattedTextField(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCpfVendedor.setBounds(10, 92, 171, 20);
		getContentPane().add(txtCpfVendedor);
		txtCpfVendedor.setColumns(10);
		
		JLabel lblNomeVendedor = new JLabel("Nome Vendedor");
		lblNomeVendedor.setBounds(191, 67, 82, 14);
		lblNomeVendedor.setSize(lblNomeVendedor.getPreferredSize());
		getContentPane().add(lblNomeVendedor);
		
		txtNomeVendedor = new JTextField();
		txtNomeVendedor.setBounds(191, 92, 309, 20);
		getContentPane().add(txtNomeVendedor);
		txtNomeVendedor.setColumns(10);
		
		txtrProdutos = new JTextArea();
		txtrProdutos.setBounds(10, 148, 490, 197);
		getContentPane().add(txtrProdutos);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Venda venda = new Venda();
				venda.setCpfCliente(txtCpfCliente.getText());
				venda.setClienteNome(txtNomeCliente.getText());
				venda.setCpfVendedor(txtCpfVendedor.getText());
				venda.setVendedorNome(txtNomeVendedor.getText());
				for(int i = 0; i < txtrProdutos.getLineCount(); i++) {
					try {
						venda.adicionaProduto(txtrProdutos.getText(txtrProdutos.getLineStartOffset(i), txtrProdutos.getLineEndOffset(i)));
					} catch (BadLocationException e) {
						e.printStackTrace();
					};
				}
				controle.cadastraVenda(venda);
			}
		});
		btnSalvar.setBounds(10, 371, 89, 23);
		getContentPane().add(btnSalvar);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setBounds(10, 123, 76, 14);
		lblProdutos.setSize(lblProdutos.getPreferredSize());
		getContentPane().add(lblProdutos);
	}
	
	public static CadastroVenda getInstance() {
		if(instance == null) {
			instance = new CadastroVenda();
		}
		
		return instance;
	}
	
	public void setControl(TelaPrincipalControl controle) {
		this.controle = controle;
	}
	
	public void limpaCampos() {
		txtCpfCliente.setText("");
		txtNomeCliente.setText("");
		txtCpfVendedor.setText("");
		txtNomeVendedor.setText("");
		txtrProdutos.setText("");
	}
}
