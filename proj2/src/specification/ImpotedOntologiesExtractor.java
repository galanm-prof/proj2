package specification;

import java.util.HashSet;
import java.util.Set;

public class ImpotedOntologiesExtractor extends
        SpecificationParserBaseVisitor<Object>{

    Set<String> ontologies=new HashSet<>();

    @Override
    public Object visitSpec(SpecificationParser.SpecContext ctx)  {
        visitVocabulary(ctx.vocabulary());
        return ontologies;
    }

    @Override
    public Object visitVocabulary(SpecificationParser.VocabularyContext ctx) {
        visitOntologies(ctx.ontologies());
        return null;
    }

    @Override
    public Object visitOntologies(SpecificationParser.OntologiesContext ctx) {
        if (ctx.getChildCount()==3){
            ontologies.add(ctx.ID().getText());
            visitOntologies(ctx.ontologies());
        }
        else ontologies.add(ctx.ID().getText());

        return null;
    }
}
