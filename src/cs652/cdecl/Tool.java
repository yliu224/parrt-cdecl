package cs652.cdecl;

import g4.CDeclLexer;
import g4.CDeclParser;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Tool {
	public static void main(String[] args) {
		// YOU MUST FILL THIS IN
		translate("int *a");
	}

	public static String translate(String cdeclText) {
		ANTLRInputStream input = new ANTLRInputStream(cdeclText);
		CDeclLexer lexer = new CDeclLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CDeclParser parser = new CDeclParser(tokens);
		ParseTree tree = parser.declaration();
		System.out.println(tree.toStringTree(parser));
		Trees.inspect(tree, parser);

		return "";
	}
}
