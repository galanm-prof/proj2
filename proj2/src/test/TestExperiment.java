package test;

import experiment.CompileExperiment;
import experiment.LexerExperiment;
import experiment.ParserExperiment;
import experiment.SemanticAnalyserExperiment;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestExperiment {

    private static void showParseTree(ParserExperiment parser, ParseTree tree){
        JFrame frame = new JFrame("Antlr ParseTree (Experiment)");
        TreeViewer v = new TreeViewer(Arrays.asList(parser.getRuleNames()),tree);
        JScrollPane panel = new JScrollPane(v);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000,300);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        String name="experimentA_5c.txt";
        CharStream f = CharStreams.fromFileName("./src/experiments/"+name);
        LexerExperiment analex = new LexerExperiment(f);
        CommonTokenStream ts = new CommonTokenStream(analex);
        ParserExperiment parser = new ParserExperiment(ts);
        ParseTree tree = parser.experiment();
        //showParseTree(parser, tree);
        System.out.println("Semantic analisys...");
        SemanticAnalyserExperiment semanticAnalyser = new SemanticAnalyserExperiment();
        List<String> errors=semanticAnalyser.visit(tree);
        errors.stream().forEach(e->System.out.println(e));
        if (errors.size()==0){
            System.out.println("Compiling...");
            CompileExperiment compiler = new CompileExperiment();
            compiler.init(name.replace(".txt",""));
            compiler.visit(tree);
        }
        System.out.println("Compilation done");
        //showParseTree(parser, tree);
    }
}
