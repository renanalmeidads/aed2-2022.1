package br.edu.uni7.aed2.grafo;

import java.util.HashSet;
import java.util.Set;

public class Vertice {

    private final Integer valor;
    private final Set<Aresta> arestas;

    public Vertice(Integer valor) {
        this.valor = valor;
        this.arestas = new HashSet<>();
    }

    public Integer getValor() {
        return valor;
    }

    public Set<Aresta> getArestas() {
        return arestas;
    }

    public void adicionar(Aresta aresta) {
        arestas.add(aresta);
    }

}
