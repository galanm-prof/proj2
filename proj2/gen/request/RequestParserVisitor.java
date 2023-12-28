// Generated from java-escape by ANTLR 4.11.1
package request;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RequestParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RequestParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RequestParser#req}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReq(RequestParser.ReqContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#vocabulary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVocabulary(RequestParser.VocabularyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#ontologies}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOntologies(RequestParser.OntologiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#inputs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputs(RequestParser.InputsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#iparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIparams(RequestParser.IparamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#iparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIparam(RequestParser.IparamContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#outputs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputs(RequestParser.OutputsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#oparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOparams(RequestParser.OparamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#oparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOparam(RequestParser.OparamContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(RequestParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#pairs_of_states}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairs_of_states(RequestParser.Pairs_of_statesContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#pair_of_states}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair_of_states(RequestParser.Pair_of_statesContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#precondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecondition(RequestParser.PreconditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#effect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEffect(RequestParser.EffectContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#sentences}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentences(RequestParser.SentencesContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(RequestParser.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(RequestParser.SetContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#set_and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_and(RequestParser.Set_andContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#set_base}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_base(RequestParser.Set_baseContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#property_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty_set(RequestParser.Property_setContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#neg_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeg_set(RequestParser.Neg_setContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#inv_property_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInv_property_set(RequestParser.Inv_property_setContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#inv_property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInv_property(RequestParser.Inv_propertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#class_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_set(RequestParser.Class_setContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#anonymous_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonymous_set(RequestParser.Anonymous_setContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#set1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet1(RequestParser.Set1Context ctx);
	/**
	 * Visit a parse tree produced by {@link RequestParser#terms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerms(RequestParser.TermsContext ctx);
}