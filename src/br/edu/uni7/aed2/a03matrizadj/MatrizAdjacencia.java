package br.edu.uni7.aed2.a03matrizadj;

import java.util.LinkedList;
import java.util.List;

public class MatrizAdjacencia {

    public static List<Vertice> lerMatrizDeAdjacencia(boolean[][] matriz) {
        int n = matriz.length;

        List<Vertice> vertices = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Vertice v = new Vertice(i);
            vertices.add(v);
        }

        for (int i = 0; i < n; i++) {
            Vertice verticeA = vertices.get(i);

            for (int j = 0; j < matriz[i].length; j++) {
                Vertice verticeB = vertices.get(j);

                if (matriz[i][j]) {
                    verticeA.adicionar(verticeB);
                }
            }
        }

        return vertices;
    }

}
