echo "MENU DE COMANDOS"
        echo "
        12 - Evaluacion de expresiones
        13 - Existe Archivo
        14 - Renombrador
        16 - Reporte
        17 - Invertir Min y May
        0 - Salir
        "
        opciones=(12 13 14 16 17 0)
	echo "Elije una de estas opciones"
	select op in "${opciones[@]}"
	do
        	case $op in
                	"12")
				echo "ejecutando punto 12"
				echo "ingrese operando"
				read num1
				echo "Ingrese Operadores "
				read num2 num3
                        	bash punto12c $num1 $num2 $num3
                	;;
                	"13")
				echo "Ingrese el archivo a buscar"
				read arch
                        	bash punto13c $arch
               		 ;;
               		 "14")
				echo "Ingrese directorio: "
				read dir
				echo "Ingrese cadena: "
				read cad
				echo "Ingrese opcion" 
				read opt
                        	bash punto14 $dir $cad $opt
                	;;
                	"16")
				echo "ingrese extension"
				read ext
                        	bash punto16.sh $ext
                	;;
                	"17")	
				
                        	bash punto17.sh
                	;;
                	"0")
                        	exit 0
                	;;
        	esac
	done
