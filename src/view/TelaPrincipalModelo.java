package view;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaPrincipalModelo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalModelo window = new TelaPrincipalModelo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipalModelo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
			}
		});
		frame.setTitle("Sistema de Gerenciamento Comercial");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar");
		mnCliente.add(mntmCadastrarCliente);
		
		JMenuItem mntmAlterarDados = new JMenuItem("Alterar dados");
		mnCliente.add(mntmAlterarDados);
		
		JMenuItem mntmRemover = new JMenuItem("Remover");
		mnCliente.add(mntmRemover);
		
		JMenu mnFuncionrio = new JMenu("Funcion\u00E1rio");
		menuBar.add(mnFuncionrio);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mnFuncionrio.add(mntmCadastrar);
		
		JMenuItem mntmAlterarDados_1 = new JMenuItem("Alterar dados");
		mnFuncionrio.add(mntmAlterarDados_1);
		
		JMenuItem mntmPromover = new JMenuItem("Promover");
		mnFuncionrio.add(mntmPromover);
		
		JMenuItem mntmDesativar = new JMenuItem("Desativar");
		mnFuncionrio.add(mntmDesativar);
		
		JMenu mnFornecedores = new JMenu("Fornecedores");
		menuBar.add(mnFornecedores);
		
		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mnFornecedores.add(mntmCadastrar_1);
		
		JMenuItem mntmAlterarDados_2 = new JMenuItem("Alterar dados");
		mnFornecedores.add(mntmAlterarDados_2);
		
		JMenuItem mntmDesativar_1 = new JMenuItem("Desativar");
		mnFornecedores.add(mntmDesativar_1);
		
		JMenu mnProdutos = new JMenu("Produtos");
		menuBar.add(mnProdutos);
		
		JMenuItem mntmCadastrar_2 = new JMenuItem("Cadastrar");
		mnProdutos.add(mntmCadastrar_2);
		
		JMenuItem mntmRemover_1 = new JMenuItem("Remover");
		mnProdutos.add(mntmRemover_1);
		
		JMenuItem mntmSolicitar = new JMenuItem("Solicitar");
		mnProdutos.add(mntmSolicitar);
		
		JMenu mnEstoque = new JMenu("Estoque");
		menuBar.add(mnEstoque);
		
		JMenuItem mntmCadastrar_3 = new JMenuItem("Cadastrar");
		mnEstoque.add(mntmCadastrar_3);
		
		JMenuItem mntmAlterarEstoque = new JMenuItem("Alterar estoque");
		mnEstoque.add(mntmAlterarEstoque);
		
		frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
	}

}
