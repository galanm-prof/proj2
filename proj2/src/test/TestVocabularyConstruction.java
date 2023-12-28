package test;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import request.ConstructVocabularyRequest;
import request.ConstructVocabularyRequests;
import specification.ConstructVocabularySpecification;
import specification.ConstructVocabularySpecifications;

import java.io.IOException;
import java.util.Calendar;


public class TestVocabularyConstruction {
    private static void constructVocabularySpecification(String specification) throws OWLOntologyCreationException, IOException, OWLOntologyStorageException {
        ConstructVocabularySpecification constructor = new
                ConstructVocabularySpecification();
        constructor.merge(specification);
    }

    private static void constructVocabulariesSpecifications() throws OWLOntologyCreationException, IOException, OWLOntologyStorageException {
        ConstructVocabularySpecifications.constructVocabularies();
    }

    private static void constructVocabularyRequest(String request) throws OWLOntologyCreationException, IOException, OWLOntologyStorageException {
        ConstructVocabularyRequest constructor = new
                ConstructVocabularyRequest();
        constructor.merge(request);
    }

    private static void constructVocabulariesRequests() throws OWLOntologyCreationException, IOException, OWLOntologyStorageException {
        ConstructVocabularyRequests.constructVocabularies();
    }

    public static void main(String[] args) throws IOException, OWLOntologyCreationException, OWLOntologyStorageException {
        //TestVocabularyConstruction.constructVocabulary(args[0]);
        Calendar begin=Calendar.getInstance();
        long time1 = begin.getTimeInMillis();
        TestVocabularyConstruction.constructVocabulariesRequests();
        //TestVocabularyConstruction.constructVocabulariesSpecifications();
        Calendar end=Calendar.getInstance();
        long time2 = end.getTimeInMillis();
        System.out.println("Amount of time (in seconds): "+(time2-time1)/1000.0);
    }
}
