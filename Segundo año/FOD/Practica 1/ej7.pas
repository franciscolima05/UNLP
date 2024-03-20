program ej7;
type 
	novela = record
		nom : string;
		code : integer;
		gen : string;
		precio : real;
		end;
		
	arch = file of novela;
	
procedure cargarArchivo(var al : arch);
var
	n : novela;
	te : text;
begin
	assign(al, 'ruta');
	assign(te, 'ruta');
	rewrite(al);
	reset(te);
	while(not EOF(te)) do
		begin
			with n do
				begin
					readln(te, code, precio, gen);
					readln(te, nom);
				end;
			write(al, n);
		end;
	close(al);
	close(te);
end;

procedure cargarNovela(var n : novela);
begin
	with n do 
		begin
			readln(nom);
			readln(precio);
			readln(gen);
			readln(code);
		end;
end;


procedure agregarNovela(var al : arch);
var

	n : novela;
	c : integer;
begin
	reset(al)
	cargarNovela(n);  //se podria hacer comprobando por codigo de novela que la novela no se encontrara en el archivo
	seek(al, filesize);
	write(al, n);
	close(al);
end;

procedure modificarNovela(var al : arch);
var
	n : novela;
	co : integer;
	ok : boolean
begin
	ok := true;
	writeln('ingrese codigo');
	readln(co);
	reset(al);
	while(not EOF(al)) and (ok) do
		begin
			read(al, n);
			if(n.code = co) then
				//desplegar menu de opciones para poder elegir que campo modificar
				//poner ok = false
		
		//hacer los close
	
			

