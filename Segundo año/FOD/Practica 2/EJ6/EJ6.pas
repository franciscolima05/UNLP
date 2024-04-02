program EJ6;
const
	valoralto = 999;
	lim = 5;
type

		fecha = record
			dia : integer;
			mes : integer;
			end;

		log = record
			code : integer;
			date : fecha;
			time : real;
			end;
			
		archivo = file of log;
		
		vecArch = array[1..lim] of archivo;
		
		vecReg = array[1..lim] of log;
		
procedure leer(var det : archivo; var dato : log);
begin
	if(not EOF(det)) then
		read(det, dato)
	else
		dato.code := valoralto;
end;

procedure minimo(var vecA : vecArch; var vecR : vecReg; var min : log);
var 
	aux, i : integer;
begin
	min.code := 9999;
	for i :=  1 to lim do
		begin
			if(vecR[i].code < min.code) or ((vecR[i].code = min.code) and ((vecR[i].date.mes < min.date.mes) or ((vecR[i].date.mes = min.date.mes) and (vecR[i].date.dia < min.date.dia)))) then
				begin
					min := vecR[i];
					aux := i;
				end;
		end;
	leer(vecA[aux], vecR[aux]);
end;

procedure cargarArchivo(var al : archivo; var te : text);
var
	l : log;
begin
	rewrite(al);
	reset(te);
	while(not EOF(te)) do
		begin
			with l do 
				begin
					readln(te, code);
					readln(te, date.dia);
					readln(te, date.mes);
					readln(te, time);
				end;
			write(al, l);
		end;
	close(al);
	close(te);
end;

procedure procesarArchivo(var vecA : vecArch; var vecR : vecReg; var al : archivo);
var
	sess : log;
	actual : log;
	ruta : string;
	i : integer;
begin
	for i:= 1 to lim do
		begin
			reset(vecA[i]);
			leer(vecA[i], vecR[i]);
		end;
	writeln('ingrese ruta para el maestro: ');
	readln(ruta);
	assign(al, ruta);
	rewrite(al);
	minimo(vecA, vecR, sess);
	while(sess.code <> valoralto) do
	  	begin
			actual.time := 0;
			actual.code := sess.code;
			actual.date := sess.date;
			while((actual.code = sess.code) and ((actual.date.mes = sess.date.mes) and (actual.date.dia = sess.date.dia))) do
				begin
					actual.time := actual.time + sess.time;
					minimo(vecA, vecR, sess);
			  	 end;
			write(al, actual);
	 	 end;
end;

procedure imprimirArchivo(var al : archivo);
var
	l : log;
begin
	reset(al);
	while(Not EOF(al)) do
		begin
			read(al, l);
			writeln(' | ','CODIGO: ',l.code, ' | ');
			writeln(' | ', 'DIA: ', l.date.dia, ' / ', l.date.mes, ' | ');
			writeln(' | ', 'TIEMPO: ', l.time:0:1, ' | ');
		end;
	close(al);
end;

var
	vecA : vecArch;
	vecR : vecReg;
	al : archivo;
	te : text;
	ruta : string;
	i : integer;
begin
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ6\detalle1.txt';
	assign(te, ruta);
	writeln('Ingresa ruta: ');
	readln(ruta);
	assign(vecA[1], ruta);
	cargarArchivo(vecA[1], te);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ6\detalle2.txt';
	assign(te, ruta);
	writeln('Ingresa ruta: ');
	readln(ruta);
	assign(vecA[2], ruta);
	cargarArchivo(vecA[2], te);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ6\detalle3.txt';
	assign(te, ruta);
	writeln('Ingresa ruta: ');
	readln(ruta);
	assign(vecA[3], ruta);
	cargarArchivo(vecA[3], te);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ6\detalle4.txt';
	assign(te, ruta);
	writeln('Ingresa ruta: ');
	readln(ruta);
	assign(vecA[4], ruta);
	cargarArchivo(vecA[4], te);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ6\detalle5.txt';
	assign(te, ruta);
	writeln('Ingresa ruta: ');
	readln(ruta);
	assign(vecA[5], ruta);
	cargarArchivo(vecA[5], te);
	for i := 1 to lim do
		imprimirArchivo(vecA[i]);
	procesarArchivo(vecA, vecR, al);
	imprimirArchivo(al);
end.
