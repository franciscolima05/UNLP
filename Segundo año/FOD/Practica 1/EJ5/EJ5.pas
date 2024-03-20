program EJ5;
type
	celular = record
		code: integer;
		name : string;
		desc : string;
		marca : string;
		stockM : integer;
		stockD : integer;
		precio : real;
		end;
		
	arch = file of celular;
	
procedure crearArchivo(var ar : arch);
var
	cel : celular;
	te : text;
	ruta : string;
begin
	writeln('Ingrese ruta del Archivo');
	readln(ruta);
	assign(ar, ruta);
	//writeln('Ingrese ruta del Archivo de Texto');
	ruta := 'C:\Users\franp\Desktop\pascal\EJ5\celulares.txt';
	assign(te, ruta);
	rewrite(ar);
	reset(te);
	writeln('llegue');
	while(not EOF(te)) do
		begin
			with cel do
				begin
					readln(te, code, precio, marca);
					readln(te, stockM, stockD, desc);
					readln(te, name);
				end;
			write(ar, cel);
		end;
	close(ar);
	close(te);
end;

procedure listarMin(var al : arch);
var
	c : celular;
begin
	//considero que no debo hacer el assign de nuevo
	reset(al);
	while(not EOF(al)) do
		begin
			read(al, c);
			if(c.stockD < c.stockM) then
				begin
					with c do
						begin
							writeln('Nombre: ', name);
							writeln('Marca: ', marca);
							writeln('Precio: ',precio);
							writeln('Descripcion: ',desc);
							writeln('Stock Minimo: ', stockM);
							writeln('Stock Disponible: ', stockD);
						end;
				end;
		end;
	close(al);
end;


procedure exportarArchivo(var al : arch; var te : text);
var
	cel : celular;
	ruta : string;
begin
	//writeln('ingrese ruta del archivo de texto');
	ruta := 'C:\Users\franp\Desktop\pascal\EJ5\Celulares2.txt';
	assign(te, ruta);
	reset(al);
	rewrite(te);
	while(not EOF(al)) do
		begin
			read(al, cel);
			with cel do
				begin
					writeln(te, code, ' ', precio, ' ', marca);
					writeln(te, stockM, ' ', stockD, ' ', desc);
					writeln(te, name);
				end;
		end;
	close(te);
	close(al);
end;

var
	al : arch;
	te : text;
	op : char;
	ok : boolean;
begin
	ok := true;
	if(ok) then
		begin
			writeln('Ingrese A para crear un archivo nuevo a partir de un archivo de texto');
			readln(op);
			ok := false;
			while(op <> 'A') do
				begin
					writeln('Ingrese A para crear un archivo nuevo a partir de un archivo de texto');
					readln(op);
				end;
			crearArchivo(al);
		end;
	repeat
		writeln('Ingrese B para generar una lista con los celulares con bajo Stock');
		writeln('Ingrese C para exportar el archivo a uno de texto');
		writeln('Ingrese D para salir');
		readln(op);
		case op of
				'B':
					begin
						listarMin(al);
					end;
				'C':
					begin
						exportarArchivo(al, te);
					end;
		end;
	until  op = 'D';
end.
