package gb_collections.lists;

import gb_collections.GbList;
import gb_collections.lists.util.ArrayIterator;

import java.util.Iterator;

public class GbLinkedList<E> implements GbList<E> {

    int size = 0;
    private Node<E> firstNode;
    private Node<E> prev;

    @Override
    public void add(E value) {
        Node<E> newNode = new Node<>(value);
        if (firstNode == null) {
            firstNode = newNode;
            prev = firstNode;
        } else {
            prev.next = newNode;
            prev = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, E value) {
        if (index <= size && index >= 0) {
            int i = 0;
            Node<E> newNode = new Node<>(value);
            Node<E> node = firstNode;
            if (index == 0){
                newNode.next = firstNode;
                firstNode = newNode;
                return;
            }
            else {
                while (node != null) {
                    if (i == index - 1) {
                        Node<E> temp = node.next;
                        node.next = newNode;
                        newNode.next = temp;
                        return;
                    }
                    node = node.next;
                    i++;
                }
            }
        }
        throw new RuntimeException("Не правильно задан индекс");

    }

    @Override
    public E get(int index) {
        if (index < size && index >= 0) {
            int i = 0;
            Node<E> node = firstNode;
            while (node != null) {
                if (i == index) {
                    return node.value;
                }
                node = node.next;
                i++;
            }
        }
        return null;
    }

    @Override
    public void remove(E value) {
        Node<E> node = firstNode;
        Node<E> prevNode = firstNode;
        while (node != null) {
            if (firstNode.value == value) {
                firstNode = node.next;
                node.next = null;
                size--;
                return;
            }
            else if (value == node.value) {
                prevNode.next = node.next;
                node.next = null;
                size--;
                return;

            }
            prevNode = node;
            node = node.next;
        }
        throw new RuntimeException("Элемент не был найден");
    }

    @Override
    public void removeByIndex(int index) {
        if (index < size && index >= 0) {
            if (index == 0) {
                firstNode = firstNode.next;
                size--;
                return;
            } else {
                int i = 1;
                Node<E> prevNode = firstNode;
                Node<E> node = firstNode.next;
                while (node != null) {
                    if (index == i) {
                        prevNode.next = node.next;
                        node.next = null;
                        size--;
                        return;
                    }
                    prevNode = node;
                    node = node.next;
                    i++;
                }
            }
        }
        throw new RuntimeException("Не правильно задан индекс");

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(toArray());

    }

    private E[] toArray() {
        E[] newArr = (E[]) new Object[size];
        Node<E> x = firstNode;
        int i = 0;
        while (x != null) {
            newArr[i] = x.value;
            x = x.next;
            i++;
        }
        return newArr;
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value) {
            this.value = value;
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node<E> node = firstNode;
        while (node != null) {
            builder.append(node.value).append(", ");
            node = node.next;
        }
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}
