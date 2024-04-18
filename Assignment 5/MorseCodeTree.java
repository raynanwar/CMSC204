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
import java.io.UncheckedIOException;
import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
    private TreeNode<String> root;

    public MorseCodeTree() {
        root = new TreeNode<>("");
        buildTree();
    }

    public void setRoot(TreeNode<String> newNode) {
        root = new TreeNode<>(newNode);
    }
    
    public TreeNode<String> getRoot() {
       return root;
    }
    
    public void insert(String code, String letter) {
        addNode(root, code, letter);
    } 
    
    public void addNode(TreeNode<String> root, String code, String letter) {
        // Base case: if there is only one character
    
        if (code.length() == 1) {
            if (code.charAt(0) == '.') {
                if(root.left ==null) {
                    root.left = new TreeNode<>(letter);
                    return;
                }
                
            }
            if (code.charAt(0) == '-') {
                if(root.right == null) {
                    root.right = new TreeNode<>(letter);
                    return;
                }
            }
        } else {
            String tempCode = code.substring(1);
            if (code.charAt(0) == '.') {
                if(root.left ==null) {
                    root.left = new TreeNode<>("");
                }
                addNode(root.left, tempCode, letter);
            } 
            if (code.charAt(0) == '-') {
                if(root.right == null) {
                    root.right = new TreeNode<>("");
                }
                addNode(root.right, tempCode, letter);
            }
        }
    }
  
    public String fetch(String code) {
        String [] tokens = code.split(" ");
        StringBuilder string = new StringBuilder();
        
        for(String element:tokens) {
            string.append(fetchNode(root, element));
        }
        return string.toString();
    }

    public String fetchNode(TreeNode<String> root, String code) {
        //traverse the tree based on the code
        if(code.length()==1) {
            if(code.charAt(0)=='.') {
                return root.left.data;
            }
            else if(code.charAt(0)=='-') {
                return root.right.data;
            } else {
                return " ";
            }

        }
        else {
           char direction = code.charAt(0);
           if(direction == '.') {
            return fetchNode(root.left, code.substring(1));
           }
            if(direction == '-') {
            return fetchNode(root.right, code.substring(1));
            } 
           if(direction == ' ') {
            return " ";
           }
        }
        return " ";
    }
    public MorseCodeTree delete(String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public MorseCodeTree update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public void buildTree() {
        //first level
        insert(".", "e");
        insert("-", "t");

        //second level
        insert("..",  "i");
        insert(".-", "a");
        insert("-.", "n");
        insert("--", "m");
        
        //third level
        insert("...", "s");
        insert("..-", "u");
        insert(".-.", "r");
        insert(".--", "w");
        insert("-..", "d");
        insert("-.-", "k");
        insert("--.", "g");
        insert("---", "o");
        
        //fourth level
        insert("....", "h");
        insert("...-", "v");
        insert("..-.", "f");
        insert(".-..", "l");
        insert(".--.", "p");
        insert(".---", "j");
        insert("-...", "b");
        insert("-..-", "x");
        insert("-.-.", "c");
        insert("-.--", "y");
        insert("--..", "z");
        insert("--.-", "q");
    }

    public ArrayList<String> toArrayList() {
        ArrayList<String> list = new ArrayList<>();
        LNRoutputTraversal(root, list);
        return list;
    }

    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if(root != null) {
            LNRoutputTraversal(root.left, list);
            list.add(root.data);
            LNRoutputTraversal(root.right ,list);
        }
    }

    

    
}