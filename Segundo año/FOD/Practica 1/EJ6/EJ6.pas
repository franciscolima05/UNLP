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
	ruta := 'C:\Users\franp\Desktop\pascal\EJ6\celulares.txt';
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

procedure cargarCelular(var cel : celular);
begin
	writeln('Nombre: ');
	readln(cel.name);
	if(cel.name <> 'zzz') then
		begin
			writeln('Marca: ');
			readln(cel.marca);
			writeln('Precio: ');
			readln(cel.precio);
			writeln('Descripcion: ');
			readln(cel.desc);
			writeln('Stock Minimo: ');
			readln(cel.stockM);
			writeln('Stock Disponible: ');
			readln(cel.stockD);
		end;
end;
procedure agregarElemento(var al : arch);
var
	cel : celular;
begin
	reset(al);
	writeln('Ingrese los datos');
	cargarCelular(cel);
	while(cel.name <> 'zzz') do 
		begin
			seek(al, filesize(al));
			write(al, cel);
			cargarCelular(cel);
		end;
	close(al);
end;

procedure modificarStock(var al : arch);
var
	cel : celular;
	nom : string;
	newStock : integer;
	ok : boolean;
begin
	writeln('Ingrese un Nombre de celular');
	readln(nom);
	reset(al);
	ok := true;
	while((not EOF(al)) and (ok))do
		begin
			read(al, cel);
			if(cel.name = nom) then
				begin
					ok := false;
					writeln('Stock Disponible actual: ', cel.stockD);
					writeln('Ingrese stock deseado: ');
					read(newStock);
					cel.stockD := newStock;
					seek(al, filepos(al) - 1);
					write(al, cel);
					writeln('Nuevo Stock: ', cel.stockD);
				end;
		end;
	if(ok) then
		writeln('No se encontro el codigo');
	close(al);
end;
	
procedure imprimirTexto(var te : text);
var
	ruta, linea : string;
begin
	writeln('ingrese ruta');
	readln(ruta);
	assign(te, ruta);
	reset(te);
	while(not EOF(te)) do
		begin
			readln(te, linea);
			writeln(linea);
		end;
	close(te);
end;

			
	
	
procedure exportarSinStock(var al : arch; var te : text);
var
	cel : celular;
begin
	assign(te, 'C:\Users\franp\Desktop\pascal\EJ6\sinStock.txt');
	rewrite(te);
	reset(al);
	while(not EOF(al)) do
		begin
			read(al,cel);
			if(cel.stockD = 0) then
				begin
					with cel do
						begin
							writeln(te, code, ' ', precio, ' ', marca);
							writeln(te, stockM, ' ', stockD, ' ', desc);
							writeln(te, name);
						end;
				end;
		end;
	close(al);
	close(te);
end;

procedure exportarArchivo(var al : arch; var te : text);
var
	cel : celular;
	ruta : string;
begin
	//writeln('ingrese ruta del archivo de texto');
	ruta := 'C:\Users\franp\Desktop\pascal\EJ6\Celulares2.txt';
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
		writeln('Ingrese D para agrear un elemento al final');
		writeln('Ingrese E para cambiar el stock de un celular');
		Writeln('Ingrese F para exportar los celulares sin Stock');
		Writeln('Ingrese G para imprimir un archivo de texto');
		writeln('Ingrese H para terminar el programa');
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
				'D':
					begin
						Writeln('Si ingresa Nombre ZZZ dejara de agregar Celulares');
						agregarElemento(al);
					end;
				'E':
					begin
						modificarStock(al);
					end;
				'F':
					begin
						exportarSinStock(al,te);
					end;
				'G':
					begin
						imprimirTexto(te);
					end;
		end;
	until  op = 'H';
end.
