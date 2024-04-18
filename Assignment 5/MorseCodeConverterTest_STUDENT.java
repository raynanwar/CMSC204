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
 import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeConverterTest_STUDENT {
	
	@BeforeEach
	void setUp() throws Exception {
		 
	}

	@AfterEach
	void tearDown() throws Exception {

	}

	@Test
	void testPrintTree() {
		 MorseCodeTree tree = new MorseCodeTree();
		    ArrayList<String> array = tree.toArrayList();

		    StringBuilder stringBuilder = new StringBuilder();
		    for (String item : array) {
		        stringBuilder.append(item).append(" ");
		    }
		    String arrayListString = stringBuilder.toString().trim(); // Remove trailing space

		    String printTreeString = MorseCodeConverter.printTree();

		    assertEquals(arrayListString, printTreeString);
	}
	@Test
    public void testConvertToEnglish() {
        // Test converting Morse code to English
        assertEquals("hello", MorseCodeConverter.convertToEnglish(".... . .-.. .-.. ---"));
        assertEquals("world", MorseCodeConverter.convertToEnglish(".-- --- .-. .-.. -.."));

        // Test converting Morse code with slash separator to English
        assertEquals("hello world", MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.."));

}
	@Test
	public void testConvertToEnglishFile() {
		File file = new File("Student.txt");
		
		try {
			String output = MorseCodeConverter.convertToEnglish(file);
			assertTrue(output.equals("i love this class"));
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		
	}
}
