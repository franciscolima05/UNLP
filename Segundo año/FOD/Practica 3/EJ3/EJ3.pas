program EJ3;
type
	novela = record
		code : integer;
		genero : string;
		nom : string;
		duracion : real;
		director : string;
		precio : real;
		end;
	
	archivo =  file of novela;
	
procedure leerNov(var n : novela);
begin
	Writeln('Ingrese Codigo: ');
	readln(n.code);
	if(n.code <> 9999) then
		begin
			Writeln('Ingrese Genero: ');
			readln(n.genero);
			Writeln('Ingrese Nombre: ');
			readln(n.nom);
			Writeln('Ingrese Duracion: ');
			readln(n.duracion);
			Writeln('Ingrese Director: ');
			readln(n.director);
			Writeln('Ingrese Precio: ');
			readln(n.precio);
		end;
end;

procedure cargarArchivo(var al : archivo);
var
	i : integer;
	n : novela;
begin
	i := 0;
	rewrite(al);
	n.code := 0;
	n.genero := 'zzz';
	n.director := 'zzz';
	n.nom := 'zzz';
	n.duracion := 0.0;
	n.precio := 0.0;
	write(al, n);
	leerNov(n);
	writeln('Llegue');
	while(n.code <> 9999) do
		begin
			write(al, n);
			leerNov(n);
			i := i + 1;
			writeln(i);
		end;
	close(al);
end;

procedure mantenimiento(var al : archivo);
var
	i, num : integer;
	op : char;
	n, nAux : novela;
begin
	reset(al);
	writeln('Ingrese una Opcion para OPERAR LAS NOVELAS');
	writeln('A: Dar de alta una novela');
	writeln('B: Modificar los datos de una novela');
	writeln('C: Eliminar una Novela');
	readln(op);
	case op of
		'A':
			begin
				read(al, n);
				if(n.code = 0) then
					writeln('No hay Lugar')
				else
					begin
						leerNov(nAux);
						writeln('EL NUMERO DE ARCHIVO A SOBREESCRIBIR ES: ', n.code);
						num := n.code * -1;
						writeln(num);
						seek(al, 0);
						for i := 0 to num do
							read(al, n);
						seek(al, 0);
						write(al, n);
						seek(al, num);
						write(al, nAux);
					end;
			end;
		'B': 
			begin
				writeln('Ingrese numero de novela a modificar: ');
				readln(num);
				leerNov(nAux);
				seek(al, num);
				read(al, n);
				nAux.code := n.code;
				seek(al, filepos(al) - 1);
				write(al, nAux);
			end;
		'C':
			begin
				Writeln('Ingrese Numero de novela a eliminar: ');
				readln(num);
				read(al, n);
				seek(al, num);
				read(al, nAux);
				seek(al, filepos(al) - 1);
				write(al, n);
				seek(al, 0);
				nAux.code := nAux.code * -1;
				write(al, nAux);
			end;
		end;
	close(al);
end;

procedure exportarTxt(var al : archivo; var te : text);
var
	n : novela;
begin
	reset(al);
	rewrite(te);
	while(not EOF(al)) do
		begin
			read(al, n);
			with n do
				begin
					writeln(te, code, ' ', nom);
					writeln(te, precio:1:0, ' ', director);
					writeln(te, duracion:1:0, ' ', genero);
				end;
		end;
	close(te);
	close(al);
end;

var
	te : text;
	ruta : string;
	al : archivo;
	op : char;
	ok : boolean;
begin
	writeln('Ingrese Opcion: ');
	writeln('A: Crear un archivo de novelas');
	writeln('B: Operar el archivo');
	writeln('C: Exportar a un archivo de texto');
	writeln('D: Detener el programa');
	ok := true;
	while(ok) do
		begin
			writeln('Ingrese Opcion: ');
			readln(op);
			case op of
				'A': 
					begin
						writeln('Ingrese Ruta para el archivo: ');
						readln(ruta);
						assign(al, ruta);
						cargarArchivo(al);
					end;
				'B':
					begin
						mantenimiento(al);
					end;
				'C':
					begin
						writeln('Ingrese ruta del archivo de Texto: ');
						readln(ruta);
						assign(te, ruta);
						exportarTxt(al, te);
					end;
				'D':
					begin
						ok := false;
					end;
				end;
			end;
end.
					
					
