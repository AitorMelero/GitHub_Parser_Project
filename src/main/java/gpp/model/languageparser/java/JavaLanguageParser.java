package gpp.model.languageparser.java;

import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
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

	/**************************************************************************
	 * CONSTRUCTOR
	 * ************************************************************************
	 */

	/**
	 * 
	 * Constructor del parser para lenguaje Java.
	 * 
	 * @param file. Fichero Java a parsear.
	 * @throws IOException
	 */
	public JavaLanguageParser(File file) throws IOException {

		super(file);

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

}
