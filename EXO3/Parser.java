import java.io.*;

class Parser {
    protected LookAhead1 reader;

    public Parser(LookAhead1 r)
      throws IOException {
        reader = r;
    }

    public void axiom() throws Exception {
        propNonTerm();
        reader.eat(Sym.EOF);

    }
    public void propNonTerm()throws Exception{
      if(reader.check(Sym.SI)){
    		reader.eat(Sym.SI);
    		propNonTerm();
    		reader.eat(Sym.ALORS);
    		propNonTerm();
    	}
    	else if(reader.check(Sym.NON)){
    		reader.eat(Sym.NON);
    		reader.eat(Sym.LPAR);
    		propNonTerm();
    		reader.eat(Sym.RPAR);
    	}
      else if(!reader.check(Sym.NON) && !reader.check(Sym.SI)){
    		atNonTerm();
    	}

      else{
        throw new Exception();
      }
    }

	public void atNonTerm()throws Exception{
		if(reader.check(Sym.VRAI)){
			reader.eat(Sym.VRAI);
		}
		else if(reader.check(Sym.FAUX)){
			reader.eat(Sym.FAUX);
		}
		else if(reader.check(Sym.INT)){
			intTerm();
			opTerm();
			intTerm();
		}else{
      throw new Exception();
    }
	}

	public void intTerm()throws Exception{
		if(reader.check(Sym.INT)){
			reader.eat(Sym.INT);
		}
	}
	public void opTerm()throws Exception{
		if(reader.check(Sym.OP)){
			reader.eat(Sym.OP);
		}
	}
}
