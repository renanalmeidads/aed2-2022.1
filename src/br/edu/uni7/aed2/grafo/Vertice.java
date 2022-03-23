package br.edu.uni7.aed2.grafo;

import java.util.LinkedList;
import java.util.List;

public class Vertice {

    private final Integer valor;
    private final List<Vertice> vizinhos;

    public Vertice(Integer valor) {
        this.valor = valor;
        vizinhos = new LinkedList<>();
    }

    public Integer getValor() {
        return valor;
    }

    public List<Vertice> getVizinhos() {
        return vizinhos;
    }

    public void adicionar(Vertice vizinho) {
        vizinhos.add(vizinho);
    }

}
