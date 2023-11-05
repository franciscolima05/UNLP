.data
 A: .word 0
 B: .word 2
 C: .word 2
 Cant: .word 0
.code
  
 ld r1, A(r0)
 ld r2, B(r0) 
 ld r3, C(r0)
 
 bne r1, r2, NoIgual1
 daddi r4, r0, 1
NoIgual1: bne r1, r3, NoIgual2
 daddi r4, r4, 1
 j Fin
NoIgual2: bne r2, r3, Fin
 daddi r4, r0, 1
Fin: beqz r4, Terminar
 daddi r4, r4, 1
Terminar: sd r4, Cant(r0)
 Halt