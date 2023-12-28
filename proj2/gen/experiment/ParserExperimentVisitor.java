// Generated from C:/Investigacion/prototypes/proj2/src/experiment\ParserExperiment.g4 by ANTLR 4.8
package experiment;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ParserExperiment}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ParserExperimentVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ParserExperiment#experiment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExperiment(ParserExperiment.ExperimentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserExperiment#repositories}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepositories(ParserExperiment.RepositoriesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserExperiment#requests}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequests(ParserExperiment.RequestsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserExperiment#reqs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReqs(ParserExperiment.ReqsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserExperiment#repository}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepository(ParserExperiment.RepositoryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserExperiment#searching}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearching(ParserExperiment.SearchingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserExperiment#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(ParserExperiment.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserExperiment#primitive_predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive_predicate(ParserExperiment.Primitive_predicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParserExperiment#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ParserExperiment.ExpressionContext ctx);
}