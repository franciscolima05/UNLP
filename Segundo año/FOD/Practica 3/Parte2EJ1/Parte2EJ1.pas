program Parte2EJ1;
const
	valoralto = 999;
type
	producto = record
		code : integer;
		nom : string;
		stockA : integer;
		stockM : integer;
		end;
	
	venta = record
		code : integer;
		cant : integer;
		end;
		
	maestro = file of producto;
	
	detalle = file of venta;
	
procedure leer(var al : detalle; var dato : venta);
begin
	if(not EOF(al)) then
		read(al, dato)
	else
		dato.code := valoralto;
end;
	
procedure cargarArchivoMaestro(var al : maestro; var te : text);
var
	p : producto;
begin
	reset(te);
	rewrite(al);
	while(not EOF(te)) do
		begin
			readln(te, p.code, p.stockA, p.stockM);
			readln(te, p.nom);
			write(al, p);
		end;
	close(al); 
	close(te);
end;

procedure cargarArchivoDetalle(Var al : detalle; var te : text);
var
	v : venta;
begin
	reset(te);
	rewrite(al);
	while(Not EOF(te)) do
		begin
			readln(te, v.code, v.cant);
			write(al, v);
		end;
	close(al);
	close(te);
end;

procedure actualizarMaestro(var al : maestro; var det : detalle);
var
	v : venta;
	p : producto;
begin
	reset(det);
	reset(al);
	leer(det, v);
	while(v.code <> valoralto) do
		begin
			seek(al, 0);
			read(al, p);
			while(p.code <> v.code) and (not EOF(al)) do
				read(al, p);
			p.stockA := p.stockA - v.cant;
			if(p.stockA < 0) then
				p.stockA := 0;
			seek(al, filepos(al) -1);
			write(al, p);
			leer(det, v);
		end;
	close(al);
	close(det);
end;

procedure imprimirArchivo(var al : maestro);
var
	p : producto;
begin
	reset(al);
	while(not EOF(al))do
		begin
			read(al, p);
			writeln('NOMBRE: ',p.nom);
			writeln('CODIGO: ',p.code);
			writeln('STOCK ACTUAL : ', p.stockA);
			writeln('STOCK MINIMO: ', p.stockM);
		end;
	close(al);
end;

var
	al : maestro;
	det : detalle;
	te : text;
begin
	assign(al, 'A');
	assign(det, 'B');
	assign(te, 'C:\Users\franp\Desktop\Practica 3\Parte2EJ1\maestro.txt');
	cargarArchivoMaestro(al, te);
	assign(te, 'C:\Users\franp\Desktop\Practica 3\Parte2EJ1\detalle.txt');
	cargarArchivoDetalle(det, te);
	imprimirArchivo(al);
	actualizarMaestro(al, det);
	writeln();
	writeln('------');
	writeln();
	imprimirArchivo(al);
end.
			

