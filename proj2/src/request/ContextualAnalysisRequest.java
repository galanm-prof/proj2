package request;

import common.ContextualError;
import common.Entities;
import common.OntologyHandler;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Pair;
import org.semanticweb.owlapi.model.*;
import specification.SpecificationParser;
import specification.SpecificationParserBaseVisitor;

import java.util.*;

public class ContextualAnalysisRequest extends
        RequestParserBaseVisitor<Pair<Entities,List<ContextualError>>> {
    OntologyHandler manager = new OntologyHandler();
    Entities entities=new Entities();
    List<ContextualError> errors = new LinkedList<>();
    Map<String,IRI>ontologies=new HashMap<>();
    String requestName=null;
    String ontologyPath="http://127.0.0.1/ontology/";
    String requestPath="http://127.0.0.1/requests/";
    public void init(String name){
        requestName=name;
    }

    @Override
    public Pair<Entities,List<ContextualError>> visitReq(RequestParser.ReqContext ctx)  {
        visitVocabulary(ctx.vocabulary());
        visitInputs(ctx.inputs());
        visitOutputs(ctx.outputs());
        visitPairs_of_states(ctx.pairs_of_states());
        return new Pair<Entities,List<ContextualError>>(this.entities,this.errors);
    }

    @Override
    public Pair<Entities,List<ContextualError>> visitVocabulary(RequestParser.VocabularyContext ctx) {
        visitOntologies(ctx.ontologies());
        for(OWLOntology ont:manager.getLoadedOntologies()){
            Set<OWLClass>c=ont.getClassesInSignature(true);
            c.stream().forEach(cls->entities.addClass(cls.getIRI().getFragment(),cls.getIRI()));
            Set<OWLObjectProperty>p=ont.getObjectPropertiesInSignature(true);
            p.stream().forEach(pro->entities.addObjectProperty(pro.getIRI().getFragment(),pro.getIRI()));
            Set<OWLNamedIndividual>i=ont.getIndividualsInSignature(true);
            i.stream().forEach(ind->entities.addIndividual(ind.getIRI().getFragment(),ind.getIRI()));
            Set<OWLDatatype>d=ont.getDatatypesInSignature(true);
            d.stream().forEach(dtp->entities.addDatatypeProperty(dtp.getIRI().getFragment(),dtp.getIRI()));
        }

        return null;
    }

    @Override
    public Pair<Entities,List<ContextualError>> visitOntologies(RequestParser.OntologiesContext ctx) {
        IRI ontologyIRI =
                IRI.create(ontologyPath+ctx.ID().getText()+".owl");
        ontologies.put(ctx.ID().getText(),ontologyIRI);
        manager.loadOntology(ontologyIRI);
        if (ctx.getChildCount()==3)
            visitOntologies(ctx.ontologies());
        return null;
    }

    @Override
    public Pair<Entities,List<ContextualError>> visitInputs(RequestParser.InputsContext ctx) {
        if (ctx.getChildCount()==3)
            visitIparams(ctx.iparams());
        return null;
    }

    @Override
    public Pair<Entities,List<ContextualError>> visitIparams(RequestParser.IparamsContext ctx) {
        visitIparam(ctx.iparam());
        if (ctx.getChildCount()==3)
            visitIparams(ctx.iparams());
        return null;
    }

    @Override
    public Pair<Entities,List<ContextualError>> visitIparam(RequestParser.IparamContext ctx) {
        String ont = ctx.type().getChild(0).getText();
        String cls = ctx.type().getChild(2).getText();
        if (!this.ontologies.containsKey(ont)) {
            Token tk = ctx.type().ID(0).getSymbol();
            ContextualError error =
                    new ContextualError(tk.getLine(),
                            tk.getText() + " is not defined as ontology ");
            errors.add(error);
        }
        if (!this.entities.containsClass(cls)) {
            Token tk = ctx.type().ID(1).getSymbol();
            ContextualError error =
                    new ContextualError(tk.getLine(),
                            tk.getText() + " is not defined as class ");
            errors.add(error);
        }
        if (this.entities.containsIndividual(ctx.ID().getText())){
            Token tk = ctx.ID().getSymbol();
            ContextualError error =
                    new ContextualError(tk.getLine(),
                            tk.getText() + " has been redeclared as input parameter ");
            errors.add(error);
        }
        else {
            //IRI iparamIRI=IRI.create(specificationPath+specificationName.replace(".txt","")
            //        +"/I.owl#"+ctx.ID().getText());
            IRI iparamIRI=IRI.create("http://127.0.0.1/parameter/"+ctx.ID().getText());
            this.entities.addIndividual(ctx.ID().getText(), iparamIRI);
        }

        return null;
    }

    @Override
    public Pair<Entities,List<ContextualError>> visitOutputs(RequestParser.OutputsContext ctx) {
        if (ctx.getChildCount()==3)
            visitOparams(ctx.oparams());
        return null;
    }

    @Override
    public Pair<Entities,List<ContextualError>> visitOparams(RequestParser.OparamsContext ctx) {
        visitOparam(ctx.oparam());
        if (ctx.getChildCount()==3)
            visitOparams(ctx.oparams());
        return null;
    }

    @Override
    public Pair<Entities,List<ContextualError>> visitOparam(RequestParser.OparamContext ctx) {
        String ont = ctx.type().getChild(0).getText();
        String cls = ctx.type().getChild(2).getText();
        if (!this.ontologies.containsKey(ont)) {
            Token tk = ctx.type().ID(0).getSymbol();
            ContextualError error =
                    new ContextualError(tk.getLine(),
                            tk.getText() + " is not defined as ontology ");
            errors.add(error);
        }
        if (!this.entities.containsClass(cls)) {
            Token tk = ctx.type().ID(1).getSymbol();
            ContextualError error =
                    new ContextualError(tk.getLine(),
                            tk.getText() + " is not defined as class ");
            errors.add(error);
        }
        if (this.entities.containsIndividual(ctx.ID().getText())){
            Token tk = ctx.ID().getSymbol();
            ContextualError error =
                    new ContextualError(tk.getLine(),
                            tk.getText() + " has been redeclared as output parameter ");
            errors.add(error);
        }
        else {
            //IRI oparamIRI=IRI.create(specificationPath+specificationName.replace(".txt","")+
            //        "/O.owl#"+ctx.ID().getText());
            IRI oparamIRI=IRI.create("http://127.0.0.1/parameter/"+ctx.ID().getText());
            this.entities.addIndividual(ctx.ID().getText(), oparamIRI);
        }

        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitPairs_of_states(RequestParser.Pairs_of_statesContext ctx) {
        for(int i=0;i<ctx.getChildCount();i++)
            visit(ctx.pair_of_states(i));
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitPair_of_states(RequestParser.Pair_of_statesContext ctx) {
        visit(ctx.precondition());
        visit(ctx.effect());
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitPrecondition(RequestParser.PreconditionContext ctx) {
        visit(ctx.sentences());
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitEffect(RequestParser.EffectContext ctx) {
        visit(ctx.sentences());
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitSentences(RequestParser.SentencesContext ctx) {
        switch(ctx.getChildCount()){
            case 0: break;
            case 1: visit(ctx.sentence()); break;
            case 3: visit(ctx.sentence());  visit(ctx.sentences()); break;
        }
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitSentence(RequestParser.SentenceContext ctx) {
        switch(ctx.getChildCount()){
            case 2: visit(ctx.set(0));
                    break;
            case 3:
                if (ctx.BELONGS()!=null){
                   if (!this.entities.containsIndividual(ctx.ID().getText())){
                       Token tk = ctx.ID().getSymbol();
                       ContextualError error =
                               new ContextualError(tk.getLine(),
                                       tk.getText() + " has not been declared ");
                       errors.add(error);
                   }
                   visit(ctx.set(0));
                }
                else{
                   visit(ctx.set(0));
                   visit(ctx.set(1));
                }
                break;
        }
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitSet(RequestParser.SetContext ctx) {
        visit(ctx.set_and());
        if (ctx.getChildCount()==3){
            visit(ctx.set());
        }
        return null;
    }
    @Override
    public Pair<Entities, List<ContextualError>> visitSet_and(RequestParser.Set_andContext ctx) {
        visit(ctx.set_base());
        if (ctx.getChildCount()==3){
            visit(ctx.set_and());
        }
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitSet_base(RequestParser.Set_baseContext ctx) {
        if (ctx.getChildCount()==3)
            visit(ctx.set());
        else
            if (ctx.anonymous_set()!=null) visit(ctx.anonymous_set());
            else if (ctx.property_set()!=null) visit(ctx.property_set());
            else if (ctx.inv_property_set()!=null) visit(ctx.inv_property_set());
            else if (ctx.class_set()!=null) visit(ctx.class_set());
            else visit(ctx.neg_set());
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitProperty_set(RequestParser.Property_setContext ctx) {
        if (!this.entities.containsObjectProperty(ctx.ID(0).getText())) {
            Token tk = ctx.ID(0).getSymbol();
            ContextualError error =
                    new ContextualError(tk.getLine(),
                            tk.getText() + " has not been declared ");
            errors.add(error);
        }
        if (ctx.SOME() != null || ctx.ONLY() != null)
                visit(ctx.set());
        else
            if (ctx.VALUE()!=null && ctx.ID(1)!=null){
                if (!this.entities.containsIndividual(ctx.ID(1).getText())) {
                    Token tk = ctx.ID(1).getSymbol();
                    ContextualError error =
                        new ContextualError(tk.getLine(),
                                tk.getText() + " has not been declared ");
                    errors.add(error);
                }
            }
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitNeg_set(RequestParser.Neg_setContext ctx) {
        visit(ctx.set());

        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitInv_property_set(RequestParser.Inv_property_setContext ctx) {
        visit(ctx.inv_property());
        if (ctx.VALUE()!=null){
            if (!this.entities.containsIndividual(ctx.ID().getText())) {
                Token tk = ctx.ID().getSymbol();
                ContextualError error =
                        new ContextualError(tk.getLine(),
                                tk.getText() + " has not been declared ");
                errors.add(error);
            }
        }
        else
        if (ctx.SOME() != null || ctx.ONLY() != null)
            visit(ctx.set1());
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitInv_property(RequestParser.Inv_propertyContext ctx) {
        if (ctx.inv_property()!=null)
            visit(ctx.inv_property());
        else
        if (!this.entities.containsObjectProperty(ctx.ID().getText())) {
            Token tk = ctx.ID().getSymbol();
            ContextualError error =
                    new ContextualError(tk.getLine(),
                            tk.getText() + " has not been declared ");
            errors.add(error);
        }
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitClass_set(RequestParser.Class_setContext ctx) {
        if (ctx.ID()!=null)
            if (!this.entities.containsClass(ctx.ID().getText())) {
                Token tk = ctx.ID().getSymbol();
                ContextualError error =
                        new ContextualError(tk.getLine(),
                                tk.getText() + " has not been declared ");
                errors.add(error);
            }
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitAnonymous_set(RequestParser.Anonymous_setContext ctx) {
        visit(ctx.terms());
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitTerms(RequestParser.TermsContext ctx) {
        if (!this.entities.containsIndividual(ctx.ID().getText())) {
            Token tk = ctx.ID().getSymbol();
            ContextualError error =
                    new ContextualError(tk.getLine(),
                            tk.getText() + " has not been declared ");
            errors.add(error);
        }
        if (ctx.getChildCount()==3)
            visit(ctx.terms());
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitSet1(RequestParser.Set1Context ctx) {
        if (ctx.class_set()!=null) visit(ctx.class_set());
        else if (ctx.terms()!=null) visit(ctx.terms());
        else visit(ctx.set());
        return null;
    }
}
