package lab2.electo.urna.impl;

public class Voto {
    private int id;
    private int votanteID;
    private int candidatoID;
    private String timestamp;

    public Voto(int id, int votanteID, int candidatoID, String timestamp) {
        this.id = id;
        this.votanteID = votanteID;
        this.candidatoID = candidatoID;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVotanteID() {
        return votanteID;
    }

    public void setVotanteID(int votanteID) {
        this.votanteID = votanteID;
    }

    public int getCandidatoID() {
        return candidatoID;
    }

    public void setCandidatoID(int candidatoID) {
        this.candidatoID = candidatoID;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

