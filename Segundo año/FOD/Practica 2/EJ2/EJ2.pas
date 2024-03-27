program EJ2;
const 
	valoralto = 999;
type
	alumno = record
		code : integer;
		nom : string;
		apellido : String;
		cursadas : integer;
		finales : integer;
		end;
		
	alumnoD = record
		code : integer;
		cursadas : integer;
		finales : integer;
		end;
	
	archivo = file of alumno;

procedure leer(var te : text; var dato : alumnoD);
begin
	if(not EOF(te)) then
		with dato do
			begin
				readln(te, code, cursadas, finales);
			end
	else
		dato.code := valoralto;
end;

procedure cargarArchivo(var al : archivo; var mae : text);
var
	a : alumno;
begin
	rewrite(al);
	reset(mae);
	while(not EOF(mae)) do
		begin
			with a do
				begin
					readln(mae, code);
					readln(mae, apellido);
					readln(mae, nom);
					readln(mae, cursadas);
					readln(mae, finales);
				end;
			write(al, a);
		end;
	close(al);
	close(mae);
end;

procedure imprimirArchivo(var al : archivo);
var
	e : alumno;
begin
	reset(al);
	while(not EOF(al)) do
		begin
			read(al, e);
			writeln('Nombre: ',e.nom);
			writeln('Apellido: ',e.apellido);
			writeln('Codigo: ',e.code);
			writeln('Cursadas aprobadas: ',e.cursadas);
			writeln('Finales Aprobados: ',e.finales);
		end;
	close(al);
end;

procedure procesarArchivo(var al : archivo; var det : text);
var
	a : alumnoD; 
	aux : alumno;
	cursadas, finales : integer;
	actual : integer;
begin
	reset(al);
	reset(det);
	leer(det, a);
	while(a.code <> valoralto) do
		begin
			cursadas := 0;
			finales := 0;
			actual := a.code;
			while(a.code = actual) do
				begin
					finales := finales + a.finales;
					cursadas := cursadas + a.cursadas - a.finales;
					leer(det, a);
				end;
			read(al, aux);
			while(actual <> aux.code) do
				read(al, aux);
			aux.cursadas := aux.cursadas + cursadas;
			aux.finales := aux.finales + finales;
			seek(al, filepos(al) -1);
			write(al, aux);
		end;
	close(al);
	close(det);
end;

procedure exportarArchivo(var al : archivo; var te : text);
var
	a : alumno;
begin
	reset(al);
	rewrite(te);
	while(not EOF(al)) do
		begin
			read(al, a);
			if(a.finales > a.cursadas) then
				begin
					with a do
						writeln(te, a.nom, a.apellido, a.code, a.cursadas, a.finales);
				end;
		end;
	close(al);
	close(te);
end;

var
	al : archivo;
	maestro, detalle, exp : text;
	ruta : String;
	op : char;
begin
	writeln('Ingrese Ruta: ');
	readln(ruta);
	assign(al, ruta);
	ruta := 'C:\Users\franp\Desktop\pascal 2\EJ2\maestro.txt';
	assign(maestro, ruta);
	ruta := 'C:\Users\franp\Desktop\pascal 2\EJ2\detalle.txt';
	assign(detalle,ruta);
	repeat
	writeln('Ingrese una A para actualizar el maestro, B para exportar los alumnos con mas finales que cursadas o C para salir');
	readln(op);
	case op of
			'A': 
				begin
					cargarArchivo(al, maestro);
					writeln('--------------------Maestro Original-------------------------');
					imprimirArchivo(al);
					procesarArchivo(al, detalle);
					writeln('----------------------Maestro Actualizado---------------------');
					imprimirArchivo(al);
				end;
			'B':
				begin
					cargarArchivo(al, maestro);
					writeln('--------------------Maestro Original-------------------------');
					imprimirArchivo(al);
					//writeln('Ingrese una ruta: ');
					//readln(ruta);
					ruta := 'C:\Users\franp\Desktop\pascal 2\EJ2\exportado.txt';
					assign(exp, ruta);
					exportarArchivo(al, exp);
				end;
		end;
	until op = 'C';
end.
