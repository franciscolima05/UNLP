array=()
for i in $(cut -d : -f1 /etc/passwd)
do
	array+=("$i")
done


if [ $# -lt 1 ] 
then
	exit 1
fi

case $1 in
	b) 
		if [ $# -eq 2 ]
		then
			cont=0
			ok=0
			while [ $cont -le ${#array[@]} ] && [ $ok -ne 1 ]
			do
				if [ $2 = ${array[$cont]} ]
				then
					#echo "${array[$cont]}"
					ok=1
					echo "$cont"
				else
					cont=$((cont+1))
				fi
			done
			if [ $ok -eq 0 ]
			then
				echo "NO SE ENCONTRO EL USUARIO"
			fi
		else
			exit 2
		fi
	;;
	l)
		echo "${#array[@]}"
	;;
	i)
		for i in ${array[@]}
		do
			echo $i
		done
	;;
	*)
		echo "Opcion invalida"
	;;
esac


					
