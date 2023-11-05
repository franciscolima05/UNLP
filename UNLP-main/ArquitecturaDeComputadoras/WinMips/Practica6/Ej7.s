.data
num: .word 0
control: .word32 0x10000
data: .word32 0x10008
.code
lwu $s0, control($0)
lwu $s1, data($zero)
daddi $t0, $0, 8
sd $t0, 0($s0)
lbu $a0, 0($s1)
daddi $t0, $0, 0
beq $a0, $t0, cero
beq $a0, $t0, final
daddi $t0, $t0, 1
beq $a0, $t0, uno
beq $a0, $t0, final
final: halt


cero: jr $ra

uno: daddi $t0, $0, 1
daddi $t1, $0, 1
daddi $t2, $0, 3
daddi $t3, $0, 5
parte_baja: sb $t1, 5($s1)
sb $t0, 5($s1)
sd $t3, 0($s0)
daddi $t0, $t0, 1
daddi $t2, $t2, -1
beqz $t2, fin_parte_baja
j parte_baja

fin_parte_baja: daddi $t0, $0, 1
daddi $t1, $0, 2
daddi $t2, $0, 5
parte_media: sb $t1, 5($s1)
sb $t0, 4($s1)
sd $t3, 0($s0)
daddi $t0, $t0, 1
daddi $t2, $t2, -1
beqz $t2, fin_parte_media
j parte_media

fin_parte_media: daddi $t0, $0, 5
daddi $t1, $0, 1

sb $t0, 4($s1)
sb $t1, 5($s1)
sd $t3, 0($s0)
jr $ra
