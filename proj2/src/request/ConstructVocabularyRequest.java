package request;

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

public class ConstructVocabularyRequest {
    private OntologyHandler manager;

    public ConstructVocabularyRequest(){
        manager=new OntologyHandler();
    }

    //Pre: requestName is the name of the request (with an extension .txt)
    public void merge(String requestName) throws IOException, OWLOntologyCreationException, OWLOntologyStorageException, OWLOntologyCreationException, OWLOntologyStorageException {
        CharStream f = CharStreams.fromFileName("C://xampp//htdocs//requests//"+
                requestName);
        RequestLexer analex = new RequestLexer(f);
        CommonTokenStream ts = new CommonTokenStream(analex);
        RequestParser anasint = new RequestParser(ts);
        ParseTree tree = anasint.req();
        ImpotedOntologiesExtractor extractor = new ImpotedOntologiesExtractor();
        Set<String> ontologies=((Set<String>)extractor.visit(tree));
        manager.loadOntologies(ontologies);
        
        OWLOntology vocabulary=
                manager.constructVocabularyFromImportedOntologiesInADescription(
                        requestName.replace(".txt",""),
                        false);

        OWLOntologyManager manager2 = OWLManager.createOWLOntologyManager();
        IRI vocabularyIRI = IRI.create("file:///C://xampp//htdocs//requests//"+
                requestName.replace(".txt","")+"//vocabulary.owl");
        OWLOntologyFormat oformat = new OWLXMLOntologyFormat();
        manager2.saveOntology(vocabulary,oformat,vocabularyIRI);
    }
}
