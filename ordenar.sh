#! /bin/bash

while getopts a:i:o: OPCAO; do
     case "${OPCAO}" in
     	a) ALGORITHM=${OPTARG} ;;
        i) INPUTFILE=${OPTARG} ;;
        o) OUTPUTFILE=${OPTARG} ;;
        ?) echo "Please read the file README.md"; exit 1; ;;
     esac
 done
  
if [ -z $ALGORITHM ] 
then
	echo "Value invalid algorithm. Read the file README.md"
	exit
fi 
  
# --- Clean
rm -rf ./bin/*

# --- Build
echo "Compiling files..."
javac -d ./bin ./src/*/*.java
echo "Compiled files"

# --- Run
if [ ! -z $INPUTFILE ] 
then
	if [ ! -f $INPUTFILE ]
	then 
		echo "Input file does not exist"
		exit
	fi
	#cp -R $INPUTFILE bin/
fi

#cd bin
echo $INPUTFILE $OUTPUTFILE
case $ALGORITHM in 
1)
    echo "Running parallel algorithm..."
	java -cp bin/ algotithm/RunnerAlgorithm par $INPUTFILE $OUTPUTFILE
    echo "Algorithm finalized" 
;;
2)
    echo "Running sequential algorithm..."
	java -cp bin/ algotithm/RunnerAlgorithm heap $INPUTFILE $OUTPUTFILE
    echo "Algorithm finalized"
;;
*)
	echo "Something wrong happened. Please open the README.md file and check." 
	exit
;;
esac
