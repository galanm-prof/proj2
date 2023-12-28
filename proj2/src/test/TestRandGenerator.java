package test;

import common.RandGenerator;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import java.io.IOException;
import java.util.Set;

public class TestRandGenerator {
    public static void main(String[]args) throws OWLOntologyCreationException, IOException, OWLOntologyStorageException {
        //Set<String> specs=RandGenerator.generateSpecificationSubset(30);
        //specs.forEach(s->System.out.println(s));
        RandGenerator.calculateImplicationsSets(30);
    }
}
