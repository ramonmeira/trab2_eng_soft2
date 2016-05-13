package view;

import java.util.ArrayList;
import javax.swing.JButton;

import control.TelaPrincipalControl;
import data.model.Fornecedor;
import view.models.CadastroBasicoPJ;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroFornecedor extends CadastroBasicoPJ {
	
	private static CadastroFornecedor instance = null;
	
	private JButton btnSalvar;
	private TelaPrincipalControl controle;

	private static final long serialVersionUID = 1680750000093104596L;

	public CadastroFornecedor() {
		super();
		setBounds(100, 100, 639, 220);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setCnpj(txtCnpj.getText());
				fornecedor.setRazaoSocial(txtRazaoSocial.getText());
				fornecedor.setAtivo(String.valueOf(chckbxAtivo.isSelected()));
				controle.salvaDadosFornecedor(fornecedor);
			}
		});
		btnSalvar.setBounds(20, 143, 89, 23);
		getContentPane().add(btnSalvar);
	}
	
	public static CadastroFornecedor getInstance() {
		if(instance == null) {
			instance = new CadastroFornecedor();
		}
		
		return instance;
	}
	
	public void setControl(TelaPrincipalControl controle) {
		this.controle = controle;
	}
	
	public void limpaCampos() {
		txtRazaoSocial.setText("");
		txtCnpj.setText("");
		chckbxAtivo.setSelected(false);
	}
	
	public void insereDados(ArrayList<String> dados) {
		txtRazaoSocial.setText(dados.get(0).substring(dados.get(0).indexOf("=") + 1).replace(".", ""));
		txtCnpj.setText(dados.get(1).substring(dados.get(1).indexOf("=") + 1));
		if(dados.get(3).substring(dados.get(3).indexOf("=") + 1).equals("true")) chckbxAtivo.setSelected(true);
		else chckbxAtivo.setSelected(false);
	}

}
