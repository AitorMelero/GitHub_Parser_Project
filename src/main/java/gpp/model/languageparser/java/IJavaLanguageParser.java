package gpp.model.languageparser.java;

/**
 * 
 * Definición de acciones comunes para parsear métodos y variables en Java.
 * 
 * @author Aitor Melero
 *
 */
public interface IJavaLanguageParser {

	/**
	 * 
	 * Indica el número de métodos del código.
	 * 
	 * @return Número de métodos del código.
	 */
	int getNumberMethods();

	/**
	 * 
	 * Indica el número de variables del código.
	 * 
	 * @return Número de variables del código.
	 */
	int getNumberVariables();

	/**
	 * 
	 * Indica el número de variables locales de métodos del código.
	 * 
	 * @return Número de variables locales de métodos del código.
	 */
	int getNumberLocalVariables();

	/**
	 * 
	 * Indica si el código hace uso de static.
	 * 
	 * @return True si el código hace uso de static, false en caso contrario.
	 */
	boolean useStatic();

	/**
	 * 
	 * Indica el número de static del código.
	 * 
	 * @return Número de static del código.
	 */
	int getNumberStatic();

	/**
	 * 
	 * Indica si el código hace uso de public.
	 * 
	 * @return True si el código hace uso de public, false en caso contrario.
	 */
	boolean usePublic();

	/**
	 * 
	 * Indica el número de public del código.
	 * 
	 * @return Número de public del código.
	 */
	int getNumberPublic();

	/**
	 * 
	 * Indica si el código hace uso de private.
	 * 
	 * @return True si el código hace uso de private, false en caso contrario.
	 */
	boolean usePrivate();

	/**
	 * 
	 * Indica el número de private del código.
	 * 
	 * @return Número de private del código.
	 */
	int getNumberPrivate();

	/**
	 * 
	 * Indica si el código hace uso de protected.
	 * 
	 * @return True si el código hace uso de protected, false en caso contrario.
	 */
	boolean useProtected();

	/**
	 * 
	 * Indica el número de protected del código.
	 * 
	 * @return Número de protected del código.
	 */
	int getNumberProtected();

	/**
	 * 
	 * Indica si el código hace uso de abstract.
	 * 
	 * @return True si el código hace uso de abstract, false en caso contrario.
	 */
	boolean useAbstract();

	/**
	 * 
	 * Indica el número de abstract del código.
	 * 
	 * @return Número de abstract del código.
	 */
	int getNumberAbstract();

	/**
	 * 
	 * Indica el número de clases del código.
	 * 
	 * @return Número de clases del código.
	 */
	int getNumberClasses();

	/**
	 * 
	 * Indica si el código hace uso de yield.
	 * 
	 * @return True si el código hace uso de yield, false en caso contrario.
	 */
	boolean useYield();

	/**
	 * 
	 * Indica el número de yield del código.
	 * 
	 * @return Número de yield del código.
	 */
	int getNumberYield();

	/**
	 * 
	 * Indica si el código hace uso de assert.
	 * 
	 * @return True si el código hace uso de assert, false en caso contrario.
	 */
	boolean useAssert();

	/**
	 * 
	 * Indica el número de assert del código.
	 * 
	 * @return Número de assert del código.
	 */
	int getNumberAssert();

	/**
	 * 
	 * Indica si el código hace uso de try.
	 * 
	 * @return True si el código hace uso de try, false en caso contrario.
	 */
	boolean useTry();

	/**
	 * 
	 * Indica el número de try del código.
	 * 
	 * @return Número de try del código.
	 */
	int getNumberTry();

	/**
	 * 
	 * Indica si el código hace uso de annotations.
	 * 
	 * @return True si el código hace uso de annotations, false en caso contrario.
	 */
	boolean useAnnotations();

	/**
	 * 
	 * Indica el número de annotations del código.
	 * 
	 * @return Número de annotations del código.
	 */
	int getNumberAnnotations();

	/**
	 * 
	 * Indica si el código hace uso de constructores implementados en el código.
	 * 
	 * @return True si el código hace uso de constructores implementados en el
	 *         código, false en caso contrario.
	 */
	boolean usePersonalConstructors();

	/**
	 * 
	 * Indica el número de constructores implementados en el código.
	 * 
	 * @return Número de constructores implementados en el código.
	 */
	int getNumberPersonalConstructors();

	/**
	 * 
	 * Indica si el código hace uso de interfaces propias del desarrollador.
	 * 
	 * @return True si el código hace uso de interfaces propias del desarrollador,
	 *         false en caso contrario.
	 */
	boolean usePersonalInterfaces();

	/**
	 * 
	 * Indica el número de interfaces desarrolladas en el código.
	 * 
	 * @return Número de interfaces desarrolladas en el código.
	 */
	int getNumberPersonalInterfaces();

	/**
	 * 
	 * Indica si el código hace uso de interfaces, es decir, implementa interfaces.
	 * 
	 * @return True si el código hace uso de interfaces, false en caso contrario.
	 */
	boolean useImplements();

	/**
	 * 
	 * Indica el número de veces que hace uso de implements en el código.
	 * 
	 * @return Número de veces que se hace uso de implements en el código.
	 */
	int getNumberImplements();

	/**
	 * 
	 * Indica si el código hace uso de extends.
	 * 
	 * @return True si el código hace uso de extends, false en caso contrario.
	 */
	boolean useExtends();

	/**
	 * 
	 * Indica el número de extends del código.
	 * 
	 * @return Número de extends del código.
	 */
	int getNumberExtends();

	/**
	 * 
	 * Indica si el código hace uso de throws.
	 * 
	 * @return True si el código hace uso de throws, false en caso contrario.
	 */
	boolean useThrows();

	/**
	 * 
	 * Indica el número de throws del código.
	 * 
	 * @return Número de throws del código.
	 */
	int getNumberThrows();

	/**
	 * 
	 * Indica si el código hace uso de throw.
	 * 
	 * @return True si el código hace uso de throw, false en caso contrario.
	 */
	boolean useThrow();

	/**
	 * 
	 * Indica el número de throw del código.
	 * 
	 * @return Número de throw del código.
	 */
	int getNumberThrow();

	/**
	 * 
	 * Indica si el código hace uso de enum.
	 * 
	 * @return True si el código hace uso de enum, false en caso contrario.
	 */
	boolean useEnum();

	/**
	 * 
	 * Indica el número de enum del código.
	 * 
	 * @return Número de enum del código.
	 */
	int getNumberEnum();

	/**
	 * 
	 * Indica si el código hace uso de final.
	 * 
	 * @return True si el código hace uso de final, false en caso contrario.
	 */
	boolean useFinal();

	/**
	 * 
	 * Indica el número de final del código.
	 * 
	 * @return Número de final del código.
	 */
	int getNumberFinal();

	/**
	 * 
	 * Indica si el código hace uso de switch.
	 * 
	 * @return True si el código hace uso de switch, false en caso contrario.
	 */
	boolean useSwitch();

	/**
	 * 
	 * Indica el número de switch del código.
	 * 
	 * @return Número de switch del código.
	 */
	int getNumberSwitch();

	/**
	 * 
	 * Indica si el código hace uso de instanceof.
	 * 
	 * @return True si el código hace uso de instanceof, false en caso contrario.
	 */
	boolean useInstanceOf();

	/**
	 * 
	 * Indica el número de instanceof del código.
	 * 
	 * @return Número de instanceof del código.
	 */
	int getNumberInstanceOf();

	/**
	 * 
	 * Indica si el código hace uso de synchronized.
	 * 
	 * @return True si el código hace uso de synchronized, false en caso contrario.
	 */
	boolean useSynchronized();

	/**
	 * 
	 * Indica el número de synchronized del código.
	 * 
	 * @return Número de synchronized del código.
	 */
	int getNumberSynchronized();

}
