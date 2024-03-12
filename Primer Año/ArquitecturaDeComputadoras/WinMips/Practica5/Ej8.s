.data
resultado: .word 0
cadena: .word "123450"
cadena2: .word "124560"

.code
daddi $a0, $0, cadena 		;cargo dir inicial cadena1 
daddi $a1, $0, cadena2		;Cargo cadena2
jal sub
sd $v0, resultado($0)
halt

sub: dadd $v0, $0, $0 		;Inicializo mi resultado $v0 = 0
loop: lbu $t0, 0($a0)
lbu $t1, 0($a1)
beqz $t0, diferentes
beqz $t1, fin
bne $t0, $t1, fin
daddi $v0, $v0, 1
daddi $a1, $a1, 1
daddi $a0, $a0, 1
j loop
diferentes: bnez $t1, fin
daddi $v0, $0, -1
fin: jr $ra
