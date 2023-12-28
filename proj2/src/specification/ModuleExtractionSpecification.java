package specification;

import file.RepositoryHandler;
import modularity.OntologyModuleExtractor;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ModuleExtractionSpecification {
    public static void extractModule(String specificationName,boolean effect) throws Exception {

        IRI vocabularyModuleIRI = null;
        IRI moduleIRI = null;

        String repository = "file:///C://xampp//htdocs//specifications//";
        String path = "http://127.0.0.1/specifications/";

        String repository2 = "c://xampp//htdocs//specifications//"+
                specificationName.replace(".txt","/");

        IRI vocabularyIRI = IRI.create(path+
                specificationName.replace(".txt","")+"/vocabulary.owl");
        IRI IIRI = IRI.create(path+
                specificationName.replace(".txt","")+"/I.owl");
        IRI OIRI = IRI.create(path+
                specificationName.replace(".txt","")+"/O.owl");

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology vocabulary = manager.loadOntology(vocabularyIRI);
        Set<OWLAxiom> auxAxiomSet=new HashSet<>();
        auxAxiomSet.addAll(vocabulary.getAxioms());
        IRI VIRI = IRI.create(path+
                specificationName.replace(".txt","")+"/V.owl");
        OWLOntology v = manager.createOntology(auxAxiomSet,VIRI);

        OntologyModuleExtractor extractor =
                new OntologyModuleExtractor(manager, v,
                        OntologyModuleExtractor.TYPEMODULE.STAR);
        OWLOntology I = manager.loadOntology(IIRI);
        OWLOntology O = manager.loadOntology(OIRI);

        RepositoryHandler rh = new RepositoryHandler(repository2);
        Set<File>files=rh.get_files();
        long pairOfStatesCounter =
                files.stream().filter(f->f.getName().startsWith("E")).count();
        if (pairOfStatesCounter>1){
           for(int i=0;i<pairOfStatesCounter;i++){
               IRI PIRI = IRI.create(path+
                       specificationName.replace(".txt","")+"/P"+i+".owl");
               IRI EIRI = IRI.create(path+
                       specificationName.replace(".txt","")+"/E"+i+".owl");
               OWLOntology P = manager.loadOntology(PIRI);
               OWLOntology E = manager.loadOntology(EIRI);
               Set<OWLEntity> entities=new HashSet<>();
               entities.addAll(I.getSignature());
               if (effect) {
                   entities.addAll(O.getSignature());
                   entities.addAll(E.getSignature());
                   vocabularyModuleIRI = IRI.create(path+
                           specificationName.replace(".txt","")+"/vocabularyIOEModule"+i+".owl");
               }
               else {
                   entities.addAll(P.getSignature());
                   vocabularyModuleIRI = IRI.create(path+
                           specificationName.replace(".txt","")+"/vocabularyIPModule"+i+".owl");
               }
               OWLOntology module =
                       extractor.extractAsOntology(entities,vocabularyModuleIRI);

               if (effect)
                   moduleIRI = IRI.create(repository+
                           specificationName.replace(".txt","")+"/vocabularyIOEModule"+i+".owl");
               else
                   moduleIRI = IRI.create(repository+
                           specificationName.replace(".txt","")+"/vocabularyIPModule"+i+".owl");
               manager.saveOntology(module,moduleIRI);
           }
        }
        else{
            IRI PIRI = IRI.create(path+
                    specificationName.replace(".txt","")+"/P.owl");
            IRI EIRI = IRI.create(path+
                    specificationName.replace(".txt","")+"/E.owl");
            OWLOntology P = manager.loadOntology(PIRI);
            OWLOntology E = manager.loadOntology(EIRI);
            Set<OWLEntity> entities=new HashSet<>();
            entities.addAll(I.getSignature());
            if (effect) {
                entities.addAll(O.getSignature());
                entities.addAll(E.getSignature());
                vocabularyModuleIRI = IRI.create(path+
                        specificationName.replace(".txt","")+"/vocabularyIOEModule.owl");
            }
            else {
                entities.addAll(P.getSignature());
                vocabularyModuleIRI = IRI.create(path+
                        specificationName.replace(".txt","")+"/vocabularyIPModule.owl");
            }
            OWLOntology module =
                    extractor.extractAsOntology(entities,vocabularyModuleIRI);

            if (effect)
                moduleIRI = IRI.create(repository+
                        specificationName.replace(".txt","")+"/vocabularyIOEModule.owl");
            else
                moduleIRI = IRI.create(repository+
                        specificationName.replace(".txt","")+"/vocabularyIPModule.owl");
            manager.saveOntology(module,moduleIRI);
        }
    }
}
