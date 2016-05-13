package view;

import java.util.ArrayList;
import view.models.CadastroBasicoPF;
import javax.swing.JLabel;
import javax.swing.JTextField;
import control.TelaPrincipalControl;
import data.model.Funcionario;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroFuncionario extends CadastroBasicoPF {
	private static final long serialVersionUID = 3502310070202990472L;
	private static CadastroFuncionario instance = null;
	private TelaPrincipalControl controle;
	private JTextField txtLogin;
	private JPasswordField pwdSenha;
	private JLabel lblSenha;
	private JCheckBox chckbxGerente;
	private JButton btnCadastrar;
	private JButton btnSalvaer;
	private JCheckBox chckbxAtivo;

	public CadastroFuncionario() {
		super();
		setBounds(100, 100, 486, 256);
		txtCpf.setLocation(20, 90);
		txtNome.setBounds(20, 34, 421, 20);
		setTitle("Cadastro de Funcion\u00E1rio");
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(180, 65, 46, 14);
		lblLogin.setSize(lblLogin.getPreferredSize());
		getContentPane().add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(180, 90, 261, 20);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(180, 121, 46, 14);
		lblSenha.setSize(lblSenha.getPreferredSize());
		getContentPane().add(lblSenha);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setBounds(180, 146, 261, 20);
		getContentPane().add(pwdSenha);
		
		chckbxGerente = new JCheckBox("Gerente");
		chckbxGerente.setBounds(20, 117, 65, 23);
		chckbxGerente.setSize(chckbxGerente.getPreferredSize());
		getContentPane().add(chckbxGerente);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(130, 365, 89, 23);
		getContentPane().add(btnCadastrar);
		
		btnSalvaer = new JButton("Salvar");
		btnSalvaer.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Funcionario funcionario = new Funcionario();
				funcionario.setCpf(txtCpf.getText());
				funcionario.setNome(txtNome.getText());
				funcionario.setLogin(txtLogin.getText());
				funcionario.setSenha(new String(pwdSenha.getPassword()));
				funcionario.setGerente(String.valueOf(chckbxGerente.isSelected()));
				funcionario.setAtivo(String.valueOf(chckbxAtivo.isSelected()));
				controle.salvaDadosFuncionarios(funcionario);
			}
		});
		btnSalvaer.setBounds(20, 189, 89, 23);
		getContentPane().add(btnSalvaer);
		
		chckbxAtivo = new JCheckBox("Ativo");
		chckbxAtivo.setBounds(20, 145, 97, 23);
		getContentPane().add(chckbxAtivo);
	}
	
	public static CadastroFuncionario getInstance() {
		if(instance == null) {
			instance = new CadastroFuncionario();
		}
		
		return instance;
	}
	
	public void setControl(TelaPrincipalControl controle) {
		this.controle = controle;
	}
	
	public void limpaCampos() {
		txtNome.setText("");
		txtCpf.setText("");
		txtLogin.setText("");
		pwdSenha.setText("");
		chckbxGerente.setSelected(false);
	}
	
	public void insereDados(ArrayList<String> dados) {
		txtCpf.setText(dados.get(0).substring(dados.get(0).indexOf("=") + 1).replace(".", ""));
		txtNome.setText(dados.get(1).substring(dados.get(1).indexOf("=") + 1));
		txtLogin.setText(dados.get(2).substring(dados.get(2).indexOf("=") + 1));
		pwdSenha.setText(dados.get(3).substring(dados.get(3).indexOf("=") + 1));
//		chckbxGerente.setSelected(Boolean.getBoolean(dados.get(4).substring(dados.get(4).indexOf("=") + 1)));
//		chckbxAtivo.setSelected(Boolean.getBoolean(dados.get(5).substring(dados.get(5).indexOf("=") + 1)));
		if(dados.get(4).substring(dados.get(4).indexOf("=") + 1).equals("true")) chckbxGerente.setSelected(true);
		else chckbxGerente.setSelected(false);
		if(dados.get(5).substring(dados.get(5).indexOf("=") + 1).equals("true")) chckbxAtivo.setSelected(true);
		else chckbxAtivo.setSelected(false);
	}
}
