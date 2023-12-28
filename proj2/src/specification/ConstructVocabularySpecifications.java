package specification;

import file.RepositoryHandler;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import java.io.File;
import java.io.IOException;

public class ConstructVocabularySpecifications {
    private static String path="C://xampp//htdocs//specifications//";
    public static void constructVocabularies() throws IOException, OWLOntologyCreationException, OWLOntologyStorageException {
        RepositoryHandler rh = new RepositoryHandler(path);
        for (File n:rh.get_files()) {
            ConstructVocabularySpecification cv =
                    new ConstructVocabularySpecification();
            cv.merge(n.getName());
        }
    }
}
