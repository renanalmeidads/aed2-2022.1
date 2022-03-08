package br.edu.uni7.aed2.a03matrizadj;

import java.util.LinkedList;
import java.util.List;

public class ListaAdjacencia {

    public static List<Vertice> lerListaDeAdjacencia(List<Integer>[] listaAdjacencia) {
        int n = listaAdjacencia.length;

        List<Vertice> vertices = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Vertice vertice = new Vertice(i);
            vertices.add(vertice);
        }

        for (int i = 0; i < n; i++) {
            Vertice verticeA = vertices.get(i);
            List<Integer> adjacentes = listaAdjacencia[i];

            for (Integer adjacente : adjacentes) {
                Vertice verticeAdjacente = vertices.get(adjacente);
                verticeA.adicionar(verticeAdjacente);
            }
        }

        return vertices;
    }

}
