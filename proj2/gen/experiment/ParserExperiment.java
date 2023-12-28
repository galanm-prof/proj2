// Generated from C:/Investigacion/prototypes/proj2/src/experiment\ParserExperiment.g4 by ANTLR 4.8
package experiment;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ParserExperiment extends Parser {
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
	public static final int
		RULE_experiment = 0, RULE_repositories = 1, RULE_requests = 2, RULE_reqs = 3, 
		RULE_repository = 4, RULE_searching = 5, RULE_predicate = 6, RULE_primitive_predicate = 7, 
		RULE_expression = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"experiment", "repositories", "requests", "reqs", "repository", "searching", 
			"predicate", "primitive_predicate", "expression"
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

	@Override
	public String getGrammarFileName() { return "ParserExperiment.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ParserExperiment(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ExperimentContext extends ParserRuleContext {
		public RepositoriesContext repositories() {
			return getRuleContext(RepositoriesContext.class,0);
		}
		public RequestsContext requests() {
			return getRuleContext(RequestsContext.class,0);
		}
		public RepositoryContext repository() {
			return getRuleContext(RepositoryContext.class,0);
		}
		public SearchingContext searching() {
			return getRuleContext(SearchingContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ParserExperiment.EOF, 0); }
		public ExperimentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_experiment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserExperimentListener ) ((ParserExperimentListener)listener).enterExperiment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserExperimentListener ) ((ParserExperimentListener)listener).exitExperiment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserExperimentVisitor ) return ((ParserExperimentVisitor<? extends T>)visitor).visitExperiment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExperimentContext experiment() throws RecognitionException {
		ExperimentContext _localctx = new ExperimentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_experiment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			repositories();
			setState(19);
			requests();
			setState(20);
			repository();
			setState(21);
			searching();
			setState(22);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepositoriesContext extends ParserRuleContext {
		public TerminalNode REPOSITORIES() { return getToken(ParserExperiment.REPOSITORIES, 0); }
		public TerminalNode COLON() { return getToken(ParserExperiment.COLON, 0); }
		public TerminalNode INT() { return getToken(ParserExperiment.INT, 0); }
		public TerminalNode SEMICOLON() { return getToken(ParserExperiment.SEMICOLON, 0); }
		public RepositoriesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repositories; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserExperimentListener ) ((ParserExperimentListener)listener).enterRepositories(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserExperimentListener ) ((ParserExperimentListener)listener).exitRepositories(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserExperimentVisitor ) return ((ParserExperimentVisitor<? extends T>)visitor).visitRepositories(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepositoriesContext repositories() throws RecognitionException {
		RepositoriesContext _localctx = new RepositoriesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_repositories);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(REPOSITORIES);
			setState(25);
			match(COLON);
			setState(26);
			match(INT);
			setState(27);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RequestsContext extends ParserRuleContext {
		public TerminalNode REQUESTS() { return getToken(ParserExperiment.REQUESTS, 0); }
		public TerminalNode COLON() { return getToken(ParserExperiment.COLON, 0); }
		public ReqsContext reqs() {
			return getRuleContext(ReqsContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ParserExperiment.SEMICOLON, 0); }
		public RequestsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requests; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserExperimentListener ) ((ParserExperimentListener)listener).enterRequests(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserExperimentListener ) ((ParserExperimentListener)listener).exitRequests(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserExperimentVisitor ) return ((ParserExperimentVisitor<? extends T>)visitor).visitRequests(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequestsContext requests() throws RecognitionException {
		RequestsContext _localctx = new RequestsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_requests);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(REQUESTS);
			setState(30);
			match(COLON);
			setState(31);
			reqs();
			setState(32);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReqsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ParserExperiment.ID, 0); }
		public TerminalNode COMMA() { return getToken(ParserExperiment.COMMA, 0); }
		public ReqsContext reqs() {
			return getRuleContext(ReqsContext.class,0);
		}
		public ReqsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reqs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserExperimentListener ) ((ParserExperimentListener)listener).enterReqs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserExperimentListener ) ((ParserExperimentListener)listener).exitReqs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserExperimentVisitor ) return ((ParserExperimentVisitor<? extends T>)visitor).visitReqs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReqsContext reqs() throws RecognitionException {
		ReqsContext _localctx = new ReqsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_reqs);
		try {
			setState(38);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				match(ID);
				setState(35);
				match(COMMA);
				setState(36);
				reqs();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepositoryContext extends ParserRuleContext {
		public TerminalNode REPOSITORY() { return getToken(ParserExperiment.REPOSITORY, 0); }
		public TerminalNode COLON() { return getToken(ParserExperiment.COLON, 0); }
		public TerminalNode INT() { return getToken(ParserExperiment.INT, 0); }
		public TerminalNode COMMA() { return getToken(ParserExperiment.COMMA, 0); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ParserExperiment.SEMICOLON, 0); }
		public RepositoryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repository; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserExperimentListener ) ((ParserExperimentListener)listener).enterRepository(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserExperimentListener ) ((ParserExperimentListener)listener).exitRepository(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserExperimentVisitor ) return ((ParserExperimentVisitor<? extends T>)visitor).visitRepository(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepositoryContext repository() throws RecognitionException {
		RepositoryContext _localctx = new RepositoryContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_repository);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(REPOSITORY);
			setState(41);
			match(COLON);
			setState(42);
			match(INT);
			setState(43);
			match(COMMA);
			setState(44);
			predicate();
			setState(45);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SearchingContext extends ParserRuleContext {
		public TerminalNode SEARCHING() { return getToken(ParserExperiment.SEARCHING, 0); }
		public TerminalNode COLON() { return getToken(ParserExperiment.COLON, 0); }
		public TerminalNode SEMICOLON() { return getToken(ParserExperiment.SEMICOLON, 0); }
		public TerminalNode INEFFICIENT() { return getToken(ParserExperiment.INEFFICIENT, 0); }
		public TerminalNode EFFICIENTLEVEL1() { return getToken(ParserExperiment.EFFICIENTLEVEL1, 0); }
		public TerminalNode EFFICIENTLEVEL2() { return getToken(ParserExperiment.EFFICIENTLEVEL2, 0); }
		public SearchingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_searching; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserExperimentListener ) ((ParserExperimentListener)listener).enterSearching(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserExperimentListener ) ((ParserExperimentListener)listener).exitSearching(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserExperimentVisitor ) return ((ParserExperimentVisitor<? extends T>)visitor).visitSearching(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SearchingContext searching() throws RecognitionException {
		SearchingContext _localctx = new SearchingContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_searching);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(SEARCHING);
			setState(48);
			match(COLON);
			setState(49);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INEFFICIENT) | (1L << EFFICIENTLEVEL1) | (1L << EFFICIENTLEVEL2))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(50);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserExperimentListener ) ((ParserExperimentListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserExperimentListener ) ((ParserExperimentListener)listener).exitPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserExperimentVisitor ) return ((ParserExperimentVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Primitive_predicateContext extends ParserRuleContext {
		public TerminalNode NUMBERINFORMATIONSPACESTRONGSETS() { return getToken(ParserExperiment.NUMBERINFORMATIONSPACESTRONGSETS, 0); }
		public TerminalNode OP() { return getToken(ParserExperiment.OP, 0); }
		public List<TerminalNode> INT() { return getTokens(ParserExperiment.INT); }
		public TerminalNode INT(int i) {
			return getToken(ParserExperiment.INT, i);
		}
		public TerminalNode COMMA() { return getToken(ParserExperiment.COMMA, 0); }
		public TerminalNode CP() { return getToken(ParserExperiment.CP, 0); }
		public TerminalNode NUMBERINFORMATIONSPACEWEAKSETS() { return getToken(ParserExperiment.NUMBERINFORMATIONSPACEWEAKSETS, 0); }
		public TerminalNode NUMBERSTATESPACESTRONGSETS() { return getToken(ParserExperiment.NUMBERSTATESPACESTRONGSETS, 0); }
		public TerminalNode NUMBERSTATESPACEWEAKSETS() { return getToken(ParserExperiment.NUMBERSTATESPACEWEAKSETS, 0); }
		public TerminalNode MEANSIZEINFORMATIONSPACESTRONGSETS() { return getToken(ParserExperiment.MEANSIZEINFORMATIONSPACESTRONGSETS, 0); }
		public TerminalNode DBL() { return getToken(ParserExperiment.DBL, 0); }
		public TerminalNode MEANSIZEINFORMATIONSPACESTRONGSETSMAX() { return getToken(ParserExperiment.MEANSIZEINFORMATIONSPACESTRONGSETSMAX, 0); }
		public TerminalNode MEANSIZEINFORMATIONSPACEWEAKSETS() { return getToken(ParserExperiment.MEANSIZEINFORMATIONSPACEWEAKSETS, 0); }
		public TerminalNode MEANSIZEINFORMATIONSPACEWEAKSETSMAX() { return getToken(ParserExperiment.MEANSIZEINFORMATIONSPACEWEAKSETSMAX, 0); }
		public TerminalNode MEANSIZESTATESPACESTRONGSETS() { return getToken(ParserExperiment.MEANSIZESTATESPACESTRONGSETS, 0); }
		public TerminalNode MEANSIZESTATESPACESTRONGSETSMAX() { return getToken(ParserExperiment.MEANSIZESTATESPACESTRONGSETSMAX, 0); }
		public TerminalNode MEANSIZESTATESPACEWEAKSETS() { return getToken(ParserExperiment.MEANSIZESTATESPACEWEAKSETS, 0); }
		public TerminalNode MEANSIZESTATESPACEWEAKSETSMAX() { return getToken(ParserExperiment.MEANSIZESTATESPACEWEAKSETSMAX, 0); }
		public TerminalNode MEANRELATIVESIZEINFORMATIONSPACESTRONGSETS() { return getToken(ParserExperiment.MEANRELATIVESIZEINFORMATIONSPACESTRONGSETS, 0); }
		public TerminalNode MEANRELATIVESIZEINFORMATIONSPACESTRONGSETSMAX() { return getToken(ParserExperiment.MEANRELATIVESIZEINFORMATIONSPACESTRONGSETSMAX, 0); }
		public TerminalNode MEANRELATIVESIZEINFORMATIONSPACEWEAKSETS() { return getToken(ParserExperiment.MEANRELATIVESIZEINFORMATIONSPACEWEAKSETS, 0); }
		public TerminalNode MEANRELATIVESIZEINFORMATIONSPACEWEAKSETSMAX() { return getToken(ParserExperiment.MEANRELATIVESIZEINFORMATIONSPACEWEAKSETSMAX, 0); }
		public TerminalNode MEANRELATIVESIZESTATESPACESTRONGSETS() { return getToken(ParserExperiment.MEANRELATIVESIZESTATESPACESTRONGSETS, 0); }
		public TerminalNode MEANRELATIVESIZESTATESPACESTRONGSETSMAX() { return getToken(ParserExperiment.MEANRELATIVESIZESTATESPACESTRONGSETSMAX, 0); }
		public TerminalNode MEANRELATIVESIZESTATESPACEWEAKSETS() { return getToken(ParserExperiment.MEANRELATIVESIZESTATESPACEWEAKSETS, 0); }
		public TerminalNode MEANRELATIVESIZESTATESPACEWEAKSETSMAX() { return getToken(ParserExperiment.MEANRELATIVESIZESTATESPACEWEAKSETSMAX, 0); }
		public TerminalNode TRUE() { return getToken(ParserExperiment.TRUE, 0); }
		public Primitive_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserExperimentListener ) ((ParserExperimentListener)listener).enterPrimitive_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserExperimentListener ) ((ParserExperimentListener)listener).exitPrimitive_predicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserExperimentVisitor ) return ((ParserExperimentVisitor<? extends T>)visitor).visitPrimitive_predicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primitive_predicateContext primitive_predicate() throws RecognitionException {
		Primitive_predicateContext _localctx = new Primitive_predicateContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_primitive_predicate);
		try {
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBERINFORMATIONSPACESTRONGSETS:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(NUMBERINFORMATIONSPACESTRONGSETS);
				setState(55);
				match(OP);
				setState(56);
				match(INT);
				setState(57);
				match(COMMA);
				setState(58);
				match(INT);
				setState(59);
				match(CP);
				}
				break;
			case NUMBERINFORMATIONSPACEWEAKSETS:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(NUMBERINFORMATIONSPACEWEAKSETS);
				setState(61);
				match(OP);
				setState(62);
				match(INT);
				setState(63);
				match(COMMA);
				setState(64);
				match(INT);
				setState(65);
				match(CP);
				}
				break;
			case NUMBERSTATESPACESTRONGSETS:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				match(NUMBERSTATESPACESTRONGSETS);
				setState(67);
				match(OP);
				setState(68);
				match(INT);
				setState(69);
				match(COMMA);
				setState(70);
				match(INT);
				setState(71);
				match(CP);
				}
				break;
			case NUMBERSTATESPACEWEAKSETS:
				enterOuterAlt(_localctx, 4);
				{
				setState(72);
				match(NUMBERSTATESPACEWEAKSETS);
				setState(73);
				match(OP);
				setState(74);
				match(INT);
				setState(75);
				match(COMMA);
				setState(76);
				match(INT);
				setState(77);
				match(CP);
				}
				break;
			case MEANSIZEINFORMATIONSPACESTRONGSETS:
				enterOuterAlt(_localctx, 5);
				{
				setState(78);
				match(MEANSIZEINFORMATIONSPACESTRONGSETS);
				setState(79);
				match(OP);
				setState(80);
				match(DBL);
				setState(81);
				match(CP);
				}
				break;
			case MEANSIZEINFORMATIONSPACESTRONGSETSMAX:
				enterOuterAlt(_localctx, 6);
				{
				setState(82);
				match(MEANSIZEINFORMATIONSPACESTRONGSETSMAX);
				setState(83);
				match(OP);
				setState(84);
				match(DBL);
				setState(85);
				match(CP);
				}
				break;
			case MEANSIZEINFORMATIONSPACEWEAKSETS:
				enterOuterAlt(_localctx, 7);
				{
				setState(86);
				match(MEANSIZEINFORMATIONSPACEWEAKSETS);
				setState(87);
				match(OP);
				setState(88);
				match(DBL);
				setState(89);
				match(CP);
				}
				break;
			case MEANSIZEINFORMATIONSPACEWEAKSETSMAX:
				enterOuterAlt(_localctx, 8);
				{
				setState(90);
				match(MEANSIZEINFORMATIONSPACEWEAKSETSMAX);
				setState(91);
				match(OP);
				setState(92);
				match(DBL);
				setState(93);
				match(CP);
				}
				break;
			case MEANSIZESTATESPACESTRONGSETS:
				enterOuterAlt(_localctx, 9);
				{
				setState(94);
				match(MEANSIZESTATESPACESTRONGSETS);
				setState(95);
				match(OP);
				setState(96);
				match(DBL);
				setState(97);
				match(CP);
				}
				break;
			case MEANSIZESTATESPACESTRONGSETSMAX:
				enterOuterAlt(_localctx, 10);
				{
				setState(98);
				match(MEANSIZESTATESPACESTRONGSETSMAX);
				setState(99);
				match(OP);
				setState(100);
				match(DBL);
				setState(101);
				match(CP);
				}
				break;
			case MEANSIZESTATESPACEWEAKSETS:
				enterOuterAlt(_localctx, 11);
				{
				setState(102);
				match(MEANSIZESTATESPACEWEAKSETS);
				setState(103);
				match(OP);
				setState(104);
				match(DBL);
				setState(105);
				match(CP);
				}
				break;
			case MEANSIZESTATESPACEWEAKSETSMAX:
				enterOuterAlt(_localctx, 12);
				{
				setState(106);
				match(MEANSIZESTATESPACEWEAKSETSMAX);
				setState(107);
				match(OP);
				setState(108);
				match(DBL);
				setState(109);
				match(CP);
				}
				break;
			case MEANRELATIVESIZEINFORMATIONSPACESTRONGSETS:
				enterOuterAlt(_localctx, 13);
				{
				setState(110);
				match(MEANRELATIVESIZEINFORMATIONSPACESTRONGSETS);
				setState(111);
				match(OP);
				setState(112);
				match(DBL);
				setState(113);
				match(CP);
				}
				break;
			case MEANRELATIVESIZEINFORMATIONSPACESTRONGSETSMAX:
				enterOuterAlt(_localctx, 14);
				{
				setState(114);
				match(MEANRELATIVESIZEINFORMATIONSPACESTRONGSETSMAX);
				setState(115);
				match(OP);
				setState(116);
				match(DBL);
				setState(117);
				match(CP);
				}
				break;
			case MEANRELATIVESIZEINFORMATIONSPACEWEAKSETS:
				enterOuterAlt(_localctx, 15);
				{
				setState(118);
				match(MEANRELATIVESIZEINFORMATIONSPACEWEAKSETS);
				setState(119);
				match(OP);
				setState(120);
				match(DBL);
				setState(121);
				match(CP);
				}
				break;
			case MEANRELATIVESIZEINFORMATIONSPACEWEAKSETSMAX:
				enterOuterAlt(_localctx, 16);
				{
				setState(122);
				match(MEANRELATIVESIZEINFORMATIONSPACEWEAKSETSMAX);
				setState(123);
				match(OP);
				setState(124);
				match(DBL);
				setState(125);
				match(CP);
				}
				break;
			case MEANRELATIVESIZESTATESPACESTRONGSETS:
				enterOuterAlt(_localctx, 17);
				{
				setState(126);
				match(MEANRELATIVESIZESTATESPACESTRONGSETS);
				setState(127);
				match(OP);
				setState(128);
				match(DBL);
				setState(129);
				match(CP);
				}
				break;
			case MEANRELATIVESIZESTATESPACESTRONGSETSMAX:
				enterOuterAlt(_localctx, 18);
				{
				setState(130);
				match(MEANRELATIVESIZESTATESPACESTRONGSETSMAX);
				setState(131);
				match(OP);
				setState(132);
				match(DBL);
				setState(133);
				match(CP);
				}
				break;
			case MEANRELATIVESIZESTATESPACEWEAKSETS:
				enterOuterAlt(_localctx, 19);
				{
				setState(134);
				match(MEANRELATIVESIZESTATESPACEWEAKSETS);
				setState(135);
				match(OP);
				setState(136);
				match(DBL);
				setState(137);
				match(CP);
				}
				break;
			case MEANRELATIVESIZESTATESPACEWEAKSETSMAX:
				enterOuterAlt(_localctx, 20);
				{
				setState(138);
				match(MEANRELATIVESIZESTATESPACEWEAKSETSMAX);
				setState(139);
				match(OP);
				setState(140);
				match(DBL);
				setState(141);
				match(CP);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 21);
				{
				setState(142);
				match(TRUE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode NEG() { return getToken(ParserExperiment.NEG, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OP() { return getToken(ParserExperiment.OP, 0); }
		public TerminalNode CP() { return getToken(ParserExperiment.CP, 0); }
		public Primitive_predicateContext primitive_predicate() {
			return getRuleContext(Primitive_predicateContext.class,0);
		}
		public TerminalNode AND() { return getToken(ParserExperiment.AND, 0); }
		public TerminalNode OR() { return getToken(ParserExperiment.OR, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserExperimentListener ) ((ParserExperimentListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserExperimentListener ) ((ParserExperimentListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserExperimentVisitor ) return ((ParserExperimentVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEG:
				{
				setState(146);
				match(NEG);
				setState(147);
				expression(3);
				}
				break;
			case OP:
				{
				setState(148);
				match(OP);
				setState(149);
				expression(0);
				setState(150);
				match(CP);
				}
				break;
			case NUMBERINFORMATIONSPACESTRONGSETS:
			case NUMBERINFORMATIONSPACEWEAKSETS:
			case NUMBERSTATESPACESTRONGSETS:
			case NUMBERSTATESPACEWEAKSETS:
			case MEANSIZEINFORMATIONSPACESTRONGSETS:
			case MEANSIZEINFORMATIONSPACESTRONGSETSMAX:
			case MEANSIZEINFORMATIONSPACEWEAKSETS:
			case MEANSIZEINFORMATIONSPACEWEAKSETSMAX:
			case MEANSIZESTATESPACESTRONGSETS:
			case MEANSIZESTATESPACESTRONGSETSMAX:
			case MEANSIZESTATESPACEWEAKSETS:
			case MEANSIZESTATESPACEWEAKSETSMAX:
			case MEANRELATIVESIZEINFORMATIONSPACESTRONGSETS:
			case MEANRELATIVESIZEINFORMATIONSPACESTRONGSETSMAX:
			case MEANRELATIVESIZEINFORMATIONSPACEWEAKSETS:
			case MEANRELATIVESIZEINFORMATIONSPACEWEAKSETSMAX:
			case MEANRELATIVESIZESTATESPACESTRONGSETS:
			case MEANRELATIVESIZESTATESPACESTRONGSETSMAX:
			case MEANRELATIVESIZESTATESPACEWEAKSETS:
			case MEANRELATIVESIZESTATESPACEWEAKSETSMAX:
			case TRUE:
				{
				setState(152);
				primitive_predicate();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(161);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(155);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(156);
						match(AND);
						setState(157);
						expression(6);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(158);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(159);
						match(OR);
						setState(160);
						expression(5);
						}
						break;
					}
					} 
				}
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u00a9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\5\5)\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\5\t\u0092\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u009c\n\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\7\n\u00a4\n\n\f\n\16\n\u00a7\13\n\3\n\2\3\22\13\2"+
		"\4\6\b\n\f\16\20\22\2\3\3\2\34\36\2\u00b8\2\24\3\2\2\2\4\32\3\2\2\2\6"+
		"\37\3\2\2\2\b(\3\2\2\2\n*\3\2\2\2\f\61\3\2\2\2\16\66\3\2\2\2\20\u0091"+
		"\3\2\2\2\22\u009b\3\2\2\2\24\25\5\4\3\2\25\26\5\6\4\2\26\27\5\n\6\2\27"+
		"\30\5\f\7\2\30\31\7\2\2\3\31\3\3\2\2\2\32\33\7\3\2\2\33\34\7%\2\2\34\35"+
		"\7.\2\2\35\36\7&\2\2\36\5\3\2\2\2\37 \7\4\2\2 !\7%\2\2!\"\5\b\5\2\"#\7"+
		"&\2\2#\7\3\2\2\2$%\7/\2\2%&\7$\2\2&)\5\b\5\2\')\7/\2\2($\3\2\2\2(\'\3"+
		"\2\2\2)\t\3\2\2\2*+\7\5\2\2+,\7%\2\2,-\7.\2\2-.\7$\2\2./\5\16\b\2/\60"+
		"\7&\2\2\60\13\3\2\2\2\61\62\7\6\2\2\62\63\7%\2\2\63\64\t\2\2\2\64\65\7"+
		"&\2\2\65\r\3\2\2\2\66\67\5\22\n\2\67\17\3\2\2\289\7\7\2\29:\7\"\2\2:;"+
		"\7.\2\2;<\7$\2\2<=\7.\2\2=\u0092\7#\2\2>?\7\b\2\2?@\7\"\2\2@A\7.\2\2A"+
		"B\7$\2\2BC\7.\2\2C\u0092\7#\2\2DE\7\t\2\2EF\7\"\2\2FG\7.\2\2GH\7$\2\2"+
		"HI\7.\2\2I\u0092\7#\2\2JK\7\n\2\2KL\7\"\2\2LM\7.\2\2MN\7$\2\2NO\7.\2\2"+
		"O\u0092\7#\2\2PQ\7\13\2\2QR\7\"\2\2RS\7-\2\2S\u0092\7#\2\2TU\7\f\2\2U"+
		"V\7\"\2\2VW\7-\2\2W\u0092\7#\2\2XY\7\r\2\2YZ\7\"\2\2Z[\7-\2\2[\u0092\7"+
		"#\2\2\\]\7\16\2\2]^\7\"\2\2^_\7-\2\2_\u0092\7#\2\2`a\7\17\2\2ab\7\"\2"+
		"\2bc\7-\2\2c\u0092\7#\2\2de\7\20\2\2ef\7\"\2\2fg\7-\2\2g\u0092\7#\2\2"+
		"hi\7\21\2\2ij\7\"\2\2jk\7-\2\2k\u0092\7#\2\2lm\7\22\2\2mn\7\"\2\2no\7"+
		"-\2\2o\u0092\7#\2\2pq\7\23\2\2qr\7\"\2\2rs\7-\2\2s\u0092\7#\2\2tu\7\24"+
		"\2\2uv\7\"\2\2vw\7-\2\2w\u0092\7#\2\2xy\7\25\2\2yz\7\"\2\2z{\7-\2\2{\u0092"+
		"\7#\2\2|}\7\26\2\2}~\7\"\2\2~\177\7-\2\2\177\u0092\7#\2\2\u0080\u0081"+
		"\7\27\2\2\u0081\u0082\7\"\2\2\u0082\u0083\7-\2\2\u0083\u0092\7#\2\2\u0084"+
		"\u0085\7\30\2\2\u0085\u0086\7\"\2\2\u0086\u0087\7-\2\2\u0087\u0092\7#"+
		"\2\2\u0088\u0089\7\31\2\2\u0089\u008a\7\"\2\2\u008a\u008b\7-\2\2\u008b"+
		"\u0092\7#\2\2\u008c\u008d\7\32\2\2\u008d\u008e\7\"\2\2\u008e\u008f\7-"+
		"\2\2\u008f\u0092\7#\2\2\u0090\u0092\7\33\2\2\u00918\3\2\2\2\u0091>\3\2"+
		"\2\2\u0091D\3\2\2\2\u0091J\3\2\2\2\u0091P\3\2\2\2\u0091T\3\2\2\2\u0091"+
		"X\3\2\2\2\u0091\\\3\2\2\2\u0091`\3\2\2\2\u0091d\3\2\2\2\u0091h\3\2\2\2"+
		"\u0091l\3\2\2\2\u0091p\3\2\2\2\u0091t\3\2\2\2\u0091x\3\2\2\2\u0091|\3"+
		"\2\2\2\u0091\u0080\3\2\2\2\u0091\u0084\3\2\2\2\u0091\u0088\3\2\2\2\u0091"+
		"\u008c\3\2\2\2\u0091\u0090\3\2\2\2\u0092\21\3\2\2\2\u0093\u0094\b\n\1"+
		"\2\u0094\u0095\7!\2\2\u0095\u009c\5\22\n\5\u0096\u0097\7\"\2\2\u0097\u0098"+
		"\5\22\n\2\u0098\u0099\7#\2\2\u0099\u009c\3\2\2\2\u009a\u009c\5\20\t\2"+
		"\u009b\u0093\3\2\2\2\u009b\u0096\3\2\2\2\u009b\u009a\3\2\2\2\u009c\u00a5"+
		"\3\2\2\2\u009d\u009e\f\7\2\2\u009e\u009f\7 \2\2\u009f\u00a4\5\22\n\b\u00a0"+
		"\u00a1\f\6\2\2\u00a1\u00a2\7\37\2\2\u00a2\u00a4\5\22\n\7\u00a3\u009d\3"+
		"\2\2\2\u00a3\u00a0\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\23\3\2\2\2\u00a7\u00a5\3\2\2\2\7(\u0091\u009b\u00a3"+
		"\u00a5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}