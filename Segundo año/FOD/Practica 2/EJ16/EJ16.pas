program EJ16;
const
	valoralto = 999;
	lim = 3;
type

	moto = record
		code : integer;
		nom : string;
		modelo : string;
		marca : string;
		stockA : integer;
		end;
		
	venta = record
		code : integer;
		precio : real;
		dia : integer;
		mes : integer;
		end;
		
	maestro = file of moto;
	
	detalle = file of venta;
	
	vecArc = array[1..lim] of detalle;
	
	vecReg = array[1..lim] of venta;
	
	//vecMod = array[1..10] of 
	
procedure leer(var al : detalle; var dato : venta);
begin
	if(not EOF(al)) then
		read(al, dato)
	else
		dato.code := valoralto;
end;

procedure cargarArchivo(var al : maestro; var te : text);
var
	m : moto;
begin
	reset(te);
	rewrite(al);
	while(not EOF(te)) do
		begin
			with m do
				begin
					readln(te, code);
					readln(te, nom);
					readln(te, modelo);
					readln(te, marca);
					readln(te, stockA);
				end;
			write(al, m);
		end;
	close(te);
	close(al);
end;

procedure cargarDetalle(var al : detalle; var te : text);
var	
	v : venta;
begin
	reset(te);
	rewrite(al);
	while(not EOF(te)) do
		begin
			with v do
				begin
					readln(te, code);
					readln(te, precio);
					readln(te, dia);
					readln(te, mes);
				end;
			write(al, v);
		end;
	close(te);
	close(al);
end;

procedure minimo(var vecA : vecArc; var vecR : vecReg; var min : venta);
var
	i, aux : integer;
begin
	min.code := 9999;
	for i := 1 to lim do
		begin
			if(vecR[i].code < min.code) then
				begin
					min := vecR[i];
					aux := i;
				end;
		end;
	leer(vecA[aux], vecR[aux]);
end;

procedure procesarArchivo(var vecA : vecArc; var vecR : vecReg; var al : maestro);
var
	min : venta;
	actual : integer;
	max, m : moto;
	maxC, i, aux : integer;
begin
	reset(al);
	for i := 1 to lim do
		begin
			reset(vecA[i]);
			leer(vecA[i], vecR[i]);
		end;
	minimo(vecA, vecR, min);
	maxC := 0;
	while(min.code <> valoralto) do
		begin
			actual := min.code;
			aux := 0;
			while(actual = min.code) do
				begin
					aux := aux + 1;
					minimo(vecA, vecR, min);
				end;
			read(al, m);
			while(m.code <> actual) do
				begin
					read(al, m);
				end;
			if(m.stockA >= aux) then
				m.stockA := m.stockA - aux
			else
				m.stockA := 0;
			seek(al, filepos(al) - 1);
			write(al, m);
			if(maxC < aux) then
				begin
					maxC := aux;
					max := m;
				end;
		end;
	writeln('--------------------');
	writeln('La moto mas vendida fue: ',max.nom);
	writeln();
	writeln(max.modelo);
	writeln();
	writeln('Se vendio un total de: ',maxC,' veces');
	writeln('--------------------');
end;

procedure imprimirArchivo(var al : maestro);
var
	m : moto;
begin
	reset(al);
	while(not EOF(al)) do
		begin
			read(al, m);
			with m do
				begin
					writeln('CODIGO: ', code);
					writeln('NOMBRE :',nom);
					writeln('MARCA: ',marca);
					writeln('MODELO: ',modelo);
					writeln('STOCK ANUAL: ',stockA);
				end;
		end;
end;

var
	vecA : vecArc;
	vecR : vecReg;
	al : maestro;
	te : text;
	ruta : string;
begin
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ16\detalle1.txt';
	assign(te, ruta);
	ruta := 'a';
	assign(vecA[1], ruta);
	cargarDetalle(vecA[1], te);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ16\detalle2.txt';
	assign(te, ruta);
	ruta := 'v';
	assign(vecA[2], ruta);
	cargarDetalle(vecA[2], te);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ16\detalle3.txt';
	assign(te, ruta);
	ruta := 'C';
	assign(vecA[3], ruta);
	cargarDetalle(vecA[3], te);
	ruta := 'z';
	assign(al, ruta);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ16\maestro.txt';
	assign(te, ruta);
	cargarArchivo(al, te);
	imprimirArchivo(al);
	writeln('-----------------------------');
	procesarArchivo(vecA, vecR, al);
	writeln('RESULTADO');
	imprimirArchivo(al);
end.
				
			
