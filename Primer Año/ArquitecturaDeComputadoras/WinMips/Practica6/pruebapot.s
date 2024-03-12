.data
control: .word32 0x10000
data: .word32 0x10008
res: .double 0.0
num: .double 0.0 
exp: .word 0
.code
lwu $s0, control($0)
lwu $s1, data($0)
daddi $t0, $0, 8
sd $t0, 0($s0)
l.d f0, 0($s1)
sd $t0, 0($s0)
ld $a0, 0($s1)
sb $a0, exp($0)
s.d f0, num($0)
jal a_la_potencia
daddi $t0, $0, 3
s.d f1, 0($s1)
sb $t0, 0($s0)
halt 

a_la_potencia: beqz $a0, cero
daddi $t2, $0, 1
mtc1 $t2, f1
cvt.d.l f1, f1
loop: mul.d f1, f1, f0
daddi $a0, $a0, -1
beqz $a0, fin
j loop
cero: daddi $t0, $0, 1
mtc1 $t0, f0
cvt.d.l f1, f0
fin: jr $ra