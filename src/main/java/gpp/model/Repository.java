package gpp.model;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import com.google.gson.JsonObject;

import gpp.GPPSystem;
import gpp.constant.GPPConstant;
import gpp.model.languageparser.LanguageParser;
import gpp.model.languageparser.java.JavaLanguageParser;
import gpp.model.languageparser.python.PythonLanguageParser;
import gpp.model.search.Search;

/**
 * 
 * Clase que implementa un repositorio.
 * 
 * @author AitorMelero.
 *
 */
public class Repository {

	private String ownerName; // nombre del propietario del repositorio
	private String name; // nombre del repositorio
	private String clonePath; // path donde est� clonado el repositorio, null si no est� clonado
	private String description; // descripci�n del repositorio
	private long starsNumber; // n�mero de estrellas del repositorio
	private long forksNumber; // n�mero de forks del repositorio
	private long watchersNumber; // n�mero de watchers del repositorio
	private String license; // licencia del repositorio
	private String dateCreated; // fecha de creaci�n
	private String dateUpdated; // fecha de actualizaci�n
	private int filesNumber; // n�mero de ficheros del repositorio
	private Set<String> extensionsList; // lista con las extensiones que aparecen en el repositorio
	private ArrayList<String> topics; // lista de topics del repositorio
	private long totalSize; // tama�o total del repositorio (sacado de la api y puede ser 0)
	private long avgSize; // tama�o medio de ficheros (en caso de un tama�o total de 0, ser� 0 la media)
	private String mainLanguage; // lenguaje principal del repositorio
	private long mainLanguagesFilesNumber; // n�mero de ficheros del lenguaje principal
	private LanguageParser languageProperties; // propiedades sobre el lenguaje principal del repositorio
	private String mainBranch; // nombre de la rama principal del repositorio

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor.
	 * 
	 * @param ownerName. Propietario del repositorio.
	 * @param name.      Nombre del repositorio.
	 */
	public Repository(String ownerName, String name) {

		this.ownerName = ownerName;
		this.name = name;

		// Comprobamos si el repositorio est� clonado
		String path = GPPSystem.getUser().getClonePath() + ownerName + "/" + name + "/";
		File file = new File(path);
		if (file.isDirectory()) {

			this.clonePath = path;

		} else {

			this.clonePath = null;

		}

		this.description = "";
		this.starsNumber = 0;
		this.forksNumber = 0;
		this.watchersNumber = 0;
		this.license = "";
		this.dateCreated = "";
		this.dateUpdated = "";
		this.filesNumber = 0;
		this.extensionsList = new HashSet<String>();
		this.topics = new ArrayList<String>();
		this.totalSize = 0;
		this.avgSize = 0;
		this.mainLanguage = null;
		this.mainLanguagesFilesNumber = 0;
		this.languageProperties = null;
		this.mainBranch = "";

	}

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Devuelve el nombre del propietario del repositorio.
	 * 
	 * @return Nombre del propietarios del repositorio.
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * 
	 * Modifica el nombre del propietario del repositorio.
	 * 
	 * @param ownerName. Nuevo nombre del propietario del repositorio.
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/**
	 * 
	 * Devuelve el nombre del repositorio.
	 * 
	 * @return Nombre del repositorio.
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * Modifica el nombre del repositorio.
	 * 
	 * @param name. Nuevo nombre del repositorio.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * Devuelve el path donde est� clonado el repositorio.
	 * 
	 * @return Path donde est� clonado el repositorio, null si no est� clonado.
	 */
	public String getClonePath() {
		return clonePath;
	}

	/**
	 * 
	 * Modifica el path donde est� clonado el repositorio.
	 * 
	 * @param clonePath. Path donde est� clonado el repositorio.
	 */
	public void setClonePath(String clonePath) {
		this.clonePath = clonePath;
	}

	/**
	 * 
	 * Devuelve la descripci�n del repositorio.
	 * 
	 * @return Descripci�n del repositorio.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * Modifica la descripci�n del repositorio.
	 * 
	 * @param description. Descripci�n del repositorio.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * Devuelve el n�mero de estrellas del repositorio.
	 * 
	 * @return N�mero de estrellas del repositorio.
	 */
	public long getStarsNumber() {
		return starsNumber;
	}

	/**
	 * 
	 * Modifica el n�mero de estrellas del repositorio.
	 * 
	 * @param starsNumber. N�mero de estrellas del repositorio.
	 */
	public void setStarsNumber(long starsNumber) {
		this.starsNumber = starsNumber;
	}

	/**
	 * 
	 * Devuelve el n�mero de forks del repositorio.
	 * 
	 * @return N�mero de forks del repositorio.
	 */
	public long getForksNumber() {
		return forksNumber;
	}

	/**
	 * 
	 * Modifica el n�mero de forks del repositorio.
	 * 
	 * @param forksNumber. N�mero de forks del repositorio.
	 */
	public void setForksNumber(long forksNumber) {
		this.forksNumber = forksNumber;
	}

	/**
	 * 
	 * Devuelve el n�mero de watchers del repositorio.
	 * 
	 * @return N�mero de watchers del repositorio.
	 */
	public long getWatchersNumber() {
		return watchersNumber;
	}

	/**
	 * 
	 * Modifica el n�mero de watchers del repositorio.
	 * 
	 * @param watchersNumber. N�mero de watchers del repositorio.
	 */
	public void setWatchersNumber(long watchersNumber) {
		this.watchersNumber = watchersNumber;
	}

	/**
	 * 
	 * Devuelve la licencia del repositorio.
	 * 
	 * @return Licencia del repositorio.
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * 
	 * Modifica la licencia del repositorio.
	 * 
	 * @param license. Licencia del repositorio.
	 */
	public void setLicense(String license) {
		this.license = license;
	}

	/**
	 * 
	 * Devuelve la cadena de la fecha de creaci�n del repositorio.
	 * 
	 * @return Fecha de creaci�n del repositorio.
	 */
	public String getDateCreated() {
		return dateCreated;
	}

	/**
	 * 
	 * Modifica la fecha de creaci�n del repositorio.
	 * 
	 * @param dateCreated. Fecha de creaci�n del repositorio.
	 */
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * 
	 * Devuelve la cadena de la fecha de actualizaci�n del repositorio.
	 * 
	 * @return Fecha de actualizaci�n del repositorio.
	 */
	public String getDateUpdated() {
		return dateUpdated;
	}

	/**
	 * 
	 * Modifica la cadena de la fecha de actualizaci�n del repositorio.
	 * 
	 * @param dateUpdated. Fecha de actualizaci�n del repositorio.
	 */
	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	/**
	 * 
	 * Devuelve el n�mero de ficheros de un repositorio.
	 * 
	 * @return N�mero de ficheros del repositorio.
	 */
	public int getFilesNumber() {
		return filesNumber;
	}

	/**
	 * 
	 * Modifica el n�mero de ficheros del repositorio
	 * 
	 * @param filesNumber. N�mero de ficheros del repositorio.
	 */
	public void setFilesNumber(int filesNumber) {
		this.filesNumber = filesNumber;
	}

	/**
	 * 
	 * Devuelve la lista de extensiones del repositorio.
	 * 
	 * @return Lista de extensiones del repositorio.
	 */
	public Set<String> getExtensionsList() {
		return extensionsList;
	}

	/**
	 * 
	 * Modifica la lista de extensiones del repositorio
	 * 
	 * @param extensionsList. Lista de extensiones del repositorio.
	 */
	public void setExtensionsList(Set<String> extensionsList) {
		this.extensionsList = extensionsList;
	}

	/**
	 * 
	 * Devuelve la lista de topics del repositorio.
	 * 
	 * @return Lista de topics del repositorio.
	 */
	public ArrayList<String> getTopics() {
		return topics;
	}

	/**
	 * 
	 * Modifica la lista de topics del repositorio.
	 * 
	 * @param topics. Lista de topics del repositorio.
	 */
	public void setTopics(ArrayList<String> topics) {
		this.topics = topics;
	}

	/**
	 * 
	 * Devuelve el tama�o total del repositorio en KBytes.
	 * 
	 * @return Tama�o total del repositorio en KBytes. Sacado de la API y puede ser
	 *         0 KB.
	 */
	public long getTotalSize() {
		return totalSize;
	}

	/**
	 * 
	 * Modifica el tama�o total del repositorio.
	 * 
	 * @param totalSize. Tama�o total del repositorio.
	 */
	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}

	/**
	 * 
	 * Devuelve el tama�o medio de ficheros del repositorio.
	 * 
	 * @return El tama�o medio de ficheros del repositorio. Como el tama�o total
	 *         puede ser 0, el tama�o medio tambi�n lo puede ser.
	 */
	public long getAvgSize() {
		return avgSize;
	}

	/**
	 * 
	 * Modifica el tama�o medio de los ficheros del repositorio.
	 * 
	 * @param avgSize. Tama�o medio de los ficheros del repositorio.
	 */
	public void setAvgSize(long avgSize) {
		this.avgSize = avgSize;
	}

	/**
	 * 
	 * Devuelve el lenguaje principal del repositorio, sacado de la API.
	 * 
	 * @return Lenguaje principal del repositorio.
	 */
	public String getMainLanguage() {
		return mainLanguage;
	}

	/**
	 * 
	 * Modifica el lenguaje principal del repositorio.
	 * 
	 * @param mainLanguage. Lenguaje principal del repositorio.
	 */
	public void setMainLanguage(String mainLanguage) {
		this.mainLanguage = mainLanguage;

		// Cambiamos las propiedades del lenguaje si existe c�digo para analizar el
		// mismo
		if (mainLanguage.toLowerCase().equals("java")) {

			this.languageProperties = new JavaLanguageParser();

		} else if (mainLanguage.toLowerCase().equals("python")) {

			this.languageProperties = new PythonLanguageParser();

		} else {

			this.languageProperties = null;

		}
	}

	/**
	 * 
	 * Devuelve el n�mero de ficheros analizados por lenguaje particular.
	 * 
	 * @return N�mero de ficheros analizados por lenguaje particular.
	 */
	public long getMainLanguagesFilesNumber() {
		return mainLanguagesFilesNumber;
	}

	/**
	 * 
	 * Modifica el n�mero de ficheros analizados por lenguaje particular.
	 * 
	 * @param mainLanguagesFilesNumber. N�mero de ficheros analizados por lenguaje
	 *                                  particular.
	 */
	public void setMainLanguagesFilesNumber(long mainLanguagesFilesNumber) {
		this.mainLanguagesFilesNumber = mainLanguagesFilesNumber;
	}

	/**
	 * 
	 * Devuelve las propiedades parseadas del lenguaje principal.
	 * 
	 * @return Propiedades parseadas del lenguaje principal.
	 */
	public LanguageParser getLanguageProperties() {
		return languageProperties;
	}

	/**
	 * 
	 * Devuelve el nombre de la rama principal del repositorio.
	 * 
	 * @return Rama principal del repositorio.
	 */
	public String getMainBranch() {
		return mainBranch;
	}

	/**
	 * 
	 * Modifica la rama principal del repositorio.
	 * 
	 * @param mainBranch. Rama principal del repositorio.
	 */
	public void setMainBranch(String mainBranch) {
		this.mainBranch = mainBranch;
	}

	/**************************************************************************
	 * M�TODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Genera la informaci�n completa del repositorio.
	 * 
	 */
	public void generateFullInfo() throws Exception {

		// Inicializamos a 0 los valores de las propiedades del lenguaje
		if (languageProperties != null) {
			languageProperties.clearProperties();
		}

		// Recorremos el repositorio fichero a fichero si tenemos el repositorio clonado
		if (clonePath != null && !clonePath.equals("")) {

			File f = new File(clonePath);
			getFullInfo(f);

		} else {

			// Conseguimos el zip y parseamos el repositorio si no est� clonado
			getInfoDownloadRepo();

		}

		// Calculamos el tama�o medio de ficheros
		if (totalSize == 0 || filesNumber == 0) {

			avgSize = 0;

		} else {

			avgSize = totalSize / filesNumber;

		}

	}

	/**
	 * 
	 * M�todo para clonar el repositorio.
	 * 
	 */
	public void cloneRepo() throws Exception {

		String repoUrl = "https://github.com/" + ownerName + "/" + name + ".git";
		User user = GPPSystem.getUser();
		String path = user.getClonePath() + ownerName + "/" + name + "/";

		// Comprobamos si el repositorio ya est� clonado
		if (clonePath == null) {
			
			// Creamos panel de informaci�n
			JOptionPane container = new JOptionPane();
			container.setMessageType(JOptionPane.INFORMATION_MESSAGE);
			container.setMessage("Espere un momento mientras se clona el repositorio...");
			String[] op = {};
			container.setOptions(op);
			JDialog dialog = container.createDialog(GPPConstant.window, "Clonar repositorio");
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(false);
			
			// Tarea ejecutada en paralelo para clonar el repositorio
			ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
			Future<Object> submit = newCachedThreadPool.submit(new Callable<Object>() {
			    @Override
			    public Search call() {
			    	
			    	if (GPPSystem.isGlobalSemaphoreTasks()) {
			    		
			    		setClonePath(path);

						CredentialsProvider cp = new UsernamePasswordCredentialsProvider(user.getUsername(), user.getToken());

						try {
							Git.cloneRepository().setCredentialsProvider(cp).setURI(repoUrl).setDirectory(Paths.get(path).toFile())
									.call().close();
						} catch (InvalidRemoteException e) {

							dialog.dispose();
							GPPSystem.setGlobalSemaphoreTasks(false);
							JOptionPane.showMessageDialog(GPPConstant.window, "Hubo un error al clonar el repositorio", "Error", JOptionPane.ERROR_MESSAGE);
							return null;
							
						} catch (TransportException e) {

							dialog.dispose();
							GPPSystem.setGlobalSemaphoreTasks(false);
							JOptionPane.showMessageDialog(GPPConstant.window, "Hubo un error al clonar el repositorio", "Error", JOptionPane.ERROR_MESSAGE);
							return null;
							
						} catch (GitAPIException e) {

							dialog.dispose();
							GPPSystem.setGlobalSemaphoreTasks(false);
							JOptionPane.showMessageDialog(GPPConstant.window, "Hubo un error al clonar el repositorio", "Error", JOptionPane.ERROR_MESSAGE);
							return null;
							
						}
						
						if (GPPSystem.isGlobalSemaphoreTasks()) {
							
							dialog.dispose();
							GPPSystem.setGlobalSemaphoreTasks(false);
							return null;
							
						}
						
			    	}
			    	
					return null;
			    }
			});
			
			GPPSystem.setGlobalSemaphoreTasks(true);
			
			dialog.setVisible(true);
			
			if (GPPSystem.isGlobalSemaphoreTasks()) {
				
				// Si se llega aqu� es que el usuario ha cancelado la clonaci�n
				GPPSystem.setGlobalSemaphoreTasks(false);
				
				// Borramos el repositorio
				if (this.clonePath != null && !this.clonePath.replace(" ", "").equals("")) {
					
					File dirRepo = new File(this.clonePath);
					this.deleteCloneRepo(dirRepo);
					dirRepo = new File(user.getClonePath() + ownerName + "/");
					if (dirRepo.listFiles().length == 0) {
						dirRepo.delete();
					}
					setClonePath(null);
					
				}
				
			}

		} else {
			
			JOptionPane.showMessageDialog(GPPConstant.window, "Ya est� clonado este repositorio", "Clonado", JOptionPane.INFORMATION_MESSAGE);
			
		}

	}

	/**
	 * 
	 * Consigue el zip del repositorio y va parseando cada fichero.
	 * 
	 */
	public void getInfoDownloadRepo() throws Exception {

		String code = "";
		String uriPath = "https://codeload.github.com/" + this.getOwnerName() + "/" + this.getName()
				+ "/zip/refs/heads/" + this.getMainBranch();

		try {

			URL url = new URL(uriPath);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Authorization", "token " + GPPSystem.getUser().getToken());
			InputStream in = connection.getInputStream();
			ZipInputStream zipIn = new ZipInputStream(in);
			ZipEntry entry = zipIn.getNextEntry();

			while (entry != null) {
				
				// Se cancela la tarea en paralelo
				if (!GPPSystem.isGlobalSemaphoreTasks()) {
					
					return;
					
				}

				if (!entry.isDirectory()) {
					code = new String(zipIn.readAllBytes(), Charset.forName("UTF-8"));
					this.parserCode(entry.getName(), code);

				}

				zipIn.closeEntry();
				entry = zipIn.getNextEntry();

			}

		} catch (Exception e) {

			System.out.println("EXCEPCION: " + e);

		}

	}

	/**
	 * 
	 * Parsea un fichero del repositorio.
	 * 
	 * @param fileName. Nombre del fichero a parsear.
	 * @param code.     C�digo a parsear.
	 */
	private void parserCode(String fileName, String code) {

		String extension = "";
		boolean fileLanguageAnalyze = false;

		// Sumamos el n�mero de ficheros
		filesNumber++;

		// Guardamos las extensiones
		if (fileName.contains(".")) {

			extension = fileName.substring(fileName.lastIndexOf(".") + 1);

			extensionsList.add(extension);

			// Analizamos las propiedades del lenguaje si corresponde
			if (languageProperties != null) {

				for (int i = 0; i < languageProperties.getExtensions().length && !fileLanguageAnalyze; i++) {

					if (languageProperties.getExtensions()[i].equals(extension)) {

						this.mainLanguagesFilesNumber++;

						try {

							languageProperties.setCodeWithoutFile(code);
							languageProperties.generateAllValues();

						} catch (StackOverflowError e) {
							System.out.println("ERROR STACK OVERFLOW ERROR");
						}

						fileLanguageAnalyze = true;

					}

				}

			}

		}

	}

	/**
	 * 
	 * M�todo para eliminar repositorios clonados
	 * 
	 */
	private void deleteCloneRepo(File f) {

		if (f.isDirectory()) {
			for (File c : f.listFiles()) {
				deleteCloneRepo(c);
			}
		}

		if (!f.delete()) {
			System.out.println("NO SE PUEDE BORRAR: " + f.getName());
		}

	}

	/**
	 * 
	 * M�todo recursivo que saca toda la info del repositorio.
	 * 
	 * @param f. Fichero o directorio a analizar.
	 */
	private void getFullInfo(File f) {

		String fileName = f.getName();
		String extension = "";
		boolean fileLanguageAnalyze = false;

		if (!fileName.equals(".git")) {

			if (f.isDirectory()) {

				for (File c : f.listFiles()) {
					
					// Se cancela la tarea en paralelo
					if (!GPPSystem.isGlobalSemaphoreTasks()) {
						
						return;
						
					}
					
					getFullInfo(c);
				}

			} else {

				// Sumamos el n�mero de ficheros
				filesNumber++;

				// Guardamos las extensiones
				if (fileName.contains(".")) {

					extension = fileName.substring(fileName.lastIndexOf(".") + 1);

					extensionsList.add(extension);

					// Analizamos las propiedades del lenguaje si corresponde
					if (languageProperties != null) {

						for (int i = 0; i < languageProperties.getExtensions().length && !fileLanguageAnalyze; i++) {

							if (languageProperties.getExtensions()[i].equals(extension)) {

								this.mainLanguagesFilesNumber++;

								try {

									languageProperties.setFile(f);
									languageProperties.generateAllValues();

								} catch (IOException e) {

									System.out.println("NO SE HA PODIDO ANALIZAR EL FICHERO A PARTIR DEL LENGUAJE");

								} catch (StackOverflowError e) {
									System.out.println("ERROR STACK OVERFLOW ERROR");
								}

								fileLanguageAnalyze = true;

							}

						}

					}

				}

			}

		}

	}
	
	/**
	 * 
	 * Devuelve la informaci�n b�sica del repositorio en formato JSON.
	 * 
	 * @return Informaci�n b�sica del repositorio en formato JSON.
	 */
	public JsonObject infoRepositoryToJsonObject() {
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("ownerName", ownerName);
		jsonObject.addProperty("name", name);
		jsonObject.addProperty("clonePath", clonePath);
		jsonObject.addProperty("description", description);
		jsonObject.addProperty("starsNumber", starsNumber);
		jsonObject.addProperty("forksNumber", forksNumber);
		jsonObject.addProperty("watchersNumber", watchersNumber);
		jsonObject.addProperty("license", license);
		jsonObject.addProperty("dateCreated", dateCreated);
		jsonObject.addProperty("dateUpdated", dateUpdated);
		jsonObject.addProperty("filesNumber", filesNumber);
		
		String listString = "[";
		if (extensionsList.size() == 0) {
			listString += "]";
		} else {
			for (String s: extensionsList) {
				listString += s + ", ";
			}
			listString = listString.substring(0, listString.length()-2) + "]";
		}
		jsonObject.addProperty("extensionsList", listString);
		
		listString = "[";
		if (topics.size() == 0) {
			listString += "]";
		} else {
			for (String s: topics) {
				listString += s + ", ";
			}
			listString = listString.substring(0, listString.length()-2) + "]";
		}
		jsonObject.addProperty("topics", listString);
		jsonObject.addProperty("totalSize", totalSize);
		jsonObject.addProperty("avgSize", avgSize);
		jsonObject.addProperty("mainLanguage", mainLanguage);
		jsonObject.addProperty("mainLanguagesFilesNumber", mainLanguagesFilesNumber);
		jsonObject.addProperty("mainBranch", mainBranch);
		JsonObject language = new JsonObject();
		if (languageProperties != null) {
			
			for (String s: languageProperties.getPropertiesVisualMap().keySet()) {
				language.addProperty(s, languageProperties.getPropertiesVisualMap().get(s));
			}
			
		}
		jsonObject.add("languageProperties", language);
		
		return jsonObject;
		
	}

}
