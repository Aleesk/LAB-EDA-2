package lab2.electo.urna.impl;

import lab2.electo.linkedlist.Queue;

public class Candidato {
    private int id;
    private String nombre;
    private String partido;
    private final Queue votosRecibidos;

    public Candidato(int id, String nombre, String partido) {
        this.id = id;
        this.nombre = nombre;
        this.partido = partido;
        this.votosRecibidos = new Queue();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public Queue getVotosRecibidos() {
        return votosRecibidos;
    }

    public void agregarVoto(Voto voto) {
        votosRecibidos.enQueue(voto);
    }
}
