prg
type
	producto = record
		cant : integer;
		monto : real;
		codep : integer;
		end;
		
	venta = record
		code : integer;
		codep: integer;
		cant : integer;
		precio : real;
		end;
		
	arb = ^nodo
	
	nodo = record
		p : producto;
		hi : arb;
		hd : arb;
		end;
		
procedure leer(var v : venta);
begin
	readln(v.code);
	read(v.codep);
	read(v.cant);
	read(v.precio);
end;


procedure agregar(var a : arb; elem : venta);
Var
	aux : producto
begin
	aux.cant := elem.cant;
	aux.codep := elem.codep;
	aux.monto := elem.precio *elem.cant;
	if(a = nil) then
		begin
			new(a); a^.hi := nil, a^.hd := nil; a^.p := aux;
		end;
	else
		if(elem.code = a^.p.code) then
			begin
				a^.p.cant := a^.p.cant + aux.cant;
				a^.p.monto := aux.monto
		if(elem.code < a^.p.code) then
			agregar(a^.hi, elem);
		else
			agregar(a^.hd, elem);
end;
	



procedure cargararbol(var a : arb);
var
	aux : venta;
begin
	leer(aux);
	if(aux.code <> -1) then
		begin
			agregar(a, aux);
			leer(aux);
			cargararbol(a);
		end;
end;


procedure preorden(a : arb);
begin
	if(a <> nil) then
		begin
			writeln(a^.p.cant);
			writeln(a^.p.monto);
			writeln(a^.p.codep);
			preorden(a^.hi);
			preorden(a^.hd);
		end;
end;


function maximo(num1, num2): integer;
begin
	if (a = nil) then
		maximo := -1;
	else
		if(a^.p.ca
end;

procedure maxproducto(a : arb; var max : integer; var codemax : integer);
begin
	if(a <> nil) then
		begin
			maxproducto(a^.hi, max, codemax);
			maxproducto(a^.hd, max, codemax);
			if(a^.p.cant > max) then
				begin
					codemax := a^.p.code;
					max := a^.p.cant;
				end;
		end;
	else
		maxproducto := -1;
end;


procedure menores(a : arb; var cant : integer; code : integer) : integer;
begin
	if(a <> nil) then
		begin
			if(a^.p.code < code) then
				begin
					cant := cant + 1;
					menores(a^.hi, cant, code);
					menores(a^.hd, cant, code);
				end;
			else
				menores(a^.hi, cant, code);
		end;
end;


function estaenrango(num1, rango1, rango2 : integer) : boolean
begin
	if(num1 > rango1) and (num1 < rango2) then
		estaenrango := true;
	else
		estaenrango := false;
end;
		
		
procedure rango (a : arb; num1, num2 : integer; var montototal: real);
begin
	if(a <> nil) then
		begin
			if(estaenrango(a^.p.code, num1, num2)) then
				begin
					montotal := montototal + a^.p.monto;
					rango(a^.hi, num1, num2, montotal);
					rango(a^.hd, num1, num2, montotal);
				end
			else
				begin
					if(num1 > a^.p.code) then
						rango(a^.hd, num1, num2, montotal)
					else
						if(num2 < a^.p.code) then
							rango(a^.hi, num1, num2, montotal);
				end;
		end;
end;


function rango2(a : arb, num1, num2): real
begin
	if(a <> nil) then
		begin
			if(estaenrango(a^.p.code, num1, num2) then
				begin
					rango2 := rango2(a^.hd, num1, num2) + rango2(a^.hi, num1, num2) + a^.p.monto;
				end
			else
				if(num1 > a^.p.code) then
						rango := rango(a^.hd, num1, num2)
				else
					if(num2 < a^.p.code) then
						rango := rango(a^.hi, num1, num2);
		end;
	else
		rango2 := 0;
end;

var
	a : arb;
	cant, code, max, codemax, num1, num2 : integer;
begin
	cargararbol(a);
	preorden(a);
	max := -1;
	codemax := 0;
	maxproducto(a, max, codemax);
	cant := 0;
	code := 5;
	menores(a, cant, code);
	num1 := 3;
	num2 := 7;
	writeln(rango2(a, num1, num2));
end:
	
		
			
		
	
	
		




