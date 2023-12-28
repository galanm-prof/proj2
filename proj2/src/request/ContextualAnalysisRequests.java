package request;

import common.ContextualError;
import common.Entities;
import file.RepositoryHandler;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ParseTree;
import specification.ContextualAnalysisSpecification;
import specification.SpecificationLexer;
import specification.SpecificationParser;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ContextualAnalysisRequests {
    private static String path="C://xampp//htdocs//requests//";
    public static Pair<RequestParser,ParseTree> contextualAnalisisRequest(String requestName) throws IOException {
        CharStream f = CharStreams.fromFileName(path + requestName);
        RequestLexer analex = new RequestLexer(f);
        CommonTokenStream ts = new CommonTokenStream(analex);
        RequestParser parser = new RequestParser(ts);
        ParseTree tree = parser.req();

        System.out.println("SERVICE REQUEST: "+requestName);
        ContextualAnalysisRequest contextualAnalyser =
                new ContextualAnalysisRequest();
        contextualAnalyser.init(requestName);
        Pair<Entities, List<ContextualError>> r =
                contextualAnalyser.visit(tree);
        System.out.println(requestName+"  Number of errors: "+r.b.size());
        System.out.println(requestName+"  Errors: "+r.b);
        //r.a.showIndividuals();
        return new Pair<>(parser,tree);
    }

    public static void contextualAnalysisRequests() throws IOException {
        RepositoryHandler rh = new RepositoryHandler(path);
        for (File n:rh.get_files())
            contextualAnalisisRequest(n.getName());
    }
}
