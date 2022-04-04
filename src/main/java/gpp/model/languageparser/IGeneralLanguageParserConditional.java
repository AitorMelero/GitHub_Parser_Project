package gpp.model.languageparser;

/**
 * 
 * Definici�n de acciones comunes para parsear condicionales en cualquier
 * lenguaje.
 * 
 * @author Aitor Melero
 *
 */
public interface IGeneralLanguageParserConditional {

	/**
	 * 
	 * Indica si el c�digo hace uso de condicionales if
	 * 
	 * @return True si se hace uso de if, false en caso contrario
	 */
	boolean useIf();

	/**
	 * 
	 * Indica el n�mero de veces que se usa el condicional if en el c�digo.
	 * 
	 * @return N�mero de veces que se usa el if en el c�digo.
	 */
	int getNumberIf();

	/**
	 * 
	 * Indica el n�mero de veces que se usa else/else if en el c�digo.
	 * 
	 * @return N�mero de veces que se usa el else/else if en el c�digo.
	 */
	int getNumberElse();

	/**
	 * 
	 * Indica si el c�digo hace uso de else/else if
	 * 
	 * @return True si se hace uso de else/else if, false en caso contrario
	 */
	boolean useElse();

}
