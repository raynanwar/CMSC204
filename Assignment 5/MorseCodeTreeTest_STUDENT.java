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
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTreeTest_STUDENT {
	MorseCodeTree tree;
	@BeforeEach
	void setUp() throws Exception {
		tree = new MorseCodeTree();
	}
	@AfterEach
	void tearDown() throws Exception {
		tree = null;
	}
	@Test
	public void testConstructor() {
		//testing if the constructor set the root
		assertEquals("", tree.getRoot().data);
		//testing if the build tree was called
		assertEquals("e", tree.getRoot().left.getData());
		assertEquals("t", tree.getRoot().right.getData());
	}
	@Test
	public void testSetRoot() {
		assertEquals("", tree.getRoot().data);
		TreeNode<String> node = new TreeNode<>("Rayn");
		tree.setRoot(node);
		assertEquals("Rayn", tree.getRoot().data);
	}
	@Test
	public void testGetRoot() {
		assertEquals("", tree.getRoot().data);
		TreeNode<String> node = new TreeNode<>("Rayn");
		tree.setRoot(node);
		assertEquals("Rayn", tree.getRoot().data);
		
	}
	@Test
	public void testInsert() {
		assertEquals(27, tree.toArrayList().size());
		assertEquals("a", tree.getRoot().left.right.data);
		assertEquals("n", tree.getRoot().right.left.data);
	}
	@Test
	public void testAdd() {
		  // Test adding a node to an empty tree
        tree.addNode(tree.getRoot(), ".", "e");
        assertEquals("e", tree.getRoot().left.getData());

        // Test adding a node to an existing tree
        tree.addNode(tree.getRoot(), ".-", "a");
        assertEquals("a", tree.getRoot().left.right.getData());

        // Test adding a node with longer code
        tree.addNode(tree.getRoot(), "--..", "z");
        assertEquals("z", tree.fetch("--.."));
	}
	@Test
    public void testFetch() {
        // Test fetching characters for valid Morse code sequences
        assertEquals("e", tree.fetch("."));
        assertEquals("t", tree.fetch("-"));
        assertEquals("i", tree.fetch(".."));
        assertEquals("a", tree.fetch(".-"));
        assertEquals("n", tree.fetch("-."));
        assertEquals("m", tree.fetch("--"));
        assertEquals("s", tree.fetch("..."));
        assertEquals("u", tree.fetch("..-"));
        assertEquals("r", tree.fetch(".-."));
        assertEquals("w", tree.fetch(".--"));
        assertEquals("d", tree.fetch("-.."));
        assertEquals("k", tree.fetch("-.-"));
        assertEquals("g", tree.fetch("--."));
        assertEquals("o", tree.fetch("---"));
        assertEquals("h", tree.fetch("...."));
        assertEquals("v", tree.fetch("...-"));
        assertEquals("f", tree.fetch("..-."));
        assertEquals("l", tree.fetch(".-.."));
        assertEquals("p", tree.fetch(".--."));
        assertEquals("j", tree.fetch(".---"));
        assertEquals("b", tree.fetch("-..."));
        assertEquals("x", tree.fetch("-..-"));
        assertEquals("c", tree.fetch("-.-."));
        assertEquals("y", tree.fetch("-.--"));
        assertEquals("z", tree.fetch("--.."));
        assertEquals("q", tree.fetch("--.-"));
        try {
        	assertEquals("", tree.fetch(""));
        } catch(Exception e) {
        	assertEquals("String index out of range: 0", e.getMessage());
        }
    }
	@Test
	public void testFetchNode() {
		assertEquals("e", tree.fetchNode(tree.getRoot(), "."));
        assertEquals("t", tree.fetchNode(tree.getRoot(), "-"));
        assertEquals("i", tree.fetchNode(tree.getRoot(), ".."));
        assertEquals("a", tree.fetchNode(tree.getRoot(), ".-"));
        assertEquals("n", tree.fetchNode(tree.getRoot(), "-."));
        assertEquals("m", tree.fetchNode(tree.getRoot(), "--"));
        assertEquals("s", tree.fetchNode(tree.getRoot(), "..."));
        assertEquals("u", tree.fetchNode(tree.getRoot(), "..-"));
        assertEquals("r", tree.fetchNode(tree.getRoot(), ".-."));
        assertEquals("w", tree.fetchNode(tree.getRoot(), ".--"));
        assertEquals("d", tree.fetchNode(tree.getRoot(), "-.."));
        assertEquals("k", tree.fetchNode(tree.getRoot(), "-.-"));
        assertEquals("g", tree.fetchNode(tree.getRoot(), "--."));
        assertEquals("o", tree.fetchNode(tree.getRoot(), "---"));
        assertEquals("h", tree.fetchNode(tree.getRoot(), "...."));
        assertEquals("v", tree.fetchNode(tree.getRoot(), "...-"));
        assertEquals("f", tree.fetchNode(tree.getRoot(), "..-."));
        assertEquals("l", tree.fetchNode(tree.getRoot(), ".-.."));
        assertEquals("p", tree.fetchNode(tree.getRoot(), ".--."));
        assertEquals("j", tree.fetchNode(tree.getRoot(), ".---"));
        assertEquals("b", tree.fetchNode(tree.getRoot(), "-..."));
        assertEquals("x", tree.fetchNode(tree.getRoot(), "-..-"));
        assertEquals("c", tree.fetchNode(tree.getRoot(), "-.-."));
        assertEquals("y", tree.fetchNode(tree.getRoot(), "-.--"));
        assertEquals("z", tree.fetchNode(tree.getRoot(), "--.."));
        assertEquals("q", tree.fetchNode(tree.getRoot(), "--.-"));
     
        try {
        	 assertEquals("", tree.fetchNode(tree.getRoot(), ""));
        } catch(Exception e) {
        	assertEquals("String index out of range: 0", e.getMessage());
        }
	}
	@Test
	public void testDelete() {
		try { 
			tree.delete("this gonna fail");
		} catch(Exception e) {
			assertTrue(true);
		}
	}
	@Test
	public void testUpdate() {
		try {
			tree.update();
		} catch(Exception e) {
			assertTrue(true);
		}
	}
	@Test
	public void testBuildTree() {
		 // Test that the tree is built correctly
        TreeNode<String> root = tree.getRoot();
        assertNotNull(root);
        assertEquals("", root.getData());

        // Check first level nodes
        TreeNode<String> leftChild = root.left;
        assertNotNull(leftChild);
        assertEquals("e", leftChild.getData());

        TreeNode<String> rightChild = root.right;
        assertNotNull(rightChild);
        assertEquals("t", rightChild.getData());

        // Check second level nodes
        TreeNode<String> leftLeftChild = leftChild.left;
        assertNotNull(leftLeftChild);
        assertEquals("i", leftLeftChild.getData());

        TreeNode<String> leftRightChild = leftChild.right;
        assertNotNull(leftRightChild);
        assertEquals("a", leftRightChild.getData());

        TreeNode<String> rightLeftChild = rightChild.left;
        assertNotNull(rightLeftChild);
        assertEquals("n", rightLeftChild.getData());

        TreeNode<String> rightRightChild = rightChild.right;
        assertNotNull(rightRightChild);
        assertEquals("m", rightRightChild.getData());
	}
	@Test
	public void testToArrayList() {
		assertEquals(27, tree.toArrayList().size());
	}
	@Test
	public void testLNROutputTraversal() {
		StringBuilder string = new StringBuilder();
		int i=0;
		for(String element:tree.toArrayList()) {
			string.append(element);
			if(i<tree.toArrayList().size()-1) {
				string.append(", ");
			}
		i++;
		}
		String outPut = "h, s, v, i, f, u, e, l, r, a, p, w, j, , b, d, x, n, c, k, y, t, z, g, q, m, o";
		assertTrue(outPut.equals(string.toString()));
	}
}
