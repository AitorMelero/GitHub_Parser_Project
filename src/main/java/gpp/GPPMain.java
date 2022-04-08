package gpp;

import java.awt.EventQueue;

import gpp.controller.window.login.CLogin;
import gpp.view.VWindow;

public class GPPMain {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {

				// Declaramos instancias
				VWindow windows = new VWindow();
				GPPSystem gppSystem;
				CLogin cLogin;
				
				// Inicializamos componentes
				gppSystem = GPPSystem.getInstance();
				cLogin = new CLogin(gppSystem, windows);
				
				// Asociamos controladores a las vistas
				windows.getLoginView().setControllers(cLogin);
				
			}
			
		});
		
	}

}
