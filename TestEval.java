import java.io.*;

class TestEval {

    public static void main(String[] args) throws Exception {
	File input = new File(args[0]);
	Reader reader = new FileReader(input);
	Lexer lexer = new Lexer(reader);
	LookAhead1 look = new LookAhead1(lexer);
        Evaluator parser = new Evaluator(look);
	parser.axiom();
	System.out.println("\nMot accepté");
    }
}
