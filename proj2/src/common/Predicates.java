package common;

import java.util.function.Predicate;

// Purpose: experimentation.
//    Predicates for generating random specifications repositories.
public class Predicates {

    //No restriction is required.
    public static Predicate<RepositoryStatistics>noRestriction(){
        Predicate<RepositoryStatistics> p = (stats)-> true;
        return p;
    }
    // Number of strong sets required for a repository. We only consider the information space of its
    // specifications. This number belongs to interval [left,right]
    public static Predicate<RepositoryStatistics>numberInformationSpaceStrongSets(int left,
                                                                                  int right){
        Predicate<RepositoryStatistics> p = (stats)->
                stats.numberInformationSpaceStrongSets()>=left &&
                        stats.numberInformationSpaceStrongSets()<=right;
        return p;
    }

    // Number of weak sets required for a repository. We only consider the information space of its
    // specifications. This number belongs to interval [left,right]
    public static Predicate<RepositoryStatistics>numberInformationSpaceWeakSets(int left,
                                                                                int right){
        Predicate<RepositoryStatistics> p = (stats)->
                stats.numberInformationSpaceWeakSets()>=left &&
                        stats.numberInformationSpaceWeakSets()<=right;
        return p;
    }

    // Number of strong sets required for a repository. We only consider the state space of its
    // specifications. This number belongs to interval [left,right]
    public static Predicate<RepositoryStatistics>numberStateSpaceStrongSets(int left,
                                                                            int right){
        Predicate<RepositoryStatistics> p = (stats)->
                stats.numberStateSpaceStrongSets()>=left &&
                        stats.numberStateSpaceStrongSets()<=right;
        return p;
    }

    // Number of weak sets required for a repository. We only consider the state space of its
    // specifications. This number belongs to interval [left,right]
    public static Predicate<RepositoryStatistics>numberStateSpaceWeakSets(int left,
                                                                          int right){
        Predicate<RepositoryStatistics> p = (stats)->
                stats.numberStateSpaceWeakSets()>=left &&
                        stats.numberStateSpaceWeakSets()<=right;
        return p;
    }

    // Mean size of strong sets required for a repository. We only consider the information space of its
    // specifications. Threshold parameter represents the minimum mean size which is required.
    public static Predicate<RepositoryStatistics>meanSizeInformationSpaceStrongSets(double threshold){
        Predicate<RepositoryStatistics> p = (stats)->
                stats.meanSizeInformationSpaceStrongSets()>threshold;
        return p;
    }
    // Mean size of strong sets required for a repository. We only consider the information space of its
    // specifications. Threshold parameter represents the maximum mean size which is required.
    public static Predicate<RepositoryStatistics>meanSizeInformationSpaceStrongSetsMax(double threshold){
        Predicate<RepositoryStatistics> p = (stats)->
                stats.meanSizeInformationSpaceStrongSets()<=threshold;
        return p;
    }

    // Mean size of weak sets required for a repository. We only consider the information space of its
    // specifications. Threshold parameter represents the minimum mean size which is required.
    public static Predicate<RepositoryStatistics>meanSizeInformationSpaceWeakSets(double threshold){
        Predicate<RepositoryStatistics> p = (stats)->
                stats.meanSizeInformationSpaceWeakSets()>threshold;
        return p;
    }

    // Mean size of weak sets required for a repository. We only consider the information space of its
    // specifications. Threshold parameter represents the maximum mean size which is required.
    public static Predicate<RepositoryStatistics>meanSizeInformationSpaceWeakSetsMax(double threshold){
        Predicate<RepositoryStatistics> p = (stats)->
                stats.meanSizeInformationSpaceWeakSets()<=threshold;
        return p;
    }

    // Mean size of strong sets required for a repository. We only consider the state space of its
    // specifications. Threshold parameter represents the minimum mean size which is required.
    public static Predicate<RepositoryStatistics>meanSizeStateSpaceStrongSets(double threshold){
        Predicate<RepositoryStatistics> p = (stats)->
                stats.meanSizeStateSpaceStrongSets()>threshold;
        return p;
    }

    // Mean size of strong sets required for a repository. We only consider the state space of its
    // specifications. Threshold parameter represents the maximum mean size which is required.
    public static Predicate<RepositoryStatistics>meanSizeStateSpaceStrongSetsMax(double threshold){
        Predicate<RepositoryStatistics> p = (stats)->
                stats.meanSizeStateSpaceStrongSets()<=threshold;
        return p;
    }

    // Mean size of weak sets required for a repository. We only consider the state space of its
    // specifications. Threshold parameter represents the minimum mean size which is required.
    public static Predicate<RepositoryStatistics>meanSizeStateSpaceWeakSets(double threshold){
        Predicate<RepositoryStatistics> p = (stats)->
                stats.meanSizeStateSpaceWeakSets()>threshold;
        return p;
    }

    // Mean size of weak sets required for a repository. We only consider the state space of its
    // specifications. Threshold parameter represents the maximum mean size which is required.
    public static Predicate<RepositoryStatistics>meanSizeStateSpaceWeakSetsMax(double threshold){
        Predicate<RepositoryStatistics> p = (stats)->
                stats.meanSizeStateSpaceWeakSets()<=threshold;
        return p;
    }

    // Mean relative size of strong sets required for a repository. We only consider the information space of its
    // specifications. Threshold parameter represents the minimum mean size which is required.
    public static Predicate<RepositoryStatistics>meanRelativeSizeInformationSpaceStrongSets(double threshold){
       Predicate<RepositoryStatistics> p = (stats)->
               stats.meanRelativeSizeInformationSpaceStrongSets()>threshold;
       return p;
    }

    // Mean relative size of strong sets required for a repository. We only consider the information space of its
    // specifications. Threshold parameter represents the maximum mean size which is required.
    public static Predicate<RepositoryStatistics>meanRelativeSizeInformationSpaceStrongSetsMax(double threshold){
        Predicate<RepositoryStatistics> p = (stats)->
                stats.meanRelativeSizeInformationSpaceStrongSets()<=threshold;
        return p;
    }

    // Mean relative size of weak sets required for a repository. We only consider the information space of its
    // specifications. Threshold parameter represents the minimum mean size which is required.
    public static Predicate<RepositoryStatistics>meanRelativeSizeInformationSpaceWeakSets(double threshold){
        Predicate<RepositoryStatistics> p = (stats)->
                stats.meanRelativeSizeInformationSpaceWeakSets()>threshold;
        return p;
    }

    // Mean relative size of weak sets required for a repository. We only consider the information space of its
    // specifications. Threshold parameter represents the maximum mean size which is required.
    public static Predicate<RepositoryStatistics>meanRelativeSizeInformationSpaceWeakSetsMax(double threshold){
        Predicate<RepositoryStatistics> p = (stats)->
                stats.meanRelativeSizeInformationSpaceWeakSets()<=threshold;
        return p;
    }

    // Mean relative size of strong sets required for a repository. We only consider the state space of its
    // specifications. Threshold parameter represents the minimum mean size which is required.
    public static Predicate<RepositoryStatistics>meanRelativeSizeStateSpaceStrongSets(double threshold){
        Predicate<RepositoryStatistics> p = (stats)->
                stats.meanRelativeSizeStateSpaceStrongSets()>threshold;
        return p;
    }

    // Mean relative size of strong sets required for a repository. We only consider the state space of its
    // specifications. Threshold parameter represents the maximum mean size which is required.
    public static Predicate<RepositoryStatistics>meanRelativeSizeStateSpaceStrongSetsMax(double threshold){
        Predicate<RepositoryStatistics> p = (stats)->
                stats.meanRelativeSizeStateSpaceStrongSets()<=threshold;
        return p;
    }

    // Mean relative size of weak sets required for a repository. We only consider the state space of its
    // specifications. Threshold parameter represents the minimum mean size which is required.
    public static Predicate<RepositoryStatistics>meanRelativeSizeStateSpaceWeakSets(double threshold){
        Predicate<RepositoryStatistics> p = (stats)->
                stats.meanRelativeSizeStateSpaceWeakSets()>threshold;
        return p;
    }

    // Mean relative size of weak sets required for a repository. We only consider the state space of its
    // specifications. Threshold parameter represents the maximum mean size which is required.
    public static Predicate<RepositoryStatistics>meanRelativeSizeStateSpaceWeakSetsMax(double threshold){
        Predicate<RepositoryStatistics> p = (stats)->
                stats.meanRelativeSizeStateSpaceWeakSets()<=threshold;
        return p;
    }
}
