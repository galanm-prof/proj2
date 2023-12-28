package test;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import repositories.PredicateLexer;
import repositories.PredicateSyntax;
import specification.SpecificationLexer;
import specification.SpecificationParser;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;

public class TestPredicate {

    private static void showParseTree(PredicateSyntax parser,ParseTree tree){
        JFrame frame = new JFrame("Antlr ParseTree (Predicate)");
        TreeViewer v = new TreeViewer(Arrays.asList(parser.getRuleNames()),tree);
        JScrollPane panel = new JScrollPane(v);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000,300);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        CharStream f = CharStreams.fromFileName(args[0]);
        PredicateLexer analex = new PredicateLexer(f);
        CommonTokenStream ts = new CommonTokenStream(analex);
        PredicateSyntax parser = new PredicateSyntax(ts);
        ParseTree tree = parser.predicate();
        showParseTree(parser, tree);
    }
}
