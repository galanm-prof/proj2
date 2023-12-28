package test;

import common.Tuple;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import repositories.Repositories;
import search.RepositorySearch;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class TestSearch {

    private static int nRepositories=20;
    private static int repositorySize=140;
    private static String predicate="true";
            //"meanRelativeSizeInformationSpaceStrongSetsMax(0.021) and meanRelativeSizeInformationSpaceWeakSetsMax(0.025)";
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
                Tuple<Set<String>,Double,Set<String>,Double> r1=searching.efficientSearch2LevelsOfAbstractionPost(request);
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
    }

    public static void main(String[] args) throws IOException, OWLOntologyCreationException, OWLOntologyStorageException {
        String request = //"GEOGRAPHICAL-REGIONGEOGRAPHICAL-REGION_ICON_REQUEST";
                //"CALCULATE_SUNRISE_REQUEST";
                //"TIME-MEASUREGEOPOLITICAL-ENTITYCITY_BEDANDBREAKFAST_REQUEST";
                //"ProvideMedicalFlightInformationRequest";
                //"GetMedicalTransportAccountRequest";
                //"CREDITACCOUNTBOOKPERSON__REQUEST";
                //"CITYCITY_MAP_REQUEST";
                //"CITY_HOTEL_GERMAN_REQUEST";
                //"CHECK_ADDRESS_REQUEST";
                "CITYCOUNTRY_ACCOMMODATION_REQUEST";
        /*
        Searching searching = new Searching();

        Calendar begin = Calendar.getInstance();
        long time1 = begin.getTimeInMillis();
        Pair<Set<String>,Double> r1=searching.inefficientSearchingInformationSpace(request);
        Calendar end = Calendar.getInstance();
        long time2 = end.getTimeInMillis();
        System.out.println("\nAmount of time (in seconds): " + (time2 - time1) / 1000.0);
        System.out.println("Found services: "+r1.a);
        System.out.println("Percentage of specifications which have been visited: "+r1.b*100+"%");

        begin = Calendar.getInstance();
        time1 = begin.getTimeInMillis();
        Pair<Set<String>,Double> r2=searching.efficientSearchingInformationSpace(request);
        end = Calendar.getInstance();
        time2 = end.getTimeInMillis();
        System.out.println("Amount of time (in seconds): " + (time2 - time1) / 1000.0);
        System.out.println("Found services: "+r2.a);
        System.out.println("Percentage of specifications which have been visited: "+r2.b*100+"%");

        begin = Calendar.getInstance();
        time1 = begin.getTimeInMillis();
        Pair<Set<String>,Double> r3=
                searching.efficientSearchingInformationSpaceStateSpace(request);
        end = Calendar.getInstance();
        time2 = end.getTimeInMillis();
        System.out.println("Amount of time (in seconds): " + (time2 - time1) / 1000.0);
        System.out.println("Found services: "+r3.a);
        System.out.println("Percentage of specifications which have been visited: "+r2.b*100+"%");
        */
        int repositorySize = 140;
        Set<Integer> s1= Repositories.selectionOfRepositories(repositorySize);
        String repository=s1.stream().findAny().get().toString(); //"22"
        RepositorySearch searching = new RepositorySearch(repository);
        System.out.println("\nSearching for "+request+" in repository "+repository+":");
        Calendar begin = Calendar.getInstance();
        long time1 = begin.getTimeInMillis();
        //Tuple<Set<String>,Double> r1=searching.inefficientSearchingInformationSpace(request);
        //Tuple<Set<String>,Double> r1=searching.inefficientSearchingStateSpace(request);
        Tuple<Set<String>,Double,Set<String>,Double> r1=searching.efficientSearch2LevelsOfAbstraction(request);
        Calendar end = Calendar.getInstance();
        long time2 = end.getTimeInMillis();
        System.out.println("\nSearch time (in seconds): " + (time2 - time1) / 1000.0);
        System.out.println("Request: "+request);
        System.out.println("Found services: "+r1.getField1());
        System.out.println("Found remaining services: "+r1.getField3());
        System.out.println("Search space (percentage): "+r1.getField2()*100+"%");
        System.out.println("Remaining search space (percentage): "+r1.getField4()*100+"%");
        /*
        System.out.println("\nSearching for "+request+" in repository "+repository+":");
        begin = Calendar.getInstance();
        time1 = begin.getTimeInMillis();
        Tuple<Set<String>,Double> r2=searching.efficientSearchingInformationSpace(request);
        end = Calendar.getInstance();
        time2 = end.getTimeInMillis();
        System.out.println("Amount of time (in seconds): " + (time2 - time1) / 1000.0);
        System.out.println("Request: "+request);
        System.out.println("Found services: "+r2.getField1());
        System.out.println("Percentage of specifications which have been visited: "+
                r2.getField2()*100+"%");
        */
        System.out.println("\nSearching for "+request+" in repository "+repository+":");
        begin = Calendar.getInstance();
        time1 = begin.getTimeInMillis();
        Tuple<Set<String>,Double,Set<String>,Double> r3=
                searching.efficientSearch2LevelsOfAbstractionPost(request);
        end = Calendar.getInstance();
        time2 = end.getTimeInMillis();
        System.out.println("\nSearch time (in seconds): " + (time2 - time1) / 1000.0);
        System.out.println("Request: "+request);
        System.out.println("Found services: "+r3.getField1());
        System.out.println("Found remaining services: "+r3.getField3());
        System.out.println("Search space (percentage): "+r3.getField2()*100+"%");
        System.out.println("Remaining search space (percentage): "+r3.getField4()*100+"%");
    }
}
