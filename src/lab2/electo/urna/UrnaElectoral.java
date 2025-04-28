package lab2.electo.urna;

import lab2.electo.linkedlist.LinkedList;
import lab2.electo.linkedlist.Queue;
import lab2.electo.linkedlist.Stack;
import lab2.electo.urna.impl.Candidato;
import lab2.electo.urna.impl.Votante;
import lab2.electo.urna.impl.Voto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UrnaElectoral {
    private final LinkedList listaCandidatos;
    private final Stack historialVotos;
    private final Queue votosReportados;
    int idCounter;

    public UrnaElectoral() {
        this.listaCandidatos = new LinkedList();
        this.historialVotos = new Stack();
        this.votosReportados = new Queue();
        this.idCounter = 0;
    }

    public void addCandidatos(Candidato candidato) {
        if (listaCandidatos.getCandidatoID(candidato.getId()) == null) {
            listaCandidatos.insertFirst(candidato);
            return;
        }
        System.out.println("Este candidato ya ha sido registrado.");
    }

    public boolean verificarVotante(Votante votante) {
        return votante.isYaVoto();
    }

    public void registrarVoto(Votante votante, int candidatoID) {
        if (!verificarVotante(votante)) {
            if (listaCandidatos.getCandidatoID(candidatoID) != null) {
                this.idCounter++;
                Voto voto = new Voto(this.idCounter, votante.getId(), candidatoID, this.getTime());
                votante.setYaVoto(true);
                this.historialVotos.push(voto);
                this.listaCandidatos.addVoto(candidatoID, voto);
                return;
            }
            System.out.println("Este candidato no existe.");
            return;
        }
        System.out.println("Este votante ya ha sufragado.");
    }

    public void reportarVoto(Candidato candidato, int idVoto) {
        if (listaCandidatos.getCandidatoID(candidato.getId()) != null) {
            if (historialVotos.getVoto(idVoto) != null) {
                if (candidato.getVotosRecibidos().getVoto(idVoto) != null) {
                    Voto voto = candidato.getVotosRecibidos().remove(idVoto);
                    votosReportados.enQueue(voto);
                    return;
                }
                System.out.println("El voto no existe para este candidato.");
                return;
            }
            System.out.println("El voto no existe.");
            return;
        }
        System.out.println("Este candidato no existe.");
    }

    public Map<Integer, Integer> obtenerResultados() {
        Map<Integer, Integer> resultados = new HashMap<>();

        LinkedList.Node temp = listaCandidatos.getHead();
        while (temp != null) {
            int candidatoID = temp.getData().getId();
            int votos = temp.getData().getVotosRecibidos().getItems() + 1;
            resultados.put(candidatoID, votos);
            temp = temp.getNext();
        }

        return resultados;
    }

    public String getTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
