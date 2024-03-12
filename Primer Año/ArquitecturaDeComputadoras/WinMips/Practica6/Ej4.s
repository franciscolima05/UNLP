.data
control: .word32 0x10000
data: .word32 0x10008
contra: .word "abcd"
clave: .word  ""
correcto: .asciiz "Bienvenido"
incorrecto: .asciiz "Error"
.code
lwu $s0, control($0)
lwu $s1, data($0)
daddi $a0, $0, clave
jal char
daddi $a1, $0, clave
daddi $t0, $0, 0
daddi $t3, $0, 4
loop: lbu $t1, clave($t0)
lbu $t2, contra($t0)
daddi $t3, $t3, -1
beqz $t3, correcta
beq $t1, $t2, loop
j incorrecta
correcta: lbu $a2, correcto($zero)
jal respuesta
j fin
incorrecta: lbu $a2, incorrecto($zero)
jal respuesta
fin: halt 

respuesta: sd $a2, 0($s1)
daddi $t0, $0, 4
sd $t0, 0($s0)
jr $ra

char: daddi $t2, $0, 9
sd $t2, 0($s0)
lbu $v0, 0($s1)
sd $v0, 0($a0)
sd $t2, 0($s0)
lbu $v0, 0($s1)
sd $v0, 1($a0)
sd $t2, 0($s0)
lbu $v0, 0($s1)
sd $v0, 2($a0)
sd $t2, 0($s0)
lbu $v0, 0($s1)
sd $v0, 3($a0)
bnez $t0, loop

jr $ra

