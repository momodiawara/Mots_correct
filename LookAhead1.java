import java.io.*;

class LookAhead1  {
    /* Simulating a reader class for a stream of Token */
    
    private Token current;
    private Lexer lexer;

    public LookAhead1(Lexer l) 
	throws Exception, IOException, LexerException {
	lexer=l;
	current=lexer.yylex();
    }

    public boolean check(Sym s) {
	/* check whether the first character is of type s*/
        return (current.symbol() == s); 
    }

    public void eat(Sym s)
	throws Exception {
	/* consumes a token of type s from the stream,
	   exception when the contents does not start on s.   */
	if (!check(s)) {
	    throw new Exception("Erreur");
	}
        current=lexer.yylex();

    }

    public int getIntValue ()
	throws Exception {
	/* returns the value of an integer token */
	if(current.symbol()==Sym.INT)
	    return ((IntToken)current).value();
	else 
	    throw new Exception("Erreur");
    }

    public char getCharValue ()
	throws Exception {
	/* returns the value of a char token */
	if(current.symbol()==Sym.OP)
	    return ((OpToken)current).value();
	else
	    throw new Exception("Erreur");
    }

}
