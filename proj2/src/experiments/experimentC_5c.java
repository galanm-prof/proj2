package experiments;
import common.Tuple;
import common.Tuple2;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import repositories.Repositories;
import search.RepositorySearch;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
public class experimentC_5c{
     private static int nRepositories=20;
     private static int repositorySize=140;
     private static String predicate="meanRelativeSizeInformationSpaceStrongSetsMax(0.021) and meanRelativeSizeInformationSpaceWeakSetsMax(0.025)";
     private static Set<String>requests;
     private static long time1,time2;
     private static double meanSearchSpaceAcc;
     private static double coefficientVariationAcc;
     private static double meanSearchSpaceRemainingDiscoveryAcc;
     private static double meanSpecificationsPercentageRemainingDiscoveryAcc;
     private static boolean repositoriesGenerationIsOK=true;
    private static void initRequests(){
        requests=new HashSet<>();
        requests.add("CALCULATE_SUNRISE_REQUEST");
        requests.add("CHECK_ADDRESS_REQUEST");
        requests.add("CITY_HOTEL_REQUEST");
        requests.add("CITYCITY_MAP_REQUEST");
        requests.add("CITYCOUNTRY_ACCOMMODATION_REQUEST");
        requests.add("CREDITACCOUNTBOOKPERSON__REQUEST");
        requests.add("GEOGRAPHICAL-REGIONGEOGRAPHICAL-REGION_ICON_REQUEST");
        requests.add("GetMedicalTransportAccountRequest");
        requests.add("open_door_request");
        requests.add("ProvideMedicalFlightInformationRequest");
        requests.add("TIME-MEASUREGEOPOLITICAL-ENTITYCITY_BEDANDBREAKFAST_REQUEST");
    }
     private static boolean generateRepositories() throws IOException {
         Set<Integer> s1=Repositories.selectionOfRepositories(repositorySize);
         Set<Integer> s2=Repositories.selectionOfRepositories(predicate);
         s1.retainAll(s2);
         if (s1.size()<nRepositories)
             repositoriesGenerationIsOK=Repositories.conditionalGenerationOfRepositories(nRepositories-s1.size(),repositorySize,predicate);
         return repositoriesGenerationIsOK;
     }
     private static Tuple2<Boolean,Set<String>> selectionOfRepositories() throws IOException {
         Boolean b=false;
         Set<String> s=new HashSet<>();
         Tuple2<Boolean,Set<String>> tuple=null;
         Set<Integer> s1=Repositories.selectionOfRepositories(repositorySize);
         Set<Integer> s2=Repositories.selectionOfRepositories(predicate);
         s1.retainAll(s2);
         if (s1.size()<nRepositories)
             tuple=new Tuple2(b,s);
         else{
             int cont=0;
             for(Integer r:s1) {
                 if (cont==nRepositories) break;
                 else{
                     s.add(r.toString());
                     cont++;
                 }
             }
             b=true;
             tuple=new Tuple2(b,s);
         }
         return tuple;
     }
     private static void search(Set<String>repositories) throws IOException, OWLOntologyCreationException {
         meanSearchSpaceAcc=0.0;
         coefficientVariationAcc=0.0;
         meanSpecificationsPercentageRemainingDiscoveryAcc=0.0;
         Calendar begin = Calendar.getInstance();
         time1 = begin.getTimeInMillis();
         for(String repository:repositories){
             System.out.println("\nRepository: "+repository);
             System.out.println("---------------");
             double searchSpacePerRepository=0.0;
             double searchSpaceRemainingDiscoveryPerRepository=0.0;
             double specificationsPercentageRemainingDiscoveryPerRepository=0.0;
             double variancePerRepository=0.0;
             RepositorySearch searching = new RepositorySearch(repository);
             for(String request:requests){
                 Tuple<Set<String>,Double,Set<String>,Double> r1=searching.efficientSearch2LevelsOfAbstraction(request);
                 System.out.println("Request: "+request);
                 System.out.println("Found services (Direct Discovery): "+r1.getField1());
                 System.out.println("Found services (Remaining Discovery): "+r1.getField3());
                 System.out.println("Search space (percentage): "+r1.getField2()*100+"%");
                 System.out.println("Search space (Remaining Discovery) (percentage): "+r1.getField4()*100+"%");
                 searchSpacePerRepository+=r1.getField2()*100;
                 variancePerRepository+=r1.getField2()*100*r1.getField2()*100;
                 searchSpaceRemainingDiscoveryPerRepository+=r1.getField4()*100;
                 if (r1.getField1().size()>0) 
                     specificationsPercentageRemainingDiscoveryPerRepository+=
                         (r1.getField3().size()/r1.getField1().size())*100;
             }
             double meanSearchSpacePerRepository=searchSpacePerRepository/requests.size();
             double meanVariancePerRepository=(variancePerRepository/requests.size())-(meanSearchSpacePerRepository*meanSearchSpacePerRepository);
             double coefficientVariationPerRepository=(Math.sqrt(Math.abs(meanVariancePerRepository))/Math.abs(meanSearchSpacePerRepository))*100;
             double meanSearchSpaceRemainingDiscoveryPerRepository=searchSpaceRemainingDiscoveryPerRepository/requests.size();
             double meanSpecificationsPercentageRemainingDiscoveryPerRepository=specificationsPercentageRemainingDiscoveryPerRepository/requests.size();
             System.out.println("Mean search space (percentage) in repository "+repository+":  "+meanSearchSpacePerRepository+"%");
             System.out.println("Coefficient of variation (percentage) in repository "+repository+":  "+coefficientVariationPerRepository+"%");
             System.out.println("Mean search space (Remaining discovery) (percentage) in repository "+repository+":  "+meanSearchSpaceRemainingDiscoveryPerRepository+"%");
             System.out.println("Mean proportion of specifications found at the remaining discovery stage (percentage) in repository "+repository+":  "+meanSpecificationsPercentageRemainingDiscoveryPerRepository+"%");
             meanSearchSpaceAcc+=meanSearchSpacePerRepository;
             coefficientVariationAcc+=coefficientVariationPerRepository;
             meanSearchSpaceRemainingDiscoveryAcc+=meanSearchSpaceRemainingDiscoveryPerRepository;
             meanSpecificationsPercentageRemainingDiscoveryAcc+=meanSpecificationsPercentageRemainingDiscoveryPerRepository;
         }
         Calendar end = Calendar.getInstance();
         time2 = end.getTimeInMillis();
         System.out.println("\nMean search time (in seconds): " + ((time2 - time1) / 1000.0)/nRepositories);
         System.out.println("Mean search space (percentage) : "+(meanSearchSpaceAcc/nRepositories)+"%");
         System.out.println("Mean coefficient of variation (percentage) : "+(coefficientVariationAcc/nRepositories)+"%");
         System.out.println("Mean search space at the remaining discovery stage (percentage) : "+(meanSearchSpaceRemainingDiscoveryAcc/nRepositories)+"%");
         System.out.println("Mean proportion of specifications found at the remaining discovery stage (percentage) : "+(meanSpecificationsPercentageRemainingDiscoveryAcc/nRepositories)+"%");
         FileWriter g = new FileWriter("./src/experiments/experimentC_5c.out");
         g.write("mean search time (in sec): "+((time2 - time1) / 1000.0)/nRepositories+"\n");
         g.write("mean search space (percentage): "+(meanSearchSpaceAcc/nRepositories)+"\n");
         g.write("coefficient of variation (percentage): "+(coefficientVariationAcc/nRepositories)+"\n");
         g.write("mean search space at the remaining discovery stage (percentage): "+(meanSearchSpaceRemainingDiscoveryAcc/nRepositories)+"\n");
         g.write("mean proportion of specifications found at the remaining discovery stage (percentage): "+(meanSpecificationsPercentageRemainingDiscoveryAcc/nRepositories)+"\n");
         g.close();
     }
     private static boolean experiment() throws IOException, OWLOntologyCreationException {
         boolean r = false;
         Tuple2<Boolean,Set<String>> tuple=experimentC_5c.selectionOfRepositories();
         if (!tuple.getField1()) {
             System.out.println("Before generating repositories: "+tuple.getField2().size()+"/"+nRepositories);
             boolean b=experimentC_5c.generateRepositories();
             System.out.println("Generation of repositories: "+b);
         }
         initRequests();
         tuple = experimentC_5c.selectionOfRepositories();
         r = tuple.getField1();
         if (r)
             experimentC_5c.search(tuple.getField2());
         return r;
     }
     public static void main(String[]args){
         try {
             boolean r=experimentC_5c.experiment();
             System.out.println("Experiment done?: "+r);
         } catch (IOException e) { throw new RuntimeException(e); } catch (OWLOntologyCreationException e) {  throw new RuntimeException(e); }
     }
 }
