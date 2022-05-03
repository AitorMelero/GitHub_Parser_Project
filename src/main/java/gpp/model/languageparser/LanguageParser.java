package gpp.model.languageparser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Define e implementa las características básicas para el parser de cualquier
 * lenguaje.
 * 
 * @author Aitor Melero
 *
 */
public abstract class LanguageParser implements IGeneralLanguageParser {

	private String[] extensions;

	private File file = null; // fichero para parsear
	private String code = ""; // codigo para parsear

	private Lexer lexer = null; // lexer
	private CommonTokenStream tokensStream = null; // stream de tokens comunes
	private Parser parser = null; // parser
	private RuleContext context = null; // contexto del fichero

	private List<Token> tokens = null; // tokens del fichero parseado
	private List<RuleContext> rulesContexts = null; // reglas de contextos del fichero parseado

	private HashMap<Integer, Long> propertiesMap = null; // diccionario con las propiedades y sus valores analizados
	private HashMap<String, Long> propertiesVisualMap = null; // diccionario con los valores de las propiedades a
																// mostrar

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor vacío.
	 * 
	 */
	public LanguageParser() {

		context = new RuleContext();
		tokens = new ArrayList<Token>();
		rulesContexts = new ArrayList<RuleContext>();

		propertiesMap = new HashMap<Integer, Long>();
		propertiesVisualMap = new HashMap<String, Long>();

	}

	/**
	 * Constructor de parser del lenguaje.
	 * 
	 * @param file. Fichero para parsear.
	 * @throws IOException
	 */
	public LanguageParser(File file) throws IOException {

		context = new RuleContext();
		tokens = new ArrayList<Token>();
		rulesContexts = new ArrayList<RuleContext>();

		// genera todo el parser a partir del fichero
		setFile(file);

		propertiesMap = new HashMap<Integer, Long>();
		propertiesVisualMap = new HashMap<String, Long>();

	}

	/**************************************************************************
	 * GETTERS Y SETTERS
	 * ************************************************************************
	 */

	public String[] getExtensions() {
		return this.extensions;
	}

	public void setExtensions(String[] extensions) {
		this.extensions = extensions;
	}

	public File getFile() {
		return this.file;
	}

	public void setFile(File file) throws IOException {
		this.file = file;
		this.setCode();
	}

	public String getCode() {
		return this.code;
	}

	private void setCode() throws IOException {
		this.code = readFile(Charset.forName("UTF-8"));
		// Cada vez que cambia el codigo cambiamos las reglas de contexto y el parser
		this.rulesContexts = null;
		this.generateParser();
	}

	public Lexer getLexer() {
		return lexer;
	}

	public void setLexer(Lexer lexer) {
		this.lexer = lexer;
	}

	public CommonTokenStream getTokensStream() {
		return tokensStream;
	}

	public void setTokensStream(CommonTokenStream tokensStream) {
		this.tokensStream = tokensStream;
	}

	public Parser getParser() {
		return parser;
	}

	public void setParser(Parser parser) {
		this.parser = parser;
	}

	public RuleContext getContext() {
		return context;
	}

	public void setContext(RuleContext context) {
		this.context = context;
	}

	public List<Token> getTokens() {
		return tokens;
	}

	public void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}

	public List<RuleContext> getRulesContexts() {
		return rulesContexts;
	}

	public void setRulesContexts(List<RuleContext> rulesContexts) {
		this.rulesContexts = rulesContexts;
	}

	public HashMap<Integer, Long> getPropertiesMap() {
		return propertiesMap;
	}

	public void setPropertiesMap(HashMap<Integer, Long> propertiesMap) {
		this.propertiesMap = propertiesMap;
	}

	public HashMap<String, Long> getPropertiesVisualMap() {
		return propertiesVisualMap;
	}

	public void setPropertiesVisualMap(HashMap<String, Long> propertiesVisualMap) {
		this.propertiesVisualMap = propertiesVisualMap;
	}

	/**************************************************************************
	 * METODOS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Genera la lista con las reglas de contexto del fichero parseado.
	 * 
	 * @param ctx. Contexto.
	 */
	public void generateRulesContextList(RuleContext ctx) {

		// Creamos de 0 las reglas si no están creadas
		if (this.rulesContexts == null) {

			this.rulesContexts = new ArrayList<RuleContext>();

		}

		// Incluimos la regla a la lista de reglas
		this.getRulesContexts().add(ctx);

		for (int i = 0; i < ctx.getChildCount(); i++) {

			ParseTree element = ctx.getChild(i);

			if (element instanceof RuleContext) {

				generateRulesContextList((RuleContext) element);

			}

		}

	}

	/**
	 * 
	 * Indica si un tipo de token aparece en la lista de tokens del fichero.
	 * 
	 * @param tokenType. Tipo de token a buscar.
	 * @return True si se ha encontrado el tipo de token, false en caso contrario.
	 */
	public boolean isInTokens(int tokenType) {

		boolean isIn = false;

		for (int i = 0; i < tokens.size() && !isIn; i++) {

			if (tokens.get(i).getType() == tokenType) {

				isIn = true;

			}

		}

		return isIn;

	}

	/**
	 * 
	 * Devuelve el número de veces que aparece un token en la lista de tokens del
	 * fichero.
	 * 
	 * @param tokenType. Tipo de token a contar.
	 * @return Número de veces que aparece el tipo de token.
	 */
	public int getCountOfToken(int tokenType) {

		int tokenCount = 0;

		for (int i = 0; i < tokens.size(); i++) {

			if (tokens.get(i).getType() == tokenType) {

				tokenCount++;

			}

		}

		return tokenCount;

	}

	/**
	 * 
	 * Indica si una regla de contexto se encuentra entre las reglas de contexto del
	 * fichero.
	 * 
	 * @param ruleContext. Regla de contexto a buscar.
	 * @return True si se ha encontrado la regla de contexto, false en caso
	 *         contrario.
	 */
	public boolean isInRulesContexts(RuleContext ruleContext) {

		boolean isIn = false;

		for (int i = 0; i < rulesContexts.size() && !isIn; i++) {

			if (rulesContexts.get(i).getClass().isInstance(ruleContext)) {

				isIn = true;

			}

		}

		return isIn;

	}

	/**
	 * 
	 * Cuenta el número de veces que aparece una regla de contexto entre todas las
	 * reglas de contexto del fichero.
	 * 
	 * @param ruleContext. Regla de contexto a contar.
	 * @return Número de veces que aparece la regla de contexto.
	 */
	public int getCountOfRuleContext(RuleContext ruleContext) {

		int ruleContextCount = 0;

		for (int i = 0; i < rulesContexts.size(); i++) {

			if (rulesContexts.get(i).getClass().isInstance(ruleContext)) {

				ruleContextCount++;

			}

		}

		return ruleContextCount;

	}

	/**
	 * 
	 * Imprime el Abstract Syntax Tree (AST) del fichero parseado.
	 * 
	 */
	public void print() {

		explore(context, 0);

	}

	/**
	 * 
	 * Inicializa los valores de las propiedades a 0.
	 * 
	 */
	public void clearProperties() {

		for (int k : propertiesMap.keySet()) {

			propertiesMap.put(k, 0l);

		}

	}

	/**
	 * Genera la cadena con el contenido de un fichero.
	 * 
	 * @param file.     Fichero.
	 * @param encoding. Codificación.
	 * @return La cadena con el contenido del fichero.
	 * @throws IOException
	 */
	private String readFile(Charset encoding) throws IOException {

		byte[] encoded = Files.readAllBytes(file.toPath());

		return new String(encoded, encoding);

	}

	/**************************************************************************
	 * METODOS A IMPLEMENTAR POR CLASES HIJAS
	 * ************************************************************************
	 */

	/**
	 * 
	 * Genera el parser del lenguaje.
	 * 
	 */
	public abstract void generateParser();

	/**
	 * 
	 * Genera el contexto del lenguaje parseado, parsea el fichero.
	 * 
	 */
	public abstract void parse();

	/**
	 * 
	 * Explora imprimiendo el Abstract Syntax Tree (AST) a partir de un contexto.
	 * 
	 * @param ctx.         Contexto.
	 * @param indentation. Identación
	 */
	public abstract void explore(RuleContext ctx, int indentation);

	/**
	 * 
	 * Analiza todos las propiedades del lenguaje de una sola pasada al fichero.
	 * 
	 */
	public abstract void generateAllValues();

}
