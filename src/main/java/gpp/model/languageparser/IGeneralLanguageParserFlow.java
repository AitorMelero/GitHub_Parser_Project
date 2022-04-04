package gpp.model.languageparser;

/**
 * 
 * Definición de acciones comunes para parsear flujos en cualquier lenguaje.
 * 
 * @author Aitor Melero
 *
 */
public interface IGeneralLanguageParserFlow {

	/**
	 * 
	 * Indica si el código hace uso de continue.
	 * 
	 * @return True si el código hace uso de continue.
	 */
	boolean useContinue();

	/**
	 * 
	 * Indica el número de veces que se hace uso de continue.
	 * 
	 * @return Número de veces que se hace uso de continue en el código.
	 */
	int getNumberContinue();

	/**
	 * 
	 * Indica si el código hace uso de break.
	 * 
	 * @return True si el código hace uso de break, false en caso contrario.
	 */
	boolean useBreak();

	/**
	 * 
	 * Indica el número de breaks del código.
	 * 
	 * @return Número de breaks del código.
	 */
	int getNumberBreak();

}
