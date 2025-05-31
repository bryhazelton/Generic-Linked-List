import java.util.Objects;

public class LinkedList<E> {

    private Node<E> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    private class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (index == 0) {
            head = new Node<>(e, head);
        }
        else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = new Node<>(e, current.next);
        }
        size++;
    }
    public void add(E e) {
        add(size, e);
    }

    public boolean contains(Object e) {
        if (size == 0) {
            return false;
        }
        Node<E> current = head;
        while (current != null) {
            if (Objects.equals(e, current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int indexOf(Object e) {
        if (size == 0) {
            return -1;
        }
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(e, current.data)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    public E remove(int index) {
        E removedData = null;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (index == 0) {
            removedData = head.data;
            head = head.next;
            size--;
            return removedData;
        }
        Node<E> current = head;
        for (int i = 0; i < index-1; i++) {
            current = current.next;
        }
        removedData = current.next.data;
        current.next = current.next.next;
        size--;
        return removedData;
    }

    public boolean remove(Object e) {
        if (isEmpty()) {
            return false;
        }
        if (indexOf(e) == -1) {
            return false;
        }
        remove(indexOf(e));;
        return true;
    }

    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E oldData = current.data;
        current.data = e;
        return oldData;
    }

    public String toString(){
        if (isEmpty()) {
            return "[]";
        }
        if (head.next == null) {
            return ("[" + head.data + "]");
        }
        Node<E> current = head;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        LinkedList <?> other = (LinkedList <?>) obj;
        if (size != other.size) {
            return false;
        }
        if (head == null) {
            return other.head == null;
        }
        Node<E> current = head;
        LinkedList<?>.Node<?> otherCurrent = other.head;
        while (current != null) {
            if (current.data != otherCurrent.data) {
                return false;
            }
            current = current.next;
            otherCurrent = otherCurrent.next;
        }
        return true;

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(7);
        list.add(8);
        LinkedList list2 = new LinkedList();
        list2.add(5);
        list2.add(7);
        list2.add(8);
        System.out.println(list);
        System.out.println(list2);
        System.out.println(list.equals(list2));
    }
}
