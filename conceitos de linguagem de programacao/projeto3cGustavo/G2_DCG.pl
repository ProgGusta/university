expr(E)--> termo(T),[+],expr(E1), {E is T+E1}.
expr(E)--> termo(T),[-],expr(E1), {E is T-E1}.
expr(T)--> termo(T).
termo(T)--> fator(F),[*],termo(T1),{T is F*T1}.
termo(T)--> fator(F),[/],termo(T1),{T is F/T1}.
termo(F)--> fator(F).
fator(X)--> [X],{integer(X)}.
fator(E)--> ['('], expr(E), [')'].