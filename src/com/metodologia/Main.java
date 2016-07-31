package com.metodologia;

import com.metodologia.modelos.MergeSort;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String pathEntrada = "C:\\Users\\PábloVíctor\\Documents\\GitHub\\ProjetoMC\\src\\com\\metodologia\\entrada.txt";
        String pathSaida = "C:\\Users\\PábloVíctor\\Documents\\GitHub\\ProjetoMC\\src\\com\\metodologia\\saida.txt";
        //write(pathEntrada);

        int[] num = new int[15];
        randomNumbers(num);
        System.out.println(Arrays.toString(num));

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(num, 0, num.length-1);

        System.out.println(Arrays.toString(num));
    }

    private static void write(String path){
        String[] letra = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","x","y","z"};
        int tamanho = 15;
        Random random = new Random();
        FileWriter arq = null;
        try {
            arq = new FileWriter(path);
            PrintWriter gravarArq = new PrintWriter(arq);

            for (int k = 0; k < 50; k++) {
                int tamanhoPalavra = random.nextInt(tamanho);

                if (tamanhoPalavra < 2){
                    tamanhoPalavra += random.nextInt(tamanho);
                }
                String palavra = "";
                for (int i=1; i <= tamanhoPalavra; i++) {
                    palavra += letra[random.nextInt(letra.length)];
                }
                gravarArq.printf("%s\n", palavra);
            }

            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Foi gravado");
    }

    public static void leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
                System.out.println(linha);

            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }

    public static void escritor(String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        String linha = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Escreva algo: ");
        linha = in.nextLine();
        buffWrite.append(linha + "\n");
        buffWrite.close();
    }

    private static void randomNumbers(int[] num){

        Random random = new Random();

        for (int i = 0; i < 15; i++) {
            num[i] = random.nextInt(100);
        }
    }
}
