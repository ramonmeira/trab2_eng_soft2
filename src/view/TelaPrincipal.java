package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.TelaPrincipalControl;
import data.tools.FileOperations;

import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;

public class TelaPrincipal extends JFrame {
	private JMenuBar menuBar;
	private JMenu mnCliente;	
	private JMenuItem mntmCadastrarCliente;	
	private JMenuItem mntmAlterarDados;
	private JMenuItem mntmRemover;
	private JMenu mnFuncionrio;
	private JMenuItem mntmCadastrar;
	private JMenuItem mntmAlterarDados_1;
	private JMenuItem mntmPromover;
	private JMenuItem mntmDesativar;
	private JMenu mnFornecedores;
	private JMenuItem mntmCadastrar_1;
	private JMenuItem mntmAlterarDados_2;
	private JMenuItem mntmDesativar_1;
	private JMenu mnProdutos;
	private JMenuItem mntmCadastrar_2;
	private JMenuItem mntmRemover_1;
	private JMenuItem mntmSolicitar;
	private JMenu mnEstoque;
	private JMenuItem mntmCadastrar_3;
	private JMenuItem mntmAlterarEstoque;
	JDesktopPane desktop;
	
	TelaPrincipalControl controle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FileOperations.initializeFiles();
		System.out.println("SENHA=1".substring(6));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
			}
		});
		setTitle("Sistema de Gerenciamento Comercial");
		
		controle = new TelaPrincipalControl(this);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		mntmCadastrarCliente = new JMenuItem("Cadastrar");
		mntmCadastrarCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controle.abrePesquisaCliente(1);
			}
		});
		mntmCadastrarCliente.addMenuKeyListener(new MenuKeyListener() {
			public void menuKeyPressed(MenuKeyEvent e) {
				controle.abrePesquisaCliente(1);
			}
			public void menuKeyReleased(MenuKeyEvent e) {
			}
			public void menuKeyTyped(MenuKeyEvent e) {
			}
		});
		mnCliente.add(mntmCadastrarCliente);
		
		mntmAlterarDados = new JMenuItem("Alterar dados");
		mntmAlterarDados.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controle.abrePesquisaCliente(2);
			}
		});
		mnCliente.add(mntmAlterarDados);
		
		mntmRemover = new JMenuItem("Remover");
		mntmRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controle.abrePesquisaCliente(3);
			}
		});
		mnCliente.add(mntmRemover);
		
		mnFuncionrio = new JMenu("Funcion\u00E1rio");
		menuBar.add(mnFuncionrio);
		
		mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controle.abrePesquisaFuncionario(4);
			}
		});
		mnFuncionrio.add(mntmCadastrar);
		
		mntmAlterarDados_1 = new JMenuItem("Alterar dados");
		mntmAlterarDados_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controle.abrePesquisaFuncionario(5);
			}
		});
		mnFuncionrio.add(mntmAlterarDados_1);
		
		mntmPromover = new JMenuItem("Promover");
		mntmPromover.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controle.abrePesquisaFuncionario(6);
			}
		});
		mnFuncionrio.add(mntmPromover);
		
		mntmDesativar = new JMenuItem("Desativar");
		mntmDesativar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controle.abrePesquisaFuncionario(7);
			}
		});
		mnFuncionrio.add(mntmDesativar);
		
		mnFornecedores = new JMenu("Fornecedores");
		menuBar.add(mnFornecedores);
		
		mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mntmCadastrar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controle.abrePesquisaForncedor(8);
			}
		});
		mnFornecedores.add(mntmCadastrar_1);
		
		mntmAlterarDados_2 = new JMenuItem("Alterar dados");
		mntmAlterarDados_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controle.abrePesquisaForncedor(9);
			}
		});
		mnFornecedores.add(mntmAlterarDados_2);
		
		mntmDesativar_1 = new JMenuItem("Desativar");
		mntmDesativar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controle.abrePesquisaForncedor(10);
			}
		});
		mnFornecedores.add(mntmDesativar_1);
		
		mnProdutos = new JMenu("Produtos");
		menuBar.add(mnProdutos);
		
		mntmCadastrar_2 = new JMenuItem("Cadastrar");
		mntmCadastrar_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controle.abrePesquisaProduto(11);
			}
		});
		mnProdutos.add(mntmCadastrar_2);
		
		mntmRemover_1 = new JMenuItem("Remover");
		mntmRemover_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controle.abrePesquisaProduto(12);
			}
		});
		mnProdutos.add(mntmRemover_1);
		
		mntmSolicitar = new JMenuItem("Solicitar");
		mntmSolicitar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controle.abrePesquisaProduto(13);
			}
		});
		mnProdutos.add(mntmSolicitar);
		
		mnEstoque = new JMenu("Estoque");
		menuBar.add(mnEstoque);
		
		mntmCadastrar_3 = new JMenuItem("Cadastrar");
		mntmCadastrar_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				controle.cadastraEstoque();
			}
		});
		mnEstoque.add(mntmCadastrar_3);
		
		mntmAlterarEstoque = new JMenuItem("Alterar estoque");
		mntmAlterarEstoque.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controle.alterarEstoque();
			}
		});
		mnEstoque.add(mntmAlterarEstoque);
		
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		//getContentPane().setLayout(null);
		
		desktop = new JDesktopPane();
		getContentPane().add(desktop, BorderLayout.CENTER);
		//desktop.setBounds(0, 241, 434, -239);
		//getContentPane().add(desktop);
		ativarMenus(false);
		controle.abreTelaLogin();
	}
	
	public void addInternalFrame(JInternalFrame internalFrame) {
		if(!internalFrame.isVisible()) {
			desktop.remove(internalFrame);
			desktop.add(internalFrame);
		}
	}
	
	public void ativarMenus(boolean ativar) {
		menuBar.setEnabled(ativar);
		mnCliente.setEnabled(ativar);	
		mntmCadastrarCliente.setEnabled(ativar);	
		mntmAlterarDados.setEnabled(ativar);
		mntmRemover.setEnabled(ativar);
		mnFuncionrio.setEnabled(ativar);
		mntmCadastrar.setEnabled(ativar);
		mntmAlterarDados_1.setEnabled(ativar);
		mntmPromover.setEnabled(ativar);
		mntmDesativar.setEnabled(ativar);
		mnFornecedores.setEnabled(ativar);
		mntmCadastrar_1.setEnabled(ativar);
		mntmAlterarDados_2.setEnabled(ativar);
		mntmDesativar_1.setEnabled(ativar);
		mnProdutos.setEnabled(ativar);
		mntmCadastrar_2.setEnabled(ativar);
		mntmRemover_1.setEnabled(ativar);
		mntmSolicitar.setEnabled(ativar);
		mnEstoque.setEnabled(ativar);
		mntmCadastrar_3.setEnabled(ativar);
		mntmAlterarEstoque.setEnabled(ativar);
	}
}
