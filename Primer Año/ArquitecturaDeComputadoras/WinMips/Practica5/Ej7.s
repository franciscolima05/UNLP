.data
valor: .word 4
tabla: .word 2, 3, 4, 6, 7, 8
cant: .word 6
res: .word 0
.code
ld $a0, valor($zero) 	;$a0 = 4
daddi $a1, $0, tabla 	; $a1 = Offset Tabla
ld $a2, cant($zero)	; $a2 = 6
jal sub 		; salto a la subrutina
sd $v0, res($0)		;guardo el valor
halt 			;end

sub: dadd $t0, $a1, $0		;guardo cant elementos
dadd $v0, $0, $0		;Inicializo $v0 en 0		
loop: ld $t1, 0($a1)  		;Cargo en $t1 comienzo tabla
slt $t2, $a0, $a1		;Pone $t2 = 1 si es menor
bnez $t2, menor			;Comparo salto si es menor
beq $t2, $a0, menor		;Comparo salto si es igual
daddi $v0, $v0, 1		;No entro a los saltos es > entonces sumo
menor: daddi $a1, $a1, 8	;Es menor paso al siguiente elemento 
daddi $t0, $t0, -1		;resto 1 a la cant elemtnos
bnez $a2, loop			;si no llegue al final sigo buscnado
jr $ra				;return
	

