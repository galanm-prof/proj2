package test;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestInformationSpaceImplication {
    public static void main(String[] args) throws IOException, OWLOntologyCreationException, OWLOntologyStorageException {

        Calendar begin = Calendar.getInstance();
        long time1 = begin.getTimeInMillis();
        specifications.InformationSpaceImplication.calculateImplicationsSets(); //implications between specifications
        //searching.InformationSpaceImplication.calculateImplicationsSets(); //implications between specification and request
        Calendar end = Calendar.getInstance();
        long time2 = end.getTimeInMillis();
        System.out.println("Amount of time (in seconds): " + (time2 - time1) / 1000.0);
    }
}
