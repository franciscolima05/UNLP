if [ $# -lt 1 ]
then
	exit 1
fi

echo "$#"
params=("$@")

cont=1
noExiste=0
echo "${params[@]}"
for i in ${params[@]}
do
	if [ $(($cont%2)) -ne 0 ]
        then
		if [ -d "$i" ]
		then
			echo "$(file $i)"
		else
			noExiste=$(($noExiste+1))	
		fi	
        
	fi
	cont=$((cont+1))
done
echo "$noExiste"
