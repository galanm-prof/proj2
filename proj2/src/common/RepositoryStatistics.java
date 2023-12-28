package common;

public record RepositoryStatistics (Integer repositorySize,
    Integer numberInformationSpaceStrongSets, Integer numberInformationSpaceWeakSets,
    Integer numberStateSpaceStrongSets,Integer numberStateSpaceWeakSets,
    Double meanSizeInformationSpaceStrongSets, Double meanSizeInformationSpaceWeakSets,
    Double meanSizeStateSpaceStrongSets, Double meanSizeStateSpaceWeakSets,
    Double meanRelativeSizeInformationSpaceStrongSets,
    Double meanRelativeSizeInformationSpaceWeakSets, Double meanRelativeSizeStateSpaceStrongSets,
    Double meanRelativeSizeStateSpaceWeakSets) {

}


