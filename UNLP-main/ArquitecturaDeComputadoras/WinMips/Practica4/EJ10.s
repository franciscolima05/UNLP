.data
cadena: .asciiz "adbdcdedfdgdhdid"
car: .asciiz "d" 
cant: .word 0

.code

lbu r1, car(r0)
daddi r2, r0, 0
daddi r3, r0, 0
loop: lbu r4, cadena(r2)
beqz r4, Fin 
dsub r5, r4, r1
bnez r5, Distintos
daddi r3, r3, 1
Distintos: daddi r2, r2, 1
j loop
Fin: sd r3, cant(r0)
Halt