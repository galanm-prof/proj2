// Generated from java-escape by ANTLR 4.11.1
package specification;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SpecificationParser}.
 */
public interface SpecificationParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#spec}.
	 * @param ctx the parse tree
	 */
	void enterSpec(SpecificationParser.SpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#spec}.
	 * @param ctx the parse tree
	 */
	void exitSpec(SpecificationParser.SpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#vocabulary}.
	 * @param ctx the parse tree
	 */
	void enterVocabulary(SpecificationParser.VocabularyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#vocabulary}.
	 * @param ctx the parse tree
	 */
	void exitVocabulary(SpecificationParser.VocabularyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#ontologies}.
	 * @param ctx the parse tree
	 */
	void enterOntologies(SpecificationParser.OntologiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#ontologies}.
	 * @param ctx the parse tree
	 */
	void exitOntologies(SpecificationParser.OntologiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#inputs}.
	 * @param ctx the parse tree
	 */
	void enterInputs(SpecificationParser.InputsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#inputs}.
	 * @param ctx the parse tree
	 */
	void exitInputs(SpecificationParser.InputsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#iparams}.
	 * @param ctx the parse tree
	 */
	void enterIparams(SpecificationParser.IparamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#iparams}.
	 * @param ctx the parse tree
	 */
	void exitIparams(SpecificationParser.IparamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#iparam}.
	 * @param ctx the parse tree
	 */
	void enterIparam(SpecificationParser.IparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#iparam}.
	 * @param ctx the parse tree
	 */
	void exitIparam(SpecificationParser.IparamContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#outputs}.
	 * @param ctx the parse tree
	 */
	void enterOutputs(SpecificationParser.OutputsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#outputs}.
	 * @param ctx the parse tree
	 */
	void exitOutputs(SpecificationParser.OutputsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#oparams}.
	 * @param ctx the parse tree
	 */
	void enterOparams(SpecificationParser.OparamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#oparams}.
	 * @param ctx the parse tree
	 */
	void exitOparams(SpecificationParser.OparamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#oparam}.
	 * @param ctx the parse tree
	 */
	void enterOparam(SpecificationParser.OparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#oparam}.
	 * @param ctx the parse tree
	 */
	void exitOparam(SpecificationParser.OparamContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SpecificationParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SpecificationParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#pairs_of_states}.
	 * @param ctx the parse tree
	 */
	void enterPairs_of_states(SpecificationParser.Pairs_of_statesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#pairs_of_states}.
	 * @param ctx the parse tree
	 */
	void exitPairs_of_states(SpecificationParser.Pairs_of_statesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#pair_of_states}.
	 * @param ctx the parse tree
	 */
	void enterPair_of_states(SpecificationParser.Pair_of_statesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#pair_of_states}.
	 * @param ctx the parse tree
	 */
	void exitPair_of_states(SpecificationParser.Pair_of_statesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#precondition}.
	 * @param ctx the parse tree
	 */
	void enterPrecondition(SpecificationParser.PreconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#precondition}.
	 * @param ctx the parse tree
	 */
	void exitPrecondition(SpecificationParser.PreconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#effect}.
	 * @param ctx the parse tree
	 */
	void enterEffect(SpecificationParser.EffectContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#effect}.
	 * @param ctx the parse tree
	 */
	void exitEffect(SpecificationParser.EffectContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#sentences}.
	 * @param ctx the parse tree
	 */
	void enterSentences(SpecificationParser.SentencesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#sentences}.
	 * @param ctx the parse tree
	 */
	void exitSentences(SpecificationParser.SentencesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(SpecificationParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(SpecificationParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSet(SpecificationParser.SetContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSet(SpecificationParser.SetContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#set_and}.
	 * @param ctx the parse tree
	 */
	void enterSet_and(SpecificationParser.Set_andContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#set_and}.
	 * @param ctx the parse tree
	 */
	void exitSet_and(SpecificationParser.Set_andContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#set_base}.
	 * @param ctx the parse tree
	 */
	void enterSet_base(SpecificationParser.Set_baseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#set_base}.
	 * @param ctx the parse tree
	 */
	void exitSet_base(SpecificationParser.Set_baseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#property_set}.
	 * @param ctx the parse tree
	 */
	void enterProperty_set(SpecificationParser.Property_setContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#property_set}.
	 * @param ctx the parse tree
	 */
	void exitProperty_set(SpecificationParser.Property_setContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#neg_set}.
	 * @param ctx the parse tree
	 */
	void enterNeg_set(SpecificationParser.Neg_setContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#neg_set}.
	 * @param ctx the parse tree
	 */
	void exitNeg_set(SpecificationParser.Neg_setContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#inv_property_set}.
	 * @param ctx the parse tree
	 */
	void enterInv_property_set(SpecificationParser.Inv_property_setContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#inv_property_set}.
	 * @param ctx the parse tree
	 */
	void exitInv_property_set(SpecificationParser.Inv_property_setContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#inv_property}.
	 * @param ctx the parse tree
	 */
	void enterInv_property(SpecificationParser.Inv_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#inv_property}.
	 * @param ctx the parse tree
	 */
	void exitInv_property(SpecificationParser.Inv_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#class_set}.
	 * @param ctx the parse tree
	 */
	void enterClass_set(SpecificationParser.Class_setContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#class_set}.
	 * @param ctx the parse tree
	 */
	void exitClass_set(SpecificationParser.Class_setContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#anonymous_set}.
	 * @param ctx the parse tree
	 */
	void enterAnonymous_set(SpecificationParser.Anonymous_setContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#anonymous_set}.
	 * @param ctx the parse tree
	 */
	void exitAnonymous_set(SpecificationParser.Anonymous_setContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#set1}.
	 * @param ctx the parse tree
	 */
	void enterSet1(SpecificationParser.Set1Context ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#set1}.
	 * @param ctx the parse tree
	 */
	void exitSet1(SpecificationParser.Set1Context ctx);
	/**
	 * Enter a parse tree produced by {@link SpecificationParser#terms}.
	 * @param ctx the parse tree
	 */
	void enterTerms(SpecificationParser.TermsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpecificationParser#terms}.
	 * @param ctx the parse tree
	 */
	void exitTerms(SpecificationParser.TermsContext ctx);
}