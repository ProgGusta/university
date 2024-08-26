% Função de Ackerman
ackerman(0, N, Result) :- Result is N + 1.
ackerman(M, 0, Result) :- 
    M > 0,
    M1 is M - 1,
    ackerman(M1, 1, Result).
ackerman(M, N, Result) :- 
    M > 0,
    N > 0,
    M1 is M - 1,
    N1 is N - 1,
    ackerman(M, N1, TempResult),
    ackerman(M1, TempResult, Result).

% Consultar com algo como:
% ?- ackerman(2, 3, Result).
% Result = 9.