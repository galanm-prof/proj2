package specification;

import file.RepositoryHandler;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.IOException;

public class SyntaxAnalysis {
    private static String path="specs";
    public static ParseTree syntaxAnalysisSpec(String file) throws IOException {
        CharStream f = CharStreams.fromFileName(path+"\\"+file);
        SpecificationLexer analex = new SpecificationLexer(f);
        CommonTokenStream ts = new CommonTokenStream(analex);
        SpecificationParser anasint = new SpecificationParser(ts);
        ParseTree tree = anasint.spec();
        return tree;
    }

    public static void syntaxAnalysisSpecs() throws IOException {
        RepositoryHandler rh = new RepositoryHandler(path);
        for (File n:rh.get_files()) {
            System.out.println(n.getName());
            syntaxAnalysisSpec(n.getName());
        }
        System.out.println(rh.get_files().size()+" files have been syntactically analised");
    }
}
