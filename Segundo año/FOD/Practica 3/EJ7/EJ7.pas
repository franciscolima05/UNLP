program EJ7;
type
	ave = record
		code : integer;
		//zona : string;
		//familia : string;
		//desc : string;
		nom : string;
		end;
		
	archivo = file of ave;
	
procedure cargarArchivo(var al : archivo; var te : text);
var
	a : ave;
begin
	reset(te);
	rewrite(al);
	while(NOT EOF(te)) do
		begin
			readln(te, a.code, a.nom);
			write(al, a);
		end;
	close(al);
	close(te);
end;

procedure realizarBaja(var al : archivo);
var
	bj : integer;
	a : ave;
	ok : boolean;
begin
	reset(al);
	writeln('Ingrese ave a borrar');
	readln(bj);
	while(bj <> 5000) do
		begin
			seek(al, 0);
			ok := true;
			while(not EOF(al) and (ok)) do
				begin
					read(al, a);
					if(a.code = bj) then
						ok := false;
				end;
			if(ok) then
				writeln('NO SE ENCONTRO ESA AVE')
			else
				begin
					a.nom := 'zzz';
					seek(al, filepos(al) - 1);
					write(al, a);
				end;
			writeln('Ingrese ave a borrar o 5000 para detener');
			readln(bj);
		end;
	close(al);
end;

procedure compactar(var al : archivo);
var
	a, aux : ave;
	i : integer;
begin
	reset(al);
	i := 0;
	while(not EOF(al)) do
		begin
			read(al, a);
			if(a.nom = 'zzz') then
				begin
					seek(al, filesize(al)-1);
					read(al, aux);
					seek(al, i);
					write(al, aux);
					seek(al, filesize(al)-1);
					truncate(al);
					if(aux.nom <> 'zzz') then
						i := i + 1;
					seek(al, i);
				end
			else
				i := i + 1;
		end;
	close(al);
end;

procedure imprimirArchivo(var al : archivo);
var
	a : ave;
begin
	reset(al);
	while(not EOF(al)) do
		begin
			read(al, a);
			writeln('CODIGO: ',a.code);
			writeln('AVE: ', a.nom);
		end;
	close(al);
end;
	
var
	al : archivo;
	te : text;
begin
	assign(al, 'a');
	assign(te, 'C:\Users\franp\Desktop\Practica 3\EJ7\carga.txt');
	cargarArchivo(al, te);
	imprimirArchivo(al);
	writeln();
	writeln('------------');
	writeln();
	realizarBaja(al);
	compactar(al);
	imprimirArchivo(al);
end.
