program ej1;
type
	socio = record
		nombre : string;
		edad : integer;
		num : integer;
		end;
		
	arb = ^nodo;
	
	nodo = record
		s : socio;
		hi : arb;
		hd : arb;
		end;
		
procedure cargararbol(var a : arb; soc : socio);
begin
	if(a = nil) then
		begin
			new(a); 
			a^.hi := nil; a^.hd := nil;
		end;
	else
		if(soc.num > a^.s.num) then
			cargararbol(a^.hd, soc);
		else
			cargararbol(a^.hi, soc);
end;


procedure maximo(a : arb; var max : integer);
begin
	if (a <> nil) then
		begin
			if(a^.s.num > max) then
				begin
					max := a^.s.num;
					maximo(a^.hd);
				end;
		end;
end;

procedure minimo(a : arb; var min : socio);
begin
	if (a <> nil) then
		begin
			if(a^.s.num < min.num) then
				begin
					min := a^.s.;
					minimo(a^.hi);
				end;
		end;
end;


procedure masedad(a : arb; var edadmax: integer);
begin
	if (a <> nil) then
		begin
			if(a^.s.edad > edadmax) then
				begin
					edadmax := a^.s.edad;
					masedad := (a^.hd, edadmax);
					masedad := (a^.hi, edadmax);
				end;
		end;
end;


procedure aumentar(a : arb);
begin
	if(a <> nil) then
		begin
			a^.s.edad := a^.s.edad = 1;
			aumentar(a^.hi);
			aumentar(a^.hd);
		end;
end;


function esta(a : arb; dato : integer) : boolean
begin
	if(a <> nil) then
		if(a^.s.num = dato) then
			function := true;
		else
			begin
				esta(a^.hi, dato);
				esta(a^.hd, dato);
			end;
	else
		esta := false;
end;

	
	
function nombreesta(a : arb; dato : string) : boolean
begin
	if(a <> nil) then
		if(a^.s.nombre = dato) then
			function := true;
		else
			begin
				nombreesta(a^.hi, nombre);
				nombreesta(a^.hd, nombre);
			end;
	else
		nombreesta := false;
end;

	
function cantidadsocios(a : arb; total : integer) : integer;
begin
	if(a<>nil) then
		begin
			total := total + 1;
			cantidadsocios(a^.hi, total);
			cantidadsocios(a^.hd, total);
		end;
	cantidadsocios := total;
end;

function edadtotal(a : arb; total : integer) : integer;
begin
	if(a<>nil) then
		begin
			total := a^.s.edad + total;
			edadtotal(a^.hi, total);
			edadtotal(a^.hd, total);
		end;
	edadtotal := total;
end;
	
	
procedure edadsocios(a : arb; prom : real);
var
	total, cant : integer;
	
begin
	cantidadsocios(a, cant);
	edadtotal(a, total);
	edadsocios(total / cant);
end;


function dosvalores(num1, num2, dato : integer) : boolean;
var
	aux : integer;
begin
	if(num1 > num2) then
		begin
			num1 := aux;
			num1 := num2;
			num2 := num1;
		end;
	if(dato >= num1) and (dato <= num2) then
		dosvalores := true;
	else
		dosvalores := false;
end;


function entredosvalores(a : arb; num1, num2, cant : integer);
begin
	if(a<>nil) then
		begin
			if(dosvalores(num1, num2, a^.s.num) then
				cant := cant + 1;
			entredosvalores(a^.hi, num1, num2, cant);
			entredosvalores(a^.hd, num1, num2, cant);
		end;
	entredosvalores := cant;
end;

procedure preorden(a : arb);
begin
    if(a <> nil) then  
        begin
        writeln(a^.s.num);
        preorden(a^.hi);
        preorden(a^.hd);
        end;
end;

procedure postorden(a : arb);
begin
    if(a <> nil) then  
        begin
        postorden(a^.hi);
        postorden(a^.hd);
        writeln(a^.s.num);
        end;
end;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	






