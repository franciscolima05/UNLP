program ej3;
const
	lim = 10;
type
	lis = ^nodo;
	
	nodo = record
		num : integer;
		sig : lis;
		end;
	
	
procedure agregar(var l : lis; elem : integer);
var
	aux : lis;
begin
	new(aux); aux^.sig := nil; aux^.num := elem;
	if(l = nil) then
		l := aux
	else
		begin
			aux^.sig := l;
			l := aux;
		end;
end;
	
	
procedure generarlista(var l : lis);
var
	num : integer;
begin
	num := random(101);
	if(num <> 0) then
		begin
			agregar(l, num);
			generarlista(l);
		end;
end;

procedure minimo(l : lis; var min : integer);
begin
	if(l <> nil) then
		begin
			if(l^.num < min) then
				min := l^.num;
			minimo(l^.sig, min);
		end;
end;

procedure maximo(l : lis; var max : integer);
begin
	if(l <> nil) then
		begin
			if(l^.num > max) then
				max := l^.num;
			maximo(l^.sig, max);
		end;
end;



function buscar(l : lis; num : integer): boolean;
begin
	if (l = nil) then
		buscar := false
	else
		if(l^.num = num) then
			buscar := true
		else
			buscar := buscar(l^.sig, num);
end;

procedure imprimir(l : lis);
begin
    if (l<>nil) then
        begin
            writeln(l^.num);
            imprimir(l^.sig);
        end;
end;
        

var
	l : lis;
	max, min,num : integer;
begin
	max := -999;
	min := 999;
	Randomize;
	new(l);
	generarlista(l);
	maximo(l, max);
	minimo(l, min);
	imprimir(l);
	writeln('el numero mas chico es ', min);
	writeln('el numero mas grande es ', max);
	writeln('ingrese numero a buscar');
	readln(num);
	writeln(buscar(l, num));
end.

















