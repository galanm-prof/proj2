package test;

import common.Predicates;
import common.RepositoryStatistics;
import repositories.Repositories;

import java.io.IOException;
import java.util.Set;
import java.util.function.Predicate;

public class TestRepositories {
    public static void main(String[]args) throws IOException {
        /*
        Predicate<RepositoryStatistics>p1=
                Predicates.meanRelativeSizeInformationSpaceStrongSets(0.04);
        Predicate<RepositoryStatistics>p2=
                Predicates.meanRelativeSizeInformationSpaceWeakSets(0.04);
        Predicate<RepositoryStatistics>p3=
                Predicates.numberInformationSpaceStrongSets(10,30);

        Repositories.conditionalGenerationOfRepositories(5,80,p1.and(p2));
        Set<Integer>repositoriesIndexes = Repositories.selectionOfRepositories(p1.and(p2));
        String pred = "meanRelativeSizeInformationSpaceStrongSets(0.04) and  meanRelativeSizeInformationSpaceWeakSets(0.04)";
        Repositories.conditionalGenerationOfRepositories(5,80,pred);
        Set<Integer>repositoriesIndexes = Repositories.selectionOfRepositories(pred);
        System.out.println(repositoriesIndexes);
         */

        /*
        Set<Integer>repositoriesIndexes = Repositories.selectionOfRepositories(p1.and(p2));
        System.out.println(repositoriesIndexes);
        String pred="meanRelativeSizeInformationSpaceStrongSets(0.05) and " +
                    "meanRelativeSizeInformationSpaceWeakSets(0.05)";
        repositoriesIndexes = Repositories.selectionOfRepositories(pred);
        System.out.println(repositoriesIndexes);
         */

        int index = 232;
        RepositoryStatistics stats= Repositories.repositoryStatistics(index);
        System.out.println("Statistics of repository "+index);
        System.out.println("   "+stats);

        /*
        String pred = "meanRelativeSizeInformationSpaceStrongSets(0.04) and" +
                "       meanRelativeSizeInformationSpaceWeakSets(0.0425)";
        boolean r=Repositories.hypotheticalGenerationOfRepositories(20,80,pred);
        System.out.println(r);
         */
    }
}
