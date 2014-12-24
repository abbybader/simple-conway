:- dynamic([cell/2]).

createCell(X-Y) :-
  cell(X,Y).
createCell(X-Y) :-
  assert(cell(X,Y)).

killCell(X-Y) :-
 \+ cell(X,Y).
killCell(X-Y) :-
  retractall(cell(X,Y)).

neighbors(X1,Y,X2,Y) :-
  offByOne(X1,X2).
neighbors(X,Y1,X,Y2) :-
  offByOne(Y1,Y2).
neighbors(X1,Y1,X2,Y2) :-
  offByOne(X1,X2),
  offByOne(Y1,Y2).

offByOne(I,J) :-
  J is I - 1.
offByOne(I,J) :-
 J is I + 1.

numberOfNeighbors(X,Y,N) :-
  findall(X2-Y2, ( neighbors(X,Y,X2,Y2), cell(X2,Y2)), Neighbors),
  length(Neighbors,N).

tick :-
  findall(X-Y, 
    (cell(X,Y),
    numberOfNeighbors(X,Y,N),
    \+ (N is 2; N is 3)
    ),
   ShouldDie),
  findall(X2-Y2,
  (
    cell(X1,Y1),
    neighbors(X1,Y1,X2,Y2),
    \+ cell(X2,Y2),
    numberOfNeighbors(X2,Y2,3)
  ),
  ShouldBeBorn),
  maplist(killCell, ShouldDie),
  maplist(createCell, ShouldBeBorn),
  !.

print(XMin,YMin,XMax,YMax) :-
  between(YMin,YMax,Y),
  printRow(Y,XMin,XMax),
  nl,
  fail.

printRow(Y, XMin,XMax) :-
  between(XMin,XMax, X),
  printCell(X,Y),
  fail.

printCell(X,Y) :-
  cell(X,Y),
  write('1').
printCell(X,Y) :-
  \+ cell(X,Y),
  write('0').
