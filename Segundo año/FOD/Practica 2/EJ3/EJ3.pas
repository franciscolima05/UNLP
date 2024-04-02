program EJ3;
const 	
	valoralto = 999;
type
	producto = record
		code : integer;
		nom : string;
		precio : real;
		stockA : integer;
		stockM : integer;
		end;
		
	maestro = file of producto;
	
	venta = record
		code : integer;
		cantV : integer;
		end;
		
	detalle = file of venta;
	
procedure cargarArchivo(var al : maestro; var te : text);
var
	p : producto;
begin
	rewrite(al);
	reset(te);
	while(not EOF(te)) do
		begin
			with p do
				begin
					readln(te, code);
					readln(te, nom);
					readln(te, precio);
					readln(te, stockA);
					readln(te, stockM);
				end;
			write(al, p);
		end;
	close(al);
	close(te);
end;

procedure imprimirArchivo(var al : maestro);
var
	p : producto;
begin
	reset(al);
	while(Not EOF(al)) do
		begin
			read(al, p);
			with p do
				writeln('Codigo: ', code,' | ', ' Nombre: ', nom, ' | ',' Precio: ', precio,' | ',' Stock Anual: ', stockA, ' | ',' Stock Minimo: ', stockM);
		end;
	close(al);
end;

procedure imprimirArchivoDetalle(var al : detalle);
var
	v : venta;
begin
	reset(al);
	while(Not EOF(al)) do
		begin
			read(al, v);
			with v do
				writeln('Codigo: ', code,' | ',' Ventas: ', cantV);
		end;
	close(al);
end;

procedure cargarArchivoDetalle(var al : detalle; var te : text);
var
	v : venta;
begin
	rewrite(al);
	reset(te);
	while(not EOF(te)) do
		begin
			with v do
				begin
					readln(te, code, cantV);
				end;
			write(al, v);
		end;
	close(al);
	close(te);
end;

procedure leer(var det : detalle; var dato : venta);
begin
	if(not EOF(det)) then
		read(det, dato)
	else
		dato.code := valoralto;
end;

procedure actualizarMaestro(var mae : maestro; var det : detalle);
var
	p : producto;
	v : venta;
	actual, ventasTotales : integer;
begin
	reset(mae);
	reset(det);
	leer(det, v);
	while(v.code <> valoralto) do
		begin
			actual := v.code;
			ventasTotales := 0;
			while(v.code = actual) do
				begin
					ventasTotales := ventasTotales + v.cantV;
					leer(det, v);
				end;
			read(mae, p);
			while(p.code <> actual) do
				read(mae,p);
			p.stockA := p.stockA - ventasTotales;
			seek(mae, filepos(mae) - 1);
			write(mae, p);
		end;
	close(mae);
	close(det);
end;
	
procedure exportarMinimo(var al : maestro; var te : text);
var
	p : producto;
begin
	reset(al);
	rewrite(te);
	while(not EOF(al)) do
		begin
			read(al, p);
			if(p.stockA < p.stockM) then
				begin
					with p do
						begin
							writeln(te, code, nom);
							writeln(te, precio, stockA, stockM);
						end;
				end;
		end;
	close(al);
	close(te);
end;


var
	al : maestro;
	det : detalle;
	ruta : string;
	te, te2, stockMinimo : text;
begin
	writeln('Ingrese ruta: ');
	readln(ruta);
	assign(al,ruta);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ3\maestro.txt';
	assign(te, ruta);
	writeln('Ingrese ruta del Archivo detalle: ');
	readln(ruta);
	assign(det, ruta);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ3\detalle.txt';
	assign(te2, ruta);
	cargarArchivo(al, te);
	imprimirArchivo(al);
	cargarArchivoDetalle(det, te2);
	imprimirArchivoDetalle(det);
	actualizarMaestro(al, det);
	imprimirArchivo(al);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ3\stock_minimo.txt';
	assign(stockMinimo, ruta);
	exportarMinimo(al, stockMinimo);
end.
	
