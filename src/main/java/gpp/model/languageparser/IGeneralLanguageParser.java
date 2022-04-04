package gpp.model.languageparser;

/**
 * 
 * Definición de acciones comunes para parsear cualquier lenguaje.
 * 
 * @author Aitor Melero
 *
 */
public interface IGeneralLanguageParser {

	/**
	 * 
	 * Indica si el código hace uso de comentarios.
	 * 
	 * @return True si el código hace uso de comentarios, false en caso contrario.
	 */
	boolean useComments();

	/**
	 * 
	 * Indica el número de líneas comentadas del código.
	 * 
	 * @return Número de comentarios del código.
	 */
	int getNumberComments();
	
	/**
	 * 
	 * Indica si el código hace uso de imports.
	 * 
	 * @return True si el código hace uso de imports, false en caso contrario.
	 */
	boolean useImports();

	/**
	 * 
	 * Indica el número de importaciones.
	 * 
	 * @return Número de importaciones.
	 */
	int getNumberImports();

	/**
	 * 
	 * Indica si el código hace uso de arrays.
	 * 
	 * @return True si el código hace uso de arrays.
	 */
	boolean useArrays();

	/**
	 * 
	 * Indica el número de veces que el código hace uso de arrays.
	 * 
	 * @return Número de veces que el código hace uso de arrays.
	 */
	int getNumberArrays();

}
