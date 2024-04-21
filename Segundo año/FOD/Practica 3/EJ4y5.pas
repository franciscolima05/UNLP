program EJ4;
type
	flor = record
		nom : string;
		code : integer;
		end;
	
	archivo = file of flor;
	
procedure agregarFlor(var al : archivo; nom : string; code : integer);
var
	f, f2 : flor;
	num : integer;
begin
	reset(al);
	read(al, f);
	if(f.code = 0) then
		begin
			seek(al, filesize(al));
			f.code := code;
			f.nom := nom;
			write(al, f);
		end
	else
		begin
			num := f.code * (-1); //Tomo el NRR
			seek(al, num);//me muevo hacia el NRR
			read(al, f2);//Leo el valor 
			seek(al, 0);//Vuelvo a la Cabecera
			write(al, f2);//Escribo ese valor como nueva cabecera para apuntar al proximo elemento borrado de la lista o en caso de ser el ultimo a 0
			f.code := code;//cargo a F con los parametros
			f.nom := nom;
			seek(al, num);//voy al ex primer elemento eliminado de la Lista
			write(al, f);//Escribo el nuevo elemento
		end;
	close(al);
end;

procedure cargarArchivo(var al : archivo);
var
	f : flor;
begin
	rewrite(al);
	writeln('ingrese code: ');
	readln(f.code);
	if(f.code <> 9999) then
		begin
			writeln('Ingrese Nombre: ');
			readln(f.nom);
		end;
	while(f.code <> 9999) do
		begin
			write(al, f);
			writeln('ingrese code: ');
			readln(f.code);
			if(f.code <> 9999) then
				begin
					writeln('Ingrese Nombre: ');
					readln(f.nom);
				end;
		end;
	close(al);
end;

procedure imprimirArchivo(var al : archivo);
var
	f : flor;
begin
	reset(al);
	while(not EOF(al)) do
		begin
			read(al, f);
			if(f.code > 0) then
				begin
					writeln('CODE: ',f.code);
					writeln('NOMBRE: ',f.nom);
				end;
		end;
	close(al);
end;

procedure eliminarArchivo(var al : archivo);
var
	f, f2 : flor;
	num : integer;
begin
	reset(al);
	writeln('Ingrese numero de flor a borrar');
	readln(num);
	read(al, f);
	seek(al, num);
	read(al, f2);
	seek(al, filepos(al) - 1);
	write(al, f);
	seek(al, 0);
	f2.code := num * -1;
	write(al, f2);
end;
	
var
	al : archivo;
	f : flor;
	i : integer;
begin
	assign(al, 'a');
	cargarArchivo(al);
	imprimirArchivo(al);
	for i := 1 to 2 do
		eliminarArchivo(al);
	writeln('Ingrese codigo: ');
	readln(f.code);
	writeln('Ingrese nombre: ');
	readln(f.nom);
	agregarFlor(al, f.nom, f.code);
	imprimirArchivo(al);
end.		
	
