package gpp.model.languageparser;

/**
 * 
 * Definici�n de acciones comunes para parsear cualquier lenguaje.
 * 
 * @author Aitor Melero
 *
 */
public interface IGeneralLanguageParser {

	/**
	 * 
	 * Indica si el c�digo hace uso de comentarios.
	 * 
	 * @return True si el c�digo hace uso de comentarios, false en caso contrario.
	 */
	boolean useComments();

	/**
	 * 
	 * Indica el n�mero de l�neas comentadas del c�digo.
	 * 
	 * @return N�mero de comentarios del c�digo.
	 */
	int getNumberComments();
	
	/**
	 * 
	 * Indica si el c�digo hace uso de imports.
	 * 
	 * @return True si el c�digo hace uso de imports, false en caso contrario.
	 */
	boolean useImports();

	/**
	 * 
	 * Indica el n�mero de importaciones.
	 * 
	 * @return N�mero de importaciones.
	 */
	int getNumberImports();

	/**
	 * 
	 * Indica si el c�digo hace uso de arrays.
	 * 
	 * @return True si el c�digo hace uso de arrays.
	 */
	boolean useArrays();

	/**
	 * 
	 * Indica el n�mero de veces que el c�digo hace uso de arrays.
	 * 
	 * @return N�mero de veces que el c�digo hace uso de arrays.
	 */
	int getNumberArrays();

}
