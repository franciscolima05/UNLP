.data
 Tabla: .word 1, 2, 3, 4, 5
 X: .word 3
 Res: .word 0, 0, 0, 0, 0
 Cant: .word 0
 Long: .word 5
.code
 ld r1, X(r0)
 ld r2, Long(r0)
 daddi r3, r0, 0
 daddi r4, r0, 0
 daddi r8, r0, 1
 
loop: ld r5, Tabla(r3)
slt r6, r5, r1
bnez r6, esMenor
dsub r7, r5, r1
beqz r7, esMenor
sd r8, Res(r3)
daddi r4, r4, 1
esMenor: daddi r3, r3, 8
daddi r2, r2, -1
bnez r2, loop
sd r4, Cant(r0)
Halt                                                      
