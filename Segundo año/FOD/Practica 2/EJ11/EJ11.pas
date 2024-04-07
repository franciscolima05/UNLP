program EJ11;
const
	valoralto = 999;
type

	acceso = record
		ano : integer;
		mes : integer;
		dia : integer;
		id : integer;
		cantHs : integer;
		end;
		
	archivo = file of acceso;

procedure leer(var det : archivo; var dato : acceso);
begin
	if(not EOF(det)) then
		read(det, dato)
	else
		begin
			dato.ano := valoralto;
			dato.mes := valoralto;
			dato.dia := valoralto;
		end;
end;

procedure cargarArchivo(var det : archivo; var te : text);
var
	a : acceso;
begin
	reset(te);
	rewrite(det);
	while(not EOF(te)) do
		begin
			with a do
				read(te, ano, mes, dia, id, cantHs);
			write(det, a);
		end;
	close(te);
	close(det);
end;

procedure procesarArchivo(var det : archivo);
var
	ano, actualMes, actualDia, totalHAno, totalHMes, totalHDia : integer;
	a : acceso;
begin
	reset(det);
	writeln('Ingrese año a buscar: ');
	readln(ano);
	leer(det, a);
	while((a.ano <> ano) and (a.ano <> valoralto)) do
		begin
			leer(det, a);
		end;
	if(a.ano = valoralto) then	
		writeln('No se encontro el año buscado')
	else
		begin
			totalHAno := 0;
			writeln('Año: ', ano);
			while(a.ano = ano) do
				begin
					actualmes := a.mes;
					totalHMes := 0;
					writeln();
					writeln('<----Mes---->: ',actualMes);
					writeln();
					while(a.mes = actualMes) do
						begin
							actualDia := a.dia;
							totalHDia := 0;
							writeln('Dia: ',actualDia);
							while((a.mes = actualMes) and (a.dia = actualDia)) do
								begin
									writeln();
									writeln('-------------------------------------');
									writeln('ID Usuario: ',a.id, ' Tiempo total de acceso: ',a.cantHs);
									writeln();
									totalHDia := totalHDia + a.cantHs;
									leer(det, a);
								end;
							writeln('Total Dia ',actualDia,': ',totalHDia);
							totalHMes := totalHMes + totalHDia;
						end;
					writeln('Total Mes ',actualMEs,': ', totalHMes);
					totalHAno := totalHAno + totalHMes;
				end;
				writeln('Total del año', ano,': ', totalHAno);
			end;
	close(det);
end;
									
var
	det : archivo;
	te : text;
	ruta : string;
begin
	writeln('Ingrese ruta para el detalle: ');
	readln(ruta);
	assign(det, ruta);
	ruta := 'C:\Users\franp\Desktop\Practica 2\EJ11\detalle.txt';
	assign(te, ruta);
	cargarArchivo(det, te);
	procesarArchivo(det);
end.
			


