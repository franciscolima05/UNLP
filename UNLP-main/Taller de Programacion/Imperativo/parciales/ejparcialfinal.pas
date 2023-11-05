program ejparcial6;
type

	DIA = 1..31;

	venta = record
		fecha : DIA;
		code : integer;
		cant : integer;
		monto : real;
		end;
		
		
	ventalista = record
		fecha : DIA;
		monto : real;
		cant : integer;
		end;
		
	lis = ^nodolista;
	
	nodolista = record
		dato : ventalista;
		sig : lis;
		end;
	
	arb = ^nodo;
	
	nodo = record
		code : integer;
		cant : integer;
		l : lis;
		hi : arb;
		hd : arb;
		end;
		
	
procedure leer(var v : venta);
begin
	{writeln('ingrese codigo: ');
	readln(v.code);}
	v.code := random(20) - 1;
	if(v.code > -1) then
		begin
			v.cant := random(100) + 1;
			v.monto := random(1000) + 10.50;
			v.fecha := random(31) + 1;
		end;
end;

procedure agregaradelante(var l : lis; elem : ventalista);
var
	aux : lis;
begin
	new(aux); aux^.sig := nil; aux^.dato := elem;
	if(l = nil) then
		l := aux
	else
		begin
			aux^.sig := l;
			l := aux;
		end;
end;


procedure agregarnodo(var a : arb; v : venta);
var
	vl : ventalista;
begin
	if(a = nil) then
		begin	
			vl.fecha := v.fecha;
			vl. monto := v.monto;
			vl.cant := v.cant;
			new(a); a^.hi := nil; a^.hd := nil; a^.l := nil;a^.code := v.code; a^.cant :=0;
			agregaradelante(a^.l, vl);
		end
	else
		begin
			if(v.code > a^.code)then
				agregarnodo(a^.hd, v)
			else
				agregarnodo(a^.hi, v);
		end;
end;

procedure buscar(a : arb; var ok : boolean; var nodo : arb; code : integer);
begin
	if(a <> nil) then
		begin
			if(a^.code = code) then
				begin
					ok := true;
					nodo := a;
				end
			else
				begin
					if(code > a^.code) then
						buscar(a^.hd, ok ,nodo, code)
					else
						buscar(a^.hi, ok, nodo, code);
				end;
		end
	else
		begin
			ok := false;
			nodo := nil;
		end;
end;

procedure cargararbol(var a : arb; v : venta);
var
	ok : boolean;
	nodo : arb;
	vl : ventalista;
begin
	buscar(a, ok ,nodo, v.code);
	if(ok)then
		begin
			vl.fecha := v.fecha;
			vl. monto := v.monto;
			vl.cant := v.cant;
			agregaradelante(nodo^.l, vl);
		end
	else
		agregarnodo(a, v);
end;

function listacant(l : lis) : integer;
var
	cant : integer;
begin
	cant := 0;
	while(l <> nil) do
		begin
			cant := cant + l^.dato.cant;
			l := l^.sig;
		end;
	listacant := cant;
end;
			

procedure cantarbol(var a : arb);
begin
	if(a <> nil) then
		begin
			a^.cant := listacant(a^.l);
			cantarbol(a^.hi);
			cantarbol(a^.hd);
		end;
end;
			

procedure cargartodo(var a : arb);
var
	v : venta;
begin
	leer(v);
	if(v.code <> -1)then
		begin
			cargararbol(a,v);
			cargartodo(a);
		end;
	cantarbol(a);
end;

procedure imprimirlista(l : lis);
begin
	while(l <> nil) do
		begin
			writeln(l^.dato.monto:0:2);
			writeln(l^.dato.cant);
			l := l^.sig;
		end;
end;

			

procedure imprimirarbol(a : arb);
begin
	if(a <> nil) then
		begin
			imprimirarbol(a^.hi);
			writeln('el codigo de producto es: ',a^.code);
			writeln('el cantidad de producto vendida es: ',a^.cant);
			imprimirlista(a^.l);
			imprimirarbol(a^.hd);
		end;
end;

{function mascantidad(a : arb; cant : integer) : integer;//defectuosa
begin
	if(a <> nil) then
		begin
			if(a^.cant > cant) then
				mascantidad := mascantidad(a^.hd, cant) + mascantidad(a^.hi, cant) + 1;
		end
	else
		mascantidad := 0;
end;}

procedure mascantidad2(a : arb; var cant : integer; cantmax : integer);
begin
    if(a <> nil) then
        begin
            if(a^.cant > cantmax) then
                cant := cant +1;
            mascantidad2(a^.hd, cant, cantmax);
            mascantidad2(a^.hi, cant, cantmax);
        end;
end;
                    

var
	a : arb;
	cm, cant : integer;
begin
    a := nil;
    cant := 80;
    randomize;
	cargarTodo(a);
	imprimirarbol(a);
	mascantidad2(a, cm, cant);
	writeln('la cantidad de productos que vendieron mas de ', cant,' unidades fueron ',cm);
	{writeln('la cantidad de productos que vendieron mas de ', cant,' unidades fueron ',mascantidad(a, cant));}
end.
		
