package experiment;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CompileExperimentPost extends ParserExperimentBaseVisitor<String>{
    private FileWriter f=null;
    private String path="./src/experimentsPost/";
    private String className=null;
    private int nRepositories;
    private Set<String> requests;
    private int repositorySize;
    private String predicate;
    private String typeOfSearch;

    private int blanks; // A blank counter for pretty writing

    public void increase_blanks(int amount){
        blanks+=amount;
    }

    public void decrease_blanks(int amount){
        blanks-=amount;
    }

    public void write_blanks(){
        try{
            for(int i=0;i<=blanks;i++)
                f.write(" ");
        }catch(IOException e){}
    }

    // Method for writing in the output file
    public void write(String s){
        try{
            write_blanks();
            f.write(s);
        }catch(IOException e){}
    }

    //Initialisation of the compiler
    public void init(String name) throws IOException {
        this.className=name;
        f=new FileWriter(path+className+".java");
        requests=new HashSet<>();
        blanks=0;
    }

    @Override
    public String visitExperiment(ParserExperiment.ExperimentContext ctx) {
        //experiment: repositories requests repository searching EOF;
        codeGenerationImports();
        codeGenerationClassDeclaration();
        visitRepositories(ctx.repositories());
        String code=visitRequests(ctx.requests());
        visitRepository(ctx.repository());
        visitSearching(ctx.searching());
        codeGenerationFields();
        try {
            f.write(code);
        } catch (IOException e) {  throw new RuntimeException(e);   }
        codeGenerationGenerateRepositories();
        codeGenerationSelectionOfRepositories();
        codeGenerationSearch();
        codeGenerationExperiment();
        codeGenerationMain();
        decrease_blanks(4);
        write_blanks();
        try {
            f.write("}\n");
            f.close();
        } catch (IOException e) {  throw new RuntimeException(e);  }
        return null;
    }

    @Override
    public String visitRepositories(ParserExperiment.RepositoriesContext ctx) {
        //repositories: REPOSITORIES COLON INT SEMICOLON ;
        nRepositories=Integer.valueOf(ctx.INT().getText());
        return null;
    }

    @Override
    public String visitRequests(ParserExperiment.RequestsContext ctx) {
        //requests: REQUESTS COLON reqs SEMICOLON ; //requests (1 o more)
        String code="    private static void initRequests(){\n"+
                    "        requests=new HashSet<>();\n"+
                             visitReqs(ctx.reqs())+
                    "    }\n";

        return code;
    }

    @Override
    public String visitReqs(ParserExperiment.ReqsContext ctx) {
        //reqs: ID COMMA reqs
        //    | ID
        //    ;
        String code=null;
        if (ctx.getChildCount()==3)
            code="        requests.add(\""+ctx.ID().getText()+"\");\n"+visitReqs(ctx.reqs());
        else
            code="        requests.add(\""+ctx.ID().getText()+"\");\n";

        return code;
    }

    @Override
    public String visitRepository(ParserExperiment.RepositoryContext ctx) {
        //repository: REPOSITORY COLON INT COMMA predicate SEMICOLON ;
        repositorySize=Integer.valueOf(ctx.INT().getText());
        predicate=visitPredicate(ctx.predicate());
        return null;
    }

    @Override
    public String visitSearching(ParserExperiment.SearchingContext ctx) {
        //searching: SEARCHING COLON
        //       (INEFFICIENT | EFFICIENTLEVEL1 | EFFICIENTLEVEL2) SEMICOLON ;
        typeOfSearch=ctx.getChild(2).getText();
        return null;
    }

    @Override
    public String visitPredicate(ParserExperiment.PredicateContext ctx) {
        //predicate : expression ;
        return visitExpression(ctx.expression());
    }

    @Override
    public String visitExpression(ParserExperiment.ExpressionContext ctx) {
        //expression: expression AND expression
        //   |  expression OR expression
        //   |  NEG expression
        //   |  OP expression CP
        //   |  primitive_predicate
        //   ;
        if (ctx.getChildCount()==3){
            if (ctx.getChild(0).getText().equals("("))
                return ctx.getText();
            else return visitExpression(ctx.expression(0))+
                    " "+ctx.getChild(1).getText()+" "+
                    visitExpression(ctx.expression(1));
        }
        else{
            if (ctx.getChildCount()==2)
                return ctx.getChild(0).getText()+" "+
                        visitExpression(ctx.expression(0));
            else return ctx.getText();
        }
    }


    //CODE GENERATION METHODS
    private void codeGenerationImports()  {
        String code = "package experimentsPost;\n"+
                "import common.Tuple;\n" +
                "import common.Tuple2;\n" +
                "import org.semanticweb.owlapi.model.OWLOntologyCreationException;\n" +
                "import repositories.Repositories;\n" +
                "import search.RepositorySearch;\n" +
                "\n" +
                "import java.io.FileWriter;\n"+
                "import java.io.IOException;\n" +
                "import java.util.Calendar;\n" +
                "import java.util.HashSet;\n" +
                "import java.util.Set;\n";
        try {
            f.write(code);
        } catch (IOException e) {  throw new RuntimeException(e);  }
    }
    private void codeGenerationClassDeclaration(){
        String code = "public class "+className+"{\n";
        try {
            f.write(code);
        } catch (IOException e) {  throw new RuntimeException(e);  }
    }

    private void codeGenerationFields(){
        try{
            increase_blanks(4);
            write_blanks();
            f.write("private static int nRepositories="+nRepositories+";\n");
            write_blanks();
            f.write("private static int repositorySize="+repositorySize+";\n");
            write_blanks();
            f.write("private static String predicate=\""+predicate+"\";\n");
            write_blanks();
            f.write("private static Set<String>requests;\n");
            write_blanks();
            f.write("private static long time1,time2;\n");
            write_blanks();
            f.write("private static double meanSearchSpaceAcc;\n");
            write_blanks();
            f.write("private static double coefficientVariationAcc;\n");
            write_blanks();
            f.write("private static double meanSearchSpaceRemainingDiscoveryAcc;\n");
            write_blanks();
            f.write("private static double meanSpecificationsPercentageRemainingDiscoveryAcc;\n");
            write_blanks();
            f.write("private static boolean repositoriesGenerationIsOK=true;\n");
        } catch (IOException e) {  throw new RuntimeException(e);  }
    }

    private void codeGenerationGenerateRepositories(){
        try{
            write_blanks();
            f.write("private static boolean generateRepositories() throws IOException {\n");
            increase_blanks(4);
            write_blanks();
            f.write("Set<Integer> s1=Repositories.selectionOfRepositories(repositorySize);\n");
            write_blanks();
            f.write("Set<Integer> s2=Repositories.selectionOfRepositories(predicate);\n");
            write_blanks();
            f.write("s1.retainAll(s2);\n");
            write_blanks();
            f.write("if (s1.size()<nRepositories)\n");
            increase_blanks(4);
            write_blanks();
            f.write("repositoriesGenerationIsOK=Repositories.conditionalGenerationOfRepositories(nRepositories-s1.size(),repositorySize,predicate);\n");
            decrease_blanks(4);
            write_blanks();
            f.write("return repositoriesGenerationIsOK;\n");
            decrease_blanks(4);
            write_blanks();
            f.write("}\n");
        } catch (IOException e) {  throw new RuntimeException(e);  }
    }

    private void codeGenerationSelectionOfRepositories(){
        try{
            write_blanks();
            f.write("private static Tuple2<Boolean,Set<String>> selectionOfRepositories() throws IOException {\n");
            increase_blanks(4);
            write_blanks();
            f.write("Boolean b=false;\n");
            write_blanks();
            f.write("Set<String> s=new HashSet<>();\n");
            write_blanks();
            f.write("Tuple2<Boolean,Set<String>> tuple=null;\n");
            write_blanks();
            f.write("Set<Integer> s1=Repositories.selectionOfRepositories(repositorySize);\n");
            write_blanks();
            f.write("Set<Integer> s2=Repositories.selectionOfRepositories(predicate);\n");
            write_blanks();
            f.write("s1.retainAll(s2);\n");
            write_blanks();
            f.write("if (s1.size()<nRepositories)\n");
            increase_blanks(4);
            write_blanks();
            f.write("tuple=new Tuple2(b,s);\n");
            decrease_blanks(4);
            write_blanks();
            f.write("else{\n");
            increase_blanks(4);
            write_blanks();
            f.write("int cont=0;\n");
            write_blanks();
            f.write("for(Integer r:s1) {\n");
            increase_blanks(4);
            write_blanks();
            f.write("if (cont==nRepositories) break;\n");
            write_blanks();
            f.write("else{\n");
            increase_blanks(4);
            write_blanks();
            f.write("s.add(r.toString());\n");
            write_blanks();
            f.write("cont++;\n");
            decrease_blanks(4);
            write_blanks();
            f.write("}\n");
            decrease_blanks(4);
            write_blanks();
            f.write("}\n");
            write_blanks();
            f.write("b=true;\n");
            write_blanks();
            f.write("tuple=new Tuple2(b,s);\n");
            decrease_blanks(4);
            write_blanks();
            f.write("}\n");
            write_blanks();
            f.write("return tuple;\n");
            decrease_blanks(4);
            write_blanks();
            f.write("}\n");
        } catch (IOException e) {  throw new RuntimeException(e);  }
    }

    private void codeGenerationSearch(){
        try{
            write_blanks();
            f.write("private static void search(Set<String>repositories) throws IOException, OWLOntologyCreationException {\n");
            increase_blanks(4);
            write_blanks();
            f.write("meanSearchSpaceAcc=0.0;\n");
            write_blanks();
            f.write("coefficientVariationAcc=0.0;\n");
            write_blanks();
            f.write("meanSpecificationsPercentageRemainingDiscoveryAcc=0.0;\n");
            write_blanks();
            f.write("Calendar begin = Calendar.getInstance();\n");
            write_blanks();
            f.write("time1 = begin.getTimeInMillis();\n");
            write_blanks();
            f.write("for(String repository:repositories){\n");
            increase_blanks(4);
            write_blanks();
            f.write("System.out.println(\"\\nRepository: \"+repository);\n");
            write_blanks();
            f.write("System.out.println(\"---------------\");\n");
            write_blanks();
            f.write("double searchSpacePerRepository=0.0;\n");
            write_blanks();
            f.write("double searchSpaceRemainingDiscoveryPerRepository=0.0;\n");
            write_blanks();
            f.write("double specificationsPercentageRemainingDiscoveryPerRepository=0.0;\n");
            write_blanks();
            f.write("double variancePerRepository=0.0;\n");
            write_blanks();
            f.write("RepositorySearch searching = new RepositorySearch(repository);\n");
            write_blanks();
            f.write("for(String request:requests){\n");
            increase_blanks(4);
            if (typeOfSearch.equals("inefficient")) {
                write_blanks();
                f.write("Tuple<Set<String>,Double,Set<String>,Double> r1=searching.inefficientSearchPost(request);\n");
            }
            else if (typeOfSearch.equals("efficient-1-level")) {
                write_blanks();
                f.write("Tuple<Set<String>,Double,Set<String>,Double> r1=searching.efficientSearch1LevelOfAbstractionPost(request);\n");
            }
            else{
                write_blanks();
                f.write("Tuple<Set<String>,Double,Set<String>,Double> r1=searching.efficientSearch2LevelsOfAbstractionPost(request);\n");
            }
            write_blanks();
            f.write("System.out.println(\"Request: \"+request);\n");
            write_blanks();
            f.write("System.out.println(\"Found services (Direct Discovery): \"+r1.getField1());\n");
            write_blanks();
            f.write("System.out.println(\"Found services (Remaining Discovery): \"+r1.getField3());\n");
            write_blanks();
            f.write("System.out.println(\"Search space (percentage): \"+r1.getField2()*100+\"%\");\n");
            write_blanks();
            f.write("System.out.println(\"Search space (Remaining Discovery) (percentage): \"+r1.getField4()*100+\"%\");\n");
            write_blanks();
            f.write("searchSpacePerRepository+=r1.getField2()*100;\n");
            write_blanks();
            f.write("variancePerRepository+=r1.getField2()*100*r1.getField2()*100;\n");
            write_blanks();
            f.write("searchSpaceRemainingDiscoveryPerRepository+=r1.getField4()*100;\n");
            write_blanks();
            f.write("if (r1.getField1().size()>0) \n");
            increase_blanks(4);
            write_blanks();
            f.write("specificationsPercentageRemainingDiscoveryPerRepository+=\n" +
                    "                         (r1.getField3().size()/r1.getField1().size())*100;\n");
            decrease_blanks(4);
            decrease_blanks(4);
            write_blanks();
            f.write("}\n");
            write_blanks();
            f.write("double meanSearchSpacePerRepository=searchSpacePerRepository/requests.size();\n");
            write_blanks();
            f.write("double meanVariancePerRepository=(variancePerRepository/requests.size())-(meanSearchSpacePerRepository*meanSearchSpacePerRepository);\n");
            write_blanks();
            f.write("double coefficientVariationPerRepository=(Math.sqrt(Math.abs(meanVariancePerRepository))/Math.abs(meanSearchSpacePerRepository))*100;\n");
            write_blanks();
            f.write("double meanSearchSpaceRemainingDiscoveryPerRepository=searchSpaceRemainingDiscoveryPerRepository/requests.size();\n");
            write_blanks();
            f.write("double meanSpecificationsPercentageRemainingDiscoveryPerRepository=specificationsPercentageRemainingDiscoveryPerRepository/requests.size();\n");
            write_blanks();
            f.write("System.out.println(\"Mean search space (percentage) in repository \"+repository+\":  \"+meanSearchSpacePerRepository+\"%\");\n");
            write_blanks();
            f.write("System.out.println(\"Coefficient of variation (percentage) in repository \"+repository+\":  \"+coefficientVariationPerRepository+\"%\");\n");
            write_blanks();
            f.write("System.out.println(\"Mean search space (Remaining discovery) (percentage) in repository \"+repository+\":  \"+meanSearchSpaceRemainingDiscoveryPerRepository+\"%\");\n");
            write_blanks();
            f.write("System.out.println(\"Mean proportion of specifications found at the remaining discovery stage (percentage) in repository \"+repository+\":  \"+meanSpecificationsPercentageRemainingDiscoveryPerRepository+\"%\");\n");
            write_blanks();
            f.write("meanSearchSpaceAcc+=meanSearchSpacePerRepository;\n");
            write_blanks();
            f.write("coefficientVariationAcc+=coefficientVariationPerRepository;\n");
            write_blanks();
            f.write("meanSearchSpaceRemainingDiscoveryAcc+=meanSearchSpaceRemainingDiscoveryPerRepository;\n");
            write_blanks();
            f.write("meanSpecificationsPercentageRemainingDiscoveryAcc+=meanSpecificationsPercentageRemainingDiscoveryPerRepository;\n");
            decrease_blanks(4);
            write_blanks();
            f.write("}\n");
            write_blanks();
            f.write("Calendar end = Calendar.getInstance();\n");
            write_blanks();
            f.write("time2 = end.getTimeInMillis();\n");
            write_blanks();
            f.write("System.out.println(\"\\nMean search time (in seconds): \" + ((time2 - time1) / 1000.0)/nRepositories);\n");
            write_blanks();
            f.write("System.out.println(\"Mean search space (percentage) : \"+(meanSearchSpaceAcc/nRepositories)+\"%\");\n");
            write_blanks();
            f.write("System.out.println(\"Mean coefficient of variation (percentage) : \"+(coefficientVariationAcc/nRepositories)+\"%\");\n");
            write_blanks();
            f.write("System.out.println(\"Mean search space at the remaining discovery stage (percentage) : \"+(meanSearchSpaceRemainingDiscoveryAcc/nRepositories)+\"%\");\n");
            write_blanks();
            f.write("System.out.println(\"Mean proportion of specifications found at the remaining discovery stage (percentage) : \"+(meanSpecificationsPercentageRemainingDiscoveryAcc/nRepositories)+\"%\");\n");
            write_blanks();
            f.write("FileWriter g = new FileWriter(\"./src/experimentsPost/"+className+".out\");\n");
            write_blanks();
            f.write("g.write(\"mean search time (in sec): \"+((time2 - time1) / 1000.0)/nRepositories+\"\\n\");\n");
            write_blanks();
            f.write("g.write(\"mean search space (percentage): \"+(meanSearchSpaceAcc/nRepositories)+\"\\n\");\n");
            write_blanks();
            f.write("g.write(\"coefficient of variation (percentage): \"+(coefficientVariationAcc/nRepositories)+\"\\n\");\n");
            write_blanks();
            f.write("g.write(\"mean search space at the remaining discovery stage (percentage): \"+(meanSearchSpaceRemainingDiscoveryAcc/nRepositories)+\"\\n\");\n");
            write_blanks();
            f.write("g.write(\"mean proportion of specifications found at the remaining discovery stage (percentage): \"+(meanSpecificationsPercentageRemainingDiscoveryAcc/nRepositories)+\"\\n\");\n");
            write_blanks();
            f.write("g.close();\n");
            decrease_blanks(4);
            write_blanks();
            f.write("}\n");
        } catch (IOException e) {  throw new RuntimeException(e);  }
    }

    private void codeGenerationExperiment(){
        try{
            write_blanks();
            f.write("private static boolean experiment() throws IOException, OWLOntologyCreationException {\n");
            increase_blanks(4);
            write_blanks();
            f.write("boolean r = false;\n");
            write_blanks();
            f.write("Tuple2<Boolean,Set<String>> tuple="+className+".selectionOfRepositories();\n");
            write_blanks();
            f.write("if (!tuple.getField1()) {\n");
            increase_blanks(4);
            write_blanks();
            f.write("System.out.println(\"Before generating repositories: \"+tuple.getField2().size()+\"/\"+nRepositories);\n");
            write_blanks();
            f.write("boolean b="+className+".generateRepositories();\n");
            write_blanks();
            f.write("System.out.println(\"Generation of repositories: \"+b);\n");
            decrease_blanks(4);
            write_blanks();
            f.write("}\n");
            write_blanks();
            f.write("initRequests();\n");
            write_blanks();
            f.write("tuple = "+className+".selectionOfRepositories();\n");
            write_blanks();
            f.write("r = tuple.getField1();\n");
            write_blanks();
            f.write("if (r)\n");
            increase_blanks(4);
            write_blanks();
            f.write(className+".search(tuple.getField2());\n");
            decrease_blanks(4);
            write_blanks();
            f.write("return r;\n");
            decrease_blanks(4);
            write_blanks();
            f.write("}\n");
        } catch (IOException e) {  throw new RuntimeException(e);  }
    }

    private void codeGenerationMain(){
        try{
            write_blanks();
            f.write("public static void main(String[]args){\n");
            increase_blanks(4);
            write_blanks();
            f.write("try {\n");
            increase_blanks(4);
            write_blanks();
            f.write("boolean r="+className+".experiment();\n");
            write_blanks();
            f.write("System.out.println(\"Experiment done?: \"+r);\n");
            decrease_blanks(4);
            write_blanks();
            f.write("} catch (IOException e) { throw new RuntimeException(e); } catch (OWLOntologyCreationException e) {  throw new RuntimeException(e); }\n");
            decrease_blanks(4);
            write_blanks();
            f.write("}\n");
        } catch (IOException e) {  throw new RuntimeException(e);  }
    }
}
