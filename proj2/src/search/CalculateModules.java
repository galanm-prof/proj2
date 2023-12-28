package search;

import file.RepositoryHandler;
import modularity.OntologyModuleExtractor;
import org.antlr.v4.runtime.misc.Pair;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class CalculateModules {
    private static final String requestsPath = "http://127.0.0.1/requests/";
    private static final String requestsRepository = "C://xampp//htdocs//requests//";
    private static final String specificationsPath = "http://127.0.0.1/specifications/";
    private static final String specificationsRepository = "C://xampp//htdocs//specifications//";
    private static final String ontologiesPath = "http://127.0.0.1/ontologies2/";
    private static Pair<OWLOntology,OWLOntologyManager> loadCommonVocabulary(String specificationName,
                                                                             String requestName) throws OWLOntologyCreationException {
        IRI vocabularyIRI = IRI.create(ontologiesPath+
                specificationName.replace(".txt","")+"/"+
                requestName.replace(".txt","")+"/"+
                "vocabulary.owl");
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology vocabulary = manager.loadOntology(vocabularyIRI);
        return new Pair<>(vocabulary,manager);
    }

    //Calculation of all entities in the IO parameters section of a given description (request or specification)
    private static Set<OWLEntity> entitiesIO(String descriptionName,
                                             OWLOntologyManager manager,boolean request) throws OWLOntologyCreationException {
        Set<OWLEntity> entities=new HashSet<>();

        if (request){
            IRI IIRI = IRI.create(requestsPath+
                    descriptionName.replace(".txt","")+"/I.owl");
            IRI OIRI = IRI.create(requestsPath+
                    descriptionName.replace(".txt","")+"/O.owl");

            OWLOntology I = manager.loadOntology(IIRI);
            OWLOntology O = manager.loadOntology(OIRI);

            entities.addAll(I.getSignature());
            entities.addAll(O.getSignature());
        }
        else{
            IRI IIRI = IRI.create(specificationsPath+
                    descriptionName.replace(".txt","")+"/I.owl");
            IRI OIRI = IRI.create(specificationsPath+
                    descriptionName.replace(".txt","")+"/O.owl");

            OWLOntology I = manager.loadOntology(IIRI);
            OWLOntology O = manager.loadOntology(OIRI);

            entities.addAll(I.getSignature());
            entities.addAll(O.getSignature());
        }
        return entities;
    }

    //Calculation of all entities in the precondition section of a given description
    private static Set<OWLEntity> entitiesP(String descriptionName,
                                            OWLOntologyManager manager,boolean request) throws OWLOntologyCreationException {
        Set<OWLEntity> entities=new HashSet<>();

        if (request){
            String requestRepository = requestsRepository+
                    descriptionName.replace(".txt","");
            RepositoryHandler rh = new RepositoryHandler(requestRepository);
            Set<File>files=rh.get_files();
            long pairOfStatesCounter =
                    files.stream().filter(f->f.getName().startsWith("E")).count();
            if (pairOfStatesCounter>1) {
                for (int i = 0; i < pairOfStatesCounter; i++) {
                    IRI PIRI = IRI.create(requestsPath +
                            descriptionName.replace(".txt", "") + "/P" + i + ".owl");
                    OWLOntology P = manager.loadOntology(PIRI);
                    entities.addAll(P.getSignature());
                }
            }
            else{
                IRI PIRI = IRI.create(requestsPath +
                        descriptionName.replace(".txt", "") + "/P.owl");
                OWLOntology P = manager.loadOntology(PIRI);
                entities.addAll(P.getSignature());
            }
        }
        else{
            String specificationRepository = specificationsRepository+
                    descriptionName.replace(".txt","");
            RepositoryHandler rh = new RepositoryHandler(specificationRepository);
            Set<File>files=rh.get_files();
            long pairOfStatesCounter =
                    files.stream().filter(f->f.getName().startsWith("E")).count();
            if (pairOfStatesCounter>1) {
                for (int i = 0; i < pairOfStatesCounter; i++) {
                    IRI PIRI = IRI.create(specificationsPath +
                            descriptionName.replace(".txt", "") + "/P" + i + ".owl");
                    OWLOntology P = manager.loadOntology(PIRI);
                    entities.addAll(P.getSignature());
                }
            }
            else{
                IRI PIRI = IRI.create(specificationsPath +
                        descriptionName.replace(".txt", "") + "/P.owl");
                OWLOntology P = manager.loadOntology(PIRI);
                entities.addAll(P.getSignature());
            }
        }

        return entities;
    }



    //Calculation of all entities in the effect section of a given specification
    private static Set<OWLEntity> entitiesE(String descriptionName,
                                            OWLOntologyManager manager, boolean request) throws OWLOntologyCreationException {
        Set<OWLEntity> entities=new HashSet<>();
        if (request){
            String requestRepository = requestsRepository+
                    descriptionName.replace(".txt","");
            RepositoryHandler rh = new RepositoryHandler(requestRepository);
            Set<File>files=rh.get_files();
            long pairOfStatesCounter =
                    files.stream().filter(f->f.getName().startsWith("E")).count();
            if (pairOfStatesCounter>1) {
                for (int i = 0; i < pairOfStatesCounter; i++) {
                    IRI EIRI = IRI.create(requestsPath +
                            descriptionName.replace(".txt", "") + "/E" + i + ".owl");
                    OWLOntology E = manager.loadOntology(EIRI);
                    entities.addAll(E.getSignature());
                }
            }
            else{
                IRI EIRI = IRI.create(requestsPath +
                        descriptionName.replace(".txt", "") + "/E.owl");
                OWLOntology E = manager.loadOntology(EIRI);
                entities.addAll(E.getSignature());
            }
        }
        else{
            String specificationRepository = specificationsRepository+
                    descriptionName.replace(".txt","");
            RepositoryHandler rh = new RepositoryHandler(specificationRepository);
            Set<File>files=rh.get_files();
            long pairOfStatesCounter =
                    files.stream().filter(f->f.getName().startsWith("E")).count();
            if (pairOfStatesCounter>1) {
                for (int i = 0; i < pairOfStatesCounter; i++) {
                    IRI EIRI = IRI.create(specificationsPath +
                            descriptionName.replace(".txt", "") + "/E" + i + ".owl");
                    OWLOntology E = manager.loadOntology(EIRI);
                    entities.addAll(E.getSignature());
                }
            }
            else{
                IRI EIRI = IRI.create(specificationsPath +
                        descriptionName.replace(".txt", "") + "/E.owl");
                OWLOntology E = manager.loadOntology(EIRI);
                entities.addAll(E.getSignature());
            }
        }

        return entities;
    }

    //Module calculation from the common vocabulary of the pair request, specification
    public static void calculateModule(String specificationName,
                                       String requestName) throws OWLOntologyCreationException, OWLOntologyStorageException {

        String modulesRepository = "file:///C://xampp//htdocs//modules2//";
        String modulesPath = "http://127.0.0.1/modules2/";

        //Load the common vocabulary of the involved specifications
        Pair<OWLOntology,OWLOntologyManager> tuple = loadCommonVocabulary(specificationName,requestName);
        OWLOntology vocabulary = tuple.a;
        OWLOntologyManager manager = tuple.b;

        //Creation of module extractor
        OntologyModuleExtractor extractor =
                new OntologyModuleExtractor(manager, vocabulary,
                        OntologyModuleExtractor.TYPEMODULE.STAR);

        //Calculation of all entities occurring in the pair of given specifications
        Set<OWLEntity> entities=new HashSet<>();
        entities.addAll(CalculateModules.entitiesIO(requestName,manager,true));
        entities.addAll(CalculateModules.entitiesP(requestName,manager,true));
        entities.addAll(CalculateModules.entitiesE(requestName,manager,true));

        entities.addAll(CalculateModules.entitiesIO(specificationName,manager,false));
        entities.addAll(CalculateModules.entitiesP(specificationName,manager,false));
        entities.addAll(CalculateModules.entitiesE(specificationName,manager,false));

        //Module extraction
        IRI moduleIRI = IRI.create(modulesPath+
                specificationName.replace(".txt","")+"/"+
                requestName.replace(".txt","")+"/"+
                "module.owl");
        OWLOntology module = extractor.extractAsOntology(entities,moduleIRI);

        //Module persistence
        IRI moduleRepositoryIRI = IRI.create(modulesRepository+
                specificationName.replace(".txt","")+"/"+
                requestName.replace(".txt","")+"/"+
                "module.owl");
        manager.saveOntology(module,moduleRepositoryIRI);
    }


    public static void calculateModules() throws OWLOntologyCreationException, OWLOntologyStorageException {
        RepositoryHandler rh1 = new RepositoryHandler(specificationsRepository);
        int count = 0;
        for (File n1:rh1.get_files()) {
            count++;
            System.out.println("Calculating modules for "+n1.getName());
            RepositoryHandler rh2 = new RepositoryHandler(requestsRepository);
            for (File n2:rh2.get_files()){
                    System.out.println("    ("+count+"/"+rh1.get_files().size()+")  "+ n2.getName());
                    CalculateModules.calculateModule(n1.getName(), n2.getName());
            }
        }
    }

    //Deprecated (useless)
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
