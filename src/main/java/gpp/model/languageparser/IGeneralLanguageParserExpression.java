package gpp.model.languageparser;

/**
 * 
 * Definici�n de acciones comunes para parsear expresiones en cualquier
 * lenguaje.
 * 
 * @author Aitor Melero
 *
 */
public interface IGeneralLanguageParserExpression {

	/**
	 * 
	 * Indica si el c�digo hace uso de expresiones lambda.
	 * 
	 * @return True si el c�digo hace uso de expresiones lambda.
	 */
	boolean useLambdas();

	/**
	 * 
	 * Indica el n�mero de veces que el c�digo hace uso de expresiones lambda.
	 * 
	 * @return N�mero de veces que el c�digo hace uso de expresiones lambda.
	 */
	int getNumberLambdas();

}
