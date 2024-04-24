program Parte2EJ3;
const
	valoralto = 9999;
	lim = 3;
type
	log = record
		code : integer;
		dia : integer;
		mes : integer;
		time : real;
		end;

	
	detalle = file of log;
	
	maestro = file of log;
	
	vecReg = array[1..lim] of log;
	
	vecArc = array[1..lim] of detalle;
	
procedure leer(var al : detalle; var dato : log);
begin
	if(not EOF(al)) then
		read(al, dato)
	else
		dato.code := valoralto;
end;

procedure cargarArchivo(var al : detalle; var te : text);
var
	l : log;
begin
	rewrite(al);
	reset(te);
	while(not EOF(te)) do
		begin
			readln(te, l.code, l.mes, l.dia, l.time);
			write(al, l);
		end;
	close(al);
	close(te);
end;

procedure minimo(var vecR : vecReg; var vecA : vecArc; var min : log);
var
	aux, i : integer;
begin
	min.code := 9999;
	for i := 1 to lim do
		begin
			if(vecR[i].code < min.code) or ((vecR[i].code = min.code) and (vecR[i].mes < min.mes)) or ((vecR[i].code = min.code) and (vecR[i].mes = min.mes) and(vecR[i].dia < min.dia)) then
				begin
					min := vecR[i];
					aux := i;
				end;
		end;
	leer(vecA[aux], vecR[aux]);
end;

procedure contain(var al : maestro; aux : log; var ok : boolean; var num : integer);
var
	l : log;
begin
	ok := false;
	seek(al, 0);
	num := -1;
	while((not EOF(al)) and (not ok)) do
		begin
			read(al, l);
			num := num + 1;
			if((aux.code = l.code) and (aux.mes = l.mes) and (aux.dia = l.dia)) then
				ok := true;
		end;
end;


procedure procesar(var vecR : vecReg; var vecA : vecArc; var al : maestro);
var
	aux, aux2 : log;
	ok : boolean;
	num, i : integer;
begin
	rewrite(al);
	for i := 1 to lim do
		begin
			reset(vecA[i]);
			read(vecA[i], vecR[i]);
		end;
	minimo(vecR, vecA, aux);
	while(aux.code <> valoralto) do
		begin
			contain(al, aux, ok, num);
			writeln(ok);
			if(ok) then
				begin
					seek(al, num);
					read(al, aux2);
					aux2.time := aux2.time + aux.time;
					seek(al, filepos(al) - 1);
					write(al, aux2);
				end
			else
				begin
					seek(al, filesize(al));
					write(al, aux);
				end;
			minimo(vecR, vecA, aux);
		end;
	close(al);
	for i := 1 to lim do
		begin
			close(vecA[i]);
		end;
end;

procedure imprimirArchivo(var al : maestro);
var
	l : log;
begin
	reset(al);
	while(not EOF(al)) do
		begin
			read(al, l);
			writeln('CODIGO: ',l.code);
			writeln('MES: ',l.mes,' / DIA: ',l.dia);
			writeln('TOTAL: ',l.time:0:1);
		end;
	close(al);
end;


var
	al : maestro;
	vecR : vecReg;
	vecA : vecArc;
	te : text;
begin
	assign(al, 'a');
	assign(vecA[1], 'b');
	assign(te, 'C:\Users\franp\Desktop\Practica 3\Parte2EJ3\carga1.txt');
	cargarArchivo(vecA[1], te);
	assign(vecA[2], 'c');
	assign(te, 'C:\Users\franp\Desktop\Practica 3\Parte2EJ3\carga2.txt');
	cargarArchivo(vecA[2], te);
	assign(vecA[3], 'd');
	assign(te, 'C:\Users\franp\Desktop\Practica 3\Parte2EJ3\carga3.txt');
	cargarArchivo(vecA[3], te);
	procesar(vecR, vecA, al);
	writeln('EDELP');
	imprimirArchivo(al);
end.
