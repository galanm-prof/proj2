package test;



import modularity.ModuleExtractor;
import modularity.OntologyModuleExtractor;
import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.owlapi.apibinding.OWLManager;

import org.semanticweb.owlapi.model.*;


import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import specification.ModuleExtractionSpecification;
import specification.ModuleExtractionSpecifications;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class TestModuleExtraction {

    public static void main(String[] args) throws Exception {
        //"CITYCOUNTRY_DESTINATIONHOTEL_SERVICE.txt"
        //"USER_PRICE_SERVICE.txt"
        //"CITYCOUNTRY_HOTEL_SERVICE.txt"
        //String name = "CITYCOUNTRY_DESTINATIONHOTEL_SERVICE.txt";
        /*
        String specificationName = "CITYCOUNTRY_HOTEL_SERVICE.txt";
        ModuleExtractionSpecification.extractModule(specificationName,false);
        ModuleExtractionSpecification.extractModule(specificationName,true);
         */
        ModuleExtractionSpecifications.extractModules();
    }
}
