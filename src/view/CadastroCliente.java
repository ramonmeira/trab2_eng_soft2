package view;

import java.beans.PropertyVetoException;

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
		setBounds(100, 100, 711, 450);
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
				cliente.setTelResidencial(txtTelResidencial.getText());
				cliente.setTelCelular(txtTelCelular.getText());
				cliente.setEmail(txtEmail.getText());
				cliente.setEmailComercial(txtEmailComercial.getText());
				controle.cadastraCliente(cliente);
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
}
