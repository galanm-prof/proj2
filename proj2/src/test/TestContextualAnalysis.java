package test;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ParseTree;
import request.ContextualAnalysisRequests;
import specification.ContextualAnalysisSpecifications;
import specification.SpecificationParser;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;

public class TestContextualAnalysis {

    private static void showParseTree(SpecificationParser parser,ParseTree tree){
        JFrame frame = new JFrame("Antlr ParseTree (Specification)");
        TreeViewer v = new TreeViewer(Arrays.asList(parser.getRuleNames()),tree);
        JScrollPane panel = new JScrollPane(v);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000,300);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        //The the contextual analysis of all specifications
        ContextualAnalysisRequests.contextualAnalysisRequests();
        //ContextualAnalysisSpecifications.contextualAnalysisSpecifications();
        /*
        //Test the contextual analysis of a specification
        Pair<SpecificationParser,ParseTree> tuple=ContextualAnalysisSpecifications.
                contextualAnalisisSpecification("PLACES_WITHIN_CITY_SERVICE.txt");
        showParseTree(tuple.a,tuple.b);
         */
    }
}
