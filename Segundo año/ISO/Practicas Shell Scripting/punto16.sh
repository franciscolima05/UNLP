for i in $(cat	/etc/passwd)
do
	user=$(echo $i | cut -d : -f1)
	#echo $user
	home=$(echo $i | cut -d : -f6)
	#echo $home

	if [ -d $home ] 
	then
		cant=$(find $home -type f -name "*$1" | wc -l)
		echo "$user $cant" >> reporte.txt
	fi
done


