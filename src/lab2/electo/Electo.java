package lab2.electo;

import lab2.electo.urna.UrnaElectoral;
import lab2.electo.urna.impl.Candidato;
import lab2.electo.urna.impl.Votante;

import java.util.Map;

/*
* Estructura de Datos y Algoritmos
* Laboratorio 2: Votación
*
* Autores:
*   Alexander Bravo
*   Eduardo Vergara
*
* Profesora:
*   Valentina Aravena
*
* Repositorio:
*   https://github.com/Aleesk/LAB-EDA-2
*/

public class Electo {
    public static void main(String[] args) {
        UrnaElectoral urna = new UrnaElectoral();
        Candidato c1 = new Candidato(1, "N1", "P1");
        Candidato c2 = new Candidato(2, "N2", "P2");
        Candidato c3 = new Candidato(3, "N3", "P3");

        urna.addCandidatos(c1);
        urna.addCandidatos(c2);
        urna.addCandidatos(c3);

        Votante v1 = new Votante(1, "Mateo");
        urna.registrarVoto(v1, c2.getId());
        urna.registrarVoto(v1, c1.getId()); //Votante 1 ya ha votado

        Votante v2 = new Votante(2, "Lucas");
        urna.registrarVoto(v2, c3.getId());

        Votante v3 = new Votante(3, "Alexander");
        urna.registrarVoto(v3, c2.getId());

        urna.reportarVoto(c1, v1.getId()); //El candidato 1 no tiene el voto de votante 1

        Votante v4 = new Votante(4, "Eduardo");
        urna.registrarVoto(v4, c3.getId());

        Votante v5 = new Votante(5, "Sebastian");
        urna.registrarVoto(v5, c1.getId());

        Map<Integer, Integer> resultados = urna.obtenerResultados();
        System.out.println("---------------------------------------");
        for (Map.Entry<Integer, Integer> entry : resultados.entrySet()) {
            System.out.println("Candidato ID: " + entry.getKey() + " (" + entry.getValue() + " votos)");
        }
        urna.reportarVoto(c1, v5.getId());
        urna.reportarVoto(c3, v4.getId());

        resultados = urna.obtenerResultados();
        System.out.println("---------------------------------------");
        for (Map.Entry<Integer, Integer> entry : resultados.entrySet()) {
            System.out.println("Candidato ID: " + entry.getKey() + " (" + entry.getValue() + " votos)");
        }
    }
}