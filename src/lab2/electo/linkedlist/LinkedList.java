package lab2.electo.linkedlist;

import lab2.electo.urna.impl.Candidato;
import lab2.electo.urna.impl.Voto;

public class LinkedList {
    private Node head;
    private int items;

    public static class Node {
        Candidato data;
        Node next;

        public Node(Candidato data) {
            this.data = data;
            this.next = null;
        }

        public Node(Candidato data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Candidato getData() {
            return data;
        }

        public void setData(Candidato data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public LinkedList() {
        this.items = -1;
    }

    public Node getHead() {
        return this.head;
    }

    public int getItems() {
        return this.items;
    }

    public void insertFirst(Candidato data) {
        if (this.items == -1) {
            this.head = new Node(data);
            this.items = 0;
            return;
        }
        this.items++;
        this.head = new Node(data,this.head);
    }

    public void addVoto(int candidatoID, Voto voto) {
        Node temp = this.head;
        while (temp != null) {
            if (temp.data.getId() == candidatoID) {
                temp.data.agregarVoto(voto);
                break;
            }
            temp = temp.next;
        }
    }

    public Candidato getCandidatoID(int candidatoID) {
        Node temp = this.head;
        while (temp != null) {
            if (temp.data.getId() == candidatoID) {
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }
}
