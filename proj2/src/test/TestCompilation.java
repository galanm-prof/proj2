package test;

import common.ContextualError;
import common.Entities;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ParseTree;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import request.*;
import specification.*;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class TestCompilation {

    private static String path="C://xampp//htdocs//specifications//";
    private static String path2="C://xampp//htdocs//requests//";
    public static Pair<ParseTree, Entities> contextualAnalisisSpecification(String specificationName) throws IOException {
        CharStream f = CharStreams.fromFileName(path + specificationName);
        SpecificationLexer analex = new SpecificationLexer(f);
        CommonTokenStream ts = new CommonTokenStream(analex);
        SpecificationParser parser = new SpecificationParser(ts);
        ParseTree tree = parser.spec();

        System.out.println("SERVICE: "+specificationName);
        ContextualAnalysisSpecification contextualAnalyser =
                new ContextualAnalysisSpecification();
        contextualAnalyser.init(specificationName);
        Pair<Entities, List<ContextualError>> r =
                contextualAnalyser.visit(tree);

        return new Pair<ParseTree, Entities>(tree,r.a);
    }

    public static Pair<ParseTree, Entities> contextualAnalisisRequest(String requestName) throws IOException {
        CharStream f = CharStreams.fromFileName(path2 + requestName);
        RequestLexer analex = new RequestLexer(f);
        CommonTokenStream ts = new CommonTokenStream(analex);
        RequestParser parser = new RequestParser(ts);
        ParseTree tree = parser.req();

        System.out.println("REQUEST: "+requestName);
        ContextualAnalysisRequest contextualAnalyser =
                new ContextualAnalysisRequest();
        contextualAnalyser.init(requestName);
        Pair<Entities, List<ContextualError>> r =
                contextualAnalyser.visit(tree);

        return new Pair<ParseTree, Entities>(tree,r.a);
    }
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

    public static void main(String[] args) throws IOException, OWLOntologyCreationException {
        Calendar begin = Calendar.getInstance();
        long time1 = begin.getTimeInMillis();
        CompileRequests.compileRequests();
        CompileSpecifications.compileSpecifications();

        /*
        String name="CITYCOUNTRY_ACCOMMODATION_REQUEST.txt";
        Pair<ParseTree,Entities>tuple =
                contextualAnalisisRequest(name);
        CompileRequest compiler = new CompileRequest();
        compiler.init(name,tuple.b);
        compiler.visit(tuple.a);
        */
        Calendar end = Calendar.getInstance();
        long time2 = end.getTimeInMillis();
        System.out.println("Amount of time (in seconds): " + (time2 - time1) / 1000.0);

    }
}
