/*
 
Class: CMSC204
Instructor: Eivzi
Description: Infix to postifx 
Due: 2/25
Platform/compiler: Eclipse
I pledge that I have completed the programming
assignment independently. I have not copied the code
from a student or any source. I have not given my code
to any student.
Print your Name here:= Rayn Anwar
*/
import java.util.ArrayList;
public class MyQueue<T> implements QueueInterface<T> {
    private ArrayList<T> queueList;
    private int size;
    private static final int DEFAULTSIZE = 10;
    private int numberOfElements;

    
    public MyQueue() {
        this(DEFAULTSIZE);
        
    }
    public MyQueue(int size) {
        ArrayList<T> tempArrayList = new ArrayList<>(size);
        queueList = tempArrayList;
        this.size = size;
    }

    public boolean isEmpty() {
        return numberOfElements==0;
    }

    public boolean isFull() {
        return numberOfElements==size;
    }

    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        numberOfElements--;
        return queueList.remove(0);
    }

    public int size() {
        return this.numberOfElements;
    }

    public boolean enqueue(T e) throws QueueOverflowException {
        if(isFull()) {
            throw new QueueOverflowException();
        } 
        this.queueList.add(e);
        numberOfElements++;
        return true;
    }
    public String toString() {
        StringBuilder string = new StringBuilder();
        for(int i =0; i<queueList.size(); i++) {
            string.append(queueList.get(i));
            if(i<queueList.size()-1) {
                string.append(", ");
            }
        }
        return string.toString();
    }
    public String toString(String delimiter) {
        StringBuilder string = new StringBuilder();
        for(int i =0; i<queueList.size(); i++) {
            string.append(queueList.get(i));
            if(i<queueList.size()-1) {
                string.append(delimiter);
            }
        }
        return string.toString();
    }
     @SuppressWarnings("unchecked")
   public void fill(ArrayList <T> list) throws QueueOverflowException {
   ArrayList<T> deepCopy = new ArrayList<>();
    int i =0;
        for(T element : list) {
            try {
                deepCopy.add((T)element.getClass().getConstructor(element.getClass()).newInstance(element));
            } catch(Exception e) {
                System.out.println("its over");
            }
           
         enqueue(deepCopy.get(i));
         i++;
        }
        

        
   }

}



