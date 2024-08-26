ls( A11,A12,A13,A14,A15,A16,
    A21,A22,A23,A24,A25,A26,
    A31,A32,A33,A34,A35,A36,
    A41,A42,A43,A44,A45,A46,
    A51,A52,A53,A54,A55,A56,
    A61,A62,A63,A64,A65,A66):-
perm(A11,A12,A13,A14,A15,A16),perm(A21,A22,A23,A24,A25,A26),perm(A31,A32,A33,A34,A35,A36),perm(A41,A42,A43,A44,A45,A46),perm(A51,A52,A53,A54,A55,A56),perm(A61,A62,A63,A64,A65,A66),
perm(A11,A21,A31,A41,A51,A61),perm(A12,A22,A32,A42,A52,A62),perm(A13,A23,A33,A43,A53,A63),perm(A14,A24,A34,A44,A54,A64),perm(A15,A25,A35,A45,A55,A65),perm(A16,A26,A36,A46,A56,A66).

%prow(A11,A12,A13,A14,A15,A16),nl,prow(A21,A22,A23,A24,A25,A26),nl,prow(A31,A32,A33,A34,A35,A36),nl,prow(A41,A42,A43,A44,A45,A46),nl,prow(A51,A52,A53,A54,A55,A56),nl,prow(A61,A62,A63,A64,A65,A66),nl.
%prow(X,Y,Z,B,C,D):-write(X),write(' '),write(Y),write(' '),write(Z),write(' '),write(B),write(' '),write(C),write(' '),write(D).

%write('fim'),nl.

perm(X1, X2, X3, X4, X5, X6) :-
    neq(X1, X2, X3, X4, X5, X6).

neq(X1, X2, X3, X4, X5, X6) :-
    d(X1, X2),
    d(X1, X3),
    d(X1, X4),
    d(X1, X5),
    d(X1, X6),
    d(X2, X3),
    d(X2, X4),
    d(X2, X5),
    d(X2, X6),
    d(X3, X4),
    d(X3, X5),
    d(X3, X6),
    d(X4, X5),
    d(X4, X6),
    d(X5, X6).

d(1, 2).
d(1, 3).
d(1, 4).
d(1, 5).
d(1, 6).
d(2, 1).
d(2, 3).
d(2, 4).
d(2, 5).
d(2, 6).
d(3, 1).
d(3, 2).
d(3, 4).
d(3, 5).
d(3, 6).
d(4, 1).
d(4, 2).
d(4, 3).
d(4, 5).
d(4, 6).
d(5, 1).
d(5, 2).
d(5, 3).
d(5, 4).
d(5, 6).
d(6, 1).
d(6, 2).
d(6, 3).
d(6, 4).
d(6, 5).