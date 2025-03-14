array=(1 2 3 4 5 6 7 8 9 10)
cont=0;
for i in ${array[@]}
do
	aux=$(($i%2))
	if [ $aux -eq 0 ]
	then
		echo "$i"
	else
		cont=$(($cont+1))
	fi
done
echo "$cont"
