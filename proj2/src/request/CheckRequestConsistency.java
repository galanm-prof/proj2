package request;

import file.RepositoryHandler;
import org.antlr.v4.runtime.misc.Pair;
import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class CheckRequestConsistency {
    private static OWLReasonerFactory reasonerFactory = new Reasoner.ReasonerFactory();
    private static Pair<Boolean,Boolean> checkPairOfStates(
            OWLOntologyManager manager,IRI vocabularyIRI,
            IRI IIRI, IRI OIRI, IRI PIRI, IRI EIRI
    ) throws OWLOntologyCreationException {
        Pair<Boolean,Boolean>r=null;
        OWLOntology vocabulary = manager.loadOntology(vocabularyIRI);
        OWLOntology I = manager.loadOntology(IIRI);
        OWLOntology O = manager.loadOntology(OIRI);
        OWLOntology P = manager.loadOntology(PIRI);
        OWLOntology E = manager.loadOntology(EIRI);

        Set<OWLAxiom> axiomsForCheckingPreconditionConsistency = new HashSet<>();
        axiomsForCheckingPreconditionConsistency.addAll(vocabulary.getAxioms());
        axiomsForCheckingPreconditionConsistency.addAll(I.getAxioms());
        axiomsForCheckingPreconditionConsistency.addAll(P.getAxioms());

        Set<OWLAxiom> axiomsForCheckingEffectConsistency = new HashSet<>();
        axiomsForCheckingEffectConsistency.addAll(vocabulary.getAxioms());
        axiomsForCheckingEffectConsistency.addAll(I.getAxioms());
        axiomsForCheckingEffectConsistency.addAll(O.getAxioms());
        axiomsForCheckingEffectConsistency.addAll(E.getAxioms());

        OWLOntology ontologyForCheckingPreconditionConsistency =
                manager.createOntology(axiomsForCheckingPreconditionConsistency);
        OWLOntology ontologyForCheckingEffectConsistency =
                manager.createOntology(axiomsForCheckingEffectConsistency);

        //Reasoner reasonerForCheckingPreconditionConsistency = new Reasoner(ontologyForCheckingPreconditionConsistency);
        OWLReasoner reasonerForCheckingPreconditionConsistency = reasonerFactory.createReasoner(ontologyForCheckingPreconditionConsistency);
        //Reasoner reasonerForCheckingEffectConsistency = new Reasoner(ontologyForCheckingEffectConsistency);
        OWLReasoner reasonerForCheckingEffectConsistency= reasonerFactory.createReasoner(ontologyForCheckingEffectConsistency);

        boolean consistencyPrecondition = reasonerForCheckingPreconditionConsistency.isConsistent();
        boolean consistencyEffect = reasonerForCheckingEffectConsistency.isConsistent();

        System.out.println("    consistencyPrecondition = " + consistencyPrecondition);
        System.out.println("    consistencyEffect = " + consistencyEffect);
        r=new Pair<>(consistencyPrecondition,consistencyEffect);
        return r;
    }
    private static Pair<Boolean,Boolean> checkConsistencyPairOfStates(
            String path,int i,OWLOntologyManager manager,
            IRI vocabularyIRI, IRI IIRI, IRI OIRI
    ) throws OWLOntologyCreationException {
        Pair<Boolean,Boolean>r=null;
        IRI PIRI = IRI.create(path + "/P" + i + ".owl");
        IRI EIRI = IRI.create(path + "/E" + i + ".owl");

        r = checkPairOfStates(manager,vocabularyIRI, IIRI, OIRI, PIRI, EIRI);
        return r;
    }

    private static Pair<Boolean,Boolean> checkConsistencyPairOfStates(
            String path,OWLOntologyManager manager,
            IRI vocabularyIRI, IRI IIRI, IRI OIRI
    ) throws OWLOntologyCreationException {
        Pair<Boolean,Boolean>r=null;
        IRI PIRI = IRI.create(path + "/P.owl");
        IRI EIRI = IRI.create(path + "/E.owl");

        r = checkPairOfStates(manager,vocabularyIRI, IIRI, OIRI, PIRI, EIRI);
        return r;
    }
    public static List<Boolean> checkConsistency(String requestName) throws OWLOntologyCreationException {
        List<Boolean> consistency = new LinkedList<>();

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        String repository = "c://xampp//htdocs//requests//"+
                requestName.replace(".txt","");
        String path="http://127.0.0.1/requests/"+
                requestName.replace(".txt","");

        RepositoryHandler rh = new RepositoryHandler(repository);
        Set<File>files=rh.get_files();
        long pairOfStatesCounter =
                files.stream().filter(f->f.getName().startsWith("E")).count();
        System.out.println("Checking the consistency of " + requestName + ":");

        IRI vocabularyIRI = IRI.create(path + "/vocabulary.owl");
        IRI IIRI = IRI.create(path + "/I.owl");
        IRI OIRI = IRI.create(path + "/O.owl");
        if (pairOfStatesCounter>1) {
            for (int i = 0; i < pairOfStatesCounter; i++) {
                System.out.println("Checking the consistency of P" + i + ", " + "E" + i + " :");
                Pair<Boolean,Boolean> r =
                        checkConsistencyPairOfStates(
                                path, i, manager, vocabularyIRI, IIRI, OIRI);
                consistency.add(r.a && r.b);
            }
        }
        else{
            System.out.println("Checking the consistency of P, E :");
            Pair<Boolean,Boolean> r =checkConsistencyPairOfStates(
                    path, manager, vocabularyIRI, IIRI, OIRI);
            consistency.add(r.a && r.b);
        }
        return consistency;
    }

    private static Pair<Boolean,Boolean>checkPairOfModuleStates(
            OWLOntologyManager manager,IRI IIRI,IRI OIRI,IRI PIRI,IRI EIRI,
            OWLOntology vocabularyIPModule,OWLOntology vocabularyIOEModule
    ) throws OWLOntologyCreationException {
        Pair<Boolean,Boolean>r=null;
        OWLOntology I = manager.loadOntology(IIRI);
        OWLOntology O = manager.loadOntology(OIRI);
        OWLOntology P = manager.loadOntology(PIRI);
        OWLOntology E = manager.loadOntology(EIRI);

        Set<OWLAxiom> axiomsForCheckingPreconditionConsistency = new HashSet<>();
        axiomsForCheckingPreconditionConsistency.addAll(vocabularyIPModule.getAxioms());
        axiomsForCheckingPreconditionConsistency.addAll(I.getAxioms());
        axiomsForCheckingPreconditionConsistency.addAll(P.getAxioms());

        Set<OWLAxiom> axiomsForCheckingEffectConsistency = new HashSet<>();
        axiomsForCheckingEffectConsistency.addAll(vocabularyIOEModule.getAxioms());
        axiomsForCheckingEffectConsistency.addAll(I.getAxioms());
        axiomsForCheckingEffectConsistency.addAll(O.getAxioms());
        axiomsForCheckingEffectConsistency.addAll(E.getAxioms());

        OWLOntology ontologyForCheckingPreconditionConsistency =
                manager.createOntology(axiomsForCheckingPreconditionConsistency);
        OWLOntology ontologyForCheckingEffectConsistency =
                manager.createOntology(axiomsForCheckingEffectConsistency);
        OWLReasoner reasonerForCheckingPreconditionConsistency = reasonerFactory.createReasoner(ontologyForCheckingPreconditionConsistency);
        //Reasoner reasonerForCheckingPreconditionConsistency = new Reasoner(ontologyForCheckingPreconditionConsistency);
        OWLReasoner reasonerForCheckingEffectConsistency= reasonerFactory.createReasoner(ontologyForCheckingEffectConsistency);
        //Reasoner reasonerForCheckingEffectConsistency = new Reasoner(ontologyForCheckingEffectConsistency);

        boolean consistencyPrecondition = reasonerForCheckingPreconditionConsistency.isConsistent();
        boolean consistencyEffect = reasonerForCheckingEffectConsistency.isConsistent();

        System.out.println("    consistencyPrecondition = " + consistencyPrecondition);
        System.out.println("    consistencyEffect = " + consistencyEffect);
        r = new Pair<>(consistencyPrecondition,consistencyEffect);
        return r;
    }
    private static Pair<Boolean,Boolean> checkModuleConsistencyPairOfStates(
            String path,OWLOntologyManager manager,IRI IIRI, IRI OIRI
    ) throws OWLOntologyCreationException {
        Pair<Boolean,Boolean>r=null;
        IRI PIRI = IRI.create(path + "/P.owl");
        IRI EIRI = IRI.create(path + "/E.owl");

        IRI vocabularyIPModuleIRI = IRI.create(path + "/vocabularyIPModule.owl");
        OWLOntology vocabularyIPModule = manager.loadOntology(vocabularyIPModuleIRI);
        IRI vocabularyIOEModuleIRI = IRI.create(path + "/vocabularyIOEModule.owl");
        OWLOntology vocabularyIOEModule = manager.loadOntology(vocabularyIOEModuleIRI);

        r = checkPairOfModuleStates(manager,IIRI,OIRI,PIRI,EIRI,
                vocabularyIPModule,vocabularyIOEModule);
        return r;
    }
    private static Pair<Boolean,Boolean> checkModuleConsistencyPairOfStates(
            String path,int i,OWLOntologyManager manager,IRI IIRI, IRI OIRI
    ) throws OWLOntologyCreationException {
        Pair<Boolean,Boolean>r=null;
        IRI PIRI = IRI.create(path + "/P" + i + ".owl");
        IRI EIRI = IRI.create(path + "/E" + i + ".owl");

        IRI vocabularyIPModuleIRI = IRI.create(path + "/vocabularyIPModule"+i+".owl");
        OWLOntology vocabularyIPModule = manager.loadOntology(vocabularyIPModuleIRI);
        IRI vocabularyIOEModuleIRI = IRI.create(path + "/vocabularyIOEModule"+i+".owl");
        OWLOntology vocabularyIOEModule = manager.loadOntology(vocabularyIOEModuleIRI);

        r = checkPairOfModuleStates(manager,IIRI,OIRI,PIRI,EIRI,
                vocabularyIPModule,vocabularyIOEModule);
        return r;
    }
    public static List<Boolean> checkModuleConsistency(String requestName) throws OWLOntologyCreationException {
        List<Boolean> consistency = new LinkedList<>();

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        String repository = "c://xampp//htdocs//requests//"+
                requestName.replace(".txt","");
        String path="http://127.0.0.1/requests/"+
                requestName.replace(".txt","");

        RepositoryHandler rh = new RepositoryHandler(repository);
        Set<File>files=rh.get_files();
        long pairOfStatesCounter =
                files.stream().filter(f->f.getName().startsWith("E")).count();
        System.out.println("Checking the consistency of " + requestName + ":");
        IRI IIRI = IRI.create(path + "/I.owl");
        IRI OIRI = IRI.create(path + "/O.owl");
        if (pairOfStatesCounter>1) {
            for (int i = 0; i < pairOfStatesCounter; i++) {
                System.out.println("Checking the consistency of P" + i + ", " + "E" + i + " :");
                Pair<Boolean,Boolean>r =
                        checkModuleConsistencyPairOfStates(path,i,manager, IIRI, OIRI);
                consistency.add(r.a && r.b);
            }
        }
        else{
            System.out.println("Checking the consistency of P, E :");
            Pair<Boolean,Boolean>r =
                    checkModuleConsistencyPairOfStates(path,manager, IIRI, OIRI);
            consistency.add(r.a && r.b);
        }
        return consistency;
    }
}
