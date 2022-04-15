package gpp.view.component;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import gpp.model.Repository;

/**
 * 
 * Clase que implementa el diseño del contenedor de un repositorio.
 * 
 * @author Aitor Melero
 *
 */
public class VRepositoryContainer extends JPanel {
	
	private Repository repository;  // repositorio
	private JButton repositoryName;  // nombre del repositorio
	
	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */
	
	/**
	 * 
	 * Constructor.
	 * 
	 * @param repository. Repositorio.
	 */
	public VRepositoryContainer(Repository repository) {
		
		this.repository = repository;
		this.repositoryName = new JButton(repository.getOwnerName() + "/" + repository.getName());
		
		this.setBorder(BorderFactory.createLineBorder(VColor.getBLACK_MAIN()));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(repositoryName);
		
		
		
	}

}
