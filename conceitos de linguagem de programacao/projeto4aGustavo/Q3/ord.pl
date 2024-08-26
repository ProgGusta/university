insertion_sort(List, Sorted) :- i_sort(List, [], Sorted).
i_sort([], Acc, Acc).
i_sort([H|T], Acc, Sorted) :- insert(H, Acc, NAcc), i_sort(T, NAcc, Sorted).

insert(X, [Y|T], [Y|NT]) :- X > Y, insert(X, T, NT).
insert(X, [Y|T], [X,Y|T]) :- X =< Y.
insert(X, [], [X]).



bubble_sort(List, Sorted) :- b_sort(List, [], Sorted).
b_sort([], Acc, Acc).
b_sort([H|T], Acc, Sorted) :- bubble(H, T, NT, Max), b_sort(NT, [Max|Acc], Sorted).

bubble(X, [], [], X).
bubble(X, [Y|T], [Y|NT], Max) :- X > Y, bubble(X, T, NT, Max).
bubble(X, [Y|T], [X|NT], Max) :- X =< Y, bubble(Y, T, NT, Max).



merge_sort([], []).
merge_sort([A], [A]).
merge_sort(List, Sorted) :-
    List = [_,_|_],
    divide(List, L1, L2),
    merge_sort(L1, Sorted1),
    merge_sort(L2, Sorted2),
    merge(Sorted1, Sorted2, Sorted).

divide([], [], []).
divide([A], [A], []).
divide([A,B|T], [A|T1], [B|T2]) :- divide(T, T1, T2).

merge([], L, L).
merge(L, [], L).
merge([A|T1], [B|T2], [A|T]) :- A =< B, merge(T1, [B|T2], T).
merge([A|T1], [B|T2], [B|T]) :- A > B, merge([A|T1], T2, T).



quick_sort([], []).
quick_sort([H|T], Sorted) :-
    partition(H, T, L, G),
    quick_sort(L, SortedL),
    quick_sort(G, SortedG),
    append(SortedL, [H|SortedG], Sorted).

partition(_, [], [], []).
partition(H, [X|T], [X|L], G) :- X =< H, partition(H, T, L, G).
partition(H, [X|T], L, [X|G]) :- X > H, partition(H, T, L, G).
