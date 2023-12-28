package specifications;

import file.RepositoryHandler;
import modularity.OntologyModuleExtractor;
import org.antlr.v4.runtime.misc.Pair;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class CalculateModules {
    private static final String specificationsPath = "http://127.0.0.1/specifications/";
    private static final String specificationsRepository = "C://xampp//htdocs//specifications//";
    private static final String ontologiesPath = "http://127.0.0.1/ontologies/";
    private static Pair<OWLOntology,OWLOntologyManager> loadCommonVocabulary(String specificationName1,
                                                                             String specificationName2) throws OWLOntologyCreationException {
        IRI vocabularyIRI = IRI.create(ontologiesPath+
                specificationName1.replace(".txt","")+"/"+
                specificationName2.replace(".txt","")+"/"+
                "vocabulary.owl");
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology vocabulary = manager.loadOntology(vocabularyIRI);
        return new Pair<>(vocabulary,manager);
    }

    //Calculation of all entities in the IO parameters section of a given specification
    private static Set<OWLEntity> entitiesIO(String specificationName,
                                             OWLOntologyManager manager) throws OWLOntologyCreationException {
        Set<OWLEntity> entities=new HashSet<>();

        IRI IIRI = IRI.create(specificationsPath+
                specificationName.replace(".txt","")+"/I.owl");
        IRI OIRI = IRI.create(specificationsPath+
                specificationName.replace(".txt","")+"/O.owl");

        OWLOntology I = manager.loadOntology(IIRI);
        OWLOntology O = manager.loadOntology(OIRI);

        entities.addAll(I.getSignature());
        entities.addAll(O.getSignature());

        return entities;
    }

    //Calculation of all entities in the precondition section of a given specification
    private static Set<OWLEntity> entitiesP(String specificationName,
                                            OWLOntologyManager manager) throws OWLOntologyCreationException {
        Set<OWLEntity> entities=new HashSet<>();

        String specificationRepository = specificationsRepository+
                specificationName.replace(".txt","");
        RepositoryHandler rh = new RepositoryHandler(specificationRepository);
        Set<File>files=rh.get_files();
        long pairOfStatesCounter =
                files.stream().filter(f->f.getName().startsWith("E")).count();
        if (pairOfStatesCounter>1) {
            for (int i = 0; i < pairOfStatesCounter; i++) {
                IRI PIRI = IRI.create(specificationsPath +
                        specificationName.replace(".txt", "") + "/P" + i + ".owl");
                OWLOntology P = manager.loadOntology(PIRI);
                entities.addAll(P.getSignature());
            }
        }
        else{
            IRI PIRI = IRI.create(specificationsPath +
                    specificationName.replace(".txt", "") + "/P.owl");
            OWLOntology P = manager.loadOntology(PIRI);
            entities.addAll(P.getSignature());
        }

        return entities;
    }



    //Calculation of all entities in the effect section of a given specification
    private static Set<OWLEntity> entitiesE(String specificationName,
                                            OWLOntologyManager manager) throws OWLOntologyCreationException {
        Set<OWLEntity> entities=new HashSet<>();

        String specificationRepository = specificationsRepository+
                specificationName.replace(".txt","");
        RepositoryHandler rh = new RepositoryHandler(specificationRepository);
        Set<File>files=rh.get_files();
        long pairOfStatesCounter =
                files.stream().filter(f->f.getName().startsWith("E")).count();
        if (pairOfStatesCounter>1) {
            for (int i = 0; i < pairOfStatesCounter; i++) {
                IRI EIRI = IRI.create(specificationsPath +
                        specificationName.replace(".txt", "") + "/E" + i + ".owl");
                OWLOntology E = manager.loadOntology(EIRI);
                entities.addAll(E.getSignature());
            }
        }
        else{
            IRI EIRI = IRI.create(specificationsPath +
                    specificationName.replace(".txt", "") + "/E.owl");
            OWLOntology E = manager.loadOntology(EIRI);
            entities.addAll(E.getSignature());
        }

        return entities;
    }

    //Module calculation from the common vocabulary of the pair of given specifications
    public static void calculateModule(String specificationName1,
                                       String specificationName2) throws OWLOntologyCreationException, OWLOntologyStorageException {

        String modulesRepository = "file:///C://xampp//htdocs//modules//";
        String modulesPath = "http://127.0.0.1/modules/";

        //Load the common vocabulary of the involved specifications
        Pair<OWLOntology,OWLOntologyManager> tuple = loadCommonVocabulary(specificationName1, specificationName2);
        OWLOntology vocabulary = tuple.a;
        OWLOntologyManager manager = tuple.b;

        //Creation of module extractor
        OntologyModuleExtractor extractor =
                new OntologyModuleExtractor(manager, vocabulary,
                        OntologyModuleExtractor.TYPEMODULE.STAR);

        //Calculation of all entities occurring in the pair of given specifications
        Set<OWLEntity> entities=new HashSet<>();
        entities.addAll(CalculateModules.entitiesIO(specificationName1,manager));
        entities.addAll(CalculateModules.entitiesP(specificationName1,manager));
        entities.addAll(CalculateModules.entitiesE(specificationName1,manager));

        entities.addAll(CalculateModules.entitiesIO(specificationName2,manager));
        entities.addAll(CalculateModules.entitiesP(specificationName2,manager));
        entities.addAll(CalculateModules.entitiesE(specificationName2,manager));

        //Module extraction
        IRI moduleIRI = IRI.create(modulesPath+
                specificationName1.replace(".txt","")+"/"+
                specificationName2.replace(".txt","")+"/"+
                "module.owl");
        OWLOntology module = extractor.extractAsOntology(entities,moduleIRI);

        //Module persistence
        IRI moduleRepositoryIRI = IRI.create(modulesRepository+
                specificationName1.replace(".txt","")+"/"+
                specificationName2.replace(".txt","")+"/"+
                "module.owl");
        manager.saveOntology(module,moduleRepositoryIRI);
    }


    public static void calculateModules() throws OWLOntologyCreationException, OWLOntologyStorageException {
        RepositoryHandler rh = new RepositoryHandler(specificationsRepository);
        int count = 0;
        for (File n1:rh.get_files()) {
            count++;
            System.out.println("Calculating modules for "+n1.getName());
            for (File n2:rh.get_files()){
                if (!n1.getName().equals(n2.getName())) {
                    System.out.println("    ("+count+"/"+rh.get_files().size()+")  "+ n2.getName());
                    CalculateModules.calculateModule(n1.getName(), n2.getName());
                }
            }
        }
    }

    public static void calculateModules(String specificationName) throws OWLOntologyCreationException, OWLOntologyStorageException {
        RepositoryHandler rh = new RepositoryHandler(specificationsRepository);
        System.out.println("Calculating modules for "+specificationName);
        for (File n2:rh.get_files()){
            if (!specificationName.equals(n2.getName())) {
                System.out.println("    " + n2.getName());
                CalculateModules.calculateModule(specificationName, n2.getName());
            }
        }
    }
}
