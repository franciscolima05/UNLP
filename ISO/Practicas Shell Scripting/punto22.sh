num=(10 3 5 7 9 3 5 4)
cont=1
for i in ${num[@]}
do
	echo "$i"
	cont=$(($cont*$i))
done
echo $cont
