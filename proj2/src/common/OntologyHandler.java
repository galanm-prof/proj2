package common;


import org.semanticweb.owlapi.apibinding.OWLManager;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.OWLEntityCollector;

import java.util.HashSet;
import java.util.Set;

public class OntologyHandler {
    private OWLOntologyManager manager;

    //Constructor
    public OntologyHandler(){

        manager = OWLManager.createOWLOntologyManager();
    }

    //Load an ontology from irs IRI
    public void loadOntology(IRI iriOntology){
        try {
            //System.out.println("Ontology to be loaded: "+iriOntology);
            //System.out.println("Ontologies loaded: "+manager.getOntologies().stream().
                    //map(o->o.getOntologyID().getOntologyIRI().toString()).toList());
            if (!manager.contains(iriOntology)) {
                manager.loadOntology(iriOntology);
                System.out.println("Loaded ontology: "+iriOntology);
            }
        }catch(OWLOntologyCreationException e){ e.printStackTrace(); }
    }

    //Load a set of ontologies deployed in an apache server
    // from a set short ontology names
    //The prefix "http://127.0.0.1/ontology/" is used to complete the
    //IRIs (local server).
    public void loadOntologies(Set<String> ontologies){
        System.out.println("Ontologies to be loaded: "+ontologies);
        String ontologyPath="http://127.0.0.1/ontology/";
        for(String o:ontologies) {
            IRI iriOntology = IRI.create(ontologyPath + o + ".owl");
            this.loadOntology(iriOntology);
        }
    }

    // Get ontologies deployed in the ontology manager
    public Set<OWLOntology>getLoadedOntologies(){
        return manager.getOntologies();
    }

    //Materialise the vocabulary of a description (service or request)
    // by putting together all the previously loaded ontologies.
    //(To be used when creating the infrastructure not for production.)
    public OWLOntology constructVocabularyFromImportedOntologiesInADescription(String descriptionName, boolean specification) throws OWLOntologyCreationException {
        OWLOntologyManager auxManager = OWLManager.createOWLOntologyManager();
        IRI newOntologyIRI;
        if (specification)
           newOntologyIRI = IRI.create("http://127.0.0.1/specifications/"+
                   descriptionName+"/vocabulary.owl");
        else
            newOntologyIRI = IRI.create("http://127.0.0.1/requests/"+
                    descriptionName+"/vocabulary.owl");
        return auxManager.createOntology(newOntologyIRI,manager.getOntologies());
    }

    public OWLOntology constructVocabularyFromImportedOntologiesInTwoSpecifications(String specificationName1,
                                                                                    String specificationName2) throws OWLOntologyCreationException {
        OWLOntologyManager auxManager = OWLManager.createOWLOntologyManager();
        IRI newOntologyIRI = IRI.create("http://127.0.0.1/ontologies/"+
                specificationName1+"/"+specificationName2+"/vocabulary.owl");
        return auxManager.createOntology(newOntologyIRI,manager.getOntologies());
    }

    public OWLOntology constructVocabularyFromImportedOntologiesInRequestSpecification(String requestName,
                                                                                    String specificationName) throws OWLOntologyCreationException {
        OWLOntologyManager auxManager = OWLManager.createOWLOntologyManager();
        IRI newOntologyIRI = IRI.create("http://127.0.0.1/ontologies2/"+
                requestName+"/"+specificationName+"/vocabulary.owl");
        return auxManager.createOntology(newOntologyIRI,manager.getOntologies());
    }

    private Set<OWLEntity> getAxiomSignature(OWLAxiom ax) {
        Set<OWLEntity>collectedEntities=new HashSet<>();
        OWLEntityCollector axiomSignatureCollector
                = new OWLEntityCollector(collectedEntities);
        ax.accept(axiomSignatureCollector);

        //System.out.println("Ax: " + ax);
        //System.out.println("\tEntities: " + collectedEntities);

        //return axiomSignatureCollector.getObjects();
        return collectedEntities;
    }
}
