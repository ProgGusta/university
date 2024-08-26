ls( A11,A12,A13,A14,A15,
    A21,A22,A23,A24,A25,
    A31,A32,A33,A34,A35,
    A41,A42,A43,A44,A45,
    A51,A52,A53,A54,A55):-
perm(A11,A12,A13,A14,A15),perm(A21,A22,A23,A24,A25),perm(A31,A32,A33,A34,A35),perm(A41,A42,A43,A44,A45),perm(A51,A52,A53,A54,A55),
perm(A11,A21,A31,A41,A51),perm(A12,A22,A32,A42,A52),perm(A13,A23,A33,A43,A53),perm(A14,A24,A34,A44,A54),perm(A15,A25,A35,A45,A55).

%prow(A11,A12,A13,A14,15),nl,prow(A21,A22,A23,A24,A25),nl,prow(A31,A32,A33,A34,A35),nl,prow(A41,A42,A43,A44,A45),nl,prow(A51,A52,A53,A54,A55),nl.
%prow(X,Y,Z,B,C):-write(X),write(' '),write(Y),write(' '),write(Z),write(' '),write(B),write(' '),write(C).

%write('fim'),nl.

perm(X1, X2, X3, X4, X5) :-
    neq(X1, X2, X3, X4, X5).

neq(X1, X2, X3, X4, X5) :-
    d(X1, X2),
    d(X1, X3),
    d(X1, X4),
    d(X1, X5),
    d(X2, X3),
    d(X2, X4),
    d(X2, X5),
    d(X3, X4),
    d(X3, X5),
    d(X4, X5).

d(1, 2).
d(1, 3).
d(1, 4).
d(1, 5).
d(2, 1).
d(2, 3).
d(2, 4).
d(2, 5).
d(3, 1).
d(3, 2).
d(3, 4).
d(3, 5).
d(4, 1).
d(4, 2).
d(4, 3).
d(4, 5).
d(5, 1).
d(5, 2).
d(5, 3).
d(5, 4).