package gpp.view.window.search.language;

import java.util.ArrayList;

import gpp.model.Repository;
import gpp.view.component.VSearchFieldContainer;

/**
 * 
 * Clase que implementa el filtro de los lenguajes.
 * 
 * @author Aitor Melero.
 *
 */
public abstract class Filter {

	private ArrayList<VSearchFieldContainer> fieldsList; // lista de campos de filtros

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor
	 * 
	 */
	public Filter() {

		fieldsList = new ArrayList<VSearchFieldContainer>();

	}

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Devuelve la lista de campos de filtros.
	 * 
	 * @return Lista de campos de filtros.
	 */
	public ArrayList<VSearchFieldContainer> getFieldsList() {
		return fieldsList;
	}

	/**
	 * 
	 * Modifica la lista de campos de filtros.
	 * 
	 * @param fieldsList. Lista de campos de filtros.
	 */
	public void setFieldsList(ArrayList<VSearchFieldContainer> fieldsList) {
		this.fieldsList = fieldsList;
	}

	/**************************************************************************
	 * M�TODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Compara la cadena del filtro con el n�mero del dato del lenguaje.
	 * 
	 * @param compareString. Cadena del campo del filtro a comparar.
	 * @param compareNumber. Dato a comparar.
	 * @return True si se cumple el filtro, false en caso contrario.
	 */
	public boolean compareStringNumber(String compareString, long compareNumber) {

		boolean isValid = true;
		long qRepo = compareNumber;
		long qComp = 0;
		String[] compareList = compareString.split("\\.\\.");

		try {

			if (compareString.contains("..")) {

				if (compareList.length != 2) {

					isValid = false;

				} else {

					qComp = Long.parseLong(compareList[0]);

					if (qRepo < qComp) {

						isValid = false;

					} else {

						qComp = Long.parseLong(compareList[1]);

						if (qRepo > qComp) {

							isValid = false;

						}

					}

				}

			} else if (compareString.length() > 1 && compareString.substring(1, 2).equals("=")) {

				if (compareString.substring(0, 1).equals("<")) {

					qComp = Long.parseLong(compareString.substring(2));

					if (qRepo > qComp) {

						isValid = false;

					}

				} else if (compareString.substring(0, 1).equals(">")) {

					qComp = Long.parseLong(compareString.substring(2));

					if (qRepo < qComp) {

						isValid = false;

					}

				} else {

					isValid = false;

				}

			} else if (compareString.substring(0, 1).equals("<")) {

				qComp = Long.parseLong(compareString.substring(1));

				if (qRepo >= qComp) {

					isValid = false;

				}

			} else if (compareString.substring(0, 1).equals(">")) {

				qComp = Long.parseLong(compareString.substring(1));

				if (qRepo <= qComp) {

					isValid = false;

				}

			} else {

				qComp = Long.parseLong(compareString);

				if (qRepo != qComp) {

					isValid = false;

				}

			}

		} catch (NumberFormatException e) {

			isValid = false;

		} catch (Exception e) {

			isValid = false;

		}

		return isValid;

	}

	/**
	 * 
	 * Filtra un repositorio por lenguaje.
	 * 
	 * @param repository. Repositorio a filtrar.
	 * @return True si el repositorio cumple con los filtros del lenguaje.
	 */
	public abstract boolean filterRepositoryLanguage(Repository repository);

}
