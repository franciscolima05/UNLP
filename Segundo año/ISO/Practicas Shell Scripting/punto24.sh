vec1=(1 2 3 4 5)
vec2=(6 7 8 9 10)

for (( i=0; i<5; i++ ))
do
	sum=$((${vec1[$i]}+${vec2[$i]}))
	echo "La suma de los elementos en la posicion $i es: $sum"
done
