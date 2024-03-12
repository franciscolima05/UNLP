program ejercicio;
const
	LIM = 300;
type
	oficina = record
		code : integer;
		dni : integer;
		valor : real;
		end;
		
		
	vec = array[1..LIM] of oficina;
	
	
procedure leer(var o : oficina);
begin
	writeln('ingresa codigo de oficina: ');
	readln(o.code);
	o.dni := random(20)+ 1;
	o.valor := random(999) + 1000;
end;


procedure cargarvector(var v : vec; var diml : integer);
var
	o : oficina;
begin
	leer(o);//cuidado con esto
	while(diml < LIM) and(o.code <> -1) do
		begin
			diml := diml + 1;
			v[diml] := o;
			leer(o);
		end;
end;

procedure imprimirvector(v : vec; diml : integer);
var
	i : integer;
begin
	for i := 1 to diml do
		begin
			writeln(v[i].code);
			writeln(v[i].dni);
			writeln(v[i].valor:0:2);
		end;
end;

procedure seleccion(var v : vec; diml : integer);
var
	i, j, pos : integer;
	act : oficina;
begin
	for i := 1 to diml -1 do
		begin
			pos := i;
			for j := i + 1 to diml do
				begin
					if(v[pos].code > v[j].code)then
						pos := j;
				end;
			act := v[pos];
			v[pos] := v[i];
			v[i] := act;
		end;
end;
		
		
function busquedaDicotomica(v : vec; diml : integer; ini, fin, codigo : integer) : integer;
var
	med : integer;
begin
	med := (ini + fin) div 2;
	if(ini <= fin) and (codigo <> v[med].code) then
		begin
			if(codigo > v[med].code) then
				begin
					ini := med;
					busquedadicotomica := busquedadicotomica(v, diml, ini, fin, codigo);
				end
			else
				if(codigo < v[med].code) then
					begin
						fin := med;
						busquedadicotomica := busquedadicotomica(v, diml, ini, fin, codigo);
					end;
		end;
		if(ini <= fin) and(codigo = v[med].code)then
		    begin
			    writeln('el dni de la oficina con codigo ',codigo,' es ',v[med].dni);
				busquedadicotomica := med;
			end
end;

             
Function existe (v : vec; dL:integer; valor:integer): integer;
Var
    pos, pri, ult, medio : integer;
Begin
   pos := 0;
    pri:= 1 ; ult:= dL; medio := (pri + ult) div 2 ;
    While (pri <= ult) and ( valor <> v[medio].code) do
        begin
            if ( valor < v[medio].code ) then
                ult := medio -1
            else 
                pri := medio + 1;
            medio := ( pri + ult ) div 2 ;
        end;
    if (pri <=ult) and (valor = v[medio].code) then pos := medio;
    existe := pos;
end;
    
    

function totalmonto(v : vec; diml : integer): real;
begin
    if(diml > 0) then
    	begin
    		totalmonto := totalmonto(v, diml-1) + v[diml].valor;
    	end;
end;


var
	v : vec;
	aux,ini, fin, pos, codigo, diml : integer;
begin
	cargarvector(v, diml);
	imprimirvector(v, diml);
	seleccion(v, diml);
	imprimirvector(v, diml);
	ini := 1;
	fin := diml;
	writeln('ingrese codigo a buscar: ');
	readln(codigo);
    aux := existe(v, diml, codigo);
    if(aux = 0) then
        writeln('no se encontro')
    else
        writeln('el dni de la oficina con codigo ', codigo,' es ',v[aux].dni);
    writeln('todo lo gastado fue: ', totalmonto(v, diml):0:2);
end.




