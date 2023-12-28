// Generated from java-escape by ANTLR 4.11.1
package specification;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SpecificationParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SpecificationParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpec(SpecificationParser.SpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#vocabulary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVocabulary(SpecificationParser.VocabularyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#ontologies}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOntologies(SpecificationParser.OntologiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#inputs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputs(SpecificationParser.InputsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#iparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIparams(SpecificationParser.IparamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#iparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIparam(SpecificationParser.IparamContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#outputs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputs(SpecificationParser.OutputsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#oparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOparams(SpecificationParser.OparamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#oparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOparam(SpecificationParser.OparamContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SpecificationParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#pairs_of_states}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairs_of_states(SpecificationParser.Pairs_of_statesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#pair_of_states}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair_of_states(SpecificationParser.Pair_of_statesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#precondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecondition(SpecificationParser.PreconditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#effect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEffect(SpecificationParser.EffectContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#sentences}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentences(SpecificationParser.SentencesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(SpecificationParser.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(SpecificationParser.SetContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#set_and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_and(SpecificationParser.Set_andContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#set_base}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_base(SpecificationParser.Set_baseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#property_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty_set(SpecificationParser.Property_setContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#neg_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeg_set(SpecificationParser.Neg_setContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#inv_property_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInv_property_set(SpecificationParser.Inv_property_setContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#inv_property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInv_property(SpecificationParser.Inv_propertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#class_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_set(SpecificationParser.Class_setContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#anonymous_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonymous_set(SpecificationParser.Anonymous_setContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#set1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet1(SpecificationParser.Set1Context ctx);
	/**
	 * Visit a parse tree produced by {@link SpecificationParser#terms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerms(SpecificationParser.TermsContext ctx);
}