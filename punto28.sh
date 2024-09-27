if [ $# -ne 1 ]
then
	exit 2
fi
if [ -d $1 ] 
then 
	archivos=($(ls $1))
	contR=0
	contW=0
	for i in $1/*
	do
		echo "$i"
		if [ -f $i ] 
		then
			if [ -r $i ]
			then
				contR=$((contR+1))
			fi
			if [ -w $i ]
			then
				contW=$((contW+1))
			fi
		fi	
	done
	echo "CANTIDAD DE ARCHIVOS DE ESCRITURA: $contW"
	echo "CANTIDAD DE ARCHIVOS DE LECTURA: $contR"
else
	exit 4
fi

