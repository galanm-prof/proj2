// Generated from java-escape by ANTLR 4.11.1
package request;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RequestParser}.
 */
public interface RequestParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RequestParser#req}.
	 * @param ctx the parse tree
	 */
	void enterReq(RequestParser.ReqContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#req}.
	 * @param ctx the parse tree
	 */
	void exitReq(RequestParser.ReqContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#vocabulary}.
	 * @param ctx the parse tree
	 */
	void enterVocabulary(RequestParser.VocabularyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#vocabulary}.
	 * @param ctx the parse tree
	 */
	void exitVocabulary(RequestParser.VocabularyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#ontologies}.
	 * @param ctx the parse tree
	 */
	void enterOntologies(RequestParser.OntologiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#ontologies}.
	 * @param ctx the parse tree
	 */
	void exitOntologies(RequestParser.OntologiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#inputs}.
	 * @param ctx the parse tree
	 */
	void enterInputs(RequestParser.InputsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#inputs}.
	 * @param ctx the parse tree
	 */
	void exitInputs(RequestParser.InputsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#iparams}.
	 * @param ctx the parse tree
	 */
	void enterIparams(RequestParser.IparamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#iparams}.
	 * @param ctx the parse tree
	 */
	void exitIparams(RequestParser.IparamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#iparam}.
	 * @param ctx the parse tree
	 */
	void enterIparam(RequestParser.IparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#iparam}.
	 * @param ctx the parse tree
	 */
	void exitIparam(RequestParser.IparamContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#outputs}.
	 * @param ctx the parse tree
	 */
	void enterOutputs(RequestParser.OutputsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#outputs}.
	 * @param ctx the parse tree
	 */
	void exitOutputs(RequestParser.OutputsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#oparams}.
	 * @param ctx the parse tree
	 */
	void enterOparams(RequestParser.OparamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#oparams}.
	 * @param ctx the parse tree
	 */
	void exitOparams(RequestParser.OparamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#oparam}.
	 * @param ctx the parse tree
	 */
	void enterOparam(RequestParser.OparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#oparam}.
	 * @param ctx the parse tree
	 */
	void exitOparam(RequestParser.OparamContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(RequestParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(RequestParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#pairs_of_states}.
	 * @param ctx the parse tree
	 */
	void enterPairs_of_states(RequestParser.Pairs_of_statesContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#pairs_of_states}.
	 * @param ctx the parse tree
	 */
	void exitPairs_of_states(RequestParser.Pairs_of_statesContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#pair_of_states}.
	 * @param ctx the parse tree
	 */
	void enterPair_of_states(RequestParser.Pair_of_statesContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#pair_of_states}.
	 * @param ctx the parse tree
	 */
	void exitPair_of_states(RequestParser.Pair_of_statesContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#precondition}.
	 * @param ctx the parse tree
	 */
	void enterPrecondition(RequestParser.PreconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#precondition}.
	 * @param ctx the parse tree
	 */
	void exitPrecondition(RequestParser.PreconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#effect}.
	 * @param ctx the parse tree
	 */
	void enterEffect(RequestParser.EffectContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#effect}.
	 * @param ctx the parse tree
	 */
	void exitEffect(RequestParser.EffectContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#sentences}.
	 * @param ctx the parse tree
	 */
	void enterSentences(RequestParser.SentencesContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#sentences}.
	 * @param ctx the parse tree
	 */
	void exitSentences(RequestParser.SentencesContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(RequestParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(RequestParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSet(RequestParser.SetContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSet(RequestParser.SetContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#set_and}.
	 * @param ctx the parse tree
	 */
	void enterSet_and(RequestParser.Set_andContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#set_and}.
	 * @param ctx the parse tree
	 */
	void exitSet_and(RequestParser.Set_andContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#set_base}.
	 * @param ctx the parse tree
	 */
	void enterSet_base(RequestParser.Set_baseContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#set_base}.
	 * @param ctx the parse tree
	 */
	void exitSet_base(RequestParser.Set_baseContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#property_set}.
	 * @param ctx the parse tree
	 */
	void enterProperty_set(RequestParser.Property_setContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#property_set}.
	 * @param ctx the parse tree
	 */
	void exitProperty_set(RequestParser.Property_setContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#neg_set}.
	 * @param ctx the parse tree
	 */
	void enterNeg_set(RequestParser.Neg_setContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#neg_set}.
	 * @param ctx the parse tree
	 */
	void exitNeg_set(RequestParser.Neg_setContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#inv_property_set}.
	 * @param ctx the parse tree
	 */
	void enterInv_property_set(RequestParser.Inv_property_setContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#inv_property_set}.
	 * @param ctx the parse tree
	 */
	void exitInv_property_set(RequestParser.Inv_property_setContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#inv_property}.
	 * @param ctx the parse tree
	 */
	void enterInv_property(RequestParser.Inv_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#inv_property}.
	 * @param ctx the parse tree
	 */
	void exitInv_property(RequestParser.Inv_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#class_set}.
	 * @param ctx the parse tree
	 */
	void enterClass_set(RequestParser.Class_setContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#class_set}.
	 * @param ctx the parse tree
	 */
	void exitClass_set(RequestParser.Class_setContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#anonymous_set}.
	 * @param ctx the parse tree
	 */
	void enterAnonymous_set(RequestParser.Anonymous_setContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#anonymous_set}.
	 * @param ctx the parse tree
	 */
	void exitAnonymous_set(RequestParser.Anonymous_setContext ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#set1}.
	 * @param ctx the parse tree
	 */
	void enterSet1(RequestParser.Set1Context ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#set1}.
	 * @param ctx the parse tree
	 */
	void exitSet1(RequestParser.Set1Context ctx);
	/**
	 * Enter a parse tree produced by {@link RequestParser#terms}.
	 * @param ctx the parse tree
	 */
	void enterTerms(RequestParser.TermsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RequestParser#terms}.
	 * @param ctx the parse tree
	 */
	void exitTerms(RequestParser.TermsContext ctx);
}