package br.edu.uni7.aed2.grafo;

public interface Visitante {

    /**
     * Visita um vértice durante um percurso no grafo
     * @param vertice o vértice sendo visitado
     * @param aresta a aresta utilizada para alcançar o vértice
     * @return true caso o percurso deva ser encerrado, false caso contrário
     */
    boolean visitar(Vertice vertice, Aresta aresta);

}
