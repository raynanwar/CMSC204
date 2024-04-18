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

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreeNodeTest_STUDENT {
	TreeNode<String> root;
	
	@BeforeEach
	public void setUp() throws Exception {
		root = new TreeNode<>("Rayn");
	}

	@AfterEach
	public void tearDown() throws Exception {
		root = null;
	}
	@Test
	public void testConstructor1() {
		//testing if the constructor sets the root properly
		assertEquals("Rayn", root.data);
		assertEquals(null, root.left);
		assertEquals(null, root.right);
	}
	@Test
	public void testConstructor2() {
		//testing second constructor 
		TreeNode<String> node = new TreeNode<>(root);
		assertEquals(node.data, root.data);
		assertEquals(node.left, root.left);
		assertEquals(node.right, root.right);
	}
	@Test
	public void testGetData() {
		TreeNode<String> node = new TreeNode<>(root);
		assertEquals("Rayn", root.getData());
		assertEquals(root.getData(), node.getData());
	}

}
