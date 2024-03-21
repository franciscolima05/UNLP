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


procedure agregarOModificarNovela(var al : arch; n : novela);
var

	n2 : novela;
	c : integer;
	ok : boolean;
begin
	reset(al)
	while((not EOF(al))and (ok)) do
		begin
			read(al, n2);
			if(n2.code = n.code) then
				begin
					seek(al, filepos(al)-1);
					write(al, n);
					ok := false;
				end;
		end;
	if(ok) then
		begin
			write(al, n);
		end;
	close(al);
end;

var
	al : arch;
	n : novela;
begin
	cargarArchivo(al);
	writeln('si ingresa un codigo de novela ya existente se sobrescribiran los campos');
	cargarNovela(n);
	agregarOModificar(al, n);
end.
	
	
	
	
	
	
	
	
			
