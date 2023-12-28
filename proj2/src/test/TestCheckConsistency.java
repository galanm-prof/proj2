package test;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import request.CheckRequestsConsistency;
import specification.CheckSpecificationsConsistency;

import java.io.IOException;
import java.util.Calendar;

public class TestCheckConsistency {

    public static void main(String[] args) throws IOException, OWLOntologyCreationException, OWLOntologyStorageException {
        long time1=Calendar.getInstance().getTimeInMillis();
        //Consistency of a specification
        //List<Boolean> consistency=
          //      CheckSpecificationConsistency.checkModuleConsistency("CITYCOUNTRY_DESTINATIONHOTEL_SERVICE.txt");

        //List<Boolean> consistency=
          //   CheckSpecificationConsistency.checkConsistency("USER_PRICE_SERVICE");
        //CheckSpecificationsConsistency.checkConsistency();

        //Consistency of all requests
        CheckRequestsConsistency.checkConsistency();
        //Consistency of all specifications
        //CheckSpecificationsConsistency.checkConsistency();
        long time2=Calendar.getInstance().getTimeInMillis();
        double time=((time2-time1)/1000.0);
        System.out.println("Amount of time in seconds = "+time);
    }
}
