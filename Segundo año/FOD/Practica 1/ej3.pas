program ej3;
type
	empleado = record
		num : integer;
		apellido: string;
		nom : string;
		edad : integer;
		dni : integer;
		end;
		
	empleados = file of empleado;

procedure cargarEmpleado(var e : empleado);
begin
	writeln('ingrese apellido');
	readln(e.apellido);
	if(e.apellido <> 'fin') then
		begin
			writeln('ingrese numero');
			readln(e.num);
			writeln('ingrese nombre');
			readln(e.nom);
			writeln('ingrese edad');
			readln(e.edad);
			writeln('ingrese dni');
			readln(e.dni);
		end;
end;

procedure imprimirEmpleado(e : empleado);
begin
	writeln(e.num);
	writeln(e.apellido);
	writeln(e.nom);
	writeln(e.dni);
	writeln(e.edad);
end;


procedure crearArchivo(var al : empleados);
var
	e : empleado;
begin
	cargarEmpleado(e);
	while(e.apellido <> 'fin') do
		begin
			write(al, e);
			cargarEmpleado(e);
		end;
end;

procedure abrirArchivo(var al : empleados);
var
	nom : string;
	op : char;
	e : empleado;
begin
	writeln('que desea hacer');
	readln(op);
	case op of
		'a': 
			begin
				writeln('ingrese nombre a buscar');
				readln(nom);
				while(not EOF(al)) do
					begin
						read(al, e);
						if((e.nom = nom) or (e.apellido = nom)) then
							imprimirEmpleado(e);
					end;
			end;
		'b':
			begin
				while(not EOF(al)) do 
					begin
						read(al, e);
						imprimirEmpleado(e);
					end;
			end;
		'c':
			begin
				while(not EOF(al)) do
					begin
						read(al, e);
						if(e.edad >= 70) then
							imprimirEmpleado(e);
					end;
			end;
		end;
end;

var
	al : empleados;
	op : char;
	ruta : string;
	ok : boolean;
begin
	writeln('ingrese ruta: ');
	readln(ruta);
	assign(al, ruta);
	ok := true;
	while(ok) do
		begin
			writeln('ingrese opcion: ');
			readln(op);
			case op of
			'a': 
				begin
					rewrite(al);
					crearArchivo(al);
				end;
			'b':
				begin
					reset(al);
					abrirArchivo(al);
				end;
			'c':
				begin
					close(al);
					ok := false;
				end;
		end;
	end;
end.
			
			
	
			
	



