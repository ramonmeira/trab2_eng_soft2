package view;

import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import control.TelaPrincipalControl;
import data.model.Cliente;
import view.models.CadastroBasicoPF;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroCliente extends CadastroBasicoPF {

	private static final long serialVersionUID = -8071117372959399379L;
	
	private static CadastroCliente instance = null;
	
	private TelaPrincipalControl controle;
	
	private CadastroCliente() {
		super();
		setBounds(100, 100, 711, 375);
		setTitle("Cadastro de Cliente");
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Cliente cliente = new Cliente();
				cliente.setCpf(txtCpf.getText());
				cliente.setNome(txtNome.getText());
				cliente.setRg(txtRg.getText());
				cliente.setOrgaoExpedidor(txtExpedicao.getText());
				cliente.setUfExpepdidor(cmbUfExpedissao.getSelectedItem().toString());
				cliente.setDataEmissao(txtEmissao.getText());
				cliente.setDataNascimento(dtNascimentoField.getText());
				cliente.setNacionalidade(txtNacionalidade.getText());
				cliente.setNaturalidade(txtNaturalidade.getText());
				cliente.setUfNascimento(cmbUfNascimento.getSelectedItem().toString());
				cliente.setSexo(cmbSexo.getSelectedItem().toString());
				cliente.setCep(txtCep.getText());
				cliente.setLogradouro(txtEndereco.getText());
				cliente.setNumero(txtNumero.getText());
				cliente.setComplemento(txtComplemento.getText());
				cliente.setCidade(txtCidade.getText());
				cliente.setUfEndereco(cmbUfEndereco.getSelectedItem().toString());
				cliente.setTelResidencial(txtTelResidencial.getText());
				cliente.setTelCelular(txtTelCelular.getText());
				cliente.setEmail(txtEmail.getText());
				cliente.setEmailComercial(txtEmailComercial.getText());
				controle.salvaDadosCliente(cliente);
			}
		});
		btnSalvar.setBounds(22, 299, 89, 23);
		getContentPane().add(btnSalvar);
		
	}
	
	public static CadastroCliente getInstance() {
		if(instance == null) {
			instance = new CadastroCliente();
		}
		
		return instance;
	}
	
	public void setControl(TelaPrincipalControl controle) {
		this.controle = controle;
	}
	
	public void limpaCampos() {
		txtNome.setText("");
		txtRg.setText("");
		txtExpedicao.setText("");
		cmbUfExpedissao.setSelectedIndex(0);
		txtEmissao.setText("");
		dtNascimentoField.setText("");
		txtNacionalidade.setText("");
		txtNaturalidade.setText("");
		cmbUfNascimento.setSelectedIndex(0);
		cmbSexo.setSelectedIndex(0);
		txtCep.setText("");
		txtEndereco.setText("");
		txtNumero.setText("");
		txtComplemento.setText("");
		txtCidade.setText("");
		cmbUfEndereco.setSelectedIndex(0);
		txtTelResidencial.setText("");
		txtTelCelular.setText("");
		txtEmail.setText("");
		txtEmailComercial.setText("");
	}
	
	public void insereDados(ArrayList<String> dados) {
		txtCpf.setText(dados.get(0).substring(dados.get(0).indexOf("=") + 1).replace(".", ""));
		txtNome.setText(dados.get(1).substring(dados.get(1).indexOf("=") + 1));
		txtRg.setText(dados.get(2).substring(dados.get(2).indexOf("=") + 1).replace("/", ""));
		txtExpedicao.setText(dados.get(3).substring(dados.get(3).indexOf("=") + 1));
		cmbUfExpedissao.setSelectedItem(dados.get(4).substring(dados.get(4).indexOf("=") + 1));
		txtEmissao.setText(dados.get(5).substring(dados.get(5).indexOf("=") + 1));
		dtNascimentoField.setText(dados.get(6).substring(dados.get(6).indexOf("=") + 1));
		txtNacionalidade.setText(dados.get(7).substring(dados.get(7).indexOf("=") + 1));
		txtNaturalidade.setText(dados.get(8).substring(dados.get(8).indexOf("=") + 1));
		cmbUfNascimento.setSelectedItem(dados.get(9).substring(dados.get(9).indexOf("=") + 1));
		cmbSexo.setSelectedItem(dados.get(10).substring(dados.get(10).indexOf("=") + 1));
		txtCep.setText(dados.get(11).substring(dados.get(11).indexOf("=") + 1).replace("/", "").replace("-", ""));
		txtEndereco.setText(dados.get(12).substring(dados.get(12).indexOf("=") + 1));
		txtNumero.setText(dados.get(13).substring(dados.get(13).indexOf("=") + 1));
		txtComplemento.setText(dados.get(14).substring(dados.get(14).indexOf("=") + 1));
		txtCidade.setText(dados.get(15).substring(dados.get(15).indexOf("=") + 1));
		cmbUfEndereco.setSelectedItem(dados.get(16).substring(dados.get(16).indexOf("=") + 1));
		txtTelResidencial.setText(dados.get(17).substring(dados.get(17).indexOf("=") + 1).replace("(", "").replace(")", "").replace("-", "").replace(" ", ""));
		txtTelCelular.setText(dados.get(18).substring(dados.get(18).indexOf("=") + 1).replace("(", "").replace(")", "").replace("-", "").replace(" ", ""));
		txtEmail.setText(dados.get(19).substring(dados.get(19).indexOf("=") + 1));
		txtEmailComercial.setText(dados.get(20).substring(dados.get(20).indexOf("=") + 1));
	}
}
