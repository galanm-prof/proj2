package specification;

import file.RepositoryHandler;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import java.io.File;
import java.io.IOException;

public class CheckSpecificationsConsistency {
    private static String path="C://xampp//htdocs//specifications//";
    public static void checkConsistency() throws IOException, OWLOntologyCreationException, OWLOntologyStorageException {
        RepositoryHandler rh = new RepositoryHandler(path);
        for (File n:rh.get_files()) {
            CheckSpecificationConsistency.checkConsistency(n.getName());
        }
    }
    public static void checkModuleConsistency() throws IOException, OWLOntologyCreationException, OWLOntologyStorageException {
        RepositoryHandler rh = new RepositoryHandler(path);
        for (File n:rh.get_files()) {
            CheckSpecificationConsistency.checkModuleConsistency(n.getName());
        }
    }
}
