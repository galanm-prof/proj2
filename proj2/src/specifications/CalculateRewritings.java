package specifications;

import common.ReadSubstitution;
import common.Substitution;
import file.RepositoryHandler;
import org.semanticweb.owlapi.model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalculateRewritings {

    public static final String specificationsRepository = "C://xampp//htdocs//specifications//";
    public static final String rewritingRepository = "C://xampp//htdocs//rewriting//";

    private static void createDirectories(String repository,String specificationName1,String specificationName2){
        File r = new File(rewritingRepository);
        File s = new File(repository);
        File t = new File(repository+
                specificationName1.replace(".txt","")+"//");
        File u = new File(repository+
                specificationName1.replace(".txt","")+"//"+
                specificationName2.replace(".txt","")+"//");
        if (!r.exists())  r.mkdir();
        if (!s.exists())  s.mkdir();
        if (!t.exists())  t.mkdir();
        if (!u.exists())  u.mkdir();
    }

    private static void createDirectories(String repository,String ext,
                                          String specificationName1,
                                          String specificationName2){
        File r = new File(rewritingRepository);
        File s = new File(repository);
        File t = new File(repository+
                specificationName1.replace(".txt","")+"//");
        File u = new File(repository+
                specificationName1.replace(".txt","")+"//"+
                specificationName2.replace(".txt","")+"//");
        File v = new File(repository+
                specificationName1.replace(".txt","")+"//"+
                specificationName2.replace(".txt","")+"//"+
                ext+"//");
        if (!r.exists())  r.mkdir();
        if (!s.exists())  s.mkdir();
        if (!t.exists())  t.mkdir();
        if (!u.exists())  u.mkdir();
        if (!v.exists())  v.mkdir();
    }


    //Calculate rewritings of the different sections (materialised as ontologies) which compose a specification
    //The rewriting is done in the context of an implication between a pair of specifications.

    //Rewriting of I
    public static void calculateRewritingI(String specificationName1,
                                           String specificationName2) throws OWLOntologyCreationException, OWLOntologyStorageException, IOException {
        String rewritingRepositoryI = rewritingRepository+"rewritingI//";
        String specificationRepository1 = specificationsRepository+
                specificationName1.replace(".txt","")+"//";
        Path IPath = Path.of(specificationRepository1+"I.owl");
        String I = Files.readString(IPath);
        //Rewriting I
        Set<Set<Substitution>> substitutions =
                ReadSubstitution.read(true, specificationName1,
                specificationName2);
        List<String>Is = new ArrayList<>();
        for(Set<Substitution>substitution:substitutions) {
            String rewrittenI = I;
            for (Substitution s:substitution) {
                rewrittenI = rewrittenI.replace(s.parameterName1(),s.parameterName2());
                rewrittenI = rewrittenI.replace(s.type1(),s.type2());
            }
            Is.add(rewrittenI);
        }
        if (substitutions.isEmpty()) //empty substitution
            Is.add(I);

        //Rewritten I persistence
        CalculateRewritings.createDirectories(rewritingRepositoryI,specificationName1,specificationName2);
        for(int i=0;i<Is.size();i++) {
            FileWriter f = new FileWriter(rewritingRepositoryI+
                    specificationName1.replace(".txt","")+"//"+
                    specificationName2.replace(".txt","")+"//I"+i+".owl");
            f.write(Is.get(i));
            f.close();
        }
    }

    //Rewriting of O
    public static void calculateRewritingO(String specificationName1,
                                           String specificationName2) throws OWLOntologyCreationException, OWLOntologyStorageException, IOException {
        String rewritingRepositoryO = rewritingRepository+"rewritingO//";
        String specificationRepository2 = specificationsRepository+
                specificationName2.replace(".txt","")+"//";
        Path OPath = Path.of(specificationRepository2+"O.owl");
        String O = Files.readString(OPath);

        Set<Set<Substitution>> substitutions =
                ReadSubstitution.read(false, specificationName1,
                        specificationName2);
        List<String>Os = new ArrayList<>();
        for(Set<Substitution>substitution:substitutions) {
            String rewrittenO = O;
            for (Substitution s:substitution) {
                rewrittenO = rewrittenO.replace(s.parameterName2(),s.parameterName1());
                rewrittenO = rewrittenO.replace(s.type2(),s.type1());
            }
            Os.add(rewrittenO);
        }
        if (substitutions.isEmpty()) //empty substitution
            Os.add(O);

        CalculateRewritings.createDirectories(rewritingRepositoryO,specificationName1,specificationName2);
        for(int i=0;i<Os.size();i++) {
            FileWriter f = new FileWriter(rewritingRepositoryO+
                    specificationName1.replace(".txt","")+"//"+
                    specificationName2.replace(".txt","")+"//O"+i+".owl");
            f.write(Os.get(i));
            f.close();
        }
    }

    //Rewriting of P
    private static void calculateRewritingP1(String specificationName1,
                                             String specificationName2) throws OWLOntologyCreationException, OWLOntologyStorageException, IOException {
        String rewritingRepositoryP = rewritingRepository+"rewritingP//";
        String specificationRepository1 = specificationsRepository+
                specificationName1.replace(".txt","")+"//";
        RepositoryHandler rh = new RepositoryHandler(specificationRepository1);
        Set<File> files=rh.get_files();
        long filesCounter =  files.stream().filter(f->f.getName().startsWith("P")).count();
        if (filesCounter>1) {
            for (int i = 0; i < filesCounter; i++) {
                Path PPath = Path.of(specificationRepository1 + "P" + i + ".owl");
                String P = Files.readString(PPath);
                Set<Set<Substitution>> substitutions =
                        ReadSubstitution.read(true, specificationName1,
                                specificationName2);
                List<String> P1s = new ArrayList<>();
                for (Set<Substitution> substitution : substitutions) {
                    String rewrittenP1 = P;
                    for (Substitution s : substitution) {
                        rewrittenP1 = rewrittenP1.replace(s.parameterName1(), s.parameterName2());
                    }
                    P1s.add(rewrittenP1);
                }
                if (substitutions.isEmpty()) //empty substitution
                    P1s.add(P);

                CalculateRewritings.createDirectories(rewritingRepositoryP,"P1",
                        specificationName1,specificationName2);
                for(int k=0;k<P1s.size();k++) {
                    FileWriter f = new FileWriter(rewritingRepositoryP+
                            specificationName1.replace(".txt","")+"//"+
                            specificationName2.replace(".txt","")+"//"
                            +"P1"+"//"+"P"+i+"_"+k+".owl");
                    f.write(P1s.get(k));
                    f.close();
                }
            }
        }
        else {
            Path PPath = Path.of(specificationRepository1 + "P.owl");
            String P = Files.readString(PPath);
            Set<Set<Substitution>> substitutions =
                    ReadSubstitution.read(true, specificationName1,
                            specificationName2);
            List<String> P1s = new ArrayList<>();
            for (Set<Substitution> substitution : substitutions) {
                String rewrittenP1 = P;
                for (Substitution s : substitution) {
                    rewrittenP1 = rewrittenP1.replace(s.parameterName1(), s.parameterName2());
                }
                P1s.add(rewrittenP1);
            }
            if (substitutions.isEmpty()) //empty substitution
                P1s.add(P);

            CalculateRewritings.createDirectories(rewritingRepositoryP,"P1",
                    specificationName1,specificationName2);
            for (int k = 0; k < P1s.size(); k++) {
                FileWriter f = new FileWriter(rewritingRepositoryP +
                        specificationName1.replace(".txt", "") + "//" +
                        specificationName2.replace(".txt", "") + "//" +
                        "P1"+"//" + "P" + k + ".owl");
                f.write(P1s.get(k));
                f.close();
            }
        }
    }

    private static void calculateRewritingP2(String specificationName1,
                                             String specificationName2) throws OWLOntologyCreationException, OWLOntologyStorageException, IOException {
        String rewritingRepositoryP = rewritingRepository+"rewritingP//";
        String specificationRepository2 = specificationsRepository+
                specificationName2.replace(".txt","")+"//";
        RepositoryHandler rh = new RepositoryHandler(specificationRepository2);
        Set<File> files=rh.get_files();
        long filesCounter =  files.stream().filter(f->f.getName().startsWith("P")).count();
        if (filesCounter>1) {
            for (int i = 0; i < filesCounter; i++) {
                Path PPath = Path.of(specificationRepository2 + "P" + i + ".owl");
                String P = Files.readString(PPath);
                Set<Set<Substitution>> substitutions =
                        ReadSubstitution.read(false, specificationName1,
                                specificationName2);
                List<String> P2s = new ArrayList<>();
                for (Set<Substitution> substitution : substitutions) {
                    String rewrittenP2 = P;
                    for (Substitution s : substitution) {
                        rewrittenP2 = rewrittenP2.replace(s.parameterName2(), s.parameterName1());
                    }
                    P2s.add(rewrittenP2);
                }
                if (substitutions.isEmpty()) //empty substitution
                    P2s.add(P);

                CalculateRewritings.createDirectories(rewritingRepositoryP,"P2",
                        specificationName1,specificationName2);
                for(int k=0;k<P2s.size();k++) {
                    FileWriter f = new FileWriter(rewritingRepositoryP+
                            specificationName1.replace(".txt","")+"//"+
                            specificationName2.replace(".txt","")+"//"+
                            "P2"+"//"+"P"+i+"_"+k+".owl");
                    f.write(P2s.get(k));
                    f.close();
                }
            }
        }
        else {
            Path PPath = Path.of(specificationRepository2 + "P.owl");
            String P = Files.readString(PPath);
            Set<Set<Substitution>> substitutions =
                    ReadSubstitution.read(false, specificationName1,
                            specificationName2);
            List<String> P2s = new ArrayList<>();
            for (Set<Substitution> substitution : substitutions) {
                String rewrittenP2 = P;
                for (Substitution s : substitution) {
                    rewrittenP2 = rewrittenP2.replace(s.parameterName2(), s.parameterName1());
                }
                P2s.add(rewrittenP2);
            }
            if (substitutions.isEmpty()) //empty substitution
                P2s.add(P);

            CalculateRewritings.createDirectories(rewritingRepositoryP,"P2",
                    specificationName1,specificationName2);
            for (int k = 0; k < P2s.size(); k++) {
                FileWriter f = new FileWriter(rewritingRepositoryP +
                        specificationName1.replace(".txt", "") + "//" +
                        specificationName2.replace(".txt", "") + "//"
                        + "P2"+"//" + "P" + k + ".owl");
                f.write(P2s.get(k));
                f.close();
            }
        }
    }
    public static void calculateRewritingP(String specificationName1,
                                           String specificationName2) throws OWLOntologyCreationException, OWLOntologyStorageException, IOException {
        CalculateRewritings.calculateRewritingP1(specificationName1,specificationName2);
        CalculateRewritings.calculateRewritingP2(specificationName1,specificationName2);
    }

    public static void calculateRewritingE(String specificationName1,
                                           String specificationName2) throws OWLOntologyCreationException, OWLOntologyStorageException, IOException {
        CalculateRewritings.calculateRewritingE1(specificationName1,specificationName2);
        CalculateRewritings.calculateRewritingE2(specificationName1,specificationName2);
    }

    private static void calculateRewritingE1(String specificationName1,
                                             String specificationName2) throws OWLOntologyCreationException, OWLOntologyStorageException, IOException {

        String rewritingRepositoryE = rewritingRepository+"rewritingE//";
        String specificationRepository1 = specificationsRepository+
                specificationName1.replace(".txt","")+"//";
        RepositoryHandler rh = new RepositoryHandler(specificationRepository1);
        Set<File> files=rh.get_files();
        long filesCounter =  files.stream().filter(f->f.getName().startsWith("E")).count();
        if (filesCounter>1) {
            for (int i = 0; i < filesCounter; i++) {
                Path EPath = Path.of(specificationRepository1 + "E" + i + ".owl");
                String E = Files.readString(EPath);
                Set<Set<Substitution>> substitutions =
                        ReadSubstitution.read(true, specificationName1,
                                specificationName2);
                List<String> E1s = new ArrayList<>();
                for (Set<Substitution> substitution : substitutions) {
                    String rewrittenE1 = E;
                    for (Substitution s : substitution) {
                        rewrittenE1 = rewrittenE1.replace(s.parameterName1(), s.parameterName2());
                    }
                    E1s.add(rewrittenE1);
                }
                if (substitutions.isEmpty()) //empty substitution
                    E1s.add(E);

                CalculateRewritings.createDirectories(rewritingRepositoryE,"E1",
                        specificationName1,specificationName2);
                for(int k=0;k<E1s.size();k++) {
                    FileWriter f = new FileWriter(rewritingRepositoryE+
                            specificationName1.replace(".txt","")+"//"+
                            specificationName2.replace(".txt","")+"//"
                            +"E1"+"//"+"E"+i+"_"+k+".owl");
                    f.write(E1s.get(k));
                    f.close();
                }
            }
        }
        else {
            Path EPath = Path.of(specificationRepository1 + "E.owl");
            String E = Files.readString(EPath);
            Set<Set<Substitution>> substitutions =
                    ReadSubstitution.read(true, specificationName1,
                            specificationName2);
            List<String> E1s = new ArrayList<>();
            for (Set<Substitution> substitution : substitutions) {
                String rewrittenE1 = E;
                for (Substitution s : substitution) {
                    rewrittenE1 = rewrittenE1.replace(s.parameterName1(), s.parameterName2());
                }
                E1s.add(rewrittenE1);
            }
            if (substitutions.isEmpty()) //empty substitution
                E1s.add(E);

            CalculateRewritings.createDirectories(rewritingRepositoryE,"E1",
                    specificationName1,specificationName2);
            for (int k = 0; k < E1s.size(); k++) {
                FileWriter f = new FileWriter(rewritingRepositoryE +
                        specificationName1.replace(".txt", "") + "//" +
                        specificationName2.replace(".txt", "") + "//" +
                        "E1"+"//" + "E" + k + ".owl");
                f.write(E1s.get(k));
                f.close();
            }
        }
    }

    private static void calculateRewritingE2(String specificationName1,
                                             String specificationName2) throws OWLOntologyCreationException, OWLOntologyStorageException, IOException {

        String rewritingRepositoryE = rewritingRepository+"rewritingE//";
        String specificationRepository2 = specificationsRepository+
                specificationName2.replace(".txt","")+"//";
        RepositoryHandler rh = new RepositoryHandler(specificationRepository2);
        Set<File> files=rh.get_files();
        long filesCounter =  files.stream().filter(f->f.getName().startsWith("E")).count();
        if (filesCounter>1) {
            for (int i = 0; i < filesCounter; i++) {
                Path EPath = Path.of(specificationRepository2 + "E" + i + ".owl");
                String E = Files.readString(EPath);
                Set<Set<Substitution>> substitutions =
                        ReadSubstitution.read(false, specificationName1,
                                specificationName2);
                List<String> E2s = new ArrayList<>();
                for (Set<Substitution> substitution : substitutions) {
                    String rewrittenE2 = E;
                    for (Substitution s : substitution) {
                        rewrittenE2 = rewrittenE2.replace(s.parameterName2(), s.parameterName1());
                    }
                    E2s.add(rewrittenE2);
                }
                if (substitutions.isEmpty()) //empty substitution
                    E2s.add(E);

                CalculateRewritings.createDirectories(rewritingRepositoryE,"E2",
                        specificationName1,specificationName2);
                for(int k=0;k<E2s.size();k++) {
                    FileWriter f = new FileWriter(rewritingRepositoryE+
                            specificationName1.replace(".txt","")+"//"+
                            specificationName2.replace(".txt","")+"//"+
                            "E2"+"//"+"E"+i+"_"+k+".owl");
                    f.write(E2s.get(k));
                    f.close();
                }
            }
        }
        else {
            Path EPath = Path.of(specificationRepository2 + "E.owl");
            String E = Files.readString(EPath);
            Set<Set<Substitution>> substitutions =
                    ReadSubstitution.read(false, specificationName1,
                            specificationName2);
            List<String> E2s = new ArrayList<>();
            for (Set<Substitution> substitution : substitutions) {
                String rewrittenE2 = E;
                for (Substitution s : substitution) {
                    rewrittenE2 = rewrittenE2.replace(s.parameterName2(), s.parameterName1());
                }
                E2s.add(rewrittenE2);
            }
            if (substitutions.isEmpty()) //empty substitution
                E2s.add(E);

            CalculateRewritings.createDirectories(rewritingRepositoryE,"E2",
                    specificationName1,specificationName2);
            for (int k = 0; k < E2s.size(); k++) {
                FileWriter f = new FileWriter(rewritingRepositoryE +
                        specificationName1.replace(".txt", "") + "//" +
                        specificationName2.replace(".txt", "") + "//"
                        + "E2"+"//" + "E" + k + ".owl");
                f.write(E2s.get(k));
                f.close();
            }
        }
    }

    public static void calculateRewriting(String specificationName1,
                                           String specificationName2) throws OWLOntologyCreationException, IOException, OWLOntologyStorageException {
        String substitutionsRepository = "C://xampp//htdocs//substitutions//substitutionsI//";
        RepositoryHandler rh = new RepositoryHandler(substitutionsRepository);
        Set<File> directories=rh.get_directories();
        if (directories.stream().
                anyMatch(d->d.getName().equals(specificationName1.replace(".txt","")))) {
            String repository = substitutionsRepository+
                    specificationName1.replace(".txt","")+"//";
            rh = new RepositoryHandler(repository);
            directories=rh.get_directories();
            if (directories.stream().
                    anyMatch(d->d.getName().equals(specificationName2.replace(".txt","")))) {
                CalculateRewritings.calculateRewritingI(specificationName1, specificationName2);
                CalculateRewritings.calculateRewritingO(specificationName1, specificationName2);
                CalculateRewritings.calculateRewritingP(specificationName1, specificationName2);
                CalculateRewritings.calculateRewritingE(specificationName1, specificationName2);
            }
        }
    }

    public static void calculateRewritings() throws OWLOntologyCreationException, OWLOntologyStorageException, IOException {
        RepositoryHandler rh = new RepositoryHandler(specificationsRepository);
        for (File n1:rh.get_files()) {
            System.out.println("Calculating rewritings for "+n1.getName());
            for (File n2:rh.get_files()){
                if (!n1.getName().equals(n2.getName())) {
                    System.out.println("    " + n2.getName());
                    CalculateRewritings.calculateRewriting(n1.getName(), n2.getName());
                }
            }
        }
    }
}
