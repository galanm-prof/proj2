package specification;

import common.ContextualError;
import common.Entities;
import file.RepositoryHandler;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ContextualAnalysisSpecifications {
    private static String path="C://xampp//htdocs//specifications//";
    public static Pair<SpecificationParser,ParseTree> contextualAnalisisSpecification(String specificationName) throws IOException {
        CharStream f = CharStreams.fromFileName(path + specificationName);
        SpecificationLexer analex = new SpecificationLexer(f);
        CommonTokenStream ts = new CommonTokenStream(analex);
        SpecificationParser parser = new SpecificationParser(ts);
        ParseTree tree = parser.spec();

        System.out.println("SERVICE SPECIFICATION: "+specificationName);
        ContextualAnalysisSpecification contextualAnalyser =
                new ContextualAnalysisSpecification();
        contextualAnalyser.init(specificationName);
        Pair<Entities, List<ContextualError>> r =
                contextualAnalyser.visit(tree);
        System.out.println(specificationName+"  Number of errors: "+r.b.size());
        System.out.println(specificationName+"  Errors: "+r.b);
        //r.a.showIndividuals();
        return new Pair<>(parser,tree);
    }

    public static void contextualAnalysisSpecifications() throws IOException {
        RepositoryHandler rh = new RepositoryHandler(path);
        for (File n:rh.get_files())
            contextualAnalisisSpecification(n.getName());
    }
}
