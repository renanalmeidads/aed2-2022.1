package br.edu.uni7.aed2;

import br.edu.uni7.aed2.network.Dispositivo;
import br.edu.uni7.aed2.network.Enlace;
import br.edu.uni7.aed2.network.Rede;

import java.util.HashSet;
import java.util.Set;

public class MainNetwork {
    public static void main(String[] args) {
        Dispositivo roteador = new Dispositivo("R1");
        Dispositivo host1 = new Dispositivo("H1");
        Dispositivo host2 = new Dispositivo("H2");
        Dispositivo sw1 = new Dispositivo("SW1");

        Enlace e1 = new Enlace(5.0, roteador, sw1, null);
        Enlace e2 = new Enlace(4.0, sw1, host1, null);
        Enlace e3 = new Enlace(3.0, sw1, host2, null);

        Set<Dispositivo> dispositivos = new HashSet(){
            {
                add(roteador);
                add(host1);
                add(host2);
                add(sw1);
            }
        };

        Rede rede = Rede.criarRede(dispositivos);
    }
}
