package search;

import common.OntologyHandler;
import file.RepositoryHandler;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLXMLOntologyFormat;
import org.semanticweb.owlapi.model.*;

import request.RequestLexer;
import request.RequestParser;
import specification.SpecificationLexer;
import specification.SpecificationParser;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CalculateCommonVocabularies {

    private static final String requestRepository = "C://xampp//htdocs//requests//";
    private static final String specificationRepository = "C://xampp//htdocs//specifications//";
    //Pre: descriptionName is the name of a description (request or specification with an extension .txt)
    //Post: It calculates the set of ontology names imported in the description.
    private static Set<String> extractOntologies(String descriptionName, boolean request) throws IOException {
        if (request){
            CharStream f = CharStreams.fromFileName(requestRepository+descriptionName);
            RequestLexer analex = new RequestLexer(f);
            CommonTokenStream ts = new CommonTokenStream(analex);
            RequestParser anasint = new RequestParser(ts);
            ParseTree tree = anasint.req();
            request.ImpotedOntologiesExtractor extractor = new request.ImpotedOntologiesExtractor();
            Set<String> ontologies = ((Set<String>) extractor.visit(tree));
            return ontologies;
        }
        else{
            CharStream f = CharStreams.fromFileName(specificationRepository+descriptionName);
            SpecificationLexer analex = new SpecificationLexer(f);
            CommonTokenStream ts = new CommonTokenStream(analex);
            SpecificationParser anasint = new SpecificationParser(ts);
            ParseTree tree = anasint.spec();
            specification.ImpotedOntologiesExtractor extractor = new specification.ImpotedOntologiesExtractor();
            Set<String> ontologies = ((Set<String>) extractor.visit(tree));
            return ontologies;
        }
    }
    public static void merge(String specificationName,String requestName) throws IOException, OWLOntologyCreationException, OWLOntologyStorageException, OWLOntologyCreationException, OWLOntologyStorageException {
        Set<String> ontologies1=extractOntologies(specificationName,false);
        Set<String> ontologies2=extractOntologies(requestName,true);
        Set<String> ontologies=new HashSet<>();
        ontologies.addAll(ontologies1);
        ontologies.addAll(ontologies2);
        OntologyHandler handler = new OntologyHandler();
        handler.loadOntologies(ontologies);
        OWLOntology vocabulary=
                handler.constructVocabularyFromImportedOntologiesInRequestSpecification(
                        specificationName.replace(".txt",""),
                        requestName.replace(".txt",""));
        OWLOntologyManager manager2 = OWLManager.createOWLOntologyManager();
        IRI vocabularyIRI = IRI.create("file:///C://xampp//htdocs//ontologies2//"+
                specificationName.replace(".txt","")+"//"+
                requestName.replace(".txt","")+"//vocabulary.owl");
        OWLOntologyFormat oformat = new OWLXMLOntologyFormat();
        manager2.saveOntology(vocabulary,oformat,vocabularyIRI);
    }

    public static void commonVocabularies() throws OWLOntologyCreationException, OWLOntologyStorageException, IOException {
        RepositoryHandler rh1 = new RepositoryHandler(specificationRepository);
        int n = rh1.get_files().size();
        for (File n1:rh1.get_files()) {
            RepositoryHandler rh2 = new RepositoryHandler(requestRepository);
            for (File n2:rh2.get_files()){
                System.out.println("Calculating common vocabulary for " +
                        n1.getName().replace(".txt","") +
                        " (leave " +n +" specs), "+
                        n2.getName().replace(".txt",""));
                CalculateCommonVocabularies.merge(n1.getName(),n2.getName());
            }
            n--;
        }
    }
}
