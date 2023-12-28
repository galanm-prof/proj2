package test;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import java.io.IOException;
import java.util.Calendar;

public class TestCalculateRewritings {
    public static void main(String[] args) throws IOException, OWLOntologyCreationException, OWLOntologyStorageException {
        //"CITYCOUNTRY_DESTINATIONHOTEL_SERVICE.txt"
        //"USER_PRICE_SERVICE.txt"
        //"COUNTRYCAPITAL-CITY_HOTEL_SERVICE.txt"
        //"CITYCOUNTRY_ACCOMMODATION_SERVICE.txt"
        //"CITY_LOCATION_SERVICE.txt"
        //"CITY_STATE_LOCATION_SERVICE.txt"
        //"COUNTRYCITY_LUXURYHOTEL_SERVICE.txt"
        /*
        String name1 = "COUNTRYCITY_LUXURYHOTEL_SERVICE.txt";
        String name2 = "CITYCOUNTRY_DESTINATIONHOTEL_SERVICE.txt";

        CalculateSubstitutions.init(name1,name2);
        boolean inputParameters = true;
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
                CalculateSubstitutions.pairSpecificationSubstitutions(name1,name2,inputParameters,optimisation);
        for(Set<Substitution>substitution:substitutions) {
            System.out.println("Substitution "+"(inputs: "+inputParameters+", optimisation: "+optimisation+"):");
            for(Substitution s:substitution)
                System.out.println("   "+s);
        }
        */
        //String name1 = "USPOSTALCODE_DISTANCE_SERVICE.txt";
        //String name2 = "USZIPCODE_DISTANCE_SERVICE.txt";

        //String name1 = "CITYCOUNTRY_DESTINATIONHOTEL_SERVICE.txt";
        //String name2 = "CITYCOUNTRY_ACCOMMODATION_SERVICE.txt";
        //String name1="CALCULATE_SUNRISE_SERVICE.txt";
        //String name2="CALCULATE_SUNRISE_REQUEST.txt";

        Calendar begin = Calendar.getInstance();
        long time1 = begin.getTimeInMillis();
        //searching.CalculateRewritings.calculateRewriting(name1, name2);
        specifications.CalculateRewritings.calculateRewritings();
        search.CalculateRewritings.calculateRewritings();
        Calendar end = Calendar.getInstance();
        long time2 = end.getTimeInMillis();
        System.out.println("Amount of time (in seconds): " + (time2 - time1) / 1000.0);
    }
}
