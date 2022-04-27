package br.edu.uni7.aed2.network;

import br.edu.uni7.aed2.grafo.Aresta;

public class Enlace extends Aresta<String, Double> {

    public Enlace(Double descricao, Dispositivo dispositivoA, Dispositivo dispositivoB, Integer peso) {
        super(descricao, dispositivoA, dispositivoB, peso);

        dispositivoA.adicionar(new Aresta<>(dispositivoA, dispositivoB));
        dispositivoB.adicionar(new Aresta<>(dispositivoA, dispositivoB));
    }
}
