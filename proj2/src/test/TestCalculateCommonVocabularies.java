package test;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import specifications.CalculateCommonVocabularies;

import java.io.IOException;
import java.util.Calendar;

public class TestCalculateCommonVocabularies {

    public static void main(String[] args) throws IOException, OWLOntologyCreationException, OWLOntologyStorageException {
        /*
        String specification1 = "PERSONBOOKLIABILITYACCOUNT__SERVICE.txt";
        String specification2 = "BOOKPERSON__SERVICE.txt";
        //String specification1 = "LOCATIONLOCATION_ARROWFIGURE_SERVICE";
        //String specification2 = "LOCATIONLOCATION_ICON_SERVICE";
        Calendar begin = Calendar.getInstance();
        long time1 = begin.getTimeInMillis();
        CalculateCommonVocabularies.merge(specification1,specification2);
        Calendar end = Calendar.getInstance();
        long time2 = end.getTimeInMillis();
        System.out.println("Amount of time (in seconds): " + (time2 - time1) / 1000.0);
         */
        Calendar begin = Calendar.getInstance();
        long time1 = begin.getTimeInMillis();
        CalculateCommonVocabularies.commonVocabularies();
        Calendar end = Calendar.getInstance();
        long time2 = end.getTimeInMillis();
        System.out.println("Amount of time (in seconds): " + (time2 - time1) / 1000.0);
    }
}
