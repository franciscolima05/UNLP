.data
peso: .double 47.7
altura: .double 1.73
IMC: .double 0.0
estado: .word 0
infrapeso: .double 18.5
normal: .double 25.0
sobrepeso: .double 30.0
.code
l.d f1, peso(r0)
l.d f2, altura(r0)
mul.d f3, f2, f2 ; Altura al cuadrado
div.d f4, f1, f3
s.d f4, IMC(r0)
l.d f5, infrapeso(r0)
l.d f6, normal(r0)
l.d f7, sobrepeso(r0)
c.lt.d f4, f5
bc1t infra
c.lt.d f4, f6
bc1t normal
c.lt.d f4, f7
bc1t sobrepeso
daddi r1, r0, 4
sd r1, estado(r0)
j fin
infra: daddi r1, r0, 1
sd r1, estado(r0)
j fin
normal: daddi r1, r0, 2
sd r1, estado(r0)
j fin
sobrepeso: daddi r1, r0, 3
sd r1, estado(r0)
fin: halt