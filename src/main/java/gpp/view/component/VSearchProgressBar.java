package gpp.view.component;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;

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

	/**
	 * 
	 * Constructor.
	 * 
	 * @param window.         Frame principal de la app.
	 * @param resultNumber.   Número total de resultados.
	 * @param progressNumber. Número mínimo de progreso.
	 */
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
		String[] op = { "Cancel" };
		container.setOptions(op);
		// Añadimos la barra de tareas
		progressBar.setValue(progressNumber);
		progressBar.setStringPainted(true);
		progressBar.setString(progressString);
		container.add(progressBar, 1);
		dialog = container.createDialog(window, "Realizando consulta");
		dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		dialog.setVisible(false);

	}

	/**
	 * 
	 * Devuelve el dialog.
	 * 
	 * @return Dialog.
	 */
	public JDialog getDialog() {
		return dialog;
	}

	/**
	 * 
	 * Devuelve el número de progreso.
	 * 
	 * @return Número de progreso.
	 */
	public int getProgressNumber() {
		return progressNumber;
	}

	/**
	 * 
	 * Indica si se debe mostrar el dialog.
	 * 
	 * @param showDialog. True si se muestra el dialog, false en caso contrario.
	 */
	public void showDialog(boolean showDialog) {

		dialog.setVisible(showDialog);

	}

	/**
	 * 
	 * Modifica todos los componentes en función del número de progreso.
	 * 
	 * @param progressNumber. Número de progreso.
	 */
	public void setProgressNumber(int progressNumber) {

		this.progressNumber = progressNumber;
		this.progressString = progressNumber + " de " + resultNumber;
		progressBar.setValue(progressNumber);
		progressBar.setString(progressString);

	}

}
