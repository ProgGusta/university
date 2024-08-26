expr --> term,rexpr.
rexpr --> [+],expr, {write('y=POP(); x=POP(); PUSH(x ADD y)'),nl}.
rexpr --> [-],expr, {write('y=POP(); x=POP(); PUSH(x SUB y)'),nl}.
rexpr --> [].
term--> factor,rterm.
rterm--> [*],term, {write('y=POP(); x=POP(); PUSH(x MUL y)'),nl}.
rterm--> [/],term, {write('y=POP(); x=POP(); PUSH(x DIV y)'),nl}.
rterm--> [].
factor --> [X],{integer(X)},{write('PUSH('),write(X), write(')'), nl}.
factor --> ['('], expr, [')'].