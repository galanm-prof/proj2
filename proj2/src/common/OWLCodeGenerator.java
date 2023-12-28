package common;

import common.Entities;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

import java.util.HashSet;
import java.util.Set;

public class OWLCodeGenerator {
    // Ontology managers
    private OWLOntologyManager manager;

    // Data factory
    private OWLDataFactory dataFactory;
    private Entities entities;

    public OWLCodeGenerator(Entities entities) throws OWLOntologyCreationException {
        manager = OWLManager.createOWLOntologyManager();
        dataFactory = manager.getOWLDataFactory();
        this.entities = entities;
    }

    ////////////////////////////////////////////////////////
    ////////////// CODE GENERATION METHODS /////////////////
    ////////////////////////////////////////////////////////

    public OWLClassExpression type(String c){
        OWLClassExpression result;
        IRI c_iri;
        c_iri = entities.getClasses().get(c);
        result = dataFactory.getOWLClass(c_iri);
        return result;
    }
    ////////////////////////////////////////////////
    // Min-restriction for a property
    // pre: p is the name of a property
    public OWLClassExpression min(String p, int n){
        OWLClassExpression result;
        IRI p_iri;
        if (entities.containsObjectProperty(p)){
            p_iri = entities.getObjectProperties().get(p);
            OWLObjectProperty op = dataFactory.getOWLObjectProperty(p_iri);
            result = dataFactory.getOWLObjectMinCardinality(n, op);
        }
        else{
            p_iri = entities.getDatatypeProperties().get(p);
            OWLDataProperty dp = dataFactory.getOWLDataProperty(p_iri);
            result = dataFactory.getOWLDataMinCardinality(n, dp);
        }
        return result;
    }

    ////////////////////////////////////////////////
    // Exactly-restriction for a property
    // pre: p is the name of a property
    public OWLClassExpression exactly(String p, int n){
        OWLClassExpression result;
        IRI p_iri;
        if (entities.containsObjectProperty(p)){
            p_iri = entities.getObjectProperties().get(p);
            OWLObjectProperty op = dataFactory.getOWLObjectProperty(p_iri);
            result = dataFactory.getOWLObjectExactCardinality(n, op);
        }
        else{
            p_iri = entities.getDatatypeProperties().get(p);
            OWLDataProperty dp = dataFactory.getOWLDataProperty(p_iri);
            result = dataFactory.getOWLDataExactCardinality(n, dp);
        }
        return result;
    }

    ////////////////////////////////////////////////
    // Max-restriction for a property
    // pre: p is the name of a property
    public OWLClassExpression max(String p, int n){
        OWLClassExpression result;
        IRI p_iri;
        if (entities.containsObjectProperty(p)){
            p_iri = entities.getObjectProperties().get(p);
            OWLObjectProperty op = dataFactory.getOWLObjectProperty(p_iri);
            result = dataFactory.getOWLObjectMaxCardinality(n, op);
        }
        else{
            p_iri = entities.getDatatypeProperties().get(p);
            OWLDataProperty dp = dataFactory.getOWLDataProperty(p_iri);
            result = dataFactory.getOWLDataMaxCardinality(n, dp);
        }
        return result;
    }

    ////////////////////////////////////////////////
    // Value-id restriction for an object property
    // pre: p is the name of an object property
    public OWLClassExpression value_id(String p, String i){
        OWLClassExpression result;
        //System.out.println("valued_id: "+i);
        IRI op_iri = entities.getObjectProperties().get(p);
        IRI i_iri = entities.getIndividuals().get(i);
        //System.out.println("valued_id (2): "+i_iri);
        OWLObjectProperty op = dataFactory.getOWLObjectProperty(op_iri);
        OWLIndividual ind = dataFactory.getOWLNamedIndividual(i_iri);
        result = dataFactory.getOWLObjectHasValue(op, ind);
        return result;
    }

    ////////////////////////////////////////////////
    // Value-dbl restriction for a datatype property with double as its range
    // pre: p is the name of the datatype property
    public OWLClassExpression value_dbl(String p, String d){
        OWLClassExpression result;
        IRI dp_iri = entities.getDatatypeProperties().get(p);
        OWLDataProperty dp = dataFactory.getOWLDataProperty(dp_iri);
        OWLLiteral l =	dataFactory.getOWLLiteral(d, dataFactory.getDoubleOWLDatatype());
        result = dataFactory.getOWLDataHasValue(dp, l);
        return result;
    }

    ////////////////////////////////////////////////
    // Value-int restriction for a datatype property with integer as its range
    // pre: p is the name of the datatype property
    public OWLClassExpression value_int(String p, String i){
        OWLClassExpression result;
        IRI dp_iri = entities.getDatatypeProperties().get(p);
        OWLDataProperty dp = dataFactory.getOWLDataProperty(dp_iri);
        OWLLiteral l =	dataFactory.getOWLLiteral(i, dataFactory.getIntegerOWLDatatype());
        result = dataFactory.getOWLDataHasValue(dp, l);
        return result;
    }

    ////////////////////////////////////////////////
    // Value-str restriction for a datatype property with string as range
    // pre: p is the name of the datatype property
    public OWLClassExpression value_str(String p, String s){
        OWLClassExpression result;
        IRI dp_iri = entities.getDatatypeProperties().get(p);
        OWLDataProperty dp = dataFactory.getOWLDataProperty(dp_iri);
        OWLLiteral l =	dataFactory.getOWLLiteral(s);
        result = dataFactory.getOWLDataHasValue(dp, l);
        return result;
    }

    ////////////////////////////////////////////////
    // Value-boolean restriction for a datatype property with boolean as its range
    // pre: p is the name of the datatype property
    public OWLClassExpression value_boolean(String p, String b){
        OWLClassExpression result;
        IRI dp_iri = entities.getDatatypeProperties().get(p);
        OWLDataProperty dp = dataFactory.getOWLDataProperty(dp_iri);
        OWLLiteral l =	dataFactory.getOWLLiteral(b, dataFactory.getBooleanOWLDatatype());
        result = dataFactory.getOWLDataHasValue(dp, l);
        return result;
    }

    ////////////////////////////////////////////////
    // Only-restriction for an object property
    // pre: p is the name of an object property
    public OWLClassExpression only(String p, OWLClassExpression r){
        OWLClassExpression result;
        IRI op_iri = entities.getObjectProperties().get(p);
        OWLObjectProperty op = dataFactory.getOWLObjectProperty(op_iri);
        result = dataFactory.getOWLObjectAllValuesFrom(op, r);
        return result;
    }

    ////////////////////////////////////////////////
    // Some-restriction for an object property
    // pre: p is the name of an object property
    public OWLClassExpression some(String p, OWLClassExpression r){
        OWLClassExpression result;
        IRI op_iri = entities.getObjectProperties().get(p);
        OWLObjectProperty op = dataFactory.getOWLObjectProperty(op_iri);
        result = dataFactory.getOWLObjectSomeValuesFrom(op, r);
        return result;
    }

    ////////////////////////////////////////////////
    // Negation of a class expression
    public OWLClassExpression neg(OWLClassExpression ce){
        OWLClassExpression result = ce.getObjectComplementOf();
        return result;
    }

    ////////////////////////////////////////////////
    // Min restriction for an object property in the context of inverse operations
    // pre: p is the name of an object property
    public OWLClassExpression min_inverse(String p, Boolean b, int n){
        OWLClassExpression result;

        IRI op_iri;
        OWLObjectPropertyExpression ope;
        op_iri = entities.getObjectProperties().get(p);
        OWLObjectProperty op = dataFactory.getOWLObjectProperty(op_iri);
        if (b)
            ope=dataFactory.getOWLObjectInverseOf(op);
        else
            ope=op;
        result = dataFactory.getOWLObjectMinCardinality(n, ope);
        return result;
    }

    ////////////////////////////////////////////////
    // Exact restriction for an object property in the context of inverse operations
    // pre: p is the name of an object property
    public OWLClassExpression exactly_inverse(String p, Boolean b, int n){
        OWLClassExpression result;

        IRI op_iri;
        OWLObjectPropertyExpression ope;
        op_iri = entities.getObjectProperties().get(p);
        OWLObjectProperty op = dataFactory.getOWLObjectProperty(op_iri);
        if (b)
            ope=dataFactory.getOWLObjectInverseOf(op);
        else
            ope=op;
        result = dataFactory.getOWLObjectExactCardinality(n, ope);
        return result;
    }

    ////////////////////////////////////////////////
    // Max restriction for an object property in the context of inverse operations
    // pre: p is the name of an object property
    public OWLClassExpression max_inverse(String p, Boolean b, int n){
        OWLClassExpression result;

        IRI op_iri;
        OWLObjectPropertyExpression ope;
        op_iri = entities.getObjectProperties().get(p);
        OWLObjectProperty op = dataFactory.getOWLObjectProperty(op_iri);
        if (b)
            ope=dataFactory.getOWLObjectInverseOf(op);
        else
            ope=op;
        result = dataFactory.getOWLObjectMaxCardinality(n, ope);
        return result;
    }

    ////////////////////////////////////////////////
    // Value-id restriction for an object property in the context of inverse operations
    // pre: p is the name of an object property
    public OWLClassExpression value_id_inverse(String p, Boolean b, String i){
        OWLClassExpression result;

        OWLObjectPropertyExpression ope;
        IRI op_iri = entities.getObjectProperties().get(p);
        IRI i_iri = entities.getIndividuals().get(i);
        OWLObjectProperty op = dataFactory.getOWLObjectProperty(op_iri);
        OWLIndividual ind = dataFactory.getOWLNamedIndividual(i_iri);
        if (b)
            ope=dataFactory.getOWLObjectInverseOf(op);
        else
            ope=op;
        result = dataFactory.getOWLObjectHasValue(ope, ind);
        return result;
    }

    ////////////////////////////////////////////////
    // Only-restriction for an object property in the context of inverse operations
    // pre: p is the name of an object property
    public OWLClassExpression only_inverse(String p, Boolean b, OWLClassExpression r){
        OWLClassExpression result;
        OWLObjectPropertyExpression ope;
        IRI op_iri = entities.getObjectProperties().get(p);
        OWLObjectProperty op = dataFactory.getOWLObjectProperty(op_iri);
        if (b)
            ope=dataFactory.getOWLObjectInverseOf(op);
        else
            ope=op;
        result = dataFactory.getOWLObjectAllValuesFrom(ope, r);
        return result;
    }

    ////////////////////////////////////////////////
    // Some-restriction for an object property in the context of inverse operations
    // pre: p is the name of an object property
    public OWLClassExpression some_inverse(String p, Boolean b, OWLClassExpression r){
        OWLClassExpression result;
        OWLObjectPropertyExpression ope;
        IRI op_iri = entities.getObjectProperties().get(p);
        OWLObjectProperty op = dataFactory.getOWLObjectProperty(op_iri);
        if (b)
            ope=dataFactory.getOWLObjectInverseOf(op);
        else
            ope=op;
        result = dataFactory.getOWLObjectSomeValuesFrom(ope, r);
        return result;
    }

    ////////////////////////////////////////////////
    // Self-restriction for an object property
    // pre: p is the name of an object property
    public OWLClassExpression self(String p){
        OWLClassExpression result;
        IRI op_iri = entities.getObjectProperties().get(p);
        OWLObjectProperty op = dataFactory.getOWLObjectProperty(op_iri);
        result = dataFactory.getOWLObjectHasSelf(op);
        return result;
    }

    ////////////////////////////////////////////////
    // Self-restriction for an object property in the context of inverse operations
    // pre: p is the name of an object property
    public OWLClassExpression self_inverse(String p, Boolean b){
        OWLClassExpression result;
        OWLObjectPropertyExpression ope;
        IRI op_iri = entities.getObjectProperties().get(p);
        OWLObjectProperty op = dataFactory.getOWLObjectProperty(op_iri);
        if (b)
            ope=dataFactory.getOWLObjectInverseOf(op);
        else
            ope=op;
        result = dataFactory.getOWLObjectHasSelf(ope);
        return result;
    }


    // Code generation: anonymous class occurrence in a query
    public OWLObjectOneOf anonymous_class(Set<String> ts){
        Set<OWLIndividual> individuals = new HashSet<>();

        for(String t:ts){
            OWLNamedIndividual individual =
                    dataFactory.getOWLNamedIndividual(this.entities.getIndividuals().get(t));
            individuals.add(individual);
        }
        return dataFactory.getOWLObjectOneOf(individuals);
    }

    // Code generation: nothing
    public OWLClass nothing(){
        return dataFactory.getOWLNothing();
    }

    // Code generation: thing
    public OWLClass thing(){
        return dataFactory.getOWLThing();
    }

    public OWLClassExpression disjunction(OWLClassExpression ce1,
                                          OWLClassExpression ce2){
        return dataFactory.getOWLObjectUnionOf(ce1, ce2);
    }

    public OWLClassExpression conjunction(OWLClassExpression ce1,
                                          OWLClassExpression ce2){
        return dataFactory.getOWLObjectIntersectionOf(ce1,ce2);
    }


    public OWLAxiom subClassAxiom(OWLClassExpression ce1,
                                  OWLClassExpression ce2){
        return dataFactory.getOWLSubClassOfAxiom(ce1, ce2);
    }

    public OWLAxiom equivalentClassesAxiom(OWLClassExpression ce1,
                                           OWLClassExpression ce2){
        return dataFactory.getOWLEquivalentClassesAxiom(ce1, ce2);
    }

    public OWLAxiom belongsAxiom(IRI i_iri,
                                 OWLClassExpression ce){
        OWLNamedIndividual individual = dataFactory.getOWLNamedIndividual(i_iri);
        return dataFactory.getOWLClassAssertionAxiom(ce,individual);
    }
}
