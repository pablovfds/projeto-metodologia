package com.metodologia.modelos;

public class MergeSort {

    public void sort(int[] array, int inicio, int fim){
        if (inicio < fim){
            int meio = inicio + (fim - inicio)/2;

            sort(array, inicio, meio);
            sort(array, meio+1, fim);
            merge(array, inicio, meio, fim);
        }
    }

    public void merge(int[] array, int inicio, int meio, int fim){
        int[] arrayAux = new int[array.length];

        for (int i = inicio; i <= fim; i++) {
            arrayAux[i] = array[i];
        }

        int i = inicio;
        int j = meio + 1;
        int k = inicio;

        while (i<= meio && j<= fim){
            if (arrayAux[i] <= arrayAux[j]){
                array[k] = arrayAux[i];
                i++;
            } else {
                array[k] = arrayAux[j];
                j++;
            }
            k++;
        }

        while (i<=meio){
            array[k] = arrayAux[i];
            k++;
            i++;
        }

//        for (int i = inicio; i <= meio; i++) {
//            arrayAux[i] = array[i];
//        }
//
//        for (int j = meio+1; j < fim; j++) {
//            arrayAux[fim+meio+1-j] = arrayAux[j];
//        }
//
//        int i = inicio, j = fim;
//
//        for (int k = inicio; k <= fim; k++){
//            if (arrayAux[i] < arrayAux[j]){
//                array[k] = arrayAux[i];
//                i++;
//            } else {
//                array[k] = arrayAux[j];
//                j--;
//            }
//            if (arrayAux[i].compareTo(arrayAux[j]) <= 0){
//                array[k] = arrayAux[i];
//                i++;
//            } else {
//                array[k] = arrayAux[j];
//                j--;
//            }
        }
    }

//    public void sort(int inputArr[]) {
//        this.array = inputArr;
//        this.length = inputArr.length;
//        this.tempMergArr = new int[length];
//        doMergeSort(0, length - 1);
//    }
//
//    private void doMergeSort(int lowerIndex, int higherIndex) {
//
//        if (lowerIndex < higherIndex) {
//            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
//            // Below step sorts the left side of the array
//            doMergeSort(lowerIndex, middle);
//            // Below step sorts the right side of the array
//            doMergeSort(middle + 1, higherIndex);
//            // Now merge both sides
//            mergeParts(lowerIndex, middle, higherIndex);
//        }
//    }
//
//    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
//
//        for (int i = lowerIndex; i <= higherIndex; i++) {
//            tempMergArr[i] = array[i];
//        }
//        int i = lowerIndex;
//        int j = middle + 1;
//        int k = lowerIndex;
//        while (i <= middle && j <= higherIndex) {
//            if (tempMergArr[i] <= tempMergArr[j]) {
//                array[k] = tempMergArr[i];
//                i++;
//            } else {
//                array[k] = tempMergArr[j];
//                j++;
//            }
//            k++;
//        }
//        while (i <= middle) {
//            array[k] = tempMergArr[i];
//            k++;
//            i++;
//        }

