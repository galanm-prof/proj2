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

public class ModuleExtractionSpecifications {
    private static String path="C://xampp//htdocs//specifications//";

    public static void extractModules() throws Exception {
        RepositoryHandler rh = new RepositoryHandler(path);
        for (File n:rh.get_files()) {
            System.out.println("SPECIFICATION: "+n.getName());
            System.out.println("   Extracting module for the precondition.");
            ModuleExtractionSpecification.extractModule(n.getName(), false);
            System.out.println("   Extracting module for the effect.");
            ModuleExtractionSpecification.extractModule(n.getName(), true);
        }
    }
}
