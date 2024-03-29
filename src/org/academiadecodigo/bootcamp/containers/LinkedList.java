package org.academiadecodigo.bootcamp.containers;

public class LinkedList<T> {

    private Node head;
    private int length = 0;

    public LinkedList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     * @param data the element to add
     */
    public void add(T data)  {

        Node node = new Node(data);
        Node iterator = head;
        while (iterator.getNext() != null){
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     * @param index the index of the element
     * @return the element
     */
    public T get(int index) {

        //throw new UnsupportedOperationException();

        Node iterator = head;
        if (this.length <= index){
            return null;
        }
        for (int i = -1; i < index; i++){
            iterator = iterator.getNext();
        }
        return iterator.getData();
    }

    /**
     * Returns the index of the element in the list
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element000.
     * .
     * 0
     */
    public int indexOf(T data) {

        //throw new UnsupportedOperationException();
        int pos = -1;
        Node iterator = head;
        while (iterator.getData() != data){
            if(iterator.getNext() == null){
                return -1;
            }
            iterator = iterator.getNext();
            pos++;
        }
        return pos;
    }

    /**
     * Removes an element from the list
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(T data) {

       // throw new UnsupportedOperationException();

        int index = this.indexOf(data);
        if (index == -1){return false;}
        Node iterator = head;
        for (int i = -1; i < index-1; i++){
            iterator = iterator.getNext();
        }
        iterator.setNext(iterator.getNext().getNext());
        this.length = length-1;
        return true;

    }

    private class Node {

        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
