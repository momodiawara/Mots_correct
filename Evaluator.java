import java.io.*;

class Evaluator {
    protected LookAhead1 reader;

    public Evaluator(LookAhead1 r)
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

	public boolean atNonTerm()throws Exception{
		if(reader.check(Sym.VRAI)){
			reader.eat(Sym.VRAI);
      return true;
		}
		else if(reader.check(Sym.FAUX)){
			reader.eat(Sym.FAUX);
      return true;
		}
		else if(reader.check(Sym.INT)){
			int a=intTerm();
			char c=opTerm();
			int b=intTerm();
      if(c=='=') return a==b;
      return a>b;
		}else{
      throw new Exception();
    }
	}

	public int intTerm()throws Exception{
    int a=-99;
    if(reader.check(Sym.INT)){
        a=reader.getIntValue();
        reader.eat(Sym.INT);
		}
    return a;
  }
	public char opTerm()throws Exception{
    char c='*';
    if(reader.check(Sym.OP)){
      c=reader.getCharValue();
      reader.eat(Sym.OP);
		}
    return c;
	}
}
