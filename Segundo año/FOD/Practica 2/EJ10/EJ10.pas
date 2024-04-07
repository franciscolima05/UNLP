program EJ10;
const
	valoralto = 999;
	Lim  = 15;
type
	
	cat = 1..15;
	
	empleado = record
		depto : integer;
		division : integer;
		nro : integer;
		categ : cat;
		cantHs : integer;
		end;
		
	archivo = file of empleado;
	
	vecCat = array[cat] of real;
	
procedure leer(var al : archivo; var dato : empleado);
begin
	if(not EOF(al)) then   
		read(al, dato)
	else
		dato.depto := valoralto;
end;

procedure cargarArchivo(var al : archivo; var te : text);
var
	e : empleado;
begin
	rewrite(al);
	reset(te);
	while(not EOF(te)) do
		begin
			readln(te, e.depto,e.division, e.nro, e.categ, e.cantHs);
			write(al, e);
		end;
	close(al);
	close(te);
end;


procedure cargarVector(var vec : vecCat; var te : text);
var
	x, i : integer;
	aux : real;
begin
	reset(te);
	for i := 1 to lim do
		begin
			readln(te, x, aux);
			vec[x] := aux;
		end;
end;
			

procedure procesarArchivo(var det : archivo; vec : vecCat);
var
	totalHs, totalDiv, totalDepto, actualDiv, actualDepto, actualNro: integer;
	montoTotal, montoTotalDepto, montoTotalDiv : real;
	e : empleado;
begin
	reset(det);
	leer(det, e);
	while(e.depto <> valoralto) do
		begin
			actualDepto := e.depto;
			totalDepto := 0;
			montoTotalDepto := 0;
			montoTotal := 0;
			totalHs :=0;
			while(e.depto = actualDepto) do
				begin
					totalDiv := 0;
					actualDiv := e.division;
					montoTotalDiv := 0;
					while((actualDepto = e.depto) and (actualDiv = e.division)) do
						begin
							montoTotal := 0;
							totalHs := 0;
							actualNro := e.nro;
							while((actualDepto = e.depto) and (actualDiv = e.division) and (actualNro = e.nro)) do
								begin
									totalHs := totalHs + e.cantHs;
									leer(det, e);
								end;
							montoTotal := vec[e.categ] * totalHs;
							writeln();
							writeln('Empleado nro ',actualNro, ' Trabajo un total de: ', totalHs);
							writeln('Empleado nro ',actualNro, ' le corresponde: ', montoTotal:1:0);
							montoTotalDiv := montoTotalDiv + montoTotal;
							totalDiv := totalDiv + totalHs;
						end;
					Writeln('Cantidad de horas de la division ', actualDiv,': ',totalDiv);
					Writeln('Monto total de la division ', actualDiv,': ',montoTotalDiv:1:0);
					montoTotalDepto:= montoTotalDepto + montoTotalDiv;
					totalDepto := totalDepto + totalDiv;
				end;
			writeln();
			writeln('Monto Total depto. nro',actualDepto,': ',montoTotalDepto:1:0);
			writeln('Cantidad de horas extras del depto. ',actualDepto,': ',totalDepto);
		end;
	close(det);
end;

var
	det : archivo;
	vec : vecCat;
	te : text;
	ruta : string;
begin
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ10\detalle.txt';
	assign(te, ruta);
	writeln('Ingrese ruta para el archivo');
	readln(ruta);
	assign(det, ruta);
	cargarArchivo(det, te);
	writeln('Carge el det');
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ10\categorias.txt';
	assign(te, ruta);
	cargarVector(vec, te);
	writeln('cargue el vector');
	procesarArchivo(det, vec);
end.
