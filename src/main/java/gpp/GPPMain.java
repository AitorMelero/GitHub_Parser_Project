package gpp;

import java.awt.EventQueue;

import gpp.controller.window.login.CLogin;
import gpp.model.github.api.caller.GitHubAPICaller;
import gpp.model.search.Search;
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
				
				// PRUEBAS -> BORRAR
				Search s = new Search("Búsqueda prueba");
				s.getQuery().setOwner("AitorMelero");
				s.getQuery().setInRepositoryName("");
				s.getQuery().generateQueryPath();
				//System.out.println("RESULTADO: " + GitHubAPICaller.searchRepositories("", s.getQuery().getPath(), "best-match", "desc", 1, 1));
				
			}
			
		});
		
	}

}
