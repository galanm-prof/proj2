// Generated from C:/Investigacion/prototypes/proj2/src/experiment\ParserExperiment.g4 by ANTLR 4.8
package experiment;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ParserExperiment}.
 */
public interface ParserExperimentListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ParserExperiment#experiment}.
	 * @param ctx the parse tree
	 */
	void enterExperiment(ParserExperiment.ExperimentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserExperiment#experiment}.
	 * @param ctx the parse tree
	 */
	void exitExperiment(ParserExperiment.ExperimentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserExperiment#repositories}.
	 * @param ctx the parse tree
	 */
	void enterRepositories(ParserExperiment.RepositoriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserExperiment#repositories}.
	 * @param ctx the parse tree
	 */
	void exitRepositories(ParserExperiment.RepositoriesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserExperiment#requests}.
	 * @param ctx the parse tree
	 */
	void enterRequests(ParserExperiment.RequestsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserExperiment#requests}.
	 * @param ctx the parse tree
	 */
	void exitRequests(ParserExperiment.RequestsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserExperiment#reqs}.
	 * @param ctx the parse tree
	 */
	void enterReqs(ParserExperiment.ReqsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserExperiment#reqs}.
	 * @param ctx the parse tree
	 */
	void exitReqs(ParserExperiment.ReqsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserExperiment#repository}.
	 * @param ctx the parse tree
	 */
	void enterRepository(ParserExperiment.RepositoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserExperiment#repository}.
	 * @param ctx the parse tree
	 */
	void exitRepository(ParserExperiment.RepositoryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserExperiment#searching}.
	 * @param ctx the parse tree
	 */
	void enterSearching(ParserExperiment.SearchingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserExperiment#searching}.
	 * @param ctx the parse tree
	 */
	void exitSearching(ParserExperiment.SearchingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserExperiment#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(ParserExperiment.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserExperiment#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(ParserExperiment.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserExperiment#primitive_predicate}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive_predicate(ParserExperiment.Primitive_predicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserExperiment#primitive_predicate}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive_predicate(ParserExperiment.Primitive_predicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserExperiment#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ParserExperiment.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserExperiment#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ParserExperiment.ExpressionContext ctx);
}