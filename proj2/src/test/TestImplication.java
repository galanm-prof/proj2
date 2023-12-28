package test;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import search.RepositorySearch;
import search.StateSpaceImplication;

import java.io.IOException;

public class TestImplication {
    public static void main(String[] args) throws IOException, OWLOntologyCreationException, OWLOntologyStorageException {
        String request = "GEOGRAPHICAL-REGIONGEOGRAPHICAL-REGION_ICON_REQUEST";
        String specification1 = "LOCATIONLOCATION_MAP_SERVICE";
        String specification2 = "LOCATIONLOCATION_MAP_SERVICE1";
        String repository="22";
        RepositorySearch prover = new RepositorySearch(repository);
        System.out.println(specification1+" -->(IS) "+request+"?: "+prover.implies1(specification1,request));
        System.out.println(specification2+" -->(IS) "+request+"?: "+prover.implies1(specification2,request));
        System.out.println(specification1+" -->(SS,pre) "+request+"?: "+StateSpaceImplication.preconditionsImplication(specification1,request));
        System.out.println(specification2+" -->(SS,pre) "+request+"?: "+StateSpaceImplication.preconditionsImplication(specification2,request));
        System.out.println(specification1+" -->(SS,eff) "+request+"?: "+ StateSpaceImplication.effectsImplication(specification1,request));
        System.out.println(specification2+" -->(SS,eff) "+request+"?: "+ StateSpaceImplication.effectsImplication(specification2,request));
    }
}
