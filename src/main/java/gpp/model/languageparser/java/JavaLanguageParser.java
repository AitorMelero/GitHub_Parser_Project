package gpp.model.languageparser.java;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr4.parser.JavaLexer;
import antlr4.parser.JavaParser;
import gpp.model.languageparser.IGeneralLanguageParserConditional;
import gpp.model.languageparser.IGeneralLanguageParserExpression;
import gpp.model.languageparser.IGeneralLanguageParserFlow;
import gpp.model.languageparser.IGeneralLanguageParserLoop;
import gpp.model.languageparser.LanguageParser;
import gpp.model.languageparser.LanguageParserErrorListener;

/**
 * 
 * Clase que se encarga de parsear ficheros Java.
 * 
 * @author Aitor Melero
 *
 */
public class JavaLanguageParser extends LanguageParser implements IGeneralLanguageParserConditional,
		IGeneralLanguageParserLoop, IGeneralLanguageParserExpression, IGeneralLanguageParserFlow, IJavaLanguageParser {

	public static final int COMMENTS = 0, IMPORTS = 1, IF = 2, ELSE = 3, FOR = 4, WHILE = 5, CONTINUE = 6, BREAK = 7,
			ARRAYS = 8, LAMBDAS = 9, METHODS = 10, VARIABLES = 11, LOCAL_VARIABLES = 12, STATIC = 13, PUBLIC = 14,
			PRIVATE = 15, PROTECTED = 16;
	public static final int[] namesProperties = { COMMENTS, IMPORTS, IF, ELSE, FOR, WHILE, CONTINUE, BREAK, ARRAYS,
			LAMBDAS, METHODS, VARIABLES, LOCAL_VARIABLES, STATIC, PUBLIC, PRIVATE, PROTECTED };

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor vacío.
	 * 
	 */
	public JavaLanguageParser() {

		super();

		// Inicializamos la lista de propiedades
		for (int np : namesProperties) {

			super.getPropertiesMap().put(np, 0l);

			switch (np) {

			case COMMENTS:
				super.getPropertiesVisualMap().put("Número de comentarios: ", 0l);
				break;

			case IMPORTS:
				super.getPropertiesVisualMap().put("Número de imports: ", 0l);
				break;

			case IF:
				super.getPropertiesVisualMap().put("Número de if: ", 0l);
				break;

			case ELSE:
				super.getPropertiesVisualMap().put("Número de else: ", 0l);
				break;

			case FOR:
				super.getPropertiesVisualMap().put("Número de for: ", 0l);
				break;

			case WHILE:
				super.getPropertiesVisualMap().put("Número de while: ", 0l);
				break;

			case CONTINUE:
				super.getPropertiesVisualMap().put("Número de continue: ", 0l);
				break;

			case BREAK:
				super.getPropertiesVisualMap().put("Número de break: ", 0l);
				break;

			case ARRAYS:
				super.getPropertiesVisualMap().put("Número de arrays: ", 0l);
				break;

			case LAMBDAS:
				super.getPropertiesVisualMap().put("Número de lambdas: ", 0l);
				break;

			case METHODS:
				super.getPropertiesVisualMap().put("Número de métodos: ", 0l);
				break;

			case VARIABLES:
				super.getPropertiesVisualMap().put("Número de variables: ", 0l);
				break;

			case LOCAL_VARIABLES:
				super.getPropertiesVisualMap().put("Número de variables locales: ", 0l);
				break;

			case STATIC:
				super.getPropertiesVisualMap().put("Número de campos static: ", 0l);
				break;

			case PUBLIC:
				super.getPropertiesVisualMap().put("Número de campos public: ", 0l);
				break;

			case PRIVATE:
				super.getPropertiesVisualMap().put("Número de campos private: ", 0l);
				break;

			case PROTECTED:
				super.getPropertiesVisualMap().put("Número de campos protected: ", 0l);
				break;

			default:
				break;

			}

		}

		String[] ext = { "java" };
		super.setExtensions(ext);

	}

	/**
	 * 
	 * Constructor del parser para lenguaje Java.
	 * 
	 * @param file. Fichero Java a parsear.
	 * @throws IOException
	 */
	public JavaLanguageParser(File file) throws IOException {

		super(file);

		// Inicializamos la lista de propiedades
		for (int np : namesProperties) {

			super.getPropertiesMap().put(np, 0l);

		}

		String[] ext = { "java" };
		super.setExtensions(ext);

	}

	/**************************************************************************
	 * METODOS
	 * ************************************************************************
	 */

	@Override
	public void generateParser() {

		this.setLexer(new JavaLexer(new ANTLRInputStream(this.getCode())));
		this.setTokensStream(new CommonTokenStream(this.getLexer()));
		this.setTokens(this.getTokensStream().getTokens());
		this.setParser(new JavaParser(this.getTokensStream()));
		this.getParser().removeErrorListeners();
		this.getParser().addErrorListener(LanguageParserErrorListener.INSTANCE);
		System.gc();
		this.parse();
		this.generateRulesContextList(this.getContext());
	}

	@Override
	public void parse() {

		if (this.getParser() != null) {

			JavaParser javaParser = (JavaParser) this.getParser();

			// ERROR en el codigo
			try {

				RuleContext ctx = javaParser.compilationUnit();
				this.setContext(ctx);

			} catch (ParseCancellationException e) {

				System.out.println("Error syntax: " + e.getMessage());

			} catch (RecognitionException e) {

				System.out.println("ERROR TE PILLE");

			}

		}

	}

	@Override
	public void explore(RuleContext ctx, int indentation) {

		String ruleName = JavaParser.ruleNames[ctx.getRuleIndex()];

		for (int i = 0; i < indentation; i++) {

			System.out.print(" ");

		}

		System.out.println(ruleName);

		for (int i = 0; i < ctx.getChildCount(); i++) {

			ParseTree element = ctx.getChild(i);

			if (element instanceof RuleContext) {

				explore((RuleContext) element, indentation + 1);

			}

		}

	}

	/**************************************************************************
	 * MÉTODOS PARA ANALIZAR
	 * ************************************************************************
	 */

	@Override
	public boolean useComments() {

		int commentToken1 = JavaLexer.COMMENT;
		int commentToken2 = JavaLexer.LINE_COMMENT;

		return this.isInTokens(commentToken1) || this.isInTokens(commentToken2);

	}

	@Override
	public int getNumberComments() {

		int commentToken1 = JavaLexer.COMMENT;
		int commentToken2 = JavaLexer.LINE_COMMENT;

		return this.getCountOfToken(commentToken1) + this.getCountOfToken(commentToken2);

	}

	@Override
	public boolean useImports() {

		JavaParser.ImportDeclarationContext ctx = new JavaParser.ImportDeclarationContext(null, 0);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberImports() {

		JavaParser.ImportDeclarationContext ctx = new JavaParser.ImportDeclarationContext(null, 0);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useIf() {

		return this.isInTokens(JavaParser.IF);

	}

	@Override
	public int getNumberIf() {

		return this.getCountOfToken(JavaParser.IF);

	}

	@Override
	public boolean useElse() {

		return this.isInTokens(JavaParser.ELSE);

	}

	@Override
	public int getNumberElse() {

		return this.getCountOfToken(JavaParser.ELSE);

	}

	@Override
	public boolean useFor() {

		JavaParser.ForControlContext ctx = new JavaParser.ForControlContext(null, 0);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberFor() {

		JavaParser.ForControlContext ctx = new JavaParser.ForControlContext(null, 0);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useWhile() {

		return this.isInTokens(JavaParser.WHILE);

	}

	@Override
	public int getNumberWhile() {

		return this.getCountOfToken(JavaParser.WHILE);

	}

	@Override
	public boolean useContinue() {

		return this.isInTokens(JavaParser.CONTINUE);

	}

	@Override
	public int getNumberContinue() {

		return this.getCountOfToken(JavaParser.CONTINUE);

	}

	@Override
	public boolean useBreak() {

		return this.isInTokens(JavaParser.BREAK);

	}

	@Override
	public int getNumberBreak() {

		return this.getCountOfToken(JavaParser.BREAK);

	}

	@Override
	public boolean useArrays() {

		// Nota: se comprueba la creación de arrays, no se comprueba un array declarado
		// sin inicializar ni tamaño especificado; e.g: int[] a;
		JavaParser.ArrayInitializerContext ctx = new JavaParser.ArrayInitializerContext(null, 0);
		JavaParser.ArrayCreatorRestContext ctx2 = new JavaParser.ArrayCreatorRestContext(null, 0);

		return this.isInRulesContexts(ctx) || this.isInRulesContexts(ctx2);

	}

	@Override
	public int getNumberArrays() {

		// Nota: se comprueba la creación de arrays, no se comprueba un array declarado
		// sin inicializar ni tamaño especificado; e.g: int[] a;
		JavaParser.ArrayInitializerContext ctx = new JavaParser.ArrayInitializerContext(null, 0);
		JavaParser.ArrayCreatorRestContext ctx2 = new JavaParser.ArrayCreatorRestContext(null, 0);

		return this.getCountOfRuleContext(ctx) + this.getCountOfRuleContext(ctx2);

	}

	@Override
	public boolean useLambdas() {

		JavaParser.LambdaExpressionContext ctx = new JavaParser.LambdaExpressionContext(null, 0);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberLambdas() {

		JavaParser.LambdaExpressionContext ctx = new JavaParser.LambdaExpressionContext(null, 0);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public int getNumberMethods() {

		JavaParser.MethodDeclarationContext ctx = new JavaParser.MethodDeclarationContext(null, 0);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public int getNumberVariables() {

		JavaParser.VariableDeclaratorContext ctx = new JavaParser.VariableDeclaratorContext(null, 0);

		return this.getCountOfRuleContext(ctx);
	}

	@Override
	public int getNumberLocalVariables() {

		JavaParser.LocalVariableDeclarationContext ctx = new JavaParser.LocalVariableDeclarationContext(null, 0);

		return this.getCountOfRuleContext(ctx);
	}

	@Override
	public boolean useStatic() {

		return this.isInTokens(JavaParser.STATIC);

	}

	@Override
	public int getNumberStatic() {

		return this.getCountOfToken(JavaParser.STATIC);

	}

	@Override
	public boolean usePublic() {

		return this.isInTokens(JavaParser.PUBLIC);

	}

	@Override
	public int getNumberPublic() {

		return this.getCountOfToken(JavaParser.PUBLIC);

	}

	@Override
	public boolean usePrivate() {

		return this.isInTokens(JavaParser.PRIVATE);

	}

	@Override
	public int getNumberPrivate() {

		return this.getCountOfToken(JavaParser.PRIVATE);

	}

	@Override
	public boolean useProtected() {

		return this.isInTokens(JavaParser.PROTECTED);

	}

	@Override
	public int getNumberProtected() {

		return this.getCountOfToken(JavaParser.PROTECTED);

	}

	@Override
	public boolean useAbstract() {

		return this.isInTokens(JavaParser.ABSTRACT);

	}

	@Override
	public int getNumberAbstract() {

		return this.getCountOfToken(JavaParser.ABSTRACT);

	}

	@Override
	public int getNumberClasses() {

		JavaParser.ClassDeclarationContext ctx = new JavaParser.ClassDeclarationContext(null, 0);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useYield() {

		return this.isInTokens(JavaParser.YIELD);

	}

	@Override
	public int getNumberYield() {

		return this.getCountOfToken(JavaParser.YIELD);

	}

	@Override
	public boolean useAssert() {

		return this.isInTokens(JavaParser.ASSERT);

	}

	@Override
	public int getNumberAssert() {

		return this.getCountOfToken(JavaParser.ASSERT);

	}

	@Override
	public boolean useTry() {

		return this.isInTokens(JavaParser.TRY);

	}

	@Override
	public int getNumberTry() {

		return this.getCountOfToken(JavaParser.TRY);

	}

	@Override
	public boolean useAnnotations() {

		JavaParser.AnnotationContext ctx = new JavaParser.AnnotationContext(null, 0);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberAnnotations() {

		JavaParser.AnnotationContext ctx = new JavaParser.AnnotationContext(null, 0);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean usePersonalConstructors() {

		JavaParser.ConstructorDeclarationContext ctx = new JavaParser.ConstructorDeclarationContext(null, 0);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberPersonalConstructors() {

		JavaParser.ConstructorDeclarationContext ctx = new JavaParser.ConstructorDeclarationContext(null, 0);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean usePersonalInterfaces() {

		JavaParser.InterfaceDeclarationContext ctx = new JavaParser.InterfaceDeclarationContext(null, 0);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberPersonalInterfaces() {

		JavaParser.InterfaceDeclarationContext ctx = new JavaParser.InterfaceDeclarationContext(null, 0);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useImplements() {

		return this.isInTokens(JavaParser.IMPLEMENTS);

	}

	@Override
	public int getNumberImplements() {

		return this.getCountOfToken(JavaParser.IMPLEMENTS);

	}

	@Override
	public boolean useExtends() {

		return this.isInTokens(JavaParser.EXTENDS);

	}

	@Override
	public int getNumberExtends() {

		return this.getCountOfToken(JavaParser.EXTENDS);

	}

	@Override
	public boolean useThrows() {

		return this.isInTokens(JavaParser.THROWS);

	}

	@Override
	public int getNumberThrows() {

		return this.getCountOfToken(JavaParser.THROWS);

	}

	@Override
	public boolean useThrow() {

		return this.isInTokens(JavaParser.THROW);

	}

	@Override
	public int getNumberThrow() {

		return this.getCountOfToken(JavaParser.THROW);

	}

	@Override
	public boolean useEnum() {

		JavaParser.EnumDeclarationContext ctx = new JavaParser.EnumDeclarationContext(null, 0);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberEnum() {

		JavaParser.EnumDeclarationContext ctx = new JavaParser.EnumDeclarationContext(null, 0);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useFinal() {

		return this.isInTokens(JavaParser.FINAL);

	}

	@Override
	public int getNumberFinal() {

		return this.getCountOfToken(JavaParser.FINAL);

	}

	@Override
	public boolean useSwitch() {

		return this.isInTokens(JavaParser.SWITCH);

	}

	@Override
	public int getNumberSwitch() {

		return this.getCountOfToken(JavaParser.SWITCH);

	}

	@Override
	public boolean useInstanceOf() {

		return this.isInTokens(JavaParser.INSTANCEOF);

	}

	@Override
	public int getNumberInstanceOf() {

		return this.getCountOfToken(JavaParser.INSTANCEOF);

	}

	@Override
	public boolean useSynchronized() {

		return this.isInTokens(JavaParser.SYNCHRONIZED);

	}

	@Override
	public int getNumberSynchronized() {

		return this.getCountOfToken(JavaParser.SYNCHRONIZED);

	}

	@Override
	public void generateAllValues() {

		HashMap<Integer, Long> properties = super.getPropertiesMap();
		HashMap<String, Long> visualProperties = super.getPropertiesVisualMap();
		List<Token> tokens = super.getTokens();
		int actualType = 0;
		List<RuleContext> rulesContext = super.getRulesContexts();

		// Tipos de tokens
		final int comment = JavaLexer.COMMENT;
		final int comment2 = JavaLexer.LINE_COMMENT;
		final int ifToken = JavaParser.IF;
		final int elseToken = JavaParser.ELSE;
		final int whileToken = JavaParser.WHILE;
		final int continueToken = JavaParser.CONTINUE;
		final int breakToken = JavaParser.BREAK;
		final int staticToken = JavaParser.STATIC;
		final int publicToken = JavaParser.PUBLIC;
		final int privateToken = JavaParser.PRIVATE;
		final int protectedToken = JavaParser.PROTECTED;

		// Tipos de contextos
		final JavaParser.ImportDeclarationContext imports = new JavaParser.ImportDeclarationContext(null, 0);
		final JavaParser.ForControlContext forCtx = new JavaParser.ForControlContext(null, 0);
		// Nota: se comprueba la creación de arrays, no se comprueba un array declarado
		// sin inicializar ni tamaño especificado; e.g: int[] a;
		final JavaParser.ArrayInitializerContext arrayCtx1 = new JavaParser.ArrayInitializerContext(null, 0);
		final JavaParser.ArrayCreatorRestContext arrayCtx2 = new JavaParser.ArrayCreatorRestContext(null, 0);
		final JavaParser.LambdaExpressionContext lambdasCtx = new JavaParser.LambdaExpressionContext(null, 0);
		final JavaParser.MethodDeclarationContext methodsCtx = new JavaParser.MethodDeclarationContext(null, 0);
		final JavaParser.VariableDeclaratorContext variablesCtx = new JavaParser.VariableDeclaratorContext(null, 0);
		final JavaParser.LocalVariableDeclarationContext localVariablesCtx = new JavaParser.LocalVariableDeclarationContext(
				null, 0);

		// Contamos tokens
		for (int i = 0; i < tokens.size(); i++) {

			actualType = tokens.get(i).getType();

			switch (actualType) {

			case comment:
			case comment2:
				properties.put(COMMENTS, properties.get(COMMENTS) + 1);
				visualProperties.put("Número de comentarios: ", properties.get(COMMENTS));
				break;

			case ifToken:
				properties.put(IF, properties.get(IF) + 1);
				visualProperties.put("Número de if: ", properties.get(IF));
				break;

			case elseToken:
				properties.put(ELSE, properties.get(ELSE) + 1);
				visualProperties.put("Número de else: ", properties.get(ELSE));
				break;

			case whileToken:
				properties.put(WHILE, properties.get(WHILE) + 1);
				visualProperties.put("Número de while: ", properties.get(WHILE));
				break;

			case continueToken:
				properties.put(CONTINUE, properties.get(CONTINUE) + 1);
				visualProperties.put("Número de continue: ", properties.get(CONTINUE));
				break;

			case breakToken:
				properties.put(BREAK, properties.get(BREAK) + 1);
				visualProperties.put("Número de break: ", properties.get(BREAK));
				break;

			case staticToken:
				properties.put(STATIC, properties.get(STATIC) + 1);
				visualProperties.put("Número de campos static: ", properties.get(STATIC));
				break;

			case publicToken:
				properties.put(PUBLIC, properties.get(PUBLIC) + 1);
				visualProperties.put("Número de campos public: ", properties.get(PUBLIC));
				break;

			case privateToken:
				properties.put(PRIVATE, properties.get(PRIVATE) + 1);
				visualProperties.put("Número de campos private: ", properties.get(PRIVATE));
				break;

			case protectedToken:
				properties.put(PROTECTED, properties.get(PROTECTED) + 1);
				visualProperties.put("Número de campos protected: ", properties.get(PROTECTED));
				break;

			default:
				break;

			}

		}

		// Contamos contextos
		for (int i = 0; i < rulesContext.size(); i++) {

			if (rulesContext.get(i).getClass().isInstance(imports)) {

				properties.put(IMPORTS, properties.get(IMPORTS) + 1);
				visualProperties.put("Número de imports: ", properties.get(IMPORTS));

			} else if (rulesContext.get(i).getClass().isInstance(forCtx)) {

				properties.put(FOR, properties.get(FOR) + 1);
				visualProperties.put("Número de for: ", properties.get(FOR));

			} else if (rulesContext.get(i).getClass().isInstance(arrayCtx1)
					|| rulesContext.get(i).getClass().isInstance(arrayCtx2)) {

				properties.put(ARRAYS, properties.get(ARRAYS) + 1);
				visualProperties.put("Número de arrays: ", properties.get(ARRAYS));

			} else if (rulesContext.get(i).getClass().isInstance(lambdasCtx)) {

				properties.put(LAMBDAS, properties.get(LAMBDAS) + 1);
				visualProperties.put("Número de lambdas: ", properties.get(LAMBDAS));

			} else if (rulesContext.get(i).getClass().isInstance(methodsCtx)) {

				properties.put(METHODS, properties.get(METHODS) + 1);
				visualProperties.put("Número de métodos: ", properties.get(METHODS));

			} else if (rulesContext.get(i).getClass().isInstance(variablesCtx)) {

				properties.put(VARIABLES, properties.get(VARIABLES) + 1);
				visualProperties.put("Número de variables: ", properties.get(VARIABLES));

			} else if (rulesContext.get(i).getClass().isInstance(localVariablesCtx)) {

				properties.put(LOCAL_VARIABLES, properties.get(LOCAL_VARIABLES) + 1);
				visualProperties.put("Número de variables locales: ", properties.get(LOCAL_VARIABLES));

			}

		}

	}

}
