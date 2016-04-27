package view.models;

import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Rectangle;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class CadastroBasicoPF extends SingletonJInternalFrame {

	private static final long serialVersionUID = 2528457607303713404L;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField dtNascimentoField;
	private JTextField txtCidade;
	private JTextField txtEndereco;
	private JTextField txtComplemento;
	private JTextField txtId;
	private JTextField txtRg;
	private JTextField txtExpedicao;
	private JTextField txtEmissao;
	private JTextField txtNacionalidade;
	private JTextField txtNaturalidade;
	private JTextField txtNumero;
	private JTextField txtTelResidencial;
	private JTextField txtTelCelular;
	private JTextField txtEmail;
	private JTextField textField;

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
		lblEndereo.setBounds(20, 155, 65, 14);
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
		
		txtCpf = new JTextField();
		txtCpf.setBounds(20, 80, 150, 20);
		getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		
		dtNascimentoField = new JTextField();
		dtNascimentoField.setBounds(20, 125, 100, 20);
		getContentPane().add(dtNascimentoField);
		dtNascimentoField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		comboBox.setBounds(591, 125, 85, 20);
		getContentPane().add(comboBox);
		
		JComboBox cmbBoxEstado = new JComboBox();
		cmbBoxEstado.setModel(new DefaultComboBoxModel(new String[] {"Acre", "Alagoas", "Amap\u00E1", "Bahia", "Cear\u00E1", "Distrito Federal", "Esp\u00EDrito Santo", "Goi\u00E1s", "Maranh\u00E3o", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Par\u00E1", "Para\u00EDba", "Paran\u00E1", "Pernambuco", "Piau\u00ED", "Rio Grande do Norte", "Rio Grande do Sul", "Rio de Janeiro", "Rond\u00F4nia", "Roraima", "Santa Catarina", "S\u00E3o Paulo", "Sergipe", "Tocantins"}));
		cmbBoxEstado.setBounds(450, 125, 131, 20);
		getContentPane().add(cmbBoxEstado);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(290, 215, 245, 20);
		getContentPane().add(txtCidade);
		txtCidade.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(20, 170, 581, 20);
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
		
		txtId = new JTextField();
		txtId.setBounds(20, 35, 65, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtRg = new JTextField();
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
		
		JComboBox cmbUf = new JComboBox();
		cmbUf.setModel(new DefaultComboBoxModel(new String[] {"Acre", "Alagoas", "Amap\u00E1", "Bahia", "Cear\u00E1", "Distrito Federal", "Esp\u00EDrito Santo", "Goi\u00E1s", "Maranh\u00E3o", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Par\u00E1", "Para\u00EDba", "Paran\u00E1", "Pernambuco", "Piau\u00ED", "Rio Grande do Norte", "Rio Grande do Sul", "Rio de Janeiro", "Rond\u00F4nia", "Roraima", "Santa Catarina", "S\u00E3o Paulo", "Sergipe", "Tocantins"}));
		cmbUf.setBounds(435, 80, 131, 20);
		getContentPane().add(cmbUf);
		
		JLabel lblEmisso = new JLabel("Emiss\u00E3o");
		lblEmisso.setBounds(576, 65, 46, 14);
		getContentPane().add(lblEmisso);
		
		txtEmissao = new JTextField();
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
		
		txtNumero = new JTextField();
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
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Acre", "Alagoas", "Amap\u00E1", "Bahia", "Cear\u00E1", "Distrito Federal", "Esp\u00EDrito Santo", "Goi\u00E1s", "Maranh\u00E3o", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Par\u00E1", "Para\u00EDba", "Paran\u00E1", "Pernambuco", "Piau\u00ED", "Rio Grande do Norte", "Rio Grande do Sul", "Rio de Janeiro", "Rond\u00F4nia", "Roraima", "Santa Catarina", "S\u00E3o Paulo", "Sergipe", "Tocantins"}));
		comboBox_1.setBounds(545, 215, 131, 20);
		getContentPane().add(comboBox_1);
		
		JLabel lblTelResidencial = new JLabel("Tel. Residencial");
		lblTelResidencial.setBounds(20, 245, 85, 14);
		getContentPane().add(lblTelResidencial);
		
		JLabel lblTelCelular = new JLabel("Tel. Celular");
		lblTelCelular.setBounds(130, 245, 75, 14);
		getContentPane().add(lblTelCelular);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(240, 245, 46, 14);
		getContentPane().add(lblEmail);
		
		txtTelResidencial = new JTextField();
		txtTelResidencial.setBounds(20, 260, 100, 20);
		getContentPane().add(txtTelResidencial);
		txtTelResidencial.setColumns(10);
		
		txtTelCelular = new JTextField();
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
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblId, txtId, lblNome, txtNome, lblCpf, txtCpf, lblRg, txtRg, lblExpedicao, txtExpedicao, lblUf, cmbUf, lblEmisso, txtEmissao, lblDataDeNascimento, dtNascimentoField, lblNacionalidade, txtNacionalidade, lblNaturalidade, txtNaturalidade, lblEstado, cmbBoxEstado, lblSexo, comboBox, lblEndereo, txtEndereco, lblN, txtNumero, lblComplemento, txtComplemento, lblCidade, txtCidade, label, comboBox_1, lblTelResidencial, txtTelResidencial, lblTelCelular, txtTelCelular, lblEmail, txtEmail, lblEmailComercial, textField, btnCancelar}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblId, txtId, lblNome, txtNome, lblCpf, txtCpf, lblRg, txtRg, lblExpedicao, txtExpedicao, lblUf, cmbUf, lblEmisso, txtEmissao, lblDataDeNascimento, dtNascimentoField, lblNacionalidade, txtNacionalidade, lblNaturalidade, txtNaturalidade, lblEstado, cmbBoxEstado, lblSexo, comboBox, lblEndereo, txtEndereco, lblN, txtNumero, lblComplemento, txtComplemento, lblCidade, txtCidade, label, comboBox_1, lblTelResidencial, txtTelResidencial, lblTelCelular, txtTelCelular, lblEmail, txtEmail, lblEmailComercial, textField, btnCancelar, getContentPane()}));
	}
}
