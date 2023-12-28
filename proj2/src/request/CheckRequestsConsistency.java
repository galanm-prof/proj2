package request;

import file.RepositoryHandler;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import java.io.File;
import java.io.IOException;

public class CheckRequestsConsistency {
    private static String path="C://xampp//htdocs//requests//";
    public static void checkConsistency() throws IOException, OWLOntologyCreationException, OWLOntologyStorageException {
        RepositoryHandler rh = new RepositoryHandler(path);
        for (File n:rh.get_files()) {
            CheckRequestConsistency.checkConsistency(n.getName());
        }
    }

    //Deprecated (useless)
    public static void checkModuleConsistency() throws IOException, OWLOntologyCreationException, OWLOntologyStorageException {
        RepositoryHandler rh = new RepositoryHandler(path);
        for (File n:rh.get_files()) {
            CheckRequestConsistency.checkModuleConsistency(n.getName());
        }
    }
}
