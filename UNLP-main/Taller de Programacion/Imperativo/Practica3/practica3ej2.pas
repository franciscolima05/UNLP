program ej2;
type
	venta = record
		code : integer;
		fecha : integer;
		cant : integer;
		end;
		
	arb = ^nodo;
	
	nodo = record
		v : venta;
		hi : arb;
		hd : arb;
		end;
	
	
	
	vendidos = record
		code : integer;
		cant : integer;
		end;
	
	tree = ^nodo2;
	
	nodo2 = record
		ven : vendidos;
		hd : tree;
		hi : tree;
		
		end;
		
		
procedure cargararbol(var a : arb; v : venta);
begin
	if(a = nil) then
		begin
			new(a);
			a^.hi := nil; a^.hd:= nil; a^.v := v;
		end;
	else
		if(v.code > a^.v.code) then
			cargararbol(a^.hd, v);
		else
			cargararbol(a^.hi, v);
end;


procedure cargarcantidad(var tr : tree; v : vedidos);
begin
	if(tr = nil) then
		begin
			new(tr);
			tr^.hd :+ nil; tr^hi := nil; tr^.ven := v;
		end;
		if(v.code <= tr^.ven.code) then
			cargarcantidad(tr^.hi, v);
		else
			cargarcantidad(tr^.hd, v);
end;

procedure cantvendidos(a : arb; var cant : integer; var tr : tree; dato : integer);
var
	aux : vendidos;
begin
	if(a <> nil)then
		begin
			if(dato = a^.v.code) then
				begin
					cant := cant + a^.v.cant;
					cantvendidos(a^.hi, cant, tr);
					aux.code := dato;
					aux.cant := cant;
					cargarcantidad(tr, aux);
				end;
			else
				if (dato > a^.v.code) then
					cantvendidos(a^.hd, cant, tr, dato);
				else
					cantvendidos(a^.hd, cant, tr, dato);
		end;
end;


procedure retornar(a : arb; dato : integer; var cant : integer);
begin
	if(a <> nil) then
			if(dato <> a^.v.code) then
				begin
					if(dato > a^.v.code) then
						retornar(a^.hd, dato);
					else
						retornar(a^.hi, dato);
				end;
			else
				retornar := a^.v.cant;
	else
		cant := -1;
end;


procedure retornar2(tr : tree; dato : integer; var cant : integer);
begin
	if(tr <> nil) then
			if(dato <> tr^.v.code) then
				begin
					if(dato > tr^.v.code) then
						retornar(tr^.hd, dato);
					else
						retornar(tr^.hi, dato);
				end;
			else
				retornar := tr^.v.cant;
	else
		cant := -1;
end;
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
