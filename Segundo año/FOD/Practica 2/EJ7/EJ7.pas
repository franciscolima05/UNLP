program EJ7;
const 
	valoralto = 999;
type
	
	caso = record
		codeL : integer;
		nom : string;
		codeC : string;
		cantC : integer;
		cantCN : integer;
		cantR : integer;
		cantF : integer;
		end;
	
	
	archivo = file of caso;

procedure leer(var det : archivo; var dato : caso);
begin
	if(not EOF(det)) then
	  	read(det, dato)
	else 
		dato.codeL := valoralto;
end;

procedure cargarArchivo(var al : archivo; var te : text);
var	
	c : caso;
begin
	rewrite(al);
	reset(te);
	while(not EOF(te)) do
		begin
			with c do 
				begin
					readln(te, codeL);
					readln(te, nom);
					readln(te, codeC);
					readln(te, cantC);
					readln(te, cantCN);
					readln(te, cantR);
					readln(te, cantF);
				end;
			write(al, c);
		end;
	close(al);
	close(te);
end;

procedure imprimirArchivo(var al : archivo);
var
	c : caso;
begin
	reset(al);
	while(Not EOF(al)) do
		begin
			read(al, c);
			with c do
				writeln('Nombre: ', nom, ' | ', ' Codigo: ', codeL,' | ',' Codigo de cepa: ', codeC, ' | ', ' Cantidad de casos activos: ', cantC, ' | ', ' Cantidad de casos nuevos: ', cantCN, ' | ', ' Cantidad de Casos recuperados: ', cantR, ' | ', ' Cantidad de casos Fallecidos: ', cantF);
		end;
	close(al);
end;

procedure procesarArchivo(Var al : archivo; var det : archivo);
var
	c, c2 : caso;
	actualNom, actualCepa : String; 
	actual: integer;
	aux : caso;
begin
	reset(al);
	reset(det);
	leer(det, c);
	writeln('CODIGO: ', c.codeL);
	while(c.codeL <> valoralto) do
		begin
			actual := c.codeL;
			actualCepa := c.codeC;
			actualNom := c.nom;
			aux.cantR := 0;
			aux.cantCN := 0;
			aux.cantC := 0;
			aux.cantF := 0;
			while(actual = c.codeL) and (actualCepa = c.codeC) do
				begin
					aux.cantCN := aux.cantCN + c.cantCN;
					aux.cantF := aux.cantF + c.cantF;
					aux.cantR := aux.cantR + c.cantR;
					aux.cantC := aux.cantC + c.cantC;
					writeln('ACTUAL: ',actual);
					writeln('CODIGO EN EL WHILE: ',c.codeL);
					writeln('ACTUAL CEPA: ',actualCepa);
					writeln('CODIGO CEPA EN EL WHILE: ',c.codeC);
					leer(det, c);
				end;
			writeln('------------------------------------');
			read(al, c2);
			writeln('CODIGO QUE LEI: ',c2.codeL);
			Writeln('CODIGO QUE BUSCO: ',actual);;
			while((c2.codeL <> actual) or (c2.codeC <> actualCepa)) and (not EOF(al)) do
				begin
					read(al, c2);
					writeln('CODIGO QUE LEI: ',c2.codeL);
					Writeln('CODIGO QUE BUSCO: ',actual);
					writeln('CODIGO DE CEPA QUE LEI: ', c2.codeC);
					writeln('CODIGO DE CEPA QUE BUSCO: ', actualCepa);
				end;
			c2.cantCN := aux.cantCN;
			c2.cantC := aux.cantC;
			c2.cantF := aux.cantF + c2.cantF;
			c2.cantR := aux.cantR + c2.cantR;
			if(EOF(al)) then
				begin
					c2.codeC := actualCepa;
					c2.nom := actualNom;
					seek(al, filesize(al));
					write(al, c2);
				end
			else
				begin
					seek(al, filepos(al) - 1);
					write(al, c2);
				end;
		end;
	close(al);
	close(det);
end;
var	
	al : archivo;
	te : text;
	det1, det2, det3 : archivo;
	ruta : string;
begin
	writeln('Ingrese ruta: ');
	readln(ruta);
	assign(al, ruta);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ7\maestro.txt';
	assign(te, ruta);
	cargarArchivo(al, te);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ7\detalle.txt';
	assign(te, ruta);
	writeln('Ingrese ruta para el detalle: ');
	readln(ruta);
	assign(det1, ruta);
	cargarArchivo(det1, te);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ7\detalle2.txt';
	assign(te, ruta);
	writeln('Ingrese ruta para el detalle: ');
	readln(ruta);
	assign(det2, ruta);
	cargarArchivo(det2, te);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ7\detalle3.txt';
	assign(te, ruta);
	writeln('Ingrese ruta para el detalle: ');
	readln(ruta);
	assign(det3, ruta);
	cargarArchivo(det3, te);
	imprimirArchivo(al);
	imprimirArchivo(det2);
	writeln('-------------------------');
	procesarArchivo(al, det1);
	writeln(1);
	procesarArchivo(al, det2);
	writeln(2);
	procesarArchivo(al, det3);
	imprimirArchivo(al);
end.




