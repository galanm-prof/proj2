package common;

import org.semanticweb.owlapi.model.IRI;

import java.util.HashMap;
import java.util.Map;

public class Entities {
    private Map<String,IRI>classes;
    private Map<String,IRI>objectProperties;
    private Map<String,IRI>datatypeProperties;
    private Map<String, IRI> individuals;

    public Entities(){
        this.classes=new HashMap<>();
        this.objectProperties=new HashMap<>();
        this.datatypeProperties=new HashMap<>();
        this.individuals=new HashMap<>();
    }

    public void addClass(String shortName, IRI classIRI){
        classes.put(shortName,classIRI);
    }

    public void addObjectProperty(String shortName, IRI objectPropertyIRI){
        objectProperties.put(shortName,objectPropertyIRI);
    }

    public void addDatatypeProperty(String shortName, IRI datatypePropertyIRI){
        datatypeProperties.put(shortName,datatypePropertyIRI);
    }

    public void addIndividual(String shortName, IRI individualIRI){

        individuals.put(shortName,individualIRI);
    }

    public boolean containsClass(String shortName){
        return classes.containsKey(shortName);
    }

    public boolean containsObjectProperty(String shortName){
        return objectProperties.containsKey(shortName);
    }
    public boolean containsDatatypeProperty(String shortName){
        return datatypeProperties.containsKey(shortName);
    }
    public boolean containsIndividual(String shortName){
        return individuals.containsKey(shortName);
    }

    public Map<String,IRI>getClasses(){
        return this.classes;
    }
    public Map<String,IRI>getObjectProperties(){
        return this.objectProperties;
    }
    public Map<String,IRI>getDatatypeProperties(){
        return this.datatypeProperties;
    }

    public Map<String,IRI>getIndividuals(){
        return this.individuals;
    }

    public void showClasses(){
        System.out.println("Classes: ");
        this.classes.entrySet().stream().forEach(e->System.out.println("   "+e));
    }
    public void showObjectProperties(){
        System.out.println("Object properties: ");
        this.objectProperties.entrySet().stream().forEach(e->System.out.println("   "+e));
    }
    public void showDatatypeProperties(){
        System.out.println("Datatype properties: ");
        this.datatypeProperties.entrySet().stream().forEach(e->System.out.println("   "+e));
    }
    public void showIndividuals(){
        System.out.println("Individuals: ");
        this.individuals.entrySet().stream().forEach(e->System.out.println("   "+e));
    }

}
