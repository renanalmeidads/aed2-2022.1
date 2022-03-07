package br.edu.uni7.aed2.a02complexidade;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        for (int n = 10_000_000; n < 1_000_000_000; n = n*2) {
            int[] array = randomArray(n);

            long inicio = System.currentTimeMillis();
            boolean resultado = search(array, 47);
            long fim = System.currentTimeMillis();

            System.out.println("Tamanho: " + n);
            System.out.println("Tempo: " + (fim - inicio) + " ms");
            System.out.println("Resultado: " + resultado);
            System.out.println();
        }
    }


    public static int[] randomArray(int n) {
        Random random = new Random();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt();
        }

        return array;
    }

    public static boolean search(int[] array, int x) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                return true;
            }
        }

        return false;
    }
}
