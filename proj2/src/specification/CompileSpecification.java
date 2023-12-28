package specification;

import common.Entities;
import common.OWLCodeGenerator;
import file.FileHandler;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLXMLOntologyFormat;
import org.semanticweb.owlapi.model.*;

import java.io.File;
import java.util.*;

public class CompileSpecification extends SpecificationParserBaseVisitor<Object>{
    private OWLCodeGenerator codeGenerator;
    private Entities entities=null;
    private String specificationName=null;

    //For the purpose of facilitating unification activities between specifications
    private Map<String,String>inputs; //input parameter and its type (in short form)
    private Map<String,String>outputs; //output parameter and its type (in short form)
    private Set<OWLAxiom> I;
    private Set<OWLAxiom> O;
    private List<Set<OWLAxiom>>P;
    private List<Set<OWLAxiom>>E;
    private FileHandler fh;

    private boolean precondition;
    private int pre_index;
    private int eff_index;
    public void init(String name,Entities entities) throws OWLOntologyCreationException {
        specificationName=name;
        this.entities=entities; //computed previously by ContextualAnalisisSpecification
        //Every occurrence of a parameter is prefixed with http://127.0.0.1/parameter/
        //in order to differentiate them from others individuals. This translation has been
        //calculated in contextual analysis and stored in the variable entitities.
        this.inputs=new HashMap<>();
        this.outputs=new HashMap<>();

        this.I = new HashSet<>();
        this.O = new HashSet<>();
        this.P = new LinkedList<>();
        this.E = new LinkedList<>();

        precondition = false;
        pre_index=0;
        eff_index=0;

        codeGenerator= new OWLCodeGenerator(this.entities);
        String path="C://xampp//htdocs//specifications//"+
                this.specificationName.replace(".txt","")+"//";
        File location = new File(path);
        if (!location.exists()) location.mkdir();
    }

    @Override
    public Object visitSpec(SpecificationParser.SpecContext ctx) {
        visitInputs(ctx.inputs());
        visitOutputs(ctx.outputs());
        visitPairs_of_states(ctx.pairs_of_states());
        return null;
    }

    @Override
    public Object visitInputs(SpecificationParser.InputsContext ctx) {
        if (ctx.iparams()!=null)
            visitIparams(ctx.iparams());
        //code generation I.txt and I.owl
        String path="C://xampp//htdocs//specifications//"+
                this.specificationName.replace(".txt","")+"//";
        String name = "I";
        fh=new FileHandler();
        fh.open_file(path,name);
        //write in an auxiliary file both the name and the type of ans input parameter under consideration.
        inputs.entrySet().stream().forEach(e->{
            fh.write("http://127.0.0.1/parameter/"+e.getKey()); fh.write(","); fh.write(e.getValue()); fh.write("\n");
        });
        fh.close_file();
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        IRI I_IRI_server = IRI.create("http://127.0.0.1/specifications/"+
                this.specificationName.replace(".txt","")+"/I.owl");
        IRI I_IRI = IRI.create("file:///C://xampp//htdocs//specifications//"+
                this.specificationName.replace(".txt","")+"//I.owl");
        try {
            OWLOntology Iontology=manager.createOntology(I,I_IRI_server);
            OWLOntologyFormat oformat = new OWLXMLOntologyFormat();
            manager.saveOntology(Iontology, oformat, I_IRI);
        }catch(Exception e){e.getStackTrace();}
        return null;
    }

    @Override
    public Object visitIparams(SpecificationParser.IparamsContext ctx) {
        visitIparam(ctx.iparam());
        if (ctx.getChildCount()==3)
            visitIparams(ctx.iparams());
        return null;
    }

    @Override
    public Object visitIparam(SpecificationParser.IparamContext ctx) {
        //iparam : type  ID          type: ID COLON ID
        String parameter = ctx.ID().getText();
        String type = ctx.type().ID(1).getText();
        inputs.put(parameter,this.entities.getClasses().get(type).toString());
        OWLAxiom ax=codeGenerator.belongsAxiom(this.entities.getIndividuals().get(parameter),
                codeGenerator.type(type));
        I.add(ax);
        return null;
    }

    @Override
    public Object visitOutputs(SpecificationParser.OutputsContext ctx) {
        if (ctx.oparams()!=null)
            visitOparams(ctx.oparams());
        //code generation I.txt and I.owl
        String path="C://xampp//htdocs//specifications//"+
                this.specificationName.replace(".txt","")+"//";
        String name = "O";
        fh=new FileHandler();
        fh.open_file(path,name);
        outputs.entrySet().stream().forEach(e->{
            fh.write("http://127.0.0.1/parameter/"+e.getKey()); fh.write(","); fh.write(e.getValue()); fh.write("\n");
        });
        fh.close_file();
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        IRI O_IRI_server = IRI.create("http://127.0.0.1/specifications/"+
                this.specificationName.replace(".txt","")+"/O.owl");
        IRI O_IRI = IRI.create("file:///C://xampp//htdocs//specifications//"+
                this.specificationName.replace(".txt","")+"//O.owl");
        try {
            OWLOntology Oontology=manager.createOntology(O,O_IRI_server);
            OWLOntologyFormat oformat = new OWLXMLOntologyFormat();
            manager.saveOntology(Oontology, oformat, O_IRI);
        }catch(Exception e){e.getStackTrace();}
        return null;
    }

    @Override
    public Object visitOparams(SpecificationParser.OparamsContext ctx) {
        visitOparam(ctx.oparam());
        if (ctx.getChildCount()==3)
            visitOparams(ctx.oparams());
        return null;
    }

    @Override
    public Object visitOparam(SpecificationParser.OparamContext ctx) {
        //iparam : type  ID          type: ID COLON ID
        String parameter = ctx.ID().getText();
        String type = ctx.type().ID(1).getText();
        outputs.put(parameter,this.entities.getClasses().get(type).toString());
        OWLAxiom ax=codeGenerator.belongsAxiom(this.entities.getIndividuals().get(parameter),
                codeGenerator.type(type));
        O.add(ax);
        return null;
    }

    @Override
    public Object visitPairs_of_states(SpecificationParser.Pairs_of_statesContext ctx) {
        //(pair_of_states)+
        for(int i=0;i<ctx.getChildCount();i++) {
            pre_index=i;
            eff_index=i;
            //Initialise empty sets of axioms for precondition and effect
            Set<OWLAxiom>auxP=new HashSet<>();
            this.P.add(auxP);
            Set<OWLAxiom>auxE=new HashSet<>();
            this.E.add(auxE);
            visitPair_of_states(ctx.pair_of_states(i));
        }
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        if (E.size()>1){
            for(int i=0;i<E.size();i++){
                IRI P_IRI_server = IRI.create("http://127.0.0.1/specifications/"+
                        this.specificationName.replace(".txt","")+"/P"+i+".owl");
                IRI E_IRI_server = IRI.create("http://127.0.0.1/specifications/"+
                        this.specificationName.replace(".txt","")+"/E"+i+".owl");
                IRI P_IRI = IRI.create("file:///C://xampp//htdocs//specifications//"+
                        this.specificationName.replace(".txt","")+"//P"+i+".owl");
                IRI E_IRI = IRI.create("file:///C://xampp//htdocs//specifications//"+
                        this.specificationName.replace(".txt","")+"//E"+i+".owl");
                try {
                    OWLOntology Pontology=manager.createOntology(P.get(i),P_IRI_server);
                    OWLOntologyFormat oformat = new OWLXMLOntologyFormat();
                    manager.saveOntology(Pontology, oformat, P_IRI);
                    OWLOntology Eontology=manager.createOntology(E.get(i),E_IRI_server);
                    manager.saveOntology(Eontology, oformat, E_IRI);
                }catch(Exception e){e.getStackTrace();}
            }
        }
        else{
            IRI P_IRI_server = IRI.create("http://127.0.0.1/specifications/"+
                    this.specificationName.replace(".txt","")+"/P.owl");
            IRI E_IRI_server = IRI.create("http://127.0.0.1/specifications/"+
                    this.specificationName.replace(".txt","")+"/E.owl");
            IRI P_IRI = IRI.create("file:///C://xampp//htdocs//specifications//"+
                    this.specificationName.replace(".txt","")+"//P.owl");
            IRI E_IRI = IRI.create("file:///C://xampp//htdocs//specifications//"+
                    this.specificationName.replace(".txt","")+"//E.owl");
            try {
                OWLOntology Pontology=manager.createOntology(P.get(0),P_IRI_server);
                OWLOntologyFormat oformat = new OWLXMLOntologyFormat();
                manager.saveOntology(Pontology, oformat, P_IRI);
                OWLOntology Eontology=manager.createOntology(E.get(0),E_IRI_server);
                manager.saveOntology(Eontology, oformat, E_IRI);
            }catch(Exception e){e.getStackTrace();}
        }
        return null;
    }

    @Override
    public Object visitPair_of_states(SpecificationParser.Pair_of_statesContext ctx) {
        visitPrecondition(ctx.precondition());
        visitEffect(ctx.effect());
        return null;
    }

    @Override
    public Object visitPrecondition(SpecificationParser.PreconditionContext ctx) {
        //precondition : PRECONDITION COLON sentences
        precondition=true;
        visitSentences(ctx.sentences());
        return null;
    }

    @Override
    public Object visitEffect(SpecificationParser.EffectContext ctx) {
        //effect : EFFECT COLON sentences ;
        precondition=false;
        visitSentences(ctx.sentences());
        return null;
    }

    @Override
    public Object visitSentences(SpecificationParser.SentencesContext ctx) {
    //sentences : sentence COMMA sentences
        //          | sentence
        //          |
        if (ctx.getChildCount()>0){
            visitSentence(ctx.sentence());
            if (ctx.getChildCount()==3)
                visitSentences(ctx.sentences());
        }
        return null;
    }

    @Override
    public Object visitSentence(SpecificationParser.SentenceContext ctx) {
        //sentence : set SUBCLASSOF set
        //         | set EQUIVALENTTO set
        //         | ID BELONGS set
        OWLAxiom ax=null;
        if (ctx.BELONGS()!=null){
            String ind = ctx.ID().getText();
            OWLClassExpression ce = (OWLClassExpression)visitSet(ctx.set(0));
            //every occurrence of a parameter is prefixed with http://127.0.0.1/parameter/
            //in order to differentiate them from others individuals.
            ax=codeGenerator.belongsAxiom(this.entities.getIndividuals().get(ind), ce);

        } else if (ctx.SUBCLASSOF()!=null) {
            OWLClassExpression ce1 = (OWLClassExpression)visitSet(ctx.set(0));
            OWLClassExpression ce2 = (OWLClassExpression)visitSet(ctx.set(1));
            ax=codeGenerator.subClassAxiom(ce1,ce2);
        }
        else{
            OWLClassExpression ce1 = (OWLClassExpression)visitSet(ctx.set(0));
            OWLClassExpression ce2 = (OWLClassExpression)visitSet(ctx.set(1));
            ax=codeGenerator.equivalentClassesAxiom(ce1,ce2);
        }
        if (precondition)
            P.get(pre_index).add(ax);
        else
            E.get(eff_index).add(ax);
        return null;
    }

    @Override
    public Object visitSet(SpecificationParser.SetContext ctx) {
        //set :  set_and OR set
        //    |  set_and
        OWLClassExpression ce=null;
        OWLClassExpression ce1=(OWLClassExpression)visitSet_and(ctx.set_and());
        if (ctx.getChildCount()==3) {
            OWLClassExpression ce2=(OWLClassExpression)visitSet(ctx.set());
            ce=codeGenerator.disjunction(ce1,ce2);
        }
        else
           ce=ce1;
        return ce;
    }

    @Override
    public Object visitSet_and(SpecificationParser.Set_andContext ctx) {
        //set_and : set_base AND set_and
        //        | set_base
        OWLClassExpression ce=null;
        OWLClassExpression ce1=(OWLClassExpression)visitSet_base(ctx.set_base());
        if (ctx.getChildCount()==3) {
            OWLClassExpression ce2=(OWLClassExpression)visitSet_and(ctx.set_and());
            ce=codeGenerator.conjunction(ce1,ce2);
        }
        else
            ce=ce1;
        return ce;
    }

    @Override
    public Object visitSet_base(SpecificationParser.Set_baseContext ctx) {
        //set_base : property_set
        //      | neg_set
        //      | inv_property_set
        //      | class_set
        //      | OP set CP
        //      | anonymous_set
        OWLClassExpression ce=null;
        if (ctx.property_set()!=null)
            ce=(OWLClassExpression)visitProperty_set(ctx.property_set());
        else if (ctx.neg_set()!=null)
            ce=(OWLClassExpression)visitNeg_set(ctx.neg_set());
        else if (ctx.inv_property_set()!=null)
            ce=(OWLClassExpression)visitInv_property_set(ctx.inv_property_set());
        else if (ctx.class_set()!=null)
            ce=(OWLClassExpression)visitClass_set(ctx.class_set());
        else if (ctx.anonymous_set()!=null)
            ce=(OWLClassExpression)visitAnonymous_set(ctx.anonymous_set());
        else ce=(OWLClassExpression)visitSet(ctx.set());
        return ce;
    }

    @Override
    public Object visitProperty_set(SpecificationParser.Property_setContext ctx) {
        //property_set : ID (MIN | EXACTLY | MAX) INT
        //           | ID VALUE (ID | DBL | INT | STR | T | F)
        //           | ID ONLY set
        //           | ID SOME set
        //           | ID SELF
        OWLClassExpression ce=null;
        String p = ctx.ID(0).getText();
        if (ctx.MIN()!=null){
            Integer n = Integer.valueOf(ctx.INT().getText());
            ce=codeGenerator.min(p,n);
        }
        else if (ctx.MAX()!=null){
            Integer n = Integer.valueOf(ctx.INT().getText());
            ce=codeGenerator.max(p,n);
        }
        else if (ctx.EXACTLY()!=null){
            Integer n = Integer.valueOf(ctx.INT().getText());
            ce=codeGenerator.exactly(p,n);
        }
        else if (ctx.VALUE()!=null){
            if (ctx.ID(1)!=null){
               String i = ctx.ID(1).getText();
               ce=codeGenerator.value_id(p,i);
            } else if (ctx.DBL()!=null) {
                String d = ctx.DBL().getText();
                ce=codeGenerator.value_dbl(p,d);
            } else if (ctx.INT()!=null) {
                String i = ctx.INT().getText();
                ce=codeGenerator.value_int(p,i);
            } else if (ctx.STR()!=null) {
                String s = ctx.STR().getText();
                ce=codeGenerator.value_str(p,s);
            }
            else{
                String b;
                if (ctx.T().getText()!=null)   b=ctx.T().getText();
                else b=ctx.F().getText();
                ce=codeGenerator.value_boolean(p,b);
            }
        } else if (ctx.ONLY()!=null) {
            OWLClassExpression r = (OWLClassExpression)visitSet(ctx.set());
            ce=codeGenerator.only(p,r);
        } else if (ctx.SOME()!=null) {
            OWLClassExpression r = (OWLClassExpression)visitSet(ctx.set());
            ce=codeGenerator.some(p,r);
        }
        else{
            ce=codeGenerator.self(p);
        }
        return ce;
    }

    @Override
    public Object visitNeg_set(SpecificationParser.Neg_setContext ctx) {
        //neg_set : NEG set  ;
        OWLClassExpression ce = (OWLClassExpression)visitSet(ctx.set());
        return codeGenerator.neg(ce);
    }

    @Override
    public Object visitInv_property_set(SpecificationParser.Inv_property_setContext ctx) {
        //inv_property_set :  inv_property (MIN | EXACTLY | MAX) INT
        //               | inv_property VALUE ID
        //               | inv_property ONLY set1
        //               | inv_property SOME set1
        //               | inv_property SELF
        OWLClassExpression ce=null;
        Stack<Boolean>b = new Stack<Boolean>();
        String p = (String)visitInv_property(ctx.inv_property(),b);
        if (ctx.MIN()!=null){
            Integer n = Integer.valueOf(ctx.INT().getText());
            ce=codeGenerator.min_inverse(p,b.peek(),n);
        }
        else if (ctx.MAX()!=null){
            Integer n = Integer.valueOf(ctx.INT().getText());
            ce=codeGenerator.max_inverse(p,b.peek(),n);
        }
        else if (ctx.EXACTLY()!=null){
            Integer n = Integer.valueOf(ctx.INT().getText());
            ce=codeGenerator.exactly_inverse(p,b.peek(),n);
        }
        else if (ctx.VALUE()!=null){
                String i = ctx.ID().getText();
                ce=codeGenerator.value_id_inverse(p,b.peek(),i);

        } else if (ctx.ONLY()!=null) {
            OWLClassExpression r = (OWLClassExpression)visitSet1(ctx.set1());
            ce=codeGenerator.only_inverse(p,b.peek(),r);
        } else if (ctx.SOME()!=null) {
            OWLClassExpression r = (OWLClassExpression)visitSet1(ctx.set1());
            ce=codeGenerator.some_inverse(p,b.peek(),r);
        }
        else{
            ce=codeGenerator.self_inverse(p,b.peek());
        }
        return ce;
    }


    public Object visitInv_property(SpecificationParser.Inv_propertyContext ctx, Stack<Boolean> b) {
        //inv_property : INVERSE OP (inv_property | ID) CP
        String p=null;
        if (ctx.inv_property()!=null) {
            p = (String)visitInv_property(ctx.inv_property(),b);
            b.push(!b.peek());
        }
        else{
            p = new String(ctx.ID().getText());
            b.push(true);
        }
        return p;
    }

    @Override
    public Object visitClass_set(SpecificationParser.Class_setContext ctx) {
        //class_set :  ID
        //          | THING
        //          | NOTHING
        OWLClassExpression ce = null;
        if (ctx.ID()!=null)
            ce=codeGenerator.type(ctx.ID().getText());
        else if (ctx.NOTHING()!=null)
            ce=codeGenerator.nothing();
        else ce=codeGenerator.thing();
        return ce;
    }

    @Override
    public Object visitAnonymous_set(SpecificationParser.Anonymous_setContext ctx) {
        //anonymous_set: OB terms CB
        Set<String>ts = (Set<String>)visitTerms(ctx.terms());
        return (OWLClassExpression)codeGenerator.anonymous_class(ts);
    }

    @Override
    public Object visitTerms(SpecificationParser.TermsContext ctx) {
        //terms : ID COMMA terms
        //      | ID
        Set<String>ts = new HashSet<>();
        ts.add(ctx.ID().getText());
        if (ctx.getChildCount()==3)
            ts.addAll((Set<String>)visitTerms(ctx.terms()));
        return ts;
    }

    @Override
    public Object visitSet1(SpecificationParser.Set1Context ctx) {
        //set1: class_set
        //      | OP set CP
        //      | OB terms CB
        OWLClassExpression ce = null;
        if (ctx.class_set()!=null)
            ce=(OWLClassExpression)visitClass_set(ctx.class_set());
        else if (ctx.set()!=null) {
            ce=(OWLClassExpression)visitSet(ctx.set());
        }
        else {
            Set<String>ts = (Set<String>)visitTerms(ctx.terms());
            ce=(OWLClassExpression)codeGenerator.anonymous_class(ts);
        }
        return ce;
    }
}
