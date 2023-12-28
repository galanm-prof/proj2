// Generated from java-escape by ANTLR 4.11.1
package repositories;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PredicateSyntax}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PredicateSyntaxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PredicateSyntax#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(PredicateSyntax.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PredicateSyntax#primitive_predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive_predicate(PredicateSyntax.Primitive_predicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PredicateSyntax#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PredicateSyntax.ExpressionContext ctx);
}