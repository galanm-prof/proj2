// Lexical Analyzer (predicate)
lexer grammar PredicateLexer;

NUMBERINFORMATIONSPACESTRONGSETS: 'numberInformationSpaceStrongSets';
NUMBERINFORMATIONSPACEWEAKSETS: 'numberInformationSpaceWeakSets';
NUMBERSTATESPACESTRONGSETS: 'numberStateSpaceStrongSets';
NUMBERSTATESPACEWEAKSETS: 'numberStateSpaceWeakSets';
MEANSIZEINFORMATIONSPACESTRONGSETS:'meanSizeInformationSpaceStrongSets';
MEANSIZEINFORMATIONSPACESTRONGSETSMAX:'meanSizeInformationSpaceStrongSetsMax';
MEANSIZEINFORMATIONSPACEWEAKSETS:'meanSizeInformationSpaceWeakSets';
MEANSIZEINFORMATIONSPACEWEAKSETSMAX:'meanSizeInformationSpaceWeakSetsMax';
MEANSIZESTATESPACESTRONGSETS:'meanSizeStateSpaceStrongSets';
MEANSIZESTATESPACESTRONGSETSMAX:'meanSizeStateSpaceStrongSetsMax';
MEANSIZESTATESPACEWEAKSETS:'meanSizeStateSpaceWeakSets';
MEANSIZESTATESPACEWEAKSETSMAX:'meanSizeStateSpaceWeakSetsMax';
MEANRELATIVESIZEINFORMATIONSPACESTRONGSETS:'meanRelativeSizeInformationSpaceStrongSets';
MEANRELATIVESIZEINFORMATIONSPACESTRONGSETSMAX:'meanRelativeSizeInformationSpaceStrongSetsMax';
MEANRELATIVESIZEINFORMATIONSPACEWEAKSETS:'meanRelativeSizeInformationSpaceWeakSets';
MEANRELATIVESIZEINFORMATIONSPACEWEAKSETSMAX:'meanRelativeSizeInformationSpaceWeakSetsMax';
MEANRELATIVESIZESTATESPACESTRONGSETS:'meanRelativeSizeStateSpaceStrongSets';
MEANRELATIVESIZESTATESPACESTRONGSETSMAX:'meanRelativeSizeStateSpaceStrongSetsMax';
MEANRELATIVESIZESTATESPACEWEAKSETS:'meanRelativeSizeStateSpaceWeakSets';
MEANRELATIVESIZESTATESPACEWEAKSETSMAX:'meanRelativeSizeStateSpaceWeakSetsMax';
TRUE:'true';

OR:'or';
AND:'and';
NEG:'not';

OP:'(';
CP:')';
COMMA: ',';

BLANK : ' ' ->skip;
TAB : '\t'->skip;
NL: '\r'?'\n' ->skip;

LETTER: 'a'..'z'|'A'..'Z';
DIGIT: '0'..'9';
UNDERLINE: '_';
MINUS:'-';
DOT:'.';

DBL: (DIGIT)+ DOT (DIGIT)* | DOT (DIGIT)+ ;
INT: (DIGIT)+ ;

LINECOMMENTARY  :  '//' .*? NL -> skip ;
BLOCKCOMMENTARY : '/*' .*? '*/' -> skip ;
