package br.edu.uni7.aed2.a04bfs;

public class Main {

    public static Grafo gerarGrafo() {
        Grafo grafo = new Grafo();
        Vertice v1 = new Vertice(1);
        Vertice v2 = new Vertice(2);
        Vertice v3 = new Vertice(3);
        Vertice v4 = new Vertice(4);
        Vertice v5 = new Vertice(5);

        grafo.addVertice(v1);
        grafo.addVertice(v2);
        grafo.addVertice(v3);
        grafo.addVertice(v4);
        grafo.addVertice(v5);

        v1.adicionar(v2);
        v2.adicionar(v1);
        v2.adicionar(v4);
        v3.adicionar(v4);
        v3.adicionar(v5);
        v4.adicionar(v2);
        v4.adicionar(v3);
        v4.adicionar(v5);
        v5.adicionar(v3);
        v5.adicionar(v4);

        return grafo;
    }

    public static void main(String[] args) {
        Grafo grafo = gerarGrafo();
        Vertice vertice = grafo.getVerticeNoIndice(3);
        boolean resultado = grafo.bfs(vertice, 1);
        System.out.println("resultado: " + resultado);
    }

}
