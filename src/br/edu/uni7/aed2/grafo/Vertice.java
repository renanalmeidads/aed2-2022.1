package br.edu.uni7.aed2.grafo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Vertice<T> {

    private final T valor;
    private final Set<Aresta<T>> arestas;

    public Vertice(T valor) {
        this.valor = valor;
        this.arestas = new HashSet<>();
    }

    public T getValor() {
        return valor;
    }

    public Set<Aresta<T>> getArestas() {
        return arestas;
    }

    public void adicionar(Aresta aresta) {
        arestas.add(aresta);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice vertice = (Vertice) o;
        return valor.equals(vertice.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}
