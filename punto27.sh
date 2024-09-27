function inicializar(){
	array=()
}

function agregar_elem(){
	array+=("$1")
}

function eliminar_elem(){
	if [ $1 -gt ${#array[@]} ] || [ $1 -lt 0 ] 
	then
		exit 217
	else
		echo "$array[$1]"
		unset array[$1]
		array=(${array[@]})
	fi
}

function longitud(){
	echo "${#array[@]}"
}

function imprimir(){
	echo "${array[@]}"
}

function inicializar_con_valores(){
	if [ $# -ne 2 ]
	then
		exit 205
	fi
	array=()
	for (( i=0; i<$1; i++ ))
	do
		echo "Agregando elemento, $i - $1"
		array[$i]=$2
	done
}

