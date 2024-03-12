program ej1;
const
	lim = 10;
type
	vec = array[1..lim] of char;
	
	lis = ^nodo;
	
	nodo = record
	    car : char;
	    sig : lis;
	    end;
	
procedure cargarvector(var v : vec; var diml : integer);
var
	aux : char;
begin
	if(diml < lim) then
		begin
			writeln('ingrese carac.');
			readln(aux);
			if(aux <> '.') then
				begin
				    diml := diml + 1;
					v[diml] :=aux;
					cargarvector(v, diml);
				end;
		end;
end;


procedure imprimir (v : vec; diml : integer);
begin
	if(diml > 0) then
		begin   
			imprimir(v, diml - 1);
			write(v[diml]);
		end;
end;

procedure retornarcant (var cont : integer);
var
	aux : char;
begin
	writeln('ingrese una cadena');
	readln(aux);
	if(aux  <> '.') then
	    begin
		    cont := cont + 1;
		    retornarcant(cont);
		end;
end;


procedure agregar(var l : lis ; elem : char);
var
	aux : lis;
begin
	new(aux); aux^.sig := nil; aux^.car := elem;
	if (l = nil) then
		    l := aux
    else    
        begin
            aux^.sig := l;
            l:= aux;
        end;
end;
	
	
procedure lista(var l : lis);
var
	aux : char;
begin
	writeln('ingrese cadena');
	readln(aux);
	if(aux <> '.') then
		begin
			agregar(l, aux);
			lista(l);
		end;
end;
		
procedure imprimirlista(l : lis);
begin
    if(l <> nil) then   
        begin
            imprimirlista(l^.sig);
            writeln(l^.car);
        end;
end;

procedure imprimirlistanverso(l : lis);
begin
    if(l <> nil) then   
        begin
            writeln(l^.car);
            imprimirlista(l^.sig);
        end;
end;
       
        
	

var
    v : vec;
    cont, diml : integer;
    l : lis;
begin
    lista(l);
    imprimirlista(l);
end.
		








	
