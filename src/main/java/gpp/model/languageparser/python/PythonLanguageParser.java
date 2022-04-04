package gpp.model.languageparser.python;

import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
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

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor del parser para lenguaje Python.
	 * 
	 * @param file. Fichero Python a parsear.
	 * @throws IOException
	 */
	public PythonLanguageParser(File file) throws IOException {

		super(file);

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

}
