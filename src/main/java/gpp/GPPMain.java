package gpp;

import java.awt.EventQueue;

import gpp.constant.GPPConstant;
import gpp.controller.component.CLeftMenu;
import gpp.controller.component.CRepository;
import gpp.controller.component.CRepositoryContainer;
import gpp.controller.window.login.CLogin;
import gpp.controller.window.search.CSearch;
import gpp.controller.window.search.CSearchResult;
import gpp.view.VWindow;
import gpp.view.component.VColor;

public class GPPMain {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {

				// Variables generales necesarias
				GPPSystem.setGlobalSemaphoreTasks(false);
				GPPSystem.setMenuButtonSelected(GPPSystem.BUSCAR);
				GPPSystem.setSearchButtonSelected(GPPSystem.BUSCAR_REPO);

				// Declaramos instancias
				VWindow windows = new VWindow();
				GPPConstant.window = windows;
				GPPSystem gppSystem;
				CLogin cLogin;
				CSearch cSearch;
				CSearchResult cSearchResult;
				CLeftMenu cLeftMenu;
				CRepositoryContainer cRepositoryContainer;
				CRepository cRepository;

				// Inicializamos componentes
				gppSystem = GPPSystem.getInstance();
				cLogin = new CLogin(gppSystem, windows);
				cSearch = new CSearch(gppSystem, windows);
				cSearchResult = new CSearchResult(gppSystem, windows);
				cLeftMenu = new CLeftMenu(gppSystem, windows);
				cRepositoryContainer = new CRepositoryContainer(gppSystem, windows);
				cRepository = new CRepository(gppSystem, windows);

				// Asociamos controladores a las vistas
				windows.getLoginView().setControllers(cLogin);
				windows.getSearchView().setControllers(cSearch);
				windows.getSearchResultView().setControllers(cSearchResult);
				windows.getMenu().setControllers(cLeftMenu);
				windows.getSearchResultView().setResultContainerRepositoryListener(cRepositoryContainer);
				windows.getRepositoryView().setControllers(cRepository);

				// Colores de botones
				windows.getMenu().getSearchButton().setBackground(VColor.getGRAY_FOCUS_MENU());
				windows.getSearchView().getQueryWindowButton().setBackground(VColor.getGRAY_FOCUS_MENU());

			}

		});

	}

}
