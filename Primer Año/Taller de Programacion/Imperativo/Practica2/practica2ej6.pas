program ej6;
procedure conversion(num : integer);
var
	 resultado : integer;
begin
	resultado := 0;
	if(num <> 0) then
		begin
			resultado := num mod 2;
			conversion(num div 2);
		end;
	writeln(resultado);
end;


		
procedure procesar();
var
	num : integer;
begin
	writeln();
	writeln('ingresar numero');
	readln(num);
	if(num <> 0) then
		begin
			conversion(num);
			procesar();
		end;
end;

begin
	procesar();
end.
			
	
	

	


