.data
coorX: .byte 0 ; coordenada X de un punto
coorY: .byte 5 ; coordenada Y de un punto
color: .byte 255, 0, 255, 0 ; color: máximo rojo + máximo azul => magenta
CONTROL: .word32 0x10000
DATA: .word32 0x10008

.text
lwu $s6, CONTROL($zero) ; $s6 = dirección de CONTROL
lwu $s7, DATA($zero) ; $s7 = dirección de DATA
daddi $t0, $zero, 7 ; $t0 = 7 -> función 7: limpiar pantalla gráfica
sd $t0, 0($s6) ; CONTROL recibe 7 y limpia la pantalla gráfica
daddi $t1, $0, 8
sb $t1, 0($s6)
lbu $s0, 0($s7)
sb $s0, coorX($zero)
daddi $t1, $0, 8
sb $t1, 0($s6)
lbu $s1, 0($s7)
sb $s1, 4($s7)
sb $s0, 5($s7)
sb $s1, coorY($zero)
lwu $s2, color($zero) ; $s2 = valor de color a pintar
sw $s2, 0($s7) ; DATA recibe el valor del color a pintar
daddi $t0, $zero, 5 ; $t0 = 5 -> función 5: salida gráfica
sd $t0, 0($s6) ; CONTROL recibe 5 y produce el dibujo del punto
halt 
