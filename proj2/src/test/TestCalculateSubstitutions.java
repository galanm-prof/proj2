package test;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import java.io.IOException;
import java.util.Calendar;

public class TestCalculateSubstitutions {
    public static void main(String[] args) throws IOException, OWLOntologyCreationException {
        //"CITYCOUNTRY_DESTINATIONHOTEL_SERVICE.txt"
        //"USER_PRICE_SERVICE.txt"
        //"COUNTRYCAPITAL-CITY_HOTEL_SERVICE.txt"
        //"CITYCOUNTRY_ACCOMMODATION_SERVICE.txt"
        //"CITY_LOCATION_SERVICE.txt"
        //"CITY_STATE_LOCATION_SERVICE.txt"
        //"COUNTRYCITY_LUXURYHOTEL_SERVICE.txt"
        //"USPOSTALCODE_DISTANCE_SERVICE.txt"
        //"USZIPCODE_DISTANCE_SERVICE.txt"
        //"PERSONBOOKLIABILITYACCOUNT__SERVICE.txt"
        //"BOOKPERSON__SERVICE.txt"
/*
        String name1 = "PERSONBOOKLIABILITYACCOUNT__SERVICE.txt";
        String name2 = "BOOKPERSON__SERVICE.txt";

        CalculateSubstitutions.init(name1,name2);
        boolean inputParameters = false;
        boolean optimisation = false;
        if (inputParameters){
            System.out.println(name1+"'s inputs: "+ CalculateSubstitutions.getI1());
            System.out.println(name2+"'s inputs: "+ CalculateSubstitutions.getI2());
        }
        else{
            System.out.println(name1+"'s outputs: "+ CalculateSubstitutions.getO1());
            System.out.println(name2+"'s outputs: "+ CalculateSubstitutions.getO2());
        }

        Set<Set<Substitution>> substitutions =
                CalculateSubstitutions.pairSpecificationSubstitutions(inputParameters,optimisation);
        for(Set<Substitution>substitution:substitutions) {
            System.out.println("Substitution "+"(inputs: "+inputParameters+", optimisation: "+optimisation+"):");
            for(Substitution s:substitution)
                System.out.println("   "+s);
        }

*/

        Calendar begin=Calendar.getInstance();
        long time1 = begin.getTimeInMillis();
        specifications.CalculateSubstitutions.calculatePersistentSubstitutions();
        search.CalculateSubstitutions.calculatePersistentSubstitutions();
        Calendar end=Calendar.getInstance();
        long time2 = end.getTimeInMillis();
        System.out.println("Amount of time (in seconds): "+(time2-time1)/1000.0);
    }
}
