// Generated from java-escape by ANTLR 4.11.1
package request;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class RequestParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		REQ=1, VOCAB=2, INPUTS=3, OUTPUTS=4, PRECONDITION=5, EFFECT=6, SUBCLASSOF=7, 
		EQUIVALENTTO=8, STRICTSUBCLASSOF=9, INTERSECTS=10, DISJOINTWITH=11, SAT=12, 
		UNSAT=13, BELONGS=14, OR=15, AND=16, NEG=17, T=18, F=19, MIN=20, EXACTLY=21, 
		MAX=22, VALUE=23, SOME=24, ONLY=25, SELF=26, INVERSE=27, THING=28, NOTHING=29, 
		OP=30, CP=31, OB=32, CB=33, COMMA=34, COLON=35, BLANK=36, TAB=37, NL=38, 
		ID=39, DBL=40, INT=41, STR=42, LINECOMMENTARY=43;
	public static final int
		RULE_req = 0, RULE_vocabulary = 1, RULE_ontologies = 2, RULE_inputs = 3, 
		RULE_iparams = 4, RULE_iparam = 5, RULE_outputs = 6, RULE_oparams = 7, 
		RULE_oparam = 8, RULE_type = 9, RULE_pairs_of_states = 10, RULE_pair_of_states = 11, 
		RULE_precondition = 12, RULE_effect = 13, RULE_sentences = 14, RULE_sentence = 15, 
		RULE_set = 16, RULE_set_and = 17, RULE_set_base = 18, RULE_property_set = 19, 
		RULE_neg_set = 20, RULE_inv_property_set = 21, RULE_inv_property = 22, 
		RULE_class_set = 23, RULE_anonymous_set = 24, RULE_set1 = 25, RULE_terms = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"req", "vocabulary", "ontologies", "inputs", "iparams", "iparam", "outputs", 
			"oparams", "oparam", "type", "pairs_of_states", "pair_of_states", "precondition", 
			"effect", "sentences", "sentence", "set", "set_and", "set_base", "property_set", 
			"neg_set", "inv_property_set", "inv_property", "class_set", "anonymous_set", 
			"set1", "terms"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'req'", "'Vocabulary'", "'Inputs'", "'Outputs'", "'Precondition'", 
			"'Effect'", "'subclassOf'", "'equivalentTo'", "'strictSubclassOf'", "'intersects'", 
			"'disjointWith'", "'satisfiable'", "'unsatisfiable'", "'belongs'", "'or'", 
			"'and'", "'not'", "'true'", "'false'", "'min'", "'exactly'", "'max'", 
			"'value'", "'some'", "'only'", "'self'", "'inverse'", "'Thing'", "'NoThing'", 
			"'('", "')'", "'{'", "'}'", "','", "':'", "' '", "'\\t'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "REQ", "VOCAB", "INPUTS", "OUTPUTS", "PRECONDITION", "EFFECT", 
			"SUBCLASSOF", "EQUIVALENTTO", "STRICTSUBCLASSOF", "INTERSECTS", "DISJOINTWITH", 
			"SAT", "UNSAT", "BELONGS", "OR", "AND", "NEG", "T", "F", "MIN", "EXACTLY", 
			"MAX", "VALUE", "SOME", "ONLY", "SELF", "INVERSE", "THING", "NOTHING", 
			"OP", "CP", "OB", "CB", "COMMA", "COLON", "BLANK", "TAB", "NL", "ID", 
			"DBL", "INT", "STR", "LINECOMMENTARY"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RequestParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReqContext extends ParserRuleContext {
		public TerminalNode REQ() { return getToken(RequestParser.REQ, 0); }
		public TerminalNode ID() { return getToken(RequestParser.ID, 0); }
		public VocabularyContext vocabulary() {
			return getRuleContext(VocabularyContext.class,0);
		}
		public InputsContext inputs() {
			return getRuleContext(InputsContext.class,0);
		}
		public OutputsContext outputs() {
			return getRuleContext(OutputsContext.class,0);
		}
		public Pairs_of_statesContext pairs_of_states() {
			return getRuleContext(Pairs_of_statesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(RequestParser.EOF, 0); }
		public ReqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_req; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterReq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitReq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitReq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReqContext req() throws RecognitionException {
		ReqContext _localctx = new ReqContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_req);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(REQ);
			setState(55);
			match(ID);
			setState(56);
			vocabulary();
			setState(57);
			inputs();
			setState(58);
			outputs();
			setState(59);
			pairs_of_states();
			setState(60);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VocabularyContext extends ParserRuleContext {
		public TerminalNode VOCAB() { return getToken(RequestParser.VOCAB, 0); }
		public TerminalNode COLON() { return getToken(RequestParser.COLON, 0); }
		public OntologiesContext ontologies() {
			return getRuleContext(OntologiesContext.class,0);
		}
		public VocabularyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vocabulary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterVocabulary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitVocabulary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitVocabulary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VocabularyContext vocabulary() throws RecognitionException {
		VocabularyContext _localctx = new VocabularyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_vocabulary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(VOCAB);
			setState(63);
			match(COLON);
			setState(64);
			ontologies();
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

	@SuppressWarnings("CheckReturnValue")
	public static class OntologiesContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RequestParser.ID, 0); }
		public TerminalNode COMMA() { return getToken(RequestParser.COMMA, 0); }
		public OntologiesContext ontologies() {
			return getRuleContext(OntologiesContext.class,0);
		}
		public OntologiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ontologies; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterOntologies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitOntologies(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitOntologies(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OntologiesContext ontologies() throws RecognitionException {
		OntologiesContext _localctx = new OntologiesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ontologies);
		try {
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				match(ID);
				setState(67);
				match(COMMA);
				setState(68);
				ontologies();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InputsContext extends ParserRuleContext {
		public TerminalNode INPUTS() { return getToken(RequestParser.INPUTS, 0); }
		public TerminalNode COLON() { return getToken(RequestParser.COLON, 0); }
		public IparamsContext iparams() {
			return getRuleContext(IparamsContext.class,0);
		}
		public InputsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterInputs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitInputs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitInputs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputsContext inputs() throws RecognitionException {
		InputsContext _localctx = new InputsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_inputs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(INPUTS);
			setState(73);
			match(COLON);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(74);
				iparams();
				}
			}

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

	@SuppressWarnings("CheckReturnValue")
	public static class IparamsContext extends ParserRuleContext {
		public IparamContext iparam() {
			return getRuleContext(IparamContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(RequestParser.COMMA, 0); }
		public IparamsContext iparams() {
			return getRuleContext(IparamsContext.class,0);
		}
		public IparamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iparams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterIparams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitIparams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitIparams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IparamsContext iparams() throws RecognitionException {
		IparamsContext _localctx = new IparamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_iparams);
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				iparam();
				setState(78);
				match(COMMA);
				setState(79);
				iparams();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				iparam();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IparamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(RequestParser.ID, 0); }
		public IparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iparam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterIparam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitIparam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitIparam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IparamContext iparam() throws RecognitionException {
		IparamContext _localctx = new IparamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_iparam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			type();
			setState(85);
			match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class OutputsContext extends ParserRuleContext {
		public TerminalNode OUTPUTS() { return getToken(RequestParser.OUTPUTS, 0); }
		public TerminalNode COLON() { return getToken(RequestParser.COLON, 0); }
		public OparamsContext oparams() {
			return getRuleContext(OparamsContext.class,0);
		}
		public OutputsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterOutputs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitOutputs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitOutputs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputsContext outputs() throws RecognitionException {
		OutputsContext _localctx = new OutputsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_outputs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(OUTPUTS);
			setState(88);
			match(COLON);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(89);
				oparams();
				}
			}

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

	@SuppressWarnings("CheckReturnValue")
	public static class OparamsContext extends ParserRuleContext {
		public OparamContext oparam() {
			return getRuleContext(OparamContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(RequestParser.COMMA, 0); }
		public OparamsContext oparams() {
			return getRuleContext(OparamsContext.class,0);
		}
		public OparamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oparams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterOparams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitOparams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitOparams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OparamsContext oparams() throws RecognitionException {
		OparamsContext _localctx = new OparamsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_oparams);
		try {
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				oparam();
				setState(93);
				match(COMMA);
				setState(94);
				oparams();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				oparam();
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

	@SuppressWarnings("CheckReturnValue")
	public static class OparamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(RequestParser.ID, 0); }
		public OparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oparam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterOparam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitOparam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitOparam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OparamContext oparam() throws RecognitionException {
		OparamContext _localctx = new OparamContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_oparam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			type();
			setState(100);
			match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(RequestParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RequestParser.ID, i);
		}
		public TerminalNode COLON() { return getToken(RequestParser.COLON, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(ID);
			setState(103);
			match(COLON);
			setState(104);
			match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Pairs_of_statesContext extends ParserRuleContext {
		public List<Pair_of_statesContext> pair_of_states() {
			return getRuleContexts(Pair_of_statesContext.class);
		}
		public Pair_of_statesContext pair_of_states(int i) {
			return getRuleContext(Pair_of_statesContext.class,i);
		}
		public Pairs_of_statesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairs_of_states; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterPairs_of_states(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitPairs_of_states(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitPairs_of_states(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pairs_of_statesContext pairs_of_states() throws RecognitionException {
		Pairs_of_statesContext _localctx = new Pairs_of_statesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_pairs_of_states);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(106);
				pair_of_states();
				}
				}
				setState(109); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PRECONDITION );
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

	@SuppressWarnings("CheckReturnValue")
	public static class Pair_of_statesContext extends ParserRuleContext {
		public PreconditionContext precondition() {
			return getRuleContext(PreconditionContext.class,0);
		}
		public EffectContext effect() {
			return getRuleContext(EffectContext.class,0);
		}
		public Pair_of_statesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_of_states; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterPair_of_states(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitPair_of_states(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitPair_of_states(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_of_statesContext pair_of_states() throws RecognitionException {
		Pair_of_statesContext _localctx = new Pair_of_statesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pair_of_states);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			precondition();
			setState(112);
			effect();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PreconditionContext extends ParserRuleContext {
		public TerminalNode PRECONDITION() { return getToken(RequestParser.PRECONDITION, 0); }
		public TerminalNode COLON() { return getToken(RequestParser.COLON, 0); }
		public SentencesContext sentences() {
			return getRuleContext(SentencesContext.class,0);
		}
		public PreconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterPrecondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitPrecondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitPrecondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreconditionContext precondition() throws RecognitionException {
		PreconditionContext _localctx = new PreconditionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_precondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(PRECONDITION);
			setState(115);
			match(COLON);
			setState(116);
			sentences();
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

	@SuppressWarnings("CheckReturnValue")
	public static class EffectContext extends ParserRuleContext {
		public TerminalNode EFFECT() { return getToken(RequestParser.EFFECT, 0); }
		public TerminalNode COLON() { return getToken(RequestParser.COLON, 0); }
		public SentencesContext sentences() {
			return getRuleContext(SentencesContext.class,0);
		}
		public EffectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_effect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterEffect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitEffect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitEffect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EffectContext effect() throws RecognitionException {
		EffectContext _localctx = new EffectContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_effect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(EFFECT);
			setState(119);
			match(COLON);
			setState(120);
			sentences();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SentencesContext extends ParserRuleContext {
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(RequestParser.COMMA, 0); }
		public SentencesContext sentences() {
			return getRuleContext(SentencesContext.class,0);
		}
		public SentencesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentences; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterSentences(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitSentences(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitSentences(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentencesContext sentences() throws RecognitionException {
		SentencesContext _localctx = new SentencesContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sentences);
		try {
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				sentence();
				setState(123);
				match(COMMA);
				setState(124);
				sentences();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				sentence();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
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

	@SuppressWarnings("CheckReturnValue")
	public static class SentenceContext extends ParserRuleContext {
		public List<SetContext> set() {
			return getRuleContexts(SetContext.class);
		}
		public SetContext set(int i) {
			return getRuleContext(SetContext.class,i);
		}
		public TerminalNode SUBCLASSOF() { return getToken(RequestParser.SUBCLASSOF, 0); }
		public TerminalNode EQUIVALENTTO() { return getToken(RequestParser.EQUIVALENTTO, 0); }
		public TerminalNode ID() { return getToken(RequestParser.ID, 0); }
		public TerminalNode BELONGS() { return getToken(RequestParser.BELONGS, 0); }
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitSentence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_sentence);
		try {
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				set();
				setState(131);
				match(SUBCLASSOF);
				setState(132);
				set();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				set();
				setState(135);
				match(EQUIVALENTTO);
				setState(136);
				set();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(138);
				match(ID);
				setState(139);
				match(BELONGS);
				setState(140);
				set();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SetContext extends ParserRuleContext {
		public Set_andContext set_and() {
			return getRuleContext(Set_andContext.class,0);
		}
		public TerminalNode OR() { return getToken(RequestParser.OR, 0); }
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_set);
		try {
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				set_and();
				setState(144);
				match(OR);
				setState(145);
				set();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				set_and();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Set_andContext extends ParserRuleContext {
		public Set_baseContext set_base() {
			return getRuleContext(Set_baseContext.class,0);
		}
		public TerminalNode AND() { return getToken(RequestParser.AND, 0); }
		public Set_andContext set_and() {
			return getRuleContext(Set_andContext.class,0);
		}
		public Set_andContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterSet_and(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitSet_and(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitSet_and(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Set_andContext set_and() throws RecognitionException {
		Set_andContext _localctx = new Set_andContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_set_and);
		try {
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				set_base();
				setState(151);
				match(AND);
				setState(152);
				set_and();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				set_base();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Set_baseContext extends ParserRuleContext {
		public Property_setContext property_set() {
			return getRuleContext(Property_setContext.class,0);
		}
		public Neg_setContext neg_set() {
			return getRuleContext(Neg_setContext.class,0);
		}
		public Inv_property_setContext inv_property_set() {
			return getRuleContext(Inv_property_setContext.class,0);
		}
		public Class_setContext class_set() {
			return getRuleContext(Class_setContext.class,0);
		}
		public TerminalNode OP() { return getToken(RequestParser.OP, 0); }
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public TerminalNode CP() { return getToken(RequestParser.CP, 0); }
		public Anonymous_setContext anonymous_set() {
			return getRuleContext(Anonymous_setContext.class,0);
		}
		public Set_baseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_base; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterSet_base(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitSet_base(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitSet_base(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Set_baseContext set_base() throws RecognitionException {
		Set_baseContext _localctx = new Set_baseContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_set_base);
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				property_set();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				neg_set();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				inv_property_set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(160);
				class_set();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(161);
				match(OP);
				setState(162);
				set();
				setState(163);
				match(CP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(165);
				anonymous_set();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Property_setContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(RequestParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RequestParser.ID, i);
		}
		public TerminalNode INT() { return getToken(RequestParser.INT, 0); }
		public TerminalNode MIN() { return getToken(RequestParser.MIN, 0); }
		public TerminalNode EXACTLY() { return getToken(RequestParser.EXACTLY, 0); }
		public TerminalNode MAX() { return getToken(RequestParser.MAX, 0); }
		public TerminalNode VALUE() { return getToken(RequestParser.VALUE, 0); }
		public TerminalNode DBL() { return getToken(RequestParser.DBL, 0); }
		public TerminalNode STR() { return getToken(RequestParser.STR, 0); }
		public TerminalNode T() { return getToken(RequestParser.T, 0); }
		public TerminalNode F() { return getToken(RequestParser.F, 0); }
		public TerminalNode ONLY() { return getToken(RequestParser.ONLY, 0); }
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public TerminalNode SOME() { return getToken(RequestParser.SOME, 0); }
		public TerminalNode SELF() { return getToken(RequestParser.SELF, 0); }
		public Property_setContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterProperty_set(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitProperty_set(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitProperty_set(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Property_setContext property_set() throws RecognitionException {
		Property_setContext _localctx = new Property_setContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_property_set);
		int _la;
		try {
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				match(ID);
				setState(169);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 7340032L) != 0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(170);
				match(INT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				match(ID);
				setState(172);
				match(VALUE);
				setState(173);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 8246337994752L) != 0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				match(ID);
				setState(175);
				match(ONLY);
				setState(176);
				set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(177);
				match(ID);
				setState(178);
				match(SOME);
				setState(179);
				set();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(180);
				match(ID);
				setState(181);
				match(SELF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Neg_setContext extends ParserRuleContext {
		public TerminalNode NEG() { return getToken(RequestParser.NEG, 0); }
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public Neg_setContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neg_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterNeg_set(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitNeg_set(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitNeg_set(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Neg_setContext neg_set() throws RecognitionException {
		Neg_setContext _localctx = new Neg_setContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_neg_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(NEG);
			setState(185);
			set();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Inv_property_setContext extends ParserRuleContext {
		public Inv_propertyContext inv_property() {
			return getRuleContext(Inv_propertyContext.class,0);
		}
		public TerminalNode INT() { return getToken(RequestParser.INT, 0); }
		public TerminalNode MIN() { return getToken(RequestParser.MIN, 0); }
		public TerminalNode EXACTLY() { return getToken(RequestParser.EXACTLY, 0); }
		public TerminalNode MAX() { return getToken(RequestParser.MAX, 0); }
		public TerminalNode VALUE() { return getToken(RequestParser.VALUE, 0); }
		public TerminalNode ID() { return getToken(RequestParser.ID, 0); }
		public TerminalNode ONLY() { return getToken(RequestParser.ONLY, 0); }
		public Set1Context set1() {
			return getRuleContext(Set1Context.class,0);
		}
		public TerminalNode SOME() { return getToken(RequestParser.SOME, 0); }
		public TerminalNode SELF() { return getToken(RequestParser.SELF, 0); }
		public Inv_property_setContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inv_property_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterInv_property_set(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitInv_property_set(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitInv_property_set(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inv_property_setContext inv_property_set() throws RecognitionException {
		Inv_property_setContext _localctx = new Inv_property_setContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_inv_property_set);
		int _la;
		try {
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				inv_property();
				setState(188);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 7340032L) != 0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(189);
				match(INT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				inv_property();
				setState(192);
				match(VALUE);
				setState(193);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(195);
				inv_property();
				setState(196);
				match(ONLY);
				setState(197);
				set1();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(199);
				inv_property();
				setState(200);
				match(SOME);
				setState(201);
				set1();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(203);
				inv_property();
				setState(204);
				match(SELF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Inv_propertyContext extends ParserRuleContext {
		public TerminalNode INVERSE() { return getToken(RequestParser.INVERSE, 0); }
		public TerminalNode OP() { return getToken(RequestParser.OP, 0); }
		public TerminalNode CP() { return getToken(RequestParser.CP, 0); }
		public Inv_propertyContext inv_property() {
			return getRuleContext(Inv_propertyContext.class,0);
		}
		public TerminalNode ID() { return getToken(RequestParser.ID, 0); }
		public Inv_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inv_property; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterInv_property(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitInv_property(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitInv_property(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inv_propertyContext inv_property() throws RecognitionException {
		Inv_propertyContext _localctx = new Inv_propertyContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_inv_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(INVERSE);
			setState(209);
			match(OP);
			setState(212);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INVERSE:
				{
				setState(210);
				inv_property();
				}
				break;
			case ID:
				{
				setState(211);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(214);
			match(CP);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Class_setContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RequestParser.ID, 0); }
		public TerminalNode THING() { return getToken(RequestParser.THING, 0); }
		public TerminalNode NOTHING() { return getToken(RequestParser.NOTHING, 0); }
		public Class_setContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterClass_set(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitClass_set(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitClass_set(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_setContext class_set() throws RecognitionException {
		Class_setContext _localctx = new Class_setContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_class_set);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 550561120256L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class Anonymous_setContext extends ParserRuleContext {
		public TerminalNode OB() { return getToken(RequestParser.OB, 0); }
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public TerminalNode CB() { return getToken(RequestParser.CB, 0); }
		public Anonymous_setContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonymous_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterAnonymous_set(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitAnonymous_set(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitAnonymous_set(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Anonymous_setContext anonymous_set() throws RecognitionException {
		Anonymous_setContext _localctx = new Anonymous_setContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_anonymous_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(OB);
			setState(219);
			terms();
			setState(220);
			match(CB);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Set1Context extends ParserRuleContext {
		public Class_setContext class_set() {
			return getRuleContext(Class_setContext.class,0);
		}
		public TerminalNode OP() { return getToken(RequestParser.OP, 0); }
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public TerminalNode CP() { return getToken(RequestParser.CP, 0); }
		public TerminalNode OB() { return getToken(RequestParser.OB, 0); }
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public TerminalNode CB() { return getToken(RequestParser.CB, 0); }
		public Set1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterSet1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitSet1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitSet1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Set1Context set1() throws RecognitionException {
		Set1Context _localctx = new Set1Context(_ctx, getState());
		enterRule(_localctx, 50, RULE_set1);
		try {
			setState(231);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case THING:
			case NOTHING:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				class_set();
				}
				break;
			case OP:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				match(OP);
				setState(224);
				set();
				setState(225);
				match(CP);
				}
				break;
			case OB:
				enterOuterAlt(_localctx, 3);
				{
				setState(227);
				match(OB);
				setState(228);
				terms();
				setState(229);
				match(CB);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RequestParser.ID, 0); }
		public TerminalNode COMMA() { return getToken(RequestParser.COMMA, 0); }
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public TermsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).enterTerms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequestParserListener ) ((RequestParserListener)listener).exitTerms(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequestParserVisitor ) return ((RequestParserVisitor<? extends T>)visitor).visitTerms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermsContext terms() throws RecognitionException {
		TermsContext _localctx = new TermsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_terms);
		try {
			setState(237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				match(ID);
				setState(234);
				match(COMMA);
				setState(235);
				terms();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
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

	public static final String _serializedATN =
		"\u0004\u0001+\u00f0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002G\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003L\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004S\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006[\b\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"b\b\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0004\nl\b\n\u000b\n\f\nm\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u0081\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u008e\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u0095\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u009c\b\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u00a7\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013"+
		"\u00b7\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015"+
		"\u00cf\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016"+
		"\u00d5\b\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0003\u0019\u00e8\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0003\u001a\u00ee\b\u001a\u0001\u001a\u0000\u0000\u001b\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.024\u0000\u0003\u0001\u0000\u0014\u0016\u0002\u0000\u0012\u0013"+
		"\'*\u0002\u0000\u001c\u001d\'\'\u00f1\u00006\u0001\u0000\u0000\u0000\u0002"+
		">\u0001\u0000\u0000\u0000\u0004F\u0001\u0000\u0000\u0000\u0006H\u0001"+
		"\u0000\u0000\u0000\bR\u0001\u0000\u0000\u0000\nT\u0001\u0000\u0000\u0000"+
		"\fW\u0001\u0000\u0000\u0000\u000ea\u0001\u0000\u0000\u0000\u0010c\u0001"+
		"\u0000\u0000\u0000\u0012f\u0001\u0000\u0000\u0000\u0014k\u0001\u0000\u0000"+
		"\u0000\u0016o\u0001\u0000\u0000\u0000\u0018r\u0001\u0000\u0000\u0000\u001a"+
		"v\u0001\u0000\u0000\u0000\u001c\u0080\u0001\u0000\u0000\u0000\u001e\u008d"+
		"\u0001\u0000\u0000\u0000 \u0094\u0001\u0000\u0000\u0000\"\u009b\u0001"+
		"\u0000\u0000\u0000$\u00a6\u0001\u0000\u0000\u0000&\u00b6\u0001\u0000\u0000"+
		"\u0000(\u00b8\u0001\u0000\u0000\u0000*\u00ce\u0001\u0000\u0000\u0000,"+
		"\u00d0\u0001\u0000\u0000\u0000.\u00d8\u0001\u0000\u0000\u00000\u00da\u0001"+
		"\u0000\u0000\u00002\u00e7\u0001\u0000\u0000\u00004\u00ed\u0001\u0000\u0000"+
		"\u000067\u0005\u0001\u0000\u000078\u0005\'\u0000\u000089\u0003\u0002\u0001"+
		"\u00009:\u0003\u0006\u0003\u0000:;\u0003\f\u0006\u0000;<\u0003\u0014\n"+
		"\u0000<=\u0005\u0000\u0000\u0001=\u0001\u0001\u0000\u0000\u0000>?\u0005"+
		"\u0002\u0000\u0000?@\u0005#\u0000\u0000@A\u0003\u0004\u0002\u0000A\u0003"+
		"\u0001\u0000\u0000\u0000BC\u0005\'\u0000\u0000CD\u0005\"\u0000\u0000D"+
		"G\u0003\u0004\u0002\u0000EG\u0005\'\u0000\u0000FB\u0001\u0000\u0000\u0000"+
		"FE\u0001\u0000\u0000\u0000G\u0005\u0001\u0000\u0000\u0000HI\u0005\u0003"+
		"\u0000\u0000IK\u0005#\u0000\u0000JL\u0003\b\u0004\u0000KJ\u0001\u0000"+
		"\u0000\u0000KL\u0001\u0000\u0000\u0000L\u0007\u0001\u0000\u0000\u0000"+
		"MN\u0003\n\u0005\u0000NO\u0005\"\u0000\u0000OP\u0003\b\u0004\u0000PS\u0001"+
		"\u0000\u0000\u0000QS\u0003\n\u0005\u0000RM\u0001\u0000\u0000\u0000RQ\u0001"+
		"\u0000\u0000\u0000S\t\u0001\u0000\u0000\u0000TU\u0003\u0012\t\u0000UV"+
		"\u0005\'\u0000\u0000V\u000b\u0001\u0000\u0000\u0000WX\u0005\u0004\u0000"+
		"\u0000XZ\u0005#\u0000\u0000Y[\u0003\u000e\u0007\u0000ZY\u0001\u0000\u0000"+
		"\u0000Z[\u0001\u0000\u0000\u0000[\r\u0001\u0000\u0000\u0000\\]\u0003\u0010"+
		"\b\u0000]^\u0005\"\u0000\u0000^_\u0003\u000e\u0007\u0000_b\u0001\u0000"+
		"\u0000\u0000`b\u0003\u0010\b\u0000a\\\u0001\u0000\u0000\u0000a`\u0001"+
		"\u0000\u0000\u0000b\u000f\u0001\u0000\u0000\u0000cd\u0003\u0012\t\u0000"+
		"de\u0005\'\u0000\u0000e\u0011\u0001\u0000\u0000\u0000fg\u0005\'\u0000"+
		"\u0000gh\u0005#\u0000\u0000hi\u0005\'\u0000\u0000i\u0013\u0001\u0000\u0000"+
		"\u0000jl\u0003\u0016\u000b\u0000kj\u0001\u0000\u0000\u0000lm\u0001\u0000"+
		"\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000n\u0015"+
		"\u0001\u0000\u0000\u0000op\u0003\u0018\f\u0000pq\u0003\u001a\r\u0000q"+
		"\u0017\u0001\u0000\u0000\u0000rs\u0005\u0005\u0000\u0000st\u0005#\u0000"+
		"\u0000tu\u0003\u001c\u000e\u0000u\u0019\u0001\u0000\u0000\u0000vw\u0005"+
		"\u0006\u0000\u0000wx\u0005#\u0000\u0000xy\u0003\u001c\u000e\u0000y\u001b"+
		"\u0001\u0000\u0000\u0000z{\u0003\u001e\u000f\u0000{|\u0005\"\u0000\u0000"+
		"|}\u0003\u001c\u000e\u0000}\u0081\u0001\u0000\u0000\u0000~\u0081\u0003"+
		"\u001e\u000f\u0000\u007f\u0081\u0001\u0000\u0000\u0000\u0080z\u0001\u0000"+
		"\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u007f\u0001\u0000\u0000"+
		"\u0000\u0081\u001d\u0001\u0000\u0000\u0000\u0082\u0083\u0003 \u0010\u0000"+
		"\u0083\u0084\u0005\u0007\u0000\u0000\u0084\u0085\u0003 \u0010\u0000\u0085"+
		"\u008e\u0001\u0000\u0000\u0000\u0086\u0087\u0003 \u0010\u0000\u0087\u0088"+
		"\u0005\b\u0000\u0000\u0088\u0089\u0003 \u0010\u0000\u0089\u008e\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0005\'\u0000\u0000\u008b\u008c\u0005\u000e"+
		"\u0000\u0000\u008c\u008e\u0003 \u0010\u0000\u008d\u0082\u0001\u0000\u0000"+
		"\u0000\u008d\u0086\u0001\u0000\u0000\u0000\u008d\u008a\u0001\u0000\u0000"+
		"\u0000\u008e\u001f\u0001\u0000\u0000\u0000\u008f\u0090\u0003\"\u0011\u0000"+
		"\u0090\u0091\u0005\u000f\u0000\u0000\u0091\u0092\u0003 \u0010\u0000\u0092"+
		"\u0095\u0001\u0000\u0000\u0000\u0093\u0095\u0003\"\u0011\u0000\u0094\u008f"+
		"\u0001\u0000\u0000\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0095!\u0001"+
		"\u0000\u0000\u0000\u0096\u0097\u0003$\u0012\u0000\u0097\u0098\u0005\u0010"+
		"\u0000\u0000\u0098\u0099\u0003\"\u0011\u0000\u0099\u009c\u0001\u0000\u0000"+
		"\u0000\u009a\u009c\u0003$\u0012\u0000\u009b\u0096\u0001\u0000\u0000\u0000"+
		"\u009b\u009a\u0001\u0000\u0000\u0000\u009c#\u0001\u0000\u0000\u0000\u009d"+
		"\u00a7\u0003&\u0013\u0000\u009e\u00a7\u0003(\u0014\u0000\u009f\u00a7\u0003"+
		"*\u0015\u0000\u00a0\u00a7\u0003.\u0017\u0000\u00a1\u00a2\u0005\u001e\u0000"+
		"\u0000\u00a2\u00a3\u0003 \u0010\u0000\u00a3\u00a4\u0005\u001f\u0000\u0000"+
		"\u00a4\u00a7\u0001\u0000\u0000\u0000\u00a5\u00a7\u00030\u0018\u0000\u00a6"+
		"\u009d\u0001\u0000\u0000\u0000\u00a6\u009e\u0001\u0000\u0000\u0000\u00a6"+
		"\u009f\u0001\u0000\u0000\u0000\u00a6\u00a0\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a7"+
		"%\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005\'\u0000\u0000\u00a9\u00aa"+
		"\u0007\u0000\u0000\u0000\u00aa\u00b7\u0005)\u0000\u0000\u00ab\u00ac\u0005"+
		"\'\u0000\u0000\u00ac\u00ad\u0005\u0017\u0000\u0000\u00ad\u00b7\u0007\u0001"+
		"\u0000\u0000\u00ae\u00af\u0005\'\u0000\u0000\u00af\u00b0\u0005\u0019\u0000"+
		"\u0000\u00b0\u00b7\u0003 \u0010\u0000\u00b1\u00b2\u0005\'\u0000\u0000"+
		"\u00b2\u00b3\u0005\u0018\u0000\u0000\u00b3\u00b7\u0003 \u0010\u0000\u00b4"+
		"\u00b5\u0005\'\u0000\u0000\u00b5\u00b7\u0005\u001a\u0000\u0000\u00b6\u00a8"+
		"\u0001\u0000\u0000\u0000\u00b6\u00ab\u0001\u0000\u0000\u0000\u00b6\u00ae"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b1\u0001\u0000\u0000\u0000\u00b6\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b7\'\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005"+
		"\u0011\u0000\u0000\u00b9\u00ba\u0003 \u0010\u0000\u00ba)\u0001\u0000\u0000"+
		"\u0000\u00bb\u00bc\u0003,\u0016\u0000\u00bc\u00bd\u0007\u0000\u0000\u0000"+
		"\u00bd\u00be\u0005)\u0000\u0000\u00be\u00cf\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c0\u0003,\u0016\u0000\u00c0\u00c1\u0005\u0017\u0000\u0000\u00c1\u00c2"+
		"\u0005\'\u0000\u0000\u00c2\u00cf\u0001\u0000\u0000\u0000\u00c3\u00c4\u0003"+
		",\u0016\u0000\u00c4\u00c5\u0005\u0019\u0000\u0000\u00c5\u00c6\u00032\u0019"+
		"\u0000\u00c6\u00cf\u0001\u0000\u0000\u0000\u00c7\u00c8\u0003,\u0016\u0000"+
		"\u00c8\u00c9\u0005\u0018\u0000\u0000\u00c9\u00ca\u00032\u0019\u0000\u00ca"+
		"\u00cf\u0001\u0000\u0000\u0000\u00cb\u00cc\u0003,\u0016\u0000\u00cc\u00cd"+
		"\u0005\u001a\u0000\u0000\u00cd\u00cf\u0001\u0000\u0000\u0000\u00ce\u00bb"+
		"\u0001\u0000\u0000\u0000\u00ce\u00bf\u0001\u0000\u0000\u0000\u00ce\u00c3"+
		"\u0001\u0000\u0000\u0000\u00ce\u00c7\u0001\u0000\u0000\u0000\u00ce\u00cb"+
		"\u0001\u0000\u0000\u0000\u00cf+\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005"+
		"\u001b\u0000\u0000\u00d1\u00d4\u0005\u001e\u0000\u0000\u00d2\u00d5\u0003"+
		",\u0016\u0000\u00d3\u00d5\u0005\'\u0000\u0000\u00d4\u00d2\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d7\u0005\u001f\u0000\u0000\u00d7-\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d9\u0007\u0002\u0000\u0000\u00d9/\u0001\u0000\u0000\u0000"+
		"\u00da\u00db\u0005 \u0000\u0000\u00db\u00dc\u00034\u001a\u0000\u00dc\u00dd"+
		"\u0005!\u0000\u0000\u00dd1\u0001\u0000\u0000\u0000\u00de\u00e8\u0003."+
		"\u0017\u0000\u00df\u00e0\u0005\u001e\u0000\u0000\u00e0\u00e1\u0003 \u0010"+
		"\u0000\u00e1\u00e2\u0005\u001f\u0000\u0000\u00e2\u00e8\u0001\u0000\u0000"+
		"\u0000\u00e3\u00e4\u0005 \u0000\u0000\u00e4\u00e5\u00034\u001a\u0000\u00e5"+
		"\u00e6\u0005!\u0000\u0000\u00e6\u00e8\u0001\u0000\u0000\u0000\u00e7\u00de"+
		"\u0001\u0000\u0000\u0000\u00e7\u00df\u0001\u0000\u0000\u0000\u00e7\u00e3"+
		"\u0001\u0000\u0000\u0000\u00e83\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005"+
		"\'\u0000\u0000\u00ea\u00eb\u0005\"\u0000\u0000\u00eb\u00ee\u00034\u001a"+
		"\u0000\u00ec\u00ee\u0005\'\u0000\u0000\u00ed\u00e9\u0001\u0000\u0000\u0000"+
		"\u00ed\u00ec\u0001\u0000\u0000\u0000\u00ee5\u0001\u0000\u0000\u0000\u0010"+
		"FKRZam\u0080\u008d\u0094\u009b\u00a6\u00b6\u00ce\u00d4\u00e7\u00ed";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}