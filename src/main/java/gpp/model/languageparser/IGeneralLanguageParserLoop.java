package gpp.model.languageparser;

/**
 * 
 * Definici�n de acciones comunes para parsear bucles en cualquier lenguaje.
 * 
 * @author Aitor Melero
 *
 */
public interface IGeneralLanguageParserLoop {

	/**
	 * 
	 * Indica si el c�digo hace uso de bucles for
	 * 
	 * @return True si se hace uso de for, false en caso contrario.
	 */
	boolean useFor();

	/**
	 * 
	 * Indica el n�mero de bucles for usados.
	 * 
	 * @return N�mero de bucles for usados.
	 */
	int getNumberFor();

	/**
	 * 
	 * Indica si el c�digo hace uso de bucles while.
	 * 
	 * @return True si el c�digo hace uso de bucles while.
	 */
	boolean useWhile();

	/**
	 * 
	 * Indica el n�mero de bucles while del c�digo.
	 * 
	 * @return N�mero de bucles while del c�digo.
	 */
	int getNumberWhile();

}
