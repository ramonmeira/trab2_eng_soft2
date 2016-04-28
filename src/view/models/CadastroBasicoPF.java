package view.models;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.JFormattedTextField;

public class CadastroBasicoPF extends SingletonJInternalFrame {

	private static final long serialVersionUID = 2528457607303713404L;
	
	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	private JFormattedTextField dtNascimentoField;
	private JTextField txtCidade;
	private JTextField txtEndereco;
	private JTextField txtComplemento;
	private JFormattedTextField txtId;
	private JFormattedTextField txtRg;
	private JTextField txtExpedicao;
	private JFormattedTextField txtEmissao;
	private JTextField txtNacionalidade;
	private JTextField txtNaturalidade;
	private JFormattedTextField txtNumero;
	private JFormattedTextField txtTelResidencial;
	private JFormattedTextField txtTelCelular;
	private JTextField txtEmail;
	private JTextField textField;
	private JFormattedTextField txtCep;

	protected CadastroBasicoPF(){
		super();
		setBounds(100, 100, 711, 429);
		
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(100, 20, 39, 14);
		getContentPane().add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(20, 65, 28, 14);
		getContentPane().add(lblCpf);
		
		JLabel lblDataDeNascimento = new JLabel("Dt. Nascimento");
		lblDataDeNascimento.setBounds(20, 110, 100, 14);
		getContentPane().add(lblDataDeNascimento);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(591, 110, 46, 14);
		getContentPane().add(lblSexo);
		
		JLabel lblEndereo = new JLabel("Logradouro");
		lblEndereo.setBounds(149, 155, 65, 14);
		getContentPane().add(lblEndereo);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(20, 200, 75, 14);
		getContentPane().add(lblComplemento);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(290, 200, 46, 14);
		getContentPane().add(lblCidade);
		
		JLabel lblEstado = new JLabel("UF");
		lblEstado.setBounds(450, 110, 46, 14);
		getContentPane().add(lblEstado);
		
		txtNome = new JTextField();
		txtNome.setBounds(95, 35, 581, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JFormattedTextField();
		txtCpf.setBounds(20, 80, 150, 20);
		getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		
		dtNascimentoField = new JFormattedTextField();
		dtNascimentoField.setBounds(20, 125, 100, 20);
		getContentPane().add(dtNascimentoField);
		dtNascimentoField.setColumns(10);
		
		JComboBox cmbSexo = new JComboBox();
		cmbSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		cmbSexo.setBounds(591, 125, 85, 20);
		getContentPane().add(cmbSexo);
		
		JComboBox cmbUfNascimento = new JComboBox();
		cmbUfNascimento.setModel(new DefaultComboBoxModel(new String[] {"Acre", "Alagoas", "Amap\u00E1", "Bahia", "Cear\u00E1", "Distrito Federal", "Esp\u00EDrito Santo", "Goi\u00E1s", "Maranh\u00E3o", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Par\u00E1", "Para\u00EDba", "Paran\u00E1", "Pernambuco", "Piau\u00ED", "Rio Grande do Norte", "Rio Grande do Sul", "Rio de Janeiro", "Rond\u00F4nia", "Roraima", "Santa Catarina", "S\u00E3o Paulo", "Sergipe", "Tocantins"}));
		cmbUfNascimento.setBounds(450, 125, 131, 20);
		getContentPane().add(cmbUfNascimento);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(290, 215, 245, 20);
		getContentPane().add(txtCidade);
		txtCidade.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(149, 170, 452, 20);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(20, 215, 260, 20);
		getContentPane().add(txtComplemento);
		txtComplemento.setColumns(10);
		
		JLabel lblNacionalidade = new JLabel("Nacionalidade");
		lblNacionalidade.setBounds(130, 110, 75, 14);
		getContentPane().add(lblNacionalidade);
		
		JLabel lblNaturalidade = new JLabel("Naturalidade");
		lblNaturalidade.setBounds(290, 110, 65, 14);
		getContentPane().add(lblNaturalidade);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(180, 65, 18, 14);
		getContentPane().add(lblRg);
		
		JLabel lblExpedicao = new JLabel("Org. Expedidor");
		lblExpedicao.setBounds(340, 65, 85, 14);
		getContentPane().add(lblExpedicao);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(20, 20, 46, 14);
		getContentPane().add(lblId);
		
		txtId = new JFormattedTextField();
		txtId.setBounds(20, 35, 65, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtRg = new JFormattedTextField();
		txtRg.setBounds(180, 80, 150, 20);
		getContentPane().add(txtRg);
		txtRg.setColumns(10);
		
		txtExpedicao = new JTextField();
		txtExpedicao.setBounds(340, 80, 85, 20);
		getContentPane().add(txtExpedicao);
		txtExpedicao.setColumns(10);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(435, 65, 46, 14);
		getContentPane().add(lblUf);
		
		JComboBox cmbUfExpedissao = new JComboBox();
		cmbUfExpedissao.setModel(new DefaultComboBoxModel(new String[] {"Acre", "Alagoas", "Amap\u00E1", "Bahia", "Cear\u00E1", "Distrito Federal", "Esp\u00EDrito Santo", "Goi\u00E1s", "Maranh\u00E3o", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Par\u00E1", "Para\u00EDba", "Paran\u00E1", "Pernambuco", "Piau\u00ED", "Rio Grande do Norte", "Rio Grande do Sul", "Rio de Janeiro", "Rond\u00F4nia", "Roraima", "Santa Catarina", "S\u00E3o Paulo", "Sergipe", "Tocantins"}));
		cmbUfExpedissao.setBounds(435, 80, 131, 20);
		getContentPane().add(cmbUfExpedissao);
		
		JLabel lblDtEmissao = new JLabel("Dt. Emiss\u00E3o");
		lblDtEmissao.setBounds(576, 65, 61, 14);
		getContentPane().add(lblDtEmissao);
		
		txtEmissao = new JFormattedTextField();
		txtEmissao.setColumns(10);
		txtEmissao.setBounds(576, 80, 100, 20);
		getContentPane().add(txtEmissao);
		
		txtNacionalidade = new JTextField();
		txtNacionalidade.setBounds(130, 125, 150, 20);
		getContentPane().add(txtNacionalidade);
		txtNacionalidade.setColumns(10);
		
		txtNaturalidade = new JTextField();
		txtNaturalidade.setColumns(10);
		txtNaturalidade.setBounds(290, 125, 150, 20);
		getContentPane().add(txtNaturalidade);
		
		txtNumero = new JFormattedTextField();
		txtNumero.setText("Numero");
		txtNumero.setBounds(611, 170, 65, 20);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(611, 155, 46, 14);
		getContentPane().add(lblN);
		
		JLabel label = new JLabel("UF");
		label.setBounds(545, 200, 46, 14);
		getContentPane().add(label);
		
		JComboBox cmbUfEndereco = new JComboBox();
		cmbUfEndereco.setModel(new DefaultComboBoxModel(new String[] {"Acre", "Alagoas", "Amap\u00E1", "Bahia", "Cear\u00E1", "Distrito Federal", "Esp\u00EDrito Santo", "Goi\u00E1s", "Maranh\u00E3o", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Par\u00E1", "Para\u00EDba", "Paran\u00E1", "Pernambuco", "Piau\u00ED", "Rio Grande do Norte", "Rio Grande do Sul", "Rio de Janeiro", "Rond\u00F4nia", "Roraima", "Santa Catarina", "S\u00E3o Paulo", "Sergipe", "Tocantins"}));
		cmbUfEndereco.setBounds(545, 215, 131, 20);
		getContentPane().add(cmbUfEndereco);
		
		JLabel lblTelResidencial = new JLabel("Tel. Residencial");
		lblTelResidencial.setBounds(20, 245, 85, 14);
		getContentPane().add(lblTelResidencial);
		
		JLabel lblTelCelular = new JLabel("Tel. Celular");
		lblTelCelular.setBounds(130, 245, 75, 14);
		getContentPane().add(lblTelCelular);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(240, 245, 46, 14);
		getContentPane().add(lblEmail);
		
		txtTelResidencial = new JFormattedTextField();
		txtTelResidencial.setBounds(20, 260, 100, 20);
		getContentPane().add(txtTelResidencial);
		txtTelResidencial.setColumns(10);
		
		txtTelCelular = new JFormattedTextField();
		txtTelCelular.setColumns(10);
		txtTelCelular.setBounds(130, 260, 100, 20);
		getContentPane().add(txtTelCelular);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(240, 260, 214, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(464, 260, 212, 20);
		getContentPane().add(textField);
		
		JLabel lblEmailComercial = new JLabel("Email comercial");
		lblEmailComercial.setBounds(464, 245, 75, 14);
		getContentPane().add(lblEmailComercial);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(20, 365, 89, 23);
		getContentPane().add(btnCancelar);
		
		txtCep = new JFormattedTextField();
		txtCep.setBounds(20, 170, 119, 20);
		getContentPane().add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(20, 155, 46, 14);
		getContentPane().add(lblCep);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtId, txtNome, txtCpf, txtRg, txtExpedicao, cmbUfExpedissao, txtEmissao, dtNascimentoField, txtNacionalidade, txtNaturalidade, cmbUfNascimento, cmbSexo, txtCep, txtEndereco, txtNumero, txtComplemento, txtCidade, cmbUfEndereco, txtTelResidencial, txtTelCelular, txtEmail, textField, btnCancelar}));
	}
}
