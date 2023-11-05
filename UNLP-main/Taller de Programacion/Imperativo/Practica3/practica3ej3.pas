program ej3;
type 
	alumno = record
		legajo : integer;
		ingreso : integer;
		dni : integer;
		code : integer;
		nota : integer;
		end;
		
	arb = ^nodo;
	
	nodo = record
		a : alumno
		hi : arb;
		hd : arb;
		end;
		
		
	alumnosmenos = record
		dni : integer;
		ingreso : integer;
		end;
	
	tree = ^nodo2;
	
	nodo2 = record
		alu : alumnosmenos;
		hi : tree;
		hd : tree;
		end;
	
	
	lis = ^nodo3
	
	nodo3 = record
		dni : integer;
		sig : lis;
		end;
		
	
procedure cargararbol(var a : arb; elem : alumno);
begin
	if(a = nil) then
		begin
			new(a);
			a^.hi := nil; a^.hd := nil; a^.a:= elem;
		end;
	else
		if(elem.legajo <= a^.a.legajo) then
			cargararbol(a^.hi, elem);
		else
			cargararbol(a^.hd, elem);
end;

procedure agregar(var tr : tree; elem : alumnomenos);
begin
	if(tr = nil) then
		begin
			new(tr);
			tr^.hi := nil; tr^.hd := nil; tr^.alu:= elem;
		end;
	else
		if(elem.dni <= tr^.alu.dni) then
			agregar(a^.hi, elem);
		else
			agregar(a^.hd, elem);
end;

procedure legajomenos(var tr : tree; dato : integer; a : arb);
var
	aux : alumnomenos;
begin
	if( a <> nil) then
		begin
			if(a^.a.legajo < dato) then
				begin
					aux.ingreso := a^.a.ingreso;
					aux.dni := a^.a.dni;
					agregar(tr, aux);
					legajomenos(tr, dato, a^.hi);
					egajomenos(tr, dato, a^.hd);
				end;
			else
				legajomenos(tr, dato, a^.hi);
		end;
end;

function legajomax(a : arb; max : integer) : integer
begin
	if(a <> nil) then
		begin
			if(max < a^.a.legajo)then
				begin
					max := a^.a.legajo;
					legajomax(a^.hd, max);
				end;
			else
				legajomax(a^.hd, max);
		end;
	else
		legajomax := max;
end;


function dnimax(a : arb; max : integer) : integer
begin
	if(a <> nil) then
		begin
			if(max < a^.a.dni)then
				begin
					max := a^.a.dni;
					dnimax(a^.hd, max);
				end;
			else
				dnimax(a^.hd, max);
		end;
	else
		legajomax := max;
end;

procedure agregar(var l : lis; elem : integer);
var
	aux : lis;
begin
	new(aux); aux^.sig := nil; aux^.dni := elem;
	if(l = nil) then
		l := aux;
	else
		begin
			aux^.sig := l;
			l := aux;
		end;
end;


procedure legajoimpar(a : arb; var l : lis);
begin
	if(a <> nil) then
		begin
			if((a^.a.legajo mod 2) <> 0) then
				begin
					agregar(l, a^.a.dni);
					legajoimpar(a^.hi, l);
					legajoimpar(a^.hd, l);
				end;
			else
				begin
					legajoimpar(a^.hi, l);
					legajoimpar(a^.hd, l);
				end;
		end;
end;


				
 
				






