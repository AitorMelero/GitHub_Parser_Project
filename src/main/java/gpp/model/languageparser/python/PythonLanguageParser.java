package gpp.model.languageparser.python;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import antlr4.parser.PythonLexer;
import antlr4.parser.PythonParser;
import gpp.model.languageparser.IGeneralLanguageParserConditional;
import gpp.model.languageparser.IGeneralLanguageParserExpression;
import gpp.model.languageparser.IGeneralLanguageParserFlow;
import gpp.model.languageparser.IGeneralLanguageParserLoop;
import gpp.model.languageparser.LanguageParser;
import gpp.model.languageparser.LanguageParserErrorListener;

/**
 * 
 * Clase que se encarga de parsear ficheros Python.
 * 
 * @author Aitor Melero
 *
 */
public class PythonLanguageParser extends LanguageParser
		implements IGeneralLanguageParserConditional, IGeneralLanguageParserLoop, IGeneralLanguageParserExpression,
		IGeneralLanguageParserFlow, IPythonLanguageParser {

	public static final int COMMENTS = 0, IMPORTS = 1, IF = 2, ELSE = 3, FOR = 4, WHILE = 5, FUNCTIONS = 6, GLOBAL = 7,
			NONLOCAL = 8, CONTINUE = 9, BREAK = 10, ARRAYS = 11, LOGICAL_EXPRESSIONS = 12, LAMBDA = 13, CLASSES = 14,
			YIELD = 15, ASSERT = 16, TRY = 17, DECORATORS = 18, DICTIONARIES = 19, IMPORTS_WITH_FROM = 20, PASS = 21,
			RAISE = 22, WITH = 23, ASYNC = 24;
	public static final int[] namesProperties = { COMMENTS, IMPORTS, IF, ELSE, FOR, WHILE, FUNCTIONS, GLOBAL, NONLOCAL,
			CONTINUE, BREAK, ARRAYS, LOGICAL_EXPRESSIONS, LAMBDA, CLASSES, YIELD, ASSERT, TRY, DECORATORS, DICTIONARIES,
			IMPORTS_WITH_FROM, PASS, RAISE, WITH, ASYNC };

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor vacío.
	 * 
	 */
	public PythonLanguageParser() {

		super();

		// Inicializamos la lista de propiedades
		initializeVisualFields();

		String[] ext = { "py" };
		super.setExtensions(ext);

	}

	/**
	 * 
	 * Constructor del parser para lenguaje Python.
	 * 
	 * @param file. Fichero Python a parsear.
	 * @throws IOException
	 */
	public PythonLanguageParser(File file) throws IOException {

		super(file);

		// Inicializamos la lista de propiedades
		initializeVisualFields();

		String[] ext = { "py" };
		super.setExtensions(ext);

	}

	/**************************************************************************
	 * METODOS
	 * ************************************************************************
	 */

	@Override
	public void generateParser() {

		this.setLexer(new PythonLexer(new ANTLRInputStream(this.getCode())));
		this.setTokensStream(new CommonTokenStream(this.getLexer()));
		this.setTokens(this.getTokensStream().getTokens());
		this.setParser(new PythonParser(this.getTokensStream()));
		this.getParser().removeErrorListeners();
		this.getParser().addErrorListener(LanguageParserErrorListener.INSTANCE);
		this.parse();
		this.generateRulesContextList(this.getContext());

	}

	@Override
	public void parse() {

		if (this.getParser() != null) {

			PythonParser pythonParser = (PythonParser) this.getParser();

			// ERROR en el codigo
			try {

				RuleContext ctx = pythonParser.file_input();
				this.setContext(ctx);

			} catch (ParseCancellationException e) {

				System.out.println("Error de compilación");

			}

		}

	}

	@Override
	public void explore(RuleContext ctx, int indentation) {

		String ruleName = PythonParser.ruleNames[ctx.getRuleIndex()];

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

		int commentToken1 = PythonLexer.COMMENT;

		return this.isInTokens(commentToken1);

	}

	@Override
	public int getNumberComments() {

		int commentToken1 = PythonLexer.COMMENT;

		return this.getCountOfToken(commentToken1);

	}

	@Override
	public boolean useImports() {

		return this.isInTokens(PythonParser.IMPORT);

	}

	@Override
	public int getNumberImports() {

		return this.getCountOfToken(PythonParser.IMPORT);

	}

	@Override
	public boolean useIf() {

		PythonParser.Compound_stmtContext compCtx = new PythonParser.Compound_stmtContext();
		PythonParser.If_stmtContext ctx = new PythonParser.If_stmtContext(compCtx);
		PythonParser.Elif_clauseContext ctx2 = new PythonParser.Elif_clauseContext(null, 0);

		// Contamos tanto los if como los elif
		return this.isInRulesContexts(ctx) || this.isInRulesContexts(ctx2);

	}

	@Override
	public int getNumberIf() {

		PythonParser.Compound_stmtContext compCtx = new PythonParser.Compound_stmtContext();
		PythonParser.If_stmtContext ctx = new PythonParser.If_stmtContext(compCtx);
		PythonParser.Elif_clauseContext ctx2 = new PythonParser.Elif_clauseContext(null, 0);

		// Contamos tanto los if como los elif
		return this.getCountOfRuleContext(ctx) + this.getCountOfRuleContext(ctx2);

	}

	@Override
	public boolean useElse() {

		PythonParser.Else_clauseContext ctx = new PythonParser.Else_clauseContext(null, 0);
		PythonParser.Elif_clauseContext ctx2 = new PythonParser.Elif_clauseContext(null, 0);

		// Contamos tanto los else como los elif
		return this.isInRulesContexts(ctx) || this.isInRulesContexts(ctx2);

	}

	@Override
	public int getNumberElse() {

		PythonParser.Else_clauseContext ctx = new PythonParser.Else_clauseContext(null, 0);
		PythonParser.Elif_clauseContext ctx2 = new PythonParser.Elif_clauseContext(null, 0);

		// Contamos tanto los else como los elif
		return this.getCountOfRuleContext(ctx) + this.getCountOfRuleContext(ctx2);

	}

	@Override
	public boolean useFor() {

		PythonParser.Compound_stmtContext compCtx = new PythonParser.Compound_stmtContext();
		PythonParser.For_stmtContext ruleContext1 = new PythonParser.For_stmtContext(compCtx);

		return this.isInRulesContexts(ruleContext1);

	}

	@Override
	public int getNumberFor() {

		PythonParser.Compound_stmtContext compCtx = new PythonParser.Compound_stmtContext();
		PythonParser.For_stmtContext ruleContext1 = new PythonParser.For_stmtContext(compCtx);

		return this.getCountOfRuleContext(ruleContext1);

	}

	@Override
	public boolean useWhile() {

		PythonParser.Compound_stmtContext compCtx = new PythonParser.Compound_stmtContext();
		PythonParser.While_stmtContext ctx = new PythonParser.While_stmtContext(compCtx);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberWhile() {

		PythonParser.Compound_stmtContext compCtx = new PythonParser.Compound_stmtContext();
		PythonParser.While_stmtContext ctx = new PythonParser.While_stmtContext(compCtx);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useFunctions() {

		PythonParser.FuncdefContext ctx = new PythonParser.FuncdefContext(null, 0);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberFunctions() {

		PythonParser.FuncdefContext ctx = new PythonParser.FuncdefContext(null, 0);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useGlobal() {

		PythonParser.Small_stmtContext smallCtx = new PythonParser.Small_stmtContext(null, 0);
		PythonParser.Global_stmtContext ctx = new PythonParser.Global_stmtContext(smallCtx);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberGlobal() {

		PythonParser.Small_stmtContext smallCtx = new PythonParser.Small_stmtContext(null, 0);
		PythonParser.Global_stmtContext ctx = new PythonParser.Global_stmtContext(smallCtx);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useNonLocal() {

		PythonParser.Small_stmtContext smallCtx = new PythonParser.Small_stmtContext(null, 0);
		PythonParser.Nonlocal_stmtContext ctx = new PythonParser.Nonlocal_stmtContext(smallCtx);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberNonLocal() {

		PythonParser.Small_stmtContext smallCtx = new PythonParser.Small_stmtContext(null, 0);
		PythonParser.Nonlocal_stmtContext ctx = new PythonParser.Nonlocal_stmtContext(smallCtx);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useContinue() {

		PythonParser.Small_stmtContext smallCtx = new PythonParser.Small_stmtContext(null, 0);
		PythonParser.Continue_stmtContext ctx = new PythonParser.Continue_stmtContext(smallCtx);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberContinue() {

		PythonParser.Small_stmtContext smallCtx = new PythonParser.Small_stmtContext(null, 0);
		PythonParser.Continue_stmtContext ctx = new PythonParser.Continue_stmtContext(smallCtx);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useBreak() {

		PythonParser.Small_stmtContext smallCtx = new PythonParser.Small_stmtContext(null, 0);
		PythonParser.Break_stmtContext ctx = new PythonParser.Break_stmtContext(smallCtx);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberBreak() {

		PythonParser.Small_stmtContext smallCtx = new PythonParser.Small_stmtContext(null, 0);
		PythonParser.Break_stmtContext ctx = new PythonParser.Break_stmtContext(smallCtx);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useArrays() {

		PythonParser.TestlistContext ctx = new PythonParser.TestlistContext(null, 0);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberArrays() {

		PythonParser.Testlist_compContext ctx = new PythonParser.Testlist_compContext(null, 0);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useLogicalExpressions() {

		PythonParser.Logical_testContext ctx = new PythonParser.Logical_testContext(null, 0);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberLogicalExpressions() {

		PythonParser.Logical_testContext ctx = new PythonParser.Logical_testContext(null, 0);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useLambdas() {

		return this.isInTokens(PythonParser.LAMBDA);

	}

	@Override
	public int getNumberLambdas() {

		return this.getCountOfToken(PythonParser.LAMBDA);

	}

	@Override
	public boolean useClasses() {

		PythonParser.ClassdefContext ctx = new PythonParser.ClassdefContext(null, 0);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberClasses() {

		PythonParser.ClassdefContext ctx = new PythonParser.ClassdefContext(null, 0);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useYield() {

		PythonParser.Yield_exprContext ctx = new PythonParser.Yield_exprContext(null, 0);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberYield() {

		PythonParser.Yield_exprContext ctx = new PythonParser.Yield_exprContext(null, 0);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useAssert() {

		PythonParser.Small_stmtContext smallCtx = new PythonParser.Small_stmtContext(null, 0);
		PythonParser.Assert_stmtContext ctx = new PythonParser.Assert_stmtContext(smallCtx);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberAssert() {

		PythonParser.Small_stmtContext smallCtx = new PythonParser.Small_stmtContext(null, 0);
		PythonParser.Assert_stmtContext ctx = new PythonParser.Assert_stmtContext(smallCtx);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useTry() {

		PythonParser.Compound_stmtContext compCtx = new PythonParser.Compound_stmtContext(null, 0);
		PythonParser.Try_stmtContext ctx = new PythonParser.Try_stmtContext(compCtx);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberTry() {

		PythonParser.Compound_stmtContext compCtx = new PythonParser.Compound_stmtContext(null, 0);
		PythonParser.Try_stmtContext ctx = new PythonParser.Try_stmtContext(compCtx);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useDecorators() {

		PythonParser.DecoratorContext ctx = new PythonParser.DecoratorContext(null, 0);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberDecorators() {

		PythonParser.DecoratorContext ctx = new PythonParser.DecoratorContext(null, 0);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useDictionaries() {

		PythonParser.DictorsetmakerContext ctx = new PythonParser.DictorsetmakerContext(null, 0);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberDictionaries() {

		PythonParser.DictorsetmakerContext ctx = new PythonParser.DictorsetmakerContext(null, 0);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useImportsWithFrom() {

		PythonParser.Small_stmtContext smallCtx = new PythonParser.Small_stmtContext(null, 0);
		PythonParser.From_stmtContext ctx = new PythonParser.From_stmtContext(smallCtx);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberImportsWithFrom() {

		PythonParser.Small_stmtContext smallCtx = new PythonParser.Small_stmtContext(null, 0);
		PythonParser.From_stmtContext ctx = new PythonParser.From_stmtContext(smallCtx);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean usePass() {

		PythonParser.Small_stmtContext smallCtx = new PythonParser.Small_stmtContext(null, 0);
		PythonParser.Pass_stmtContext ctx = new PythonParser.Pass_stmtContext(smallCtx);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberPass() {

		PythonParser.Small_stmtContext smallCtx = new PythonParser.Small_stmtContext(null, 0);
		PythonParser.Pass_stmtContext ctx = new PythonParser.Pass_stmtContext(smallCtx);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useRaise() {

		PythonParser.Small_stmtContext smallCtx = new PythonParser.Small_stmtContext(null, 0);
		PythonParser.Raise_stmtContext ctx = new PythonParser.Raise_stmtContext(smallCtx);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberRaise() {

		PythonParser.Small_stmtContext smallCtx = new PythonParser.Small_stmtContext(null, 0);
		PythonParser.Raise_stmtContext ctx = new PythonParser.Raise_stmtContext(smallCtx);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useWith() {

		PythonParser.Compound_stmtContext compCtx = new PythonParser.Compound_stmtContext(null, 0);
		PythonParser.With_stmtContext ctx = new PythonParser.With_stmtContext(compCtx);

		return this.isInRulesContexts(ctx);

	}

	@Override
	public int getNumberWith() {

		PythonParser.Compound_stmtContext compCtx = new PythonParser.Compound_stmtContext(null, 0);
		PythonParser.With_stmtContext ctx = new PythonParser.With_stmtContext(compCtx);

		return this.getCountOfRuleContext(ctx);

	}

	@Override
	public boolean useAsync() {

		return this.isInTokens(PythonParser.ASYNC);

	}

	@Override
	public int getNumberAsync() {

		return this.getCountOfToken(PythonParser.ASYNC);

	}

	@Override
	public void generateAllValues() {

		HashMap<Integer, Long> properties = super.getPropertiesMap();
		HashMap<String, Long> visualProperties = super.getPropertiesVisualMap();
		List<Token> tokens = super.getTokens();
		int actualType = 0;
		List<RuleContext> rulesContext = super.getRulesContexts();

		// Tipos de tokens
		final int comment = PythonLexer.COMMENT;
		final int importToken = PythonLexer.IMPORT;
		final int lambdaToken = PythonLexer.LAMBDA;
		final int asyncToken = PythonLexer.ASYNC;

		// Tipos de contextos
		PythonParser.Compound_stmtContext compCtx = new PythonParser.Compound_stmtContext();
		PythonParser.Small_stmtContext smallCtx = new PythonParser.Small_stmtContext(null, 0);
		PythonParser.If_stmtContext ifCtx = new PythonParser.If_stmtContext(compCtx);
		PythonParser.Elif_clauseContext elifCtx = new PythonParser.Elif_clauseContext(null, 0);
		PythonParser.Else_clauseContext elseCtx = new PythonParser.Else_clauseContext(null, 0);
		PythonParser.For_stmtContext forCtx = new PythonParser.For_stmtContext(compCtx);
		PythonParser.While_stmtContext whileCtx = new PythonParser.While_stmtContext(compCtx);
		PythonParser.FuncdefContext functionsCtx = new PythonParser.FuncdefContext(null, 0);
		PythonParser.Global_stmtContext globalCtx = new PythonParser.Global_stmtContext(smallCtx);
		PythonParser.Nonlocal_stmtContext nonlocalCtx = new PythonParser.Nonlocal_stmtContext(smallCtx);
		PythonParser.Continue_stmtContext continueCtx = new PythonParser.Continue_stmtContext(smallCtx);
		PythonParser.Break_stmtContext breakCtx = new PythonParser.Break_stmtContext(smallCtx);
		PythonParser.TestlistContext arraysCtx = new PythonParser.TestlistContext(null, 0);
		PythonParser.Logical_testContext logicalExpressionsCtx = new PythonParser.Logical_testContext(null, 0);
		PythonParser.ClassdefContext classesCtx = new PythonParser.ClassdefContext(null, 0);
		PythonParser.Yield_exprContext yieldCtx = new PythonParser.Yield_exprContext(null, 0);
		PythonParser.Assert_stmtContext assertCtx = new PythonParser.Assert_stmtContext(smallCtx);
		PythonParser.Try_stmtContext tryCtx = new PythonParser.Try_stmtContext(compCtx);
		PythonParser.DecoratorContext decoratorsCtx = new PythonParser.DecoratorContext(null, 0);
		PythonParser.DictorsetmakerContext dictionariesCtx = new PythonParser.DictorsetmakerContext(null, 0);
		PythonParser.From_stmtContext importsWithFromCtx = new PythonParser.From_stmtContext(smallCtx);
		PythonParser.Pass_stmtContext passCtx = new PythonParser.Pass_stmtContext(smallCtx);
		PythonParser.Raise_stmtContext raiseCtx = new PythonParser.Raise_stmtContext(smallCtx);
		PythonParser.With_stmtContext withCtx = new PythonParser.With_stmtContext(compCtx);

		// Contamos tokens
		for (int i = 0; i < tokens.size(); i++) {

			actualType = tokens.get(i).getType();

			switch (actualType) {

			case comment:
				properties.put(COMMENTS, properties.get(COMMENTS) + 1);
				visualProperties.put("Número de comentarios: ", properties.get(COMMENTS));
				break;

			case importToken:
				properties.put(IMPORTS, properties.get(IMPORTS) + 1);
				visualProperties.put("Número de imports: ", properties.get(IMPORTS));
				break;

			case lambdaToken:
				properties.put(LAMBDA, properties.get(LAMBDA) + 1);
				visualProperties.put("Número de lambdas: ", properties.get(LAMBDA));
				break;

			case asyncToken:
				properties.put(ASYNC, properties.get(ASYNC) + 1);
				visualProperties.put("Número de async: ", properties.get(ASYNC));
				break;

			default:
				break;

			}

		}

		// Contamos contextos
		for (int i = 0; i < rulesContext.size(); i++) {

			if (rulesContext.get(i).getClass().isInstance(ifCtx)
					|| rulesContext.get(i).getClass().isInstance(elifCtx)) {

				properties.put(IF, properties.get(IF) + 1);
				visualProperties.put("Número de if: ", properties.get(IF));

			} else if (rulesContext.get(i).getClass().isInstance(elseCtx)
					|| rulesContext.get(i).getClass().isInstance(elifCtx)) {

				properties.put(ELSE, properties.get(ELSE) + 1);
				visualProperties.put("Número de else: ", properties.get(ELSE));

			} else if (rulesContext.get(i).getClass().isInstance(forCtx)) {

				properties.put(FOR, properties.get(FOR) + 1);
				visualProperties.put("Número de for: ", properties.get(FOR));

			} else if (rulesContext.get(i).getClass().isInstance(whileCtx)) {

				properties.put(WHILE, properties.get(WHILE) + 1);
				visualProperties.put("Número de while: ", properties.get(WHILE));

			} else if (rulesContext.get(i).getClass().isInstance(functionsCtx)) {

				properties.put(FUNCTIONS, properties.get(FUNCTIONS) + 1);
				visualProperties.put("Número de funciones: ", properties.get(FUNCTIONS));

			} else if (rulesContext.get(i).getClass().isInstance(globalCtx)) {

				properties.put(GLOBAL, properties.get(GLOBAL) + 1);
				visualProperties.put("Número de global: ", properties.get(GLOBAL));

			} else if (rulesContext.get(i).getClass().isInstance(nonlocalCtx)) {

				properties.put(NONLOCAL, properties.get(NONLOCAL) + 1);
				visualProperties.put("Número de nonlocal: ", properties.get(NONLOCAL));

			} else if (rulesContext.get(i).getClass().isInstance(continueCtx)) {

				properties.put(CONTINUE, properties.get(CONTINUE) + 1);
				visualProperties.put("Número de continue: ", properties.get(CONTINUE));

			} else if (rulesContext.get(i).getClass().isInstance(breakCtx)) {

				properties.put(BREAK, properties.get(BREAK) + 1);
				visualProperties.put("Número de break: ", properties.get(BREAK));

			} else if (rulesContext.get(i).getClass().isInstance(arraysCtx)) {

				properties.put(ARRAYS, properties.get(ARRAYS) + 1);
				visualProperties.put("Número de arrays: ", properties.get(ARRAYS));

			} else if (rulesContext.get(i).getClass().isInstance(logicalExpressionsCtx)) {

				properties.put(LOGICAL_EXPRESSIONS, properties.get(LOGICAL_EXPRESSIONS) + 1);
				visualProperties.put("Número de expresiones lógicas: ", properties.get(LOGICAL_EXPRESSIONS));

			} else if (rulesContext.get(i).getClass().isInstance(classesCtx)) {

				properties.put(CLASSES, properties.get(CLASSES) + 1);
				visualProperties.put("Número de clases: ", properties.get(CLASSES));

			} else if (rulesContext.get(i).getClass().isInstance(yieldCtx)) {

				properties.put(YIELD, properties.get(YIELD) + 1);
				visualProperties.put("Número de yield: ", properties.get(YIELD));

			} else if (rulesContext.get(i).getClass().isInstance(assertCtx)) {

				properties.put(ASSERT, properties.get(ASSERT) + 1);
				visualProperties.put("Número de assert: ", properties.get(ASSERT));

			} else if (rulesContext.get(i).getClass().isInstance(tryCtx)) {

				properties.put(TRY, properties.get(TRY) + 1);
				visualProperties.put("Número de try: ", properties.get(TRY));

			} else if (rulesContext.get(i).getClass().isInstance(decoratorsCtx)) {

				properties.put(DECORATORS, properties.get(DECORATORS) + 1);
				visualProperties.put("Número de decorators: ", properties.get(DECORATORS));

			} else if (rulesContext.get(i).getClass().isInstance(dictionariesCtx)) {

				properties.put(DICTIONARIES, properties.get(DICTIONARIES) + 1);
				visualProperties.put("Número de diccionarios: ", properties.get(DICTIONARIES));

			} else if (rulesContext.get(i).getClass().isInstance(importsWithFromCtx)) {

				properties.put(IMPORTS_WITH_FROM, properties.get(IMPORTS_WITH_FROM) + 1);
				visualProperties.put("Número de imports con from: ", properties.get(IMPORTS_WITH_FROM));

			} else if (rulesContext.get(i).getClass().isInstance(passCtx)) {

				properties.put(PASS, properties.get(PASS) + 1);
				visualProperties.put("Número de pass: ", properties.get(PASS));

			} else if (rulesContext.get(i).getClass().isInstance(raiseCtx)) {

				properties.put(RAISE, properties.get(RAISE) + 1);
				visualProperties.put("Número de raise: ", properties.get(RAISE));

			} else if (rulesContext.get(i).getClass().isInstance(withCtx)) {

				properties.put(WITH, properties.get(WITH) + 1);
				visualProperties.put("Número de with: ", properties.get(WITH));

			}

		}

	}

	/**
	 * 
	 * Inicializa todos los campos visuales de la información de Python.
	 * 
	 */
	private void initializeVisualFields() {

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

			case FUNCTIONS:
				super.getPropertiesVisualMap().put("Número de funciones: ", 0l);
				break;

			case GLOBAL:
				super.getPropertiesVisualMap().put("Número de global: ", 0l);
				break;

			case NONLOCAL:
				super.getPropertiesVisualMap().put("Número de nonlocal: ", 0l);
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

			case LOGICAL_EXPRESSIONS:
				super.getPropertiesVisualMap().put("Número de expresiones lógicas: ", 0l);
				break;

			case LAMBDA:
				super.getPropertiesVisualMap().put("Número de lambdas: ", 0l);
				break;

			case CLASSES:
				super.getPropertiesVisualMap().put("Número de clases: ", 0l);
				break;

			case YIELD:
				super.getPropertiesVisualMap().put("Número de yield: ", 0l);
				break;

			case ASSERT:
				super.getPropertiesVisualMap().put("Número de assert: ", 0l);
				break;

			case TRY:
				super.getPropertiesVisualMap().put("Número de try: ", 0l);
				break;

			case DECORATORS:
				super.getPropertiesVisualMap().put("Número de decorators: ", 0l);
				break;

			case DICTIONARIES:
				super.getPropertiesVisualMap().put("Número de diccionarios: ", 0l);
				break;

			case IMPORTS_WITH_FROM:
				super.getPropertiesVisualMap().put("Número de imports con from: ", 0l);
				break;

			case PASS:
				super.getPropertiesVisualMap().put("Número de pass: ", 0l);
				break;

			case RAISE:
				super.getPropertiesVisualMap().put("Número de raise: ", 0l);
				break;

			case WITH:
				super.getPropertiesVisualMap().put("Número de with: ", 0l);
				break;

			case ASYNC:
				super.getPropertiesVisualMap().put("Número de async: ", 0l);
				break;

			default:
				break;

			}

		}

	}

}
