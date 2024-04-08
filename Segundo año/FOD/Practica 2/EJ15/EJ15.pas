program EJ14;
const 
	valoralto = 999;
	lim = 3;
type
	semanario = record
		dia : integer;
		mes : integer;
		code : integer;
		nom : string;
		desc : string;
		precio : real;
		totalE : integer;
		cantV : integer;
		end;
		
	det = record
		dia : integer;
		mes : integer;
		code : integer;
		cantV : integer;
		end;
	
	maestro = file of semanario;

	detalle = file of det;
	
	vecArc = array[1..lim] of detalle;
	
	vecReg = array[1..lim] of det;
	
procedure leer(var al : detalle; var dato : det);
begin
	if(not EOF(al)) then
		read(al, dato)
	else
		dato.code := valoralto;
end;

procedure minimo(var vecA : vecArc; var vecR : vecReg; var min : det);
var
	i, aux : integer;
begin
	min.code:= 999;
	for i := 1 to lim do
		begin
			if(vecR[i].code < min.code) or ((vecR[i].code = min.code) and (vecR[i].mes < min.mes)) or ((vecR[i].code = min.code) and (vecR[i].mes = min.mes) and (vecR[i].dia < min.dia)) then
				begin
					min := vecR[i];
					aux := i;
				end;
		end;
	leer(vecA[aux], vecR[aux]);
end;

procedure cargarArchivo(var al : maestro; var te : text);
var
	s : semanario;
begin
	reset(te);
	rewrite(al);
	while(not EOF(te)) do
		begin
			with s do
				begin
					readln(te, code, dia, mes, nom);
					readln(te, totalE, cantV, precio, desc);
				end;
			write(al, s);
		end;
	close(te);
	close(al);
end;

procedure cargarArchivoDetalle(var al : detalle; var te : text);
var
	s : det;
begin
	reset(te);
	rewrite(al);
	while(not EOF(te)) do
		begin
			with s do
				readln(te, code, dia, mes, cantV);
			write(al, s);
		end;
	close(te);
	close(al);
end;

procedure procesarArchivo(var vecA : vecArc; var vecR : vecReg; var al : maestro);
var
	min, actual : det;
	minimoS ,max, s : semanario;
	i : integer;
begin
	for i:= 1 to lim do
		begin
			reset(vecA[i]);
			leer(vecA[i], vecR[i]);
		end;
	reset(al);
	minimoS.cantV := 999;
	max.cantV := -1;
	minimo(vecA, vecR, min);
	while(min.code <> valoralto) do
		begin
			actual.code := min.code;
			actual.dia := min.dia;
			actual.mes := min.mes;
			actual.cantV := 0;
			while(min.code = actual.code) and (min.mes = actual.mes) and (min.dia = actual.dia) do
				begin
					actual.cantV := actual.cantV + min.cantV;
					minimo(vecA, vecR, min);
					writeln(actual.code);
					writeln(min.code);
				end;
			read(al, s);
			if(s.cantV > max.cantV) then
				max := s;
			if(s.cantV < minimoS.cantV) then
				minimoS := s;
			while(s.code <> actual.code) do
				begin
					read(al, s);
					if(s.cantV > max.cantV) then
						max := s;
					if(s.cantV < minimoS.cantV) then
						minimoS := s;
				end;
			s.cantV := s.cantV + actual.cantV;
			seek(al, filepos(al) - 1);
			write(al, s);
			writeln('escribi');
		end;
	writeln('EL SEMANARIO QUE VENDIO MAS UNIDADES FUE: ',max.nom);
	writeln('EL SEMANARIO QUE VENDIO MENOS UNIDADES FUE: ',minimoS.nom);	
	for i:= 1 to lim do
		close(vecA[i]);
	close(al);
end;

procedure imprimirArchivo(var al : maestro);
var
	s : semanario;
begin
	reset(al);
	while(not EOF(al))do
		begin
			read(al, s);
			with s do 
				begin
					writeln('CODIGO: ',code);
					writeln('NOMBRE: ',nom);
					writeln('MES: ', mes);
					writeln('DIA: ',dia);
					writeln('CANTIDAD DE UNIDADES: ',totalE);
					writeln('CANTIDAD DE UNIDADES VENDIDAS: ',cantV);
				end;
		end;
	close(al);
end;

var
	al : maestro;
	vecA : vecArc;
	vecR : vecReg;
	ruta : string;
	te : text;
begin
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ15\detalle1.txt';
	assign(te, ruta);
	ruta := 'a';
	assign(vecA[1], ruta);
	cargarArchivoDetalle(vecA[1], te);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ15\detalle2.txt';
	assign(te, ruta);
	ruta := 'b';
	assign(vecA[2], ruta);
	cargarArchivoDetalle(vecA[2], te);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ15\detalle3.txt';
	assign(te, ruta);
	ruta := 'c';
	assign(vecA[3], ruta);
	cargarArchivoDetalle(vecA[3], te);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ15\maestro.txt';
	assign(te, ruta);
	ruta := 'z';
	assign(al, ruta);
	cargarArchivo(al, te);
	imprimirArchivo(al);
	procesarArchivo(vecA, vecR, al);
	imprimirArchivo(al);
end.
			
