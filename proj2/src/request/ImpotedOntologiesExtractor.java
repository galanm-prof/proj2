package request;

import specification.SpecificationParser;
import specification.SpecificationParserBaseVisitor;

import java.util.HashSet;
import java.util.Set;

public class ImpotedOntologiesExtractor extends
        RequestParserBaseVisitor<Object> {

    Set<String> ontologies=new HashSet<>();

    @Override
    public Object visitReq(RequestParser.ReqContext ctx)  {
        visitVocabulary(ctx.vocabulary());
        return ontologies;
    }

    @Override
    public Object visitVocabulary(RequestParser.VocabularyContext ctx) {
        visitOntologies(ctx.ontologies());
        return null;
    }

    @Override
    public Object visitOntologies(RequestParser.OntologiesContext ctx) {
        if (ctx.getChildCount()==3){
            ontologies.add(ctx.ID().getText());
            visitOntologies(ctx.ontologies());
        }
        else ontologies.add(ctx.ID().getText());

        return null;
    }
}
