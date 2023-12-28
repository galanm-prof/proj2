// Generated from C:/Investigacion/prototypes/proj2/src/experiment\LexerExperiment.g4 by ANTLR 4.8
package experiment;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LexerExperiment extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		REPOSITORIES=1, REQUESTS=2, REPOSITORY=3, SEARCHING=4, NUMBERINFORMATIONSPACESTRONGSETS=5, 
		NUMBERINFORMATIONSPACEWEAKSETS=6, NUMBERSTATESPACESTRONGSETS=7, NUMBERSTATESPACEWEAKSETS=8, 
		MEANSIZEINFORMATIONSPACESTRONGSETS=9, MEANSIZEINFORMATIONSPACESTRONGSETSMAX=10, 
		MEANSIZEINFORMATIONSPACEWEAKSETS=11, MEANSIZEINFORMATIONSPACEWEAKSETSMAX=12, 
		MEANSIZESTATESPACESTRONGSETS=13, MEANSIZESTATESPACESTRONGSETSMAX=14, MEANSIZESTATESPACEWEAKSETS=15, 
		MEANSIZESTATESPACEWEAKSETSMAX=16, MEANRELATIVESIZEINFORMATIONSPACESTRONGSETS=17, 
		MEANRELATIVESIZEINFORMATIONSPACESTRONGSETSMAX=18, MEANRELATIVESIZEINFORMATIONSPACEWEAKSETS=19, 
		MEANRELATIVESIZEINFORMATIONSPACEWEAKSETSMAX=20, MEANRELATIVESIZESTATESPACESTRONGSETS=21, 
		MEANRELATIVESIZESTATESPACESTRONGSETSMAX=22, MEANRELATIVESIZESTATESPACEWEAKSETS=23, 
		MEANRELATIVESIZESTATESPACEWEAKSETSMAX=24, TRUE=25, INEFFICIENT=26, EFFICIENTLEVEL1=27, 
		EFFICIENTLEVEL2=28, OR=29, AND=30, NEG=31, OP=32, CP=33, COMMA=34, COLON=35, 
		SEMICOLON=36, BLANK=37, TAB=38, NL=39, UNDERLINE=40, MINUS=41, DOT=42, 
		DBL=43, INT=44, ID=45, LINECOMMENTARY=46, BLOCKCOMMENTARY=47;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"REPOSITORIES", "REQUESTS", "REPOSITORY", "SEARCHING", "NUMBERINFORMATIONSPACESTRONGSETS", 
			"NUMBERINFORMATIONSPACEWEAKSETS", "NUMBERSTATESPACESTRONGSETS", "NUMBERSTATESPACEWEAKSETS", 
			"MEANSIZEINFORMATIONSPACESTRONGSETS", "MEANSIZEINFORMATIONSPACESTRONGSETSMAX", 
			"MEANSIZEINFORMATIONSPACEWEAKSETS", "MEANSIZEINFORMATIONSPACEWEAKSETSMAX", 
			"MEANSIZESTATESPACESTRONGSETS", "MEANSIZESTATESPACESTRONGSETSMAX", "MEANSIZESTATESPACEWEAKSETS", 
			"MEANSIZESTATESPACEWEAKSETSMAX", "MEANRELATIVESIZEINFORMATIONSPACESTRONGSETS", 
			"MEANRELATIVESIZEINFORMATIONSPACESTRONGSETSMAX", "MEANRELATIVESIZEINFORMATIONSPACEWEAKSETS", 
			"MEANRELATIVESIZEINFORMATIONSPACEWEAKSETSMAX", "MEANRELATIVESIZESTATESPACESTRONGSETS", 
			"MEANRELATIVESIZESTATESPACESTRONGSETSMAX", "MEANRELATIVESIZESTATESPACEWEAKSETS", 
			"MEANRELATIVESIZESTATESPACEWEAKSETSMAX", "TRUE", "INEFFICIENT", "EFFICIENTLEVEL1", 
			"EFFICIENTLEVEL2", "OR", "AND", "NEG", "OP", "CP", "COMMA", "COLON", 
			"SEMICOLON", "BLANK", "TAB", "NL", "LETTER", "DIGIT", "UNDERLINE", "MINUS", 
			"DOT", "DBL", "INT", "ID", "LINECOMMENTARY", "BLOCKCOMMENTARY"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'REPOSITORIES'", "'REQUESTS'", "'REPOSITORY'", "'SEARCHING'", 
			"'numberInformationSpaceStrongSets'", "'numberInformationSpaceWeakSets'", 
			"'numberStateSpaceStrongSets'", "'numberStateSpaceWeakSets'", "'meanSizeInformationSpaceStrongSets'", 
			"'meanSizeInformationSpaceStrongSetsMax'", "'meanSizeInformationSpaceWeakSets'", 
			"'meanSizeInformationSpaceWeakSetsMax'", "'meanSizeStateSpaceStrongSets'", 
			"'meanSizeStateSpaceStrongSetsMax'", "'meanSizeStateSpaceWeakSets'", 
			"'meanSizeStateSpaceWeakSetsMax'", "'meanRelativeSizeInformationSpaceStrongSets'", 
			"'meanRelativeSizeInformationSpaceStrongSetsMax'", "'meanRelativeSizeInformationSpaceWeakSets'", 
			"'meanRelativeSizeInformationSpaceWeakSetsMax'", "'meanRelativeSizeStateSpaceStrongSets'", 
			"'meanRelativeSizeStateSpaceStrongSetsMax'", "'meanRelativeSizeStateSpaceWeakSets'", 
			"'meanRelativeSizeStateSpaceWeakSetsMax'", "'true'", "'inefficient'", 
			"'efficient-1-level'", "'efficient-2-level'", "'or'", "'and'", "'not'", 
			"'('", "')'", "','", "':'", "';'", "' '", "'\t'", null, "'_'", "'-'", 
			"'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "REPOSITORIES", "REQUESTS", "REPOSITORY", "SEARCHING", "NUMBERINFORMATIONSPACESTRONGSETS", 
			"NUMBERINFORMATIONSPACEWEAKSETS", "NUMBERSTATESPACESTRONGSETS", "NUMBERSTATESPACEWEAKSETS", 
			"MEANSIZEINFORMATIONSPACESTRONGSETS", "MEANSIZEINFORMATIONSPACESTRONGSETSMAX", 
			"MEANSIZEINFORMATIONSPACEWEAKSETS", "MEANSIZEINFORMATIONSPACEWEAKSETSMAX", 
			"MEANSIZESTATESPACESTRONGSETS", "MEANSIZESTATESPACESTRONGSETSMAX", "MEANSIZESTATESPACEWEAKSETS", 
			"MEANSIZESTATESPACEWEAKSETSMAX", "MEANRELATIVESIZEINFORMATIONSPACESTRONGSETS", 
			"MEANRELATIVESIZEINFORMATIONSPACESTRONGSETSMAX", "MEANRELATIVESIZEINFORMATIONSPACEWEAKSETS", 
			"MEANRELATIVESIZEINFORMATIONSPACEWEAKSETSMAX", "MEANRELATIVESIZESTATESPACESTRONGSETS", 
			"MEANRELATIVESIZESTATESPACESTRONGSETSMAX", "MEANRELATIVESIZESTATESPACEWEAKSETS", 
			"MEANRELATIVESIZESTATESPACEWEAKSETSMAX", "TRUE", "INEFFICIENT", "EFFICIENTLEVEL1", 
			"EFFICIENTLEVEL2", "OR", "AND", "NEG", "OP", "CP", "COMMA", "COLON", 
			"SEMICOLON", "BLANK", "TAB", "NL", "UNDERLINE", "MINUS", "DOT", "DBL", 
			"INT", "ID", "LINECOMMENTARY", "BLOCKCOMMENTARY"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public LexerExperiment(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LexerExperiment.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\61\u03f1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3"+
		"%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\5(\u03a0\n(\3(\3(\3(\3(\3)\3)\3*\3"+
		"*\3+\3+\3,\3,\3-\3-\3.\6.\u03b1\n.\r.\16.\u03b2\3.\3.\7.\u03b7\n.\f.\16"+
		".\u03ba\13.\3.\3.\6.\u03be\n.\r.\16.\u03bf\5.\u03c2\n.\3/\6/\u03c5\n/"+
		"\r/\16/\u03c6\3\60\3\60\5\60\u03cb\n\60\3\60\3\60\3\60\3\60\3\60\7\60"+
		"\u03d2\n\60\f\60\16\60\u03d5\13\60\3\61\3\61\3\61\3\61\7\61\u03db\n\61"+
		"\f\61\16\61\u03de\13\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\7\62\u03e8"+
		"\n\62\f\62\16\62\u03eb\13\62\3\62\3\62\3\62\3\62\3\62\4\u03dc\u03e9\2"+
		"\63\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q\2S\2U*W+Y,[-]._/a\60c\61\3\2\3\4\2C\\c|\2"+
		"\u03fc\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2"+
		"\2\3e\3\2\2\2\5r\3\2\2\2\7{\3\2\2\2\t\u0086\3\2\2\2\13\u0090\3\2\2\2\r"+
		"\u00b1\3\2\2\2\17\u00d0\3\2\2\2\21\u00eb\3\2\2\2\23\u0104\3\2\2\2\25\u0127"+
		"\3\2\2\2\27\u014d\3\2\2\2\31\u016e\3\2\2\2\33\u0192\3\2\2\2\35\u01af\3"+
		"\2\2\2\37\u01cf\3\2\2\2!\u01ea\3\2\2\2#\u0208\3\2\2\2%\u0233\3\2\2\2\'"+
		"\u0261\3\2\2\2)\u028a\3\2\2\2+\u02b6\3\2\2\2-\u02db\3\2\2\2/\u0303\3\2"+
		"\2\2\61\u0326\3\2\2\2\63\u034c\3\2\2\2\65\u0351\3\2\2\2\67\u035d\3\2\2"+
		"\29\u036f\3\2\2\2;\u0381\3\2\2\2=\u0384\3\2\2\2?\u0388\3\2\2\2A\u038c"+
		"\3\2\2\2C\u038e\3\2\2\2E\u0390\3\2\2\2G\u0392\3\2\2\2I\u0394\3\2\2\2K"+
		"\u0396\3\2\2\2M\u039a\3\2\2\2O\u039f\3\2\2\2Q\u03a5\3\2\2\2S\u03a7\3\2"+
		"\2\2U\u03a9\3\2\2\2W\u03ab\3\2\2\2Y\u03ad\3\2\2\2[\u03c1\3\2\2\2]\u03c4"+
		"\3\2\2\2_\u03ca\3\2\2\2a\u03d6\3\2\2\2c\u03e3\3\2\2\2ef\7T\2\2fg\7G\2"+
		"\2gh\7R\2\2hi\7Q\2\2ij\7U\2\2jk\7K\2\2kl\7V\2\2lm\7Q\2\2mn\7T\2\2no\7"+
		"K\2\2op\7G\2\2pq\7U\2\2q\4\3\2\2\2rs\7T\2\2st\7G\2\2tu\7S\2\2uv\7W\2\2"+
		"vw\7G\2\2wx\7U\2\2xy\7V\2\2yz\7U\2\2z\6\3\2\2\2{|\7T\2\2|}\7G\2\2}~\7"+
		"R\2\2~\177\7Q\2\2\177\u0080\7U\2\2\u0080\u0081\7K\2\2\u0081\u0082\7V\2"+
		"\2\u0082\u0083\7Q\2\2\u0083\u0084\7T\2\2\u0084\u0085\7[\2\2\u0085\b\3"+
		"\2\2\2\u0086\u0087\7U\2\2\u0087\u0088\7G\2\2\u0088\u0089\7C\2\2\u0089"+
		"\u008a\7T\2\2\u008a\u008b\7E\2\2\u008b\u008c\7J\2\2\u008c\u008d\7K\2\2"+
		"\u008d\u008e\7P\2\2\u008e\u008f\7I\2\2\u008f\n\3\2\2\2\u0090\u0091\7p"+
		"\2\2\u0091\u0092\7w\2\2\u0092\u0093\7o\2\2\u0093\u0094\7d\2\2\u0094\u0095"+
		"\7g\2\2\u0095\u0096\7t\2\2\u0096\u0097\7K\2\2\u0097\u0098\7p\2\2\u0098"+
		"\u0099\7h\2\2\u0099\u009a\7q\2\2\u009a\u009b\7t\2\2\u009b\u009c\7o\2\2"+
		"\u009c\u009d\7c\2\2\u009d\u009e\7v\2\2\u009e\u009f\7k\2\2\u009f\u00a0"+
		"\7q\2\2\u00a0\u00a1\7p\2\2\u00a1\u00a2\7U\2\2\u00a2\u00a3\7r\2\2\u00a3"+
		"\u00a4\7c\2\2\u00a4\u00a5\7e\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7U\2\2"+
		"\u00a7\u00a8\7v\2\2\u00a8\u00a9\7t\2\2\u00a9\u00aa\7q\2\2\u00aa\u00ab"+
		"\7p\2\2\u00ab\u00ac\7i\2\2\u00ac\u00ad\7U\2\2\u00ad\u00ae\7g\2\2\u00ae"+
		"\u00af\7v\2\2\u00af\u00b0\7u\2\2\u00b0\f\3\2\2\2\u00b1\u00b2\7p\2\2\u00b2"+
		"\u00b3\7w\2\2\u00b3\u00b4\7o\2\2\u00b4\u00b5\7d\2\2\u00b5\u00b6\7g\2\2"+
		"\u00b6\u00b7\7t\2\2\u00b7\u00b8\7K\2\2\u00b8\u00b9\7p\2\2\u00b9\u00ba"+
		"\7h\2\2\u00ba\u00bb\7q\2\2\u00bb\u00bc\7t\2\2\u00bc\u00bd\7o\2\2\u00bd"+
		"\u00be\7c\2\2\u00be\u00bf\7v\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1\7q\2\2"+
		"\u00c1\u00c2\7p\2\2\u00c2\u00c3\7U\2\2\u00c3\u00c4\7r\2\2\u00c4\u00c5"+
		"\7c\2\2\u00c5\u00c6\7e\2\2\u00c6\u00c7\7g\2\2\u00c7\u00c8\7Y\2\2\u00c8"+
		"\u00c9\7g\2\2\u00c9\u00ca\7c\2\2\u00ca\u00cb\7m\2\2\u00cb\u00cc\7U\2\2"+
		"\u00cc\u00cd\7g\2\2\u00cd\u00ce\7v\2\2\u00ce\u00cf\7u\2\2\u00cf\16\3\2"+
		"\2\2\u00d0\u00d1\7p\2\2\u00d1\u00d2\7w\2\2\u00d2\u00d3\7o\2\2\u00d3\u00d4"+
		"\7d\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6\7t\2\2\u00d6\u00d7\7U\2\2\u00d7"+
		"\u00d8\7v\2\2\u00d8\u00d9\7c\2\2\u00d9\u00da\7v\2\2\u00da\u00db\7g\2\2"+
		"\u00db\u00dc\7U\2\2\u00dc\u00dd\7r\2\2\u00dd\u00de\7c\2\2\u00de\u00df"+
		"\7e\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7U\2\2\u00e1\u00e2\7v\2\2\u00e2"+
		"\u00e3\7t\2\2\u00e3\u00e4\7q\2\2\u00e4\u00e5\7p\2\2\u00e5\u00e6\7i\2\2"+
		"\u00e6\u00e7\7U\2\2\u00e7\u00e8\7g\2\2\u00e8\u00e9\7v\2\2\u00e9\u00ea"+
		"\7u\2\2\u00ea\20\3\2\2\2\u00eb\u00ec\7p\2\2\u00ec\u00ed\7w\2\2\u00ed\u00ee"+
		"\7o\2\2\u00ee\u00ef\7d\2\2\u00ef\u00f0\7g\2\2\u00f0\u00f1\7t\2\2\u00f1"+
		"\u00f2\7U\2\2\u00f2\u00f3\7v\2\2\u00f3\u00f4\7c\2\2\u00f4\u00f5\7v\2\2"+
		"\u00f5\u00f6\7g\2\2\u00f6\u00f7\7U\2\2\u00f7\u00f8\7r\2\2\u00f8\u00f9"+
		"\7c\2\2\u00f9\u00fa\7e\2\2\u00fa\u00fb\7g\2\2\u00fb\u00fc\7Y\2\2\u00fc"+
		"\u00fd\7g\2\2\u00fd\u00fe\7c\2\2\u00fe\u00ff\7m\2\2\u00ff\u0100\7U\2\2"+
		"\u0100\u0101\7g\2\2\u0101\u0102\7v\2\2\u0102\u0103\7u\2\2\u0103\22\3\2"+
		"\2\2\u0104\u0105\7o\2\2\u0105\u0106\7g\2\2\u0106\u0107\7c\2\2\u0107\u0108"+
		"\7p\2\2\u0108\u0109\7U\2\2\u0109\u010a\7k\2\2\u010a\u010b\7|\2\2\u010b"+
		"\u010c\7g\2\2\u010c\u010d\7K\2\2\u010d\u010e\7p\2\2\u010e\u010f\7h\2\2"+
		"\u010f\u0110\7q\2\2\u0110\u0111\7t\2\2\u0111\u0112\7o\2\2\u0112\u0113"+
		"\7c\2\2\u0113\u0114\7v\2\2\u0114\u0115\7k\2\2\u0115\u0116\7q\2\2\u0116"+
		"\u0117\7p\2\2\u0117\u0118\7U\2\2\u0118\u0119\7r\2\2\u0119\u011a\7c\2\2"+
		"\u011a\u011b\7e\2\2\u011b\u011c\7g\2\2\u011c\u011d\7U\2\2\u011d\u011e"+
		"\7v\2\2\u011e\u011f\7t\2\2\u011f\u0120\7q\2\2\u0120\u0121\7p\2\2\u0121"+
		"\u0122\7i\2\2\u0122\u0123\7U\2\2\u0123\u0124\7g\2\2\u0124\u0125\7v\2\2"+
		"\u0125\u0126\7u\2\2\u0126\24\3\2\2\2\u0127\u0128\7o\2\2\u0128\u0129\7"+
		"g\2\2\u0129\u012a\7c\2\2\u012a\u012b\7p\2\2\u012b\u012c\7U\2\2\u012c\u012d"+
		"\7k\2\2\u012d\u012e\7|\2\2\u012e\u012f\7g\2\2\u012f\u0130\7K\2\2\u0130"+
		"\u0131\7p\2\2\u0131\u0132\7h\2\2\u0132\u0133\7q\2\2\u0133\u0134\7t\2\2"+
		"\u0134\u0135\7o\2\2\u0135\u0136\7c\2\2\u0136\u0137\7v\2\2\u0137\u0138"+
		"\7k\2\2\u0138\u0139\7q\2\2\u0139\u013a\7p\2\2\u013a\u013b\7U\2\2\u013b"+
		"\u013c\7r\2\2\u013c\u013d\7c\2\2\u013d\u013e\7e\2\2\u013e\u013f\7g\2\2"+
		"\u013f\u0140\7U\2\2\u0140\u0141\7v\2\2\u0141\u0142\7t\2\2\u0142\u0143"+
		"\7q\2\2\u0143\u0144\7p\2\2\u0144\u0145\7i\2\2\u0145\u0146\7U\2\2\u0146"+
		"\u0147\7g\2\2\u0147\u0148\7v\2\2\u0148\u0149\7u\2\2\u0149\u014a\7O\2\2"+
		"\u014a\u014b\7c\2\2\u014b\u014c\7z\2\2\u014c\26\3\2\2\2\u014d\u014e\7"+
		"o\2\2\u014e\u014f\7g\2\2\u014f\u0150\7c\2\2\u0150\u0151\7p\2\2\u0151\u0152"+
		"\7U\2\2\u0152\u0153\7k\2\2\u0153\u0154\7|\2\2\u0154\u0155\7g\2\2\u0155"+
		"\u0156\7K\2\2\u0156\u0157\7p\2\2\u0157\u0158\7h\2\2\u0158\u0159\7q\2\2"+
		"\u0159\u015a\7t\2\2\u015a\u015b\7o\2\2\u015b\u015c\7c\2\2\u015c\u015d"+
		"\7v\2\2\u015d\u015e\7k\2\2\u015e\u015f\7q\2\2\u015f\u0160\7p\2\2\u0160"+
		"\u0161\7U\2\2\u0161\u0162\7r\2\2\u0162\u0163\7c\2\2\u0163\u0164\7e\2\2"+
		"\u0164\u0165\7g\2\2\u0165\u0166\7Y\2\2\u0166\u0167\7g\2\2\u0167\u0168"+
		"\7c\2\2\u0168\u0169\7m\2\2\u0169\u016a\7U\2\2\u016a\u016b\7g\2\2\u016b"+
		"\u016c\7v\2\2\u016c\u016d\7u\2\2\u016d\30\3\2\2\2\u016e\u016f\7o\2\2\u016f"+
		"\u0170\7g\2\2\u0170\u0171\7c\2\2\u0171\u0172\7p\2\2\u0172\u0173\7U\2\2"+
		"\u0173\u0174\7k\2\2\u0174\u0175\7|\2\2\u0175\u0176\7g\2\2\u0176\u0177"+
		"\7K\2\2\u0177\u0178\7p\2\2\u0178\u0179\7h\2\2\u0179\u017a\7q\2\2\u017a"+
		"\u017b\7t\2\2\u017b\u017c\7o\2\2\u017c\u017d\7c\2\2\u017d\u017e\7v\2\2"+
		"\u017e\u017f\7k\2\2\u017f\u0180\7q\2\2\u0180\u0181\7p\2\2\u0181\u0182"+
		"\7U\2\2\u0182\u0183\7r\2\2\u0183\u0184\7c\2\2\u0184\u0185\7e\2\2\u0185"+
		"\u0186\7g\2\2\u0186\u0187\7Y\2\2\u0187\u0188\7g\2\2\u0188\u0189\7c\2\2"+
		"\u0189\u018a\7m\2\2\u018a\u018b\7U\2\2\u018b\u018c\7g\2\2\u018c\u018d"+
		"\7v\2\2\u018d\u018e\7u\2\2\u018e\u018f\7O\2\2\u018f\u0190\7c\2\2\u0190"+
		"\u0191\7z\2\2\u0191\32\3\2\2\2\u0192\u0193\7o\2\2\u0193\u0194\7g\2\2\u0194"+
		"\u0195\7c\2\2\u0195\u0196\7p\2\2\u0196\u0197\7U\2\2\u0197\u0198\7k\2\2"+
		"\u0198\u0199\7|\2\2\u0199\u019a\7g\2\2\u019a\u019b\7U\2\2\u019b\u019c"+
		"\7v\2\2\u019c\u019d\7c\2\2\u019d\u019e\7v\2\2\u019e\u019f\7g\2\2\u019f"+
		"\u01a0\7U\2\2\u01a0\u01a1\7r\2\2\u01a1\u01a2\7c\2\2\u01a2\u01a3\7e\2\2"+
		"\u01a3\u01a4\7g\2\2\u01a4\u01a5\7U\2\2\u01a5\u01a6\7v\2\2\u01a6\u01a7"+
		"\7t\2\2\u01a7\u01a8\7q\2\2\u01a8\u01a9\7p\2\2\u01a9\u01aa\7i\2\2\u01aa"+
		"\u01ab\7U\2\2\u01ab\u01ac\7g\2\2\u01ac\u01ad\7v\2\2\u01ad\u01ae\7u\2\2"+
		"\u01ae\34\3\2\2\2\u01af\u01b0\7o\2\2\u01b0\u01b1\7g\2\2\u01b1\u01b2\7"+
		"c\2\2\u01b2\u01b3\7p\2\2\u01b3\u01b4\7U\2\2\u01b4\u01b5\7k\2\2\u01b5\u01b6"+
		"\7|\2\2\u01b6\u01b7\7g\2\2\u01b7\u01b8\7U\2\2\u01b8\u01b9\7v\2\2\u01b9"+
		"\u01ba\7c\2\2\u01ba\u01bb\7v\2\2\u01bb\u01bc\7g\2\2\u01bc\u01bd\7U\2\2"+
		"\u01bd\u01be\7r\2\2\u01be\u01bf\7c\2\2\u01bf\u01c0\7e\2\2\u01c0\u01c1"+
		"\7g\2\2\u01c1\u01c2\7U\2\2\u01c2\u01c3\7v\2\2\u01c3\u01c4\7t\2\2\u01c4"+
		"\u01c5\7q\2\2\u01c5\u01c6\7p\2\2\u01c6\u01c7\7i\2\2\u01c7\u01c8\7U\2\2"+
		"\u01c8\u01c9\7g\2\2\u01c9\u01ca\7v\2\2\u01ca\u01cb\7u\2\2\u01cb\u01cc"+
		"\7O\2\2\u01cc\u01cd\7c\2\2\u01cd\u01ce\7z\2\2\u01ce\36\3\2\2\2\u01cf\u01d0"+
		"\7o\2\2\u01d0\u01d1\7g\2\2\u01d1\u01d2\7c\2\2\u01d2\u01d3\7p\2\2\u01d3"+
		"\u01d4\7U\2\2\u01d4\u01d5\7k\2\2\u01d5\u01d6\7|\2\2\u01d6\u01d7\7g\2\2"+
		"\u01d7\u01d8\7U\2\2\u01d8\u01d9\7v\2\2\u01d9\u01da\7c\2\2\u01da\u01db"+
		"\7v\2\2\u01db\u01dc\7g\2\2\u01dc\u01dd\7U\2\2\u01dd\u01de\7r\2\2\u01de"+
		"\u01df\7c\2\2\u01df\u01e0\7e\2\2\u01e0\u01e1\7g\2\2\u01e1\u01e2\7Y\2\2"+
		"\u01e2\u01e3\7g\2\2\u01e3\u01e4\7c\2\2\u01e4\u01e5\7m\2\2\u01e5\u01e6"+
		"\7U\2\2\u01e6\u01e7\7g\2\2\u01e7\u01e8\7v\2\2\u01e8\u01e9\7u\2\2\u01e9"+
		" \3\2\2\2\u01ea\u01eb\7o\2\2\u01eb\u01ec\7g\2\2\u01ec\u01ed\7c\2\2\u01ed"+
		"\u01ee\7p\2\2\u01ee\u01ef\7U\2\2\u01ef\u01f0\7k\2\2\u01f0\u01f1\7|\2\2"+
		"\u01f1\u01f2\7g\2\2\u01f2\u01f3\7U\2\2\u01f3\u01f4\7v\2\2\u01f4\u01f5"+
		"\7c\2\2\u01f5\u01f6\7v\2\2\u01f6\u01f7\7g\2\2\u01f7\u01f8\7U\2\2\u01f8"+
		"\u01f9\7r\2\2\u01f9\u01fa\7c\2\2\u01fa\u01fb\7e\2\2\u01fb\u01fc\7g\2\2"+
		"\u01fc\u01fd\7Y\2\2\u01fd\u01fe\7g\2\2\u01fe\u01ff\7c\2\2\u01ff\u0200"+
		"\7m\2\2\u0200\u0201\7U\2\2\u0201\u0202\7g\2\2\u0202\u0203\7v\2\2\u0203"+
		"\u0204\7u\2\2\u0204\u0205\7O\2\2\u0205\u0206\7c\2\2\u0206\u0207\7z\2\2"+
		"\u0207\"\3\2\2\2\u0208\u0209\7o\2\2\u0209\u020a\7g\2\2\u020a\u020b\7c"+
		"\2\2\u020b\u020c\7p\2\2\u020c\u020d\7T\2\2\u020d\u020e\7g\2\2\u020e\u020f"+
		"\7n\2\2\u020f\u0210\7c\2\2\u0210\u0211\7v\2\2\u0211\u0212\7k\2\2\u0212"+
		"\u0213\7x\2\2\u0213\u0214\7g\2\2\u0214\u0215\7U\2\2\u0215\u0216\7k\2\2"+
		"\u0216\u0217\7|\2\2\u0217\u0218\7g\2\2\u0218\u0219\7K\2\2\u0219\u021a"+
		"\7p\2\2\u021a\u021b\7h\2\2\u021b\u021c\7q\2\2\u021c\u021d\7t\2\2\u021d"+
		"\u021e\7o\2\2\u021e\u021f\7c\2\2\u021f\u0220\7v\2\2\u0220\u0221\7k\2\2"+
		"\u0221\u0222\7q\2\2\u0222\u0223\7p\2\2\u0223\u0224\7U\2\2\u0224\u0225"+
		"\7r\2\2\u0225\u0226\7c\2\2\u0226\u0227\7e\2\2\u0227\u0228\7g\2\2\u0228"+
		"\u0229\7U\2\2\u0229\u022a\7v\2\2\u022a\u022b\7t\2\2\u022b\u022c\7q\2\2"+
		"\u022c\u022d\7p\2\2\u022d\u022e\7i\2\2\u022e\u022f\7U\2\2\u022f\u0230"+
		"\7g\2\2\u0230\u0231\7v\2\2\u0231\u0232\7u\2\2\u0232$\3\2\2\2\u0233\u0234"+
		"\7o\2\2\u0234\u0235\7g\2\2\u0235\u0236\7c\2\2\u0236\u0237\7p\2\2\u0237"+
		"\u0238\7T\2\2\u0238\u0239\7g\2\2\u0239\u023a\7n\2\2\u023a\u023b\7c\2\2"+
		"\u023b\u023c\7v\2\2\u023c\u023d\7k\2\2\u023d\u023e\7x\2\2\u023e\u023f"+
		"\7g\2\2\u023f\u0240\7U\2\2\u0240\u0241\7k\2\2\u0241\u0242\7|\2\2\u0242"+
		"\u0243\7g\2\2\u0243\u0244\7K\2\2\u0244\u0245\7p\2\2\u0245\u0246\7h\2\2"+
		"\u0246\u0247\7q\2\2\u0247\u0248\7t\2\2\u0248\u0249\7o\2\2\u0249\u024a"+
		"\7c\2\2\u024a\u024b\7v\2\2\u024b\u024c\7k\2\2\u024c\u024d\7q\2\2\u024d"+
		"\u024e\7p\2\2\u024e\u024f\7U\2\2\u024f\u0250\7r\2\2\u0250\u0251\7c\2\2"+
		"\u0251\u0252\7e\2\2\u0252\u0253\7g\2\2\u0253\u0254\7U\2\2\u0254\u0255"+
		"\7v\2\2\u0255\u0256\7t\2\2\u0256\u0257\7q\2\2\u0257\u0258\7p\2\2\u0258"+
		"\u0259\7i\2\2\u0259\u025a\7U\2\2\u025a\u025b\7g\2\2\u025b\u025c\7v\2\2"+
		"\u025c\u025d\7u\2\2\u025d\u025e\7O\2\2\u025e\u025f\7c\2\2\u025f\u0260"+
		"\7z\2\2\u0260&\3\2\2\2\u0261\u0262\7o\2\2\u0262\u0263\7g\2\2\u0263\u0264"+
		"\7c\2\2\u0264\u0265\7p\2\2\u0265\u0266\7T\2\2\u0266\u0267\7g\2\2\u0267"+
		"\u0268\7n\2\2\u0268\u0269\7c\2\2\u0269\u026a\7v\2\2\u026a\u026b\7k\2\2"+
		"\u026b\u026c\7x\2\2\u026c\u026d\7g\2\2\u026d\u026e\7U\2\2\u026e\u026f"+
		"\7k\2\2\u026f\u0270\7|\2\2\u0270\u0271\7g\2\2\u0271\u0272\7K\2\2\u0272"+
		"\u0273\7p\2\2\u0273\u0274\7h\2\2\u0274\u0275\7q\2\2\u0275\u0276\7t\2\2"+
		"\u0276\u0277\7o\2\2\u0277\u0278\7c\2\2\u0278\u0279\7v\2\2\u0279\u027a"+
		"\7k\2\2\u027a\u027b\7q\2\2\u027b\u027c\7p\2\2\u027c\u027d\7U\2\2\u027d"+
		"\u027e\7r\2\2\u027e\u027f\7c\2\2\u027f\u0280\7e\2\2\u0280\u0281\7g\2\2"+
		"\u0281\u0282\7Y\2\2\u0282\u0283\7g\2\2\u0283\u0284\7c\2\2\u0284\u0285"+
		"\7m\2\2\u0285\u0286\7U\2\2\u0286\u0287\7g\2\2\u0287\u0288\7v\2\2\u0288"+
		"\u0289\7u\2\2\u0289(\3\2\2\2\u028a\u028b\7o\2\2\u028b\u028c\7g\2\2\u028c"+
		"\u028d\7c\2\2\u028d\u028e\7p\2\2\u028e\u028f\7T\2\2\u028f\u0290\7g\2\2"+
		"\u0290\u0291\7n\2\2\u0291\u0292\7c\2\2\u0292\u0293\7v\2\2\u0293\u0294"+
		"\7k\2\2\u0294\u0295\7x\2\2\u0295\u0296\7g\2\2\u0296\u0297\7U\2\2\u0297"+
		"\u0298\7k\2\2\u0298\u0299\7|\2\2\u0299\u029a\7g\2\2\u029a\u029b\7K\2\2"+
		"\u029b\u029c\7p\2\2\u029c\u029d\7h\2\2\u029d\u029e\7q\2\2\u029e\u029f"+
		"\7t\2\2\u029f\u02a0\7o\2\2\u02a0\u02a1\7c\2\2\u02a1\u02a2\7v\2\2\u02a2"+
		"\u02a3\7k\2\2\u02a3\u02a4\7q\2\2\u02a4\u02a5\7p\2\2\u02a5\u02a6\7U\2\2"+
		"\u02a6\u02a7\7r\2\2\u02a7\u02a8\7c\2\2\u02a8\u02a9\7e\2\2\u02a9\u02aa"+
		"\7g\2\2\u02aa\u02ab\7Y\2\2\u02ab\u02ac\7g\2\2\u02ac\u02ad\7c\2\2\u02ad"+
		"\u02ae\7m\2\2\u02ae\u02af\7U\2\2\u02af\u02b0\7g\2\2\u02b0\u02b1\7v\2\2"+
		"\u02b1\u02b2\7u\2\2\u02b2\u02b3\7O\2\2\u02b3\u02b4\7c\2\2\u02b4\u02b5"+
		"\7z\2\2\u02b5*\3\2\2\2\u02b6\u02b7\7o\2\2\u02b7\u02b8\7g\2\2\u02b8\u02b9"+
		"\7c\2\2\u02b9\u02ba\7p\2\2\u02ba\u02bb\7T\2\2\u02bb\u02bc\7g\2\2\u02bc"+
		"\u02bd\7n\2\2\u02bd\u02be\7c\2\2\u02be\u02bf\7v\2\2\u02bf\u02c0\7k\2\2"+
		"\u02c0\u02c1\7x\2\2\u02c1\u02c2\7g\2\2\u02c2\u02c3\7U\2\2\u02c3\u02c4"+
		"\7k\2\2\u02c4\u02c5\7|\2\2\u02c5\u02c6\7g\2\2\u02c6\u02c7\7U\2\2\u02c7"+
		"\u02c8\7v\2\2\u02c8\u02c9\7c\2\2\u02c9\u02ca\7v\2\2\u02ca\u02cb\7g\2\2"+
		"\u02cb\u02cc\7U\2\2\u02cc\u02cd\7r\2\2\u02cd\u02ce\7c\2\2\u02ce\u02cf"+
		"\7e\2\2\u02cf\u02d0\7g\2\2\u02d0\u02d1\7U\2\2\u02d1\u02d2\7v\2\2\u02d2"+
		"\u02d3\7t\2\2\u02d3\u02d4\7q\2\2\u02d4\u02d5\7p\2\2\u02d5\u02d6\7i\2\2"+
		"\u02d6\u02d7\7U\2\2\u02d7\u02d8\7g\2\2\u02d8\u02d9\7v\2\2\u02d9\u02da"+
		"\7u\2\2\u02da,\3\2\2\2\u02db\u02dc\7o\2\2\u02dc\u02dd\7g\2\2\u02dd\u02de"+
		"\7c\2\2\u02de\u02df\7p\2\2\u02df\u02e0\7T\2\2\u02e0\u02e1\7g\2\2\u02e1"+
		"\u02e2\7n\2\2\u02e2\u02e3\7c\2\2\u02e3\u02e4\7v\2\2\u02e4\u02e5\7k\2\2"+
		"\u02e5\u02e6\7x\2\2\u02e6\u02e7\7g\2\2\u02e7\u02e8\7U\2\2\u02e8\u02e9"+
		"\7k\2\2\u02e9\u02ea\7|\2\2\u02ea\u02eb\7g\2\2\u02eb\u02ec\7U\2\2\u02ec"+
		"\u02ed\7v\2\2\u02ed\u02ee\7c\2\2\u02ee\u02ef\7v\2\2\u02ef\u02f0\7g\2\2"+
		"\u02f0\u02f1\7U\2\2\u02f1\u02f2\7r\2\2\u02f2\u02f3\7c\2\2\u02f3\u02f4"+
		"\7e\2\2\u02f4\u02f5\7g\2\2\u02f5\u02f6\7U\2\2\u02f6\u02f7\7v\2\2\u02f7"+
		"\u02f8\7t\2\2\u02f8\u02f9\7q\2\2\u02f9\u02fa\7p\2\2\u02fa\u02fb\7i\2\2"+
		"\u02fb\u02fc\7U\2\2\u02fc\u02fd\7g\2\2\u02fd\u02fe\7v\2\2\u02fe\u02ff"+
		"\7u\2\2\u02ff\u0300\7O\2\2\u0300\u0301\7c\2\2\u0301\u0302\7z\2\2\u0302"+
		".\3\2\2\2\u0303\u0304\7o\2\2\u0304\u0305\7g\2\2\u0305\u0306\7c\2\2\u0306"+
		"\u0307\7p\2\2\u0307\u0308\7T\2\2\u0308\u0309\7g\2\2\u0309\u030a\7n\2\2"+
		"\u030a\u030b\7c\2\2\u030b\u030c\7v\2\2\u030c\u030d\7k\2\2\u030d\u030e"+
		"\7x\2\2\u030e\u030f\7g\2\2\u030f\u0310\7U\2\2\u0310\u0311\7k\2\2\u0311"+
		"\u0312\7|\2\2\u0312\u0313\7g\2\2\u0313\u0314\7U\2\2\u0314\u0315\7v\2\2"+
		"\u0315\u0316\7c\2\2\u0316\u0317\7v\2\2\u0317\u0318\7g\2\2\u0318\u0319"+
		"\7U\2\2\u0319\u031a\7r\2\2\u031a\u031b\7c\2\2\u031b\u031c\7e\2\2\u031c"+
		"\u031d\7g\2\2\u031d\u031e\7Y\2\2\u031e\u031f\7g\2\2\u031f\u0320\7c\2\2"+
		"\u0320\u0321\7m\2\2\u0321\u0322\7U\2\2\u0322\u0323\7g\2\2\u0323\u0324"+
		"\7v\2\2\u0324\u0325\7u\2\2\u0325\60\3\2\2\2\u0326\u0327\7o\2\2\u0327\u0328"+
		"\7g\2\2\u0328\u0329\7c\2\2\u0329\u032a\7p\2\2\u032a\u032b\7T\2\2\u032b"+
		"\u032c\7g\2\2\u032c\u032d\7n\2\2\u032d\u032e\7c\2\2\u032e\u032f\7v\2\2"+
		"\u032f\u0330\7k\2\2\u0330\u0331\7x\2\2\u0331\u0332\7g\2\2\u0332\u0333"+
		"\7U\2\2\u0333\u0334\7k\2\2\u0334\u0335\7|\2\2\u0335\u0336\7g\2\2\u0336"+
		"\u0337\7U\2\2\u0337\u0338\7v\2\2\u0338\u0339\7c\2\2\u0339\u033a\7v\2\2"+
		"\u033a\u033b\7g\2\2\u033b\u033c\7U\2\2\u033c\u033d\7r\2\2\u033d\u033e"+
		"\7c\2\2\u033e\u033f\7e\2\2\u033f\u0340\7g\2\2\u0340\u0341\7Y\2\2\u0341"+
		"\u0342\7g\2\2\u0342\u0343\7c\2\2\u0343\u0344\7m\2\2\u0344\u0345\7U\2\2"+
		"\u0345\u0346\7g\2\2\u0346\u0347\7v\2\2\u0347\u0348\7u\2\2\u0348\u0349"+
		"\7O\2\2\u0349\u034a\7c\2\2\u034a\u034b\7z\2\2\u034b\62\3\2\2\2\u034c\u034d"+
		"\7v\2\2\u034d\u034e\7t\2\2\u034e\u034f\7w\2\2\u034f\u0350\7g\2\2\u0350"+
		"\64\3\2\2\2\u0351\u0352\7k\2\2\u0352\u0353\7p\2\2\u0353\u0354\7g\2\2\u0354"+
		"\u0355\7h\2\2\u0355\u0356\7h\2\2\u0356\u0357\7k\2\2\u0357\u0358\7e\2\2"+
		"\u0358\u0359\7k\2\2\u0359\u035a\7g\2\2\u035a\u035b\7p\2\2\u035b\u035c"+
		"\7v\2\2\u035c\66\3\2\2\2\u035d\u035e\7g\2\2\u035e\u035f\7h\2\2\u035f\u0360"+
		"\7h\2\2\u0360\u0361\7k\2\2\u0361\u0362\7e\2\2\u0362\u0363\7k\2\2\u0363"+
		"\u0364\7g\2\2\u0364\u0365\7p\2\2\u0365\u0366\7v\2\2\u0366\u0367\7/\2\2"+
		"\u0367\u0368\7\63\2\2\u0368\u0369\7/\2\2\u0369\u036a\7n\2\2\u036a\u036b"+
		"\7g\2\2\u036b\u036c\7x\2\2\u036c\u036d\7g\2\2\u036d\u036e\7n\2\2\u036e"+
		"8\3\2\2\2\u036f\u0370\7g\2\2\u0370\u0371\7h\2\2\u0371\u0372\7h\2\2\u0372"+
		"\u0373\7k\2\2\u0373\u0374\7e\2\2\u0374\u0375\7k\2\2\u0375\u0376\7g\2\2"+
		"\u0376\u0377\7p\2\2\u0377\u0378\7v\2\2\u0378\u0379\7/\2\2\u0379\u037a"+
		"\7\64\2\2\u037a\u037b\7/\2\2\u037b\u037c\7n\2\2\u037c\u037d\7g\2\2\u037d"+
		"\u037e\7x\2\2\u037e\u037f\7g\2\2\u037f\u0380\7n\2\2\u0380:\3\2\2\2\u0381"+
		"\u0382\7q\2\2\u0382\u0383\7t\2\2\u0383<\3\2\2\2\u0384\u0385\7c\2\2\u0385"+
		"\u0386\7p\2\2\u0386\u0387\7f\2\2\u0387>\3\2\2\2\u0388\u0389\7p\2\2\u0389"+
		"\u038a\7q\2\2\u038a\u038b\7v\2\2\u038b@\3\2\2\2\u038c\u038d\7*\2\2\u038d"+
		"B\3\2\2\2\u038e\u038f\7+\2\2\u038fD\3\2\2\2\u0390\u0391\7.\2\2\u0391F"+
		"\3\2\2\2\u0392\u0393\7<\2\2\u0393H\3\2\2\2\u0394\u0395\7=\2\2\u0395J\3"+
		"\2\2\2\u0396\u0397\7\"\2\2\u0397\u0398\3\2\2\2\u0398\u0399\b&\2\2\u0399"+
		"L\3\2\2\2\u039a\u039b\7\13\2\2\u039b\u039c\3\2\2\2\u039c\u039d\b\'\2\2"+
		"\u039dN\3\2\2\2\u039e\u03a0\7\17\2\2\u039f\u039e\3\2\2\2\u039f\u03a0\3"+
		"\2\2\2\u03a0\u03a1\3\2\2\2\u03a1\u03a2\7\f\2\2\u03a2\u03a3\3\2\2\2\u03a3"+
		"\u03a4\b(\2\2\u03a4P\3\2\2\2\u03a5\u03a6\t\2\2\2\u03a6R\3\2\2\2\u03a7"+
		"\u03a8\4\62;\2\u03a8T\3\2\2\2\u03a9\u03aa\7a\2\2\u03aaV\3\2\2\2\u03ab"+
		"\u03ac\7/\2\2\u03acX\3\2\2\2\u03ad\u03ae\7\60\2\2\u03aeZ\3\2\2\2\u03af"+
		"\u03b1\5S*\2\u03b0\u03af\3\2\2\2\u03b1\u03b2\3\2\2\2\u03b2\u03b0\3\2\2"+
		"\2\u03b2\u03b3\3\2\2\2\u03b3\u03b4\3\2\2\2\u03b4\u03b8\5Y-\2\u03b5\u03b7"+
		"\5S*\2\u03b6\u03b5\3\2\2\2\u03b7\u03ba\3\2\2\2\u03b8\u03b6\3\2\2\2\u03b8"+
		"\u03b9\3\2\2\2\u03b9\u03c2\3\2\2\2\u03ba\u03b8\3\2\2\2\u03bb\u03bd\5Y"+
		"-\2\u03bc\u03be\5S*\2\u03bd\u03bc\3\2\2\2\u03be\u03bf\3\2\2\2\u03bf\u03bd"+
		"\3\2\2\2\u03bf\u03c0\3\2\2\2\u03c0\u03c2\3\2\2\2\u03c1\u03b0\3\2\2\2\u03c1"+
		"\u03bb\3\2\2\2\u03c2\\\3\2\2\2\u03c3\u03c5\5S*\2\u03c4\u03c3\3\2\2\2\u03c5"+
		"\u03c6\3\2\2\2\u03c6\u03c4\3\2\2\2\u03c6\u03c7\3\2\2\2\u03c7^\3\2\2\2"+
		"\u03c8\u03cb\5U+\2\u03c9\u03cb\5Q)\2\u03ca\u03c8\3\2\2\2\u03ca\u03c9\3"+
		"\2\2\2\u03cb\u03d3\3\2\2\2\u03cc\u03d2\5U+\2\u03cd\u03d2\5Q)\2\u03ce\u03d2"+
		"\5S*\2\u03cf\u03d2\5W,\2\u03d0\u03d2\5Y-\2\u03d1\u03cc\3\2\2\2\u03d1\u03cd"+
		"\3\2\2\2\u03d1\u03ce\3\2\2\2\u03d1\u03cf\3\2\2\2\u03d1\u03d0\3\2\2\2\u03d2"+
		"\u03d5\3\2\2\2\u03d3\u03d1\3\2\2\2\u03d3\u03d4\3\2\2\2\u03d4`\3\2\2\2"+
		"\u03d5\u03d3\3\2\2\2\u03d6\u03d7\7\61\2\2\u03d7\u03d8\7\61\2\2\u03d8\u03dc"+
		"\3\2\2\2\u03d9\u03db\13\2\2\2\u03da\u03d9\3\2\2\2\u03db\u03de\3\2\2\2"+
		"\u03dc\u03dd\3\2\2\2\u03dc\u03da\3\2\2\2\u03dd\u03df\3\2\2\2\u03de\u03dc"+
		"\3\2\2\2\u03df\u03e0\5O(\2\u03e0\u03e1\3\2\2\2\u03e1\u03e2\b\61\2\2\u03e2"+
		"b\3\2\2\2\u03e3\u03e4\7\61\2\2\u03e4\u03e5\7,\2\2\u03e5\u03e9\3\2\2\2"+
		"\u03e6\u03e8\13\2\2\2\u03e7\u03e6\3\2\2\2\u03e8\u03eb\3\2\2\2\u03e9\u03ea"+
		"\3\2\2\2\u03e9\u03e7\3\2\2\2\u03ea\u03ec\3\2\2\2\u03eb\u03e9\3\2\2\2\u03ec"+
		"\u03ed\7,\2\2\u03ed\u03ee\7\61\2\2\u03ee\u03ef\3\2\2\2\u03ef\u03f0\b\62"+
		"\2\2\u03f0d\3\2\2\2\16\2\u039f\u03b2\u03b8\u03bf\u03c1\u03c6\u03ca\u03d1"+
		"\u03d3\u03dc\u03e9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}