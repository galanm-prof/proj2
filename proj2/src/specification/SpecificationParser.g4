// Grammar for a specification
parser grammar SpecificationParser;
options{
	tokenVocab=SpecificationLexer;
}
spec : SPEC ID vocabulary inputs outputs pairs_of_states EOF ;

vocabulary: VOCAB COLON ontologies  ;

ontologies : ID COMMA ontologies
           | ID
           ;

inputs: INPUTS COLON (iparams)?   ;

iparams : iparam COMMA iparams
        | iparam
        ;

iparam : type  ID  ;

outputs: OUTPUTS COLON (oparams)?   ;

oparams : oparam COMMA oparams
        | oparam
        ;

oparam : type ID  ;

type: ID COLON ID ;

pairs_of_states: (pair_of_states)+ ;

pair_of_states: precondition effect  ;

precondition : PRECONDITION COLON sentences ;

effect : EFFECT COLON sentences ;

sentences : sentence COMMA sentences
          | sentence
          |
          ;

sentence : set SUBCLASSOF set
         | set EQUIVALENTTO set
         | ID BELONGS set
         ;

set :  set_and OR set
    |  set_and
    ;

set_and : set_base AND set_and
        | set_base
        ;

set_base : property_set
      | neg_set
      | inv_property_set
      | class_set
      | OP set CP
      | anonymous_set
      ;

property_set : ID (MIN | EXACTLY | MAX) INT
           | ID VALUE (ID | DBL | INT | STR | T | F)
           | ID ONLY set
           | ID SOME set
           | ID SELF
           ;

neg_set : NEG set  ;

inv_property_set :  inv_property (MIN | EXACTLY | MAX) INT
               | inv_property VALUE ID
               | inv_property ONLY set1
               | inv_property SOME set1
               | inv_property SELF
               ;

inv_property : INVERSE OP (inv_property | ID) CP
          ;

class_set :  ID
          | THING
          | NOTHING
          ;


anonymous_set: OB terms CB
             ;

set1: class_set
      | OP set CP
      | OB terms CB
      ;

terms : ID COMMA terms
      | ID
      ;