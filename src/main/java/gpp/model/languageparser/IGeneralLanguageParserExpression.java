package gpp.model.languageparser;

/**
 * 
 * Definición de acciones comunes para parsear expresiones en cualquier
 * lenguaje.
 * 
 * @author Aitor Melero
 *
 */
public interface IGeneralLanguageParserExpression {

	/**
	 * 
	 * Indica si el código hace uso de expresiones lambda.
	 * 
	 * @return True si el código hace uso de expresiones lambda.
	 */
	boolean useLambdas();

	/**
	 * 
	 * Indica el número de veces que el código hace uso de expresiones lambda.
	 * 
	 * @return Número de veces que el código hace uso de expresiones lambda.
	 */
	int getNumberLambdas();

}
