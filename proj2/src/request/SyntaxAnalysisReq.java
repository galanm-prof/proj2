package request;

import file.RepositoryHandler;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.IOException;

public class SyntaxAnalysisReq {
    private static String path="reqs";
    public static ParseTree syntaxAnalysisReq(String file) throws IOException {
        CharStream f = CharStreams.fromFileName(path+"\\"+file);
        RequestLexer analex = new RequestLexer(f);
        CommonTokenStream ts = new CommonTokenStream(analex);
        RequestParser anasint = new RequestParser(ts);
        ParseTree tree = anasint.req();
        return tree;
    }

    public static void syntaxAnalysisReqs() throws IOException {
        RepositoryHandler rh = new RepositoryHandler(path);
        for (File n:rh.get_files()) {
            System.out.println(n.getName());
            syntaxAnalysisReq(n.getName());
        }
        System.out.println(rh.get_files().size()+" files have been syntactically analised");
    }
}
