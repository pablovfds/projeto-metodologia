#! /bin/bash

while getopts a:i:o: OPCAO; do
     case "${OPCAO}" in
     	a) ALGORITHM=${OPTARG} ;;
        i) INPUTFILE=${OPTARG} ;;
        o) OUTPUTFILE=${OPTARG} ;;
        ?) echo "Algo de errado aconteceu aqui. =( . Por favor leia o arquivo README."; exit 1; ;;
     esac
 done

if [ -z $ALGORITHM ]
then
	echo "Valor do algoritmo invalido. Leia o arquivo README."
	exit
fi

# --- Clean
rm -rf ./bin/*

# --- Build
echo "Compilando arquivos"
javac -d ./bin ./src/*/*.java
echo "Arquivos compilados"

# --- Run
if [ ! -z $INPUTFILE ]
then
	if [ ! -f $INPUTFILE ]
	then
		echo "Arquivo de entrada nao existe."
		exit
	fi
	#cp -R $INPUTFILE bin/
fi

#cd bin
echo $INPUTFILE $OUTPUTFILE
case $ALGORITHM in
1)
    echo "Algoritmo paralelo"
	java -cp bin/ model/RunnerAlgotithm par $INPUTFILE $OUTPUTFILE
    echo "Processo finalizado"
;;
2)
    echo "Algoritmo sequencial"
	java -cp bin/ model/RunnerAlgotithm seq $INPUTFILE $OUTPUTFILE
    echo "Processo finalizado"
;;
*)
	echo "Algo errado aconteceu. Por favor, abra o arquivo README e verifique."
	exit
;;
esac