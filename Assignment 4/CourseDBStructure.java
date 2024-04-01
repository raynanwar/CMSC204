/*
 
Class: CMSC204
Instructor: Eivzi
Description: COURSEelement
Due: 4/1
Platform/compiler: Eclipse
I pledge that I have completed the programming
assignment independently. I have not copied the code
from a student or any source. I have not given my code
to any student.
Print your Name here:= Rayn Anwar
*/
import java.io.IOException;
import java.util.*;
public class CourseDBStructure implements CourseDBStructureInterface {
    String numElements;
    int sizeOfHashTable;
    
    LinkedList<CourseDBElement>[] hashTable;
    @SuppressWarnings("unchecked")
    public CourseDBStructure(int num) {
    	num = (int)(num/1.5);
        int size = get4KPrime(num);
        hashTable = (LinkedList<CourseDBElement>[]) new LinkedList[size];
        this.sizeOfHashTable = size;
        
    }
    @SuppressWarnings("unchecked")
    public CourseDBStructure(String numElements, int size) {
    	hashTable = (LinkedList<CourseDBElement>[]) new LinkedList[size];
    	this.sizeOfHashTable = size;
    	this.numElements = numElements; 
      
    }  
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num < 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    public static int get4KPrime(int start) {
    	if(start<3) {
    		return 3;
    	}
        for(int i=0; i<start*2; i++) {
            int temp = (4*i)+3;
            if(temp<=start) {
                continue;
            }
            if(isPrime(temp)) {
                return temp;
            }
            
        }
       return 0;
    }
    public void add (CourseDBElement element) {
         int val= element.hashCode() % sizeOfHashTable;
         if(hashTable[val]==null) {
           hashTable[val] = new LinkedList<CourseDBElement>(); 
         }

            LinkedList<CourseDBElement> bucket = hashTable[val];
            for(int i=0; i<bucket.size(); i++) {
            	if(bucket.get(i).getCRN()==element.getCRN()) {
            		bucket.set(i, element);
            		return;
            	}
            }
            bucket.add(element);
            
    }
    public ArrayList<String> showAll() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (LinkedList<CourseDBElement> bucket : hashTable) {
            if (bucket != null) {
                for (CourseDBElement dbElement : bucket) {
                    arrayList.add(dbElement.toString() + "\n");
                }
            }
        }
        return arrayList;
    }
    public CourseDBElement get(int crn) throws IOException {
    	String temp = Integer.toString(crn);
    	int key = temp.hashCode()%sizeOfHashTable;
        if(hashTable[key]==null) {
        	throw new IOException();
        }
        LinkedList<CourseDBElement> bucket = hashTable[key];
        
            for(int i =0; i<bucket.size(); i++) {
                if(bucket.get(i).getCRN()==crn) {
                    return bucket.get(i);
                }
            }
        throw new IOException();
    }
    public int getTableSize() {
        return hashTable.length;
    }
}
