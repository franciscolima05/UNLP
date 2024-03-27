program EJ1;
const 
	valoralto = 999;
type
	empleado = record
		nom : String;
		monto : integer;
		code : integer;
		end;
		
	archivo = file of empleado;
procedure leer(var te : text; var dato : empleado);
begin
	if(not EOF(te)) then
		begin
			with dato do
				begin
					readln(te, code);
					readln(te, nom);
					readln(te, monto);
				end;
		end
	else
		dato.code := valoralto;
end;

procedure procesarArchivo(var al : archivo; var te : text);
var
	aux, e : empleado;
	total : integer;
	actual : integer;
begin
	leer(te, e);
	while(e.code <> valoralto) do
		begin
			aux := e;
			total := 0;
			actual := e.code;
			while(e.code = actual) do
				begin
					total := total + e.monto;
					leer(te, e);
				end;
			seek(al, filesize(al));
			aux.monto := total;
			write(al, aux);
		end;
	close(al);
	close(te);
end;

procedure imprimirArchivo(var al : archivo);
var
	e : empleado;
begin
	reset(al);
	while(not EOF(al)) do
		begin
			read(al, e);
			writeln(e.nom);
			writeln(e.code);
			writeln(e.monto);
		end;
	close(al);
end;

var
	te : text;
	al : archivo;
	ruta : String;
begin
	writeln('Ingrese ruta: ');
	readln(ruta);
	assign(al, ruta);
	ruta := 'C:\Users\franp\Desktop\pascal 2\EJ1\empleados.txt';
	assign(te, ruta);
	rewrite(al);
	reset(te);
	procesarArchivo(al, te);
	imprimirArchivo(al);
end.
	
			
			
			
