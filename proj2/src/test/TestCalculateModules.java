package test;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import specifications.CalculateModules;

import java.io.IOException;
import java.util.Calendar;

public class TestCalculateModules {
    public static void main(String[] args) throws IOException, OWLOntologyCreationException, OWLOntologyStorageException {
        //"CITYCOUNTRY_DESTINATIONHOTEL_SERVICE.txt"
        //"USER_PRICE_SERVICE.txt"
        //"COUNTRYCAPITAL-CITY_HOTEL_SERVICE.txt"
        //"CITYCOUNTRY_ACCOMMODATION_SERVICE.txt"
        //String name1 = "CITYCOUNTRY_ACCOMMODATION_SERVICE.txt";
        //String name2 = "COUNTRYCAPITAL-CITY_HOTEL_SERVICE.txt";
        //String name2 = "CITYCOUNTRY_DESTINATIONHOTEL_SERVICE.txt";

        //CalculateModules.calculateModulesO(name1,name2);
        Calendar begin=Calendar.getInstance();
        long time1 = begin.getTimeInMillis();
        CalculateModules.calculateModules();
        Calendar end=Calendar.getInstance();
        long time2 = end.getTimeInMillis();
        System.out.println("Amount of time (in seconds): "+(time2-time1)/1000.0);
        //CalculateModules.calculateModules("CITYCOUNTRY_ACCOMMODATION_SERVICE.txt");
    }
}
