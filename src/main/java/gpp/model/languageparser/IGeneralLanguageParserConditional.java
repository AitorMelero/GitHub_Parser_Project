package gpp.model.languageparser;

/**
 * 
 * Definición de acciones comunes para parsear condicionales en cualquier
 * lenguaje.
 * 
 * @author Aitor Melero
 *
 */
public interface IGeneralLanguageParserConditional {

	/**
	 * 
	 * Indica si el código hace uso de condicionales if
	 * 
	 * @return True si se hace uso de if, false en caso contrario
	 */
	boolean useIf();

	/**
	 * 
	 * Indica el número de veces que se usa el condicional if en el código.
	 * 
	 * @return Número de veces que se usa el if en el código.
	 */
	int getNumberIf();

	/**
	 * 
	 * Indica el número de veces que se usa else/else if en el código.
	 * 
	 * @return Número de veces que se usa el else/else if en el código.
	 */
	int getNumberElse();

	/**
	 * 
	 * Indica si el código hace uso de else/else if
	 * 
	 * @return True si se hace uso de else/else if, false en caso contrario
	 */
	boolean useElse();

}
