program EJ8;
type	
	distribucion = record
		nom : string;
		ano : integer;
		num : integer;
		cantD : integer;
		//desc : string;
		end;
		
	archivo = file of distribucion;
	
procedure cargarArchivo(var al : archivo; var te : text);
var
	d : distribucion;
begin
	rewrite(al);
	reset(te);
	d.nom := 'zzz';
	d.ano := -1;
	d.num := 0;
	d.cantD := -1;
	write(al, d);
	while(Not EOF(te)) do
		begin
			readln(te, d.num);
			readln(te, d.nom);
			readln(te, d.ano, d.cantD);
			write(al, d);
		end;
	close(al);
	close(te);
end;

procedure existeDistribucion(var al : archivo; nom : string; var ok : boolean; var num : integer);
var
	d : distribucion;
begin
	reset(al);
	ok := false;
	while((not EOF(al)) and (not ok)) do
		begin
			read(al, d);
			if(d.nom = nom) then
				begin
					ok := true;
					num := filepos(al) - 1;
				end;
		end;
end;

procedure leerDis(var d : distribucion);
begin
	writeln('Ingrese nro');
	readln(d.num);
	writeln('Ingrese ano');
	readln(d.ano);
	writeln('Ingrese cantidad de desarrolladores');
	readln(d.cantD);
	writeln('Ingrese nombre');
	readln(d.nom);
end;

procedure altaDistribucion(var al : archivo);
var
	num : integer;
	d, d1 : distribucion;
	ok : boolean;
begin
	reset(al);
	leerDis(d);
	existeDistribucion(al, d.nom, ok, num);
	if(ok) then
		writeln('Ya existe esa distribucion')
	else
		begin
			seek(al, 0);
			read(al, d1);
			if(d1.num = 0) then
				begin
					seek(al, filesize(al));
					write(al, d);
				end
			else
				begin
					seek(al, (d1.num * -1));
					read(al, d1);
					writeln(filepos(al) -1);
					seek(al, filepos(al) - 1);
					write(al, d);
					seek(al, 0);
					write(al, d1);
				end;
		end;
	close(al);
end;

procedure bajaDistribucion(var al : archivo);
var
	d, Daux : distribucion;
	num : integer;
	nom : string;
	ok : boolean;
begin
	reset(al);
	writeln('Ingrese nombre a borrar');
	readln(nom);
	existeDistribucion(al, nom, ok, num);
	if(ok = false) then
		writeln('No se encontro la distribucion a eliminar')
	else
		begin
			seek(al, 0);
			read(al, d);
			seek(al, num);
			read(al, Daux);
			seek(al, filepos(al) - 1);
			write(al, d);
			seek(al, 0);
			Daux.num := num * -1;
			write(al, Daux);
		end;
	close(al);
end;

procedure imprimirArchivo(var al : archivo);
var
	d : distribucion;
begin
	reset(al);
	while(Not EOF(al)) do
		begin
			read(al, d);
			writeln('NUMERO: ',d.num);
			writeln('NOMBRE: ', d.nom);
			writeln('CANTIDAD DE DESARROLLADORES: ',d.cantD);
			writeln('AÑO: ',d.ano);
		end;
	close(al);
end;

var
	al : archivo;
	ok : boolean;
	te : text;
	op : char;
begin
	assign(al, 'a');
	assign(te, 'C:\Users\franp\Desktop\Practica 3\EJ8\carga.txt');
	cargarArchivo(al, te);
	ok := true;
	while(ok) do
		begin
			writeln('Ingrese Opcion');
			readln(op);
			case op of
				'A': altaDistribucion(al);
				'B': bajaDistribucion(al);
				'C': imprimirArchivo(al);
				'D': ok := false;
			end;
		end;
end.
	
	
