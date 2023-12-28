// Generated from java-escape by ANTLR 4.11.1
package repositories;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PredicateSyntax}.
 */
public interface PredicateSyntaxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PredicateSyntax#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(PredicateSyntax.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PredicateSyntax#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(PredicateSyntax.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link PredicateSyntax#primitive_predicate}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive_predicate(PredicateSyntax.Primitive_predicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PredicateSyntax#primitive_predicate}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive_predicate(PredicateSyntax.Primitive_predicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link PredicateSyntax#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PredicateSyntax.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PredicateSyntax#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PredicateSyntax.ExpressionContext ctx);
}