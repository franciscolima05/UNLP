program EJ5;
const 
	valoralto = 999;
	lim = 3;
type 
	producto = record
		code : integer;
		nom  : string;
		desc : string;
		stockD : integer;
		stockM : integer;
		precio : real;
		end;
		
	venta = record
		code : integer;
		cant : integer;
		end;
			
			
	maestro = file of producto;
	
	detalle = file of venta;
	
	vecDetalles = array[1..lim] of detalle;

procedure leer(var det : detalle; var dato : venta);
begin
	if(not EOF(det)) then
		read(det, dato)
	else
		dato.code := valoralto;
end;

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
					readln(te, desc);
					readln(te, stockD);
					readln(te, stockM);
					readln(te, precio);
				end;
			write(al, p);
		end;
	close(al);
	close(te);
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
					readln(te, code, cant);
				end;
			write(al, v);
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
				writeln('Nombre: ', nom, ' | ', ' Codigo: ', code,' | ', ' Stock Disponible: ', stockD,' | ', ' Stock Minimo ', stockM, ' | ', ' Precio: ', precio,' | ', 'Descripcion: ', desc);
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
				writeln('Codigo: ', code,' | ', ' Cantidad: ', cant);
		end;
	close(al);
end;

procedure procesarArchivo(var vec : vecDetalles; var al : maestro);
var
	p : producto;
	v : venta;
	actual, stockDis : integer;
	i : integer;
begin
	reset(al);
	for i := 1 to lim do
		begin
			reset(vec[i]);
			leer(vec[i], v);
			while(v.code <> valoralto) do
				begin
					actual := v.code;
					stockDis := 0;
					while(actual = v.code) do
						begin
							stockDis := stockDis + v.cant;
							leer(vec[i], v);
						end;
					read(al, p);
					while(p.code <> actual) do
						read(al,p);
					p.stockD := p.stockD - stockDis;
					seek(al, filepos(al) - 1);
					write(al, p);
				end;
			close(vec[i]);
			seek(al, 0);
		end;
end;


var
	vec : vecDetalles;
	al : maestro;
	i : integer;
	te : text;
	ruta : string;
begin
	writeln('Ingrese ruta: ');
	readln(ruta);
	assign(al, ruta);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ5\maestro.txt';
	assign(te, ruta);
	cargarArchivo(al, te);
	imprimirArchivo(al);
	for i := 1 to lim do
		begin
			writeln('Ingrese ruta: ');
			readln(ruta);
			assign(te, ruta);
			writeln('Ingrese ruta para el vector: ');
			readln(ruta);
			assign(vec[i], ruta);
			cargarArchivoDetalle(vec[i], te);
		end;
	{for i := 1 to lim do
		imprimirArchivoDetalle(vec[i]);}
	procesarArchivo(vec, al);
	imprimirArchivo(al);
end.
