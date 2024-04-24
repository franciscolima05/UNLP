program Parte2EJ2;
type
	info = record
		code : integer;
		nro : integer;
		cant : integer;
		end;
	
	archivo = file of info;

procedure cargarArchivo(var al : archivo; var te : text);
var
	i : info;
begin
	rewrite(al);
	reset(te);
	while(not EOF(te)) do
		begin
			readln(te, i.code, i.nro, i.cant);
			write(al, i);
		end;
	close(al);
	close(te);
end;

procedure contain(var al : archivo; inform : info ; var ok : boolean);
var
	i : info;
begin
	ok := false;
	seek(al, 0);
	while((not EOF(al)) and (not ok)) do 
		begin
			read(al, i);
			if((i.code = inform.code) and (i.nro = inform.nro)) then
				ok := true;
		end;
end;

procedure procesarArchivo(var al : archivo);
var
	total, pos, act : integer;
	aux : archivo;
	ok : boolean;
	i : info;
begin

	reset(al);
	assign(aux, 'a');
	rewrite(aux);
	while(filesize(aux) < filesize(al)) do
		begin
			read(al, i);
			contain(aux, i, ok);
			while(ok)do
				begin
					read(al, i);
					contain(aux, i, ok);
				end;
			act := i.code;
			pos := filepos(al);
			seek(aux, filesize(aux));
			write(aux, i);
			writeln('Codigo de Localidad: ',act);
			writeln('Codigo de Mesa: ', i.nro);
			writeln('Votos: ', i.cant);
			total := i.cant;
			while(not EOF(al)) do
				begin
					read(al, i);
					if(i.code = act)then
						begin
							total := total + i.cant;
							seek(aux, filesize(aux));
							write(aux, i);
							writeln('Nro de Mesa: ',i.nro);
							writeln('Votos: ', i.cant);
						end;
				end;
			writeln('Total de votos de la Localidad ',act,': ',total);
			seek(al, pos);
		end;
	close(al);
	close(aux);
end;

var
	al : archivo;
	te : text;
begin
	assign(al, 'B');
	assign(te, 'C:\Users\franp\Desktop\Practica 3\Parte2EJ2\Carga.txt'); 
	cargarArchivo(al, te);
	procesarArchivo(al);
end.
