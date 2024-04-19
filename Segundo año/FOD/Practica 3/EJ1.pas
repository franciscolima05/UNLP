program EJ1;
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

procedure anadirEmpleado(var al : empleados);
var
	e, emp : empleado;
	ok : boolean;
begin
	cargarEmpleado(emp);
	while(emp.num <> 0000) do
		begin
			ok := true;
			while((ok) and (not EOF(al))) do
				begin
					read(al, e);
					if(emp.dni = e.dni) then
						ok := false;
				end;
			if(ok) then
				begin
					seek(al, filesize(al));
					write(al, emp);
				end;
			cargarEmpleado(emp);
		end;
end;



procedure cambiarEdad(var al : empleados);
var
	edad, num : integer;
	e : empleado;
	ok : boolean;
begin
	writeln('ingrese numero de empleado');
	readln(num);
	ok := true;
	while((ok) and (not EOF(al))) do
		begin
			read(al, e);
			if(e.num = num) then
				begin
					ok := false;
					writeln('la edad actual es: ', e.edad);
					writeln('nueva edad: ');
					readln(edad);
					e.edad := edad;
					seek(al, filepos(al) - 1);
					write(al, e);
				end;
		end;
end;

procedure exportarTxt(var al : empleados; var te: text);
var
	e : empleado;
begin
	reset(al);
	rewrite(te);
	while(not EOF(al)) do
		begin
			read(al, e);
			with e do
				begin
					writeln(te, nom, apellido, dni, edad);
				end;
		end;
end;

procedure imprimirTxt(var te : text);
var
	linea : string;
begin
	reset(te);
	while(not EOF(te)) do
		begin
			readln(te, linea);
			writeln(linea);
		end;
end;
			
procedure eliminarArchivo(num : integer; var al : empleados);
var
	i : integer;
	aux, aux2 : empleado;
begin
	reset(al);
	if(num > filesize(al)) then
		writeln('Ingresaste un numero invalido')
	else
		begin
			seek(al, filesize(al) - 1);
			read(al, aux2);
			seek(al, 0);
			for i := 0 to num do
				read(al, aux);
			aux := aux2;
			seek(al, filepos(al) - 1);
			write(al, aux);
			seek(al, filesize(al) - 1);
			truncate(al);
		end;
	close(al);
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
		'd':
			begin
				anadirEmpleado(al);	
			end;	
		'e':
			begin
				cambiarEdad(al);
			end;
		end;
end;

var
	al : empleados;
	op : char;
	num : integer;
	ruta : string;
	ok : boolean;
	te : text;
	//linea : string;
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
					seek(al, 0); //si se usa un archivo ya creado se rompe el programa
					abrirArchivo(al);
				end;
			'c':
				begin
					close(al);
					ok := false;
				end;
			'd':
				begin
					writeln('ingrese ruta para el archivo de texto');
					readln(ruta);
					assign(te, ruta);
					reset(al);
					rewrite(te);
					exportarTxt(al, te);
					imprimirTxt(te);
					close(te);
				end;
			'e':
				begin
					writeln('Ingrese numero de archivo a borrar: ');
					readln(num);
					eliminarArchivo(num, al);
				end;
		end;
	end;
end.
