program EJ6;
type

	prenda = record
		code : integer;
		stock : integer;
		precio : real;
		end;
		
	maestro = file of prenda;

	baja = file of integer;
	
procedure cargarArchivo(var al : maestro; var te : text);
var
	p : prenda;
begin
	reset(te);
	rewrite(al);
	while(not EOF(te)) do
		begin
			readln(te, p.code, p.stock, p.precio);
			write(al, p);
		end;
	close(te);
	close(al);
end;

procedure imprimirArchivo(var al : maestro);
var
	p : prenda;
begin
	reset(al);
	while(Not EOF(al)) do
		begin
			read(al, p);
			writeln('CODIGO: ',p.code);
			writeln('STOCK: ',p.stock);
			writeln('PRECIO: ',p.precio:1:0);
		end;
	close(al);
end;

procedure cargarBaja(var al : baja; var te : text);
var
	num : integer;
begin
	reset(te);
	rewrite(al);
	while(not EOF(te)) do
		begin
			readln(te, num);
			write(al, num);
		end;
	close(al);
	close(te);
end;

procedure realizarBaja(var al : maestro; var bj : baja);
var
	num : integer;
	ok : boolean;
	p : prenda;
begin
	reset(bj);
	reset(al);
	while(Not EOF(bj)) do
		begin
			read(bj, num);
			ok := true;
			seek(al, 0);
			while((not EOF(al)) and (ok))do
				begin
					read(al, p);
					if(p.code = num) then
						ok := false;
				end;
			if(ok) then
				writeln('No se encontro el codigo a borrar')
			else
				begin
					p.stock := p.stock * -1;
					seek(al, filepos(al) -1);
					write(al, p);
				end;
		end;
	close(al);
	close(bj);
end;

procedure maestroOriginal(var al : maestro; var origi : maestro);
var
	p: prenda;
begin
	reset(al);
	rewrite(origi);
	while(not EOF(al)) do
		begin
			read(al, p);
			if(p.stock >= 0) then
				write(origi, p);
		end;
	close(al);
	close(origi);
end;

var
	al, origi : maestro;
	bj : baja;
	te : text;
begin
	assign(al, 'a');
	assign(origi, 'b');
	assign(bj, 'c');
	assign(te, 'C:\Users\franp\Desktop\Practica 3\EJ6\Carga1.txt');
	cargarArchivo(al, te);
	assign(te, 'C:\Users\franp\Desktop\Practica 3\EJ6\Carga2.txt');
	cargarBaja(bj, te);
	imprimirArchivo(al);
	reset(al);
	writeln('tamaño: ', filesize(al));
	close(al);
	writeln(' ');
	writeln('-----------------');
	writeln(' ');
	realizarBaja(al, bj);
	imprimirArchivo(al);
	writeln(' ');
	writeln('-----------------');
	writeln(' ');
	maestroOriginal(al, origi);
	writeln('ARCHIVO ORIGINAL');
	imprimirArchivo(origi);
end.
	
