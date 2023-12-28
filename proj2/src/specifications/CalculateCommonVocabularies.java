package specifications;

import common.OntologyHandler;
import file.RepositoryHandler;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLXMLOntologyFormat;
import org.semanticweb.owlapi.model.*;
import specification.ImpotedOntologiesExtractor;
import specification.SpecificationLexer;
import specification.SpecificationParser;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CalculateCommonVocabularies {

    private static final String specificationRepository = "C://xampp//htdocs//specifications//";
    //Pre: specificationName is the name of a specification (with an extension .txt)
    //Post: It calculates the set of ontology names imported in the specification.
    private static Set<String> extractOntologies(String specificationName) throws IOException {
        CharStream f = CharStreams.fromFileName(specificationRepository+specificationName);
        SpecificationLexer analex = new SpecificationLexer(f);
        CommonTokenStream ts = new CommonTokenStream(analex);
        SpecificationParser anasint = new SpecificationParser(ts);
        ParseTree tree = anasint.spec();
        ImpotedOntologiesExtractor extractor = new ImpotedOntologiesExtractor();
        Set<String> ontologies = ((Set<String>) extractor.visit(tree));
        return ontologies;
    }
    public static void merge(String specificationName1,String specificationName2) throws IOException, OWLOntologyCreationException, OWLOntologyStorageException, OWLOntologyCreationException, OWLOntologyStorageException {
        Set<String> ontologies1=extractOntologies(specificationName1);
        Set<String> ontologies2=extractOntologies(specificationName2);
        Set<String> ontologies=new HashSet<>();
        ontologies.addAll(ontologies1);
        ontologies.addAll(ontologies2);
        OntologyHandler handler = new OntologyHandler();
        handler.loadOntologies(ontologies);
        OWLOntology vocabulary=
                handler.constructVocabularyFromImportedOntologiesInTwoSpecifications(
                        specificationName1.replace(".txt",""),
                        specificationName2.replace(".txt",""));
        OWLOntologyManager manager2 = OWLManager.createOWLOntologyManager();
        IRI vocabularyIRI = IRI.create("file:///C://xampp//htdocs//ontologies//"+
                specificationName1.replace(".txt","")+"//"+
                specificationName2.replace(".txt","")+"//vocabulary.owl");
        OWLOntologyFormat oformat = new OWLXMLOntologyFormat();
        manager2.saveOntology(vocabulary,oformat,vocabularyIRI);
    }

    public static void commonVocabularies() throws OWLOntologyCreationException, OWLOntologyStorageException, IOException {
        String path="C://xampp//htdocs//specifications//";
        RepositoryHandler rh = new RepositoryHandler(path);
        int n = rh.get_files().size();
        for (File n1:rh.get_files()) {
            for (File n2:rh.get_files()){
                if (!n1.getName().equals(n2.getName())) {
                    System.out.println("Calculating common vocabulary for " +
                            n1.getName().replace(".txt","") +
                            " (leave" +n +"specs), "+
                            n2.getName().replace(".txt",""));
                    CalculateCommonVocabularies.merge(n1.getName(),n2.getName());
                }
            }
            n--;
        }
    }
}
