program EJ9;
const
	valoralto = 999;
	lim = 3;
type
	mesa = record
		codeProv : integer;
		codeLoc : integer;
		nroMesa : integer;
		cantVotos : integer;
		end;
		
	archivo = file of mesa;

	localidad = record
		codeProv : integer;
		codeLoc : integer;
		totalLoc : integer;
		end;
		
	maestro = file of localidad;
		
	vecProv = array[1..lim] of integer;
		
procedure leer(var al : archivo; var dato : mesa);
begin
	if(not EOF(al)) then
		read(al, dato)
	else
		dato.codeProv := valoralto;
end;

procedure leerAux(var al : maestro; var dato : localidad);
begin
	if(not EOF(al)) then
		read(al, dato)
	else
		dato.codeProv := valoralto;
end;

procedure cargarArchivo(var al : archivo; var te : text);
var
	m : mesa;
begin
	rewrite(al);
	reset(te);
	while(not EOF(te)) do
		begin
			with m do
				readln(te, codeProv, codeLoc, nroMesa, cantVotos);
			write(al, m);
		end;
	close(te);
	close(al);
end;

procedure imprimirArchivo(var al : archivo);
var
	m : mesa;
begin
	reset(al);
	while(not EOF(al)) do
		begin
			read(al, m);
			writeln('PROVINCIA: ', m.codeProv);
			writeln('LOCALIDAD: ', m.codeLoc);
			writeln('MESA: ', m.nroMesa);
			writeln('Cantidad de Votos: ', m.cantVotos);
		end;
	close(al);
end;

procedure imprimirArchivoMaestro(var al : maestro; vec : vecProv);
var
	m : localidad;
	actual : integer;
begin
	reset(al);
	leerAux(al, m);
	while(m.codeProv <> valoralto) do
		begin
			actual := m.codeProv;
			while(actual = m.codeProv) do
				begin
					writeln('PROVINCIA: ', m.codeProv);
					writeln('LOCALIDAD: ', m.codeLoc);
					writeln('Cantidad de votos en ',m.codeLoc,': ',m.totalLoc);
					leerAux(al, m);
				end;
			writeln('Cantidad de votos de la provincia ',actual,': ',vec[actual]);
			writeln('------------------');
		end;
	close(al);
end;

procedure procesarArchivo(var al : maestro; var det : archivo; var vec : vecProv);
var
	total, actualProv, actualLoc : integer;
	aux : localidad;
	mAux : mesa;
begin
	reset(det);
	rewrite(al);
	leer(det, mAux);
	while(mAux.codeProv <> valoralto) do
		begin
			actualProv := mAux.codeProv;
			actualLoc := mAux.codeLoc;
			total := 0;
			while((actualProv = mAux.codeProv) and (actualLoc = mAux.codeLoc)) do
				begin
					total := total + mAux.cantVotos;
					leer(det, mAux);
				end;
			vec[actualProv] := vec[actualProv] + total;
			aux.codeProv := actualProv;
			aux.codeLoc := actualLoc;
			aux.totalLoc := total;
			write(al, aux);
		end;
	close(al);
	close(det);
end;

var
	det : archivo;
	al : maestro;
	vec : vecProv;
	ruta : string;
	te : text;
begin
	writeln('Ingrese ruta: ');
	readln(ruta);
	assign(al, ruta);
	writeln('Ingrese ruta del detalle: ');
	readln(ruta);
	assign(det, ruta);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ9\detalle.txt';
	assign(te, ruta);
	cargarArchivo(det, te);
	imprimirArchivo(det);
	procesarArchivo(al, det, vec);
	writeln('---------------');
	imprimirArchivoMaestro(al, vec);
end.
