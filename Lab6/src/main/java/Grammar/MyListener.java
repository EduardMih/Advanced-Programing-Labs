package Grammar;

public class MyListener extends myGrammarBaseListener{
    @Override
    public void exitAction(myGrammarParser.ActionContext ctx)
    {
        super.exitAction(ctx);
        System.out.println(ctx.getText());

    }
}
