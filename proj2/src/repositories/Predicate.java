package repositories;

import common.RepositoryStatistics;

public class Predicate {
    private String text;
    java.util.function.Predicate<RepositoryStatistics> predicate;

    public Predicate(String text,java.util.function.Predicate<RepositoryStatistics> predicate){
        this.text=text;
        this.predicate=predicate;
    }

    public String getText() {
        return text;
    }

    public java.util.function.Predicate<RepositoryStatistics> getPredicate() {
        return predicate;
    }
}
