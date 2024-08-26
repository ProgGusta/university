% factorial(N,M) holds when M=Nx(N-1)x...x2x1.
factorial(1,1).
factorial(N,M) :- N > 1, N1 is N-1, factorial(N1,K), M is N*K.

test_factorial(N) :-
    get_time(T1),
    factorial(N, _),
    get_time(T2),
    Time is T2 - T1, 
    format('Tempo de execução para ~w! : ~w segundos.~n', [N, Time]),
    Time < 60.

loop_factorial(N) :-
    test_factorial(N),
    N1 is N + 1,
    loop_factorial(N1).

loop_factorial(N) :-
    \+ test_factorial(N).