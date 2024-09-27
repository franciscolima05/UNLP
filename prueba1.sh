arreglo=("elem1" "elem2" "elem3")
echo ${#arreglo[@]}
echo "${arreglo[@]}"
#arreglo=$(echo $arreglo "elem4")
arreglo+=("elem4")
echo ${#arreglo[@]}
echo "${arreglo[@]}"

for (( i=1; i<5; i++ )) 
do
	echo "Ingrese nro"
	read num
	arreglo+=("$num")
done

echo ${#arreglo[@]}
echo "${arreglo[@]}"
