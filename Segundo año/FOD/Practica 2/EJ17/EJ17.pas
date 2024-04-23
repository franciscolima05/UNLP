Program EJ17;
const
	valoralto = 9999;
type
	
	maestro = record
		codeLoc : integer;
		nomLoc : string;
		codeMun : integer;
		nomMun : string;
		codeHos : integer;
		nomHos : string;
		mes : integer;
		dia : integer;
		cantCasos : integer;
		end;
		
	ID = record
		codeLoc : integer;
		nomLoc : string;
		codeMun : integer;
		nomMun : string;
		codeHos : integer;
		nomHos : string;
		cantCasos : integer;
		end;
		
	archivo = file of maestro;
	
procedure leer(var al : archivo; var dato : maestro);
begin
	if(not EOF(al)) then
		read(al, dato)
	else
		begin
			dato.codeLoc := valorAlto;
			dato.codeMun := valorAlto;
			dato.codeHos := valorAlto;
		end;
end;

procedure cargarArchivo(var al : archivo; var te : text);
var
	m : maestro;
begin
	reset(te);
	rewrite(al);
	while(not EOF(te)) do
		begin
			with m do
				begin
					readln(te, codeLoc, nomLoc);
					readln(te, codeMun, nomMun);
					readln(te, codeHos, nomHos);
					readln(te, mes, dia, cantCasos);
				end;
			write(al, m);
		end;
	close(te);
	close(al);
end;

procedure procesarArchivo(var al : archivo);
var
	m : maestro;
	actual : ID;
	totalProv, totalLoc, totalMun : integer;
	te : text;
begin
	reset(al);
	assign(te, 'C:\Users\franp\Desktop\Practica 2\EJ17\Texto.txt');
	rewrite(te);
	totalProv := 0;
	leer(al, m);
	while(m.codeLoc <> valoralto) do
		begin
			totalLoc := 0;
			actual.codeLoc := m.codeLoc;
			actual.nomLoc := m.nomLoc;
			writeln('Nombre Localidad: ',actual.nomLoc);
			writeln(te,actual.nomLoc);
			while(actual.codeLoc = m.codeLoc) do
				begin
					totalMun := 0;
					actual.codeMun := m.codeMun;
					actual.nomMun := m.nomMun;
					writeln('	Nombre Municipio: ',actual.nomMun);
					while(actual.codeMun = m.codeMun) do
						begin
							actual.codeHos := m.codeHos;
							actual.nomHos := m.nomHos;
							actual.cantCasos := 0;
							while(actual.codeHos = m.codeHos) do
								begin
									actual.cantCasos := actual.cantCasos + m.cantCasos;
									leer(al, m);
								end;
							writeln('		Nombre Hospital: ',actual.nomHos,' : ',actual.cantCasos);
							totalMun := totalMun + actual.cantCasos;
						end;
					if(totalMun >= 1500) then
						writeln(te, totalMun, ' ',actual.nomMun);
					writeln('	Total Municipio ',actual.nomMun,': ',totalMun);
					totalLoc := totalLoc + totalMun;
				end;
			totalProv := totalProv + totalLoc;
			writeln('Total Localidad ',actual.nomLoc,': ',totalLoc);
		end;
	writeln('Total Provincia: ',totalProv);
	close(al);
	close(te);
end;


var
	al : archivo;
	ruta : string;
	te: text;
begin
	ruta := 'A';
	assign(al, ruta);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ17\archivo.txt';
	assign(te, ruta);
	cargarArchivo(al, te);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ17\Texto.txt';
	procesarArchivo(al);
end.
