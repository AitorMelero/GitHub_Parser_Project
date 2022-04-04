package gpp.model.languageparser;

/**
 * 
 * Definición de acciones comunes para parsear bucles en cualquier lenguaje.
 * 
 * @author Aitor Melero
 *
 */
public interface IGeneralLanguageParserLoop {

	/**
	 * 
	 * Indica si el código hace uso de bucles for
	 * 
	 * @return True si se hace uso de for, false en caso contrario.
	 */
	boolean useFor();

	/**
	 * 
	 * Indica el número de bucles for usados.
	 * 
	 * @return Número de bucles for usados.
	 */
	int getNumberFor();

	/**
	 * 
	 * Indica si el código hace uso de bucles while.
	 * 
	 * @return True si el código hace uso de bucles while.
	 */
	boolean useWhile();

	/**
	 * 
	 * Indica el número de bucles while del código.
	 * 
	 * @return Número de bucles while del código.
	 */
	int getNumberWhile();

}
