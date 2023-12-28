package request;

import file.RepositoryHandler;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import specification.ConstructVocabularySpecification;

import java.io.File;
import java.io.IOException;

public class ConstructVocabularyRequests {
    private static String path="C://xampp//htdocs//requests//";
    public static void constructVocabularies() throws IOException, OWLOntologyCreationException, OWLOntologyStorageException {
        RepositoryHandler rh = new RepositoryHandler(path);
        for (File n:rh.get_files()) {
            ConstructVocabularyRequest cv =
                    new ConstructVocabularyRequest();
            System.out.println("Request: "+n.getName());
            cv.merge(n.getName());
        }
    }
}
