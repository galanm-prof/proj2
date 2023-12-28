package experiment;

import file.RepositoryHandler;
import repositories.Repositories;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SemanticAnalyserExperiment extends ParserExperimentBaseVisitor<List<String>>{

    private final String pathRequests="C://xampp//htdocs//requests//";
    private final int limit = 1000;
    private final int nSpecs = 159;
    private  int nRepositories = 1;
    private List<String> errors=new LinkedList<>();

    List<String>auxRequests=new LinkedList<>();
    @Override
    public List<String> visitExperiment(ParserExperiment.ExperimentContext ctx) {
        //experiment: repositories requests repository searching EOF;
        visitRepositories(ctx.repositories());
        visitRequests(ctx.requests());
        visitRepository(ctx.repository());
        return errors;
    }

    @Override
    public List<String> visitRepositories(ParserExperiment.RepositoriesContext ctx) {
        //repositories: REPOSITORIES COLON INT SEMICOLON ;
        if (Integer.valueOf(ctx.INT().getText())>limit)
            errors.add("The number of repositories exceeds its limit");
        else nRepositories=Integer.valueOf(ctx.INT().getText());
        return null;
    }

    @Override
    public List<String> visitRequests(ParserExperiment.RequestsContext ctx) {
        //requests: REQUESTS COLON reqs SEMICOLON ; //requests (1 o more)
        List<String>aux1=visitReqs(ctx.reqs());
        Set<String>aux2=aux1.stream().collect(Collectors.toSet());

        Set<String>requests=new HashSet<>();
        RepositoryHandler rh = new RepositoryHandler(pathRequests);
        for (File n : rh.get_files()) {
            requests.add(n.getName().replace(".txt",""));
        }
        aux2.removeAll(requests);
        if (aux2.size()>0)
            errors.add("Requests not defined: "+aux2);
        return null;
    }

    @Override
    public List<String> visitReqs(ParserExperiment.ReqsContext ctx) {
        //reqs: ID COMMA reqs
        //    | ID
        //    ;
        if (ctx.getChildCount()==3){
            if (!auxRequests.contains(ctx.ID().getText()))
                auxRequests.add(ctx.ID().getText());
            else errors.add("request "+ctx.ID().getText()+" has been redeclared");
            auxRequests.addAll(visitReqs(ctx.reqs()));
        }
        else
        if (!auxRequests.contains(ctx.ID().getText()))
            auxRequests.add(ctx.ID().getText());
        else errors.add("request "+ctx.ID().getText()+" has been redeclared");
        return auxRequests;
    }

    @Override
    public List<String> visitRepository(ParserExperiment.RepositoryContext ctx) {
        //repository: REPOSITORY COLON INT COMMA predicate SEMICOLON ;
        int nSpecsPerRepository=Integer.valueOf(ctx.INT().getText());
        if (nSpecsPerRepository>nSpecs)
            errors.add("number of specifications per repository "+
                    nSpecsPerRepository+" exceeds its limit "+nSpecs);
        if (nSpecsPerRepository<=nSpecs){
            try {
                Set<Integer>s1=Repositories.selectionOfRepositories(nSpecsPerRepository);
                //System.out.println(s1);
                Set<Integer>s2=Repositories.selectionOfRepositories(ctx.predicate().getText());
                //System.out.println(ctx.predicate().getText()+" "+s2);
                s1.retainAll(s2);
                if (s1.size()<nRepositories
                    && !Repositories.hypotheticalGenerationOfRepositories(nRepositories-s1.size(),
                        nSpecsPerRepository,ctx.predicate().getText()))
                        errors.add("Insufficient number of found repositories " +
                            s1.size() + ": " + nRepositories + " are required");

            } catch (IOException e) { throw new RuntimeException(e); }

        }
        return null;
    }
}
