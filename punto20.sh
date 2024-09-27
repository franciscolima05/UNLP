function push(){
	echo "ingrese elemento: "
	read num
	pila+=("$num")
}

function pop(){
	lim=${#pila[@]}-1
	echo ${pila[$lim]}
	unset pila[$lim]
	pila=${pila[@]}
}

function lenght(){
	echo "${#pila[@]}"
}

function printPila(){
	echo "${pila[@]}"
}

opciones=("push" "lenght" "pop" "print" "quit")
#pila=()
echo "elije una de estas opciones"
select op in "${opciones[@]}"
do
	case $op in
		"push")
			push
		;;
		"pop")
			pop
		;;
		"lenght")
			lenght
		;;
		"print")
			printPila
		;;
		"quit")
			exit 0
		;;
	esac
done
