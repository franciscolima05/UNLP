program EJ2;
type
	asistente = record
		nro : integer;
		apellido : string;
		nom : string;
		mail : string;
		telefono : integer;
		dni : integer;
		end;
		
	archivo = file of asistente;
		
procedure leerAsist(var a : asistente);
begin
	writeln('Ingrese nro: ');
	readln(a.nro);
	writeln('Ingrese apellido: ');
	readln(a.apellido);
	writeln('Ingrese nombre: ');
	readln(a.nom);
	writeln('Ingrese mail: ');
	readln(a.mail);
	writeln('Ingrese telefono: ');
	readln(a.telefono);
	writeln('Ingrese DNI: ');
	readln(a.dni);
end;

procedure cargarArchivo(var al : archivo);
var
	a : asistente;
begin
	rewrite(al);
	leerAsist(a);
	while(a.nro <> 999) do
		begin
			write(al, a);
			leerAsist(a);
		end;
	close(al);
end;

procedure imprimirArchivo(var al : archivo);
var
	a : asistente;
begin
	reset(al);
	while(not EOF(al)) do
		begin
			read(al, a);
			with a do
				begin
					writeln('NRO: ', nro);
					writeln('APELLIDO: ',apellido);
					writeln('NOMBRE: ',nom);
					writeln('DNI: ', dni);
					writeln('TELEFONO: ', telefono);
					writeln('MAIL: ', mail);
				end;
		end;
	close(al);
end;

procedure eliminarAsistentes(var al : archivo);
var
	a : asistente;
begin
	reset(al);
	while(not EOF(al)) do
		begin
			read(al, a);
			if(a.nro < 1000) then
				a.apellido := '***';
			seek(al, filepos(al) - 1);
			write(al, a);
		end;
	close(al);
end;

var
	al : archivo;
begin
	assign(al, 'a');
	cargarArchivo(al);
	imprimirArchivo(al);
	eliminarAsistentes(al);
	imprimirArchivo(al);
end.
