package gpp.view.window.search;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import gpp.view.component.VColor;
import gpp.view.component.VSearchParamLabel;
import gpp.view.component.VSearchTextField;

/**
 * 
 * Clase que implementa el diseño de los parámetros de una búsqueda de repositorios.
 * 
 * @author Aitor Melero
 *
 */
public class VQuery extends JPanel {
	
	JPanel ownerContainer;  // contenedor para autores
	VSearchParamLabel ownerLabel;  // etiqueta para autores
	VSearchTextField owner;  // campo de texto para autores
	JPanel inRepositoryNameContainer;  // contenedor para cadenas en el nombre del repositorio
	VSearchParamLabel inRepositoryNameLabel;  // etiqueta para cadenas en el nombre del repositorio
	VSearchTextField inRepositoryName;  // campo de texto para cadenas en el nombre del repositorio
	
	public VQuery() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(VColor.getWHITE_MAIN());
		
		ownerContainer = new JPanel();
		inRepositoryNameContainer = new JPanel();
		ownerLabel = new VSearchParamLabel("Propietarios del repositorio: ");
		owner = new VSearchTextField();
		ownerContainer.add(ownerLabel);
		ownerContainer.add(owner);
		inRepositoryNameLabel = new VSearchParamLabel("Palabras del nombre del repositorio: ");
		inRepositoryName = new VSearchTextField();
		inRepositoryNameContainer.add(inRepositoryNameLabel);
		inRepositoryNameContainer.add(inRepositoryName);
		this.add(ownerContainer);
		this.add(inRepositoryNameContainer);
		
	}

}
