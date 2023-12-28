package specification;

import common.ContextualError;
import common.Entities;
import common.OntologyHandler;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Pair;
import org.semanticweb.owlapi.model.*;

import java.util.*;

public class ContextualAnalysisSpecification extends
        SpecificationParserBaseVisitor<Pair<Entities,List<ContextualError>>> {
    OntologyHandler manager = new OntologyHandler();
    Entities entities=new Entities();
    List<ContextualError> errors = new LinkedList<>();
    Map<String,IRI>ontologies=new HashMap<>();
    String specificationName=null;
    String ontologyPath="http://127.0.0.1/ontology/";
    String specificationPath="http://127.0.0.1/specifications/";
    public void init(String name){
        specificationName=name;
    }

    @Override
    public Pair<Entities,List<ContextualError>> visitSpec(SpecificationParser.SpecContext ctx)  {
        visitVocabulary(ctx.vocabulary());
        visitInputs(ctx.inputs());
        visitOutputs(ctx.outputs());
        visitPairs_of_states(ctx.pairs_of_states());
        return new Pair<Entities,List<ContextualError>>(this.entities,this.errors);
    }

    @Override
    public Pair<Entities,List<ContextualError>> visitVocabulary(SpecificationParser.VocabularyContext ctx) {
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
    public Pair<Entities,List<ContextualError>> visitOntologies(SpecificationParser.OntologiesContext ctx) {
        IRI ontologyIRI =
                IRI.create(ontologyPath+ctx.ID().getText()+".owl");
        ontologies.put(ctx.ID().getText(),ontologyIRI);
        manager.loadOntology(ontologyIRI);
        if (ctx.getChildCount()==3)
            visitOntologies(ctx.ontologies());
        return null;
    }

    @Override
    public Pair<Entities,List<ContextualError>> visitInputs(SpecificationParser.InputsContext ctx) {
        if (ctx.getChildCount()==3)
            visitIparams(ctx.iparams());
        return null;
    }

    @Override
    public Pair<Entities,List<ContextualError>> visitIparams(SpecificationParser.IparamsContext ctx) {
        visitIparam(ctx.iparam());
        if (ctx.getChildCount()==3)
            visitIparams(ctx.iparams());
        return null;
    }

    @Override
    public Pair<Entities,List<ContextualError>> visitIparam(SpecificationParser.IparamContext ctx) {
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
    public Pair<Entities,List<ContextualError>> visitOutputs(SpecificationParser.OutputsContext ctx) {
        if (ctx.getChildCount()==3)
            visitOparams(ctx.oparams());
        return null;
    }

    @Override
    public Pair<Entities,List<ContextualError>> visitOparams(SpecificationParser.OparamsContext ctx) {
        visitOparam(ctx.oparam());
        if (ctx.getChildCount()==3)
            visitOparams(ctx.oparams());
        return null;
    }

    @Override
    public Pair<Entities,List<ContextualError>> visitOparam(SpecificationParser.OparamContext ctx) {
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
    public Pair<Entities, List<ContextualError>> visitPairs_of_states(SpecificationParser.Pairs_of_statesContext ctx) {
        for(int i=0;i<ctx.getChildCount();i++)
            visit(ctx.pair_of_states(i));
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitPair_of_states(SpecificationParser.Pair_of_statesContext ctx) {
        visit(ctx.precondition());
        visit(ctx.effect());
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitPrecondition(SpecificationParser.PreconditionContext ctx) {
        visit(ctx.sentences());
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitEffect(SpecificationParser.EffectContext ctx) {
        visit(ctx.sentences());
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitSentences(SpecificationParser.SentencesContext ctx) {
        switch(ctx.getChildCount()){
            case 0: break;
            case 1: visit(ctx.sentence()); break;
            case 3: visit(ctx.sentence());  visit(ctx.sentences()); break;
        }
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitSentence(SpecificationParser.SentenceContext ctx) {
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
    public Pair<Entities, List<ContextualError>> visitSet(SpecificationParser.SetContext ctx) {
        visit(ctx.set_and());
        if (ctx.getChildCount()==3){
            visit(ctx.set());
        }
        return null;
    }
    @Override
    public Pair<Entities, List<ContextualError>> visitSet_and(SpecificationParser.Set_andContext ctx) {
        visit(ctx.set_base());
        if (ctx.getChildCount()==3){
            visit(ctx.set_and());
        }
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitSet_base(SpecificationParser.Set_baseContext ctx) {
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
    public Pair<Entities, List<ContextualError>> visitProperty_set(SpecificationParser.Property_setContext ctx) {
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
    public Pair<Entities, List<ContextualError>> visitNeg_set(SpecificationParser.Neg_setContext ctx) {
        visit(ctx.set());

        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitInv_property_set(SpecificationParser.Inv_property_setContext ctx) {
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
    public Pair<Entities, List<ContextualError>> visitInv_property(SpecificationParser.Inv_propertyContext ctx) {
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
    public Pair<Entities, List<ContextualError>> visitClass_set(SpecificationParser.Class_setContext ctx) {
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
    public Pair<Entities, List<ContextualError>> visitAnonymous_set(SpecificationParser.Anonymous_setContext ctx) {
        visit(ctx.terms());
        return null;
    }

    @Override
    public Pair<Entities, List<ContextualError>> visitTerms(SpecificationParser.TermsContext ctx) {
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
    public Pair<Entities, List<ContextualError>> visitSet1(SpecificationParser.Set1Context ctx) {
        if (ctx.class_set()!=null) visit(ctx.class_set());
        else if (ctx.terms()!=null) visit(ctx.terms());
        else visit(ctx.set());
        return null;
    }
}
