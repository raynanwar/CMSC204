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
public class BasicDoubleLinkedList<T> implements Iterable<T> {
    protected Node head;
    protected Node tail;
    protected int size;
    
    public BasicDoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }   
    public int getSize() {
        return size; 
    }
    
    public void addToEnd(T data) {
        Node node = new Node(data);
        if(head == null) {
            head = node;
            tail=node;
        } else {
            tail.next = node;
             node.prev= tail;
             tail = node;
        }
        
        size++;
    }
  
    public void addToFront(T data) {
        Node node = new Node(data);
        if(head == null) {
            head  = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
           
        }
        size++;
        
    }
    public T getFirst() {
        if(head== null) {
            return null;
        }
        return head.data; 
    }
    public T getLast() {
        if(tail ==null) {
            return null;
        }
        return tail.data;
    }
    
    public Node remove(T targetData, Comparator<T> comparator) {
        if (head == null) {
            return null;
        }
        
        Node currentNode = head;
        Node removedNode = null;
        
        while (currentNode != null) {
            if (comparator.compare(currentNode.data, targetData) == 0) {
                removedNode = currentNode;
                
                if (currentNode.prev != null) {
                    currentNode.prev.next = currentNode.next;
                } else {
                    head = currentNode.next; 
                }
                
                if (currentNode.next != null) {
                    currentNode.next.prev = currentNode.prev;
                }
                
                break;
            }
            
            currentNode = currentNode.next;
        }
        size--;
        return removedNode;
    }
    
    

    public T retrieveFirstElement() {
        if(getSize()==0 || head ==null) {
        return null;
    }
         T temp = head.data;
         head = head.next;
        size--;
    return temp;
    } 
    public T retrieveLastElement() {
        if(getSize()==0 || tail == null) {
            return null;
        }
       if (size ==1) {
        T temp = head.data; 
        head = null;
        size--;
        return temp;
       }
            T temp = tail.data;
             tail = tail.prev;
        
           
            size--;
        return temp;
    }
   
    public ArrayList<T> toArrayList() {
       ArrayList<T> list = new ArrayList<>();
       Node currentNode= null;
       if(head != null) {
        currentNode =  head; 
       }
       while(currentNode != null) {
        list.add(currentNode.data);
        currentNode = currentNode.next; 
       }
       return list;
    }
    public class DoubleLinkedListIterator implements ListIterator<T> {
        Node pointer;
        public DoubleLinkedListIterator() {
            pointer = head; 
        }
        public boolean hasNext() {
            if(pointer.next != null) {
                return true;
            }
            return false;
        }
        public T next() throws NoSuchElementException {
            if(pointer.next != null) {
                pointer = pointer.next;
                return pointer.data;
            } 
            throw new NoSuchElementException();
        }
        public boolean hasPrevious()  {
            if(pointer.prev != null && pointer != null) {
                return true;
            } 
            return false;
        }
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
        public void add(T arg0) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
        public int nextIndex() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
        public int previousIndex() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
        public void set(T arg0) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
        @Override
        public T previous() throws NoSuchElementException{
            if(pointer.prev != null) {
                pointer = pointer.prev; 
                return pointer.data;
            }
           throw new NoSuchElementException();
        }
        
    }
    public class Node {
            T data;
            Node prev;
            Node next; 
            public Node(T dataNode ) {
                this.data = dataNode;
            }
    }
    @Override
    public ListIterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }
}
