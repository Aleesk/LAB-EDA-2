package lab2.electo.linkedlist;

import lab2.electo.urna.impl.Voto;

public class Stack {
    private Node top;
    private int items;

    public static class Node {
        Voto data;
        Node next;

        public Node(Voto data) {
            this.data = data;
            this.next = null;
        }

        public Voto getData() {
            return data;
        }

        public void setData(Voto data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public Stack() {
        this.items = -1;
    }

    public void push(Voto voto) {
        Node toInsertNode = new Node(voto);
        this.items++;
        toInsertNode.setNext(this.top);
        this.top = toInsertNode;
    }

    public Voto pop() {
        if (this.items == -1) {
            return null;
        }
        this.items--;
        Node toPopNode = this.top;
        this.top = toPopNode.next;
        return toPopNode.getData();
    }

    public Voto getVoto(int votoID) {
        Node temp = this.top;
        while (temp != null) {
            if (temp.data.getId() == votoID) {
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }

    public int getItems() {
        return this.items;
    }
}
