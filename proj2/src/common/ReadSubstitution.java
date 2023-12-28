package common;

import file.RepositoryHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
//Substitutions for calculating specificationi --> specificationj
public class ReadSubstitution {
    public static Set<Set<Substitution>> read(boolean inputParameters,String specificationName1,
                                   String specificationName2) throws IOException {
        Set<Set<Substitution>>substitutions = new HashSet<>();
        String substitutionsRepositoryRoot = "C://xampp//htdocs//substitutions//";
        String substitutionsRepository = null;
        if (inputParameters)
            substitutionsRepository = substitutionsRepositoryRoot+
                    "substitutionsI//"+
                    specificationName1.replace(".txt","")+"//"+
                    specificationName2.replace(".txt","")+"//";
        else
            substitutionsRepository = substitutionsRepositoryRoot+
                "substitutionsO//"+
                specificationName1.replace(".txt","")+"//"+
                specificationName2.replace(".txt","")+"//";

        RepositoryHandler rh = new RepositoryHandler(substitutionsRepository);
        Set<File> files=rh.get_files();
        long filesCounter =  files.stream().count();
        for(int i=0;i<filesCounter;i++) {
            Path filePath = Path.of(substitutionsRepository +"substitution"+i+".txt");
            Stream<String> substitutionLines = Files.lines(filePath);

            Set<Substitution>substitution = new HashSet<>();
            substitutionLines.forEach(line->{
                String[] fields = line.split(",");
                String parameter1 = fields[0];
                String type1 = fields[1];
                String parameter2 = fields[2];
                String type2 = fields[3];
                Substitution s = new Substitution(parameter1,type1,parameter2,type2);
                substitution.add(s);
            });
            substitutions.add(substitution);
        }

        return substitutions;
    }
}
