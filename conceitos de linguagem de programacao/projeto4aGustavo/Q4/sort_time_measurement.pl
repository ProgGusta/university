:- use_module(library(random)).
:- use_module(library(statistics)).

generate_list(Size, List) :-
    findall(X, (between(1, Size, _), random(0, 10000, X)), List).

measure_sort_time(SortPredicate, List, Time) :-
    statistics(runtime, [Start|_]),
    call(SortPredicate, List, _),
    statistics(runtime, [End|_]),
    Time is (End - Start) / 1000.

write_results(Size, Time1, Time2, Time3, Time4) :-
    open('prolog_sort_times.csv', append, Stream),
    format(Stream, '~w,~2f,~2f,~2f,~2f~n', [Size, Time1, Time2, Time3, Time4]),
    close(Stream).

insertion_sort([], []).
insertion_sort([H|T], Sorted) :-
    insertion_sort(T, SortedTail),
    insert(H, SortedTail, Sorted).

insert(X, [Y|T], [Y|NT]) :-
    X > Y,
    insert(X, T, NT).
insert(X, [Y|T], [X,Y|T]) :-
    X =< Y.
insert(X, [], [X]).

bubble_sort(List, Sorted) :-
    swap(List, List1), !,
    bubble_sort(List1, Sorted).
bubble_sort(Sorted, Sorted).

swap([X,Y|T], [Y,X|T]) :-
    X > Y.
swap([Z|T], [Z|T1]) :-
    swap(T, T1).

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
divide([A,B|T], [A|T1], [B|T2]) :-
    divide(T, T1, T2).

merge([], L, L).
merge(L, [], L).
merge([A|T1], [B|T2], [A|T]) :-
    A =< B,
    merge(T1, [B|T2], T).
merge([A|T1], [B|T2], [B|T]) :-
    A > B,
    merge([A|T1], T2, T).

quick_sort([], []).
quick_sort([H|T], Sorted) :-
    partition(H, T, L1, L2),
    quick_sort(L1, Sorted1),
    quick_sort(L2, Sorted2),
    append(Sorted1, [H|Sorted2], Sorted).

partition(_, [], [], []).
partition(H, [A|T], [A|L], G) :-
    A =< H,
    partition(H, T, L, G).
partition(H, [A|T], L, [A|G]) :-
    A > H,
    partition(H, T, L, G).

main :-
    ListSizes = [10, 100, 1000, 10000],
    forall(member(Size, ListSizes), (
        generate_list(Size, List),
        measure_sort_time(insertion_sort, List, Time1),
        measure_sort_time(bubble_sort, List, Time2),
        measure_sort_time(merge_sort, List, Time3),
        measure_sort_time(quick_sort, List, Time4),
        write_results(Size, Time1, Time2, Time3, Time4)
    )),
    halt.
