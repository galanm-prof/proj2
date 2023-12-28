package specification;

import common.OntologyHandler;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLXMLOntologyFormat;
import org.semanticweb.owlapi.model.*;

import java.io.IOException;
import java.util.Set;

public class ConstructVocabularySpecification {
    private OntologyHandler manager;

    public ConstructVocabularySpecification(){
        manager=new OntologyHandler();
    }

    //Pre: specificationName is the name of the specification (with an extension .txt)
    public void merge(String specificationName) throws IOException, OWLOntologyCreationException, OWLOntologyStorageException, OWLOntologyCreationException, OWLOntologyStorageException {
        CharStream f = CharStreams.fromFileName("C://xampp//htdocs//specifications//"+
                specificationName);
        SpecificationLexer analex = new SpecificationLexer(f);
        CommonTokenStream ts = new CommonTokenStream(analex);
        SpecificationParser anasint = new SpecificationParser(ts);
        ParseTree tree = anasint.spec();
        ImpotedOntologiesExtractor extractor = new ImpotedOntologiesExtractor();
        Set<String> ontologies=((Set<String>)extractor.visit(tree));
        manager.loadOntologies(ontologies);
        
        OWLOntology vocabulary=
                manager.constructVocabularyFromImportedOntologiesInADescription(
                        specificationName.replace(".txt",""),
                        true);

        OWLOntologyManager manager2 = OWLManager.createOWLOntologyManager();
        IRI vocabularyIRI = IRI.create("file:///C://xampp//htdocs//specifications//"+
                specificationName.replace(".txt","")+"//vocabulary.owl");
        OWLOntologyFormat oformat = new OWLXMLOntologyFormat();
        manager2.saveOntology(vocabulary,oformat,vocabularyIRI);
    }
}
