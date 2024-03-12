.data
control: .word32 0x10000
data: .word32 0x10008
num1: .word 0
num2: .word 0
res: .word 0
.code
lwu $s0, control($zero)
lwu $s1, data($zero)
jal ingreso
sd $v0, num1($zero)
jal ingreso
sd $v0, num2($0)
lbu $a0, num1($0)
lbu $a1, num2($0)
jal resultado
sd $v0, res($0)
halt

ingreso: daddi $t0, $0, 2
daddi $t1, $0, 8
sd $t1, 0($s0)
lbu $v0, 0($s1)
jr $ra

resultado: dadd $v0, $a0, $a1
jr $ra