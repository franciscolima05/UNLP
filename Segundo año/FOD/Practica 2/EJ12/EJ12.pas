program EJ12;
const
	valoralto = 999;
	lim = 3;
type
	
	log = record
		nro : integer;
		nomUsuario : string;
		nom : string;
		apellido : string;
		cantMail : integer;
		end;
	
	arch = record
		nroUsuario : integer;
		destino : string;
		body : string;
		end;
		
	maestro = file of log;
	
	detalle = file of arch;
	
	vecDia = array[1..lim] of detalle;
	
procedure leer(var det : detalle; var dato : arch);
begin
	if(not EOF(det)) then
		read(det, dato)
	else
		dato.nroUsuario := valoralto;
end;

procedure cargarArchivo(var al : maestro; var te : text);
var
	aux : log;
begin
	reset(te);
	rewrite(al);
	while(not EOF(te)) do
		begin
			with aux do
				begin
					readln(te, nro, nomUsuario);
					readln(te, cantMail, nom);
					readln(te, apellido);
				end;
			write(al, aux);
		end;
	close(al);
	close(te);
end;

procedure cargarArchivoDetalle(var det : detalle; var te : text);
var 
	aux : arch;
begin
	rewrite(det);
	reset(te);
	while(not EOF(te)) do
		begin
			with aux do
				begin
					readln(te, nroUsuario);
					readln(te, destino);
					readln(te, body);
				end;
			write(det, aux);
		end;
	close(det);
	close(te);
end;

procedure procesarArchivo(var al : maestro; var vec : vecDia);
var
	aux, totalMail, actual : integer;
	a : arch;
	l : log;
begin
	reset(al);
	writeln('Ingrese dia a buscar: ');
	readln(aux);
	reset(vec[aux]);
	leer(vec[aux], a);
	while(a.nroUsuario <> valoralto) do
		begin
			actual := a.nroUsuario;
			totalMail := 0;
			while(a.nroUsuario = actual) do
				begin
					totalMail := totalMail + 1;
					leer(vec[aux], a);
				end;
			read(al, l);
			while(l.nro <> actual) do
				read(al, l);
			l.cantMail := l.cantMail + totalMail;
			seek(al, filepos(al) -1);
			write(al, l);
		end;
	close(al);
	close(vec[aux]);
end;

procedure imprimirArchivo(var al : maestro);
var
	a : log;
begin
	reset(al);
	while(Not EOF(al)) do
		begin
			read(al, a);
			with a do
				begin	
					writeln('---------------------');
					writeln();
					writeln('NUMERO: ', nro);
					writeln();
					writeln('NOMBRE DE USUARIO: ', nomUsuario);
					writeln();
					writeln('NOMBRE: ', nom);
					writeln();
					writeln('APELLIDO: ', apellido);
					writeln();
					writeln('CANTIDAD DE MAILS ENVIADOS: ',cantMail);
					writeln();
					writeln('---------------------');
				end;
		end;
	close(al);
end;

procedure procesarArchivo2(var al : maestro; var vec : vecDia; var te : text);
var
	aux, totalMail, actual : integer;
	a : arch;
	l : log;
begin
	reset(al);
	rewrite(te);
	writeln('Ingrese dia a buscar: ');
	readln(aux);
	reset(vec[aux]);
	leer(vec[aux], a);
	while(a.nroUsuario <> valoralto) do
		begin
			actual := a.nroUsuario;
			totalMail := 0;
			while(a.nroUsuario = actual) do
				begin
					totalMail := totalMail + 1;
					leer(vec[aux], a);
				end;
			read(al, l);
			while(l.nro <> actual) do
				read(al, l);
			l.cantMail := l.cantMail + totalMail;
			seek(al, filepos(al) -1);
			write(al, l);
			writeln(te, 'USUARIO NRO: ',actual, 'A ENVIADO: ', l.cantMail, ' MENSAJES');
		end;
	close(al);
	close(vec[aux]);
	close(te);
end;

procedure exportar(var al : maestro; var vec : vecDia; var te : text);
var
	actual, i : integer;
	a : arch;
	l : log;
begin
	writeln('Ingrese dia: ');
	readln(i);
	reset(al);
	reset(vec[i]);
	rewrite(te);
	leer(vec[i], a);
	while(a.nroUsuario <> valoralto) do
		begin
			actual := a.nroUsuario;
			while(a.nroUsuario = actual) do
				begin
					leer(vec[i], a);
				end;
			read(al, l);
			while(l.nro <> actual) do
				read(al, l);
			writeln(te, 'USUARIO NRO: ',actual, 'A ENVIADO: ', l.cantMail, ' MENSAJES');
		end;
	close(al);
	close(vec[i]);
	close(te);
end;

var
	al : maestro;
	vec : vecDia;
	ruta : string;
	te  : text;
begin
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ12\detalle.txt';
	assign(te, ruta);
	writeln('Ingrese ruta');
	readln(ruta);
	assign(vec[1], ruta);
	cargarArchivoDetalle(vec[1], te);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ12\detalle2.txt';
	assign(te, ruta);
	writeln('Ingrese ruta');
	readln(ruta);
	assign(vec[2], ruta);
	cargarArchivoDetalle(vec[2], te);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ12\detalle3.txt';
	assign(te, ruta);
	writeln('Ingrese ruta');
	readln(ruta);
	assign(vec[3], ruta);
	writeln('termine');
	cargarArchivoDetalle(vec[3], te);
	writeln('Ingrese ruta');
	readln(ruta);
	assign(al, ruta);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ12\Maestro.txt';
	assign(te, ruta);
	cargarArchivo(al, te);
	imprimirArchivo(al);
	//procesarArchivo(al, vec);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ12\resultado.txt';
	assign(te, ruta);
	procesarArchivo2(al, vec, te);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ12\resultado2.txt';
	assign(te, ruta);
	exportar(al, vec, te);
	writeln();
	writeln();
	writeln('----RESULTADO----');
	writeln();
	writeln();
	imprimirArchivo(al);
end.
	
