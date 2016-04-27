package control;

import java.awt.EventQueue;

import view.TelaLogin;
import view.TelaPrincipal;

public class LoginControl {
	
	private TelaLogin telaLogin;
	
	public LoginControl(TelaLogin telaLogin) {
		this.telaLogin = telaLogin;		
	}
	
	public void iniciaTelaPrincipal() {
		telaLogin.visualizar(false);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.visualizar(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		telaLogin.visualizar(true);
	}
	
	public boolean usuarioValido() {
		return true;
	}

}
