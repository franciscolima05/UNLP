Program EJ13;
const
	valoralto = 'zzz';
	lim = 2;
type
	vuelo = record
		destino : string;
		mes : integer;
		dia : integer;
		hora : integer;
		cantA : integer;
		end;
		
	archivo = file of vuelo;
	
	act = record
		destino : string;
		mes : integer;
		dia : integer;
		hora : integer;
		end;
	
	vecVuelo = array[1..lim] of archivo;
	
	vecReg = array[1..lim] of vuelo;
	
procedure leer(var al : archivo; var dato : vuelo);
begin
	if(Not EOF(al)) then
		read(al, dato)
	else
		dato.destino := valoralto;
end;

procedure cargarArchivoDetalle(var det : archivo; var te : text);
var
	v : vuelo;
begin
	reset(te);
	rewrite(det);
	while(not EOF(te)) do
		begin
			with v do
				readln(te, mes, dia, hora, cantA, destino);
			write(det, v);
		end;
	close(te);
	close(det);
end;	

procedure minimo(var vecA : vecVuelo; var vecR : vecReg; var min : vuelo);
var
	aux, i : integer;
begin
	min.destino := 'zzzzz';
	for i := 1 to lim do
		begin
			if(vecR[i].destino < min.destino) or ((vecR[i].destino = min.destino) and (vecR[i].mes < min.mes)) or ((vecR[i].destino = min.destino) and (vecR[i].mes = min.mes) and (vecR[i].dia < min.dia)) or ((vecR[i].destino = min.destino) and (vecR[i].mes = min.mes) and (vecR[i].dia = min.dia) and (vecR[i].hora < min.hora)) then
				begin
					min := vecR[i];
					aux := i;
				end;
		end;
	leer(vecA[aux], vecR[aux]);
end;

procedure merge(var vecA : vecVuelo; var vecR : vecReg; var al : archivo);
var
	min, v : vuelo;
	i, cantA : integer;
	actual : act;
begin
	for  i := 1 to lim do
		begin
			reset(vecA[i]);
			leer(vecA[i], vecR[i]);
		end;
	reset(al);
	minimo(vecA, vecR, min);
	while(min.destino <> valoralto) do
		begin
			cantA := 0;
			actual.destino := min.destino;
			actual.mes := min.mes;
			actual.dia := min.dia;
			Writeln('Destino Actual: ', actual.Destino); 
			Writeln('Mes Actual: ', actual.Mes); 
			Writeln('Dia Actual: ', actual.Dia); 
			actual.hora := min.hora;
			Writeln('Hora Actual: ', actual.hora); 
			while(actual.destino = min.destino) and (actual.mes = min.mes) and (actual.dia = min.dia) and (actual.hora = min.hora) do
				begin
					cantA := cantA + min.cantA;
					minimo(vecA, vecR, min);
					writeln('Destino MINIMO: ', min.destino); 
					writeln('mes MINIMO: ', min.mes); 
					writeln('Dia MINIMO: ', min.dia); 
					writeln('Hora MINIMO: ', min.hora); 
				end;
			read(al, v);
			writeln('DESTINO A BUSCAR: ', actual.destino);
			Writeln('Destino ahora: ', v.destino);
			while(v.destino <> actual.destino) do
				begin
					read(al, v);
					Writeln('Destino ahora busque : ', v.destino);
				end;
			v.cantA := v.cantA - cantA;
			seek(al, filepos(al) - 1);
			write(al, v);
			writeln('Escribi');
		end;
	for i := 1 to lim do
		close(vecA[i]);
	close(al);
end;

procedure imprimirArchivo(var al : archivo);
var
	v : vuelo;
begin
	reset(al);
	while(not EOF(al)) do
		begin
			read(al, v);
			writeln();
			writeln('DESTINO: ', v.destino);
			writeln();
			writeln('MES: ', v.mes);
			writeln();
			writeln('DIA: ', v.dia);
			writeln();
			writeln('HORA: ', v.hora);
			writeln();
			writeln('CANTIDAD DE ASIENTOS DISPONIBLES: ',v.cantA);
			writeln();
		end;
	close(al);
end;

var
	al : archivo;
	vecA : vecVuelo;
	vecR : vecReg;
	ruta : string;
	te : text;
begin
	writeln('ingrese Ruta');
	readln(ruta);
	assign(al, ruta);
	writeln('ingrese Ruta');
	readln(ruta);
	assign(vecA[1], ruta);
	writeln('ingrese Ruta');
	readln(ruta);
	assign(vecA[2], ruta);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ13\detalle.txt';
	assign(te, ruta);
	cargarArchivoDetalle(vecA[1], te);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ13\detalle2.txt';
	assign(te, ruta);
	cargarArchivoDetalle(vecA[2], te);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ13\maestro.txt';
	assign(te, ruta);
	cargarArchivoDetalle(al, te);
	imprimirArchivo(al);
	merge(vecA, vecR, al);
	writeln('----RESULTADO----');
	imprimirArchivo(al);
end.
