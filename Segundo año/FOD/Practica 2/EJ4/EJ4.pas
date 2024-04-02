program EJ4;
const
	valoralto = 999;
type
	provincia = record
		nom : string;
		cantA : integer;
		cantE : integer;
		end;
	
	censo = record
		nom : string;
		code : integer;
		cantA : integer;
		cantE : integer;
		end;
		
	maestro = file of provincia;
	
	detalle = file of censo;
	
procedure leer(var al : detalle; var dato : censo);
begin
	if(not EOF(al)) then
		read(al, dato)
	else
		dato.code := valoralto;
end;

procedure cargarArchivo(var al : maestro; var te : text);
var
	p : provincia;
begin
	rewrite(al);
	reset(te);
	while(not EOF(te)) do
		begin
			with p do 
				begin
					readln(te, nom);
					readln(te, cantA);
					readln(te, cantE);
				end;
			write(al, p);
		end;
	close(al);
	close(te);
end;

procedure cargarArchivoDetalle(var al : detalle; var te : text);
var
	c : censo;
begin
	rewrite(al);
	reset(te);
	while(not EOF(te)) do
		begin
			with c do 
				begin
					readln(te, code);
					readln(te, nom);
					readln(te, cantA);
					readln(te, cantE);
				end;
			write(al, c);
		end;
	close(al);
	close(te);
end;


procedure imprimirArchivo(var al : maestro);
var
	p : provincia;
begin
	reset(al);
	while(Not EOF(al)) do
		begin
			read(al, p);
			with p do
				writeln('Nombre de la Provincia: ', nom, ' | ', 'Cantidad de personas Alfabetizadas: ', cantA, ' | ', 'Cantidad de Encuestados: ',cantE);
		end;
	close(al);
end;


procedure imprimirArchivoDetalle(var al : detalle);
var
	c : censo;
begin
	reset(al);
	while(Not EOF(al)) do
		begin
			read(al, c);
			with c do
				writeln('Codigo: ', code,' | ',' Nombre de la Provincia: ', nom,' | ','Cantidad de personas Alfabetizadas: ', cantA, ' | ', 'Cantidad de Encuestados: ',cantE);
		end;
	close(al);
end;

procedure procesarArchivo(var al : maestro; var det : detalle);
var
	actual : String; 
	cantAlf, cantEnc : integer;
	p : provincia;
	c : censo;
begin
	reset(al);
	reset(det);
	leer(det, c);
	while(c.code <> valoralto) do
		begin
			actual := c.nom;
			cantAlf := 0;
			cantEnc := 0;
			while(c.nom = actual) do
				begin
					cantAlf := cantAlf + c.cantA;
					cantEnc := cantEnc + c.cantE;
					leer(det, c);
				end;
			read(al, p);
			writeln(p.nom, actual);
			while(p.nom <> actual) do
				read(al, p);
			p.cantA := p.cantA + cantAlf;
			p.cantE := p.cantE + cantEnc;
			seek(al, filepos(al) - 1);
			write(al, p);
		end;
	close(al);
	close(det);
end;

var
	mae : maestro;
	det, det2 : detalle;
	te, te2, te3 : text;
	ruta : string;
begin
	writeln('Ingrese ruta: ');
	readln(ruta);
	assign(mae, ruta);
	writeln('Ingrese ruta para el archivo detalle: ');
	readln(ruta);
	assign(det, ruta);
	writeln('Ingrese ruta para el segundo archivo detalle: ');
	readln(ruta);
	assign(det2, ruta);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ4\maestro.txt';
	assign(te, ruta);
	cargarArchivo(mae, te);	
	imprimirArchivo(mae);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ4\detalle.txt';
	assign(te2, ruta);
	cargarArchivoDetalle(det, te2);	
	imprimirArchivoDetalle(det);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ4\detalle2.txt';
	assign(te3, ruta);
	cargarArchivoDetalle(det2, te3);
	imprimirArchivoDetalle(det2);
	procesarArchivo(mae, det);
	imprimirArchivo(mae);
	procesarArchivo(mae, det2);
	imprimirArchivo(mae);
end.
					
					
					
					
					
					
					
					
					
					
					
