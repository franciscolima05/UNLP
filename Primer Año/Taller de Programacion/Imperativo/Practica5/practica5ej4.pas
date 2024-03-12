program ej4;
type
	reclamo = record
		code : integer;
		dni : integer;
		fecha : integer;
		tipo : integer;
		end;
		
		
	reclamolista = record
		code : integer;
		fecha : integer;
		tipo : integer;
		end;
		
	lis = ^nodolista;
	
	nodolista = record
		dato : reclamolista;
		sig : lis;
		end;
		
	arb = ^nodo;
	
	nodo = record
		hi : arb;
		hd : arb;
		dni : integer;
		l : lis;
		end;
		
procedure leer(var r : reclamo);
begin
	writeln('ingrese codigo: ');
	readln(r.code);
	if(r.code <> -1) then
		begin
		    writeln('ingresar dni:');
		    readln(r.dni);
			{r.dni := random(20) + 1;}
			r.fecha := random(24) + 2000;
			r.tipo := random(5) + 1;
		end;
end;

procedure agregaradelante(var l : lis; elem : reclamolista);
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

procedure agregarnodo(var a : arb; r : reclamo);
var
	rl : reclamolista;
begin
	if(a = nil) then
		begin
			rl.code := r.code;
			rl.fecha := r.fecha;
			rl.tipo := r.tipo;
			new(a); a^.hi := nil; a^.hd := nil; a^.dni := r.dni; a^.l := nil;
			agregaradelante(a^.l, rl);
		end
	else
		begin
			if(r.dni > a^.dni) then
				agregarnodo(a^.hd, r)
			else
				agregarnodo(a^.hi, r);
		end;
end;


procedure buscar(a : arb; var ok : boolean; var nodo : arb; dni : integer);
begin
	if(a <> nil) then
		begin
			if(a^.dni = dni) then
				begin
					ok := true;
					nodo := a;
				end
			else
				begin
					if(dni > a^.dni) then
						buscar(a^.hd, ok, nodo, dni)
					else
						buscar(a^.hd, ok, nodo, dni);
				end;
		end
	else
		begin
			ok := false;
			nodo := nil;
		end;
end;

procedure cargararbol(var a : arb; r : reclamo);
var
	rl : reclamolista;
	ok : boolean;
	nodo : arb;
begin
	buscar(a, ok, nodo, r.dni);
	if(ok) then
		begin
			rl.code := r.code;
			rl.fecha := r.fecha;
			rl.tipo := r.tipo;
			agregaradelante(nodo^.l, rl);
		end
	else
		agregarnodo(a, r);
end;

procedure cargartodo(var a : arb);
var
	r : reclamo;
begin
	leer(r);
	if(r.code <> -1) then
		begin
			cargararbol(a, r);
			cargartodo(a);
		end;
end;

procedure imprimirlista(l : lis);
begin
	while(l <> nil) do
		begin
			writeln(l^.dato.code);
			l := l^.sig;
		end;
end;

procedure imprimirarbol(a : arb);
begin
	if(a <> nil) then
		begin
			imprimirarbol(a^.hi);
			writeln('el dni es: ',a^.dni);
			imprimirlista(a^.l);
			imprimirarbol(a^.hd);
		end;
end;

function cantreclamos(l : lis) : integer;
var
	cant : integer;
begin
	cant := 0;
	while(l <> nil) do
		begin
			cant := cant + 1;
			l := l^.sig;
		end;
	cantreclamos := cant;
end;

function reclamosdni(a : arb; dni : integer) : integer;
begin
	if(a <> nil) then
		begin
			if(a^.dni = dni) then
				reclamosdni := cantreclamos(a^.l)
			else
				begin
					if(dni > a^.dni) then
						reclamosdni := reclamosdni(a^.hd, dni)
					else
						reclamosdni := reclamosdni(a^.hi, dni);
				end;
		end
	else
		reclamosdni := 0;
end;

function enrango(numero, num1, num2 : integer) : boolean;
var
	aux : integer;
begin
	if(num1 > num2) then
		begin
			aux := num1;
			num1 := num2;
			num2 := aux;
		end;
	if(numero > num1) and (numero < num2) then
		enrango := true
	else
		enrango := false;
end;

function rango(a : arb; num1, num2 : integer) : integer;
begin
	if(a <> nil) then
		begin
			if(enrango(a^.dni, num1, num2)) then
				begin
					rango := rango(a^.hd, num1, num2) + rango(a^.hi, num1, num2) + cantreclamos(a^.l);
				end
			else
				begin
					if(num1 > a^.dni) then
						rango(a^.hd, num1, num2)
					else
						rango(a^.hi, num1, num2);
				end;
		end
	else
		rango := 0;
end;
					

function procesarlista(l : lis; fecha : integer): integer;
var
	cant : integer;
begin
	while(l <> nil) do
		begin
			if(l^.dato.fecha = fecha) then
				cant := cant + 1;
			l := l^.sig;
		end;
	procesarlista := cant;
end;

function procesararbol(a : arb; fecha : integer) : integer;
begin
	if(a <> niL) then
		begin
			procesararbol := procesararbol(a^.hd, fecha) + procesararbol(a^.hi, fecha) + procesarlista(a^.l);
		end
	else
		procesararbol := 0;
end;
			


var
	a : arb;
	fecha, num1, num2, dni : integer;
begin
    a := nil;
	cargartodo(a);
	imprimirarbol(a);
	dni := 2;
	writeln('la cantidad de reclamos del dni ',dni,' es: ',reclamosdni(a, dni));
	num1 := 3;
	num2 := 9;
	writeln('la cantidad de reclamos entre todos los dni comprendidos entre ',num1,' y ',num2,' es: ',rango(a, num1, num2));
	fecha := 2018;
	writeln('la cantidad de reclamos efectuado en el anio ',fecha,' es ',procesararbol(a, fecha));
end.



