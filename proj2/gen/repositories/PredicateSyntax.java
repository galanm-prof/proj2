// Generated from java-escape by ANTLR 4.11.1
package repositories;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PredicateSyntax extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBERINFORMATIONSPACESTRONGSETS=1, NUMBERINFORMATIONSPACEWEAKSETS=2, 
		NUMBERSTATESPACESTRONGSETS=3, NUMBERSTATESPACEWEAKSETS=4, MEANSIZEINFORMATIONSPACESTRONGSETS=5, 
		MEANSIZEINFORMATIONSPACESTRONGSETSMAX=6, MEANSIZEINFORMATIONSPACEWEAKSETS=7, 
		MEANSIZEINFORMATIONSPACEWEAKSETSMAX=8, MEANSIZESTATESPACESTRONGSETS=9, 
		MEANSIZESTATESPACESTRONGSETSMAX=10, MEANSIZESTATESPACEWEAKSETS=11, MEANSIZESTATESPACEWEAKSETSMAX=12, 
		MEANRELATIVESIZEINFORMATIONSPACESTRONGSETS=13, MEANRELATIVESIZEINFORMATIONSPACESTRONGSETSMAX=14, 
		MEANRELATIVESIZEINFORMATIONSPACEWEAKSETS=15, MEANRELATIVESIZEINFORMATIONSPACEWEAKSETSMAX=16, 
		MEANRELATIVESIZESTATESPACESTRONGSETS=17, MEANRELATIVESIZESTATESPACESTRONGSETSMAX=18, 
		MEANRELATIVESIZESTATESPACEWEAKSETS=19, MEANRELATIVESIZESTATESPACEWEAKSETSMAX=20, 
		TRUE=21, OR=22, AND=23, NEG=24, OP=25, CP=26, COMMA=27, BLANK=28, TAB=29, 
		NL=30, LETTER=31, DIGIT=32, UNDERLINE=33, MINUS=34, DOT=35, DBL=36, INT=37, 
		LINECOMMENTARY=38, BLOCKCOMMENTARY=39;
	public static final int
		RULE_predicate = 0, RULE_primitive_predicate = 1, RULE_expression = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"predicate", "primitive_predicate", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'numberInformationSpaceStrongSets'", "'numberInformationSpaceWeakSets'", 
			"'numberStateSpaceStrongSets'", "'numberStateSpaceWeakSets'", "'meanSizeInformationSpaceStrongSets'", 
			"'meanSizeInformationSpaceStrongSetsMax'", "'meanSizeInformationSpaceWeakSets'", 
			"'meanSizeInformationSpaceWeakSetsMax'", "'meanSizeStateSpaceStrongSets'", 
			"'meanSizeStateSpaceStrongSetsMax'", "'meanSizeStateSpaceWeakSets'", 
			"'meanSizeStateSpaceWeakSetsMax'", "'meanRelativeSizeInformationSpaceStrongSets'", 
			"'meanRelativeSizeInformationSpaceStrongSetsMax'", "'meanRelativeSizeInformationSpaceWeakSets'", 
			"'meanRelativeSizeInformationSpaceWeakSetsMax'", "'meanRelativeSizeStateSpaceStrongSets'", 
			"'meanRelativeSizeStateSpaceStrongSetsMax'", "'meanRelativeSizeStateSpaceWeakSets'", 
			"'meanRelativeSizeStateSpaceWeakSetsMax'", "'true'", "'or'", "'and'", 
			"'not'", "'('", "')'", "','", "' '", "'\\t'", null, null, null, "'_'", 
			"'-'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NUMBERINFORMATIONSPACESTRONGSETS", "NUMBERINFORMATIONSPACEWEAKSETS", 
			"NUMBERSTATESPACESTRONGSETS", "NUMBERSTATESPACEWEAKSETS", "MEANSIZEINFORMATIONSPACESTRONGSETS", 
			"MEANSIZEINFORMATIONSPACESTRONGSETSMAX", "MEANSIZEINFORMATIONSPACEWEAKSETS", 
			"MEANSIZEINFORMATIONSPACEWEAKSETSMAX", "MEANSIZESTATESPACESTRONGSETS", 
			"MEANSIZESTATESPACESTRONGSETSMAX", "MEANSIZESTATESPACEWEAKSETS", "MEANSIZESTATESPACEWEAKSETSMAX", 
			"MEANRELATIVESIZEINFORMATIONSPACESTRONGSETS", "MEANRELATIVESIZEINFORMATIONSPACESTRONGSETSMAX", 
			"MEANRELATIVESIZEINFORMATIONSPACEWEAKSETS", "MEANRELATIVESIZEINFORMATIONSPACEWEAKSETSMAX", 
			"MEANRELATIVESIZESTATESPACESTRONGSETS", "MEANRELATIVESIZESTATESPACESTRONGSETSMAX", 
			"MEANRELATIVESIZESTATESPACEWEAKSETS", "MEANRELATIVESIZESTATESPACEWEAKSETSMAX", 
			"TRUE", "OR", "AND", "NEG", "OP", "CP", "COMMA", "BLANK", "TAB", "NL", 
			"LETTER", "DIGIT", "UNDERLINE", "MINUS", "DOT", "DBL", "INT", "LINECOMMENTARY", 
			"BLOCKCOMMENTARY"
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

	public PredicateSyntax(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PredicateContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PredicateSyntax.EOF, 0); }
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateSyntaxListener ) ((PredicateSyntaxListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateSyntaxListener ) ((PredicateSyntaxListener)listener).exitPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PredicateSyntaxVisitor ) return ((PredicateSyntaxVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			expression(0);
			setState(7);
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
	public static class Primitive_predicateContext extends ParserRuleContext {
		public TerminalNode NUMBERINFORMATIONSPACESTRONGSETS() { return getToken(PredicateSyntax.NUMBERINFORMATIONSPACESTRONGSETS, 0); }
		public TerminalNode OP() { return getToken(PredicateSyntax.OP, 0); }
		public List<TerminalNode> INT() { return getTokens(PredicateSyntax.INT); }
		public TerminalNode INT(int i) {
			return getToken(PredicateSyntax.INT, i);
		}
		public TerminalNode COMMA() { return getToken(PredicateSyntax.COMMA, 0); }
		public TerminalNode CP() { return getToken(PredicateSyntax.CP, 0); }
		public TerminalNode NUMBERINFORMATIONSPACEWEAKSETS() { return getToken(PredicateSyntax.NUMBERINFORMATIONSPACEWEAKSETS, 0); }
		public TerminalNode NUMBERSTATESPACESTRONGSETS() { return getToken(PredicateSyntax.NUMBERSTATESPACESTRONGSETS, 0); }
		public TerminalNode NUMBERSTATESPACEWEAKSETS() { return getToken(PredicateSyntax.NUMBERSTATESPACEWEAKSETS, 0); }
		public TerminalNode MEANSIZEINFORMATIONSPACESTRONGSETS() { return getToken(PredicateSyntax.MEANSIZEINFORMATIONSPACESTRONGSETS, 0); }
		public TerminalNode DBL() { return getToken(PredicateSyntax.DBL, 0); }
		public TerminalNode MEANSIZEINFORMATIONSPACESTRONGSETSMAX() { return getToken(PredicateSyntax.MEANSIZEINFORMATIONSPACESTRONGSETSMAX, 0); }
		public TerminalNode MEANSIZEINFORMATIONSPACEWEAKSETS() { return getToken(PredicateSyntax.MEANSIZEINFORMATIONSPACEWEAKSETS, 0); }
		public TerminalNode MEANSIZEINFORMATIONSPACEWEAKSETSMAX() { return getToken(PredicateSyntax.MEANSIZEINFORMATIONSPACEWEAKSETSMAX, 0); }
		public TerminalNode MEANSIZESTATESPACESTRONGSETS() { return getToken(PredicateSyntax.MEANSIZESTATESPACESTRONGSETS, 0); }
		public TerminalNode MEANSIZESTATESPACESTRONGSETSMAX() { return getToken(PredicateSyntax.MEANSIZESTATESPACESTRONGSETSMAX, 0); }
		public TerminalNode MEANSIZESTATESPACEWEAKSETS() { return getToken(PredicateSyntax.MEANSIZESTATESPACEWEAKSETS, 0); }
		public TerminalNode MEANSIZESTATESPACEWEAKSETSMAX() { return getToken(PredicateSyntax.MEANSIZESTATESPACEWEAKSETSMAX, 0); }
		public TerminalNode MEANRELATIVESIZEINFORMATIONSPACESTRONGSETS() { return getToken(PredicateSyntax.MEANRELATIVESIZEINFORMATIONSPACESTRONGSETS, 0); }
		public TerminalNode MEANRELATIVESIZEINFORMATIONSPACESTRONGSETSMAX() { return getToken(PredicateSyntax.MEANRELATIVESIZEINFORMATIONSPACESTRONGSETSMAX, 0); }
		public TerminalNode MEANRELATIVESIZEINFORMATIONSPACEWEAKSETS() { return getToken(PredicateSyntax.MEANRELATIVESIZEINFORMATIONSPACEWEAKSETS, 0); }
		public TerminalNode MEANRELATIVESIZEINFORMATIONSPACEWEAKSETSMAX() { return getToken(PredicateSyntax.MEANRELATIVESIZEINFORMATIONSPACEWEAKSETSMAX, 0); }
		public TerminalNode MEANRELATIVESIZESTATESPACESTRONGSETS() { return getToken(PredicateSyntax.MEANRELATIVESIZESTATESPACESTRONGSETS, 0); }
		public TerminalNode MEANRELATIVESIZESTATESPACESTRONGSETSMAX() { return getToken(PredicateSyntax.MEANRELATIVESIZESTATESPACESTRONGSETSMAX, 0); }
		public TerminalNode MEANRELATIVESIZESTATESPACEWEAKSETS() { return getToken(PredicateSyntax.MEANRELATIVESIZESTATESPACEWEAKSETS, 0); }
		public TerminalNode MEANRELATIVESIZESTATESPACEWEAKSETSMAX() { return getToken(PredicateSyntax.MEANRELATIVESIZESTATESPACEWEAKSETSMAX, 0); }
		public TerminalNode TRUE() { return getToken(PredicateSyntax.TRUE, 0); }
		public Primitive_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateSyntaxListener ) ((PredicateSyntaxListener)listener).enterPrimitive_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateSyntaxListener ) ((PredicateSyntaxListener)listener).exitPrimitive_predicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PredicateSyntaxVisitor ) return ((PredicateSyntaxVisitor<? extends T>)visitor).visitPrimitive_predicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primitive_predicateContext primitive_predicate() throws RecognitionException {
		Primitive_predicateContext _localctx = new Primitive_predicateContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_primitive_predicate);
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBERINFORMATIONSPACESTRONGSETS:
				enterOuterAlt(_localctx, 1);
				{
				setState(9);
				match(NUMBERINFORMATIONSPACESTRONGSETS);
				setState(10);
				match(OP);
				setState(11);
				match(INT);
				setState(12);
				match(COMMA);
				setState(13);
				match(INT);
				setState(14);
				match(CP);
				}
				break;
			case NUMBERINFORMATIONSPACEWEAKSETS:
				enterOuterAlt(_localctx, 2);
				{
				setState(15);
				match(NUMBERINFORMATIONSPACEWEAKSETS);
				setState(16);
				match(OP);
				setState(17);
				match(INT);
				setState(18);
				match(COMMA);
				setState(19);
				match(INT);
				setState(20);
				match(CP);
				}
				break;
			case NUMBERSTATESPACESTRONGSETS:
				enterOuterAlt(_localctx, 3);
				{
				setState(21);
				match(NUMBERSTATESPACESTRONGSETS);
				setState(22);
				match(OP);
				setState(23);
				match(INT);
				setState(24);
				match(COMMA);
				setState(25);
				match(INT);
				setState(26);
				match(CP);
				}
				break;
			case NUMBERSTATESPACEWEAKSETS:
				enterOuterAlt(_localctx, 4);
				{
				setState(27);
				match(NUMBERSTATESPACEWEAKSETS);
				setState(28);
				match(OP);
				setState(29);
				match(INT);
				setState(30);
				match(COMMA);
				setState(31);
				match(INT);
				setState(32);
				match(CP);
				}
				break;
			case MEANSIZEINFORMATIONSPACESTRONGSETS:
				enterOuterAlt(_localctx, 5);
				{
				setState(33);
				match(MEANSIZEINFORMATIONSPACESTRONGSETS);
				setState(34);
				match(OP);
				setState(35);
				match(DBL);
				setState(36);
				match(CP);
				}
				break;
			case MEANSIZEINFORMATIONSPACESTRONGSETSMAX:
				enterOuterAlt(_localctx, 6);
				{
				setState(37);
				match(MEANSIZEINFORMATIONSPACESTRONGSETSMAX);
				setState(38);
				match(OP);
				setState(39);
				match(DBL);
				setState(40);
				match(CP);
				}
				break;
			case MEANSIZEINFORMATIONSPACEWEAKSETS:
				enterOuterAlt(_localctx, 7);
				{
				setState(41);
				match(MEANSIZEINFORMATIONSPACEWEAKSETS);
				setState(42);
				match(OP);
				setState(43);
				match(DBL);
				setState(44);
				match(CP);
				}
				break;
			case MEANSIZEINFORMATIONSPACEWEAKSETSMAX:
				enterOuterAlt(_localctx, 8);
				{
				setState(45);
				match(MEANSIZEINFORMATIONSPACEWEAKSETSMAX);
				setState(46);
				match(OP);
				setState(47);
				match(DBL);
				setState(48);
				match(CP);
				}
				break;
			case MEANSIZESTATESPACESTRONGSETS:
				enterOuterAlt(_localctx, 9);
				{
				setState(49);
				match(MEANSIZESTATESPACESTRONGSETS);
				setState(50);
				match(OP);
				setState(51);
				match(DBL);
				setState(52);
				match(CP);
				}
				break;
			case MEANSIZESTATESPACESTRONGSETSMAX:
				enterOuterAlt(_localctx, 10);
				{
				setState(53);
				match(MEANSIZESTATESPACESTRONGSETSMAX);
				setState(54);
				match(OP);
				setState(55);
				match(DBL);
				setState(56);
				match(CP);
				}
				break;
			case MEANSIZESTATESPACEWEAKSETS:
				enterOuterAlt(_localctx, 11);
				{
				setState(57);
				match(MEANSIZESTATESPACEWEAKSETS);
				setState(58);
				match(OP);
				setState(59);
				match(DBL);
				setState(60);
				match(CP);
				}
				break;
			case MEANSIZESTATESPACEWEAKSETSMAX:
				enterOuterAlt(_localctx, 12);
				{
				setState(61);
				match(MEANSIZESTATESPACEWEAKSETSMAX);
				setState(62);
				match(OP);
				setState(63);
				match(DBL);
				setState(64);
				match(CP);
				}
				break;
			case MEANRELATIVESIZEINFORMATIONSPACESTRONGSETS:
				enterOuterAlt(_localctx, 13);
				{
				setState(65);
				match(MEANRELATIVESIZEINFORMATIONSPACESTRONGSETS);
				setState(66);
				match(OP);
				setState(67);
				match(DBL);
				setState(68);
				match(CP);
				}
				break;
			case MEANRELATIVESIZEINFORMATIONSPACESTRONGSETSMAX:
				enterOuterAlt(_localctx, 14);
				{
				setState(69);
				match(MEANRELATIVESIZEINFORMATIONSPACESTRONGSETSMAX);
				setState(70);
				match(OP);
				setState(71);
				match(DBL);
				setState(72);
				match(CP);
				}
				break;
			case MEANRELATIVESIZEINFORMATIONSPACEWEAKSETS:
				enterOuterAlt(_localctx, 15);
				{
				setState(73);
				match(MEANRELATIVESIZEINFORMATIONSPACEWEAKSETS);
				setState(74);
				match(OP);
				setState(75);
				match(DBL);
				setState(76);
				match(CP);
				}
				break;
			case MEANRELATIVESIZEINFORMATIONSPACEWEAKSETSMAX:
				enterOuterAlt(_localctx, 16);
				{
				setState(77);
				match(MEANRELATIVESIZEINFORMATIONSPACEWEAKSETSMAX);
				setState(78);
				match(OP);
				setState(79);
				match(DBL);
				setState(80);
				match(CP);
				}
				break;
			case MEANRELATIVESIZESTATESPACESTRONGSETS:
				enterOuterAlt(_localctx, 17);
				{
				setState(81);
				match(MEANRELATIVESIZESTATESPACESTRONGSETS);
				setState(82);
				match(OP);
				setState(83);
				match(DBL);
				setState(84);
				match(CP);
				}
				break;
			case MEANRELATIVESIZESTATESPACESTRONGSETSMAX:
				enterOuterAlt(_localctx, 18);
				{
				setState(85);
				match(MEANRELATIVESIZESTATESPACESTRONGSETSMAX);
				setState(86);
				match(OP);
				setState(87);
				match(DBL);
				setState(88);
				match(CP);
				}
				break;
			case MEANRELATIVESIZESTATESPACEWEAKSETS:
				enterOuterAlt(_localctx, 19);
				{
				setState(89);
				match(MEANRELATIVESIZESTATESPACEWEAKSETS);
				setState(90);
				match(OP);
				setState(91);
				match(DBL);
				setState(92);
				match(CP);
				}
				break;
			case MEANRELATIVESIZESTATESPACEWEAKSETSMAX:
				enterOuterAlt(_localctx, 20);
				{
				setState(93);
				match(MEANRELATIVESIZESTATESPACEWEAKSETSMAX);
				setState(94);
				match(OP);
				setState(95);
				match(DBL);
				setState(96);
				match(CP);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 21);
				{
				setState(97);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode NEG() { return getToken(PredicateSyntax.NEG, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OP() { return getToken(PredicateSyntax.OP, 0); }
		public TerminalNode CP() { return getToken(PredicateSyntax.CP, 0); }
		public Primitive_predicateContext primitive_predicate() {
			return getRuleContext(Primitive_predicateContext.class,0);
		}
		public TerminalNode AND() { return getToken(PredicateSyntax.AND, 0); }
		public TerminalNode OR() { return getToken(PredicateSyntax.OR, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateSyntaxListener ) ((PredicateSyntaxListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateSyntaxListener ) ((PredicateSyntaxListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PredicateSyntaxVisitor ) return ((PredicateSyntaxVisitor<? extends T>)visitor).visitExpression(this);
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEG:
				{
				setState(101);
				match(NEG);
				setState(102);
				expression(3);
				}
				break;
			case OP:
				{
				setState(103);
				match(OP);
				setState(104);
				expression(0);
				setState(105);
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
				setState(107);
				primitive_predicate();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(118);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(116);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(110);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(111);
						match(AND);
						setState(112);
						expression(6);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(113);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(114);
						match(OR);
						setState(115);
						expression(5);
						}
						break;
					}
					} 
				}
				setState(120);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
		case 2:
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
		"\u0004\u0001\'z\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001c\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002m\b\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002u\b\u0002\n\u0002"+
		"\f\u0002x\t\u0002\u0001\u0002\u0000\u0001\u0004\u0003\u0000\u0002\u0004"+
		"\u0000\u0000\u008e\u0000\u0006\u0001\u0000\u0000\u0000\u0002b\u0001\u0000"+
		"\u0000\u0000\u0004l\u0001\u0000\u0000\u0000\u0006\u0007\u0003\u0004\u0002"+
		"\u0000\u0007\b\u0005\u0000\u0000\u0001\b\u0001\u0001\u0000\u0000\u0000"+
		"\t\n\u0005\u0001\u0000\u0000\n\u000b\u0005\u0019\u0000\u0000\u000b\f\u0005"+
		"%\u0000\u0000\f\r\u0005\u001b\u0000\u0000\r\u000e\u0005%\u0000\u0000\u000e"+
		"c\u0005\u001a\u0000\u0000\u000f\u0010\u0005\u0002\u0000\u0000\u0010\u0011"+
		"\u0005\u0019\u0000\u0000\u0011\u0012\u0005%\u0000\u0000\u0012\u0013\u0005"+
		"\u001b\u0000\u0000\u0013\u0014\u0005%\u0000\u0000\u0014c\u0005\u001a\u0000"+
		"\u0000\u0015\u0016\u0005\u0003\u0000\u0000\u0016\u0017\u0005\u0019\u0000"+
		"\u0000\u0017\u0018\u0005%\u0000\u0000\u0018\u0019\u0005\u001b\u0000\u0000"+
		"\u0019\u001a\u0005%\u0000\u0000\u001ac\u0005\u001a\u0000\u0000\u001b\u001c"+
		"\u0005\u0004\u0000\u0000\u001c\u001d\u0005\u0019\u0000\u0000\u001d\u001e"+
		"\u0005%\u0000\u0000\u001e\u001f\u0005\u001b\u0000\u0000\u001f \u0005%"+
		"\u0000\u0000 c\u0005\u001a\u0000\u0000!\"\u0005\u0005\u0000\u0000\"#\u0005"+
		"\u0019\u0000\u0000#$\u0005$\u0000\u0000$c\u0005\u001a\u0000\u0000%&\u0005"+
		"\u0006\u0000\u0000&\'\u0005\u0019\u0000\u0000\'(\u0005$\u0000\u0000(c"+
		"\u0005\u001a\u0000\u0000)*\u0005\u0007\u0000\u0000*+\u0005\u0019\u0000"+
		"\u0000+,\u0005$\u0000\u0000,c\u0005\u001a\u0000\u0000-.\u0005\b\u0000"+
		"\u0000./\u0005\u0019\u0000\u0000/0\u0005$\u0000\u00000c\u0005\u001a\u0000"+
		"\u000012\u0005\t\u0000\u000023\u0005\u0019\u0000\u000034\u0005$\u0000"+
		"\u00004c\u0005\u001a\u0000\u000056\u0005\n\u0000\u000067\u0005\u0019\u0000"+
		"\u000078\u0005$\u0000\u00008c\u0005\u001a\u0000\u00009:\u0005\u000b\u0000"+
		"\u0000:;\u0005\u0019\u0000\u0000;<\u0005$\u0000\u0000<c\u0005\u001a\u0000"+
		"\u0000=>\u0005\f\u0000\u0000>?\u0005\u0019\u0000\u0000?@\u0005$\u0000"+
		"\u0000@c\u0005\u001a\u0000\u0000AB\u0005\r\u0000\u0000BC\u0005\u0019\u0000"+
		"\u0000CD\u0005$\u0000\u0000Dc\u0005\u001a\u0000\u0000EF\u0005\u000e\u0000"+
		"\u0000FG\u0005\u0019\u0000\u0000GH\u0005$\u0000\u0000Hc\u0005\u001a\u0000"+
		"\u0000IJ\u0005\u000f\u0000\u0000JK\u0005\u0019\u0000\u0000KL\u0005$\u0000"+
		"\u0000Lc\u0005\u001a\u0000\u0000MN\u0005\u0010\u0000\u0000NO\u0005\u0019"+
		"\u0000\u0000OP\u0005$\u0000\u0000Pc\u0005\u001a\u0000\u0000QR\u0005\u0011"+
		"\u0000\u0000RS\u0005\u0019\u0000\u0000ST\u0005$\u0000\u0000Tc\u0005\u001a"+
		"\u0000\u0000UV\u0005\u0012\u0000\u0000VW\u0005\u0019\u0000\u0000WX\u0005"+
		"$\u0000\u0000Xc\u0005\u001a\u0000\u0000YZ\u0005\u0013\u0000\u0000Z[\u0005"+
		"\u0019\u0000\u0000[\\\u0005$\u0000\u0000\\c\u0005\u001a\u0000\u0000]^"+
		"\u0005\u0014\u0000\u0000^_\u0005\u0019\u0000\u0000_`\u0005$\u0000\u0000"+
		"`c\u0005\u001a\u0000\u0000ac\u0005\u0015\u0000\u0000b\t\u0001\u0000\u0000"+
		"\u0000b\u000f\u0001\u0000\u0000\u0000b\u0015\u0001\u0000\u0000\u0000b"+
		"\u001b\u0001\u0000\u0000\u0000b!\u0001\u0000\u0000\u0000b%\u0001\u0000"+
		"\u0000\u0000b)\u0001\u0000\u0000\u0000b-\u0001\u0000\u0000\u0000b1\u0001"+
		"\u0000\u0000\u0000b5\u0001\u0000\u0000\u0000b9\u0001\u0000\u0000\u0000"+
		"b=\u0001\u0000\u0000\u0000bA\u0001\u0000\u0000\u0000bE\u0001\u0000\u0000"+
		"\u0000bI\u0001\u0000\u0000\u0000bM\u0001\u0000\u0000\u0000bQ\u0001\u0000"+
		"\u0000\u0000bU\u0001\u0000\u0000\u0000bY\u0001\u0000\u0000\u0000b]\u0001"+
		"\u0000\u0000\u0000ba\u0001\u0000\u0000\u0000c\u0003\u0001\u0000\u0000"+
		"\u0000de\u0006\u0002\uffff\uffff\u0000ef\u0005\u0018\u0000\u0000fm\u0003"+
		"\u0004\u0002\u0003gh\u0005\u0019\u0000\u0000hi\u0003\u0004\u0002\u0000"+
		"ij\u0005\u001a\u0000\u0000jm\u0001\u0000\u0000\u0000km\u0003\u0002\u0001"+
		"\u0000ld\u0001\u0000\u0000\u0000lg\u0001\u0000\u0000\u0000lk\u0001\u0000"+
		"\u0000\u0000mv\u0001\u0000\u0000\u0000no\n\u0005\u0000\u0000op\u0005\u0017"+
		"\u0000\u0000pu\u0003\u0004\u0002\u0006qr\n\u0004\u0000\u0000rs\u0005\u0016"+
		"\u0000\u0000su\u0003\u0004\u0002\u0005tn\u0001\u0000\u0000\u0000tq\u0001"+
		"\u0000\u0000\u0000ux\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000"+
		"vw\u0001\u0000\u0000\u0000w\u0005\u0001\u0000\u0000\u0000xv\u0001\u0000"+
		"\u0000\u0000\u0004bltv";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}