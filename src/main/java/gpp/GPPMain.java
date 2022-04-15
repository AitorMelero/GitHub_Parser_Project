package gpp;

import java.awt.EventQueue;

import gpp.controller.component.CLeftMenu;
import gpp.controller.window.login.CLogin;
import gpp.controller.window.search.CSearch;
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
				CSearch cSearch;
				CLeftMenu cLeftMenu;

				// Inicializamos componentes
				gppSystem = GPPSystem.getInstance();
				cLogin = new CLogin(gppSystem, windows);
				cSearch = new CSearch(gppSystem, windows);
				cLeftMenu = new CLeftMenu(gppSystem, windows);

				// Asociamos controladores a las vistas
				windows.getLoginView().setControllers(cLogin);
				windows.getSearchView().setControllers(cSearch);
				windows.getMenu().setControllers(cLeftMenu);

			}

		});

	}

}
