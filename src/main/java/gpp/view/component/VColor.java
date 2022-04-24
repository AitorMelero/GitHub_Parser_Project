package gpp.view.component;

import java.awt.Color;

/**
 * 
 * Clase para almacenar los colores de la vista
 * 
 * @author Aitor Melero
 *
 */
public class VColor {

	private static Color GRAY_MENU = new Color(245, 245, 245);
	private static Color WHITE_MAIN = new Color(255, 255, 255);
	private static Color BLACK_MAIN = new Color(0, 0, 0);
	private static Color GRAY_FOCUS_MENU = new Color(214, 214, 214);
	private static Color BLUE_REPOSITORY_TITLE = new Color(0, 138, 240);

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	public static Color getGRAY_MENU() {
		return GRAY_MENU;
	}

	public static void setGRAY_MENU(Color gRAY_MENU) {
		GRAY_MENU = gRAY_MENU;
	}

	public static Color getWHITE_MAIN() {
		return WHITE_MAIN;
	}

	public static void setWHITE_MAIN(Color wHITE_MAIN) {
		WHITE_MAIN = wHITE_MAIN;
	}

	public static Color getBLACK_MAIN() {
		return BLACK_MAIN;
	}

	public static void setBLACK_MAIN(Color bLACK_MAIN) {
		BLACK_MAIN = bLACK_MAIN;
	}

	public static Color getGRAY_FOCUS_MENU() {
		return GRAY_FOCUS_MENU;
	}

	public static void setGRAY_FOCUS_MENU(Color gRAY_FOCUS_MENU) {
		GRAY_FOCUS_MENU = gRAY_FOCUS_MENU;
	}

	public static Color getBLUE_REPOSITORY_TITLE() {
		return BLUE_REPOSITORY_TITLE;
	}

	public static void setBLUE_REPOSITORY_TITLE(Color bLUE_REPOSITORY_TITLE) {
		BLUE_REPOSITORY_TITLE = bLUE_REPOSITORY_TITLE;
	}

}
