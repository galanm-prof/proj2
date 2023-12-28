package test;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import java.io.IOException;
import java.util.Calendar;

public class TestStateSpaceImplication {
    public static void main(String[] args) throws IOException, OWLOntologyCreationException, OWLOntologyStorageException {
        /*
        String specification1 = "PERSONBOOKLIABILITYACCOUNT__SERVICE";
        String specification2 = "BOOKPERSON__SERVICE";
        //String specification1 = "LOCATIONLOCATION_ARROWFIGURE_SERVICE";
        //String specification2 = "LOCATIONLOCATION_ICON_SERVICE";
        Calendar begin = Calendar.getInstance();
        long time1 = begin.getTimeInMillis();
        boolean rP=StateSpaceImplication.preconditionsImplication(specification1,specification2);
        boolean rE=StateSpaceImplication.effectsImplication(specification1,specification2);
        Calendar end = Calendar.getInstance();
        long time2 = end.getTimeInMillis();
        System.out.println(specification1+" -->(pre) "+specification2+" Result: "+rP);
        System.out.println(specification1+" -->(eff) "+specification2+" Result: "+rE);
        System.out.println("Amount of time (in seconds): " + (time2 - time1) / 1000.0);
         */
        Calendar begin = Calendar.getInstance();
        long time1 = begin.getTimeInMillis();
        specifications.StateSpaceImplication.calculateImplicationsSets(); //implications between specifications
        //searching.StateSpaceImplication.calculateImplicationsSets(); //implications between specification and request
        /*
        String specification = "CITYCOUNTRY_ACCOMMODATION_SERVICE";
        //"COUNTRYCITY_LUXURYHOTEL_SERVICE";
        String request = "CITYCOUNTRY_ACCOMMODATION_REQUEST";
        boolean b1=searching.StateSpaceImplication.
                        preconditionsImplication(specification,request);
        boolean b2=searching.StateSpaceImplication.
                effectsImplication(specification,request);
        System.out.println(b1+"  "+b2);
        */
        Calendar end = Calendar.getInstance();
        long time2 = end.getTimeInMillis();
        System.out.println("Amount of time (in seconds): " + (time2 - time1) / 1000.0);
    }
}
