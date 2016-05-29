package view;

import java.util.ArrayList;
import control.TelaPrincipalControl;
import data.model.Cliente;
import view.models.CadastroBasicoPF;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroCliente extends CadastroBasicoPF {

	private static final long serialVersionUID = -8071117372959399379L;
	
	private static CadastroCliente instance = null;
	
	private TelaPrincipalControl controle;
	
	private CadastroCliente() {
		super();
		setBounds(100, 100, 452, 170);
		setTitle("Cadastro de Cliente");
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Cliente cliente = new Cliente();
				cliente.setCpf(txtCpf.getText());
				cliente.setNome(txtNome.getText());
				controle.salvaDadosCliente(cliente);
			}
		});
		btnSalvar.setBounds(214, 79, 89, 23);
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
		txtCpf.setText("");
	}
	
	public void insereDados(ArrayList<String> dados) {
		txtCpf.setText(dados.get(0).substring(dados.get(0).indexOf("=") + 1).replace(".", ""));
		txtNome.setText(dados.get(1).substring(dados.get(1).indexOf("=") + 1));
	}
}
