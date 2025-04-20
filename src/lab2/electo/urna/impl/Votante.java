package lab2.electo.urna.impl;

public class Votante {
    int id;
    String nombre;
    boolean yaVoto;

    public Votante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.yaVoto = false;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isYaVoto() {
        return yaVoto;
    }

    public void setYaVoto(boolean yaVoto) {
        this.yaVoto = yaVoto;
    }

    public void marcarComoVotado() {
        this.setYaVoto(true);
    }
}
