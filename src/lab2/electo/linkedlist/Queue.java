package lab2.electo.linkedlist;

import lab2.electo.urna.impl.Voto;

public class Queue{
    private Node head;
    private Node tail;
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

    public Queue() {
        this.items = -1;
    }

    public boolean isEmpty() {
        return items == -1;
    }

    public void enQueue(Voto data) {
        Node toEnQueueNode = new Node(data);
        if (this.items == -1) {
            this.head = toEnQueueNode;
            this.tail = toEnQueueNode;
            this.items = 0;
            return;
        }
        this.items++;
        this.tail.setNext(toEnQueueNode);
        this.tail = toEnQueueNode;
    }

    public Voto deQueue() {
        if (items == -1) {
            return null;
        }
        this.items--;
        Node toDeQueueNode = this.head;
        this.head = this.head.next;
        return toDeQueueNode.data;
    }

    public Voto remove(int votoID) {
        Node temp = this.head;
        Node prev = this.head;
        while (temp != null) {
            if (temp.data.getId() == votoID) {
                prev.setNext(temp.next);
                this.items--;
                return temp.data;
            }
            prev = temp;
            temp = temp.next;
        }
        return null;
    }

    public Voto getVoto(int votoID) {
        Node temp = this.head;
        while (temp != null) {
            if (temp.data.getId() == votoID) {
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }

    public Voto peek() {
        return this.head.data;
    }

    public int getItems() {
        return this.items;
    }
}
