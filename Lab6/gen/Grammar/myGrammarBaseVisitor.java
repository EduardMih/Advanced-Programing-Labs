// Generated from D:/Advanced-Programing-Labs/Lab6/src/main/java/Grammar\myGrammar.g4 by ANTLR 4.9.1
package Grammar;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link myGrammarVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class myGrammarBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements myGrammarVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitComm(myGrammarParser.CommContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAction(myGrammarParser.ActionContext ctx) { return visitChildren(ctx); }
}