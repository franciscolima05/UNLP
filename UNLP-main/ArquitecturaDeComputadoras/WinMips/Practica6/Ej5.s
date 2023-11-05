.data
control: .word32 0x10000
data: .word32 0x10008
num: .double 00.0
res: .double 000.0
pot: .word 0.0
.code
lwu $s0, control($zero)
lwu $s1, data($0)
daddi $t0, $0, 8
sd $t0, 0($s0)
ld $a1, 0($s1)
mtc1 $a1, f1
cvt.d.l f1, f1
s.d f1, num($0)
daddi $t0, $0, 8
sd $t0, 0($s0)
ld $a0, 0($s1)
sd $a0, pot($0)
beqz $a0, pot0
jal a_la_potencia
s.d f2, res($0)
s.d f2, 0($s1)
daddi $t0, $0, 3
sd $t0, 0($s0)
j fin
pot0: daddi $t2, $0, 1
mtc1 $t2, f0
cvt.d.l f0, f0
s.d f0, res($0)
s.d f0, 0($s1)
daddi $t0, $0, 3
sd $t0, 0($s0)
fin: halt


a_la_potencia: daddi $t1, $0, 1
mtc1 $t1, f2
cvt.d.l f2, f2
loop: mul.d f2, f2, f1
daddi $a0, $a0, -1
beqz $a0, listo
j loop
listo: jr $ra
