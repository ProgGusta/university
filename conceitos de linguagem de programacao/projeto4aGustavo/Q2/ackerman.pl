:- use_module(library(statistics)).

ackerman(0, N, Result) :- Result is N + 1.
ackerman(M, 0, Result) :- M > 0, M1 is M - 1, ackerman(M1, 1, Result).
ackerman(M, N, Result) :-
    M > 0, N > 0, 
    M1 is M - 1, N1 is N - 1,
    ackerman(M, N1, R1), ackerman(M1, R1, Result).

main :-
    open('prolog_ackerman_times.csv', write, Stream),
    write(Stream, 'm,n,time\n'),
    forall(between(0, 3, M),
           forall(between(0, 3, N),
                  (   statistics(runtime, [T0|_]),
                      ackerman(M, N, _),
                      statistics(runtime, [T1|_]),
                      Time is (T1 - T0) / 1000,
                      format(Stream, '~d,~d,~f\n', [M, N, Time])
                  ))),
    close(Stream).

:- main.
