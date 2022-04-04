package gpp.model.languageparser;

/**
 * 
 * Definici�n de acciones comunes para parsear flujos en cualquier lenguaje.
 * 
 * @author Aitor Melero
 *
 */
public interface IGeneralLanguageParserFlow {

	/**
	 * 
	 * Indica si el c�digo hace uso de continue.
	 * 
	 * @return True si el c�digo hace uso de continue.
	 */
	boolean useContinue();

	/**
	 * 
	 * Indica el n�mero de veces que se hace uso de continue.
	 * 
	 * @return N�mero de veces que se hace uso de continue en el c�digo.
	 */
	int getNumberContinue();

	/**
	 * 
	 * Indica si el c�digo hace uso de break.
	 * 
	 * @return True si el c�digo hace uso de break, false en caso contrario.
	 */
	boolean useBreak();

	/**
	 * 
	 * Indica el n�mero de breaks del c�digo.
	 * 
	 * @return N�mero de breaks del c�digo.
	 */
	int getNumberBreak();

}
