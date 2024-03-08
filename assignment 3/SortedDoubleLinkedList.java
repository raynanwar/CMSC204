/*
 
Class: CMSC204
Instructor: Eivzi
Description: Infix to postifx 
Due: 3/10
Platform/compiler: Eclipse
I pledge that I have completed the programming
assignment independently. I have not copied the code
from a student or any source. I have not given my code
to any student.
Print your Name here:= Rayn Anwar
*/
import java.util.*;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
    protected Comparator<T> comparator; 
    public SortedDoubleLinkedList(Comparator<T> comparableObject) {
        comparator = comparableObject; 
    }

    
    public void add(T data) {
        Node newNode = new Node(data);
        Node currentNode = head;
        
        if (size == 0) {
            head = newNode;
        } else {
            while (currentNode != null) {
                if (comparator.compare(currentNode.data, newNode.data) < 0) {
                    if (currentNode.next == null) {
                        currentNode.next = newNode;
                        newNode.prev = currentNode;
                        tail = newNode;
                        break;
                    } else {
                        currentNode = currentNode.next;
                    }
                } else {
                    if (currentNode.prev == null) {
                        newNode.next = currentNode;
                        currentNode.prev = newNode;
                        head = newNode;
                    } else {
                        newNode.prev = currentNode.prev;
                        newNode.next = currentNode;
                        currentNode.prev.next = newNode;
                        currentNode.prev = newNode;
                    }
                    break;
                }
            }
        }
        size++;
    }
    

    public void addToFront(T data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }
    public void addToEnd(T data) throws UnsupportedOperationException {{
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }}
    @Override
    public ListIterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }
    @Override
    public Node remove(T data, Comparator<T> comparator) {
        Node removedNode = super.remove(data, comparator);
        return removedNode;
    }
}