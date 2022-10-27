class Token {
    protected Sym symbol;
    public Token(Sym s) {
	symbol=s;
    }
    public Sym symbol() {
	return symbol;
    }
    public String toString(){
	return "Symbol : "+this.symbol;
    }
}

class IntToken extends Token {
    private int value;
    public IntToken(Sym c, int n) {
	super(c);
	value=n;
    }
    public int value() {
	return value;
    }
    public boolean isEqual(Token t){
	return (t.symbol()==Sym.INT && ((IntToken)t).value()==this.value);
    }
    public String toString(){
	return "Symbol : "+this.symbol+" | Value : "+this.value();
    }
}

class OpToken extends Token {
    private char value;
    public OpToken(Sym c, char op) {
	super(c);
	value=op;
    }
    public char value() {
	return value;
    }
    public boolean isEqual(Token t){
	return (t.symbol()==Sym.OP && ((OpToken)t).value()==this.value);
    }
    public String toString(){
	return "Symbol : "+this.symbol+" | Value : "+this.value();
    }
}

