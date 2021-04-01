grammar myGrammar;

comm: action ' ' DOUBLE ' ' DOUBLE;

action : 'draw' | 'delete';
DOUBLE: '1'..'9'('0'..'9')*'.'('0'..'9')*;
