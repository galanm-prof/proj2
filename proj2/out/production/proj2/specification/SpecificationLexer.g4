// Lexical Analyzer (specification)

lexer grammar SpecificationLexer;

SPEC:'spec';
VOCAB:'Vocabulary';
INPUTS:'Inputs';
OUTPUTS:'Outputs';
PRECONDITION: 'Precondition';
EFFECT: 'Effect';

SUBCLASSOF:'subclassOf';
EQUIVALENTTO:'equivalentTo';
STRICTSUBCLASSOF:'strictSubclassOf';
INTERSECTS:'intersects';
DISJOINTWITH:'disjointWith';
SAT:'satisfiable';
UNSAT:'unsatisfiable';
BELONGS:'belongs';
	
OR:'or';
AND:'and';
NEG:'not';

T:'true';
F:'false';

MIN:'min';
EXACTLY:'exactly';
MAX:'max';

VALUE:'value';
SOME:'some';
ONLY:'only';
SELF:'self';

INVERSE:'inverse';

THING:'Thing';
NOTHING:'NoThing';

OP:'(';
CP:')';
OB:'{';
CB:'}';
COMMA:',';
COLON:':';

fragment LETTER: 'a'..'z'|'A'..'Z';
fragment DIGIT: '0'..'9';
fragment UNDERLINE: '_';
fragment MINUS:'-';
fragment DOT:'.';

BLANK : ' ' ->skip;
TAB : '\t'->skip;
NL: '\r'?'\n' ->skip;

ID: (LETTER|UNDERLINE)(LETTER|DIGIT|UNDERLINE|MINUS)*  ;

DBL: (DIGIT)+ DOT (DIGIT)* | DOT (DIGIT)+ ;
INT: (DIGIT)+ ;



STR:  '"' .*? '"'   ;
   
LINECOMMENTARY  :  '//' .*? NL -> skip ;