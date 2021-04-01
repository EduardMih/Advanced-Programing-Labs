// Generated from D:/Advanced-Programing-Labs/Lab6/src/main/java/Grammar\myGrammar.g4 by ANTLR 4.9.1
package Grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link myGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface myGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link myGrammarParser#comm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComm(myGrammarParser.CommContext ctx);
	/**
	 * Visit a parse tree produced by {@link myGrammarParser#action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction(myGrammarParser.ActionContext ctx);
}