%%
%public
%class Lexer
%unicode
%type Token
%line
%column

%{
  private Token token(Sym type) {
      return new Token(type);
  }

  private IntToken token(Sym type, int value) {
      return new IntToken(type,value);
      }

  private OpToken token(Sym type, char value) {
      return new OpToken(type,value);
  }
%}

%yylexthrow{
Exception, LexerException
%yylexthrow}

%eofval{
  return token(Sym.EOF);
%eofval}

blank = "\n" | "\r" | " " | "\t"
operator = "<" | "="
int = [1-9][0-9]* | 0

%%
"("     {return token(Sym.LPAR);}
")"     {return token(Sym.RPAR);}
"si"    {return token(Sym.SI);}
"alors" {return token(Sym.ALORS);}
"vrai"  {return token(Sym.VRAI);}
"faux"  {return token(Sym.FAUX);}
"non"   {return token(Sym.NON);}
"Yacine" {return token(Sym.INT,0);}
"yacine" {return token(Sym.INT,0);}
{int}   {return token(Sym.INT,Integer.parseInt(yytext()));}
{operator} {return token(Sym.OP,yytext().charAt(0));}
{blank} {}
[^]     {throw new Exception("Erreur");}
