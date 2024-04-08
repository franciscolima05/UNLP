program EJ14;
const
	valoralto = 999;
	lim = 3;
type
	prov = record
		codeProv : integer;
		nomProv : string;
		codeLoc : integer;
		nomLoc : string;
		sinLuz : integer;
		sinGas : integer;
		chapa : integer;
		sinAgua : integer;
		sinBano : integer;
		end;
		
	det = record
		codeProv : integer;
		codeLoc : integer;
		conLuz : integer;
		conGas : integer;
		chapa : integer;
		conAgua : integer;
		conBano : integer;
		end;
		
	maestro = file of prov;
	detalle = file of det;
		
	vecArc = array[1..lim] of detalle;
	vecReg = array[1..lim] of det;
	
procedure leer(var al : detalle; var dato : det);
begin
	if(not EOF(al)) then
		read(al, dato)
	else
		dato.codeProv := valoralto;
end;

procedure minimo(var vecA : vecArc; var vecR : vecReg; var min : det);
var
	aux, i : integer;
begin
	min.codeProv := 9999;
	for i := 1 to lim do
		begin
			if (vecR[i].codeProv < min.codeProv) or ((vecR[i].codeProv = min.codeProv) and (vecR[i].codeLoc < min.codeLoc)) then
				begin
					min := vecR[i];
					aux := i;
				end;
		end;
	leer(vecA[aux], vecR[aux]);
end;

procedure cargarArchivo(var al : maestro; var te : text);
var
	p : prov;
begin
	reset(te);
	rewrite(al);
	while(not EOF(te)) do
		begin
			with p do
				begin
					readln(te, codeProv, nomProv);
					readln(te, codeLoc, nomLoc);
					readln(te, sinLuz, sinGas, chapa, sinAgua, sinBano);
				end;
			write(al, p);
		end;
	close(al);
	close(te);
end;

procedure cargarArchivoDetalle(var al : detalle; var te : text);
var
	d : det;
begin
	reset(te);
	rewrite(al);
	while(not EOF(te)) do
		begin
			with d do
				readln(te, codeProv, codeLoc, conLuz, conGas, chapa, conAgua, conBano);
			write(al, d);
		end;
	close(al);
	close(te);
end;

procedure procesarArchivo(var vecA : vecArc; var vecR : vecReg; var al : maestro);
var
	min, actual : det;
	i : integer;
	aux : prov;
begin
	for i := 1 to lim do
		begin
			reset(vecA[i]);
			leer(vecA[i], vecR[i]);
		end;
	reset(al);
	minimo(vecA, vecR, min);
	while(min.codeProv <> valoralto) do
		begin
			actual.codeProv := min.codeProv;
			actual.codeLoc := min.codeLoc;
			actual.conLuz := 0;
			actual.conGas := 0;
			actual.conAgua := 0;
			actual.chapa := 0;
			actual.conBano := 0;
			while(min.codeProv = actual.codeProv) and (min.codeLoc = actual.codeloc) do
				begin
					actual.conLuz := actual.conLuz + min.conLuz;
					actual.conGas := actual.conGas + min.conGas;
					actual.conAgua := actual.conAgua + min.conAgua;
					actual.chapa := actual.chapa + min.chapa;;
					actual.conBano := actual.conBano + min.conBano;
					minimo(vecA, vecR, min);
				end;
			read(al, aux);
			while(aux.codeProv <> actual.codeProv) or (aux.codeLoc <> actual.codeLoc) do
				read(al, aux);
			aux.sinLuz := aux.sinLuz - actual.conLuz;
			aux.sinGas := aux.sinGas - actual.conGas;
			aux.sinAgua := aux.sinAgua - actual.conAgua;
			aux.sinBano := aux.sinBano - actual.conBano;
			aux.chapa := aux.chapa - actual.chapa;
			if(aux.chapa = 0) then
				writeln('LA LOCALIDAD: ',aux.nomLoc,' NO TIENE CASAS DE CHAPA');
			seek(al,filepos(al) - 1);
			write(al, aux);
		end;
	for i := 1 to lim do
		close(vecA[i]);
	close(al);
end;

procedure imprimirArchivo(var al : maestro);
var
	p : prov;
begin
	reset(al);
	while(not EOF(al)) do 
		begin
			read(al, p);
			with p do
				begin
					writeln('--------------------');
					writeln('CODIGO DE PROVINCIA: ',codeProv);
					writeln();
					writeln('PROVINCIA: ', nomProv);
					writeln();
					writeln('CODIGO DE LOCALIDAD: ', codeLoc);
					writeln();
					writeln('LOCALIDAD: ',nomLoc);
					writeln();
					writeln('CANTIDAD DE CASAS SIN LUZ: ', sinLuz);
					writeln();
					writeln('CANTIDAD DE CASAS SIN GAS: ', sinGas);
					writeln();
					writeln('CANTIDAD DE CASAS SIN AGUA: ', sinAgua);
					writeln();
					writeln('CANTIDAD DE CASAS CON TECHO DE CHAPA: ', chapa);
					writeln();
					writeln('CANTIDAD DE CASAS SIN BANO: ', sinBano);
					writeln('--------------------');
				end;
		end;
	close(al);
end;

procedure imprimirArchivoDetalle(var al : detalle);
var
	p : det;
begin
	reset(al);
	while(not EOF(al)) do 
		begin
			read(al, p);
			with p do
				begin
					writeln('--------------------');
					writeln('CODIGO DE PROVINCIA: ',codeProv);
					writeln();
					writeln('CODIGO DE LOCALIDAD: ', codeLoc);
					writeln();
					writeln('CANTIDAD DE CASAS CON LUZ: ', conLuz);
					writeln();
					writeln('CANTIDAD DE CASAS CON GAS: ', conGas);
					writeln();
					writeln('CANTIDAD DE CASAS CON AGUA: ', conAgua);
					writeln();
					writeln('CANTIDAD DE CASAS CON TECHO DE CHAPA: ', chapa);
					writeln();
					writeln('CANTIDAD DE CASAS CON BANO: ', conBano);
					writeln('--------------------');
				end;
		end;
	close(al);
end;

var
	vecA : vecArc;
	vecR : vecReg;
	ruta : string;
	al :  maestro;	
	te : text;
begin
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ14\detalle1.txt';
	assign(te, ruta);
	writeln('Ingrese ruta detalle 1: ');
	readln(ruta);
	assign(vecA[1], ruta);
	cargarArchivoDetalle(vecA[1], te);
	imprimirArchivoDetalle(vecA[1]);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ14\detalle2.txt';
	assign(te, ruta);
	writeln('Ingrese ruta detalle 2: ');
	readln(ruta);
	assign(vecA[2], ruta);
	cargarArchivoDetalle(vecA[2], te);
	imprimirArchivoDetalle(vecA[2]);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ14\detalle3.txt';
	assign(te, ruta);
	writeln('Ingrese ruta detalle 3: ');
	readln(ruta);
	assign(vecA[3], ruta);
	cargarArchivoDetalle(vecA[3], te);
	imprimirArchivoDetalle(vecA[3]);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ14\maestro.txt';
	assign(te, ruta);
	writeln('Ingrese ruta maestro: ');
	readln(ruta);
	assign(al, ruta);
	cargarArchivo(al, te);
	imprimirArchivo(al);
	procesarArchivo(vecA, vecR, al);
	writeln();
	writeln('----RESULTADO----');
	writeln();
	imprimirArchivo(al);
end.
				
			
