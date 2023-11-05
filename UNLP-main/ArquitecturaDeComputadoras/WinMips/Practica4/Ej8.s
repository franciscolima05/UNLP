.data 
Num1: .word 2
Num2: .word 5
Res: .word 0
.code
ld r1, Num1(r0)
ld r2, Num2(r0)
daddi r3, r0, 0
loop: daddi r2, r2, -1
bnez r2, loop
dadd r3, r3, r1
sd r3, Res(r0)
Halt
