package specification;

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

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CompileSpecifications {

    private static String path="C://xampp//htdocs//specifications//";
    public static Pair<ParseTree,Entities> contextualAnalisisSpecification(String specificationName) throws IOException {
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

    public static void compileSpecifications() throws IOException, OWLOntologyCreationException {
        RepositoryHandler rh = new RepositoryHandler(path);
        for (File n : rh.get_files()) {
            Pair<ParseTree, Entities> tuple =
                    contextualAnalisisSpecification(n.getName());
            //tuple.b.showIndividuals();
            CompileSpecification compiler = new CompileSpecification();
            compiler.init(n.getName(), tuple.b);
            compiler.visit(tuple.a);
        }
    }
}
