program ej4;
const
	lim = 5;
type
	
	vec = array[1..lim] of integer;
	
procedure cargarvector(var v : vec; var diml : integer);
var
	num : integer;
begin
	if(diml < lim) then
		begin
			writeln('ingrese numero');
			readln(num);
			diml := diml + 1;
			v[diml] := num;
			cargarvector(v, diml);
		end;
end;

procedure imprimir(v : vec; diml : integer);
begin
	if(diml>0)then	
		begin
			imprimir(v, diml - 1);
			writeln (v[diml]);
		end;
end;
	

function maximo2(v : vec; diml : integer; max : integer) : integer;
begin
    if(diml > 0)then
        begin
            if(v[diml] > max)then
                begin
                    max:= v[diml];
                end;
            maximo2 := maximo2(v, diml -1, max);
        end
    else    
        maximo2:= max;
end;


function suma(v : vec; diml : integer; total : integer) : integer;
begin
	if(diml > 0)then
		begin
			total := v[diml] + total;
			suma := suma(v, diml -1, total);
		end
	else    
	    suma := total;
end;

var
	v : vec;
	max, diml, total : integer;
begin
    max := -9;
	diml := 0;
	total := 0;
	Randomize;
	cargarvector(v, diml);
	imprimir(v, diml);
	writeln('numero mas grande es: ',maximo2(v, diml, max));
	writeln('la suma da como resultado: ',suma(v, diml, total));
end.
	
