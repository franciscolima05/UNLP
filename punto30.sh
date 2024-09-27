if [ ! -d $HOME/bin ]
then
	mkdir $HOME/bin
fi
cont=0
for i in $(ls)
do
	echo "$i"
	if [ -f $i ]
	then
		mv $i $HOME/bin
		cont=$((cont+10))
		echo "MOVI A: $i"
	fi
done
