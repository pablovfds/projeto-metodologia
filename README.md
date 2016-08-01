# Projeto da Disciplina de Metodologia Científica - DSC - UFCG

#### Alunos:
  - Pablo Victor Felix dos Santos 113210582
  - Wendley Paulo de França 113210444
  
#### Título: 
Investigação empírica do uso do paralelismo no problema de ordenação para grandes volumes de dados

#### Uso:

```sh
$ ordenar.sh -a <algorithm> [-i <inputFile>, -o <outputFile>]
```

#### Opções:
  - -a = número do algoritmo
  - -i = arquivo de entrada
  - -o = arquivo de saida
	
#### Algoritmos:
  - 1 - MergeSort Paralelo
  - 2 - HeapSort Sequencial

#### Exemplos:
MergeSort Paralelo
```sh
$ bash ordenar.sh -a 1 -i input.txt -o output.txt
```
HeapSort Sequencial
```sh
$ bash ordenar.sh -a 2 -i input.txt -o output.txt
```

OBS: Caso não seja especificado um caminho, o arquivo de saida é gerado na pasta
em que o script foi executado.
