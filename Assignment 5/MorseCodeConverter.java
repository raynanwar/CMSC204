/*
 
Class: CMSC204
Instructor: Eivzi
Description:MorseCode
Due: 4/18
Platform/compiler: Eclipse
I pledge that I have completed the programming
assignment independently. I have not copied the code
from a student or any source. I have not given my code
to any student.
Print your Name here:= Rayn Anwar
*/
import java.io.*;
import java.util.*;
public class MorseCodeConverter { 
	private static MorseCodeTree tree = new MorseCodeTree();
    public static String printTree() {
        ArrayList<String> array = new ArrayList<>();
        StringBuilder string = new StringBuilder();

        array = tree.toArrayList();
        int i=0;
        for(String item: array) {
            string.append(item);
            if(i<array.size()-1) {
                string.append(" ");
            }
            i++;
        }
        return string.toString();
        
    }
    public static String convertToEnglish(String code) {
        String[] tokens = code.split("\\s*/\\s*");
        StringBuilder string = new StringBuilder();
        for (String item : tokens) {
            String letter = tree.fetch(item);
            if (!letter.equals(" ")) { 
                string.append(letter).append(" ");
            } else {
                string.append(" ");
            }
        }
        return string.toString().trim();
    }
    

    public static String convertToEnglish(File codeFile) throws FileNotFoundException {
        if(!codeFile.exists()) {
            throw new FileNotFoundException();
        }
        Scanner scanner=  new Scanner(codeFile);
        StringBuilder string = new StringBuilder();
        String line = "";
        while(scanner.hasNext()) {
            line = scanner.nextLine();
          string.append(convertToEnglish(line));
        }
        scanner.close();
        return string.toString();
    }
    
}
