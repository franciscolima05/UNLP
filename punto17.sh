cd /home/ubuntu_files/prueba17
for i in $(ls)
do
	var=$(echo "$i" | tr -t 'a-zA-Z' 'A-Za-z'| tr -d 'aA')
	echo $var
	
done
