.data
control: .word32 0x10000
data: .word32 0x10008

.org 100
cero: .word 1, 0, 2, 0, 3, 0  0, 1, 0 2, 0, 3, 0, 4, 1, 5, 2, 5, 3, 5, 4, 1, 4, 2, 4, 3, 4, 4, 100

.code
lwu $s0, control($0)
lwu $s1, data($0)
daddi $t0, $0, 8
sb $t0, 0($s0)
lbu $a0, 0($s1)
daddi $t1, $0, 0
daddi $t1, $0, 26
dmulu $a0, $a0, $t1
daddi $a0, $0, 140
daddi $t2, $0, 5
daddi $t3, $0, 100
loop: sb $t0, 0($a0)
daddi $a0, $a0, 8
sd $t1, 0($a0)
sb $t0, 5($s1)
sb $t1, 4($s1)
sd $t2, 0($s0)
daddi $a0, $a0, 8
beq $a0, $t3, fin
j loop

fin: halt
