function iniciar(){
	array=($(find /home -name "*.doc"))
}

function imprimir(){
	echo "${array[@]}"
}

function verArchivo(){
	if [ $# -ne 1 ]
	then
		return 2
	fi
	encontre=0
	cont=0
	while [ $cont -le ${#array[@]} ] && [ $encontre -ne 1 ]
	do
		if [ ${array[$cont]} = $1 ]
		then
			cat $1
			encontre=1
		else
			cont=$(($cont+1))
		fi
	done
	if [ $encontre -eq 0 ]
	then
		echo "Archivo no encontrado"
		return 5
	fi
}

function cantidadArchivos(){
	echo "${#array[@]}"
}

function borrarArchivo(){
	if [ $# -ne 1 ]
	then 
		exit 2
	fi
	encontre=0
	cont=0
	while [ $cont -le ${#array[@]} ] && [ $encontre -ne 1 ]
	do
		if [ ${array[cont]}=$1 ]
		then
			encontre=1
			echo "Quiere borrarlo logicamente?"
			read op
			echo "$cont"
			unset array[$cont]
			array=$(echo ${array[@]})
			if [ $op = "no" ] 
			then
				rm -r $1
			fi
		else
			cont=$((cont=1))
		fi
	done
	
	if [ $encontre -eq 0 ]
	then
		echo "No se encontro  el archivo"
		exit 10
	fi
}


