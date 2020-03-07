package eg.edu.alexu.csd.datastructure.linkedList.Classes;

import eg.edu.alexu.csd.datastructure.linkedList.Interfaces.ILinkedList;

public class SLinkedList implements ILinkedList {

    private Node start;
    private Node end;
    private int size = 0;

    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }

    public SLinkedList() {
        start = new Node();
        start.prev = null;
        start.content = null;
        end = start;
    }

    private class Node {
        private Node prev;
        private Object content;
        private Node next;

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public void add(Object element) {
        end.next = new Node();
        end = end.next;
        size++;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public void set(int index, Object element) {

    }

    @Override
    public void clear() {
        start = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ILinkedList sublist(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }
}
