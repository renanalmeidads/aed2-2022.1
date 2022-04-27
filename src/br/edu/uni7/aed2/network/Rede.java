package br.edu.uni7.aed2.network;

import br.edu.uni7.aed2.grafo.Grafo;
import br.edu.uni7.aed2.grafo.Vertice;

import java.util.HashSet;
import java.util.Set;

public class Rede extends Grafo<String, Double> {

    private Rede(Set<Vertice<String, Double>> dispositivos) {
        super(dispositivos);
    }

    public static Rede criarRede(Set<Dispositivo> dispositivos)
    {
        return new Rede(new HashSet<>(dispositivos));
    }
}
