package gpp.model.languageparser.java;

/**
 * 
 * Definici�n de acciones comunes para parsear m�todos y variables en Java.
 * 
 * @author Aitor Melero
 *
 */
public interface IJavaLanguageParser {

	/**
	 * 
	 * Indica el n�mero de m�todos del c�digo.
	 * 
	 * @return N�mero de m�todos del c�digo.
	 */
	int getNumberMethods();

	/**
	 * 
	 * Indica el n�mero de variables del c�digo.
	 * 
	 * @return N�mero de variables del c�digo.
	 */
	int getNumberVariables();

	/**
	 * 
	 * Indica el n�mero de variables locales de m�todos del c�digo.
	 * 
	 * @return N�mero de variables locales de m�todos del c�digo.
	 */
	int getNumberLocalVariables();

	/**
	 * 
	 * Indica si el c�digo hace uso de static.
	 * 
	 * @return True si el c�digo hace uso de static, false en caso contrario.
	 */
	boolean useStatic();

	/**
	 * 
	 * Indica el n�mero de static del c�digo.
	 * 
	 * @return N�mero de static del c�digo.
	 */
	int getNumberStatic();

	/**
	 * 
	 * Indica si el c�digo hace uso de public.
	 * 
	 * @return True si el c�digo hace uso de public, false en caso contrario.
	 */
	boolean usePublic();

	/**
	 * 
	 * Indica el n�mero de public del c�digo.
	 * 
	 * @return N�mero de public del c�digo.
	 */
	int getNumberPublic();

	/**
	 * 
	 * Indica si el c�digo hace uso de private.
	 * 
	 * @return True si el c�digo hace uso de private, false en caso contrario.
	 */
	boolean usePrivate();

	/**
	 * 
	 * Indica el n�mero de private del c�digo.
	 * 
	 * @return N�mero de private del c�digo.
	 */
	int getNumberPrivate();

	/**
	 * 
	 * Indica si el c�digo hace uso de protected.
	 * 
	 * @return True si el c�digo hace uso de protected, false en caso contrario.
	 */
	boolean useProtected();

	/**
	 * 
	 * Indica el n�mero de protected del c�digo.
	 * 
	 * @return N�mero de protected del c�digo.
	 */
	int getNumberProtected();

	/**
	 * 
	 * Indica si el c�digo hace uso de abstract.
	 * 
	 * @return True si el c�digo hace uso de abstract, false en caso contrario.
	 */
	boolean useAbstract();

	/**
	 * 
	 * Indica el n�mero de abstract del c�digo.
	 * 
	 * @return N�mero de abstract del c�digo.
	 */
	int getNumberAbstract();

	/**
	 * 
	 * Indica el n�mero de clases del c�digo.
	 * 
	 * @return N�mero de clases del c�digo.
	 */
	int getNumberClasses();

	/**
	 * 
	 * Indica si el c�digo hace uso de yield.
	 * 
	 * @return True si el c�digo hace uso de yield, false en caso contrario.
	 */
	boolean useYield();

	/**
	 * 
	 * Indica el n�mero de yield del c�digo.
	 * 
	 * @return N�mero de yield del c�digo.
	 */
	int getNumberYield();

	/**
	 * 
	 * Indica si el c�digo hace uso de assert.
	 * 
	 * @return True si el c�digo hace uso de assert, false en caso contrario.
	 */
	boolean useAssert();

	/**
	 * 
	 * Indica el n�mero de assert del c�digo.
	 * 
	 * @return N�mero de assert del c�digo.
	 */
	int getNumberAssert();

	/**
	 * 
	 * Indica si el c�digo hace uso de try.
	 * 
	 * @return True si el c�digo hace uso de try, false en caso contrario.
	 */
	boolean useTry();

	/**
	 * 
	 * Indica el n�mero de try del c�digo.
	 * 
	 * @return N�mero de try del c�digo.
	 */
	int getNumberTry();

	/**
	 * 
	 * Indica si el c�digo hace uso de annotations.
	 * 
	 * @return True si el c�digo hace uso de annotations, false en caso contrario.
	 */
	boolean useAnnotations();

	/**
	 * 
	 * Indica el n�mero de annotations del c�digo.
	 * 
	 * @return N�mero de annotations del c�digo.
	 */
	int getNumberAnnotations();

	/**
	 * 
	 * Indica si el c�digo hace uso de constructores implementados en el c�digo.
	 * 
	 * @return True si el c�digo hace uso de constructores implementados en el
	 *         c�digo, false en caso contrario.
	 */
	boolean usePersonalConstructors();

	/**
	 * 
	 * Indica el n�mero de constructores implementados en el c�digo.
	 * 
	 * @return N�mero de constructores implementados en el c�digo.
	 */
	int getNumberPersonalConstructors();

	/**
	 * 
	 * Indica si el c�digo hace uso de interfaces propias del desarrollador.
	 * 
	 * @return True si el c�digo hace uso de interfaces propias del desarrollador,
	 *         false en caso contrario.
	 */
	boolean usePersonalInterfaces();

	/**
	 * 
	 * Indica el n�mero de interfaces desarrolladas en el c�digo.
	 * 
	 * @return N�mero de interfaces desarrolladas en el c�digo.
	 */
	int getNumberPersonalInterfaces();

	/**
	 * 
	 * Indica si el c�digo hace uso de interfaces, es decir, implementa interfaces.
	 * 
	 * @return True si el c�digo hace uso de interfaces, false en caso contrario.
	 */
	boolean useImplements();

	/**
	 * 
	 * Indica el n�mero de veces que hace uso de implements en el c�digo.
	 * 
	 * @return N�mero de veces que se hace uso de implements en el c�digo.
	 */
	int getNumberImplements();

	/**
	 * 
	 * Indica si el c�digo hace uso de extends.
	 * 
	 * @return True si el c�digo hace uso de extends, false en caso contrario.
	 */
	boolean useExtends();

	/**
	 * 
	 * Indica el n�mero de extends del c�digo.
	 * 
	 * @return N�mero de extends del c�digo.
	 */
	int getNumberExtends();

	/**
	 * 
	 * Indica si el c�digo hace uso de throws.
	 * 
	 * @return True si el c�digo hace uso de throws, false en caso contrario.
	 */
	boolean useThrows();

	/**
	 * 
	 * Indica el n�mero de throws del c�digo.
	 * 
	 * @return N�mero de throws del c�digo.
	 */
	int getNumberThrows();

	/**
	 * 
	 * Indica si el c�digo hace uso de throw.
	 * 
	 * @return True si el c�digo hace uso de throw, false en caso contrario.
	 */
	boolean useThrow();

	/**
	 * 
	 * Indica el n�mero de throw del c�digo.
	 * 
	 * @return N�mero de throw del c�digo.
	 */
	int getNumberThrow();

	/**
	 * 
	 * Indica si el c�digo hace uso de enum.
	 * 
	 * @return True si el c�digo hace uso de enum, false en caso contrario.
	 */
	boolean useEnum();

	/**
	 * 
	 * Indica el n�mero de enum del c�digo.
	 * 
	 * @return N�mero de enum del c�digo.
	 */
	int getNumberEnum();

	/**
	 * 
	 * Indica si el c�digo hace uso de final.
	 * 
	 * @return True si el c�digo hace uso de final, false en caso contrario.
	 */
	boolean useFinal();

	/**
	 * 
	 * Indica el n�mero de final del c�digo.
	 * 
	 * @return N�mero de final del c�digo.
	 */
	int getNumberFinal();

	/**
	 * 
	 * Indica si el c�digo hace uso de switch.
	 * 
	 * @return True si el c�digo hace uso de switch, false en caso contrario.
	 */
	boolean useSwitch();

	/**
	 * 
	 * Indica el n�mero de switch del c�digo.
	 * 
	 * @return N�mero de switch del c�digo.
	 */
	int getNumberSwitch();

	/**
	 * 
	 * Indica si el c�digo hace uso de instanceof.
	 * 
	 * @return True si el c�digo hace uso de instanceof, false en caso contrario.
	 */
	boolean useInstanceOf();

	/**
	 * 
	 * Indica el n�mero de instanceof del c�digo.
	 * 
	 * @return N�mero de instanceof del c�digo.
	 */
	int getNumberInstanceOf();

	/**
	 * 
	 * Indica si el c�digo hace uso de synchronized.
	 * 
	 * @return True si el c�digo hace uso de synchronized, false en caso contrario.
	 */
	boolean useSynchronized();

	/**
	 * 
	 * Indica el n�mero de synchronized del c�digo.
	 * 
	 * @return N�mero de synchronized del c�digo.
	 */
	int getNumberSynchronized();

}
