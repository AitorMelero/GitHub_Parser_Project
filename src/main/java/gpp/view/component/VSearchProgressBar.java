package gpp.view.component;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import gpp.view.VWindow;

/**
 * 
 * Clase que implementa el diseño de la barra de progreso de una consulta.
 * 
 * @author Aitor Melero.
 *
 */
public class VSearchProgressBar {

	private VWindow window; // ventana principal de la app
	private JOptionPane container; // contenedor
	private int resultNumber; // número total de resultados
	private int progressNumber; // número actual de progreso
	private String progressString; // cadena de progreso
	private JProgressBar progressBar; // barra de progreso
	private JDialog dialog; // dialogo

	public VSearchProgressBar(VWindow window, int resultNumber, int progressNumber) {

		// Inicializamos objetos
		this.window = window;
		this.container = new JOptionPane();
		this.resultNumber = resultNumber;
		this.progressNumber = progressNumber;
		this.progressString = progressNumber + " de " + resultNumber;
		this.progressBar = new JProgressBar(progressNumber, resultNumber);

		// Mostramos el panel
		container.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		container.setMessage("Analizando repositorios");
		// Añadimos la barra de tareas
		progressBar.setValue(progressNumber);
		progressBar.setStringPainted(true);
		progressBar.setString(progressString);
		container.add(progressBar, 1);
		dialog = container.createDialog(window, "Realizando consulta");
		dialog.setVisible(false);

	}

	/**
	 * @return the dialog
	 */
	public JDialog getDialog() {
		return dialog;
	}

	/**
	 * @return the progressNumber
	 */
	public int getProgressNumber() {
		return progressNumber;
	}

	public void showDialog(boolean showDialog) {

		dialog.setVisible(showDialog);

	}

	public void setProgressNumber(int progressNumber) {

		this.progressNumber = progressNumber;
		this.progressString = progressNumber + " de " + resultNumber;
		//container.setMessage(progressString);
		progressBar.setValue(progressNumber);
		progressBar.setString(progressString);

	}

}
