expr --> termo,[+],expr.
expr --> termo,[-],expr.
expr --> termo.
termo--> fator,[*],termo.
termo--> fator,[/],termo.
termo--> fator.
fator --> [X],{integer(X)}.
fator --> ['('],expr,[')'].