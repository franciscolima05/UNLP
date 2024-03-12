.data
control: .word32 0x10000
data: .word32 0x10008
.org 50
cero: .word 1, 0, 2, 0, 3, 0, 0, 1, 0, 2, 0, 3, 0, 4, 1, 5, 2, 5, 3, 5, 4, 1, 4, 2, 4, 3, 4, 4, 100

uno: .word 1, 0, 2, 0, 3, 0, 2, 1, 2, 2, 2, 3, 2, 4, 1, 4, 100

.code
lwu $s0, control($0)
lwu $s1, data($0)
daddi $t4, $0, 8
sb $t4, 0($s0)
lb $a1, 0($s1)
daddi $t6, $0, 88
dmulu $a1, $a1, $t6
daddi $a0, $a1, 56
;daddi $a0, $0, uno
daddi $t0, $0, 5
daddi $t3, $0, 100
loop: lb $t1, 0($a0)
beq $t1, $t3, fin
daddi $a0, $a0, 8
lb $t2, 0($a0)
sb $t1, 5($s1)
sb $t2, 4($s1)
sb $t0, 0($s0)
daddi $a0, $a0, 8
j loop

fin: halt