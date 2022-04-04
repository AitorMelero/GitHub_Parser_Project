package gpp;

import java.io.File;
import java.io.IOException;

import gpp.model.languageparser.java.JavaLanguageParser;
import gpp.model.languageparser.python.PythonLanguageParser;

public class GPPLanguageParserTest {

	public static void main(String[] args) {

		String urlJava = "src/main/resources/parser_examples/java/Prueba.java";
		String urlJava1 = "src/main/java/languageparser/LanguageParser.java";
		String urlJava2 = "src/main/resources/parser_examples/java/AllInOne17.java";
		String urlJava3 = "src/main/java/languageparser/PruebaParser.java";
		String urlJava4 = "src/main/resources/parser_examples/java/AllInOne7.java";
		String urlJava5 = "src/main/java/languageparser/java/JavaLanguageParser.java";

		parserPythonFile("src/main/resources/parser_examples/python/with_stmt.py");
		// parserJavaFile(urlJava2);

	}

	public static void parserPythonFile(String nameFile) {

		PythonLanguageParser parser;

		try {

			parser = new PythonLanguageParser(new File(nameFile));
			// parser.print();
			GPPLanguageParserTest.printTestPythonParser(parser);

		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("Error al parsear el fichero Python");
		}

	}

	public static void parserJavaFile(String nameFile) {

		JavaLanguageParser parser;

		try {

			parser = new JavaLanguageParser(new File(nameFile));
			// parser.print();
			GPPLanguageParserTest.printTestJavaParser(parser);

		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("Error al parsear el fichero Java");
		}

	}

	public static void printTestPythonParser(PythonLanguageParser parser) {

		System.out.println("-------------------------------------------------------------");
		System.out.println("PYTHON PARSER TEST");
		System.out.println("-------------------------------------------------------------");
		System.out.println("COMMENTS: uso -> " + parser.useComments() + ", number -> " + parser.getNumberComments());
		System.out.println("IMPORTS: uso -> " + parser.useImports() + ", number -> " + parser.getNumberImports());
		System.out.println("ARRAYS: uso -> " + parser.useArrays() + ", number -> " + parser.getNumberArrays());
		System.out.println("IF: uso -> " + parser.useIf() + ", number -> " + parser.getNumberIf());
		System.out.println("ELSE: uso -> " + parser.useElse() + ", number -> " + parser.getNumberElse());
		System.out.println("FOR: uso -> " + parser.useFor() + ", number -> " + parser.getNumberFor());
		System.out.println("WHILE: uso -> " + parser.useWhile() + ", number -> " + parser.getNumberWhile());
		System.out.println("LAMBDAS: uso -> " + parser.useLambdas() + ", number -> " + parser.getNumberLambdas());
		System.out.println("CONTINUE: uso -> " + parser.useContinue() + ", number -> " + parser.getNumberContinue());
		System.out.println("BREAK: uso -> " + parser.useBreak() + ", number -> " + parser.getNumberBreak());
		System.out.println(
				"FUNCTIONS NUMBER: uso -> " + parser.useFunctions() + ", number -> " + parser.getNumberFunctions());
		System.out.println("GLOBAL: uso -> " + parser.useGlobal() + ", number -> " + parser.getNumberGlobal());
		System.out.println("NONLOCAL: uso -> " + parser.useNonLocal() + ", number -> " + parser.getNumberNonLocal());
		System.out.println("LOGICAL EXPRESSIONS: uso -> " + parser.useLogicalExpressions() + ", number -> "
				+ parser.getNumberLogicalExpressions());
		System.out.println("CLASS: uso -> " + parser.useClasses() + ", number -> " + parser.getNumberClasses());
		System.out.println("YIELD: uso -> " + parser.useYield() + ", number -> " + parser.getNumberYield());
		System.out.println("ASSERT: uso -> " + parser.useAssert() + ", number -> " + parser.getNumberAssert());
		System.out.println("TRY: uso -> " + parser.useTry() + ", number -> " + parser.getNumberTry());
		System.out.println(
				"DECORATORS: uso -> " + parser.useDecorators() + ", number -> " + parser.getNumberDecorators());
		System.out.println(
				"DICTIONARIES: uso -> " + parser.useDictionaries() + ", number -> " + parser.getNumberDictionaries());
		System.out.println("IMPORTS WITH FROM: uso -> " + parser.useImportsWithFrom() + ", number -> "
				+ parser.getNumberImportsWithFrom());
		System.out.println("PASS: uso -> " + parser.usePass() + ", number -> " + parser.getNumberPass());
		System.out.println("RAISE: uso -> " + parser.useRaise() + ", number -> " + parser.getNumberRaise());
		System.out.println("WITH: uso -> " + parser.useWith() + ", number -> " + parser.getNumberWith());
		System.out.println("ASYNC: uso -> " + parser.useAsync() + ", number -> " + parser.getNumberAsync());
		System.out.println("-------------------------------------------------------------\n");

	}

	public static void printTestJavaParser(JavaLanguageParser parser) {

		for (int i = 0; i < 1; i++) {

			System.out.println("-------------------------------------------------------------");
			System.out.println("JAVA PARSER TEST");
			System.out.println("-------------------------------------------------------------");
			System.out
					.println("COMMENTS: uso -> " + parser.useComments() + ", number -> " + parser.getNumberComments());
			System.out.println("IMPORTS: uso -> " + parser.useImports() + ", number -> " + parser.getNumberImports());
			System.out.println("ARRAYS: uso -> " + parser.useArrays() + ", number -> " + parser.getNumberArrays());
			System.out.println("IF: uso -> " + parser.useIf() + ", number -> " + parser.getNumberIf());
			System.out.println("ELSE: uso -> " + parser.useElse() + ", number -> " + parser.getNumberElse());
			System.out.println("FOR: uso -> " + parser.useFor() + ", number -> " + parser.getNumberFor());
			System.out.println("WHILE: uso -> " + parser.useWhile() + ", number -> " + parser.getNumberWhile());
			System.out
					.println("CONTINUE: uso -> " + parser.useContinue() + ", number -> " + parser.getNumberContinue());
			System.out.println("BREAK: uso -> " + parser.useBreak() + ", number -> " + parser.getNumberBreak());
			System.out.println("LAMBDAS: uso -> " + parser.useLambdas() + ", number -> " + parser.getNumberLambdas());
			System.out.println("METHODS NUMBER: uso -> sin instanciar, number -> " + parser.getNumberMethods());
			System.out.println("VARIABLES: uso -> sin instanciar, number -> " + parser.getNumberVariables());
			System.out.println("LOCAL VARIABLES: uso -> sin instanciar, number -> " + parser.getNumberLocalVariables());
			System.out.println("STATIC: uso -> " + parser.useStatic() + ", number -> " + parser.getNumberStatic());
			System.out.println("PUBLIC: uso -> " + parser.usePublic() + ", number -> " + parser.getNumberPublic());
			System.out.println("PRIVATE: uso -> " + parser.usePrivate() + ", number -> " + parser.getNumberPrivate());
			System.out.println(
					"PROTECTED: uso -> " + parser.useProtected() + ", number -> " + parser.getNumberProtected());
			System.out
					.println("ABSTRACT: uso -> " + parser.useAbstract() + ", number -> " + parser.getNumberAbstract());
			System.out.println("CLASSES: uso -> no instanciado, number -> " + parser.getNumberClasses());
			System.out.println("YIELD: uso -> " + parser.useYield() + ", number -> " + parser.getNumberYield());
			System.out.println("ASSERT: uso -> " + parser.useAssert() + ", number -> " + parser.getNumberAssert());
			System.out.println("TRY: uso -> " + parser.useTry() + ", number -> " + parser.getNumberTry());
			System.out.println(
					"ANNOTATIONS: uso -> " + parser.useAnnotations() + ", number -> " + parser.getNumberAnnotations());
			System.out.println("CONSTRUCTORS: uso -> " + parser.usePersonalConstructors() + ", number -> "
					+ parser.getNumberPersonalConstructors());
			System.out.println("INTERFACES: uso -> " + parser.usePersonalInterfaces() + ", number -> "
					+ parser.getNumberPersonalInterfaces());
			System.out.println(
					"IMPLEMENTS: uso -> " + parser.useImplements() + ", number -> " + parser.getNumberImplements());
			System.out.println("EXTENDS: uso -> " + parser.useExtends() + ", number -> " + parser.getNumberExtends());
			System.out.println("THROWS: uso -> " + parser.useThrows() + ", number -> " + parser.getNumberThrows());
			System.out.println("THROW: uso -> " + parser.useThrow() + ", number -> " + parser.getNumberThrow());
			System.out.println("ENUM: uso -> " + parser.useEnum() + ", number -> " + parser.getNumberEnum());
			System.out.println("FINAL: uso -> " + parser.useFinal() + ", number -> " + parser.getNumberFinal());
			System.out.println("SWITCH: uso -> " + parser.useSwitch() + ", number -> " + parser.getNumberSwitch());
			System.out.println(
					"INSTACE OF: uso -> " + parser.useInstanceOf() + ", number -> " + parser.getNumberInstanceOf());
			System.out.println("SYNCHRONIZED: uso -> " + parser.useSynchronized() + ", number -> "
					+ parser.getNumberSynchronized());
			System.out.println("-------------------------------------------------------------\n");

		}

	}

}
