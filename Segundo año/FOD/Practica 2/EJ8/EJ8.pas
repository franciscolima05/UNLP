program EJ8;
const
	valoralto = 999;
	lim = 3;
type
	cliente = record
		code : integer;
		nom : string;
		apellido : string;
		end;
		
	venta = record
		cli : cliente;
		ano : integer;
		dia : integer;
		mes : integer;
		monto : real;
		end;
	
	id = record
		cli : cliente;
		code : integer;
		ano : integer;
		mes : integer;
		total : real;
		end;
		
	maestro = file of id;
	archivo = file of venta;
	

procedure leer(var det : archivo; var dato : venta);
begin
	if(not EOF(det)) then
		read(det, dato)
	else
		dato.cli.code := valoralto;
end;

procedure procesarArchivo(var al : maestro; var det : archivo);
var
	actual : id;
	total : real;
	v : venta;
begin
	rewrite(al);
	reset(det);
	leer(det, v);
	while(v.cli.code <> valoralto) do
		begin
			actual.cli := v.cli;
			actual.ano := v.ano;
			actual.mes := v.mes;
			total := 0;
			while(v.cli.code = actual.cli.code) and (v.ano = actual.ano) and (v.mes = actual.mes)  do
				begin
					total := total + v.monto;
					leer(det, v);
				end;
			actual.total := total;
			write(al, actual);
		end;
	close(al);
	close(det);
end;

procedure cargarArchivo(var al : archivo; var te : text);
var
	v : venta;
begin
	rewrite(al);
	reset(te);
	while(not EOF(te)) do
		begin
			readln(te, v.cli.code);
			//writeln('Codigo: ', v.cli.code);
			readln(te, v.cli.nom);
			//writeln('Nombre: ', v.cli.nom);
			readln(te, v.cli.apellido);
			//writeln('Apellido: ', v.cli.apellido);
			readln(te, v.ano);
			//writeln('Año: ', v.ano);
			readln(te, v.mes);
			//writeln('Mes: ', v.mes);
			readln(te, v.dia);
			//writeln('Dia: ', v.dia);
			readln(te, v.monto);
			write(al, v);
			//writeln('ESCRIBI');
		end;
	close(al);
	close(te);
end;

procedure imprimirArchivo(var al : archivo);
var
	v : venta;
begin
	reset(al);
	while(Not EOF(al)) do
		begin
			read(al, v);
			writeln('Codigo: ', v.cli.code);
			writeln('Nombre: ', v.cli.nom);
			writeln('Apellido: ', v.cli.apellido);
			writeln('Año: ', v.ano);
			writeln('Mes: ', v.mes);
			writeln('Dia: ', v.dia);
		end;
	close(al);
end;

procedure imprimirArchivoMaestro(var al : maestro);
var
	v : id;
begin
	reset(al);
	while(Not EOF(al)) do
		begin
			read(al, v);
			writeln(' | ','Codigo: ', v.cli.code,' | ');
			writeln('--------------------');
			writeln(' | ','Nombre: ', v.cli.nom,' | ');
			writeln('--------------------');
			writeln(' | ','Apellido: ', v.cli.apellido,' | ');
			writeln('--------------------');
			writeln(' | ','Año: ', v.ano,' | ');
			writeln('--------------------');
			writeln(' | ','Mes: ', v.mes,' | ');
			writeln('--------------------');
			writeln(' | ', 'Monto Total: ', v.total:0:1,' | ');
			writeln('--------------------');
			writeln('-----NUEVO ELEMENTO-----');
			writeln('--------------------');
		end;
	close(al);
end;

var
	ruta : string;
	te : text;
	det : archivo;
	al : maestro;
begin
	writeln('Ingrese ruta: ');
	readln(ruta);
	assign(al, ruta);
	writeln('Ingrese ruta: ');
	readln(ruta);
	assign(det, ruta);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ8\detalle.txt';
	assign(te, ruta);
	cargarArchivo(det, te);
	procesarArchivo(al, det);
	imprimirArchivoMaestro(al);
end.
	
					





