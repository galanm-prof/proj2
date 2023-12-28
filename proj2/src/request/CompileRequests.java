package request;

import common.ContextualError;
import common.Entities;
import file.RepositoryHandler;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ParseTree;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import specification.CompileSpecification;
import specification.ContextualAnalysisSpecification;
import specification.SpecificationLexer;
import specification.SpecificationParser;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CompileRequests {

    private static String path="C://xampp//htdocs//requests//";
    public static Pair<ParseTree,Entities> contextualAnalisisRequest(String requestName) throws IOException {
        CharStream f = CharStreams.fromFileName(path + requestName);
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
    private static void showParseTree(RequestParser parser,ParseTree tree){
        JFrame frame = new JFrame("Antlr ParseTree (Request)");
        TreeViewer v = new TreeViewer(Arrays.asList(parser.getRuleNames()),tree);
        JScrollPane panel = new JScrollPane(v);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000,300);
        frame.setVisible(true);
    }

    public static void compileRequests() throws IOException, OWLOntologyCreationException {
        RepositoryHandler rh = new RepositoryHandler(path);
        for (File n : rh.get_files()) {
            Pair<ParseTree, Entities> tuple =
                    contextualAnalisisRequest(n.getName());
            //tuple.b.showIndividuals();
            CompileRequest compiler = new CompileRequest();
            compiler.init(n.getName(), tuple.b);
            compiler.visit(tuple.a);
        }
    }
}
