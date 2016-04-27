package control;

import java.awt.EventQueue;

import view.*;

public class SGMMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.visualizar(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
