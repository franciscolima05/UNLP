program EJ1;
var
	al : file of integer;
	aux : integer;
	af : string;
BEGIN
	writeln("ingrese ruta");
	readln(af);
	assign(al, af);
	rewrite(al);
	writeln("ingrese numero: ");
	readln(aux);
	while(aux <> 30000) do
		begin
			write(al, aux);
			writeln("ingrese numero: ");
			readln(aux);
		end;
    close(al);			
END.

