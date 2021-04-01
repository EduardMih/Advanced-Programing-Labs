// Generated from D:/Advanced-Programing-Labs/Lab6/src/main/java/Grammar\myGrammar.g4 by ANTLR 4.9.1
package Grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link myGrammarParser}.
 */
public interface myGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#comm}.
	 * @param ctx the parse tree
	 */
	void enterComm(myGrammarParser.CommContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#comm}.
	 * @param ctx the parse tree
	 */
	void exitComm(myGrammarParser.CommContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(myGrammarParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(myGrammarParser.ActionContext ctx);
}